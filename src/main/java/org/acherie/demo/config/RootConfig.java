package org.acherie.demo.config;

import org.springframework.context.annotation.*;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan(basePackages = {"org.acherie.demo"}, excludeFilters = {
    @ComponentScan.Filter(type = FilterType.CUSTOM, value = RootConfig.WebPackage.class)
})
@Import(DataConfig.class)
public class RootConfig {

    // 内部类，用来排除 web 相关的包，因为这些包已经在 WebConfig 中导入了
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("org\\.acherie\\.web"));
        }
    }
}
