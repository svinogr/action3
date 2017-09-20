package ap.controllers;

import ap.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckController {
    @Autowired
    AccountService accountService;


    @RequestMapping(value = "/api/account/activated", method = RequestMethod.GET, params = "token")
    @Transactional
    public String acceptRegistration(HttpServletRequest request) {
        System.err.println("truetruetruetruetruetruetruetrue");
        String token = request.getParameter("token");
        if (accountService.acceptRegistration(token)) {
            System.err.println("truetruetruetruetruetruetruetrue");
            return "registrationAccept";
        }
        return "index";
    }
}
