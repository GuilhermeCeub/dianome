package br.com.ceub.dianome.controller;

import br.com.ceub.dianome.dto.PacoteDto;
import br.com.ceub.dianome.dto.PacoteUpdateDto;
import br.com.ceub.dianome.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rastreio")
public class PacoteController {

    @Autowired
    private PacoteService service;

    @PostMapping
    public ResponseEntity<PacoteDto> criarPacote(@RequestBody PacoteDto dto) {
        PacoteDto resposta = service.criar(dto);
        return ResponseEntity.ok(resposta);
    }


    @GetMapping
    public List<PacoteDto> listarPacotes() {
        return service.listar();
    }

    @GetMapping("{codigo}")
    public PacoteDto detalhar(@PathVariable String codigo) {
        return service.detalhar(codigo);
    }

    @PutMapping("{codigo}")
    public void alterar(@RequestBody PacoteUpdateDto dto, @PathVariable String codigo) {

        service.alterar(codigo, dto);

    }
    @DeleteMapping("{codigo}")
    public void remover(@PathVariable String codigo){
        service.remover(codigo);

    }
}
