package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

/**
 * Date: 22.5.2022 г. Time: 11:22
 * <p>
 *  TODO: WRITE THE DESCRIPTION HERE
 *
 * @author petar
 */
@Configuration
public class SpringConfiguration
{
  @Bean
  public StandardServletMultipartResolver multipartResolver() {
    return new StandardServletMultipartResolver();
  }
}
