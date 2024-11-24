/**
 *
 */
package com.rslakra.theorem.algos.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Rohtash Lakra
 * @verion 1.0.0 Mar 4, 2019 12:39:28 PM
 */
public class ReadPersons {

    private final String filePath;

    /**
     * @param filePath
     */
    public ReadPersons(String filePath) {
        this.filePath = filePath;
    }

    private class Person {

        private String name;
        private int age;
        private String city;

        Person(String name, int age, String city) {
            this.name = name;
            this.age = age;
            this.city = city;
        }

        /**
         * (non-Javadoc)
         *
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "[" + name + ", " + age + ", " + city + "]";
        }
    }

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @Created Mar 4, 2019 12:45:20 PM
     */
    private class PersonSpliterator implements Spliterator<Person> {

        private final Spliterator<String> lineSpliterator;
        private String name;
        private int age;
        private String city;

        /**
         * @param lineSpliterator
         */
        public PersonSpliterator(Spliterator<String> lineSpliterator) {
            this.lineSpliterator = lineSpliterator;
        }

        /**
         * (non-Javadoc)
         *
         * @see java.util.Spliterator#tryAdvance(java.util.function.Consumer)
         */
        @Override
        public boolean tryAdvance(Consumer<? super Person> action) {
            if (lineSpliterator.tryAdvance(line -> name = line) && lineSpliterator.tryAdvance(
                line -> age = Integer.parseInt(line)) && lineSpliterator.tryAdvance(line -> city = line)) {
                action.accept(new Person(name, age, city));
                return true;
            }

            return false;
        }

        /**
         * (non-Javadoc)
         *
         * @see java.util.Spliterator#trySplit()
         */
        @Override
        public Spliterator<Person> trySplit() {
            return null;
        }

        /**
         * (non-Javadoc)
         *
         * @see java.util.Spliterator#estimateSize()
         */
        @Override
        public long estimateSize() {
            return lineSpliterator.estimateSize() / 3;
        }

        /**
         * (non-Javadoc)
         *
         * @see java.util.Spliterator#characteristics()
         */
        @Override
        public int characteristics() {
            return lineSpliterator.characteristics();
        }

    }

    public void printResults() {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path);) {
            Spliterator<String> lineSpliterator = lines.spliterator();
            Spliterator<Person> personSpliterator = new PersonSpliterator(lineSpliterator);
            Stream<Person> persons = StreamSupport.stream(personSpliterator, false);
            persons.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ReadPersons readPersons = new ReadPersons("/Users/lakra/Downloads/Persons.txt");
        readPersons.printResults();
    }

}
