package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name ="categoria")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idCategoria;
    private String nombre;
    private String descripcion;
    private Integer estado;

}
