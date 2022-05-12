package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = {"email", "clave", "num_documento"}) })
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer idUsuario;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "idrol")
    private Role role;
    private String nombre;
    private String tipo_documento;
    @Column(name = "num_documento")
    private String num_documento;
    private String direccion;
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "clave")
    private String clave;
    private Integer estado;
}
