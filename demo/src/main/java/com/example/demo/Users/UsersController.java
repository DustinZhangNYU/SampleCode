package com.example.demo.Users;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping(path = "/getAllUsers")
    public List<Users> getUsers() {
        return usersService.getUsers();
    }
    @GetMapping(path = "/getUserById")
    public Users findUserById(@RequestParam Long id)
    {
        return usersService.getUserById(id);
    }
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("users", new Users());
//        return "signup_form";
//    }
    @PostMapping(path = "/register")
    public ResponseEntity<Users> register(@RequestBody ObjectNode json){
        String firstName = json.get("firstName").asText();
        String lastName = json.get("lastName").asText();
        String email = json.get("email").asText();
        Character type = json.get("type").asText().charAt(0);
        String hashedPassword = json.get("hashedPassword").asText();
        String add_country = json.get("add_country").asText();
        String add_city = json.get("add_city").asText();
        String add_state = json.get("add_state").asText();
        String add_street = json.get("add_street").asText();
        String add_street2 = json.get("add_street2").asText();
        String add_zip_code = json.get("add_zip_code").asText();
        LocalDate dob = LocalDate.parse(json.get("dob").asText());
        Users user = new Users(firstName, lastName, email, type, hashedPassword,add_country,add_city,add_state, add_street, add_street2, add_zip_code,dob);
        Users newUser = usersService.register(user);
        if(newUser != null) {
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Users> login(@RequestBody ObjectNode json) {
        String email = json.get("email").asText();
        String password  = json.get("password").asText();
        Users user = usersService.verify(email, password);
        if(user == null) {
            return ResponseEntity.notFound().header("message", "user name and password are not matched").build();
        }
        else{
            user.setHashedPassword("");
            return ResponseEntity.ok(user);
        }

    }
}
