package by.intexsoft.jsonparser.parser;

import static by.intexsoft.jsonparser.utils.Utils.COMMA;
import static by.intexsoft.jsonparser.utils.Utils.ENDARRAY;
import static by.intexsoft.jsonparser.utils.Utils.FALSE;
import static by.intexsoft.jsonparser.utils.Utils.NULL;
import static by.intexsoft.jsonparser.utils.Utils.STARTARRAY;
import static by.intexsoft.jsonparser.utils.Utils.STARTOBJECT;
import static by.intexsoft.jsonparser.utils.Utils.TRUE;
import static by.intexsoft.jsonparser.utils.Utils.getArrayLength;
import static by.intexsoft.jsonparser.utils.Utils.getObjectLength;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.AbstractJsonElement;
import by.intexsoft.jsonparser.model.JsonArray;
import by.intexsoft.jsonparser.model.JsonBoolean;
import by.intexsoft.jsonparser.model.JsonNull;
import by.intexsoft.jsonparser.model.JsonString;

/**
 * Класс для парсинга строки, содержащей массив объектов Содержит метод
 * parse(String sourceLine)
 */
public class ArrayParser implements Parser {

	private StringBuilder tempString = new StringBuilder();
	private String[] lineArray;
	private boolean isNested = false;
	private int lineLength;

	/**
	 * Метод для парсинга массива. Разбирает строку на массив объектов и определяет
	 * их тип Если тип объекта - массив, парсит его рекурсивно
	 * 
	 * @param sourceLine
	 *            - целевая строка, содержащая массив JSON объектов
	 * @return объект типа JsonArray
	 */
	@Override
	public JsonArray parse(String sourceLine) throws InvalidJsonException {
		sourceLine = sourceLine.substring(0, getArrayLength(sourceLine));
		lineArray = sourceLine.split("");
		lineLength = lineArray.length;
		JsonArray result = buildArray(sourceLine);
		return result;
	}

	private JsonArray buildArray(String sourceLine) throws InvalidJsonException {
		JsonArray result = new JsonArray();
		for (int i = 0; i < lineLength; i++) {
			if (lineArray[i].equals(STARTARRAY) && isNested == false) {
				isNested = true;
				continue;
			}
			if (!lineArray[i].equals(COMMA) && !lineArray[i].equals(ENDARRAY) && !lineArray[i].equals(STARTARRAY)
					&& !lineArray[i].equals(STARTOBJECT)) {
				tempString.append(lineArray[i]);
				continue;
			}
			if (lineArray[i].equals(COMMA)) {
				result.add(checkType(tempString.toString()));
				tempString.delete(0, tempString.length());
				continue;
			}

			if (lineArray[i].equals(STARTARRAY) && isNested == true) {
				int arrayLength = getArrayLength(sourceLine.substring(i, lineLength));
				result.add(new ArrayParser().parse(sourceLine.substring(i)));
				i += arrayLength;
				continue;
			}
			if (lineArray[i].equals(ENDARRAY)) {
				result.add(checkType(tempString.toString()));
				break;
			}
			if (lineArray[i].equals(STARTOBJECT)) {
				String nestedLine = sourceLine.substring(i);
				int objectLength = getObjectLength(nestedLine);
				String targetLine = nestedLine.substring(0, objectLength);
				result.add(new ObjectParser().parse(targetLine));
				i += objectLength;
			}
		}
		return result;

	}

	/**
	 * Метод, определяющий является ли @param line значением одного из типов null,
	 * true, false или числом если значение является числом, парсит его возвращая
	 * число соответствующего типа
	 * 
	 * @throws InvalidJsonException
	 */
	private AbstractJsonElement checkType(String line) throws InvalidJsonException {
		if (line.equals(NULL))
			return new JsonNull();
		if (line.equals(TRUE))
			return new JsonBoolean(true);
		if (line.equals(FALSE))
			return new JsonBoolean(false);
		if (line.matches("[-+]?\\d+(\\.?\\d+([eE][-+]?\\d+)?)?")) {
			return new NumberParser().parse(line);
		}
		if (line.matches("\".*\""))
			return new JsonString(line);
		throw new InvalidJsonException();
	}

}
