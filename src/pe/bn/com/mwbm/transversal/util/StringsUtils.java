package pe.bn.com.mwbm.transversal.util;

import java.text.ParseException;

public class StringsUtils {
	public static String obtenerCadenaDespuesDePunto(String cadenaConPunto) {
		return cadenaConPunto.substring(cadenaConPunto.lastIndexOf('.') + 1);
	}

	public static String concatenarCadena(Object... objetos) {
		StringBuffer sb = new StringBuffer();
		for (Object objeto : objetos) {
			sb.append(objeto.toString());
		}
		return sb.toString();
	}
	
	public static String concatenarTexto(String... variables) {
		StringBuffer sb = new StringBuffer();
		for (String valor : variables) {
			sb.append(obtenerValor(valor));
		}
		return sb.toString();
	}
	

	public static String[] obtenerSubCadenas(String cadena, String separador) {
		return cadena.split(separador, 2);
	}

	public static String obtenerCadenaDespuesDe(String cadena, String separador) {
		if (cadena != null && cadena.length() > 0) {
			return cadena.substring(cadena.lastIndexOf(separador) + 1);
		}
		return cadena;
	}

	public static String obtenerCadenaAntesDe(String cadena, String separador) {
		if (cadena != null && cadena.length() > 0) {
			return cadena.substring(0, cadena.lastIndexOf(separador));
		}
		return cadena;
	}

	public static String removerUltimoCaracter(String cadena) {
		if (cadena != null && cadena.length() > 0) {
			cadena = cadena.substring(0, cadena.length() - 1);
		}
		return cadena;
	}
	
	/**
	 * Método que sirve poner en mayúscula un texto.
	 * 
	 * @param cadena
	 * @return texto en mayúscula
	 */
	public static String toUpperText(String cadena){
		cadena = (cadena != null && cadena.length() > 0) ? cadena.toUpperCase() : cadena;
		return cadena;
	}
	
	public static int formatInteger (String numero) throws ParseException{
		return Integer.parseInt(removeComma(numero));
	}
	
	public static Float formatFloat (String numero) throws ParseException{
		return Float.parseFloat(removeComma(numero));
	}
	
	public static String obtenerValor(String texto){
		try {
			return texto.equals(null) ? "" : texto.trim();			
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String removeComma(String valor){
		return ReplaceAll(valor,",","");
	}
	
	public static String sumarMontos(String num, String num2, String type) throws ParseException{
		String valor = null; 
		if(type.equals("cantidad")){
			valor = String.valueOf(formatInteger(num)+formatInteger(num2));
		}else if(type.equals("monto")){
			valor = String.valueOf(formatFloat(num)+formatFloat(num2));
		}
		else{
			valor = "0";
		}
		return valor;
	}
	

	
	public static String ReplaceAll(String text, String simbolo, String newSimbolo){
		return text.replaceAll(simbolo, newSimbolo);
	}
	


}
