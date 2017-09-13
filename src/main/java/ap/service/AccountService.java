package ap.service;

import ap.entity.Account;
import ap.entity.Role;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {
    Account getById(int id);

    Account getByName(String name);

    Account create(Account account);

    Account update(Account account);

    void delete(Account account);

    Role getRole();

    UserDetails getPrincipal();
}
