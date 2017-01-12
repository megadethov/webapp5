package lesson0.debug;

public class Main {
    public static void main(String[] args) {
        double xd;
        double y1 = 10;
        double x1 = 3;
        double y2 = 12;
        double x2 = 5;
        double x = 4;
        double resSum = Util.sum(y1, x1, y2, x2);
        System.out.println("sum = " + resSum );

        y2 = 13;
        resSum = Util.sum(y1, x1, y2, x2);
        System.out.println("sum = " + resSum );

        double a = 100.0;
        double b = 200.0;
        double resMulti = Util.multi(a, b);
        System.out.println("multi = " + resMulti);

        int[] testArray = {1, 2, 3, 4, 5, 6};
        double testResult = 0;
        for (int i :testArray) {
//            testResult = i / (i - 4);
            System.out.println("i = " + i);
            System.out.println("test result is " + testResult);
            System.out.println("work");
        }


    }
}
