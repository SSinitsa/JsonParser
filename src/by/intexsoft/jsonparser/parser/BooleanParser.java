package by.intexsoft.jsonparser.parser;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.JsonBoolean;

/**
  * ����� ��� �������� ������, ���������� �������� ���� boolean
 * �������� ����� parse(String sourceLine)
 */
public class BooleanParser implements Parser {

	/**
	 * ����� ��� �������� �������� ���� boolean �� ������.
	 * @param sourceLine - ������� ������, ���������� �������� boolean
	 * @return ������ ���� JsonBoolean
	 */
	@Override
	public JsonBoolean parse(String sourceLine) throws InvalidJsonException {
		if (sourceLine.matches("(true).*")) return new JsonBoolean(true);
		if (sourceLine.matches("(false).*")) return new JsonBoolean(false);
		throw new InvalidJsonException();
	}

}
