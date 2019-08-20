package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.Cartao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartaoRepository extends CrudRepository<Cartao, Integer>
{
    Cartao findByIdUser(long idUser);

    @Query("select new com.santanderWay.santanderWay.Model.Cartao(c.id, c.nome, c.numero, c.idUser) from Cartao c where c.idUser = ?1")
    List<Cartao> findCards(long filterValue);
}
