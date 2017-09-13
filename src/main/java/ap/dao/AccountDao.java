package ap.dao;

import ap.entity.Account;

public interface AccountDao extends BasicDao<Account> {
    Account getByLogin(String name);

}
