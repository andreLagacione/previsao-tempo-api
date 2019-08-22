package previsaotempoapi.cidade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import previsaotempoapi.cidade.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> { }