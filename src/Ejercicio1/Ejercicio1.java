package Ejercicio1;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejercicio1 {

	public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException {
	
		//Creamos 5 objetos ciudad y los introducimos en un array.
		Ciudad c1=new Ciudad("Valladolid",298000,"Oscar Puente","PSOE","Vallisoletano","Castilla y Leon");
		Ciudad c2=new Ciudad("Santander",173000,"Laura Perez","OO","santanderino","Cantabria");
		Ciudad[] ciudades= {c1,c2};
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document documentoXML=builder.newDocument();
		
		Element elementoCiudades=documentoXML.createElement("ciudades");
		
		for(Ciudad c:ciudades) {
			Element elementoCiudad=documentoXML.createElement("ciudad");
			Element elementoHabitantes=documentoXML.createElement("habitantes");
			Element elementoAlcalde=documentoXML.createElement("alcalde");
			Element elementoGentilicio=documentoXML.createElement("gentilicio");
			Element elementoComunidad=documentoXML.createElement("comunidadAutonoma");
			
			Text textoHabitantes=documentoXML.createTextNode(String.valueOf(c.getPoblacion()));
			Text textoAlcalde=documentoXML.createTextNode(c.getNombreAlcalde());
			Text textoGentilicio=documentoXML.createTextNode(c.getGentilicio());
			Text textoComunidad=documentoXML.createTextNode(c.getComunidadAutonoma());
			
			//Vamos a añadir los atributos, en nuestro caso tenemos dos.
			
			elementoCiudad.setAttribute("nombre", c.getNombre());
			elementoAlcalde.setAttribute("partido",c.getNombrePartido());
			
			//Introduzco los nodos texto en los nodos elemento
			elementoHabitantes.appendChild(textoHabitantes);
			elementoAlcalde.appendChild(textoAlcalde);
			elementoGentilicio.appendChild(textoGentilicio);
			elementoComunidad.appendChild(textoComunidad);
			
			//Ahora, añado los cuatro elementos (que ya tienen el texto incluido) como hijos del elemento ciudad
			elementoCiudad.appendChild(elementoHabitantes);
			elementoCiudad.appendChild(elementoAlcalde);
			elementoCiudad.appendChild(elementoGentilicio);
			elementoCiudad.appendChild(elementoComunidad);
			
			//añado el elemento ciudad al elemento root (ciudades)
			elementoCiudades.appendChild(elementoCiudad);
		}
		documentoXML.appendChild(elementoCiudades);
		saveXMLtoFile(documentoXML,"ciudades.xml");
		
	}
	public static void saveXMLtoFile(Document document,String fileName) throws IOException,TransformerException {
		
		DOMSource domSource=new DOMSource(document);
		FileWriter writer=new FileWriter(""+fileName);
		StreamResult result=new StreamResult(writer);
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.INDENT,"yes");
		transformer.setOutputProperty(OutputKeys.STANDALONE,"yes");
		transformer.transform(domSource, result);		
		writer.close();	
		}
}
