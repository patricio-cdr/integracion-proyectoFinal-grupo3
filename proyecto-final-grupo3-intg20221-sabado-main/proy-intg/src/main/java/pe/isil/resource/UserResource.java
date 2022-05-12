package pe.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.User;
import pe.isil.service.UserService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.read();
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{idusuario}")
    public ResponseEntity<User> getUserById(@PathVariable Integer idusuario){

        return userService.readById(idusuario)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/users")
    public ResponseEntity<User> postUser(@RequestBody User user){
        userService.create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{idusuario}")
    public ResponseEntity<User> putUser(@RequestBody User user,
                                        @PathVariable Integer idusuario){

        return userService.readById(idusuario)
                .map(currentUser -> {
                    user.setIdUsuario(idusuario);
                    userService.update(currentUser);
                    return new ResponseEntity<>(user, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    @DeleteMapping("/users/{idusuario}")
    public ResponseEntity deleteUser(@PathVariable Integer idusuario){

        return userService.readById(idusuario)
                .map(s -> {
                    userService.delete(s);
                    return new ResponseEntity<>(HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/users/{email},{clave}")
    public boolean findByEmailAndClave(@PathVariable String email,
                                       @PathVariable String clave){
        return userService.findByEmailAndClave(email,clave);
    }
}
