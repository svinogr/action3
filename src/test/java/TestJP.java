import ap.config.WebConfig;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class TestJP {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    UserDetailsService userDetailsService;

    @Test
    @Transactional()
    @Rollback
    public void saveRoles() {
       /* Role role = Role.USER;

        Roles roles = new Roles();
        roles.setRoleName(role.name());
        roles.setLoginAccount("test");

        Session currentSession = sessionFactory.getCurrentSession();
        Serializable save = currentSession.save(roles);
        Roles rolesTest = currentSession.get(Roles.class, save);
        System.out.println(save);
        assertEquals(save,rolesTest.getId());*/
        UserDetails userDetails = userDetailsService.loadUserByUsername("name");
        System.out.println(userDetails);
        System.out.println(new BCryptPasswordEncoder().encode("name"));



    }
}
