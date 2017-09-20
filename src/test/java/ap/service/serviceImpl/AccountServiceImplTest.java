package ap.service.serviceImpl;

import ap.config.WebConfig;
import ap.entity.Account;
import ap.entity.Role;
import ap.entity.Roles;
import ap.entity.Token;
import ap.service.AccountService;
import ap.service.TokenService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class AccountServiceImplTest {
    @Autowired
    AccountService accountService;

    @Autowired
    TokenService tokenService;

    Account account;


    @Before
    public void setUp() throws Exception {
        account = new Account();
        account.setMail("test@mail.ru");
        account.setLogin("test");
        account.setPassword("123456");

        Roles roles = new Roles();
        roles.setRoleName(Role.ARTIST.name());
        roles.setLoginAccount(account.getLogin());
        roles.setAccount(account);

        account.setRoles(roles);


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getById() throws Exception {
    }

    @Test
    public void getByName() throws Exception {
    }

    @Test
    @Rollback
    @Transactional
    public void create() throws Exception {
        accountService.create(account);
    }

    @Test
    public void update() throws Exception {
    }

}