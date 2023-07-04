package HomeWork5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s1 = "firefox";
        System.out.println(s1.toUpperCase()); // виведе«FIREFOX»
        String s2 = s1.replace('o', 'a');
        System.out.println(s2); // виведе «firefax»
        System.out.println(s2.charAt(1)); // виведе «i»
        int i;
        i = s1.length();
        System.out.println(i); // виведе 7
        i = s1.indexOf('f');
        System.out.println(i); // виведе 0
        i = s1.indexOf('r');
        System.out.println(i); // виведе 2
        i = s1.lastIndexOf('f');
        System.out.println(i); // виведе 4
        i = s1.indexOf('t');
        System.out.println(i); // виведе -1
        i = s1.indexOf('r',3);
        System.out.println(i); // виведе -1
    }
}

