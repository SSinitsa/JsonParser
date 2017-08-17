package by.intexsoft.jsonparser.parser;

import static by.intexsoft.jsonparser.utils.Utils.getType;
import static by.intexsoft.jsonparser.utils.Utils.removeSpaces;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.AbstractJsonElement;
import by.intexsoft.jsonparser.model.JsonNull;


/**
  * Класс для парсинга файла, содержащего объект в формате JSON
 * Содержит метод parse()
 */
public class JsonParser {

	private String sourceLine = "";

	/**
	 * Создает новый объект класса JsonParser
	 * @param fileName путь к файлу, который в конструкторе преобразуется в строку
	 */
	public JsonParser(String fileName) {
		List<String> jsonStringList = new ArrayList<>();
		try {
			jsonStringList = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			for (String line : jsonStringList) {
				sourceLine = sourceLine + line;
			}
		} catch (IOException e) {
			System.out.println("Could not read file " + fileName);
		}
	}

	
	/**
	 * Метода для парсинга строки, полученной из файла, 
	 * путь к которому был передан в конструкторе объекта
	 * @return объект типа AbstractJsonElement
	 * @throws InvalidJsonException
	 */
	public AbstractJsonElement parse() throws InvalidJsonException {
		sourceLine = removeSpaces(sourceLine);
		switch (getType(sourceLine)) {
		case OBJECT:
			return new ObjectParser().parse(sourceLine);
		case ARRAY:
			return new ArrayParser().parse(sourceLine);
		case STRING:
			return new StringParser().parse(sourceLine);
		case NUMBER:
			return new NumberParser().parse(sourceLine);
		case BOOLEAN:
			return new BooleanParser().parse(sourceLine);
		case NULL:
			return new JsonNull();
		case INVALIDTYPE:
			throw new InvalidJsonException();
		}
		return null;
	}
}
