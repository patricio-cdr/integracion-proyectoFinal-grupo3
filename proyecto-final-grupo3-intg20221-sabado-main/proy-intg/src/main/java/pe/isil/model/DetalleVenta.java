package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name ="detalleVenta")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idDetalleVenta;
    @ManyToOne
    @JoinColumn(name = "venta_id", referencedColumnName = "idVenta")
    private Venta idVenta;
    @ManyToOne
    @JoinColumn(name = "articulo_id", referencedColumnName = "idArticulo")
    private Articulo idArticulo;
    private Integer cantidad;
    private Double precio;
    private Double descuento;
}
