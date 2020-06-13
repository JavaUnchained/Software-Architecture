package com.example.foodeliver;

import com.codeborne.selenide.Configuration;
import com.example.foodeliver.model.BotFactory;
import com.example.foodeliver.model.TestBot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWindow;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public abstract class TestBase {
    protected static TestBot bot;

    @BeforeAll
    public static void setUp() {
        browser = "chrome";
        Configuration.timeout = 5000;
        baseUrl = "http://localhost:8080";
        bot = BotFactory.getOkBot();
        // autentication
    }

    protected static String getRandomString() {
        return randomAlphanumeric(5, 40);
    }

    protected static String getRandomNumber() {
        return randomNumeric(1, 9);
    }

    @AfterAll
    public static void turnDown() {
        closeWindow();
    }
}
