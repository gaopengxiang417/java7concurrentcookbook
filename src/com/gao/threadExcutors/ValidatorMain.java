package com.gao.threadExcutors;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午12:33
 */
public class ValidatorMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String test = "test";
        UserValidator userValidator = new UserValidator(test);
        UserValidator passwordValidator = new UserValidator(test);

        TaskValidate usernameTask = new TaskValidate(userValidator, test, test);
        TaskValidate passwordTask = new TaskValidate(passwordValidator, test, test);

        ExecutorService executorService = Executors.newCachedThreadPool();

        String result = executorService.invokeAny(Arrays.asList(usernameTask, passwordTask));
        System.out.println(result);

        executorService.shutdown();
    }
}
