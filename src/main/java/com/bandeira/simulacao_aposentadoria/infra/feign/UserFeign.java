package com.bandeira.simulacao_aposentadoria.infra.feign;


import com.bandeira.simulacao_aposentadoria.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "ms-users", path = "/users")
public interface UserFeign {


    @GetMapping(params =  "cpf")
    User findByCpf(@RequestParam("cpf") String cpf);
}
