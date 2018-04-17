package proxy.imp;

import proxy.annotation.Fluid;

public class DogImpAnno implements AnimalInterface {

	@Fluid(value = "Lunar")
	private String name;
	private String Property;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void say() {

		System.out.println("Dog: wang");
	}

	@Override
	public void getProperty() {
		System.out.println(this.name + this.Property);

	}

	@Fluid(Property = "Fluid Shore warrider")
	public void setProperty(String Property) {
		this.Property = Property;
	}
}
