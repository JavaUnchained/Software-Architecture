package com.example.foodeliver.model;

public class BotFactory {
    private BotFactory() {}

    public static TestBot getOkBot() {
        return new Bot();
    }

    public static TestBot getOkBotWithName(String name) {
        return new Bot(name);
    }
}
