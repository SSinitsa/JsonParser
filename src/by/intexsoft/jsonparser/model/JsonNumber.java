package by.intexsoft.jsonparser.model;

/**
 * �����, ����������� ������ JSON �������, ��������������� �����
 * ������ ���� Number
 * @see AbstractJsonElement
 */
public class JsonNumber extends AbstractJsonElement {

	/**
	 * ������� ����� ������ ������
	 * @param value - ������������ �������� ���� value �������
	 */
	public JsonNumber(Number value) {
		super();
		this.value = value;
	}
	
}
