package io.github.galeite.microservices.mscartoes.application;


import io.github.galeite.microservices.mscartoes.domain.ClienteCartao;
import io.github.galeite.microservices.mscartoes.infra.repository.ClienteCartaoRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    private final ClienteCartaoRespository respository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return respository.findByCpf(cpf);

    }
}
