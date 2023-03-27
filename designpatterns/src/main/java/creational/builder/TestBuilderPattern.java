package creational.builder;

public class TestBuilderPattern {

	public static void main(String[] args) {
		
		User user1 = new User.UserBuilder("Soumya", "Jha")
				.age(30)
				.email("test@email.com")
				.address("Test Address")
				.build();
		System.out.println("User 1 :: " + user1);
		
		User user2 = new User.UserBuilder("Devashish", "Jha")
				.age(32)
				.email("test@email.com")
				.build();
		System.out.println("User 2 :: " + user2);
		
		User user3 = new User.UserBuilder("Arvind", "Jha")
				.age(63)
				.build();
		System.out.println("User 3 :: " + user3);

	}

}
