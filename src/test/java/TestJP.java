import ap.config.WebConfig;
import ap.entity.Role;
import ap.entity.Roles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.*;

import java.io.Serializable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class TestJP {

    @Autowired
    SessionFactory sessionFactory;

    @Test
    @Transactional()
    public void saveRoles() {
        Role role = Role.USER;

        Roles roles = new Roles();
        roles.setRoleName(role.name());
        roles.setAccountId(1);

        Session currentSession = sessionFactory.getCurrentSession();
        Serializable save = currentSession.save(roles);
        Roles rolesTest = currentSession.get(Roles.class, save);
        System.out.println(save);
        assertEquals(save,rolesTest.getId());



    }
}
