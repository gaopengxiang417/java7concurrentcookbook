package com.gao.threadExcutors;

import java.util.concurrent.Callable;

/**
 * User: wangchen.gpx
 * Date: 13-11-23
 * Time: 下午7:48
 */
public class TaskValidate implements Callable<String> {

    private UserValidator userValidator;

    private String username;

    private String password;

    public TaskValidate(UserValidator userValidator, String username, String password) {
        this.userValidator = userValidator;
        this.username = username;
        this.password = password;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        if (!userValidator.validate(username, password)) {
            System.out.printf("%s is not found in ...\n" , username);
            throw new Exception("not found exception");
        }
        System.out.printf("%s has founc\n" , username);
        return username;
    }
}
