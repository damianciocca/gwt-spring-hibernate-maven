package com.springbatch.ejemplo10;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Extendemos este writer para modificar a la hora de escribir el XML ya que nos pincha cuando queremos 
 * agregar el atributo en el ROOT llamado XMLNS:
 * 
 * Caused by: javax.xml.stream.XMLStreamException: xmlns has been already bound to . Rebinding it to http://www.gemalto.com/schema/pm is an error
 * 
 * 
 * @author dciocca
 *
 */
public class CustomStaxEventItemWriter extends StaxEventItemWriter{

	@Override
	protected void startDocument(XMLEventWriter writer) throws XMLStreamException {

		XMLEventFactory factory = createXmlEventFactory();

		// write start document
		writer.add(factory.createStartDocument(getEncoding(), getVersion()));

		// write root tag
		writer.add(factory.createStartElement(getRootTagNamespacePrefix(), getRootTagNamespace(), getRootTagName()));
		if (StringUtils.hasText(getRootTagNamespace())) {
			if (StringUtils.hasText(getRootTagNamespacePrefix())) {
				writer.add(factory.createNamespace(getRootTagNamespacePrefix(), getRootTagNamespace()));
			}
			else {
				writer.add(factory.createNamespace(getRootTagNamespace()));
			}
		}

		// write root tag attributes
		if (!CollectionUtils.isEmpty(getRootElementAttributes())) {

			Map<String, String> rootElementAttributes2 = getRootElementAttributes();
			Set<Entry<String, String>> entrySet = rootElementAttributes2.entrySet();
			
			for (Map.Entry<String, String> entry : entrySet) {
				String key = entry.getKey();
				if (key.startsWith("xmlns")) {
					String prefix = "";
					if (key.contains(":")) {
						prefix = key.substring(key.indexOf(":") + 1);
						writer.add(factory.createNamespace(prefix, entry.getValue()));
					} else { // FIX para q no nos pinche cuando metemos un XMLNS con una URL.. 
						writer.add(factory.createAttribute(key, entry.getValue()));
					}
				}
				else {
					writer.add(factory.createAttribute(key, entry.getValue()));
				}
			}

		}

		/*
		 * This forces the flush to write the end of the root element and avoids
		 * an off-by-one error on restart.
		 */
		writer.add(factory.createIgnorableSpace(""));
		writer.flush();
		
		
	}

	
}
