package ap.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "auth")
public class LoginController {

    @RequestMapping(value = "/loginstatus", method = RequestMethod.GET)
    public void getStatus(HttpServletRequest request, HttpServletResponse response) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
            System.out.println(1);
            response.setStatus(200);
        } else {
            response.setStatus(401);
            System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
            System.out.println(2);
        }
    }
}
