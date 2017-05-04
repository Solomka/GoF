package ua.training.gof.bridge;

/*
 * Используйте паттерн мост, когда:
а хотите избежать постоянной привязки абстракции к реализации. 
Так, на-пример, бывает, когда реализацию необходимо выбирать во время выполне-ния программы;
а и абстракции, и реализации должны расширяться новыми подклассами.
В таком случае паттерн мост позволяет комбинировать разные абстрак-ции и реализации и изменять их независимо;
о изменения в реализации абстракции не должны сказываться на клиентах, то есть клиентский код не должен перекомпилироваться;

(только для C++!) вы хотите полностью скрыть от клиентов реализацию аб-стракции. 
В C++ представление класса видимо через его интерфейс;
а число классов начинает быстро расти, как мы видели на первой диаграмме из раздела «Мотивация». 
Это признак того, что иерархию следует разделить на две части. 
Для таких иерархий классов Рамбо (Rumbaugh) использует термин «вложенные обобщения» [RBP+91];
а вы хотите разделить одну реализацию между несколькими объектами (быть может, применяя подсчет ссылок), 
и этот факт необходимо скрыть от клиента. Простой пример - это разработанный Джеймсом Коплиеном класс String [Сор92], 
в котором разные объекты могут разделять одно и то же представ-ление строки (StringRep).

 */
/*
 * The bridge pattern looks a lot like the adapter pattern and is a common cause of confusion.
 *  However, while the adapter pattern helps two incompatible interfaces work together,
 *   the bridge pattern helps decouple the abstraction and implementation by creating two separate class hierarchies.
 *    Also, as stated by GOF “Adapter makes things work after they’re designed; Bridge makes them work before they are.“.
 */
public class BridgeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Message message = new TextMessage();
		message.sendMessage();

		message = new EmailMessage();
		message.sendMessage();
	}

}

interface Message {
	void sendMessage();
}

class EmailMessage implements Message {

	@Override
	public void sendMessage() {
		System.out.println("Sending email message");

	}
}

class TextMessage implements Message {

	@Override
	public void sendMessage() {
		System.out.println("Sending test message");

	}

}