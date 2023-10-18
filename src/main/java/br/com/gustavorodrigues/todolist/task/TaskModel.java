package br.com.gustavorodrigues.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;


import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/*
     * Essa classe Task são as Tarefas que meu programa vai ter
     * 
     * ID
     * usuário (ID_usuario)
     * Descrição
     * Título
     * Data de Início
     * Data de término
     * Prioridade
     * 
     */

 @Data
@Entity(name = "tb_tasks")  
public class TaskModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
     private UUID id;
     private String description;
    
     @Column(length = 50)
     private String title;
     private LocalDateTime starAt;
     private LocalDateTime endAt;
     private String priority;

     private UUID idUser;


     @CreationTimestamp // avisa quando nossa tarefa foi criado em nosso SQL 
     private LocalDateTime crDateTime; //iso informa quando nossa tarefa foi criado

     public void serTitle (String title)throws Exception{
        if(title.length() >50) {
            throw new Exception("O campo title deve conter no máximo 50 caracteres");
        }
        this.title = title;
     }

    

    
}
