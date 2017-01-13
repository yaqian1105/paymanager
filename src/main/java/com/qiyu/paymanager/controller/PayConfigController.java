package com.qiyu.paymanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiyu.common.result.ModelResult;
import com.qiyu.data.Msg;
import com.qiyu.data.entity.*;
import com.qiyu.data.repository.MerchantRepo;
import com.qiyu.data.repository.RestaurantRepository;
import com.qiyu.data.vo.*;
import com.qiyu.paymanager.service.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Controller
@RequestMapping("/payConfig")
public class PayConfigController {

    @Autowired
    private PayConfigService payConfigService;
    @Autowired
    private PayInformationService payInformationService;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private AgentService agentService;
    @Autowired
    private MerchantRepo merchantRepo;

   /** ---------------------------------------------- 支付配置 ---------------------------------------------  */
    @RequestMapping(value = "/paylist")
    public String payConfigInformationPage(Model model,@RequestParam(defaultValue = "") Long merchantId, @RequestParam(defaultValue = "") Long restaurantId){
        Agent agent = agentService.findAgentByRestaurantId(restaurantId);
        Restaurant restaurant = restaurantRepository.findOne(restaurantId);
        model.addAttribute("agent",agent);
        model.addAttribute("restaurant",restaurant);
        model.addAttribute("merchantId",merchantId);
        return "payconfig/payConfig_index";
    }

