package by.intexsoft.jsonparser.model;

import java.util.List;

/**
 * Абстрактный класс, содержащий общее поле value
 * и набор методов , необходимых дочерним классам конкретных
 * JSON элементов
 *
 */
public abstract class AbstractJsonElement {

	Object value;

	/**
	 * Метод ищет в объекте значение элемента по переданному ключу
	 * Если объект, в котором вызывается метод не является JSON объектом,
	 * возвращается исходный объект (метод игнорируется)
	 * @param key ключ по которому осуществляется поиск
	 * @return значение элемента
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
	 * Метод ищет элемент массива по заданному индексу
	 * Если вызывается не у массива JsonArray метод игнорируется
	 * @param index индекс имкомого элемента
	 * @return объект типа AbstractJsonElement
	 */
	@SuppressWarnings("unchecked")
	public AbstractJsonElement get(int index) {
		if (!(this instanceof JsonArray)) return this;
		return ((List<AbstractJsonElement>) value).get(index);
	}

	/**
	 * Метод возвращает размер массива хранящегося в объекте, у которого он вызывается
	 * Если в объекте нет массива, возвращается 0
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
