import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Collectors;

public class BasicOperations2 {
    public static void sumFirstTenNaturalNos(){
        int sum = 0;
        sum = IntStream.range(1,11).sum();
        System.out.println(sum);
    }
    public static void findCommonElementsBetweenTwoArrays(){
        List<Integer> list1 = Arrays.asList(23,21,25,27,29,32);
        List<Integer> list2 = Arrays.asList(23,20,34,25,35);
        list1.stream().filter(list2::contains).forEach(System.out::println);
    }
    public static void reverseEachWordOfString(){
        String str = "Today is monday";
        String reversedStr = Arrays.stream(str.split(" "))
                .map(word->new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(reversedStr);
    }
    public static void reverseIntegerArray(){
        int[] array = {1,2,3,4,5,6,7};
        int[] revArray = IntStream.rangeClosed(1,array.length)
                .map(num->array[array.length - num]).toArray();
        System.out.println(Arrays.toString(revArray));
    }
    public static void firstTwentyOddNumbers(){
        int[] arr = IntStream.rangeClosed(1,20).map(num ->2*num - 1)
                .toArray();
        System.out.println(Arrays.toString(arr));
    }
    public static void findMostRepeatedElement(){

    }
    static void main() {
        firstTwentyOddNumbers();
//        reverseIntegerArray();
//        sumFirstTenNaturalNos();
//        findCommonElementsBetweenTwoArrays();
//        reverseEachWordOfString();
    }
}
