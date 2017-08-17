package by.intexsoft.jsonparser.utils;

import static by.intexsoft.jsonparser.utils.JsonTypes.*;


/**
 * ����� �������� ����������� ��������� � ������
 * ��� ������ �� ��������
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
	 * ����� ��������� ��� ���������� ������� � �������� �� ������
	 * ���������� �������, ����������� � ������� �������
	 * @param sourceLine �������� ������
	 * @return ����������������� ������
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
	 * ������ ������������ ��� JSON ������� � ������������ ������
	 * @param sourceLine �������� ������
	 * @return �������� JsonTypes
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
	 * @param line ������ ���������� ������
	 * @return ���� ������� ��� �������� ������ � ������ � ����� ������
	 */
	public static String findObjectBody(String line) {
		return line.substring(line.indexOf(STARTOBJECT) + 1, line.lastIndexOf(ENDOBJECT));
	}
	
	/**
	 * @param line
	 *            ������, ���������� �������� ������������� �������
	 * @return ���������� �������� � �������
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
	 *            ������, ���������� �������� ������������� �������
	 * @return ���������� �������� � �������
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
	 *            �������� ������ � ���������� � ������� �������� � ������
	 *            (���������� �������������� �������)
	 * @return ���������� �������� � ��������� ��������� (������� �������)
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
	 *            ������, ���������� �������� ������������� �����
	 * @return ���������� �������� � �����
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
	 * @param �������� ������
	 * @return ���������� �������� � �������� ���� boolean,
	 * 			���������� � ������ ������
	 */
	public static int getBooleanLength(String line) {
		if (line.matches("(true).*")) return 4;
		return 5;
	}

	/**
	 * @param line �������� ������
	 * @param length ����� ���������
	 * @return ������ � ���������� ���������� �������� �����
	 */
	public static String cutSubstring(String line, int length) {
		return line.substring(length);
	}
	
	/**
	 * @param line ������ � ���������� � ������
	 * @return ������ � ���������� ����������
	 */
	public static String cutColon(String line) {
		if (line.startsWith(COLON))
			return line.substring(1);
		return null;
	}

	/**
	 * @param line ������ ���������������� ���������� ������� � ������
	 * @return ������ ��� ������� � ������
	 */
	public static String cutComma(String line) {
		if (line.startsWith(COMMA))
			return line.substring(1);
		return line;
	}
}