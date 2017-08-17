package by.intexsoft.jsonparser.model;

/**
 * �����, ����������� ������ JSON �������, ��������������� �����
 * ������ ���� String
 * @see AbstractJsonElement
 */
public class JsonString extends AbstractJsonElement {

	/**
	 * ������� ����� ������ ������
	 * @param value - ������������ �������� ���� value �������
	 */
	public JsonString(String value) {
		super();
		this.value = value;
	}
}
