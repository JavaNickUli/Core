package uli.nick.ylab.taskstwo.task1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
import static uli.nick.ylab.taskstwo.task1.ComplexExamples.*;

class ComplexExamplesTest {

    @Test
    void mainTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        main(null);

        String actualStream = out.toString();
        String expected = String.join("",
                "Raw data:",
                "0 - Harry",
                "0 - Harry",
                "1 - Harry",
                "2 - Harry",
                "3 - Emily",
                "4 - Jack",
                "4 - Jack",
                "5 - Amelia",
                "5 - Amelia",
                "6 - Amelia",
                "7 - Amelia",
                "8 - Amelia",
                "**************************************************",
                "Duplicate filtered, grouped by name, sorted by name and id:",
                "Key: Amelia",
                "Value: 4",
                "Key: Emily",
                "Value: 1",
                "Key: Harry",
                "Value: 3",
                "Key: Jack",
                "Value: 1");

        then(actualStream).containsIgnoringWhitespaces(expected);
    }

    @Test
    void sortedDataTest0() {
        Person[] testArray = new Person[]{
                new Person(0, "Harry"),
                new Person(0, "Harry"),
                new Person(1, "Harry"),
                new Person(2, "Harry"),
                new Person(3, "Emily"),
                new Person(4, "Jack"),
                new Person(4, "Jack"),
                new Person(5, "Amelia"),
                new Person(5, "Amelia"),
                new Person(6, "Amelia"),
                new Person(7, "Amelia"),
                new Person(8, "Amelia")
        };

        Map<String, List<Integer>> actualStream = processedDataByStream(testArray);
        Map<String, List<Integer>> actual = processedData(testArray);
        Map<String, List<Integer>> expected = new LinkedHashMap<>();
        expected.put("Amelia", List.of(5, 6, 7, 8));
        expected.put("Emily", List.of(3));
        expected.put("Harry", List.of(0, 1, 2));
        expected.put("Jack", List.of(4));

        then(actualStream).containsAllEntriesOf(expected);
        then(actual).containsAllEntriesOf(expected);
    }

    @Test
    void sortedDataTest1() {
        Person[] testArray = new Person[]{
                new Person(8, "Harry"),
                new Person(8, "Harry"),
                new Person(7, "Harry"),
                new Person(6, "Harry"),
                new Person(5, "Emily"),
                new Person(4, "Jack"),
                new Person(4, "Jack"),
                new Person(3, "Amelia"),
                new Person(2, "Amelia"),
                new Person(1, "Amelia"),
                new Person(0, "Amelia"),
                new Person(0, "Amelia")
        };

        Map<String, List<Integer>> actualStream = processedDataByStream(testArray);
        Map<String, List<Integer>> actual = processedData(testArray);
        Map<String, List<Integer>> expected = new LinkedHashMap<>();
        expected.put("Amelia", List.of(0, 1, 2, 3));
        expected.put("Emily", List.of(5));
        expected.put("Harry", List.of(6, 7, 8));
        expected.put("Jack", List.of(4));

        then(actualStream).containsAllEntriesOf(expected);
        then(actual).containsAllEntriesOf(expected);
    }

    @Test
    void sortedDataTest2() {
        Person[] testArray = new Person[]{
                new Person(8, "Harry"),
                new Person(8, "Harry"),
                new Person(7, "Harry"),
                new Person(6, "Harry"),
                null,
                new Person(5, "Emily"),
                new Person(4, "Jack"),
                new Person(4, "Jack"),
                new Person(3, "Amelia"),
                new Person(2, "Amelia"),
                new Person(1, "Amelia"),
                null,
                new Person(0, "Amelia"),
                new Person(0, "Amelia")
        };

        Map<String, List<Integer>> actualStream = processedDataByStream(testArray);
        Map<String, List<Integer>> actual = processedData(testArray);
        Map<String, List<Integer>> expected = new LinkedHashMap<>();
        expected.put("Amelia", List.of(0, 1, 2, 3));
        expected.put("Emily", List.of(5));
        expected.put("Harry", List.of(6, 7, 8));
        expected.put("Jack", List.of(4));

        then(actualStream).containsAllEntriesOf(expected);
        then(actual).containsAllEntriesOf(expected);
    }

    @Test
    void sortedDataTest3() {
        Person[] testArray = new Person[]{
                new Person(3, "Amelia"),
                new Person(3, "Amelia"),
                new Person(3, "Amelia"),
                new Person(3, "Amelia"),
                new Person(3, "Amelia")
        };

        Map<String, List<Integer>> actualStream = processedDataByStream(testArray);
        Map<String, List<Integer>> actual = processedData(testArray);
        Map<String, List<Integer>> expected = new LinkedHashMap<>();
        expected.put("Amelia", List.of(3));

        then(actualStream).containsAllEntriesOf(expected);
        then(actual).containsAllEntriesOf(expected);
    }

    @Test
    void sortedDataTest4() {
        Person[] testArray = new Person[]{null};

        Map<String, List<Integer>> actualStream = processedDataByStream(testArray);
        Map<String, List<Integer>> actual = processedData(testArray);
        Map<String, List<Integer>> expected = new LinkedHashMap<>();

        then(actualStream).containsAllEntriesOf(expected);
        then(actual).containsAllEntriesOf(expected);
    }

    @Test
    void sortedDataTest5() {
        Person[] testArray = null;

        Map<String, List<Integer>> actualStream = processedDataByStream(testArray);
        Map<String, List<Integer>> actual = processedData(testArray);
        Map<String, List<Integer>> expected = new LinkedHashMap<>();

        then(actualStream).containsAllEntriesOf(expected);
        then(actual).containsAllEntriesOf(expected);
    }
}