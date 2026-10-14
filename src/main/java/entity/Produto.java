package entity;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity 
public class Produto extends PanacheEntity {

    public String nome;
    public String descricao;    
    public BigDecimal preco;

    @CreationTimestamp 
    public Date dataCriacao;

    @UpdateTimestamp 
    public Date dataAtualizacao;
}