package uli.nick.ylab.taskstwo.task1;

import java.util.*;

import static java.util.stream.Collectors.*;

public class ComplexExamples {

    record Person(int id, String name) {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return id() == person.id() && name().equals(person.name());
        }

        @Override
        public int hashCode() {
            return Objects.hash(id(), name());
        }

        public static int compare(Person o1, Person o2) {
            if (o1 == null || o2 == null) {
                return o1 == o2
                        ? 0
                        : o1 == null ? 1 : -1;
            }
            int compare = o1.name().compareTo(o2.name());
            return compare != 0 ? compare : Integer.compare(o1.id(), o2.id());
        }
    }

    private static final Person[] RAW_DATA = new Person[]{
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
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        System.out.println("Raw data:\n");

        for (Person person : RAW_DATA) {
            System.out.println(person.id() + " - " + person.name());
        }

        System.out.println("\n**************************************************\n");
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:\n");

        processedDataByStream(RAW_DATA)
                .forEach((k, v) -> System.out.println("Key: " + k + "\nValue: " + v.size()));
    }

    public static Map<String, List<Integer>> processedDataByStream(Person[] persons) {
        if (persons == null || persons.length == 0) {
            return Collections.emptyMap();
        }

        return Arrays.stream(persons)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Person::compare)
                .collect(groupingBy(Person::name, LinkedHashMap::new, mapping(Person::id, toList())));
    }


    public static Map<String, List<Integer>> processedData(Person[] persons) {
        if (persons == null || persons.length == 0) {
            return Collections.emptyMap();
        }

        Arrays.sort(persons, Person::compare);
        Map<String, List<Integer>> sortedData = new LinkedHashMap<>();

        for (Person person : persons) {
            if (person != null) {
                sortedData.merge(person.name(), new ArrayList<>(List.of(person.id())), (prev, next) -> {
                            if (!prev.contains(person.id)) {
                                prev.addAll(next);
                            }
                            return prev;
                        }
                );
            }
        }

        return sortedData;
    }
}
