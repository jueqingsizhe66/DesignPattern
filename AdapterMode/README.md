 将一个类的接口转换成客户希望的另外一个接口。该模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。

## 何时使用

    一个程序想使用已经存在的类，但是该类所实现的接口和当前程序所使用的接口不一致时。
    优点

    目标与被适配者解耦
    满足开-闭原则
    原理就是保留现有的类所提供的服务，修改其接口，从而达到客户端的期望。

    再者，适配器也分对象适配器和类适配器，先看下面代码再来解释。

    举个例子，你有一个播放器，只能播放MP3格式的音乐，
    但是现在需要它能播放flac格式的，我们不能直接使用这个播放器，但可以添加一个适配器来解决这个问题：
    
 1. Vector使用Enumeration类进行遍历
 2. 实现Iterable<String>之後[注册需要实现Iterable接口，获取迭代器对象]需要实现iterator()方法
 3. 实现了Iterator<String>类需要重写hasNext()和next方法，对应Enumeration的hasMoreElements()和nextElement
    这样就可以转换老系统的Enumeration到Iterator方式
    
    Book --- Eneumeration----Vector
    
    迭代器模式的使用
    Book---BookAdapter-----IterationAdapter------Enumeration-----Vector
    
    
    以为Book数据结构是List，所以想要使用Iterator

- InputStreamReader(InputStream) : 从字节流转换为字符流
- OutputStreamReader(OutputStream) : 从字节流转换为字符流
- GUI编程也用了大量的适配器模式？仔细思考流的变化过程
- Spring也用了大量的适配器模式

适配器模式的灵魂就是存在一个系统，可以接入来自不同接口的数据流，有点像以前中国的万国朝拜， 源源不断的货物、金钱流动在以中国为核心
的系统中，我们对外匹配不同的国家，整个系统中存在的不同的适配器借口，每个适配器都可以解决两房对接的问题。
(整合流-----> 适配器就是IO流、数据流的整合)

需要分清以下概念：
被适配器对象： 网线(对外贸易通道)
系统： 电脑( 在这种模式下 他是唯一 比如中国)
适配器： usb转换器 一般适配器有很多种
