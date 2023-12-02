package br.com.ceub.dianome.repository;

import br.com.ceub.dianome.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote,Integer> {
    Pacote findByCodigoRastreamento(String codigo);
}
