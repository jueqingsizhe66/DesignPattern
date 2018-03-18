package com.build;

/**
 * 链式编程的好处
 */
public class TestUsers {
    public static void main(String[] args) {
       User user = new User.Builder("y","zl").age(18).build();
        System.out.println(user);
    }
}
