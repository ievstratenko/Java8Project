public class Runner {

    public static void main(String[] args) throws Exception {
        p("START");
        int result = calculate();
        p(result);
    }

    static Integer calculate() throws InterruptedException {
        p("calculate start");
        Thread.sleep(1000);
        p("calculate finish");
        return 1;
    }

    static void p(Object o) {
        System.out.printf("%s %5.0f %s \n", Thread.currentThread().getName(),
                System.currentTimeMillis() % 1e5, o);
    }
}