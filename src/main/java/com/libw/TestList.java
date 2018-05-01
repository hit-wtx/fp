package com.libw;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by:wentuanxu
 * date: 2018/4/29.
 */

public class TestList {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 6, 5, 4);
        integerList.sort(Comparator.naturalOrder());
        System.out.println(integerList);
        integerList.sort(Comparator.reverseOrder());
        System.out.println(integerList);

        Pair<String, String> strStrPair = Pair.of("hello", "world");
        System.out.println(strStrPair.getLeft());
        System.out.println(strStrPair.getRight());
    }
}
