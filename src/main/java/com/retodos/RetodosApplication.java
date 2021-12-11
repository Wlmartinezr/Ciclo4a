package com.retodos;

import com.retodos.model.User;
import com.retodos.repository.crud.CleaningproductsCrudRepository;
import com.retodos.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {
        @Autowired
        private UserCrudRepository userRepo;
        @Autowired
        private CleaningproductsCrudRepository proRepo;        

	public static void main(String[] args) {
		SpringApplication.run(RetodosApplication.class, args);
	}
        @Override
        public void run(String... args)throws Exception{
            userRepo.deleteAll();
            proRepo.deleteAll();
            //System.out.println("Pendiente");
            //System.out.println("Usuario :" + userRepo.findTopByOrderByIdDesc().get());
        }
        
}
            //userRepo.saveAll(List.of(
             //   new User(1, "123456", "alan brito", "CR 34-45", "311222666", "alanbrito@gmail.com", "Demo123.", "ZONA 1","COORD"),
               // new User(2, "123457", "Josue huertas", "CR 34-50", "311222555", "jouseh@gmail.com", "Demo123*", "ZONA 2","GERENTE"),
                //new User(3, "123458", "leo martinez", "CR 108-85", "311222444", "leom@gmail.com", "Demo123+", "ZONA 3","INGENIERO"),
                //new User(4, "123459", "juan gaviria", "CR 184-01", "311222333", "juang@gmail.com", "Demo123..", "ZONA 4","VETERINARIO")
            //));
            
            //System.out.println("Listado de Usuarios");
            //userRepo.findAll().forEach(System.out::println);
            
            //Optional<User> usuario = userRepo.findByEmail("jouseh@gmail.com"); 
            
            //if(usuario.isPresent()){
              //  System.out.println("Datos del usuario:" + usuario.get());        
       
            //}
            //Optional<User> usuario2 = userRepo.findByEmailAndPassword("jouseh@gmail.com", "Demo123*");
            //if(usuario2.isPresent()){
              // System.out.println("Datos del usuario:" + usuario2.get());       
       
            //}
        
        //}
        
    
