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

    @Bean
    public ViewResolver viewResolver() {
        VelocityViewResolver resolver = new VelocityViewResolver();
        resolver.setContentType("text/html;charset=UTF-8");
        resolver.setPrefix("/views/");
        resolver.setSuffix(".html");
        resolver.setToolboxConfigLocation("/WEB-INF/config/velocity-toolbox.xml");
        return resolver;
    }

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

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jacksonConverter());
    }

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
