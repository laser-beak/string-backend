package com.aincorp.stringbackend.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "api/v1")
public class StringBackendController {

    @RequestMapping(value = "/reverse")
    @ResponseBody
    @ApiOperation("Разворачивает строку переданную в параметре")
    public String reverse(@RequestParam(value = "stringParam") String stringParam) {
        return new StringBuilder(stringParam).reverse().toString();
    }

    @RequestMapping(value = "/palindrome")
    @ResponseBody
    @ApiOperation("Является ли строка полиндромом")
    public Boolean palindrome(@RequestParam(value = "stringParam") String stringParam) {

        int n = stringParam.length();

        for (int i = 0; i < (n / 2); ++i) {
            if (stringParam.charAt(i) != stringParam.charAt(n - i - 1)) {
                return false;
            }
        }

        return true;
    }

    @RequestMapping(value = "/substring")
    @ResponseBody
    @ApiOperation("Длинна самой длинной подстроки из строки переданной в параметре")
    public Integer substring(@RequestParam(value = "stringParam") String stringParam) {
        int result;

        Set<String> substringSet = new HashSet<>();

        StringBuilder concatenation = new StringBuilder();

        for (int i = 0; i < stringParam.length(); i++) {
            concatenation.append(stringParam.charAt(i));

            for (int j = i + 1; j < stringParam.length(); j++) {
                if (!concatenation.toString().contains(String.valueOf(stringParam.charAt(j)))) {
                    concatenation.append(stringParam.charAt(j));
                } else {
                    break;
                }
            }
            substringSet.add(concatenation.toString());
            concatenation = new StringBuilder();
        }

        int max = 0;
        for (String str : substringSet) {
            if (max <= str.length()) {
                max = str.length();
            }
        }
        result = max;

        return result;
    }
}
