package com.libw;

import com.libw.groovy.GroovyApp;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ScalaApp scalaApp = new ScalaApp();
        scalaApp.main(args);

        String[] strs = {"world"};
        GroovyApp.main(strs);
    }
}
