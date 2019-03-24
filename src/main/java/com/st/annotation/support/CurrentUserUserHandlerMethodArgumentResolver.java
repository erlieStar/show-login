package com.st.annotation.support;

import com.st.annotation.CurrentUser;
import com.st.pojo.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;


public class CurrentUserUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    /** 用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument。*/
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(User.class) && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    /** 真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象。*/
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

        String userId = request.getParameter("userId");

        // 为了方便不模拟查数据库的过程，直接new一个username和password都是userId的对象
        return new User(userId, userId);
    }
}
