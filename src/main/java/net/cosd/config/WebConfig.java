package net.cosd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
// 启用Spring MVC  相当于 xml中的 <mvc:annotation-driven/>
@EnableWebMvc
// 启用组件扫描
@ComponentScan("net.cosd")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public ViewResolver viewResolver() {
        // 配置JSP视图解析器
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    // 配置静态资源的处理   相当于 xml中的<mvc:default-servlet-handler/>
    // 静态文件要放到 WEB-INF 外面
    /**
     * WebConfig类扩展了configurer WebMvcConfigurerAdapter并重写了其configureDefaultServletHandling()方法.
     * 通过调用DefaultServletHandlerConfigurer的enable()方法，要求DispatcherServlet将对静态资源的请求转发到Servlet容器默认的
     * Servlet上，而不是使用DispatcherServlet来处理此类请求。
     * @param
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


}


