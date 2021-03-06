package net.cosd.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"net.cosd"},
    excludeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
@Import(DataConfig.class)
public class RootConfig {
}
