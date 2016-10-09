package org.acherie.demo.config;

import org.acherie.demo.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Lion on 2016/9/13.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * 配置 Spring 根配置的 classes
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    /**
     * 配置 Spring DispatcherServlet 配置的 classes
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
