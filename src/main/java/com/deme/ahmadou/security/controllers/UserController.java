package com.deme.ahmadou.security.controllers;

import com.deme.ahmadou.security.models.Role;
import com.deme.ahmadou.security.models.User;
import com.deme.ahmadou.security.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<User> getUser(@PathVariable String userName){
        return ResponseEntity.ok().body(userService.getUser(userName));
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleUserForm roleUserForm ){
        userService.addRoleToUser(roleUserForm.getUserName(),roleUserForm.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleUserForm{
    private String userName;
    private String roleName;
}
