package com.qiyu.paymanager.controller;



import com.qiyu.paymanager.service.AuthService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dean on 2016/3/9.
 */
@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    private static Logger logger= LoggerFactory.getLogger(AuthController.class);

    @RequestMapping(value = "login",method = RequestMethod.GET )
    public String login(Model model){
        model.addAttribute("authticationError", null);
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST )
    public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username,
                       HttpServletRequest request,
                       Model model) {
        String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);

        String authticationError=null;
        model.addAttribute("authticationError", authticationError);
        model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
        if (!StringUtils.isEmpty(error)) {
            logger.info("登录成功");
            return "main";
        } else {
            logger.error("登录异常,错误信息={}",error);
            if(UnknownAccountException.class.getName().equals(error)){
                authticationError = "用户名不存在";
            }else if(IncorrectCredentialsException.class.getName().equals(error)){
                authticationError = "用户名/密码错误";
            }else if(DisabledAccountException.class.getName().equals(error)){
                authticationError = "禁用的帐号";
            }else if(LockedAccountException.class.getName().equals(error)){
                authticationError = "锁定的帐号";
            }else if(UnknownAccountException.class.getName().equals(error)){
                authticationError = "错误的帐号";
            }else if(ExcessiveAttemptsException.class.getName().equals(error)){
                authticationError = "登录失败次数过多";
            }else if(IncorrectCredentialsException.class.getName().equals(error)){
                authticationError = "错误的凭证";
            }else if(ExpiredCredentialsException.class.getName().equals(error)){
                authticationError = "过期的凭证";
            }
            return "login";
        }

    }

    @RequestMapping(value = "/",method = RequestMethod.GET )
    public String main() {
        return "main";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET )
    public String index() {
        return "main";
    }

    @RequestMapping(value = "loginOut",method = RequestMethod.GET )
    public String loginOut() {
        Subject subject= SecurityUtils.getSubject();
        if(null!=subject){
            subject.logout();
        }
        return "redirect:/login";
    }

//    @ResponseBody
//    @ServiceExceptionRet
//    @RequestMapping(value = "register",method = RequestMethod.GET ,produces = MediaTypes.JSON_UTF_8)
//    public Object register(@RequestParam(value = "restaurantId",required = true)long restaurantId,
//                           @RequestParam(value = "userName",required = true)String userName,
//                           @RequestParam(value = "staffNo",required = true)String staffNo,
//                           @RequestParam(value = "password",required = true)String password
//    ){
//        return authService.register(restaurantId,userName,staffNo,password);
//    }




}
