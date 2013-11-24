package com.gao.threadExcutors;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-23
 * Time: 下午7:44
 */
public class UserValidator {
    private String name;

    public UserValidator(String name) {
        this.name = name;
    }

    public boolean validate(String username, String password) {
        Random random = new Random();

        int duration = random.nextInt(1000);
        //sleep
        System.out.printf("%s start to validate password %d\n" , name , duration);

        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }

        return random.nextBoolean();
    }
}
