package br.com.gustavorodrigues.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, UUID>{
//Modelo metodos, representação dos metodos
    UserModel findByUsername(String username);    
}
