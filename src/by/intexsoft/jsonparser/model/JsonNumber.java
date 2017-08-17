package by.intexsoft.jsonparser.model;

/**
 *  ласс, описывающий модель JSON объекта, представл€ющего собой
 * объект типа Number
 * @see AbstractJsonElement
 */
public class JsonNumber extends AbstractJsonElement {

	/**
	 * —оздает новый объект класса
	 * @param value - передаваемое значение пол€ value объекта
	 */
	public JsonNumber(Number value) {
		super();
		this.value = value;
	}
	
}
