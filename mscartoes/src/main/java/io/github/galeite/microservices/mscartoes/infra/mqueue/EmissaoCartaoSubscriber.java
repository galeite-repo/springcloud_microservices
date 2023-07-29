package io.github.galeite.microservices.mscartoes.infra.mqueue;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.galeite.microservices.mscartoes.domain.Cartao;
import io.github.galeite.microservices.mscartoes.domain.ClienteCartao;
import io.github.galeite.microservices.mscartoes.domain.DadosSolicitacaoEmissaoCartao;
import io.github.galeite.microservices.mscartoes.infra.repository.CartaoRepository;
import io.github.galeite.microservices.mscartoes.infra.repository.ClienteCartaoRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRespository clienteCartaoRespository;
    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload){

        try{
            var mapper = new ObjectMapper();
            DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();
            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(cartao);
            clienteCartao.setCpf(dados.getCpf());
            clienteCartao.setLimite(dados.getLimiteLiberado());

            clienteCartaoRespository.save(clienteCartao);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
