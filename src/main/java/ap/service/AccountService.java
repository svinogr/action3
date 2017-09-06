package ap.service;

import ap.entity.Account;

public interface AccountService {
    Account getById(int id);

    Account getByName(String name);

    Account create(Account account);

    Account update(Account account);

    void delete(Account account);
}
