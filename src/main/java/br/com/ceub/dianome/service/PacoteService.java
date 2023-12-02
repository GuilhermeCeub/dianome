package br.com.ceub.dianome.service;

import br.com.ceub.dianome.dto.PacoteDto;
import br.com.ceub.dianome.dto.PacoteUpdateDto;
import br.com.ceub.dianome.model.Pacote;
import br.com.ceub.dianome.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacoteService {


    @Autowired
    private PacoteRepository repository;

    public PacoteDto criar(PacoteDto dto){
        Pacote pacote = Pacote.converte(dto);
        Pacote saved = repository.save(pacote);

        return PacoteDto.converte(saved);

    }

    public List<PacoteDto> listar(){
        List<Pacote> pacotes = repository.findAll();
        return getPacoteDtos(pacotes);
    }
    
    public PacoteDto detalhar(String codigo){
        Pacote pacote=getPacote(codigo);
        return PacoteDto.converte(pacote);
        
    }
    public void alterar(String codigo, PacoteUpdateDto dto){
        Pacote pacote= getPacote(codigo);
        pacote.setDataEntrega(dto.getDataEntrega());
        pacote.setStatus(dto.getStatus());
        pacote.setEntregador(dto.getEntregador());
        repository.save(pacote);
        
    }

    public void remover(String codigo) {
        Pacote pacote=getPacote(codigo);
        repository.delete(pacote);
    }

    private static List<PacoteDto> getPacoteDtos(List<Pacote> pacotes) {
        List<PacoteDto> dtos = new ArrayList<>();
        for (Pacote entity: pacotes){
            dtos.add(PacoteDto.converte(entity));
        }
        return dtos;
    }

    private Pacote getPacote(String codigo) {
        Pacote pacote=repository.findByCodigoRastreamento(codigo);
        if (pacote==null){
            throw new RuntimeException("Pacote não encontrado");
        }
        return pacote;
    }
}

