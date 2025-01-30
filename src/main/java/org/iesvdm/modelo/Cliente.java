package org.iesvdm.modelo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//La anotación @Data de lombok proporcionará el código de:
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	private long id;

	@NotBlank(message = "Por favor, introduzca un nombre")
	@Size(min=3, message = "Nombre al menos de 3 caracteres.")
	private String nombre;

	@NotBlank(message = "Por favor, introduzca un apellido")
	@Size(min=3, message = "Apellido al menos de 3 caracteres.")
	private String apellido1;

	@NotBlank(message = "Por favor, introduzca un apellido")
	@Size(min=3, message = "Apellido al menos de 3 caracteres.")
	private String apellido2;

	@NotBlank(message = "Por favor, introduzca una ciudad")
	private String ciudad;
	private int categoria;
	
}
