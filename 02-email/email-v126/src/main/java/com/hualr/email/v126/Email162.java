package com.hualr.email.v126;

import com.hualr.email.api.IEmailService;

public class Email162 implements IEmailService {
    @Override
    public void sendEmail(String context) {
        System.out.println("send 126 email:"+context);
    }
}
