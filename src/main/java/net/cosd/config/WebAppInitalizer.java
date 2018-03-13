package net.cosd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/*
传统web.xml方式的替代方案
Servlet3.0后的服务器, 例如: Tomcat7

 */

public class WebAppInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected String[] getServletMappings() {
//        将DispatcherServlet映射到 "/"
//        这表示它会是应用的默认
//        Servlet。 它会处理进入应用的所有请求
        return new String[] { "/" };
    }

    /**
     *返回带有@Configuration注解的类将会用来配置ContextLoaderListener创建应的应用上下文中的bean。
     * ContextLoaderListener要加载应用中的其他bean，这些bean通常是驱动应用后端的中间层和数据层的组件。
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }


    /**
     *返回带有@Configuration注解的类将会用来定义DispatcherServlet应用上下文中的bean。
     * DispatcherServlet加载包含Web组件的bean，如控制器、视图解析器以及处理器映射器。
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * @Description: 配置字符过滤器
     */
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] { characterEncodingFilter() };
    }

}
