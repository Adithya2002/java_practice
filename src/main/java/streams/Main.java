package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        List<Integer> singles = Arrays.asList(1, 2, 3, 4);
        List<Integer> doubles = singles.stream().map(x -> x * 2).collect(Collectors.toList());

        // via anonymous class
        List<Integer> checkIfEven = singles.stream().filter(new Predicate<Integer>(){
            @Override
            public boolean test(Integer integer) {
                if(integer%2==0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }).collect(Collectors.toList());

        //squaring and sorting numbers
        List<Integer> numbers = Arrays.asList(3,4,2,1,7);
        System.out.println(numbers.stream().map(x -> x*x).sorted().collect(Collectors.toList()));

        //summing values
        List<Integer> sums = Arrays.asList(10,20,30,40);
        System.out.println(sums.stream().reduce((result,element) -> result+=element ).get());
    }
}
