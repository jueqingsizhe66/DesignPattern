package proxy;

import proxy.aop.AOPHandle;

import java.lang.reflect.Proxy;

public class AnimalFactory {


    private static Object getAnimalBase(Object obj)
    {
        //get proxy object
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new AOPHandle(obj));
    }
    @SuppressWarnings("unchecked")
    public static <T> T getAnimial(Object obj){
        return (T) getAnimalBase(obj);
    }

    @SuppressWarnings("unchecked")
    public static <T>  T getAnimal(String className){
        Object obj=null;
        try {
            obj= getAnimalBase(Class.forName(className).newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }
    @SuppressWarnings("unchecked")
    public static <T>  T  getAnimal(Class clz){
        Object obj=null;
        try {
            obj= getAnimalBase(clz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }

}

