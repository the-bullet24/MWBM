package pe.bn.com.mwbm.transversal.util;

public class Filtro {
	
	public static int inicializarMaxLength(int tipoBusqueda){
		if(tipoBusqueda == 1){
			return 8;
		}else if(tipoBusqueda == 2){
			return 9;
		}else if(tipoBusqueda == 4 || tipoBusqueda == 5) {
			return 12;
		}else{
			return 8;
		}
	}
	
	public static boolean filtroConsultaAfiliaciones(int tipoBusqueda){
		if(tipoBusqueda == 1){
			return true;
		}else {
			return false;
		}
	}
	
	public static int inicializarFiltroClaveSMS(int tipoBusqueda){
		if (tipoBusqueda == 2 || tipoBusqueda == 1) {
			return 12;
		} else if (tipoBusqueda == 4) {
			return 9;
		} else  {
			return 8;
		}
	}
	
	public static boolean filtroConsultaClaveSMS(int tipoBusqueda){
		if(tipoBusqueda == 3){
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean filtroOcultarConsultaClaveSMS(int tipoBusqueda){
		if(tipoBusqueda == 1){
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean filtroOcultarConsolidado(int tipoBusqueda){
		if(tipoBusqueda == 1 || tipoBusqueda == 2){
			return true;
		}else {
			return false;
		}
	}
	public static boolean filtroOperacionesMV(int tipoBusqueda){
		if(tipoBusqueda == 3){
			return true;
		}else {
			return false;
		}
	}

}
