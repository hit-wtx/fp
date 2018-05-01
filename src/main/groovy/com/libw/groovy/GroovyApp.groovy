package com.libw.groovy

/**
 * Created by:wentuanxu 
 * date: 2018/4/29.
 */
class GroovyApp {
    static main(args) {
        def closure = { param -> println "hello ${param}" }
        closure("world")
    }
}
