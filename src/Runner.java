import java.util.concurrent.*;
import java.util.function.Supplier;

public class Runner {
    static int result;

    public static void main(String[] args) throws Exception {
        p("START");
        Supplier<Integer> task = Runner::calculate;
        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(task)
                .thenAccept(Runner::p)
                .thenRun(() -> p("done"));

        p("some another task running...");

        cf.get();
        p(result);
    }

    static Integer calculate() {
        p("calculate start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p("calculate finish");
        return 1;
    }

    static void p(Object o) {
        System.out.printf("%s %5.0f %s \n", Thread.currentThread().getName(),
                System.currentTimeMillis() % 1e5, o);
    }
}