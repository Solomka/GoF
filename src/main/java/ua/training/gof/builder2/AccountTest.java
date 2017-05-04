package ua.training.gof.builder2;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = Account.newBuilder().setUserId("1").setToken("bla").build();
		System.out.println(account);
	}

}
