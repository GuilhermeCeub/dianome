package br.com.ceub.dianome.dto;

import br.com.ceub.dianome.model.Pacote;

import java.time.LocalDate;

public class PacoteDto {
    private String codigoRastreamento;
    private LocalDate dataRecebimento;
    private LocalDate dataEntrega;
    private String status;
    private String entregador;

    public static PacoteDto converte(Pacote pacote){
        PacoteDto dto = new PacoteDto();
        dto.setCodigoRastreamento(pacote.getCodigoRastreamento());
        dto.setDataEntrega(pacote.getDataEntrega());
        dto.setDataRecebimento(pacote.getDataRecebimento());
        dto.setStatus(pacote.getStatus());
        dto.setEntregador(pacote.getEntregador());
         return dto;

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
