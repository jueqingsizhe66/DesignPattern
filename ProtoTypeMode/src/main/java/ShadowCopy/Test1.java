package ShadowCopy;

/**
 * 单个对象没有深浅靠拷贝之说法，只有在组合模式下才有效！！
 */
/**
 *  当没有关联时候，谈不了深浅
 *
 *  比如一个人牵着一条狗
 *
 *  你现在复制一个人，关联对象公用
 *
 *  如果你现在复制一个人，同时也复制狗，就是深拷贝
 */

/**
 *  默认JDK提供了深拷贝clone, 必须实现clonable接口
 */
public class Test1 {

    public static void main(String[] args) {

        Person p1  = new Person();
        Cat ca = new Cat();
        ca.setName("mao");

        p1.setName("zhang");
        p1.setHeight(171);
        p1.setCa(ca);


        Person p2 = shadowCopy(p1);
        System.out.println("人一样= "+(p2==p1));
        System.out.println("关联物一样=="+(p2.getCa()== p1.getCa())); //== 判断是否同一对象


        Person p3 = deepCopy(p1);
//        System.out.println(p3.getCa()==p1.getCa());//新对象了
        System.out.println("人一样= "+(p3==p1));
        System.out.println("关联物不一样=="+(p3.getCa()== p1.getCa())); //== 判断是否同一对象
    }

    public static Person shadowCopy(Person p)
    {
        Person p1= new Person();
        p1.setCa(p.getCa());
        p1.setHeight(p.getHeight());
        p1.setName(p.getName());
        return p1;
    }
    public static  Person deepCopy(Person p)
    {
        Person p1 =new Person();

        Cat caA = new Cat(); //新的对象
        caA.setName(p.getCa().getName());
        p1.setCa(caA);

        p1.setHeight(p.getHeight());
        p1.setName(p.getName());

        return p1;
    }
}

