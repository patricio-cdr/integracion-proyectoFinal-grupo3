package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name ="rol")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idrol;
    private String nombre;
    private String descripcion;
    private Integer estado;
}
