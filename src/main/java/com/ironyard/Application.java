package com.ironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by jasonskipper on 10/31/16.
 */
@EnableSwagger2
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-api")
                .apiInfo(apiInfoUser())
                .select()
                .paths(regex("/rest/user.*"))
                .build().globalOperationParameters(
                        newArrayList(new ParameterBuilder()
                                .name("x-authorization-key")
                                .description("API Authorization Key")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()));
    }

    @Bean
    public Docket movieApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("movie-api")
                .apiInfo(apiInfoMovies())
                .select()
                .paths(regex("/rest/movie.*"))
                .build();

    }

    @Bean
    public Docket permissionApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("permission-api")
                .apiInfo(apiInfoPermissions())
                .select()
                .paths(regex("/rest/permission.*"))
                .build();
    }
    private ApiInfo apiInfoPermissions() {
        return new ApiInfoBuilder()
                .title("This is our API")
                .description("Do all permsision stuff here :D!")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Jason Skipper")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }
    private ApiInfo apiInfoUser() {
        return new ApiInfoBuilder()
                .title("This is our API")
                .description("Do all USER stuff here!!!")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Jason Skipper")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }
    private ApiInfo apiInfoMovies() {
        return new ApiInfoBuilder()
                .title("This is our API")
                .description("Do all Movie stuff here!!!")
                .termsOfServiceUrl("http://theironyard.com")
                .contact("Jason Skipper")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.1")
                .build();
    }
}
