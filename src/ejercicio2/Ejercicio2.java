package ejercicio2;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		try {
			String nombreJuego="",plataforma="";
			int anyoLanzamiento=0,notaMetacritic=0;
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
	
			//Creamos un objeto File con el fichero XML que queremos leer.
			File archivo=new File("videojuegos.xml");
			Document documento=builder.parse(archivo);
			//Extraemos el element root del documento:	
			Element xml=documento.getDocumentElement();
	
			//De este element, vamos a obtener todos sus nodos hijo (nodos <juego>)
			NodeList nodosJuego=xml.getChildNodes();
			//Vamos a recorrer los nodos <juego>
			for(int i=0;i<nodosJuego.getLength();i++) {
				//Extraemos el nodo que vamos a tratar
				Node juego=nodosJuego.item(i);
				//Comprobamos que el nodo que acabamos de leer es un Elemento
				if(juego.getNodeType()!=Node.ELEMENT_NODE) {
					//Si el nodo leido no es un Nodo <juego>, nos lo saltamos
					continue;
				}
				//Si es un nodo de tipo Elemento, obtenemos sus nodos hijo.
				NodeList hijosJuego=juego.getChildNodes();
				for(int j=0;j<hijosJuego.getLength();j++) {
					Node nodo=hijosJuego.item(j);
					if(nodo.getNodeName().equals("nombre")) {
						//Estoy leyendo el nombre del juego.
						nombreJuego=nodo.getTextContent();
					}else if(nodo.getNodeName().equals("plataforma")) {
						//Estoy leyendo la plataforma del juego
						plataforma=nodo.getTextContent().trim();
					}else if(nodo.getNodeName().equals("fechaSalida")) {
						//Estoy leyendo la fecha de salida
						String[] partesFecha=nodo.getTextContent().split(" ");
						anyoLanzamiento=Integer.parseInt(partesFecha[2]);
					}else if(nodo.getNodeName().equals("notaMetacritic")) {
						//Estoy leyendo la nota de Metacritic.
						notaMetacritic=Integer.parseInt(nodo.getTextContent());
					}	
				}
				//Una vez he leido todos los datos necesarios de un juego, puedo imprimir su información
				if(notaMetacritic>=90) {
					System.out.println("Nombre:"+nombreJuego+"\tPlataforma: "+plataforma+
									   "\tAño Lanzamiento:"+anyoLanzamiento);
				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
