package com.qiyu.paymanager.service;

import com.qiyu.common.result.ModelResult;
import com.qiyu.paymanager.context.SpringContextHolder;
import com.qiyu.pay.domain.request.RequestPayReq;
import com.qiyu.pay.domain.result.RequestPayRlt;
import com.qiyu.pay.service.IPayService;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2016/10/28.
 */
@Component
public class AliUploadImageCallable implements Callable {

    private String imageUrl;
    private Long merchantId;
    public AliUploadImageCallable(){}
    public AliUploadImageCallable(String imageUrl,Long merchantId) {
        this.imageUrl = imageUrl;
        this.merchantId = merchantId;
    }
    @Override
    public Object  call() throws Exception {
        IPayService alipayupload = SpringContextHolder.getBean("alipayupload");
        if (null != imageUrl && !"".equals(imageUrl)){
            RequestPayReq requestPayReq = new RequestPayReq();
            requestPayReq.setPayChannel("ali");
            requestPayReq.setPayType("upload");
            requestPayReq.setImageUrl(imageUrl);
            requestPayReq.setMerchantId(merchantId);
            ModelResult<RequestPayRlt> modelResult =  alipayupload.requestPay(requestPayReq);
            if (modelResult.getCode() == 0){
              RequestPayRlt requestPayRlt = modelResult.getData();
                synchronized (requestPayRlt){
                    return  requestPayRlt.getReturnStr();
                }
            }
        }
        return null;
    }
}
