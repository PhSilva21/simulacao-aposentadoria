package com.bandeira.simulacao_aposentadoria.infra.feign;

import com.bandeira.simulacao_aposentadoria.domain.User;
import com.bandeira.simulacao_aposentadoria.gateways.UserFeignGateway;

public class UserFeignGatewayImpl implements UserFeignGateway {

    private final UserFeign userFeign;

    public UserFeignGatewayImpl(UserFeign userFeign) {
        this.userFeign = userFeign;
    }

    @Override
    public User findByCpf(String cpf) {
        return userFeign.findByCpf(cpf);
    }
}
