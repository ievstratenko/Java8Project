import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
//        System.out.println(isNotEmpty.test(""));

        Function<String, Integer> length = String::length;
//        System.out.println(length.apply("abcd"));

        Stream<Object> numbers = Stream.of(1, 4, 2, "a");

        String[] words = {"abc", "XYZ", "test", "ABC", "123456"};
        Stream<String> wordsStream = Arrays.stream(words);

        Stream<Double> doubleStream = Stream.generate(() -> Math.random()).limit(10);

        Stream<Person> persons = PersonHelper.getPersons().parallelStream();

        Consumer<Object> so = System.out::println;

        IntStream intStream = persons
                .map((Person p) -> p.getAge())
                .filter((Integer age) -> age > 25)
                .flatMapToInt((Integer age) -> IntStream.of(age));

        intStream.average().ifPresent(System.out::println);

        Function<Person, Stream<Person>> flatMapF = p -> p.getFriends().stream();
        PersonHelper.getPersons().stream().flatMap(flatMapF)
                .distinct()
                .forEach(so);

    }
}