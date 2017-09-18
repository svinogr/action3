package ap.service.serviceImpl;

import ap.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    Environment environment;

    public void sendMessage(MimeMessage mimeMessage) {
        // TODO ответ сервера
        javaMailSender.send(mimeMessage);
    }

    public MimeMessage createMessage(String to, String body, String subject) {

        MimeMessage simpleMailMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(simpleMailMessage, true, "UTF-8");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println(simpleMailMessage); // delete
        return simpleMailMessage;
    }
}
