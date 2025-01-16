package com.aluracursos.modelos;

import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {

	private List<Operacion> operaciones;

	public HistorialConversiones() {
		this.operaciones = new ArrayList<Operacion>();
	}

	public void guardar(Operacion operacion) {
		this.operaciones.add(operacion);

	}

	public List<Operacion> getOperaciones() {
		return operaciones;
	}

}
