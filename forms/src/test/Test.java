package test;

import bean.User;

public class Test {

	public static void main(String[] args) {
		User user = new User("dima@email.com", "PaSSword");
		
		if (user.validate()) {
			System.out.println("Bean validates OK.");
		} else {
			System.out.println(user.getMessage());
		}
	}
}
