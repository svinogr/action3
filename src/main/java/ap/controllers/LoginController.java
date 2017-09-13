package ap.controllers;

import ap.entity.Role;
import ap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "api/auth")
public class LoginController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/loginstatus", method = RequestMethod.GET)
    public Role getStatus(HttpServletRequest request, HttpServletResponse response) {
        Role role = accountService.getRole();

        if (role != null) {
            response.setStatus(200);
            return role;
        } else {
            response.setStatus(401);
            return null;
        }
    }

}
