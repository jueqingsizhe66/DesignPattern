package proxy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import proxy.imp.AnimalInterface;
import proxy.imp.DogImp;

@RunWith(BlockJUnit4ClassRunner.class)
public class AOPTest {

	@Test
	public void Test1() {
		AnimalInterface dog = AnimalFactory.getAnimal(DogImp.class);
		dog.say();
		System.out.println("My Name is" + dog.getName());
		dog.setName("Two gou zi");
		System.out.println("My Name is" + dog.getName());
	}
}
