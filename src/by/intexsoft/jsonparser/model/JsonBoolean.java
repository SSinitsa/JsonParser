package by.intexsoft.jsonparser.model;

/**
 *  ласс, описывающий модель JSON объекта, представл€ющего собой объект типа
 * boolean
 * 
 * @see AbstractJsonElement
 */
public class JsonBoolean extends AbstractJsonElement {

	/**
	 * —оздает новый объект класса
	 * 
	 * @param value
	 *            - передаваемое значение пол€ value объекта
	 */
	public JsonBoolean(boolean value) {
		super();
		this.value = value;
	}
}