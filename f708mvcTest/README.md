## 项目结构：

F708mvc 是对SpringMVC特别特别简化的包，主要结构如structure图所述.

F708mvcTest是对这个mvc框架的使用，原则是使用Person对应的View，PersonController
对应的domain-Person(Dispatcher-servlet会自动截取掉Controller字符串，保持Person类).

![structure][1]

## 测试项目部署：

![deploy1][2]

![deploy2][3]


## 札记

下午把设计模式的案例走了一遍，觉得还是挺有意思的, 注意重写的时候得注意

1. 在DispatcherServlet添加@WebServlet("/")注解（带参数）
servlet3.0之后，剋使用@WebServlet替换在web.xml的注释（spring-boot则不需要web.xml,一代比一代
先进）

[webservlet一些介绍][5]
```$xslt
@WebServlet告知容器，HelloServlet这个Servlet的名称是Hello，这是由name属性指定的，而如果
客户端请求的URL是/hello.view，则由具Hello名称的Servlet来处理，这是由urlPatterns属性来指定的。
在Java EE相关应用程序中使用标注时，可以记得的是，没有设置的属性通常会有默认值。
例如，若没有设置@WebServlet的name属性，默认值会是Servlet的类完整名称。

当应用程序启动后，事实上并没有创建所有的Servlet实例。
容器会在首次请求需要某个Servlet服务时，才将对应的Servlet类实例化、进行初始化操作，然后再处理请求。
这意味着第一次请求该Servlet的客户端，必须等待Servlet类实例化、进行初始动作所必须花费的时间，
才真正得到请求的处理。

```
[webServlet annotation examples][4]

2. 在 ContextListener添加@WebListener监听（不需要带参数）

也是servlet3.0之后


[Listener前后变化对比][6]

```$xslt
     监听器类应该实现下面接口之一：

1.对Request的监听有ServletRequestListener和ServletRequestAttributeListener。前者可见监听Request的创建和销毁；而后者可以对Request的属性进行监听。

2.对Session的监听有HttpSessionListener和HttpSessionAttributeListener。HttpSessionListener可以监听HttpSession的创建跟销毁，而HttpSessionAttributeListener则是对session中属性的监听，它可以监听到session新增属性、移除属性和属性值被替换时。

3.对于ServletContext的监听器有ServletContextListener和ServletContextAttributeListener。ServletContextListener可以监听到ServletContext的创建和销毁，而ServletContextAttributeListener可以监听到ServletContext中属性的新增、移除和属性值的替换。
```

```java
import javax.servlet.annotation.WebListener;  
import javax.servlet.http.HttpSessionAttributeListener;  
import javax.servlet.http.HttpSessionBindingEvent;  
import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  
   
/** 
 * 
 * HttpSession监听器和HttpSession属性监听器 
 * 
 */  
@WebListener  
public class SessionListener implements HttpSessionAttributeListener,  
       HttpSessionListener {  
   
    @Override  
    public void sessionCreated(HttpSessionEvent se) {  
       System.out.println("session created");  
    }  
   
    @Override  
    public void sessionDestroyed(HttpSessionEvent se) {  
       System.out.println("session destroyed");  
    }  
   
    @Override  
    public void attributeAdded(HttpSessionBindingEvent event) {  
       System.out.println("session attribute added");  
    }  
   
    @Override  
    public void attributeRemoved(HttpSessionBindingEvent event) {  
       System.out.println("session attribute removed");  
    }  
   
    @Override  
    public void attributeReplaced(HttpSessionBindingEvent event) {  
       System.out.println("session attribute replaced");  
    }  
   
}  
```

对应的web.xml原始配置为

```java
<listener>  
   <listener-class>com.xxx.SessionListener</listener-class>  
</listener>  

```

[1]: https://github.com/jueqingsizhe66/DesignPattern/tree/master/f708mvcTest/img/structure.png
[2]: https://github.com/jueqingsizhe66/DesignPattern/tree/master/f708mvcTest/img/deploy1.png
[3]: https://github.com/jueqingsizhe66/DesignPattern/tree/master/f708mvcTest/img/deploy2.png
[4]:http://www.codejava.net/java-ee/servlet/webservlet-annotation-examples 
[5]:https://www.cnblogs.com/gckb/p/WebServlet.html 
[6]: https://blog.csdn.net/liuxiao723846/article/details/50492266 