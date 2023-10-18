package br.com.gustavorodrigues.todolist.user;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/*
 * Modificadores:
 * public qualquer um pode acessar
 * private poucos atributos pode acessar
 * protected quando esta mesmo estrutura do pacote
 */
@RestController 
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel UserModel){
        var user = this.userRepository.findByUsername(UserModel.getUsername());
        if(user != null){
            //Mensagem de erro
            //Status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe") ;
        }

        var passwordHashred = BCrypt.withDefaults().hashToString(12, UserModel.getPassword().toCharArray()); //senha criptografia

        UserModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(UserModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
