package stuService.ewq.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stuService.ewq.model.FinansijskaKartica;
import stuService.ewq.repository.FinansijskaKarticaRepository;

@Service
public class FinansijskaKarticaService {
	
	@Autowired
	private FinansijskaKarticaRepository finansijskaKarticaRepository;
	
	public Iterable<FinansijskaKartica> getAll(){
		return finansijskaKarticaRepository.findAll();
	}
		
	public FinansijskaKartica getOne(Long id){
		return this.finansijskaKarticaRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		this.finansijskaKarticaRepository.deleteById(id);
	}
	
	public void save(FinansijskaKartica finansijskaKartica) {
		finansijskaKarticaRepository.save(finansijskaKartica);
	}

}
