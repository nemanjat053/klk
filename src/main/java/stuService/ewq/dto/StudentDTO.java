package stuService.ewq.dto;

import stuService.ewq.model.FinansijskaKartica;
import stuService.ewq.model.Student;
import stuService.ewq.model.Student;

public class StudentDTO {

	private Long id;
	private String indeks, ime, prezime, email, lozinka;

	public StudentDTO(Student student) {
		this.id = student.getId();
		this.indeks = student.getIndeks();
		this.ime = student.getIme();
		this.prezime = student.getPrezime();
		this.email = student.getEmail();
		this.lozinka = student.getLozinka();
	}

	public StudentDTO(Long id, String indeks, String ime, String prezime, String email, String lozinka) {
		super();
		this.id = id;
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


}
