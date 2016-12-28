package com.qiyu.paymanager.controller;


import com.qiyu.common.annotation.ServiceExceptionRet;
import com.qiyu.common.utils.JsonUtil;
import com.qiyu.common.utils.MediaTypes;
import com.qiyu.paymanager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Dean on 2016/3/9.
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "getAppPrice", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
    public Object getAppPrice() {
        Map<String, Object> result = adminService.getAppPrice();
        return JsonUtil.toJson(result);
    }

    @ResponseBody
    @ServiceExceptionRet
    @RequestMapping(value = "saveAppPrice", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
    public Object saveAppPrice(@RequestParam(value = "appPrice", required = true) double appPrice) {
        Map<String, Object> result = adminService.saveAppPrice(appPrice);
        return JsonUtil.toJson(result);
    }


}
