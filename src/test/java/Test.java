import ap.config.HibernateConfig;
import ap.config.WebConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

import java.io.Serializable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class Test {
    @Autowired
    SessionFactory sessionFactory;

    @org.junit.Test
    @Transactional()
    public void getTest() {
        ap.entity.Test f= new ap.entity.Test();
        f.setName("ddwd");
        Session currentSession = sessionFactory.getCurrentSession();
        Serializable save = currentSession.save(f);
        ap.entity.Test test = currentSession.get(ap.entity.Test.class, save);
        System.out.println(save);
        assertEquals(save,test.getId());



    }
}
