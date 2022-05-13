package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name ="persona")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idPersona;
    private String tipo_persona;
    private String nombre;
    private String tipo_documento;
    private String num_documento;
    private String direccion;
    private String telefono;
    private String email;


}
