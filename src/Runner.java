import java.util.concurrent.*;
import java.util.function.Supplier;

public class Runner {
    static int result;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<Integer> cf1 = CompletableFuture
                .supplyAsync(Runner::calculate)
                .thenApply(Runner::increment);
        CompletableFuture<Integer> cf2 = CompletableFuture
                .supplyAsync(Runner::calculate)
                .thenApply(Runner::increment);
        CompletableFuture<Integer> cf3 = cf1.thenCombine(cf2, (r1, r2) -> r1 + r2);

        p("result=" + cf3.get());
        p(cf1.get());

        long duration = System.currentTimeMillis() - start;


        p("duration=" + duration);
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

    static Integer increment(Integer i) {
        p("calculate start. i=" + i);
        try {
            i++;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p("calculate finish. i=" + i);
        return i;
    }

    static void p(Object o) {
        System.out.printf("%s %5.0f %s \n", Thread.currentThread().getName(),
                System.currentTimeMillis() % 1e5, o);
    }
}