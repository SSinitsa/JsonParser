package by.intexsoft.jsonparser.parser;

import by.intexsoft.jsonparser.model.JsonString;
import by.intexsoft.jsonparser.utils.Utils;

/**
 * Класс для парсинга строки, содержащей JSON объект типа String
 * Содержит метод parse(String sourceLine)
 */
public class StringParser implements Parser{

	/**
	 * Метод для парсинга строки.
	 * @param sourceLine - целевая строка
	 * @return объект типа JsonString
	 */
	@Override
	public JsonString parse(String sourceLine) {
		int stringLength = Utils.getStringLength(sourceLine);
		return new JsonString(sourceLine.substring(0, stringLength));
	}

}
