import java.util.Arrays;
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

        System.out.println("====1");

        IntStream intStream = persons.peek(System.out::println)
                .map((Person p) -> p.getAge())
                .peek((a) -> {
                    System.out.println(a + " " + Thread.currentThread().getName());
                })
                .filter((Integer age) -> age > 25)
                .peek(System.out::println)
                .flatMapToInt((Integer age) -> IntStream.of(age))
                .peek(System.out::println);

        System.out.println("====2");

        intStream.average().ifPresent(System.out::println);

        //System.out.println(intStream.average().getAsDouble());
    }
}