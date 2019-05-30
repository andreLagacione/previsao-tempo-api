package previsaotempoapi.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import previsaotempoapi.domain.Cidade;
import previsaotempoapi.repositories.CidadeRepository;

@Service
public class DBService {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public void instantiateTestDataBase() throws ParseException {
		Cidade cidade1 = new Cidade(null, "Blumenau");
		cidadeRepository.saveAll(Arrays.asList(cidade1));
	}
}
