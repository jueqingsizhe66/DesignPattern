import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestInt {

    public static void main(String[] args) {
       int[]  nums = {3,5,6,7};
        Integer[]  nums1 = {3,5,6,7};
       //test1(nums);  error
        test1(toList(nums));
        test1(Arrays.asList(nums1)); //只支持包装类  asList 按理说支持从int到Integer
        //test1(Arrays.asList(nums)); //error 包装类不顶用

    }


    static List<Integer> toList(int[] values){

        List<Integer> list = new LinkedList<>();
        for (int value : values) {
            list.add(value);
        }
        return list;
    }


    static void test1(List<Integer> items)
    {
        for (Integer item : items) {
            System.out.println(item);
        }
    }
}
