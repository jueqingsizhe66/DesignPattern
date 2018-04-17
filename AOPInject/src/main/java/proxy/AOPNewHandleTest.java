package proxy;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import proxy.aop.AOPMethod;
import proxy.imp.AnimalInterface;
import proxy.imp.DogImp;

import java.lang.reflect.Method;

@RunWith(BlockJUnit4ClassRunner.class)
public class AOPNewHandleTest {
	public static void main(String[] args) {
		AnimalInterface dog = AnimalFactorNew.getAnimal(DogImp.class, new AOPMethod() {
			@Override
			public void after(Object proxy, Method method, Object[] args) {
				System.out.println("I am" + " execute before the Method :" + method.getName());
			}

			@Override
			public void before(Object proxy, Method method, Object[] args) {
				System.out.println("I am" + " execute after the Method :" + method.getName());
			}
		});

		dog.say();
		String name1 = "My name is" + dog.getName();
		System.out.println(name1);
		dog.setName("Two Sily");
		String name2 = "My name is" + dog.getName();
		System.out.println(name2);
	}
}
