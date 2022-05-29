package pe.isil.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name ="rol")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Integer idrol;
    private String nombre;
    private String descripcion;
    private Integer estado;
    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    @Transient
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<User> users;
}
