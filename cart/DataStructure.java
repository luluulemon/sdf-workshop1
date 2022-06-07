package cart;
import java.util.*;

public class DataStructure {
    
    public static void main(String[] args){
        
        List<Integer> intList = new LinkedList<Integer>();

        intList.add(Integer.parseInt("12"));
        intList.add(99);
        intList.add(20);
        intList.add(1, 69);

        System.out.println(intList);

    }
    
}
