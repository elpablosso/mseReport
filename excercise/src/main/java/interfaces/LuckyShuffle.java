package interfaces;

import java.util.*;
public class LuckyShuffle {

    ArrayList<String> stringList;
    Comparator<String> stringComparator;

    public LuckyShuffle() {
        this.stringList = new ArrayList<>(Arrays.asList("Cebulak","Bet","Alin","Halka"));
        this.stringComparator = Comparator.comparingInt(String::length);
    }

    void luckySort(ArrayList<String> strings , Comparator<String> comparator){

        ArrayList<String> sortedList = new ArrayList<>(strings);
        sortedList.sort(comparator);

        if(strings.equals(sortedList)) System.out.println("EQUALS!");

        do{
            System.out.println("SHUFFLIN");
            Collections.shuffle(strings);}
        while(!strings.equals(sortedList)) ;

    }

}
