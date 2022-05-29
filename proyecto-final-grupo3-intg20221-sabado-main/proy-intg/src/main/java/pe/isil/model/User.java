package pe.isil.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = {"email", "password", "num_documento"}) })
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Integer idusuario;
    @Column(name = "idrol")
    private Integer idrol;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "idrol", insertable = false, updatable = false)
    private Role role;
    private String nombre;
    private String tipo_documento;
    @Column(name = "num_documento")
    private String num_documento;
    private String direccion;
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    private Integer estado;
}
