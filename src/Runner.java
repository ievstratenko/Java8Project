import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Runner {
    public static void main(String[] args) {
        String[] words = {"Test", "lol", "abcde", "XYZ", "123"};
        boolean lower = false;
        Function<String, String> toLowerCase = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        };
        Function<String, String> toUpperCase = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        Function<String, String> f = lower ? toLowerCase : toUpperCase;
        for (int i = 0; i < words.length; i++) {
            words[i] = f.apply(words[i]);
        }
        System.out.println(Arrays.toString(words));

    }
}
