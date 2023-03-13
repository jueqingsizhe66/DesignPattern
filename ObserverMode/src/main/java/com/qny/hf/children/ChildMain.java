package com.qny.hf.children;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: ChildMain.java
 * @Description: 观察者模式 大多数是与责任链模式协同进行的， 谁负责谁观察！  观察到不一定负责
 * 在很多系统中，Observer模式往往和责任链共同负责对于事件的处理，
 * 其中的某一个observer负责是否将事件进一步传递
 * @Package com.qny.hf.children
 * @Time: 2023/3/13 23:49
 */
import java.util.ArrayList;
import java.util.List;
public class ChildMain {

    public static void main(String[] args) {

        Child c = new Child();
        //do sth
        c.wakeUp();
    }
}


/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 * 事件也可以形成继承体系
 */

class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();
    //添加私有观察列表 在被观察源， 每个观察者事先约定好！

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
        observers.add((e)->{
            System.out.println("ppp");
        });
        //hook callback function
    }


    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed", this);

        for(Observer o : observers) {
            o.actionOnWakeUp(event);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

class wakeUpEvent extends Event<Child>{
    long timestamp;
    String loc;
    Child source;

    public wakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}

interface Observer {
    void actionOnWakeUp(wakeUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp(wakeUpEvent event) {
        wang();
    }
}

