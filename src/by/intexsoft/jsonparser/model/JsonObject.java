package by.intexsoft.jsonparser.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс описывающий модель JSON объекта, представляющего собой коллекцию
 * элементов типа JsonKeyValue
 * Содержит метод add(JsonKeyValue keyValue), позволяющий
 * добавлять новый элемент в коллекцию
 * @see AbstractJsonElement
 */
public class JsonObject extends AbstractJsonElement {

	/**
	 * Создает новый объект класса JsonObject
	 */
	public JsonObject() {
		super();
		this.value = new LinkedList<JsonKeyValue>();
	}

	/**
	 * Добавляет новый элемент типа JsonKeyValue
	 * в коллекцию объекта
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
