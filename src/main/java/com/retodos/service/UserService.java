package com.retodos.service;

import com.retodos.model.User;
import com.retodos.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author desarrolloextremo
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repositorio;

    public List<User> getAll() {
        return repositorio.getAll();

    }
    public Optional<User> getUser(int id){
        return repositorio.getUser(id);
    }

    public boolean existeEmail(String email) {
        return repositorio.existeEmail(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = repositorio.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();

        }
    }

    public User create(User user) {
        if (user.getId() == null) {
            return user;
        } else {
            Optional<User> e = repositorio.getUser(user.getId());
            if (e.isEmpty()) {
                if (existeEmail(user.getEmail()) == false) {
                    return repositorio.create(user);
                } else {
                    return user;
                }
        } else {
                return user;
            }

        }
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName()!= null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone()!= null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                 if (user.getEmail()!= null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword()!= null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone()!= null) {
                    userDb.get().setZone(user.getZone());
                }
                if (user.getType()!= null) {
                    userDb.get().setType(user.getType());
                }
                repositorio.update(userDb.get());
                return userDb.get();
                
            }else{
                return user;
            }
        }else{
              return user;  
              }
    }
        public boolean delete(int id) {
        Optional<User> userDb = getUser(id);
        if (!userDb.isEmpty()) {
            repositorio.delete(userDb.get());
            return true;
        }
        return false;

    }
         public List<User> birthtDayList(String monthBirthtDay) {
        return repositorio.birthtDayList(monthBirthtDay);
    }   
}