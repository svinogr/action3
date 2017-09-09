package ap.config;

import ap.dao.ArtistProfileDao;
import ap.dao.BasicDao;
import ap.dao.RolesDao;
import ap.dao.daoImpl.ArtistProfileDaoImpl;
import ap.dao.daoImpl.BasicDaoImpl;
import ap.dao.daoImpl.RolesDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    BasicDao daoBasic() {
        return new BasicDaoImpl();
    }

    @Bean
    RolesDao rolesDao() {
        return new RolesDaoImpl();
    }

    @Bean
    ArtistProfileDao artistProfileDao() {
        return new ArtistProfileDaoImpl();
    }

}
