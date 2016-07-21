import java.util.List;
import java.util.Optional;

public class Runner {

    public static void main(String[] args) {
        List<Person> persons = PersonHelper.getPersons();
        Person person = persons.get(1);

        Optional<Person> personOpt = Optional.of(person);
        String bossName = personOpt.map(p -> p.getBoss())
                .map(b -> b.getName()).orElse("no_name");
        System.out.println(bossName);
    }
}