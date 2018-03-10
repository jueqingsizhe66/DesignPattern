package WithDecorate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestReadOnlyListNew {
    static List<String> getData()
    {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("123");
        list.add("f708");
        list.add("ncepu");
        list.add("qq");
        return new ReadOnlyListNew<>(list);
    }

    public static void main(String[] args) {

        List<String> list = getData();

       Iterator<String> it = list.iterator();
        for (String s : list) {
            System.out.println(s);
        }
        //it.next();
        //it.remove();

        System.out.println("By new Iterator*******************************");
       Iterator<String> it1 = it;
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }


    }

}