    /**
     * 获取所有通道信息
     * @param platform
     * @return
     */
    @RequestMapping(value = "/getChannelInformation")
    @ResponseBody
    public ModelResult getChannelInformation(@RequestParam(defaultValue = "weixin") String platform) {
        ModelResult result = new ModelResult();
        try {
            List<PayConfigInformationVo> list =payConfigService.getChannelInformation(platform);
            result.isSuccess();
            result.setData(list);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取通道信息
     * @param restaurantId
     * @param platform
     * @param paymentChannel
     * @return
     */
    @RequestMapping(value = "/getPayConfig")
    @ResponseBody
    public ModelResult getPaycConfig(@RequestParam(defaultValue = "")Long restaurantId, @RequestParam(defaultValue = "") String platform, @RequestParam(defaultValue = "")  String paymentChannel) {
        ModelResult result = new ModelResult();
        if(restaurantId==null){
            result.setMsg("请输入门店信息");
            return result;
        }
        if(StringUtils.isBlank(platform)){
            result.setMsg("请输入支付方式");
            return result;
        }
        if(!NumberUtils.isNumber(paymentChannel)){
            result.setMsg("请选择通道方式");
            return result;
        }
        try {
            PayConfig payConfig = payConfigService.getPayConfig(restaurantId,platform,paymentChannel);
            result.isSuccess();
            result.setData(payConfig);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 更新信息或添加记录
     */
    @RequestMapping("/updatePayConfig")
    @ResponseBody
    public Msg updatePayConfig(PayConfigVo vo) {
        try {
            return payConfigService.updatePayConfig(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createFailMsg("保存失败！");
    }

    /**   ------------------------------------------    设置  ---------------------------------------   */
    @RequestMapping(value = "/setConfigPage")
    public String setConfigPage(Model model,@RequestParam(defaultValue = "") Long merchantId, @RequestParam(defaultValue = "") Long restaurantId){
        Agent agent = agentService.findAgentByRestaurantId(restaurantId);
        Restaurant restaurant = restaurantRepository.findOne(restaurantId);
        model.addAttribute("agent",agent);
        model.addAttribute("restaurant",restaurant);
        model.addAttribute("merchantId",merchantId);
        return "payconfig/setConfig_index";
    }
    /**
     * 获取已配置的支付配置
     * @param restaurantId
     * @return
     */
    @RequestMapping(value = "/getChannel")
    @ResponseBody
    public Map getChannel( @RequestParam(defaultValue = "") Long restaurantId,@RequestParam(defaultValue = "1") int curPage,@RequestParam(defaultValue = "15") int pageSize) {
        Map<String,Object> result=new HashMap<>();
        try {
            List<List<SetConfigVo>> getChannels =  payConfigService.getChannels(restaurantId,curPage,pageSize);
            result.put("data",getChannels);
            result.put("success",true);
            result.put("curPage",curPage);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 更新信息或添加记录
     */
    @RequestMapping("/updateRate")
    @ResponseBody
    public Msg updateRate(PayConfigVo vo) {
        try {
            return payConfigService.updateChannel(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createFailMsg("保存失败！");
    }
    /**   ------------------------------------------   支付申请  ---------------------------------------   */
    @RequestMapping(value = "/payApplyPage")
    public String payApplyPage(Model model,@RequestParam(defaultValue = "") Long merchantId, @RequestParam(defaultValue = "") Long restaurantId){
        Agent agent = agentService.findAgentByRestaurantId(restaurantId);
        Restaurant restaurant = restaurantRepository.findOne(restaurantId);
        model.addAttribute("agent",agent);
        model.addAttribute("restaurant",restaurant);
        model.addAttribute("merchantId",merchantId);
        return "payconfig/payApply_index";
    }

    @RequestMapping(value = "/payApply")
    public String payApply(Model model, PayInformationVo vo,@RequestParam(defaultValue = "") Long merchantId ){
        PayInformation payInformation = payInformationService.getPayInformation(vo);
        if(payInformation == null){
            Merchant merchant = merchantRepo.findOne(merchantId);
            vo.setMerchantName(merchant.getName());
            vo.setMerchantSimpleName(merchant.getSimpleName());
            vo.setMerchantAddress(merchant.getAddress()+merchant.getDetailAddress());
            vo.setMerchantPhone(merchant.getPhone());
            model.addAttribute("payInformation",vo);
        }else{
            model.addAttribute("payInformation",payInformation);
        }
        model.addAttribute("merchantId",merchantId);
        if(vo.getPaymentChannel().equals("101")){
            return "payconfig/payApply_CMBC";
        }else if(vo.getPaymentChannel().equals("104")){
            return "payconfig/payApply_KFT";
        }else if(vo.getPaymentChannel().equals("11")){
            if(vo.getRestaurantSignType()==0) {
                return "payconfig/payApply_Person";
            }else if(vo.getRestaurantSignType()==1) {
                return "payconfig/payApply_Company";
            }
        }
        return "payconfig/payApply_index";
    }
    @RequestMapping(value = "/payApplyUpdate")
    @ResponseBody
    public Msg payApplyUpdate(HttpServletRequest request){
        PayInformationVo vo = null;
        Map<String, Object>  paramMap = new HashedMap();
        paramMap = getString(paramMap,request);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("properties/file");
        String imagePath = resourceBundle.getString("imagePath");
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            String merchantId = request.getParameter("restaurantId");
            Map<String, MultipartFile> map = multipartRequest.getFileMap();
            File baseFile = new File(imagePath);
            if (!baseFile.exists()) {
                baseFile.mkdir();
            }
            File dirPath = new File(baseFile, merchantId);
            if (!dirPath.exists()) {
                dirPath.mkdir();
            }
            for (Map.Entry<String, MultipartFile> entry : map.entrySet()) {
                MultipartFile file = entry.getValue();
                // 获得文件名：
                ExecutorService executorService = Executors.newCachedThreadPool();
                Future future = executorService.submit(new UploadImageCallable(dirPath, file));
                String path = future.get().toString();
                paramMap.put(entry.getKey(), path);
            }
            if (paramMap.size() > 0) {
                vo = JSONObject.parseObject(JSONObject.toJSONString(paramMap), PayInformationVo.class);
            }
            //调用保存方法
            return  payInformationService.updateInformationForISV(vo);
        } catch (Exception e) {
            e.printStackTrace();
            paramMap.put("status", 1);
            paramMap.put("message", "图片上传出错");
        }
        return Msg.createFailMsg("保存失败！");
    }

    private Map getString(Map map,HttpServletRequest request) {
        String returnStr = "";
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();
            if (paramName != "checkradio" && !paramName.equals("checkradio")){
                String[] paramValues = request.getParameterValues(paramName);
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() != 0) {
                        map.put(paramName, paramValue);
                    }
                }
            }
        }
        return map;
    }

    /**
     * 申请民生银行
     */
    @RequestMapping("/updateInformationForCMBC")
    @ResponseBody
    public Msg updateInformationForCMBC(PayInformationVo vo) {
        try {
            return payInformationService.updateInformationForCMBC(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Msg.createFailMsg("保存失败！");
    }
    /**
     * 申请快付通
     */
    @RequestMapping("/updateInformationForKFT")
    @ResponseBody
    public Msg updateInformationForKFT(HttpServletRequest request){
        PayInformationVo vo = null;
        Map<String, Object>  paramMap = new HashedMap();
        paramMap = getString(paramMap,request);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("properties/file");
        String imagePath = resourceBundle.getString("imagePath");
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            String merchantId = request.getParameter("restaurantId");
            Map<String, MultipartFile> map = multipartRequest.getFileMap();
            File baseFile = new File(imagePath);
            if (!baseFile.exists()) {
                baseFile.mkdir();
            }
            File dirPath = new File(baseFile, merchantId);
            if (!dirPath.exists()) {
                dirPath.mkdir();
            }
            for (Map.Entry<String, MultipartFile> entry : map.entrySet()) {
                MultipartFile file = entry.getValue();
                // 获得文件名：
                ExecutorService executorService = Executors.newCachedThreadPool();
                Future future = executorService.submit(new UploadImageCallable(dirPath, file));
                String path = future.get().toString();
                paramMap.put(entry.getKey(), path);
            }
            if (paramMap.size() > 0) {
                vo = JSONObject.parseObject(JSONObject.toJSONString(paramMap), PayInformationVo.class);
            }
            //调用保存方法
            return payInformationService.updateInformationForKFT(vo);
        } catch (Exception e) {
            e.printStackTrace();
            paramMap.put("status", 1);
            paramMap.put("message", "图片上传出错");
        }
        return Msg.createFailMsg("保存失败！");
    }

    /**
     * 查看阿里类目
     * @return
     */
    @RequestMapping(value = "/aliCategory")
    public String aliCategory(){
        return "payconfig/business-management-category";
    }

    /*************************************************************        查看申请结果     ********************************************************/

    /**
     * 查询申请结果页面
     * @param restaurantId
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryResultPage")
    public String queryResultPage (@RequestParam(defaultValue = "") Long restaurantId , Model model){
        model.addAttribute("restaurantId",restaurantId);
        return "payconfig/query_result";
    }

    /**
     * 查询结果
     * @param restaurantId
     * @return
     */
    @RequestMapping("/queryResult")
    @ResponseBody
    public ModelResult queryResult (@RequestParam(defaultValue = "") Long restaurantId ){
        ModelResult result = new ModelResult();
        try {
            List<ResultRecordSheetVo> list =  payConfigService.queryResult(restaurantId);
            result.isSuccess();
            result.setData(list);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}