import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Map;

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

    //Frequency of each character in string
    public void freqEachCharacterInString() {
        String str = "Today is saturday";
        // string to a stream of characters
        Map<Character,Long> characterFrequency = str.chars()
                .filter(c -> c !=' ')// ignore spaces
                .mapToObj(c->(char)c)
                //group by character and count the frequency
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }
}
