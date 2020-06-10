package stuService.ewq.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stuService.ewq.dto.FinansijskaKarticaDTO;
import stuService.ewq.model.FinansijskaKartica;
import stuService.ewq.service.FinansijskaKarticaService;
import stuService.ewq.service.StudentService;
import stuService.ewq.service.TransakcijaService;

@Controller
@RequestMapping(path = "api/kartice")
public class FinansijskaKarticaController {
	
	@Autowired
	private FinansijskaKarticaService finansijskaKarticaService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TransakcijaService transakcijaService;
	
	@Secured("ROLE_STUDENT")
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<FinansijskaKarticaDTO>> findAll(){
		List<FinansijskaKarticaDTO> kartice = new ArrayList<>();
		
		for(FinansijskaKartica fk : finansijskaKarticaService.getAll()) {
			kartice.add(new FinansijskaKarticaDTO(fk));
		}
		
		return new ResponseEntity<List<FinansijskaKarticaDTO>>(kartice, HttpStatus.OK);
	}
	
	@Secured("ROLE_STUDENT")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FinansijskaKarticaDTO> getOne(@PathVariable Long id){
		FinansijskaKartica fk = finansijskaKarticaService.getOne(id);
		if( fk == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<FinansijskaKarticaDTO>(new FinansijskaKarticaDTO(fk), HttpStatus.OK);
	}
	@Secured("ROLE_STUDENT")
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<FinansijskaKarticaDTO> post(@RequestBody FinansijskaKarticaDTO fkDTO){
		
		FinansijskaKartica fk = new FinansijskaKartica();
		fk.setId(fkDTO.getId());
		fk.setPozivNaBroj(fk.getPozivNaBroj());
		fk.setStanje(fkDTO.getStanje());
		
		finansijskaKarticaService.save(fk);
		return new ResponseEntity<>(new FinansijskaKarticaDTO(fk), HttpStatus.OK);
		
	}
	@Secured("ROLE_STUDENT")
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FinansijskaKarticaDTO> put(@PathVariable Long id, @RequestBody FinansijskaKarticaDTO fkDTO){
		FinansijskaKartica fk = finansijskaKarticaService.getOne(id);
		if(fk == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		fk.setStanje(fkDTO.getStanje());
		
		finansijskaKarticaService.save(fk);
		return new ResponseEntity<FinansijskaKarticaDTO>(new FinansijskaKarticaDTO(fk), HttpStatus.OK);
	}
	@Secured("ROLE_STUDENT")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id){
		FinansijskaKartica fk = finansijskaKarticaService.getOne(id);
		if(fk == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		finansijskaKarticaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
