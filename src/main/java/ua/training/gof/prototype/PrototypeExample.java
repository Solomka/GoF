package ua.training.gof.prototype;

/*
 * Используйте паттерн прототип, когда система не должна зависеть от того, как в ней создаются, компонуются и представляются продукты:
а инстанцируемые классы определяются во время выполнения, например с помощью динамической загрузки;
а для того чтобы избежать построения иерархий классов или фабрик, парал-лельных иерархии классов продуктов;
а экземпляры класса могут находиться в одном из не очень большого числа различных состояний. 
Может оказаться удобнее установить соответствую-щее число прототипов и клонировать их, 
а не инстанцировать каждый раз класс вручную в подходящем состоянии.
 */
public class PrototypeExample {

	public static void main(String[] args) {
		
		/* Strings review */
		
		String f = "bla";
		String f1 = f;
		
		System.out.println(f);
		System.out.println(f1);
		System.out.println(f1 == f);
		
		f = "foo";
		System.out.println(f);
		System.out.println(f1);
		System.out.println(f1 == f);
		
		String str1 = "koo";
		// !!! forcedly new object
		String str2 = new String(str1);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str1 == str2);
		
/* ------------------------------ */
		
		Human original = new Human(18, "Andtii");
		System.out.println("Original: " + original);

		Human copy = (Human) original.copy();
		System.out.println("Copy: " + copy);
		
		//hashCodes
		System.out.println("Original hashCode: " + original.getName().hashCode());
		System.out.println("Copy hashCode: " + copy.getName().hashCode());
		System.out.println((original.getName() == copy.getName()) );
		
		original.setName("Vova");
		
		System.out.println("Original: " + original);
		System.out.println("Copy: " + copy);
		
		//hashCodes
				System.out.println("Original hashCode: " + original.getName().hashCode());
				System.out.println("Copy hashCode: " + copy.getName().hashCode());
				System.out.println((original.getName() == copy.getName()) );
		
		

		
		CopyFactory factory = new CopyFactory(copy);
		Human h1 = (Human) factory.makeCopy();
		System.out.println(h1);

		factory.setPrototype(new Human(30, "Anna"));
		Human h2 = (Human) factory.makeCopy();
		System.out.println(h2);
		
	}
}

interface Copyable {
	Object copy();
}

class Human implements Copyable {

	int age;
	String name;

	public Human(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}	

	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public Object copy() {
		Human copy = new Human(age, name);
		return copy;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + "]";
	}
}

class CopyFactory {

	Copyable human;

	public CopyFactory(Copyable human) {
		setPrototype(human);
	}

	public void setPrototype(Copyable human) {
		this.human = human;
	}

	Copyable makeCopy() {
		return (Copyable) human.copy();
	}

}