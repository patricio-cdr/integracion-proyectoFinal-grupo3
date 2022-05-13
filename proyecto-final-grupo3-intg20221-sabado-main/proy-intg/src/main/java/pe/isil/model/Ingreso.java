package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Table(name ="ingreso")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Ingreso {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idIngreso;
    @ManyToOne
    @JoinColumn(name = "proveedor_id", referencedColumnName = "idPersona")
    private Persona idProveedor;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario")
    private User idUsuario;
    private String tipo_comprobante;
    private String serie_comprobante;
    private String num_comprobante;
    private Date fecha;
    private Double impuesto;
    private Double total;
    private String estado;


}
