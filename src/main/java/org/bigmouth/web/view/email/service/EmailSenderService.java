package org.bigmouth.web.view.email.service;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.bigmouth.framework.net.mail.core.Email;
import org.bigmouth.framework.net.mail.core.EmailSender;
import org.bigmouth.framework.net.mail.core.EmailSenderFactory;
import org.bigmouth.framework.net.mail.core.SMTPConfig;

public class EmailSenderService {
    
    private static final Executor EXECUTOR = Executors.newCachedThreadPool();

    private SMTPConfig smtpConfig;
    private String subject;
    private String from;
    private String display;

    public void send(final String to, final String content) {
        EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                Email message = new Email();
                message.setEmailType(Email.HTML_EMAIL);
                message.setSubject(subject);
                message.setFrom(from, display);
                message.addTo(to);
                message.setContent(content);
                EmailSender sender = EmailSenderFactory.getSender(Email.HTML_EMAIL, smtpConfig);
                sender.send(message);
            }
        });
    }
    
    public void setSmtpConfig(SMTPConfig smtpConfig) {
        this.smtpConfig = smtpConfig;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
