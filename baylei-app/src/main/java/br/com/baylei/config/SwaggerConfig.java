package br.com.baylei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
@EnableOpenApi
public class SwaggerConfig {

    private static final String API_TITLE = "Baylei";
    private static final String API_DESCRIPTION = "API for pet busines";
    private static final String API_VERSION = "0.0.1";
    private static final String TERMS_OF_SERVICE_URL = "none";
    private static final Contact CONTACT = new Contact("Jardel Back Kuhnen", "none", "jardelkuhnen@gmail.com");
    private static final String LICENSE = "Apache 2.0";
    private static final String LICENSE_URL = "http://www.apache.org/licenses/LICENSE-2.0";

    private static ApiInfo getApiInfo() {
        return new ApiInfo(API_TITLE, API_DESCRIPTION, API_VERSION, TERMS_OF_SERVICE_URL, CONTACT, LICENSE, LICENSE_URL, new ArrayList<>());
    }

    @Bean
    public Docket insuranceApi() {
        var docket = new Docket(springfox.documentation.spi.DocumentationType.SWAGGER_2);
        return docket.apiInfo(getApiInfo());
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .defaultModelsExpandDepth(1)
                .defaultModelExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .showCommonExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }

    @Bean
    public Docket openApiPetStore() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("api-bayei")
                .select()
                .paths(petstorePaths())
                .build();
    }

    private Predicate<String> petstorePaths() {
        return regex(".*/api/.*");
    }

}
