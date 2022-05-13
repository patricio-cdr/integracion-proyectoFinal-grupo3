package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name ="detalleIngreso")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class DetalleIngreso {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idDetalleIngreso;
    @ManyToOne
    @JoinColumn(name = "ingreso_id", referencedColumnName = "idIngreso")
    private Ingreso idIngreso;
    @ManyToOne
    @JoinColumn(name = "articulo_id", referencedColumnName = "idArticulo")
    private Articulo idArticulo;
    private Integer cantidad;
    private Double precio;

}
