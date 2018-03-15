package com.cglib;

public class TestCglib {
    public static void main(String[] args) {
        TestImpa t1 = new TestImpa();
        TestImpa proxyImpa =(TestImpa)new CglibProxy().getInstance(t1);
        /*
       TestImpa$$EnhancerByCGLIB$$e202c6ef

       public class TestImpa$$EnhancerByCGLIB$$e202c6ef extends TestImpa{
        private MethodInterceptor callback;
        public  TestImpa$$EnhancerByCGLIB$$e202c6ef(MethodInterceptor callback){
              this.callback =callback;
        }
         public void test1(){ callback.intercept(...);}
         public void test2(String s){ callback.intercept(...);}
       }
         */
        System.out.println(proxyImpa.getClass());
        System.out.println(proxyImpa.getClass().getSuperclass());
        proxyImpa.test1();
        proxyImpa.test2("edu.f708");

    }
}
