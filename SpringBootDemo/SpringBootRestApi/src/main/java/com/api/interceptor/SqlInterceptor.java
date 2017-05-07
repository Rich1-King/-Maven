package com.api.interceptor;

import com.api.model.po.User;
import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunchong on 2017/2/21.
 */
//执行sql时的拦截器
@Configuration
public class SqlInterceptor extends EmptyInterceptor{

    static Logger logger = Logger.getLogger(SqlInterceptor.class);
    static String name = null;

    @Override
    public String onPrepareStatement(String sql){
        return super.onPrepareStatement(sqlFilter(sql));
    }

    public static String sqlFilter(String sql){
        if(null == name){
            Table table = User.class.getAnnotation(Table.class);
            name = table.name();
        }

        if (sql.contains(name)){
            String regex = "\\$\\{(.+?)\\}";
            Matcher matcher = Pattern.compile(regex).matcher(sql);
            while (matcher.find()){
                SimpleDateFormat sdf = new SimpleDateFormat(matcher.group(1));//匹配正则
                sql = matcher.replaceAll(sdf.format(new Date()));
            }
        }
        return sql;
    }
}
