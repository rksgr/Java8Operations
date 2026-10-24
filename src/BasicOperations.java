import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    // sort the elements of a list
    static void sortListElements(){
        List.of(23,14,45,23,54,42,20)
                .stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
    // find duplicate elements from an array
    static void findDuplicateElements(){
        Set<Integer> intSet = new HashSet<>();
        Set<Integer> dupSet =
                List.of(23,45,23,34,46,56,34)
                        .stream()
                        .filter(num -> !intSet.add(num))
                        .collect(Collectors.toSet());
        System.out.println(dupSet);
    }
    // sort the elements of a list in reverse order
    static void sortInReverseOrder(){
        List<Integer> revSorted = List.of(23,12,11,14,24,25)
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(revSorted);
    }
    static void maximumOccurringCharacterInString(){
        String str = "Tomorrow is sunday";
        Map.Entry<Character,Long> map =
                str.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
        System.out.println(map);
    }
    // Merge two unsorted arrays into a single sorted array
    static void mergeUnsortedArrays(){
        int[] arrA = {1,2,3,40,5};
        int[] arrB = {4,7,9,8};
        int[] mergedArr = IntStream.concat(Arrays.stream(arrA), Arrays.stream(arrB))
                .sorted().toArray();
        System.out.println(Arrays.toString(mergedArr));
    }
    // merge two unsorted arrays into a single sorted array without duplicates
    static void mergeUnsortedArrayD(){
        int[] arrA = {1,3,5,7,5};
        int[] arrB = {2,4,6,8,7};
        int[] mergedArr = IntStream.concat(Arrays.stream(arrA), Arrays.stream(arrB))
                .sorted()
                .distinct()
                .toArray();
        System.out.println(Arrays.toString(mergedArr));
    }
    // minimum three numbers in a list
    static void minThreeNums(){
        List.of(23,24,12,4,6,46,55)
                .stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }
    // Maximum three numbers in a list
    static void maxThreeNums(){
        List.of(23,35,46,75,83,12,29,77)
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }
    // To check if two strings are anagrams or not
    static void checkIfAnagrams(){
        String s1 = "RaceCar";
        String s2 = "CarRace1";
        s1= Stream.of(s1.split(""))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining());
        //Collectors.joining() concatenates all stream elements into a single string
        s2 = Stream.of(s2.split(""))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining());
        if(s1.equals(s2)){
            System.out.println("Two strings are anagrams");
        }else{
            System.out.println("Two strings are not anagrams.");
        }
    }
// Sum of all the digits of a number
    static void sumDigits(){
        int num = 235;
        int sum = Stream.of(String.valueOf(num).split(""))
                .collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sum);
    }
//   find the second-largest number in an array
    static void secondLargestNum(){
        Integer[] numArr={23,34,12,43,48,22};
        Integer secLargestNum = Arrays.asList(numArr)
                .stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(secLargestNum);
    }
    // sort strings according to increasing order of their length
    static void sortOrderLength(){
        String[] strArr = {"Java", "Python","c++","Fortran"};
        Arrays.asList(strArr)
                .stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
    static void main() {
//        sortOrderLength();
//        secondLargestNum();
//        sumDigits();
//        checkIfAnagrams();
        maxThreeNums();
//        mergeUnsortedArrayD();
//        mergeUnsortedArrays();
        maximumOccurringCharacterInString();
//        sortInReverseOrder();
//        findDuplicateElements();
//        sortListElements();
//        findMinElement();
//        findMaxElement();
        //freqEachCharacterInString();
    }
}
