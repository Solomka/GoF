package ua.training.gof.memento;

/*
 * “Without violating encapsulation,
 *  capture and externalize an object’s internal state so that the object can be restored to this state later.”
 */
public class MementoExample {

	public static void main(String[] args) {
		Game game = new Game();
		game.set("LVL_1", 30000);
		System.out.println(game);

		File file = new File();
		file.setSave(game.save());

		game.set("LVL_3", 55000);
		System.out.println(game);

		System.out.println("Load previous level");
		game.load(file.getSave());
		System.out.println(game);
	}
}

// Originator
class Game {

	private String level;
	private int ms;

	public void set(String level, int ms) {
		this.level = level;
		this.ms = ms;
	}

	public void load(Save save) {
		level = save.getLevel();
		ms = save.getMs();

	}

	// create Memento
	public Save save() {
		return new Save(level, ms);
	}

	@Override
	public String toString() {
		return "Game [level=" + level + ", ms=" + ms + "]";
	}

}

// Memento
class Save {
	private final String level;
	private final int ms;

	public Save(String level, int ms) {
		super();
		this.level = level;
		this.ms = ms;
	}

	public String getLevel() {
		return level;
	}

	public int getMs() {
		return ms;
	}
}

// Caretaker
class File {
	Save save;

	public Save getSave() {
		return save;
	}

	public void setSave(Save save) {
		this.save = save;
	}

}
