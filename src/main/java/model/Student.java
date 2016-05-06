package model;

public class Student {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String sex;
	private int age;
	private String address;

	public Student() {
		super();
	}

	public Student(String name, String email, String phone, String sex,
			int age, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	public Student(int id, String name, String email, String phone, String sex,
			int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", sex=" + sex + ", age=" + age
				+ ", address=" + address + "]";
	}

}
