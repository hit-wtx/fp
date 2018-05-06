package com.libw.optional;
/**
 * Created by:wentuanxu
 * date: 2018/5/6.
 */

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ToString
public class TestStream {
    public static void main(String[] args) {
        List<JavaBean> javaBeans = Arrays.asList(new JavaBean("wtx", 10),
                new JavaBean("wtx", 11), new JavaBean("wtx", 12),
                new JavaBean("wtx", 13));

        List<JavaBean> filterJavaBeanList = javaBeans.stream().filter(a -> "wtx".equalsIgnoreCase(a.getName()))
                .collect(Collectors.toList());

        List<JavaBean> filterJavaBeanList2 = filterJavaBeanUseOldVersionJava(javaBeans, "wtx");

        List<JavaBean> filterJavaBeanList3 = filterJavaBeanUseOldVersionJava2(javaBeans, 10);
        // filter成为刷选，collect 称为规约

        System.out.println(filterJavaBeanList);
        System.out.println(filterJavaBeanList2);
        System.out.println(filterJavaBeanList3);

        List<JavaBean> filterJavaBeanList4 = javaBeans.stream().filter(a -> a.getAge() == 10).collect(Collectors.toList());
        List<JavaBean> filterJavaBeanList5 = javaBeans.stream().filter(a -> a.getAge() <= 10).collect(Collectors.toList());
        System.out.println(filterJavaBeanList4);
        System.out.println(filterJavaBeanList5);

        //  由于 findFirst() 并不是规约函数。
        Optional<JavaBean> optionalJavaBean = javaBeans.stream().filter(a -> a.getAge() > 10).findFirst();

        int age = optionalJavaBean.map(JavaBean::getAge).orElse(-1);
        System.out.println(age);

        //  映射  得到 所有age 的list
        List<Integer> ageList = javaBeans.stream().map(JavaBean::getAge).collect(Collectors.toList());
        List<Integer> ageList2 = javaBeans.stream().map(a -> a.getAge()).collect(Collectors.toList());

        System.out.println(ageList); // [10, 11, 12, 13]


    }

    private static List<JavaBean> filterJavaBeanUseOldVersionJava(List<JavaBean> javaBeans, String filterName) {

        List<JavaBean> javaBeanList = new ArrayList<>();
        for (JavaBean javaBean : javaBeans) {
            if (filterName.equalsIgnoreCase(javaBean.getName())) {
                javaBeanList.add(javaBean);
            }
        }
        return javaBeanList;
    }

    private static List<JavaBean> filterJavaBeanUseOldVersionJava2(List<JavaBean> javaBeans, int age) {

        List<JavaBean> javaBeanList = new ArrayList<>();
        for (JavaBean javaBean : javaBeans) {
            if (age == javaBean.getAge()) {
                javaBeanList.add(javaBean);
            }
        }
        return javaBeanList;
    }


}
