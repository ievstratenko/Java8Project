import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class Runner {

    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2016-07-22");

        LocalTime time = LocalTime.of(12, 59, 55, 222);

        LocalDateTime dateTime = LocalDateTime.MAX;
        System.out.println(dateTime);

        Instant instant = Instant.now();

        Clock clock = Clock.systemUTC();

        ZonedDateTime zdt = ZonedDateTime.of(date, time, ZoneId.of("America/Los_Angeles"));

        Duration duration = Duration.between(Instant.now(), zdt);
        System.out.println(duration.toMillis());

        Period period = Period.between(LocalDate.now(), date);
        System.out.println(period);

        System.out.println(date.with(
                TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY)));
    }
}