 将一个类的接口转换成客户希望的另外一个接口。该模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

    何时使用

    一个程序想使用已经存在的类，但是该类所实现的接口和当前程序所使用的接口不一致时。
    优点

    目标与被适配者解耦
    满足开-闭原则
    原理就是保留现有的类所提供的服务，修改其接口，从而达到客户端的期望。

    再者，适配器也分对象适配器和类适配器，先看下面代码再来解释。

    举个例子，你有一个播放器，只能播放MP3格式的音乐，
    但是现在需要它能播放flac格式的，我们不能直接使用这个播放器，但可以添加一个适配器来解决这个问题：
    
 1. Vector使用Enumeration類進行遍歷
 2. 實現Iterable<String>之後[書冊需要實現Iterable接口，獲取迭代器對象]需要實現iterator()方法
 3. 實現了Iterator<String>類需要重寫hasNext()和next方法，對應Enumeration的hasMoreElements()和nextElement
    這樣就可以轉換老系統的Enumeration到Iterator方式
    
    Book --- Eneumeration----Vector
    
    迭代器模式的使用
    Book---BookAdapter-----IterationAdapter------Enumeration-----Vector
    
    
    以為Book數據結構是List，所以想要使用Iterator
    