package ap.controllers;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @RequestMapping(value = "/test")
    public String getTestPage() {
        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria =  currentSession.createCriteria(Test.class);
        Object uniqueResult = criteria.setProjection(Projections.rowCount()).uniqueResult();
        System.out.println(uniqueResult);
        return "index";
    }
}
