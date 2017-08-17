package by.intexsoft.jsonparser.model;

/**
 * �����, ����������� ������ JSON �������, ��������������� �����
 * ���� JsonString key � Object value
 * @see AbstractJsonElement
 */
public class JsonKeyValue extends AbstractJsonElement {

	JsonString key;

	/**
	 * ������� ����� ������ ������
	 * @param key - ������������ �������� ���� key
	 * @param value - ������������ �������� ���� value
	 */
	public JsonKeyValue(JsonString key, AbstractJsonElement value) {
		super();
		this.value = value;
		this.key = key;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\n" + key + ": " + value;
	}
}
