package com.content.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by rich1 on 10/16/16.
 */
@Configuration
public class ErrorPageConfig{

    public EmbeddedServletContainerCustomizer
    embeddedServletContainerCustomizer(){
        return new MyCustomizer();
    }

    private static class MyCustomizer implements
            EmbeddedServletContainerCustomizer{

        @Override
        public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer){
            configurableEmbeddedServletContainer.addErrorPages(new ErrorPage
                    (HttpStatus.FORBIDDEN,"/403"));
        }
    }
}

