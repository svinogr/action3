package ap.config;

import ap.service.AccountService;
import ap.service.serviceImpl.AccountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    AccountService accountService() {
        return new AccountServiceImpl();
    }
}
