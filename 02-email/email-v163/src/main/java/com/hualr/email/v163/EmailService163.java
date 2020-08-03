package com.hualr.email.v163;

import com.hualr.email.api.IEmailService;

public class EmailService163 implements IEmailService {
    @Override
    public void sendEmail(String context) {
        System.out.println("send"+context+"with 163 mail");
    }
}
