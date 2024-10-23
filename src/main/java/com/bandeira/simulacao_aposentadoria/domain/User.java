package com.bandeira.simulacao_aposentadoria.domain;


import com.bandeira.simulacao_aposentadoria.domain.unums.Sex;

import java.util.List;

public record User(

        Long id,

        String cpf,

        String name,

        String email,

        String password,

        Integer age,

        Sex sex,

        Integer shortage,

        Integer yearsContribution,

        Integer monthsContribution,

        Integer daysContribution,

        Integer points,

        List benefits
){
}

