package jxj.clasesBasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import jxj.seccionDisp.Dispositivo;


public class ListaDispositivo {

	private Map<Integer, Dispositivo> dispositivos = new TreeMap<>();


	public Map<Integer, Dispositivo> getDispositivos() {

		return dispositivos;
	}

	public void setProductos(Map<Integer, Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	public void listaCoche() {
		this.dispositivos = new HashMap<Integer, Dispositivo>();
	}

}
