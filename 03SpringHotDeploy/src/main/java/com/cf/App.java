package com.cf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World, ruanhuabin" );
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    public HttpMessageConverters fastJsonConverters()
    {
    	FastJsonHttpMessageConverter fastConverters = new FastJsonHttpMessageConverter();
    	FastJsonConfig fastConfig = new FastJsonConfig();
    	
    	fastConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
    	
    	fastConverters.setFastJsonConfig(fastConfig);
    	
    	HttpMessageConverter<?>  converters = fastConverters;
    	
    	return new HttpMessageConverters(converters);
    }
}
