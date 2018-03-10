import java.util.Iterator;
import java.util.LinkedList;

public class testIterator {
    public static void main(String[] args) {
        LinkedList<String> listApple = new LinkedList<>();

        listApple.add("fu");
        listApple.add("tu");
        listApple.add("su");
        listApple.add("hu");

        Iterable<String> it1 =listApple;
        Iterator<String> iterator1 = it1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        for (String s : listApple) {
            System.out.println(s);
        }
    }
}
