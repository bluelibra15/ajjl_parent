package com.ajjl.controller;

import com.ajjl.dao.AccountDao;
import com.ajjl.pojo.Account;
import com.ajjl.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Properties;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping("/execute")
    public Result mail() throws Exception {
        String pop3Server = "pop.qq.com";
        String protocol = "pop3";
        String username = "1011194848@qq.com";
        String password = "rlviakiwsfhpbdhj";

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", protocol);
        props.setProperty("mail.smtp.host", pop3Server);

        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);

        Store store = session.getStore(protocol);
        store.connect(pop3Server, username, password);

        Folder folder = store.getFolder("INBOX");
        try {

            folder.open(Folder.READ_WRITE);

            Message[] messages = folder.getMessages();
            if (messages != null && messages.length > 0) {
                for (Message message : messages) {
                    String from = message.getFrom()[0].toString();
                    String subject = message.getSubject();
                    String sendDate = DateFormat.getInstance().format(message.getSentDate());
                    System.out.println("邮件主题：" + subject + "\t");
                    //            System.out.println("发件人:" + from + "\t");
                    //            System.out.println("发送日期：" + sendDate + "");
                    if ("PokeMMO - 新设备验证".equals(subject)) {
                        System.out.println("邮件内容:");
                        InputStream inputStream = message.getInputStream();
                        BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuffer tStringBuffer = new StringBuffer();
                        String sTempOneLine;
                        while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                            tStringBuffer.append(sTempOneLine);
                        }
                        String str = tStringBuffer.toString();
                        String accountId = str.substring(str.indexOf("Username") + 10, str.indexOf("IP Address:"));
                        String code = str.substring(str.indexOf("hori=ze this device.") + 20, str.indexOf("Please do not share this code"));
                        System.out.println("账号:" + accountId);
                        System.out.println("验证码:" + code);
                        Account account = new Account();
                        account.setAccount(accountId);
                        account = accountDao.selectOne(account);
                        if (account != null) {
                            account.setCode(code);
                            int i = accountDao.updateByPrimaryKey(account);
                        } else {
                            account = new Account();
                            account.setStatus(0);
                            account.setAccount(accountId);
                            account.setStatus(0);
                            account.setEmail("1011194848@qq.com");
                            account.setCode(code);
                            account.setPassword(accountId);
                            accountDao.insert(account);
                        }
                    }
                    message.setFlag(Flags.Flag.DELETED, true);
                }
            }
            return new Result(true,"处理成功");
        } catch (Exception e) {
            return new Result(false,"处理异常");
        }finally {
            folder.close(true);
            store.close();
        }
    }
}
