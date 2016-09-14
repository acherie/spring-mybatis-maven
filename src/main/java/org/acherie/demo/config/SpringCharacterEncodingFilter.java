package org.acherie.demo.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by wangjie on 9/14/2016.
 */
public class SpringCharacterEncodingFilter implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic springEncodingFilter =
                servletContext.addFilter("SpringEncodingFilter", encodingFilter);
        springEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
