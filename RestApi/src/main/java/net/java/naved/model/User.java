package net.java.naved.model;

public class User {
	
	private long id;
	private String name;
	private long age;
	private String email;
	
	public User(long id,String name,long age, String email) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.email=email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void printUserDetails() {
        System.out.println("User Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
	public User() {
        this.id = 0;
        this.name = "Unknown";
        this.age = 0;
        this.email = "unknown@example.com";
    }
	
}
