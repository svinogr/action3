package ap.dao.daoImpl;

import ap.dao.AccountDao;
import ap.entity.Account;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountDaoImpl extends BasicDaoImpl<Account> implements AccountDao {

    @Autowired
    SessionFactory sessionFactory;

    public AccountDaoImpl() {
        super(Account.class);
    }

    @Override
    @Transactional
    public Account getByLogin(String login) {
        Account account = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Account.class);
            criteria.add(Restrictions.eq("login", login));
            account = (Account) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return account;
    }
}
