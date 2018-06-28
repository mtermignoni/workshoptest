package workshop.api.service;

import feign.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import workshop.api.model.User;

@Configuration
class FeignConfiguration {

  @Autowired
  private CurrentUser currentUser;

  @Bean
  public Request.Options options() {
    return new Request.Options(5000, 60000);
  }

 
}