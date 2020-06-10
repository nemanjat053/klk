package stuService.ewq.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stuService.ewq.model.Student;
import stuService.ewq.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Iterable<Student> findAll() {
		return this.studentRepository.findAll();
	}

	public Student findOne(Long id) {
		return this.studentRepository.findById(id).orElse(null);
	}

	public void delete(Long id) {
		this.studentRepository.deleteById(id);
	}

	public void save(Student student) {
		this.studentRepository.save(student);
	}

	public Optional<Student> getStudent(String ime) {
		return this.studentRepository.getByIme(ime);
	}


}
