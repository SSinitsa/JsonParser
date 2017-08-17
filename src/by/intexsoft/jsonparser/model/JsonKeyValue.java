package by.intexsoft.jsonparser.model;

/**
 *  ласс, описывающий модель JSON объекта, представл€ющего собой
 * пару JsonString key и Object value
 * @see AbstractJsonElement
 */
public class JsonKeyValue extends AbstractJsonElement {

	JsonString key;

	/**
	 * —оздает новый объект класса
	 * @param key - передаваемое значение пол€ key
	 * @param value - передаваемое значение пол€ value
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
