package br.com.ceub.dianome.model;

import br.com.ceub.dianome.dto.PacoteDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String codigoRastreamento;


    @Column
    private LocalDate dataRecebimento;

    @Column
    private LocalDate dataEntrega;

    @Column
    private String status;

    @Column
    private String entregador;

    public static Pacote converte(PacoteDto pacoteDto){
        Pacote pacote = new Pacote();
        pacote.setCodigoRastreamento(pacoteDto.getCodigoRastreamento());
        pacote.setDataEntrega(pacoteDto.getDataEntrega());
        pacote.setDataRecebimento(pacoteDto.getDataRecebimento());
        pacote.setStatus(pacoteDto.getStatus());
        pacote.setEntregador(pacoteDto.getEntregador());
        return pacote;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public void setCodigoRastreamento(String codigoRastreamento) {
        this.codigoRastreamento = codigoRastreamento;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEntregador() {
        return entregador;
    }

    public void setEntregador(String entregador) {
        this.entregador = entregador;
    }



}
