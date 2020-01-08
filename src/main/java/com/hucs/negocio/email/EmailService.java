package com.hucs.negocio.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String assunto, String texto) {

        SimpleMailMessage msg = new SimpleMailMessage();
        //msg.setTo("tiagohucs@gmail.com", "2@yahoo.com");
        msg.setTo("tiagohucs@gmail.com");

        msg.setSubject(assunto);
        msg.setText(texto);

        javaMailSender.send(msg);

    }

/*    void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("1@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);
    }*/

}
