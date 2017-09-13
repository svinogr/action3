package ap.service.serviceImpl;

import ap.dao.AccountDao;
import ap.entity.Account;
import ap.entity.Role;
import ap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    public Account getById(int id) {
        return accountDao.getById(id);
    }

    public Account getByName(String name) {
        return accountDao.getByLogin(name);
    }

    @Transactional
    public Account create(Account account) {
        //TODO отпрвка активации на емейл

        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        if (checkAccount(account.getLogin())) return null;
        return accountDao.save(account);
    }

    public Account update(Account account) {
        return accountDao.update(account);
    }

    public void delete(Account account) {
        accountDao.delete(account);

    }

    private boolean checkAccount(String login) {
        return accountDao.getByLogin(login) != null;

    }

    public UserDetails getPrincipal() {
        UserDetails principal = null;
        try {
            principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return principal;
        }
        return principal;
    }

    public Role getRole() {
        UserDetails principal = getPrincipal();
        Role[] values = Role.values();

        if (principal != null) {
            for (GrantedAuthority rol : principal.getAuthorities()) {
                for (int i = 0; i < values.length; i++) {
                    if (rol.getAuthority().equals(values[i].name())) {
                        return values[i];
                    }
                }
            }

        }
        return null;
    }
}




