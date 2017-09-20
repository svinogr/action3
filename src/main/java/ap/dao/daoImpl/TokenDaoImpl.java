package ap.dao.daoImpl;

import ap.dao.TokenDao;
import ap.entity.Account;
import ap.entity.Token;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TokenDaoImpl extends BasicDaoImpl<Token> implements TokenDao {
    public TokenDaoImpl() {
        super(Token.class);
    }

    @Override
    public Token getByLogin(String login) {
        Token token = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Token.class);
            criteria.add(Restrictions.eq("login", login));
            token = (Token) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return token;

    }

    @Override
    public Token getTokenByToken(String tokenString) {
        Token token = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(Token.class);
            criteria.add(Restrictions.eq("token", tokenString));
            token = (Token) criteria.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return token;

    }

}
