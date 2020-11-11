package com.shinley.contentcentter.feignapi;

import com.shinley.contentcentter.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-center")
public interface UserCenterFeignClient {
    @GetMapping("/users/{id}")
    UserDto findById(@PathVariable Integer id);
}
