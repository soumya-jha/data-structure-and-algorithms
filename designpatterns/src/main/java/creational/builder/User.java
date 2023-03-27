package creational.builder;

public class User {

	private String firstName; //mandatory
	private String lastname; //mandatory
	private Integer age; //optional
	private String email; //optional
	private String address; //optional
	
	private User(UserBuilder userBuilder) {
		this.firstName = userBuilder.firstName;
		this.lastname = userBuilder.lastname;
		this.age = userBuilder.age;
		this.email = userBuilder.email;
		this.address = userBuilder.address;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public Integer getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public static class UserBuilder{
		private String firstName;
		private String lastname;
		private Integer age;
		private String email;
		private String address;
		
		public UserBuilder(String firstName, String lastName) { //Constructor with only mandatory parameters
			this.firstName = firstName;
			this.lastname = lastName;
		}
		
		public UserBuilder age (Integer age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public User build() {
			User user = new User(this);
			return user;
		}
		
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastname=" + lastname + ", age=" + age + ", email=" + email
				+ ", address=" + address + "]";
	}
	
}
