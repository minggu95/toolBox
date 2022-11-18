package util;

import dto.MailDTO;
import lombok.extern.slf4j.Slf4j;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 邮件 调用接口
 *
 */
public class MailUtils {

	public static Boolean sendEmail(MailDTO mailDTO) {
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");//协议
		prop.setProperty("mail.smtp.host", "smtp.263.net");//主机名
		prop.setProperty("mail.smtp.auth", "true");//是否开启权限控制
		prop.setProperty("mail.debug", "true");//如果设置为true则在发送邮件时会打印发送时的信息
		//创建程序到邮件服务器之间的一次会话
		Session session = Session.getInstance(prop);
		//获取邮件对象
		Message msg = new MimeMessage(session);
		try {
			InternetAddress[] internetAddressArr = null;
			List<String> mailList = mailDTO.getReceiverMailAddress();
			List<InternetAddress> internetAddressList = new ArrayList<>();
			if(mailList != null && mailList.size() > 0) {
				for(String mail : mailList) {
					internetAddressList.add(new InternetAddress(mail));
				}
				internetAddressArr = internetAddressList.toArray(new InternetAddress[internetAddressList.size()]);
			}
			msg.setFrom(new InternetAddress(mailDTO.getSendMailAddress()));
			msg.setRecipients(Message.RecipientType.TO, internetAddressArr);
			msg.setSubject(mailDTO.getSubject());
//			msg.setText(mailDTO.getText());
			msg.setContent(mailDTO.getText(),
					"text/html;charset=utf-8");
			//输入账号密码
			Transport trans = session.getTransport();
			trans.connect(mailDTO.getSendMailAddress(), mailDTO.getSendPWD());
			trans.sendMessage(msg, msg.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return true;
	}
}
