package org.acherie.demo.web.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lion on 2016/9/13.
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.acherie.demo.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    // 配置 VelocityViewResolver。因为 velocity 从2007年就未更新，所以 spring 从 4.3
    // 版本开始不赞成使用 velocity，推荐使用 FreeMarker
    @Bean
    public ViewResolver viewResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setPrefix("/views/");
        resolver.setSuffix(".html");
        resolver.setToolboxConfigLocation("/WEB-INF/config/velocity-toolbox.xml");
        return resolver;
    }

    // Velocity 的配置
    @Bean
    public VelocityConfigurer velocityConfigurer(ApplicationContext context) {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("/");

        Map<String, Object> velocityPropertiesMap = new HashMap<>();
        velocityPropertiesMap.put("input.encoding", "UTF-8");
        velocityPropertiesMap.put("output.encoding", "UTF-8");
        velocityConfigurer.setVelocityPropertiesMap(velocityPropertiesMap);

        velocityConfigurer.setConfigLocation(context.getResource("/WEB-INF/config/velocity.properties"));
        return velocityConfigurer;
    }

    // 开启默认 Servlet 的支持，可用于处理静态文件
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置 HttpMessageConverter，可配置多个自定义的 HttpMessageConverter
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonConverter());
    }

    // 配置自定义的 MappingJackson2HttpMessageConverter，用于处理 application/json 类型的 mediaType,
    // 并添加了 application/xml 转 json 的支持
    @Bean
    public MappingJackson2HttpMessageConverter jacksonConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_XML);

        MappingJackson2HttpMessageConverter converter =
                new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(mediaTypes);
        return converter;
    }
}
