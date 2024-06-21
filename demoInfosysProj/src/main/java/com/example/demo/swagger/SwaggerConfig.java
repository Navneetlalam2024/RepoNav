package com.example.demo.swagger;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Navneet Lalam
 * @version 1.0
 * @since 2024-06-20
 */

@Component
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-apis")
                .apiInfo(getApiInfo())
                .select()
                .build();
    }

    public ApiInfo getApiInfo(){
        return new ApiInfoBuilder().title("Reward Service Apis").version("1").build();
    }
}
