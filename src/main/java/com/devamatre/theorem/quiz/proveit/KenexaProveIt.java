package com.devamatre.theorem.quiz.proveit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-18 06:21:47 PM
 * @since 1.0.0
 */
public class KenexaProveIt {

    static String INIT = "INIt";

    public void question1() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void question2() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        for (Object obj : list) {
            System.out.println(obj);
        }

    }

    void throwIt() throws IOException {
        throw new IOException();
    }

    public void question3() {
        try {
            throwIt();
        } catch (IOException e) {
            System.out.println("Caught it!");
        } finally {
            System.out.println("End");
        }
    }

    public void question4() {
        int val = 2;
        switch (val) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
            default:
                System.out.println("default");
        }

    }

    public void question5() {
        int val = 0;
        for (; ; ) {
            System.out.println(val);
            val = val + 1;
            if (val > 3) {
                break;
            }
        }

    }

    enum Color {
        RED, WHITE, BLUE
    }

    ;

    public void question6() {

    }

    public int calculate(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return calculate(n - 1) + n;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        KenexaProveIt kProveIt = new KenexaProveIt();
        // kProveIt.Question1();
        kProveIt.question2();
        kProveIt.question3();
        kProveIt.question4();
        kProveIt.question5();
        kProveIt.question6();

        Abstract ab = new Abstract();
        ab.method1();

        Interface1 inter = new TestInterface();
        Interface2 inter2 = (Interface2) new TestInterface();
        inter.method1();
        // inter.method2();

        for (Color col : Color.values()) {
            System.out.println(col);
        }
        //
        // short s1 = 1;
        // short s2 = 2;
        // short s3 = s1 + s2;
        // System.out.println(s3);

        int number = 5;
        System.out.println("Sum of all natural numbers before:" + number + "=" + kProveIt.calculate(number));

        // int a = 1;
        // int b = 2;
        // int c = 3;
        //
        // if ((a == 1) | (++b > 1)) {
        // c += b;
        // }
        // System.out.println(c);

        int a = 312;
        int b = 4;
        int c = a >> b;
        System.out.println(c);

        // String myString = "Test123";
        // StringBuffer sb = new StringBuffer("Test123");
        // sb.reverse();
        // System.out.println(sb.toString());

        // String s1 = "Test123";
        // String s2 = "Test123";
        // String s3 = new String("Test123");
        // System.out.println(s1 == s2);
        // System.out.println(s1 == s3);
        // System.out.println(s1.equals(s3));

        StringTokenizer st = new StringTokenizer("Java is fun!");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    static {
        System.out.println(INIT);
        INIT = "hello";
    }
}

abstract class Abstract1 {

    public void method1() {
        System.out.println("Abstract1");
    }
}

abstract class Abstract2 extends Abstract1 {

    public void method1() {
        super.method1();
        System.out.println("Abstract2");
    }
}

class Abstract extends Abstract2 {

    public void method1() {
        super.method1();
        System.out.println("Abstract");
    }
}

interface Interface1 {

    public void method1();
}

interface Interface2 {

    public void method2();
}

class TestInterface implements Interface1, Interface2 {

    public void method1() {
    }

    public void method2() {
    }
}
