package by.intexsoft.jsonparser.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс описывающий модель JSON объекта, представляющего собой коллекцию
 * элементов типа AbstractJsonElement
 * Содержит метод add(AbstractJsonElement element), позволяющий
 * добавлять новый элемент в коллекцию
 * @see  AbstractJsonElement
 */
public class JsonArray extends AbstractJsonElement {

	/**
	 * Создает новый объект класса JsonArray
	 */
	public JsonArray() {
		super();
		this.value = new LinkedList<AbstractJsonElement>();
	}
	
	/**
	 * Добавляет новый элемент типа AbstractJsonElement
	 * в коллекцию объекта
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
