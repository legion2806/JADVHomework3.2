import java.util.concurrent.atomic.LongAdder;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        LongAdder countDay = new LongAdder();

        Shop shop1 = new Shop(countDay);
        Shop shop2 = new Shop(countDay);
        Shop shop3 = new Shop(countDay);

        Thread thread1 = new Thread(null, shop1::calculate, "Номер 1");
        Thread thread2 = new Thread(null, shop2::calculate, "Номер 2");
        Thread thread3 = new Thread(null, shop3::calculate, "Номер 3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.printf("Итоговая сумма состовляет %d руб.\n", countDay.sum());

    }
}