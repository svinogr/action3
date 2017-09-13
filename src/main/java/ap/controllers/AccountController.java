package ap.controllers;

import ap.dao.RolesDao;
import ap.entity.Account;
import ap.entity.ArtistProfile;
import ap.entity.Role;
import ap.entity.Roles;
import ap.service.AccountService;
import ap.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    ArtistService artistService;

    @Autowired
    RolesDao rolesDao;

    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    public Account createAccount(@RequestBody @Valid Account account, BindingResult bindingResult, HttpServletResponse response) {
        System.out.println("AccountController");
        if (bindingResult.hasErrors()) {
            Map<String, String> mapErrors = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                mapErrors.put(error.getField(), error.getDefaultMessage());
            }
            account.setLogin(mapErrors.get("login"));
            account.setMail(mapErrors.get("mail"));
            account.setPassword(mapErrors.get("password"));
            response.setStatus(400);
            return account;
        }

        Roles roles = new Roles();
        roles.setRoleName(Role.ARTIST.name());
        roles.setLoginAccount(account.getLogin());
        roles.setAccount(account);
        account.setRoles(roles);
        account = accountService.create(account);

        if (account == null) {
            response.setStatus(500);
            account = new Account();
            account.setLogin("Пользователь слогином уже существует");
            return account;
        }

        response.setStatus(201);
        response.setHeader("Location", "/api/account/" + account.getId());
        account.setPassword(null);
        account.setRoles(null);
        return account;
    }


}
