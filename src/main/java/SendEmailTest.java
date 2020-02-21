import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

//import org.omg.CORBA.PRIVATE_MEMBER;

public class SendEmailTest {
    public static void sendEmail(String to, String content, String host, String port, String sendName, String from, String password, String subject) throws UnsupportedEncodingException {

        /*** 1、创建Session ***/
        Properties props = new Properties();
        // 开启调试模式
        props.setProperty("mail.debug", "true");
        // 发送主机需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器名称
        props.setProperty("mail.host", host);
        // 设置邮件服务器端口
        props.setProperty("mail.port", port);
        // 发送协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        props.setProperty("mail.smtp.starttls.enable", "true");

        final String fromstr = from;
        final String passwordstr = password;
        // 环境信息
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 在session中设置账户信息，Transport发送邮件时会使用
                return new PasswordAuthentication(fromstr, passwordstr);
            }
        });
        /*** 2、创建邮件对象 ***/
        Message msg = new MimeMessage(session);
        try {
            // 设置发件人
            msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText(sendName) + "\" <" + from + ">"));
            // 设置标题
            msg.setSubject(subject);
            // 设置内容
            msg.setContent(content, "text/html;charset=UTF-8");
            /*** 3、发送邮件 ***/
            Transport.send(msg, InternetAddress.parse(to));

        } catch (MessagingException e) {
            System.out.println("发送邮件失败!!");
            e.printStackTrace();
        }
        System.out.println("发送邮件成功!!");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        sendEmail("yao.zhao@finlevit.com", "Test for email sending", "smtp.gmail.com", "587", "ARES", "yaozhao95@gmail.com", "zhaoyao213", "TestSending");
    }
}