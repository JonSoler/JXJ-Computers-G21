package jxj.recursividad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.seccionDisp.Dispositivo;
import jxj.seccionDisp.Movil;

public class RecursividadRecomendaciones {
	private List<List<Movil>> al;
	
	public RecursividadRecomendaciones(double importe, List<Movil> ad) {
		al = recomendaciones(importe, ad);
	}
	public List<List<Movil>> recomendaciones(double importe, List<Movil> ad){
		List<List<Movil>> recom = new ArrayList<>();
		combinaciones(recom,ad,importe,100,new ArrayList<>());
		return recom;
	}
	public void combinaciones(List<List<Movil>> recom, List<Movil>ad, double importe, double sobrante, List<Movil> temp){
		if(importe < 0)
			return;
		else if(importe < sobrante){
			Comparator<Movil> comp = (m1,m2)->{return m1.getId().compareTo(m2.getId());};
			Collections.sort(temp,comp);
			if(!recom.contains(temp)) {
				recom.add(new ArrayList<>(temp));
				
			}
		}else {
			for(Movil m: ad) {
					temp.add(m);
					combinaciones(recom, ad, importe-m.getPrecio(), sobrante, temp);
					temp.remove(temp.size()-1);
				
			}
		}
	}
	public void mostrarOpciones() {
		int i=1;
		for(List<Movil> a: al) {
			System.out.println("OPCIÓN: "+i);
			for(Dispositivo d: a) {
				System.out.println("\t"+d);
			}
			i++;
		}
	}
	
	public List<List<Movil>> getAl() {
		return al;
	}

	public void setAl(List<List<Movil>> al) {
		this.al = al;
	}

	public static void main(String[] args) {
		try {
			DBManager.initBD("JXJComputers.db");
			ArrayList<Movil> ad = DBManager.listarMovil();
			/**
			 * Añadimos la cantidad de dinero que queremos gastar, de esta manera,
			 * se nos generan todas las combinaciones de compra posibles con esa cantidad
			 */
			RecursividadRecomendaciones rr = new RecursividadRecomendaciones(700, ad);
			rr.mostrarOpciones();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
