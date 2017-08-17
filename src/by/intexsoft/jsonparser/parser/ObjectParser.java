package by.intexsoft.jsonparser.parser;

import static by.intexsoft.jsonparser.utils.Utils.DOUBLEQUOTES;
import static by.intexsoft.jsonparser.utils.Utils.cutColon;
import static by.intexsoft.jsonparser.utils.Utils.cutComma;
import static by.intexsoft.jsonparser.utils.Utils.cutSubstring;
import static by.intexsoft.jsonparser.utils.Utils.findObjectBody;
import static by.intexsoft.jsonparser.utils.Utils.getArrayLength;
import static by.intexsoft.jsonparser.utils.Utils.getBooleanLength;
import static by.intexsoft.jsonparser.utils.Utils.getNumberLength;
import static by.intexsoft.jsonparser.utils.Utils.getObjectLength;
import static by.intexsoft.jsonparser.utils.Utils.getStringLength;
import static by.intexsoft.jsonparser.utils.Utils.getType;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.JsonKeyValue;
import by.intexsoft.jsonparser.model.JsonNull;
import by.intexsoft.jsonparser.model.JsonObject;
import by.intexsoft.jsonparser.model.JsonString;

/**
 * Класс для парсинга строки, содержащей JSON объект с набором пар ключ-значение
 * Содержит метод parse(String sourceLine)
 */
public class ObjectParser implements Parser {

	private int valueLength = 0;
	/**
	 * Метод для парсинга JSON объекта с набором пар ключ-значение.
	 * Разбирает строку на массив объектов типа JsonKeyValue
	 * @param sourceLine - целевая строка, содержащая массив JSON объектов с набором пар ключ-значение.
	 * @return объект типа JsonObject
	 * @throws InvalidJsonException 
	 */
	@Override
	public JsonObject parse(String sourceLine) throws InvalidJsonException {
		JsonObject result = new JsonObject();
		String targetLine = findObjectBody(sourceLine);
		while (targetLine.length() > 0) {
			if (!targetLine.startsWith(DOUBLEQUOTES))
				throw new InvalidJsonException();
			JsonString key = new StringParser().parse(targetLine);
			targetLine = cutSubstring(targetLine, getStringLength(targetLine));
			targetLine = cutColon(targetLine);
			JsonKeyValue newElement = buildElement(key, targetLine);
			targetLine = cutSubstring(targetLine, valueLength);
			targetLine = cutComma(targetLine);
			result.add(newElement);
		}
		return result;
	}
	
	private JsonKeyValue buildElement(JsonString key, String targetLine) throws InvalidJsonException {
		switch (getType(targetLine)) {
		case ARRAY:
			valueLength = getArrayLength(targetLine);
			return new JsonKeyValue(key, new ArrayParser().parse(targetLine));
		case BOOLEAN:
			valueLength = getBooleanLength(targetLine);
			return new JsonKeyValue(key, new BooleanParser().parse(targetLine));
		case NULL:
			valueLength = 4;
			return new JsonKeyValue(key, new JsonNull());
		case NUMBER:
			valueLength = getNumberLength(targetLine);
			return new JsonKeyValue(key, new NumberParser().parse(targetLine));
		case OBJECT:
			valueLength = getObjectLength(targetLine);
			return new JsonKeyValue(key, new ObjectParser().parse(targetLine.substring(0, valueLength)));
		case STRING:
			valueLength = getStringLength(targetLine);
			return new JsonKeyValue(key, new StringParser().parse(targetLine));
		case INVALIDTYPE:
			throw new InvalidJsonException();
		}
		return null;
	}
}
