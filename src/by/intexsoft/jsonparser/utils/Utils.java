package by.intexsoft.jsonparser.utils;

import static by.intexsoft.jsonparser.utils.JsonTypes.*;


/**
 * Класс содержит статические константы и методы
 * для работы со строками
 */
public class Utils {

	public static final String STARTOBJECT = "{";
	public static final String ENDOBJECT = "}";
	public static final String DOUBLEQUOTES = "\"";
	public static final String COLON = ":";
	public static final String COMMA = ",";
	public static final String STARTARRAY = "[";
	public static final String ENDARRAY = "]";
	public static final String NULL = "null";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String MINUS = "-";
	public static final String BACKSLASH = "\\";
	public static final String NEWLINE = "\n";
	public static final String CARRIAGERETURN = "\r";
	public static final String TAB = "\t";
	public static final String WHITESPACE = " ";

	
	/**
	 * Метод убирающий все незначимые пробелы и переносы из строки
	 * Игнорирует объекты, заключенные в двойные кавычки
	 * @param sourceLine исходная строка
	 * @return отформатированная строка
	 */
	public static String removeSpaces(String sourceLine) {
		Boolean isString = false;
		StringBuilder result = new StringBuilder();
		StringBuilder tempLine = new StringBuilder();
		String[] sourceArray = sourceLine.split("");
		for (int i = 0; i < sourceArray.length; i++) {
			tempLine.append(sourceArray[i]);
			switch (isString.toString()) {
			case TRUE:
				if (!sourceArray[i].equals(DOUBLEQUOTES) || (sourceArray[i - 1].equals(BACKSLASH))) break;
				result.append(tempLine);
				tempLine.delete(0, tempLine.length());
				isString = false;
				break;
			case FALSE:
				if (!sourceArray[i].equals(DOUBLEQUOTES)) break;
				result.append(tempLine.toString().replaceAll("\\s", ""));
				tempLine.delete(0, tempLine.length());
				isString = true;
				break;
			}
		}
		result.append(tempLine.toString().replaceAll("\\s", ""));
		return result.toString();
	}
	
	
	/**
	 * Метода определяющий тип JSON объекта в передаваемой строке
	 * @param sourceLine исходная строка
	 * @return значение JsonTypes
	 */
	public static JsonTypes getType(String sourceLine) {
		if (sourceLine.matches("\\{.+")) return OBJECT;
		if (sourceLine.matches("\\[.+")) return ARRAY;
		if (sourceLine.matches("\".+")) return STRING;
		if (sourceLine.matches("-?\\d.*")) return NUMBER;
		if (sourceLine.matches("(true).*")||sourceLine.matches("(false).*")) return BOOLEAN;
		if (sourceLine.matches("(null).*")) return JsonTypes.NULL;
		return INVALIDTYPE;
	}
	
	/**
	 * @param line строка содержащая объект
	 * @return тело объекта без фигурных скобок в начале и конце строки
	 */
	public static String findObjectBody(String line) {
		return line.substring(line.indexOf(STARTOBJECT) + 1, line.lastIndexOf(ENDOBJECT));
	}
	
	/**
	 * @param line
	 *            строка, содержащая строчное представление объекта
	 * @return количество символов в объекте
	 */
	public static int getObjectLength(String line) {
		int braceCounter = 0;
		String[] lineArray = line.split("");
		for (int i = 0; i < lineArray.length; i++) {
			if (lineArray[i].equals(STARTOBJECT)) {
				braceCounter++;
			}
			if (lineArray[i].equals(ENDOBJECT)) {
				braceCounter--;
				if (braceCounter == 0)
					return i + 1;
			}
		}
		return 0;
	}

	/**
	 * @param line
	 *            строка, содержащая строчное представление массива
	 * @return количество символов в массиве
	 */
	public static int getArrayLength(String line) {
		int braceCounter = 0;
		String[] lineArray = line.split("");
		for (int i = 0; i < lineArray.length; i++) {
			if (lineArray[i].equals(STARTARRAY)) {
				braceCounter++;
			}
			if (lineArray[i].equals(ENDARRAY)) {
				braceCounter--;
				if (braceCounter == 0)
					return i + 1;
			}
		}
		return 0;
	}

	/**
	 * @param line
	 *            исходная строка с подстрокой в двойных кавычках в начале
	 *            (игнорирует экранированные кавычки)
	 * @return количество символов в найденной подстроке (включая кавычки)
	 */
	public static int getStringLength(String line) {
		String[] lineArray = line.split("");
		for (int i = 1; i < lineArray.length; i++) {
			if (lineArray[i].equals(DOUBLEQUOTES) && !lineArray[i - 1].equals(BACKSLASH)) {
				return i + 1;
			}
		}
		return 0;
	}

	/**
	 * @param line
	 *            строка, содержащая строчное представление числа
	 * @return количество символов в числе
	 */
	public static int getNumberLength(String line) {
		int position = 0;
		String[] lineArray = line.split("");
		for (int i = 0; i < lineArray.length; i++) {
			if (lineArray[i].matches("[-+]?\\d?\\.?[eE]?")) {
				position++;
				continue;
			}
			break;
		}
		return position;
	}
	
	
	/**
	 * @param исходная строка
	 * @return количество символов в значении типа boolean,
	 * 			переданном в начале строки
	 */
	public static int getBooleanLength(String line) {
		if (line.matches("(true).*")) return 4;
		return 5;
	}

	/**
	 * @param line исходная строка
	 * @param length длина подстроки
	 * @return строку с вырезанной подстрокой заданной длины
	 */
	public static String cutSubstring(String line, int length) {
		return line.substring(length);
	}
	
	/**
	 * @param line строка с двоеточием в начале
	 * @return строку с обрезанным двоеточием
	 */
	public static String cutColon(String line) {
		if (line.startsWith(COLON))
			return line.substring(1);
		return null;
	}

	/**
	 * @param line строка предположительно содержащая запятую в начале
	 * @return строку без запятой в начале
	 */
	public static String cutComma(String line) {
		if (line.startsWith(COMMA))
			return line.substring(1);
		return line;
	}
}