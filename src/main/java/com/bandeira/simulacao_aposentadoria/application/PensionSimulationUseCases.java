package com.bandeira.simulacao_aposentadoria.application;

import com.bandeira.simulacao_aposentadoria.domain.User;
import com.bandeira.simulacao_aposentadoria.domain.unums.Sex;
import com.bandeira.simulacao_aposentadoria.gateways.UserFeignGateway;
import com.bandeira.simulacao_aposentadoria.infra.exceptions.UserNotFoundException;

public class PensionSimulationUseCases {

    private final UserFeignGateway userFeign;

    public PensionSimulationUseCases(UserFeignGateway userFeign) {
        this.userFeign = userFeign;
    }

    public String doMaleAgeSimulation(String cpf) {
        var user = findUserByCpf(cpf);

        if (user.sex().equals(Sex.MAN)) {
            if (user.age() >= 65 && user.shortage() > 180
                    && user.yearsContribution() >= 15) {
                return "HABILITADO";
            }
        }
        return "NÃO HABILITADO";
    }

    public String doMaleSimulationForContributionTimeAndPoints(String cpf) {
        var user = findUserByCpf(cpf);

        if (user.sex().equals(Sex.MAN)) {
            if (user.age() >= 65 && user.shortage() > 180
                    && user.yearsContribution() >= 35 && user.points() >= 101) {
                return "HABILITADO";
            }
        }
        return "NÃO HABILITADO";
    }
    
    public String doMaleSimulationByAgeAndContributionTime(String cpf) {
        var user = findUserByCpf(cpf);

        if (user.sex().equals(Sex.MAN)) {
            if (user.age() >= 63 && user.shortage() > 180
                    && user.yearsContribution() >= 35) {
                return "HABILITADO";
            }
        }
        return "NÃO HABILITADO";
    }

    
    public String doFemaleAgeSimulation(String cpf) {
        var user = findUserByCpf(cpf);

        if (user.sex().equals(Sex.WOMAN)) {
            if (user.age() >= 62 && user.shortage() > 180
                    && user.yearsContribution() >= 15) {
                return "HABILITADA";
            }
        }
        return "NÃO HABILITADA";
    }

    
    public String doFemaleSimulationForContributionTimeAndPoints(String cpf) {
        var user = findUserByCpf(cpf);

        if (user.sex().equals(Sex.WOMAN)) {
            if (user.shortage() > 180 && user.yearsContribution() >= 30
                    && user.points() >= 91) {
                return "HABILITADA";
            }
        }
        return "NÃO HABILITADA";
    }

    
    public String doFemaleSimulationByAgeAndContributionTime(String cpf) {
        var user = findUserByCpf(cpf);

        if (user.sex().equals(Sex.WOMAN)) {
            if (user.shortage() > 180 && user.yearsContribution() >= 30
                    && user.age() >= 58 && user.points() >= 91) {
                return "HABILITADA";
            }
        }
        return "NÃO HABILITADA";
    }

    public User findUserByCpf(String cpf){
        var user = userFeign.findByCpf(cpf);
        if(user == null){
            throw new UserNotFoundException();
        }
        return user;
    }
}
