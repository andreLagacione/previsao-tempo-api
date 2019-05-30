package previsaotempoapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import previsaotempoapi.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> { }