package com.build;

/**
 * 创建对象更加复杂！！
 */
public class User {
	private String firstName; // 必传参数
	private String lastName; // 必传参数
	private int age; // 可选参数
	private String phone; // 可选参数
	private String address; // 可选参数

	/**
	 *
	 * 简化多种构造函数方式  针对字段特别的构造类
	 * user和builder字段同样
	 * @param builder
	 */
	/**
	 * 只有把Builder设置为内部类(平行关系)  才可以调用builder.firstName
	 * 不需要get和frrst
	 *
	 * @param builder
	 */
	private User(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}

	/**
	 * 加上static可以帮助优化内存， 也可以不用加static
	 */
	public static class Builder {
		private String firstName; // 必传参数
		private String lastName; // 必传参数
		private int age; // 可选参数
		private String phone; // 可选参数
		private String address; // 可选参数

		public Builder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		/**
		 * 常用写法， age  ，phone等，通过字段直接表现为函数
		 *
		 * @param age
		 * @return
		 */
		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

}
