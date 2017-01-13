package com.qiyu.paymanager.service;

import com.qiyu.bankpay.domain.constant.Constant;
import com.qiyu.bankpay.domain.request.cmbc.CMBCMerchantSignReq;
import com.qiyu.bankpay.domain.result.cmbc.CMBCMerchantSignRlt;
import com.qiyu.bankpay.service.CMBCPayService;
import com.qiyu.common.result.ModelResult;
import com.qiyu.data.BeanMapper;
import com.qiyu.data.Msg;
import com.qiyu.data.dao.PayInformationDao;
import com.qiyu.data.entity.PayConfig;
import com.qiyu.data.entity.PayInformation;
import com.qiyu.data.entity.ResultRecordSheet;
import com.qiyu.data.repository.PayConfigRepo;
import com.qiyu.data.repository.PayInformationRepo;
import com.qiyu.data.repository.ResultRecordSheetRepo;
import com.qiyu.data.vo.PayInformationVo;
import com.qiyu.pay.domain.request.RequestPayReq;
import com.qiyu.pay.domain.result.RequestPayRlt;
import com.qiyu.pay.service.IPayService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class PayInformationService {
    private static org.slf4j.Logger logger= LoggerFactory.getLogger(PayInformationService.class);
    @Autowired
    private PayInformationDao payInformationDao;
    @Autowired
    private PayInformationRepo payInformationRepo;
    @Autowired
    private ResultRecordSheetRepo resultRecordSheetRepo;
    @Autowired
    private IPayService alipaysign;
    @Autowired
    private CMBCPayService cmbcPayService;

    @Autowired
    private IPayService alipayupload;

    @Autowired
    private PayConfigRepo payConfigRepo;
    /**
     * 判断当前记录是否存在
     * @param vo
     * @return
     */
    public PayInformation getPayInformation(PayInformationVo vo){
        return payInformationDao.getPayInformation(vo.getRestaurantId(),vo.getRestaurantSignType(),vo.getPaymentChannel());
    }


    /**
     * 支付宝ISV申请
     * @param payInformation
     * @return
     */
    @Transactional
    public Msg updateInformationForISV(PayInformationVo payInformation){
        String enterpriseLogoId = uploadAliImage(payInformation.getEnterpriseLogo(),payInformation.getRestaurantId());
        String businessLicenseId =  uploadAliImage(payInformation.getBusinessLicense(),payInformation.getRestaurantId());
        String operateIdcardPositiveId =  uploadAliImage(payInformation.getOperateIdcardPositive(),payInformation.getRestaurantId());
        String operateIdcardReverseId =  uploadAliImage(payInformation.getOperateIdcardReverse(),payInformation.getRestaurantId());
        String authLetterId =  uploadAliImage(payInformation.getAuthLetter(),payInformation.getRestaurantId());
        String operateConditionsId =  uploadAliImage(payInformation.getOperateConditions(),payInformation.getRestaurantId());
        String storeImageId =  uploadAliImage(payInformation.getStoreImage(),payInformation.getRestaurantId());
        String storeImageInnerId =  uploadAliImage(payInformation.getStoreImageInner(),payInformation.getRestaurantId());
        String orgCodeCertificatePicId =  uploadAliImage(payInformation.getOrgCodeCertificatePic(),payInformation.getRestaurantId());
        String storeImageSecInnerId = uploadAliImage(payInformation.getStoreImageSecInner(),payInformation.getRestaurantId());
        String storeImageThreeInnerId = uploadAliImage(payInformation.getStoreImageThreeInner(),payInformation.getRestaurantId());
        payInformation.setEnterpriseLogoId(enterpriseLogoId);
        payInformation.setBusinessLicenseId(businessLicenseId);
        payInformation.setOperateConditionsId(operateConditionsId);
        payInformation.setOperateIdcardPositiveId(operateIdcardPositiveId);
        payInformation.setOperateIdcardReverseId(operateIdcardReverseId);
        payInformation.setAuthLetterId(authLetterId);
        payInformation.setStoreImageId(storeImageId);
        payInformation.setStoreImageInnerId(storeImageInnerId);
        payInformation.setOrgCodeCertificatePicId(orgCodeCertificatePicId);
        payInformation.setStoreImageSecInnerId(storeImageSecInnerId);
        payInformation.setStoreImageThreeInnerId(storeImageThreeInnerId);
        //当经营期限为长期时
        if(payInformation.getLongDate()==1){
            payInformation.setTimeLimit("9999-12-31");
        }
        PayInformation payInformations = BeanMapper.getMapperFacade().map(payInformation, PayInformation.class);
        payInformations.setCreateAt(new Date());
        payInformations.setUpdateAt(new Date());
        //添加记录
        payInformationRepo.save(payInformations);
        RequestPayReq requestPayReq  = new RequestPayReq();
        requestPayReq.setPayChannel("ali");
        requestPayReq.setPayType("sign");
        requestPayReq.setMerchantId(payInformation.getRestaurantId());
        ModelResult<RequestPayRlt> modelResult = alipaysign.requestPay(requestPayReq);
        if (modelResult.isSuccess()){
            String orderNo =  modelResult.getData().getReturnStr();
            return Msg.createSucMsg();
        }else{
            return Msg.createFailMsg("商家签约失败,"+ modelResult.getMsg());
        }
    }


    private String  uploadAliImage(String  imageUrl,Long restaurantId){
        RequestPayReq  requestPayReq = new RequestPayReq();
        requestPayReq.setPayChannel("ali");
        requestPayReq.setPayType("upload");
        requestPayReq.setImageUrl(imageUrl);
        requestPayReq.setMerchantId(restaurantId);
        ModelResult<RequestPayRlt> modelResult =  alipayupload.requestPay(requestPayReq);
        if (modelResult.getCode() == 0){
            String uploadAliImageId =  modelResult.getData().getReturnStr();
            return uploadAliImageId;
        }
        return null;
    }

    /**
     * 民生银行
     * @param payInformation
     * @return
     */
    @Transactional
    public Msg updateInformationForCMBC(PayInformationVo payInformation) {
        PayInformation payInformations = BeanMapper.getMapperFacade().map(payInformation, PayInformation.class);
        payInformations.setCreateAt(new Date());
        payInformations.setUpdateAt(new Date());
        //添加记录
        payInformationRepo.save(payInformations);
        String msg = "";
        //业务处理
        try {
            if (null != payInformation.getAliCategory() && !payInformation.getAliCategory().equals("")){
                msg = wrapMerchantSign(payInformations,"ZFBZF","ali","101")+",";
            }
            if(null != payInformation.getWechatCategory() && !payInformation.getWechatCategory().equals("")){
                msg = msg + wrapMerchantSign(payInformations,"WXZF","weixin","201");
            }
            logger.info("支付申请添加记录：msg={}",msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createSucMsg(msg);
    }

    /**
     * 快付通
     * @param payInformation
     * @return
     */
    @Transactional
    public Msg updateInformationForKFT(PayInformationVo payInformation) {
        PayInformation payInformations = BeanMapper.getMapperFacade().map(payInformation, PayInformation.class);
        payInformations.setCreateAt(new Date());
        payInformations.setUpdateAt(new Date());
        payInformationRepo.save(payInformations);

        return Msg.createSucMsg();
    }

    /**
     *  民生银行
     * @param payInformation
     * @param payWay 支付通道
     * @return
     */
    private String wrapMerchantSign(PayInformation payInformation, String payWay, String platform,String paymentChannel){
        String msg = "";
        CMBCMerchantSignReq cmbcMerchantSignReq = new CMBCMerchantSignReq();
        cmbcMerchantSignReq.setTranCode(Constant.TRAN_CODE_SMZF_001);
        cmbcMerchantSignReq.setPayWay(payWay);
        cmbcMerchantSignReq.setMerchantId(String.valueOf(payInformation.getRestaurantId()));
        cmbcMerchantSignReq.setMerchantName(payInformation.getMerchantName());
        if(platform.equals("ali")){
            msg = "支付宝";
            cmbcMerchantSignReq.setCategory(payInformation.getAliCategory());
        }else{
            msg = "微信";
            cmbcMerchantSignReq.setCategory(payInformation.getWechatCategory());
        }
        cmbcMerchantSignReq.setMerchantAddress(payInformation.getMerchantAddress());
        cmbcMerchantSignReq.setShortName(payInformation.getMerchantSimpleName());
        cmbcMerchantSignReq.setServicePhone(payInformation.getMerchantPhone());
        cmbcMerchantSignReq.setAccNo(payInformation.getBankCardNo());
        cmbcMerchantSignReq.setAccName(payInformation.getBankAccountName());
        cmbcMerchantSignReq.setBankType(payInformation.getBankCardNumbe());
        cmbcMerchantSignReq.setBankName(payInformation.getBusinessBankSub());
        cmbcMerchantSignReq.setChannelMerchantCode(String.valueOf(payInformation.getRestaurantId()));
        cmbcMerchantSignReq.setT0drawFee(String.valueOf(payInformation.getTzHandlingFee()));
        cmbcMerchantSignReq.setT0tradeRate(String.valueOf(payInformation.getTzFeeRate()));
        cmbcMerchantSignReq.setT1drawFee(String.valueOf(payInformation.getToHandlingFee()));
        cmbcMerchantSignReq.setT1tradeRate(String.valueOf(payInformation.getToFeeRate()));
        try {
          ModelResult modelResult = cmbcPayService.merchantSign(cmbcMerchantSignReq);
            if (null != modelResult && null != modelResult.getData()){
                CMBCMerchantSignRlt merchantSignRlt = (CMBCMerchantSignRlt) modelResult.getData();
                logger.info("支付申请结果：CMBCMerchantSignRlt={}",merchantSignRlt);
                //申请后记录结果
                ResultRecordSheet resultRecordSheet = new ResultRecordSheet();
                resultRecordSheet.setCreateAt(new Date());
                resultRecordSheet.setRestaurantId(payInformation.getRestaurantId());
                String materialCategory = "民生银行";
                if(payInformation.getRestaurantSignType()==0){
                    materialCategory = materialCategory +"个体工商户";
                }else if(payInformation.getRestaurantSignType()==1){
                    materialCategory = materialCategory +"企业";
                }else if(payInformation.getRestaurantSignType()==2){
                    materialCategory = materialCategory +"个人";
                }
                resultRecordSheet.setMaterialCategory(materialCategory);
                resultRecordSheet.setMaterialType("进件");

                if (merchantSignRlt.getRespCode().equals("000000") && merchantSignRlt.getRespType().equals("S")){
                    //1.1新增记录申请结果，并记录
                    resultRecordSheet.setResultRemark(merchantSignRlt.getMerchantCode());
                    resultRecordSheet.setResultStatus("1");
                    resultRecordSheetRepo.save(resultRecordSheet);
                    return msg+"申请成功";
                }else{
                    resultRecordSheet.setResultRemark(merchantSignRlt.getRespMsg());
                    resultRecordSheet.setResultStatus("-1");
                    resultRecordSheetRepo.save(resultRecordSheet);
                    return msg+"申请失败";
                }
            }
               /* if (merchantSignRlt.getRespCode().equals("000000") && merchantSignRlt.getRespType().equals("S")){
                    PayConfig payConfig = new PayConfig();
                    payConfig.setCreateAt(new Date());
                    payConfig.setRestaurantId(payInformation.getRestaurantId());
                    payConfig.setPlatform(platform);
                    payConfig.setPaymentChannel(paymentChannel);
                    payConfig.setChannelMerchantId(merchantSignRlt.getMerchantCode());
                    payConfigRepo.save(payConfig);
                    return msg+"申请成功";
                }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg+"申请失败";
    }
}