package com.tea.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.regex.Pattern;

@Configuration
@Deprecated
public class StaticMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String ROOT_PATH = "E:/File/";
        ROOT_PATH = getString(ROOT_PATH);
        registry.addResourceHandler("/file/**").addResourceLocations("file:"+ROOT_PATH);
        registry.addResourceHandler("/page/**").addResourceLocations("file:E:\\WorkSpace\\tea_weed_pc\\");
        super.addResourceHandlers(registry);
    }

    public static String getString(String ROOT_PATH) {
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            ROOT_PATH = "/home/zhaoliu/zys/File/";
        } else if (Pattern.matches("Mac.*", osName)) {
            ROOT_PATH = "/Users/james/File/";
        }
        return ROOT_PATH;
    }
}
