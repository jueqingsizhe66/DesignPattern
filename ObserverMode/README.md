 别名： 依赖，发布/订阅（Another Name: Dependents, Publish/Subscribe）

    定义对象间的一种一对多的依赖关系，当一个对象状态发生改变时，
    所有依赖它的对象都得到通知并被自动更新。

## 何时使用

    当一个对象的数据更新时，需要通知其他对象，而又不希望和被通知的对象形成紧耦合时
    
    优点

    ...

运用1： 天气预报

    比如我们有个天气服务（主题），然后有多个使用它的客户端（观察者），包括android和iphone
    端app的服务（观察者），那么就可以使用这么模式。

    我们需要一种结构存放天气信息（注意，省略了get、set方法！）：
    
    中台： WeatherService
    接口： 获得消息接口 Client
    消息接口具体实现: ClientAndroidServer  ClientIPhoneServer
    消息体： 封装天气消息 WeatherInfo
    
    
 运用2：很有趣的文件夹监听，也是类似观察者模式