package ua.training.gof.builder2;

public class Account1 {

	private final String userId;
	private final String token;

	private Account1(Builder builder) {
		this.userId = builder.getUserId();
		this.token = builder.getToken();
	}

	public String getUserId() {
		return userId;
	}

	public String getToken() {
		return token;
	}

	public static class Builder {

		private String userId;
		private String token;
		
		

		public String getUserId() {
			return userId;
		}

		public String getToken() {
			return token;
		}

		public Builder setUserId(String userId) {
			this.userId = userId;

			return this;
		}

		public Builder setToken(String token) {
			this.token = token;

			return this;
		}

		public Account1 build() {
			return new Account1(this);
		}

	}

}