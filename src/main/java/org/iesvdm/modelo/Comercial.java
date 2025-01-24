package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Comercial {

	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private float comision;

	public Comercial(int id, String nombre, String apellido1, String apellido2, float comisión) {
	}

	public Comercial() {

	}
}
