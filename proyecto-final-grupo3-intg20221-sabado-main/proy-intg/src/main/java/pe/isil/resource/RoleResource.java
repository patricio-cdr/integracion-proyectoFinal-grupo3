package pe.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Role;
import pe.isil.model.User;
import pe.isil.service.RoleService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class RoleResource {

    private RoleService roleService;

    public RoleResource(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){
        List<Role> roles = roleService.read();
        if (roles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/roles/{idrol}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer idrol){

        return roleService.readById(idrol)
                .map(role -> new ResponseEntity<>(role, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> postRole(@RequestBody Role role){
        roleService.create(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @PutMapping("/roles/{idrol}")
    public ResponseEntity<Role> putRole(@RequestBody Role role,
                                        @PathVariable Integer idrol){

        return roleService.readById(idrol)
                .map(currentRole -> {
                    role.setIdrol(idrol);
                    roleService.update(currentRole);
                    return new ResponseEntity<>(role, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }
    @DeleteMapping("/roles/{idrol}")
    public ResponseEntity deleteRole(@PathVariable Integer idrol){

        return roleService.readById(idrol)
                .map(s -> {
                    roleService.delete(s);
                    return new ResponseEntity<>(HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));



    }

}
