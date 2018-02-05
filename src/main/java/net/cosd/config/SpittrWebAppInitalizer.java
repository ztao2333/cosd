package net.cosd.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
传统web.xml方式的替代方案
Servlet3.0后的服务器, 例如: Tomcat7

 */

public class SpittrWebAppInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected String[] getServletMappings() {
//        将DispatcherServlet映射到 "/"
//        这表示它会是应用的默认
//        Servlet。 它会处理进入应用的所有请求
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }
}
