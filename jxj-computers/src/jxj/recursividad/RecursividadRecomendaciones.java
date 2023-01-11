package jxj.recursividad;

import java.util.ArrayList;
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
}
