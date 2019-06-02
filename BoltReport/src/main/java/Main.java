import fastener.Fastener;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Pablo\\IdeaProjects\\BoltReport\\src\\main\\resources\\bolt.xsr")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("boltDone.txt")))){
        List<Fastener> fasteners = reader.lines().map((String word)-> word.replace(" ",""))
                .map((String word)-> word.split(";")).map(Fastener::instanceBy).collect(Collectors.toList());


        Results results = new Results(fasteners);
        List<Fastener> finalList = results.getResoults();

        finalList.sort(Comparator.comparingInt(Fastener::sortNumber));

        for(Fastener fastener : finalList){
            writer.write(fastener.toString());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}