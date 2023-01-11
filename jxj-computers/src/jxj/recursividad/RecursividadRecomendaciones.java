package jxj.recursividad;

import java.util.ArrayList;
import jxj.dataBase.DBException;
import jxj.dataBase.DBManager;
import jxj.seccionDisp.Dispositivo;
import jxj.seccionDisp.Movil;

public class RecursividadRecomendaciones {
	private ArrayList<ArrayList<Movil>> al;
	
	public RecursividadRecomendaciones(double importe, ArrayList<Movil> ad) {
		al = new ArrayList<>();
		r(importe, al, new ArrayList<Movil>(), ad, 0);
	}
	
	public void r (double importe, ArrayList<ArrayList<Movil>> al, ArrayList<Movil> aux, ArrayList<Movil> ad, int i) {
		if(i<ad.size()) {
			if(importe>0) {
				importe = importe - ad.get(i).getPrecio();
				aux.add(ad.get(i));
				r(importe, al, aux, ad, i+1);
				//importe = importe + ad.get(i).getPrecio();
				//aux.remove(i);
			}else {
				al.add(aux);	
			}
		}else {
			al.add(aux);
		}
	}
	
	public void mostrarOpciones() {
		int i=1;
		for(ArrayList<Movil> a: al) {
			System.out.println("OPCIÓN: "+i);
			for(Dispositivo d: a) {
				System.out.println("\t"+d);
			}
		}
	}
	
	public ArrayList<ArrayList<Movil>> getAl() {
		return al;
	}

	public void setAl(ArrayList<ArrayList<Movil>> al) {
		this.al = al;
	}

	public static void main(String[] args) {
		try {
			DBManager.initBD("JXJComputers.db");
			ArrayList<Movil> ad = DBManager.listarMovil();
			RecursividadRecomendaciones rr = new RecursividadRecomendaciones(700, ad);
			rr.mostrarOpciones();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
