package Ejercicio3;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Ejercicio3 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		SAXParserFactory factory=SAXParserFactory.newInstance();
		SAXParser parser=factory.newSAXParser();
		
		File archivo=new File("videojuegos.xml");
		LectorVideojuegos lectorSAX=new LectorVideojuegos();
		
		parser.parse(archivo, lectorSAX);
	}
}
