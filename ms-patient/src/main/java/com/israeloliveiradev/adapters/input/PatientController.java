package com.israeloliveiradev.adapters.input;

import br.com.israeloliveira.user_core.domain.user;
import br.com.israeloliveira.user_core.ports.in.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class userController {

    private final userService userService;

    @GetMapping("/{id}")
    public user getuser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public user createuser(@RequestBody user user) {
        return userService.createNewuser(user);
    }






}
