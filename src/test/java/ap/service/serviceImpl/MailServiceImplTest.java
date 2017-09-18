package ap.service.serviceImpl;

import ap.config.WebConfig;
import ap.service.MailService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.mail.internet.MimeMessage;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class MailServiceImplTest {

    @Autowired
    MailService mailService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sendMessage() throws Exception {
        String to = "action3@inbox.ru";
        String body = "body message";
        String subject = "subject";
        MimeMessage message = mailService.createMessage(to, body, subject);
        mailService.sendMessage(message);

    }

    @Test
    public void createMessage() throws Exception {
        String to = "test@mail.ru";
        String body = "body message";
        String subject = "subject";
        MimeMessage message = mailService.createMessage(to, body, subject);
        System.out.println("message " + message.getAllRecipients()[0]);
        assertEquals(to, message.getAllRecipients()[0].toString());
        assertEquals(subject, message.getSubject());
    }

}