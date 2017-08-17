package by.intexsoft.jsonparser.parser;

import by.intexsoft.jsonparser.exception.InvalidJsonException;
import by.intexsoft.jsonparser.model.AbstractJsonElement;

interface Parser {
	
	AbstractJsonElement parse (String sourceLine) throws InvalidJsonException;

}
