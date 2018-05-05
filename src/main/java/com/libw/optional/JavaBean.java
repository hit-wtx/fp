package com.libw.optional;
/**
 * Created by:wentuanxu
 * date: 2018/5/5.
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class JavaBean {
    private String name;
    private int age;

    public static boolean isNameValid(String s) {
        return StringUtils.isNotBlank(s) && s.length() >= 10;
    }
}
