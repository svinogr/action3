package ap.service.serviceImpl;

import ap.dao.TokenDao;
import ap.entity.Token;
import ap.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.security.Key;

public class TokenServiceImpl implements TokenService {

    @Autowired
    Environment environment;

    @Autowired
    TokenDao dao;

    private void checkToken(Token token) {
        Token tokenOld = dao.getByLogin(token.getLogin());
        if (tokenOld != null) {
            dao.delete(tokenOld);
        }
    }

    public Token generateToken(Token token) {
        checkToken(token);
        Key key = MacProvider.generateKey();
        String compactJws = Jwts.builder()
                .setIssuer(environment.getRequiredProperty("mail.site"))
                .setSubject(token.getLogin())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();

        token.setToken(compactJws);

        return token;
    }
}
