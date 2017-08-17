package by.intexsoft.jsonparser.model;

import java.util.List;

/**
 * ����������� �����, ���������� ����� ���� value
 * � ����� ������� , ����������� �������� ������� ����������
 * JSON ���������
 *
 */
public abstract class AbstractJsonElement {

	Object value;

	/**
	 * ����� ���� � ������� �������� �������� �� ����������� �����
	 * ���� ������, � ������� ���������� ����� �� �������� JSON ��������,
	 * ������������ �������� ������ (����� ������������)
	 * @param key ���� �� �������� �������������� �����
	 * @return �������� ��������
	 */
	@SuppressWarnings({ "unchecked" })
	public AbstractJsonElement getValue(String key) {
		if (!(this instanceof JsonObject)) return this;
		for (JsonKeyValue pair : (List<JsonKeyValue>) value) {
			if (pair.key.toString().equals("\"" + key + "\""))
				return (AbstractJsonElement) pair.value;
		}
		return null;
	}

	/**
	 * ����� ���� ������� ������� �� ��������� �������
	 * ���� ���������� �� � ������� JsonArray ����� ������������
	 * @param index ������ �������� ��������
	 * @return ������ ���� AbstractJsonElement
	 */
	@SuppressWarnings("unchecked")
	public AbstractJsonElement get(int index) {
		if (!(this instanceof JsonArray)) return this;
		return ((List<AbstractJsonElement>) value).get(index);
	}

	/**
	 * ����� ���������� ������ ������� ����������� � �������, � �������� �� ����������
	 * ���� � ������� ��� �������, ������������ 0
	 */
	@SuppressWarnings("unchecked")
	public int size() {
		if (!(this instanceof JsonArray)) return 0;
		List<AbstractJsonElement> tempList = (List<AbstractJsonElement>) this.value;
		return tempList.size();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value.toString();
	}
}
