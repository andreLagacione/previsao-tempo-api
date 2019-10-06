package previsaotempoapi.cidade;

import org.hibernate.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {

    @Query(value = "{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Cidade> findByNome(String nome);
}