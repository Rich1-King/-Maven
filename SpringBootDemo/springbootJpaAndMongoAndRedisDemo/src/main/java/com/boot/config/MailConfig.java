package com.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by rich1 on 8/13/16.
 */
/*@Component
@ConfigurationProperties(locations ="classpath:mail" +
        ".properties")*///方法一，直接映射属性，属性上不可以有@Value,但是必须有get，set方法
@Configuration
@PropertySource("classpath:mail.properties")//方法二，get,set可有也可无，但是变量上必须要指明@Value.
public class MailConfig{
    @Value("${mailcount}")
    public int mailcount;

   /* public int getMailcount(){
        return mailcount;
    }

    public void setMailcount(int mailcount){
        this.mailcount = mailcount;
    }*/
}
