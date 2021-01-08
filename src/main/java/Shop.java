import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {

    private LongAdder countDay;

    public Shop(LongAdder summaDay) {
        this.countDay = summaDay;
    }

    private static int size = 5_000;
    private static int[] array = new int[size];

    public void calculate() {
        int count = 0;
        int max = 100_000;
        int min = 1;
        try {
            for (int i = 0; i < (size); i++) {
                Random random = new Random();
                array[i] = random.nextInt(max - min) + min;
                count += array[i];
            }
            countDay.add(count);
            System.out.printf("Выручка из магазина %s состовляет %d руб.\n", Thread.currentThread().getName(), count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
