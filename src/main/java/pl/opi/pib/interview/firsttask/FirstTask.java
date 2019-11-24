package pl.opi.pib.interview.firsttask;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FirstTask {

    public static ArrayList<Integer> filterEvenNumbers(ArrayList<Integer> list){
       return list.stream().filter(n -> n%2==0).collect(Collectors.toCollection(ArrayList::new));
    }
}
