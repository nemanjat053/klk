package stuService.ewq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import stuService.ewq.dto.StudentDTO;
import stuService.ewq.model.FinansijskaKartica;
import stuService.ewq.model.Student;
import stuService.ewq.service.StudentService;

@Controller
@RequestMapping(path = "api/studenti")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getAll() {

		List<StudentDTO> studentiDTO = new ArrayList<>();
		for (Student st : studentService.findAll()) {
			studentiDTO.add(new StudentDTO(st));
		}

		return new ResponseEntity<List<StudentDTO>>(studentiDTO, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> getOne(@PathVariable Long id) {

		Student st = studentService.findOne(id);
		if (st == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudentDTO>(new StudentDTO(st), HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StudentDTO> post(@RequestBody StudentDTO stDTO) {

		FinansijskaKartica fk = new FinansijskaKartica();
		Student st = new Student();
		st.setId(stDTO.getId());
		st.setEmail(stDTO.getEmail());
		st.setIme(stDTO.getIme());

		studentService.save(st);
		return new ResponseEntity<>(new StudentDTO(st), HttpStatus.OK);

	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StudentDTO> put(@PathVariable Long id, @RequestBody StudentDTO stDTO) {
		Student st = studentService.findOne(id);
		if (st == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		st.setEmail(stDTO.getEmail());
		st.setIme(stDTO.getIme());
		
		StudentDTO stu = new StudentDTO(st);

		studentService.save(st);
		return new ResponseEntity<StudentDTO>(stu, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Student st = studentService.findOne(id);
		if (st == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		studentService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
