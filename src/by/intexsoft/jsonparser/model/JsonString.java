package by.intexsoft.jsonparser.model;

/**
 *  ласс, описывающий модель JSON объекта, представл€ющего собой
 * объект типа String
 * @see AbstractJsonElement
 */
public class JsonString extends AbstractJsonElement {

	/**
	 * —оздает новый объект класса
	 * @param value - передаваемое значение пол€ value объекта
	 */
	public JsonString(String value) {
		super();
		this.value = value;
	}
}
