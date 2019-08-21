package com.santanderWay.santanderWay.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Saldo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long   id;

    private double valor;
    private long idCartao;

    public Saldo(){}

    public Saldo(double valor){
        this.valor = valor;
    }

    public Saldo(long id, double valor, long idCartao)
    {
        this.valor = valor;
        this.idCartao = idCartao;
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(long idCartao) {
        this.idCartao = idCartao;
    }
}
