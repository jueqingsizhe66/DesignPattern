package com.qny.Strategic;

/**
 * @author Zhaoliang Ye 叶昭良(zl_ye@qny.chng.com.cn)
 * @version V0.1
 * @Title: Duck.java
 * @Description: (用一句话描述该文件做什么 ?) https://www.youtube.com/watch?v=v9ejT8FO-7I
 * @Package com.qny.Strategic
 * @Time: 2023/3/11 0:44
 */
public abstract class Duck {
    private IFlying fl;
    private IQuack qu;

    public IFlying getFl() {
        return fl;
    }

    public void setFl(IFlying fl) {
        this.fl = fl;
    }

    public IQuack getQu() {
        return qu;
    }

    public void setQu(IQuack qu) {
        this.qu = qu;
    }

    public IDisplay getDi() {
        return di;
    }

    public void setDi(IDisplay di) {
        this.di = di;
    }

    private IDisplay di;

    public Duck(IFlying fl, IQuack qu, IDisplay di) {
        this.fl = fl;
        this.qu = qu;
        this.di = di;
    }

    public Duck() {
    }

    public void fly(){
        this.fl.fly();
    }
    public void quack(){
        this.qu.quack();
    }
    public void display(){
        this.di.display();
    }
    //    public abstract void quack(IQuack qu);
//    public abstract void fly(IFlying fl);
//    public abstract void display(IDisplay di);
}

