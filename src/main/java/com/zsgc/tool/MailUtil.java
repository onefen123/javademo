package com.zsgc.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailUtil {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    TemplateEngine templateEngine;


    /**
     * 发送简单邮件
     * @param from 发送人
     * @param to 接收人
     * @param carbonCopy 抄送人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleEmail(String from, String[] to, String[] carbonCopy, String subject, String content) {

        long startTimestamp = System.currentTimeMillis();
        logger.info("Start send mail ... ");

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setCc(carbonCopy);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
            logger.info("Send mail success, cost {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MailException e) {
            logger.error("Send mail failed, error message is : {} \n", e.getMessage());
        }
    }

    /**
     * 发送html邮件
     */
    public void sendHtmlEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content, boolean isHtml) {
        long startTimestamp = System.currentTimeMillis();
        logger.info("Start send email ...");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);

            messageHelper.setFrom(deliver);
            messageHelper.setTo(receiver);
            messageHelper.setCc(carbonCopy);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, isHtml);

            mailSender.send(message);
            logger.info("Send email success, cost {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MessagingException e) {
            logger.error("Send email failed, error message is {} \n", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送带附件的邮件
     */
    public void sendAttachmentFileEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String content, boolean isHtml, String fileName, File file) {
        long startTimestamp = System.currentTimeMillis();
        logger.info("Start send mail ...");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom(deliver);
            messageHelper.setTo(receiver);
            messageHelper.setCc(carbonCopy);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, isHtml);
            messageHelper.addAttachment(fileName, file);

            mailSender.send(message);
            logger.info("Send mail success, cost {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MessagingException e) {
            logger.error("Send mail failed, error message is {}\n", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 发送模板邮件
     */
    public void sendTemplateEmail(String deliver, String[] receiver, String[] carbonCopy, String subject, String template, Context context) {
        long startTimestamp = System.currentTimeMillis();
        logger.info("Start send mail ...");

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);

            String content = templateEngine.process(template, context);
            messageHelper.setFrom(deliver);
            messageHelper.setTo(receiver);
            messageHelper.setCc(carbonCopy);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);

            mailSender.send(message);
            logger.info("Send mail success, cost {} million seconds", System.currentTimeMillis() - startTimestamp);
        } catch (MessagingException e) {
            logger.error("Send mail failed, error message is {} \n", e.getMessage());
            e.printStackTrace();
        }
    }
}
