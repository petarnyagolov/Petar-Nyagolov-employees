package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Date: 22.5.2022 г. Time: 11:06
 * <p>
 *  TODO: WRITE THE DESCRIPTION HERE
 *
 * @author petar
 */
@SpringBootApplication
public class UploadCVS extends SpringBootServletInitializer
{


  public static void main(String[] args)
  {
    SpringApplication.run(UploadCVS.class,args);
  }
  @Bean(name = "multipartResolver")
  public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setMaxUploadSize(100000);
    return multipartResolver;
  }

}
