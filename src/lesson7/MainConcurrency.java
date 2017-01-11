package lesson7;

public class MainConcurrency {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
           /* new Thread() { // or MyClass extends Thread
                @Override
                public void run() {
                    System.out.println(this.getName());
                }
            }.start();*/

           new Thread(new Runnable() {
               @Override
               public void run() {
                   System.out.println(Thread.currentThread().getName());
               }
           }).start();
        }


    }
}
