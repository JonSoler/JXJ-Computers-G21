package jxj.clasesBasicas;

import java.util.ArrayList;


public class ListaUsuario {

	private ArrayList<Usuario> usuarios;

	public ListaUsuario() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}	

}
