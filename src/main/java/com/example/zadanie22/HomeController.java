package com.example.zadanie22;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private JavaMailSender mailSender;

    public HomeController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/")
    public String main() {
        return "home";
    }

    @GetMapping("/kontakt")
    public String contact(Model model) {
        model.addAttribute("mail", new Mail());
        return "contact";
    }

    @PostMapping("/send")
    public String send(Mail mail) {
        String companyMail = "test321@poczta.onet.pl";

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(companyMail);
            message.setTo(companyMail);
            message.setSubject(mail.getName());
            message.setText(mail.getContent());
            mailSender.send(message);

            if (mail.isConfirmation()) {
                SimpleMailMessage message2 = new SimpleMailMessage();
                message2.setFrom(companyMail);
                message2.setTo(mail.getSenderEmail());
                message.setSubject(mail.getName());
                message.setText(mail.getContent());
                mailSender.send(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}
