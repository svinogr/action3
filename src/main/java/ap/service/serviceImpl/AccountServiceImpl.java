package ap.service.serviceImpl;

import ap.dao.AccountDao;
import ap.dao.RolesDao;
import ap.entity.Account;
import ap.entity.Role;
import ap.entity.Roles;
import ap.entity.Token;
import ap.service.AccountService;
import ap.service.MailService;
import ap.service.TokenService;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.security.Key;
import java.util.Collection;

@Service
@PropertySource(value = {"classpath:mail.properties"})
public class AccountServiceImpl implements AccountService {
    @Autowired
    Environment environment;

    @Autowired
    AccountDao accountDao;

    @Autowired
    TokenService tokenService;

    @Autowired
    MailService mailService;

    @Autowired
    RolesDao rolesDao;

    @Autowired
    UserDetailsService userDetailsService;

    public Account getById(int id) {
        return accountDao.getById(id);
    }

    public Account getByName(String name) {
        return accountDao.getByLogin(name);
    }

    @Transactional
    public Account create(Account account) {
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));

        if (checkAccount(account.getLogin())) return null;

        Token token = new Token();
        token.setLogin(account.getLogin());
        token.setAccount(account);
        tokenService.generateToken(token);

        account.setToken(token);

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

    @Override
    public boolean acceptRegistration(String tokenString) {
        Token tokenByTokenString = tokenService.getTokenByTokenString(tokenString);
        if (tokenByTokenString != null) {
            Account byLogin = accountDao.getByLogin(tokenByTokenString.getLogin());
            byLogin.setActive(true);
            accountDao.update(byLogin);
            login(byLogin.getLogin());
            return true;
        }
        return false;
    }

    @Override
    public void login(String login) {
        if (login != null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(login);
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
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




