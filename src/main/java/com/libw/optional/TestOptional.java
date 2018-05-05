package com.libw.optional;
/**
 * Created by:wentuanxu
 * date: 2018/5/5.
 */

import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@ToString
public class TestOptional {
    public static void main(String[] args) {
        JavaBean javaBean = new JavaBean("wtx", 28);
        System.out.println(getName(javaBean));

        setJavaBeanName(javaBean, "wtx");
    }


    public static String getName1(JavaBean javaBean) {
        if (javaBean != null) {
            String name = javaBean.getName();
            if (StringUtils.isNotBlank(name)) {
                return name;
            }
        }
        return "unknown";
    }

    public static String getName2(JavaBean javaBean) {
        Optional<JavaBean> javaBeanOptional = Optional.ofNullable(javaBean);
        if (!javaBeanOptional.isPresent()) {
            return "unknown";
        }
        return javaBeanOptional.get().getName();
    }

    public static String getName(JavaBean javaBean) {
        return Optional.ofNullable(javaBean).map(user -> user.getName()).orElse("unknown");
    }

    public static void setJavaBeanName(JavaBean javaBean, String name) throws IllegalArgumentException {
        String resultName = Optional.ofNullable(name).filter(JavaBean::isNameValid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username."));
        javaBean.setName(resultName);
    }

}
