package by.intexsoft.jsonparser.parser;

import by.intexsoft.jsonparser.model.JsonString;
import by.intexsoft.jsonparser.utils.Utils;

/**
 * ����� ��� �������� ������, ���������� JSON ������ ���� String
 * �������� ����� parse(String sourceLine)
 */
public class StringParser implements Parser{

	/**
	 * ����� ��� �������� ������.
	 * @param sourceLine - ������� ������
	 * @return ������ ���� JsonString
	 */
	@Override
	public JsonString parse(String sourceLine) {
		int stringLength = Utils.getStringLength(sourceLine);
		return new JsonString(sourceLine.substring(0, stringLength));
	}

}
