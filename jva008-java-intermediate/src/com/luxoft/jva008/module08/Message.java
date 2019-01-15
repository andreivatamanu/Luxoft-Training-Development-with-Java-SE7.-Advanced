package com.luxoft.jva008.module08;

import java.util.function.Function;
import java.util.function.Supplier;

public class Message {

	private String text;

	public String getText() {
		return text;
	}

	public Message() {
	}

	public Message(String text) {
		this.text = text;
	}

	public static Message createMessage(String text) {
		return new Message(text);
	}

	@Override
	public String toString() {
		return text;
	}

	public static void main(String[] args) {

		Function<String, Message> messageFactory = Message::createMessage;
		System.out.println(messageFactory.apply("foo").getText());

		Function<Message, String> toString = Message::toString;
		System.out.println(toString.apply(new Message("foo")));

		Supplier<Message> messageFactory2 = Message::new;
		System.out.println(messageFactory2.get());
		System.out.println(messageFactory2.get() instanceof Message);

		Function<String, Message> messageFactory3 = Message::new;
		System.out.println(messageFactory3.apply("foo").getText());

		Function<Integer, Message[]> messageArrayFactory = Message[]::new;
		System.out.println(messageArrayFactory.apply(10).length);

	}

}
