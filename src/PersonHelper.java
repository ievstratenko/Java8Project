import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersonHelper {
    static List<Person> getPersons() {
        Person person1 = new Person("Tom", 55, null, Collections.emptyList());
        Person person2 = new Person("Sara", 21, person1, Collections.emptyList());
        Person person3 = new Person("Peter", 23, person1, Collections.emptyList());
        Person person4 = new Person("Mike", 45, null, Collections.emptyList());
        Person person5 = new Person("Matt", 27, person4,
                Arrays.asList(person2, person3));
        Person person6 = new Person("Billy", 30, person4,
                Arrays.asList(person3, person5));
        return Arrays.asList(person1, person2, person3, person4, person5, person6);
    }

    ;
}
