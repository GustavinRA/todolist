package br.com.gustavorodrigues.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data //Data importa Get e Set, isso e uma dependencia do Project lombok
@Entity(name = "tb_users") //Entidade JPA
public class UserModel {

    /*
     * UUID
     * 
     * id vai ser minha PRIMARY KEY
     * GeneratedValue(Gerador da minha chave)
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    //Definir meu dado quando vai ser criado no meu banco
    @CreationTimestamp
    private LocalDateTime createdAt;
    


    //Quando declaramos um "private", precisamos usar Getters e Setters esses dois metodos podemos acessar private em outras classes. Get buscar informação e Set atulizar e inserir
    
}
