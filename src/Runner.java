import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    static int result;

    public static void main(String[] args) throws Exception {
        p("START");
        Callable<Integer> task = Runner::calculate;
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> future = es.submit(task);

        p("some another task running...");

        result = future.get();
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