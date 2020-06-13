package com.example.foodeliver.model;

import java.util.ResourceBundle;

class Bot extends TestBot {

    Bot() {
        super(ResourceBundle.getBundle("ok_bot_data"), "Test Bot");
    }

    Bot(String name) {
        super(ResourceBundle.getBundle("ok_bot_data"), name);
    }
}
