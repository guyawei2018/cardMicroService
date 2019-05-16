package com.lanswon.springcloud.confg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Confg {

        @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.lanswon.springcloud.controller"))//这是扫描注解的配置，即你的API接口位置。
                    .paths(PathSelectors.any())
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("服务:标题")
                    .description("服务:描述信息")
//                    .termsOfServiceUrl("http://192.168.1.198:10070/platformgroup/ms-admin") //设置文档的License信息-
                    .contact(new Contact("敲代码的职业法师", "http://www.baidu.com", "gyw63612@163.com"))
                    .version("1.0")
                    .build();
        }

    }

