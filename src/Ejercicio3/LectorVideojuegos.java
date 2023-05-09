package Ejercicio3;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class LectorVideojuegos extends DefaultHandler {
	//Tenemos que sobreescribir 5 metodos: startElement(), endElement(), StartDocument(),EndDocument() y Characters()
	private String textoLeido="";
	private String nombre="",plataforma="";
	private int puntuacion=0;
	private int anyoLanzamiento=0;
	
	@Override
	public void startDocument() {
		System.out.println("Inicio de lectura de documento");
	}
	@Override
	public void endDocument() {
		System.out.println("Fin de lectura de documento");
	}
	@Override
	public void startElement(String uri, String namespace, String nombreElemento, Attributes atributos) {
		
	}
	
	@Override
	public void endElement(String uri, String namespace, String nombreElemento) {
		if(nombreElemento.equals("nombre")) {
			nombre=textoLeido;
		}else if(nombreElemento.equals("plataforma")) {
			plataforma=textoLeido.trim();
		}else if(nombreElemento.equals("notaMetacritic")) {
			puntuacion=Integer.parseInt(textoLeido);
		}else if(nombreElemento.equals("fechaSalida")) {
			String[] partesFecha=textoLeido.split(" ");
			anyoLanzamiento=Integer.parseInt(partesFecha[2]);
		}else if(nombreElemento.equals("juego")&&plataforma.equals("Xbox 360")) {
			System.out.println("Nombre:"+nombre+"\tPuntuación:"+puntuacion+"\tAño Lanzamiento:"+anyoLanzamiento);
		}
	}
	@Override
	public void characters(char[] caracteres,int inicio, int longitud) {
		textoLeido=new String(caracteres,inicio,longitud);
	}
}
