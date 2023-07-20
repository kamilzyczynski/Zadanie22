package com.example.zadanie22;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private MailService mailService;

    public HomeController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/kontakt")
    public String contact(Model model) {
        model.addAttribute("mail", new Mail());
        return "contact";
    }

    @PostMapping("/send")
    public String send(Mail mail) {

        try {
            mailService.sendMail(mail, mailService.getCompanyMail());

            if (mail.isConfirmation()) {
                mailService.sendMail(mail, mail.getSenderEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "ok";
    }
}
