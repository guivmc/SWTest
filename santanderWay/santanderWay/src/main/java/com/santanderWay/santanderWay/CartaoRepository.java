package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> {

    Cartao findByIdCartao(long idUser);

}
