package proxy.imp;

public class DogImp implements AnimalInterface {
	private String name = "Hei"; //Default Name

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public DogImp() {
	}

	public DogImp(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void say() {
		System.out.println(this.name + ": Welcome back! Fuck you!");
	}

	@Override
	public void getProperty() {

		System.out.println(this.name + " : I am your best friend, I can keep guard for you!");
	}
}
