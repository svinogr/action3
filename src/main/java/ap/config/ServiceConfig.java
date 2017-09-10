package ap.config;

import ap.dao.ArtistProfileDao;
import ap.service.AccountService;
import ap.service.ArtistSearchService;
import ap.service.ArtistService;
import ap.service.serviceImpl.AccountServiceImpl;
import ap.service.serviceImpl.ArtistSearchServiceImpl;
import ap.service.serviceImpl.ArtistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    DaoConfig daoConfig;

    @Bean
    AccountService accountService() {
        return new AccountServiceImpl();
    }

    @Bean
    ArtistService artistService() {
        return new ArtistServiceImpl(daoConfig.artistProfileDao());
    }

    @Bean
    ArtistSearchService artistSearchService() {
        return new ArtistSearchServiceImpl();
    }


}
