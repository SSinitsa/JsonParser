package by.intexsoft.jsonparser.app;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.AbstractJsonElement;
import by.intexsoft.jsonparser.parser.JsonParser;

/**
 * ����� ��� ������ ����������
 * � ������ main ��������� ������ �������, � ������������ ���������� ���� � JSON �����
 * � ������� ���������� ����� parse(), ������������ ������ ����  AbstractJsonElement,
 * �������������� ����� ����������� �� JSON� Java ������
 */
public class Runner {

	public static void main(String[] args) throws InvalidJsonException {

		JsonParser parser = new JsonParser("test.json");
		AbstractJsonElement element = parser.parse();
		System.out.println(element);
	}
}
