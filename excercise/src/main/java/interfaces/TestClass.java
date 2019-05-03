package interfaces;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class TestClass {

    public static void main(String[] args) throws IOException {

        Employee[] employees = {
                new Employee("Marecki", 100),
                new Employee("Jarecki", 200),
                new Employee("Muniak", 300)
        };

        Greeter greeter = new Greeter(100, "Pablo");
        Greeter greeter1 = new Greeter(50,"Linda");

        Runnable task = Greeter.runAllTasks(greeter,greeter1);

        Thread thread = new Thread(task);
        thread.start();


        File file = new File("C:\\Users\\Pablo\\Desktop\\JavaRzeczy");

        File[] allFiles = Objects.requireNonNull(file.listFiles());
        File[] folders = Objects.requireNonNull(file.listFiles(File::isDirectory));
        File[] txtFiles = Objects.requireNonNull(file.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt")));

        Arrays.sort(allFiles, Comparator.comparing(File::isDirectory, Comparator.reverseOrder())
                .thenComparing(File::getName , String.CASE_INSENSITIVE_ORDER));


        for(File file1 : allFiles){
            System.out.println(file1.getName());
        }
    }
}
