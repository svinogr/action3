package ap.controllers;

import ap.entity.Account;
import ap.entity.Roles;
import ap.service.AccountService;
import com.sun.deploy.security.BrowserAuthenticator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.util.BrowserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class Test {
/*
    @Autowired
    SessionFactory sessionFactory;*/

    @Autowired
    AccountService accountService;

    @Autowired
    UserDetailsService userDetailsService;

    @Transactional
    @RequestMapping(value = "/test")
    public String getTestPage() {
    /*    Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria =  currentSession.createCriteria(Roles.class);
        Object uniqueResult = criteria.setProjection(Projections.rowCount()).uniqueResult();
        System.out.println(uniqueResult);
        Account account = new Account();
        account.setName("ddd");
        account.setPassword("ddd");
        accountService.create(account);*/
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return "index";
    }


    @RequestMapping(value = "/company/conf", method = RequestMethod.GET)
    public String getConf(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "conf";

    }
}
