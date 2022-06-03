package com.example.phamtruong.haui.weather;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {
    public static String removeAccent(String s) {

        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static String Convert_String(String string){
        string = removeAccent(string);
        String tmp="";
        string = string.toLowerCase();
        for (int i=0;i<string.length();i++){
            if (string.charAt(i)==' '){
                tmp+="%20";
            }
            else {
                tmp+=string.charAt(i);
            }
        }
        return tmp;
    }
}
