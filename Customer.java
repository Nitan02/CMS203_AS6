/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: (Bradley Beverage Shop)
 * Due: 04/30/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Touch Nitan
*/
public class Customer {
	private String name;
	private int age;

	public Customer(String string, int age) {
		this.name = string;
		this.age = age;
	}

	public Customer(Customer c) {
		this.name = c.name;
		this.age = c.age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
}