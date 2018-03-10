import java.util.Calendar;
import java.util.Date;

public class TestAdapter {

    static void printPerson(Person p) {
        System.out.println("大家好，我是" + p.getName() + ",我的年龄是" + p.getAge());
    }

    static Person toPerson(Student s) {
        Person p = new Person();
        p.setId(s.getId());
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(s.getBirtyDate());

        Calendar endDate = Calendar.getInstance();
        endDate.setTime(new Date(System.currentTimeMillis()));

        long age = endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR);
        p.setAge((int) age);
        p.setName(s.getXing() + s.getMing());
        return p;
    }
    public static void main(String[] args) {
        /*
       如果需要将“一些现存的对象”放在新的环境中应用，但是新环境要求的接口是这些现存对象所不满足的。那么就可以创建一个适配器让旧对象适用于新环境

       Student是新环境   Person是旧环境
         */
        Student s = new Student();
        s.setId(1);

        Calendar cal = Calendar.getInstance();
        cal.set(1993, 3, 3);
        s.setBirtyDate(cal.getTime());
        s.setXing("杨");
        s.setMing("小帅");

        printPerson(toPerson(s));




    }
}
