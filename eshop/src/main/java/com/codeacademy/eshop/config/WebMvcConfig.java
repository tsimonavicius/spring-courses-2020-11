package com.codeacademy.eshop.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * In order for our application to be able to determine which locale is currently being used,
     * we need to add a LocaleResolver bean
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("lt", "LT"));
        return localeResolver;
    }

    /**
     * this will switch to a new locale based on the value of the lang parameter appended to a request
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    /**
     * adding our interceptors to the application's interceptor registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * Changing default message source location
     */

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("i18n/messages");
        resourceBundleMessageSource.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        return resourceBundleMessageSource;
    }
}
