package stuService.ewq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stuService.ewq.dto.TransakcijaDTO;
import stuService.ewq.model.Transakcija;
import stuService.ewq.service.TransakcijaService;




@Controller
@RequestMapping(path = "api/transakcija")
public class TransakcijaController {

	@Autowired
	private TransakcijaService transakcijaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<TransakcijaDTO>> findAll(){
		List<TransakcijaDTO> transakcije = new ArrayList<>();
		
		for(Transakcija tr : transakcijaService.findAll()) {
			transakcije.add(new TransakcijaDTO(tr));
		}
		
		return new ResponseEntity<List<TransakcijaDTO>>(transakcije, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TransakcijaDTO> getOne(@PathVariable Long id){
		Transakcija tr = transakcijaService.findOne(id);
		if( tr == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<TransakcijaDTO>(new TransakcijaDTO(tr), HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<TransakcijaDTO> post(@RequestBody TransakcijaDTO trDTO){
		
		Transakcija tr = new Transakcija();
		tr.setDatumValute(trDTO.getDatumValute());
		tr.setId(trDTO.getId());
		
		transakcijaService.save(tr);
		return new ResponseEntity<>(new TransakcijaDTO(tr), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TransakcijaDTO> put(@PathVariable Long id, @RequestBody TransakcijaDTO trDTO){
		Transakcija tr = transakcijaService.findOne(id);
		if(tr == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		tr.setDatumValute(trDTO.getDatumValute());
		tr.setId(trDTO.getId());
		
		transakcijaService.save(tr);
		return new ResponseEntity<TransakcijaDTO>(new TransakcijaDTO(tr), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id){
		Transakcija tr = transakcijaService.findOne(id);
		if(tr == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		transakcijaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
