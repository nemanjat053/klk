package stuService.ewq.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stuService.ewq.model.Transakcija;
import stuService.ewq.repository.TransakcijaRepository;

@Service
public class TransakcijaService {
	
	@Autowired
	private TransakcijaRepository transakcijaRepository;
	
	public Iterable<Transakcija> findAll(){
		return this.transakcijaRepository.findAll();
	}
	
	public Transakcija findOne(Long id){
		return this.transakcijaRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		this.transakcijaRepository.deleteById(id);
	}
	
	public void save(Transakcija transakcija) {
		transakcijaRepository.save(transakcija);
	}

}
