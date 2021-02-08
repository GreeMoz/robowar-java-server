package org.hse.robowar.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

import static org.hse.robowar.constant.StringConstant.AUTHORIZATION_HEADER;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket securedApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("secured")
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.hse.robowar.controller"))
                .paths(Predicate.not(PathSelectors.regex("/public/**")))
                .build()
                .securitySchemes(Lists.newArrayList(apiKey()))
                .securityContexts(Lists.newArrayList(securityContext()));

    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        SecurityReference securityReference = new SecurityReference("apiKey", authorizationScopes);
        return SecurityContext.builder()
                .securityReferences(Lists.newArrayList(securityReference))
                .build();
    }

    @Bean
    public Docket publicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("public")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lunawealth.accounts"))
                .paths(PathSelectors.regex("/public/**"))
                .build();
    }

//    private Predicate<String> publicPaths() {
//        return or(
//                regex("/business.*"),
//                regex("/some.*"),
//                regex("/contacts.*"),
//                regex("/pet.*"),
//                regex("/springsRestController.*"),
//                regex("/test.*"));
//    }
}
