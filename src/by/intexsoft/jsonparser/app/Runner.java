package by.intexsoft.jsonparser.app;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.AbstractJsonElement;
import by.intexsoft.jsonparser.parser.JsonParser;

/**
 * Класс для старта приложения
 * в методе main создается объект парсера, в конструкторе передается путь к JSON файлу
 * У объекта вызывается метод parse(), возвращающий объект типа  AbstractJsonElement,
 * представляющий собой распарсеный из JSONа Java объект
 */
public class Runner {

	public static void main(String[] args) throws InvalidJsonException {

		JsonParser parser = new JsonParser("test.json");
		AbstractJsonElement element = parser.parse();
		System.out.println(element);
	}
}
