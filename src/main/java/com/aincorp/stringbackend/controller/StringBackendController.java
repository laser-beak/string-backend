package com.aincorp.stringbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

@RestController
public class StringBackendController {

    @RequestMapping("/reverse")
    @ResponseBody
    public String reverse(@RequestParam(value = "stringParam") String stringParam) {
        return new StringBuilder(stringParam).reverse().toString();
    }

    @RequestMapping("/palindrome")
    @ResponseBody
    public Boolean palindrome(@RequestParam(value = "stringParam") String stringParam) {

        int n = stringParam.length();

        for (int i = 0; i < (n / 2); ++i) {
            if (stringParam.charAt(i) != stringParam.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    @RequestMapping("/substring")
    @ResponseBody
    public String substring(@RequestParam(value = "stringParam") String stringParam) {

        List<String> variants = new ArrayList<>();
        String substring = "";

        char[] chars = stringParam.toCharArray();

        int i = 0;

        while (i < chars.length - 1) {
            if ((chars[i] != chars[i + 1]) && (!substring.contains(String.valueOf(chars[i + 1])))) {
                substring += chars[i];

            } else {
                substring += chars[i];
                variants.add(substring);
                substring = "";
            }
            i++;
        }

        if (i == chars.length - 1) {
            substring += chars[i];
            variants.add(substring);
        }

        List<Integer> lengths = new ArrayList<>();

        for (String s : variants) {
            lengths.add(s.length());
        }

        int maxIndex = IntStream.range(0, lengths.size()).boxed()
                .max(comparingInt(lengths::get))
                .get();

        return variants.get(maxIndex);
    }
}
