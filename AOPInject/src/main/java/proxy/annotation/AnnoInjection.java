package proxy.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
http://blog.52python.cn/2015/12/09/%E4%BD%BF%E7%94%A8Java%E5%8E%9F%E7%94%9F%E4%BB%A3%E7%90%86%E5%AE%9E%E7%8E%B0%E6%B3%A8%E5%85%A5/
how to inject??????????????
呢,就实现了属性的方法的注入..在哪里调用呢……
查看之前的AnimalFactory代码,会发现在getAnimalBase里有
 */
public class AnnoInjection {
    public static Object getBean(Object obj) {
        //get Property
        try{
            Field f[] =obj.getClass().getDeclaredFields();
            //遍历属性
            for (Field currentField : f) {
                //获得属性上的注释
                Fluid flu = currentField.getAnnotation(Fluid.class);
                if (null != flu) {
                    System.out.println("注入"+currentField.getName() +"属性"+ " 它的值是"+flu.value());

                /*
                核心1
                 */
                    obj.getClass().getMethod("set"+currentField.getName().substring(0,1).toUpperCase()+
                            currentField.getName().substring(1), new Class[]{String.class}).invoke(obj,flu.value());
                }
            }
            //get all method
            Method m[] = obj.getClass().getDeclaredMethods();
            for (Method currentMethod : m) {
                Fluid flm = currentMethod.getAnnotation(Fluid.class);
                if (null!=flm) {
                    System.out.println("注入"+ currentMethod.getName()+"方法"+ " 方法属性"+ flm.Property());
                /*
                核心2
                 */
                    currentMethod.invoke(obj,flm.Property());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return obj;
    }
}
