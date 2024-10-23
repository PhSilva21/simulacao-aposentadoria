package com.bandeira.simulacao_aposentadoria.gateways;

import com.bandeira.simulacao_aposentadoria.domain.User;

public interface UserFeignGateway {

    User findByCpf(String cpf);
}
