package ua.training.gof.chain_of_responsibility;

/*
 * предназначенный для организации в системе уровней ответственности.
 * 
 * Шаблон рекомендован для использования в условиях:

в разрабатываемой системе имеется группа объектов, которые могут обрабатывать сообщения определенного типа;
все сообщения должны быть обработаны хотя бы одним объектом системы;
сообщения в системе обрабатываются по схеме «обработай сам либо перешли другому»,
 то есть одни сообщения обрабатываются на том уровне, где они получены, а другие пересылаются объектам иного уровня.
 
 * Delegates commands to a chain of processing objects.

        “Avoid coupling the sender of a request to its receiver
         by giving more than one object a chance to handle the request. 
        Chain the receiving objects and pass the request along the chain
         until an object handles it.”
 */

/*
 * Используйте цепочку обязанностей, когда:
а есть более одного объекта, способного обработать запрос, причем настоя-щий обработчик заранее неизвестен и должен быть найден автоматически;
а вы хотите отправить запрос одному из нескольких объектов, не указывая явно, какому именно;
а набор объектов, способных обработать запрос, должен задаваться динами-чески.
 */

/*
 * Usage:
 * 	 - ATM
 */
public class ChainOfResponsibilityExample {

	public static void main(String[] args) {
		Logger logger = getLoggersChain();

		logger.writeMessage("Fine!", Level.INFO);// 3
		logger.writeMessage("Debug!", Level.DEBUG);// 2
		logger.writeMessage("Error!", Level.ERROR);// 1

	}

	public static Logger getLoggersChain() {

		Logger smsLogger = new SMSLogger(Level.ERROR);// 1
		Logger fileLogger = new FileLogger(Level.DEBUG);// 2
		Logger emailLogger = new EmailLogger(Level.INFO);// 3

		smsLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(emailLogger);

		return smsLogger;

	}
}

class Level {
	public static final int ERROR = 1;
	public static final int DEBUG = 2;
	public static final int INFO = 3;

}

abstract class Logger {

	int priority;
	Logger nextLogger;

	public Logger(int priority) {
		this.priority = priority;
	}

	public void setNextLogger(Logger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void writeMessage(String message, int level) {
		if (level <= priority) {
			writeMessage(message);
		}
		if (nextLogger != null) {
			nextLogger.writeMessage(message, level);
		}
	}

	abstract void writeMessage(String message);

}

class SMSLogger extends Logger {

	public SMSLogger(int priority) {
		super(priority);
	}

	public void writeMessage(String message) {
		System.out.println("SMS: " + message);
	}
}

class FileLogger extends Logger {

	public FileLogger(int priority) {
		super(priority);
	}

	public void writeMessage(String message) {
		System.out.println("File: " + message);
	}
}

class EmailLogger extends Logger {

	public EmailLogger(int priority) {
		super(priority);
	}

	public void writeMessage(String message) {
		System.out.println("Email: " + message);
	}
}