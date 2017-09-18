package ap.dao.daoImpl;

import ap.config.WebConfig;
import ap.dao.AccountDao;
import ap.entity.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class AccountDaoImplTest {

    @Autowired
    AccountDao accountDao;

    private Account account;

    @Before
    public void setUp() throws Exception {
        System.out.println("test start :)");
        account = new Account();
        account.setLogin("test");
        account.setPassword("test");
        account.setMail("test@mail.ru");
        accountDao.save(account);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test end :)");
    }

    @Test
    @Transactional
    public void getByName() throws Exception {
        Account test = accountDao.getByLogin(account.getLogin());
        assertEquals(account.getId(), test.getId());
    }

    @Test
    @Transactional
    public void getById() throws Exception {
        Account test = accountDao.getById(account.getId());
        assertEquals(account.getId(), test.getId());
    }

    @Test
    @Transactional
    public void save() throws Exception {
        Account test = accountDao.getById(account.getId());
        assertEquals(account.getId(), test.getId());

    }

    @Test
    @Transactional
    public void update() throws Exception {
        String newName = "new";
        account.setLogin(newName);
        accountDao.update(account);
        accountDao.getById(account.getId());
        assertEquals(newName, account.getLogin());

    }

    @Test
    public void delete() throws Exception {
        boolean delete = accountDao.delete(account);
        assertEquals(delete, true);
    }

}