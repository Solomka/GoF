package ua.training.gof.mediator2;

import java.util.ArrayList;
import java.util.List;

public class MediatorExample2 {

	public static void main(String[] args) {
		TextChat chat = new TextChat();

		User admin = new Admin(chat, "ABob");
		User u1 = new SimpleUser(chat, "User1");
		User u2 = new SimpleUser(chat, "User2");
		User u3 = new SimpleUser(chat, "User3");
		u2.setEnable(false);

		chat.setAdmin(admin);
		chat.addUser(u1);
		chat.addUser(u2);
		chat.addUser(u3);

		u1.sendMessage("Hi, I'm the first User in this chat");

	}
}

abstract class User {

	Chat chat;

	String name;
	// online/ offline for messages from Simple users
	boolean isEnable = true;

	public User(Chat chat, String name) {
		this.chat = chat;
		this.name = name;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public String getName() {
		return name;
	}

	// admin/ simpleUser send message to chat not to the other concrete user

	public void sendMessage(String message) {
		// chat defines who will receive this message
		chat.sendMessage(message, this);
	}

	abstract void getMessage(String message);

	@Override
	public String toString() {
		return "User [chat=" + chat + ", name=" + name + ", isEnable=" + isEnable + "]";
	}
}

class Admin extends User {

	public Admin(Chat chat, String name) {
		super(chat, name);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("Admin " + getName() + " has received message: " + message);
	}
}

class SimpleUser extends User {

	Chat chat;

	public SimpleUser(Chat chat, String name) {
		super(chat, name);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("SimpleUser " + getName() + " has received message: " + message);
	}
}

interface Chat {
	void sendMessage(String message, User user);
}

// Mediator
class TextChat implements Chat {

	User admin;
	List<User> users = new ArrayList<>();

	public void setAdmin(User admin) {

		if (admin != null && admin instanceof Admin) {
			this.admin = admin;
		} else {
			throw new RuntimeException("No enough rights");
		}
	}

	public void addUser(User user) {
		if (admin == null) {
			throw new RuntimeException("Chat doesn't have an admin");
		}
		if (user instanceof SimpleUser) {
			users.add(user);
		} else {
			throw new RuntimeException(
					"Admin can't be an admin in more than one chat concurrently/simultaneously/at the same time");
		}
	}

	@Override
	public void sendMessage(String message, User user) {

		if (user instanceof Admin) {
			for (User u : users) {
				u.getMessage(user.getName() + ": " + message);
			}
		}

		if (user instanceof SimpleUser) {
			for (User u : users) {
				if (u != user && u.isEnable) {
					u.getMessage(user.getName() + ": " + message);
				}
			}
		}

		if (admin.isEnable()) {
			admin.getMessage(user.getName() + ": " + message);
		}
	}

}
