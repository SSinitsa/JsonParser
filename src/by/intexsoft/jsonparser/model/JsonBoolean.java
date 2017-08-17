package by.intexsoft.jsonparser.model;

/**
 * �����, ����������� ������ JSON �������, ��������������� ����� ������ ����
 * boolean
 * 
 * @see AbstractJsonElement
 */
public class JsonBoolean extends AbstractJsonElement {

	/**
	 * ������� ����� ������ ������
	 * 
	 * @param value
	 *            - ������������ �������� ���� value �������
	 */
	public JsonBoolean(boolean value) {
		super();
		this.value = value;
	}
}