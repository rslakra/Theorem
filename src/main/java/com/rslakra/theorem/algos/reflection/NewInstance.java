/**
 *
 */
package com.rslakra.theorem.algos.reflection;

/**
 * @author Rohtash Lakra
 */
public class NewInstance {

    public void sayHello() {
        System.out.println("Hello, Main!");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Class<?> klass = NewInstance.class;
        NewInstance mainObject = null;
        try {
            mainObject = (NewInstance) klass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (mainObject != null) {
            System.out.println(mainObject);
            mainObject.sayHello();
        }
    }

}
