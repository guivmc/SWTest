package com.santanderWay.santanderWay;

import com.santanderWay.santanderWay.Model.Cartao;
import com.santanderWay.santanderWay.Model.Saldo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaldoRepository extends CrudRepository<Saldo, Integer>
{
    Saldo findByIdCartaoLike(long idCartao);

    @Query("select new com.santanderWay.santanderWay.Model.Saldo(s.id, s.valor, s.idCartao, s.name, s.details) from Saldo s where s.idCartao = ?1")
    List<Saldo> findSaldos(long filterValue);
}
