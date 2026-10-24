import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasicOperations {
    // Remove duplicate elements from list
    public void removeDuplicateElements(){
        List<Integer> uniqueList = new ArrayList<>();
        Integer[] arr = {2,3,4,5,6,2,3,4,5,7};
        List<Integer> intList = Arrays.asList(arr);
        uniqueList = intList.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    //Maximum in a list
    public static void findMaxElement(){
        Integer maxElem = List.of(23,34,25,27,12,15).stream()
                .max(Comparator.naturalOrder())
                .get();

        System.out.println(maxElem);
    }
    //Minimum in a list
    public static void findMinElement(){
        Integer minElem = List.of(23,34,12,56,30,56)
                .stream()
                .min(Comparator.naturalOrder())
                .get();
        System.out.println(minElem);
    }


    //Frequency of each character in string
    public static void freqEachCharacterInString() {
        String str = "Today is saturday";
        // string to a stream of characters
        str = str.toLowerCase(Locale.ROOT);
        Map<Character,Long> characterFrequency = str.chars()
                .filter(c -> c !=' ')// ignore spaces
                .mapToObj(c->(char)c)
                //group by character and count the frequency
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
// Function.identity() returns a function that always returns its input argument unchanged
        // Display the frequency of each character
        characterFrequency.forEach((character,frequency)
                ->System.out.println(""+ character+ ""+ frequency));
    }

    static void main() {
        findMinElement();
//        findMaxElement();
        //freqEachCharacterInString();
    }
}
