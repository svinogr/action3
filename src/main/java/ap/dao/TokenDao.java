package ap.dao;

import ap.entity.Token;

public interface TokenDao extends BasicDao<Token> {
    Token getByLogin(String login);

    Token getTokenByToken(String tokenString);
}
