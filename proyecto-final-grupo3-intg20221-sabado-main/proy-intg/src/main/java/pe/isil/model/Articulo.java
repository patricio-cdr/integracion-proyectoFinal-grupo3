package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name ="articulo")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Articulo {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idArticulo;
    @OneToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "idCategoria")
    private Categoria idCategoria;
    private String codigo;
    private String nombre;
    private Double precio_venta;
    private Integer stock;
    private String descripcion;
    private String imagen;
    private Integer estado;
}
