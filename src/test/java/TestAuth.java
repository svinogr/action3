import ap.config.WebConfig;
import ap.dao.RolesDao;
import ap.entity.Account;
import ap.entity.Role;
import ap.entity.Roles;
import ap.service.AccountService;
import org.junit.After;
import org.junit.Before;
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

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class TestAuth {

    @Autowired
    AccountService accountService;

    @Autowired
    RolesDao rolesDao;

    @Autowired
    UserDetailsService userDetailsService;
    String name = "test";
    private Account account;
    private Roles roles;

    @Before
    @Rollback
    public void setUp() throws Exception {
        System.out.println("start test");
        account = new Account();
        account.setName(name);
        account.setPassword("test");
        accountService.create(account);
        Role role = Role.ADMIN;
        roles = new Roles();
        roles.setLoginAccount(account.getName());
        roles.setRoleName(role.name());
        rolesDao.save(roles);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test end :)");
        accountService.delete(account);
        rolesDao.delete(roles);
    }

    @Test
    public void validAuth() {
        String pass = "test";
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        boolean actual = new BCryptPasswordEncoder().matches(pass, userDetails.getPassword());
        assertEquals(true, actual);
    }

    @Test
    public void noValidAuth() {
        String pass = "notRight";
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        boolean actual = new BCryptPasswordEncoder().matches(pass, userDetails.getPassword());
        assertEquals(false, actual);
    }


}
