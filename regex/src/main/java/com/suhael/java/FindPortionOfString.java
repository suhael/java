package com.suhael.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPortionOfString {

    public String returnMatchingString(String input) {
        Pattern pattern = Pattern.compile("\\(Internal Code:(.+?)\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            return matcher.group(1).trim();
        }
        return "";
    }
}
