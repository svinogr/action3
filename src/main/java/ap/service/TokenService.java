package ap.service;

import ap.entity.Token;

public interface TokenService extends BasicService<Token> {
    Token generateToken(Token token);

    Token getTokenByTokenString(String tokenString);

}
