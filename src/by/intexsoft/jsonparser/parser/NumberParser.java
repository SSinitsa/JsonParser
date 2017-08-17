package by.intexsoft.jsonparser.parser;

import static by.intexsoft.jsonparser.utils.Utils.getNumberLength;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.JsonNumber;

/**
 * ����� ��� �������� ������, ���������� ����� ������ ���� � �������
 * �������� ����� parse(String sourceLine)
 */
public class NumberParser implements Parser {

	/**
	 * ����� ��� �������� ����� �� ������.
	 * @param sourceLine - ������� ������, ���������� ����� ������ ���� � �������
	 * @return ������ ���� JsonNumber
	 */
	@Override
	public JsonNumber parse(String sourceLine) throws InvalidJsonException {
		String targetLine = (sourceLine.substring(0, getNumberLength(sourceLine)));
		if (targetLine.matches("-?\\d+"))
			return new JsonNumber(Integer.parseInt(targetLine));
		if (targetLine.matches("-?\\d+\\.\\d+"))
			return new JsonNumber(Double.parseDouble(targetLine));
		if (targetLine.matches("-?\\d+\\.?\\d+[eE][-+]?\\d+"))
			return new JsonNumber(getNumberType(targetLine));
		throw new InvalidJsonException();
	}

	private Number getNumberType(String targetLine) {
		if (Double.parseDouble(targetLine) % 1 == 0)
			return (int) (Double.parseDouble(targetLine));
		return Double.parseDouble(targetLine);
	}
}
