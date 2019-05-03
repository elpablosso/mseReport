package interfaces;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Greeter implements Runnable{

    private int count;
    private String name;

    public Greeter(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public static void runInOrder(Runnable...tasks){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for(Runnable task : tasks) {
            executorService.submit(task);
        }
    }

    public static void runTogether(Runnable...tasks){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(Runnable task : tasks) {
            executorService.submit(task);
        }
    }

    public static Runnable runAllTasks(Runnable...tasks){
        return () -> {
            for(Runnable task : tasks){
                task.run();
            }
        };
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++){
            System.out.println(i+1+":Hello "+name);
        }
    }
}
