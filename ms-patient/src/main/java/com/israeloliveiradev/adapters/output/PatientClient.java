package com.israeloliveiradev.adapters.output;

import com.israeloliveiradev.dtos.userDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-user")
public interface userClient {

    @GetMapping("api/users/{id}")
    userDTO getuser(@PathVariable Long id);
}

