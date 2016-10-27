package com.netease.spring.user.web.controller;

import com.netease.spring.user.domain.User;
import com.netease.spring.user.service.UserServiceInter;
import com.netease.spring.user.utils.CookieUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户Controller
 * Created by switch on 16/10/27.
 */
@Controller
public class UserController {
    @Resource
    private UserServiceInter userService;

    /**
     * 去往登陆界面
     *
     * @return 登陆UI
     */
    @RequestMapping("/gotoLoginUI")
    public String gotoLoginUI() {
        return "loginUI";
    }

    /**
     * 登陆
     *
     * @param request  请求
     * @param response 响应
     * @param map      模型
     * @return 视图
     */
    @RequestMapping("/userLogin")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        // 如果cookie中用户和Session中用户匹配，则直接返回成功界面
        Cookie loginUserCookie = CookieUtils.getCookie(request.getCookies(), "loginUser");
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUserCookie != null && loginUser != null) {
            String loginUserName = loginUserCookie.getValue();
            if (loginUserName.equals(loginUser.getUserName())) {
                // 添加到视图中
                map.addAttribute(loginUser);
                return "mainUI";
            }
        }


        // 获取表单信息
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        // 通过参数创建UserBean对象
        User user = new User(null, userName, userPassword);
        // 将user传递到service中进行校验
        user = userService.login(user);
        // 登陆成功
        if (user != null) {
            // 添加到视图中
            map.addAttribute(user);
            // 添加到Session域中
            request.getSession().setAttribute("loginUser", user);
            // 设置Cookie
            Cookie cookie = new Cookie("loginUser", user.getUserName());
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);

            return "mainUI";
        }
        // 登陆失败
        map.addAttribute("errMsg", "用户名或密码有误");
        return "loginUI";
    }
}
