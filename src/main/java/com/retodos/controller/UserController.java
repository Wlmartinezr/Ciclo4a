
package com.retodos.controller;

import com.retodos.model.User;
import com.retodos.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desarrolloextremo
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
        @Autowired
        private UserService servicio;

        @GetMapping("/all")
        public List<User> getAll(){
            return servicio.getAll();
        }
        @GetMapping("/emailexist/{email}")
        public boolean existeEmail(@PathVariable("email") String email) {
        return servicio.existeEmail(email);
        }
        @GetMapping("{email}/{password}")
        public User authenticateUser(@PathVariable("email")String email,@PathVariable("password") String password) {
        return servicio.authenticateUser(email,password);
        }
        @PostMapping("/new")
        @ResponseStatus(HttpStatus.CREATED)
        public User create(@RequestBody User user){
            return servicio.create(user);
        }
        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public User update(@RequestBody User user) {
        return servicio.update(user);
        }
        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public boolean delete (@PathVariable("id")int id){
            return servicio.delete(id);
        }
            
}
