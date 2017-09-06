package ap.service.serviceImpl;

import ap.dao.AccountDao;
import ap.entity.Account;
import ap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    public Account getById(int id) {
        return accountDao.getById(id);
    }

    public Account getByName(String name) {
        return accountDao.getByName(name);
    }

    @Transactional
    public Account create(Account account) {
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        return accountDao.save(account);
    }

    public Account update(Account account) {
        return accountDao.update(account);
    }

    public void delete(Account account) {
        accountDao.delete(account);

    }
}
