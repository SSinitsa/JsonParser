package by.intexsoft.jsonparser.model;

import java.util.LinkedList;
import java.util.List;

/**
 * ����� ����������� ������ JSON �������, ��������������� ����� ���������
 * ��������� ���� AbstractJsonElement
 * �������� ����� add(AbstractJsonElement element), �����������
 * ��������� ����� ������� � ���������
 * @see  AbstractJsonElement
 */
public class JsonArray extends AbstractJsonElement {

	/**
	 * ������� ����� ������ ������ JsonArray
	 */
	public JsonArray() {
		super();
		this.value = new LinkedList<AbstractJsonElement>();
	}
	
	/**
	 * ��������� ����� ������� ���� AbstractJsonElement
	 * � ��������� �������
	 */
	@SuppressWarnings("unchecked")
	public void add(AbstractJsonElement element) {
		((List<AbstractJsonElement>) value).add(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value.toString();
	}

}
