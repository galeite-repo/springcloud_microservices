package io.github.galeite.microservices.msavaliadorcredito.application.ex;

public class DadosClientesNotFoundException extends Exception{

    public DadosClientesNotFoundException(){
        super("Dados do cliente não encontrados para o CPF informado");
    }
}
