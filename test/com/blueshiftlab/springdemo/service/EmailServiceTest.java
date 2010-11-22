package com.blueshiftlab.springdemo.service;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import com.blueshiftlab.springdemo.test.LocalServiceTest;

public class EmailServiceTest extends LocalServiceTest {

    @Test(groups = { "fast" })
    public void canInstantiateEmailService() {
        this.mailService.clearSentMessages();
        assertEquals(0, mailService.getSentMessages().size());
    }
}