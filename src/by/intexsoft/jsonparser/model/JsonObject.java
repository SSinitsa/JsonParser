package by.intexsoft.jsonparser.model;

import java.util.LinkedList;
import java.util.List;

/**
 * ����� ����������� ������ JSON �������, ��������������� ����� ���������
 * ��������� ���� JsonKeyValue
 * �������� ����� add(JsonKeyValue keyValue), �����������
 * ��������� ����� ������� � ���������
 * @see AbstractJsonElement
 */
public class JsonObject extends AbstractJsonElement {

	/**
	 * ������� ����� ������ ������ JsonObject
	 */
	public JsonObject() {
		super();
		this.value = new LinkedList<JsonKeyValue>();
	}

	/**
	 * ��������� ����� ������� ���� JsonKeyValue
	 * � ��������� �������
	 */
	@SuppressWarnings("unchecked")
	public void add(JsonKeyValue keyValue) {
		((List<JsonKeyValue>) value).add(keyValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		List<JsonKeyValue> tempList = (List<JsonKeyValue>) this.value;
		if (tempList.isEmpty())
			return "{}";
		return "\n{\n" + value.toString().substring(2, value.toString().length() - 1) + "\n}";
	}

}
