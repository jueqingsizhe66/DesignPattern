package proxy;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import proxy.aop.AOPMethod;
import proxy.imp.AnimalInterface;
import proxy.imp.DogImpAnno;

import java.lang.reflect.Method;

@RunWith(BlockJUnit4ClassRunner.class)
public class AOPNewHanleAnnoTest {
    public static void main(String[] args) {
        AnimalInterface dog = AnimalFactorAnnoNew.getAnimal(DogImpAnno.class, new AOPMethod() {

            // 调用方法前 执行的切入方法
            @Override
            public void before(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty")) {
                    System.out.println("成功拦截"+method.getName() +"方法，启动");
                }
            }
            // 调用方法执行后 切入方法
            @Override
            public void after(Object proxy, Method method, Object[] args) {
                if (method.getName().equals("getProperty")) {
                    System.out.println("成功拦截"+method.getName() +"方法，结束");
                }
            }

        });
        dog.say();
        String name1 = "我的名字是" + dog.getName();
        System.out.println(name1);
        dog.setName("天使的奴隶");
        String name2 = "我的名字是" + dog.getName();
        System.out.println(name2);
        dog.getProperty();
    }
}
