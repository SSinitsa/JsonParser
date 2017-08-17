package by.intexsoft.jsonparser.parser;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.JsonBoolean;

/**
  * Класс для парсинга строки, содержащей значение типа boolean
 * Содержит метод parse(String sourceLine)
 */
public class BooleanParser implements Parser {

	/**
	 * Метод для парсинга значения типа boolean из строки.
	 * @param sourceLine - целевая строка, содержащая значение boolean
	 * @return объект типа JsonBoolean
	 */
	@Override
	public JsonBoolean parse(String sourceLine) throws InvalidJsonException {
		if (sourceLine.matches("(true).*")) return new JsonBoolean(true);
		if (sourceLine.matches("(false).*")) return new JsonBoolean(false);
		throw new InvalidJsonException();
	}

}
