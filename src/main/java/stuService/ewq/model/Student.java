package stuService.ewq.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String indeks;

	private String ime;

	private String prezime;

	private String email;

	private String lozinka;

	@OneToOne(mappedBy = "student")
	private FinansijskaKartica finansijskaKartica;

	@OneToMany(mappedBy = "student")
	private Set<StudentPermission> studentPermissions;

	
	public Student() {
		super();
	}

	public Student(Long id, String indeks, String ime, String prezime, String email, String lozinka,
			FinansijskaKartica finansijskaKartica, Set<StudentPermission> studentPermissions) {
		super();
		this.id = id;
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.finansijskaKartica = finansijskaKartica;
		this.studentPermissions = studentPermissions;
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

	public FinansijskaKartica getFinansijskaKartica() {
		return finansijskaKartica;
	}

	public void setFinansijskaKartica(FinansijskaKartica finansijskaKartica) {
		this.finansijskaKartica = finansijskaKartica;
	}

	public Set<StudentPermission> getStudentPermissions() {
		return studentPermissions;
	}

	public void setStudentPermissions(Set<StudentPermission> studentPermissions) {
		this.studentPermissions = studentPermissions;
	}

}
