package lesson7;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Недостаток Date - не Thread safe
        System.out.println(new Date()); // полная текущая дата
        System.out.println(new Date(Long.MAX_VALUE)); // когда закончится дата
        System.out.println(new Date().getTime()); // мс с 1970
        System.out.println(System.currentTimeMillis()); // мс с 1970

    }
}
