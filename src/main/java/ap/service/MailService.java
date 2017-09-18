package ap.service;

import javax.mail.internet.MimeMessage;

public interface MailService {

    void sendMessage(MimeMessage mimeMessage);

    MimeMessage createMessage(String to, String body, String subject);
}
