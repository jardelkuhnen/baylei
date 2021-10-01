//package br.com.baylei.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.*;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.function.Predicate;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2
////@EnableOpenApi
//public class SwaggerConfig implements WebMvcConfigurer {
//
//    private static final String API_TITLE = "Bailey";
//    private static final String API_DESCRIPTION = "API for pet busines";
//    private static final String API_VERSION = "0.0.1";
//    private static final String TERMS_OF_SERVICE_URL = "none";
//    private static final Contact CONTACT = new Contact("Jardel Back Kuhnen", "none", "jardelkuhnen@gmail.com");
//    private static final String LICENSE = "Apache 2.0";
//    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";
//
//    private static ApiInfo getApiInfo() {
//        return new ApiInfo(API_TITLE, API_DESCRIPTION, API_VERSION, TERMS_OF_SERVICE_URL, CONTACT, LICENSE, LICENSE_URL, new ArrayList<>());
//    }
//
//    @Bean
//    public Docket petStoreApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.ant("/api/**"))
//                .build()
//                .apiInfo(getApiInfo());
//    }
//}
