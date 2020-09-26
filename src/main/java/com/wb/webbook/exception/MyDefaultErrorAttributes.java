package com.wb.webbook.exception;


import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 重写 DefaultErrorAttributes 以自定义统一异常处理后返回的数据.
 */
@Component
public class MyDefaultErrorAttributes extends DefaultErrorAttributes {

    @Override
    //重写 getErrorAttributes方法-添加自己的项目数据
    public Map<String, Object> getErrorAttributes(WebRequest webRequest,
                                                  boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        Map<String, Object> map = new HashMap<>();
        Object code = errorAttributes.get("status");
        Object message = errorAttributes.get("error");
        map.put("code", code);
        map.put("message", message);
        return map;
    }
}
