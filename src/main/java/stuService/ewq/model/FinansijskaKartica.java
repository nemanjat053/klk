package stuService.ewq.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "finansijska_kartica")
public class FinansijskaKartica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String pozivNaBroj;

	private double stanje;

	@OneToOne
	private Student student;

	@OneToMany(mappedBy = "finansijskaKartica")
	private List<Transakcija> transakcije;

	public FinansijskaKartica(Long id, String pozivNaBroj, double stanje, Student student,
			List<Transakcija> transakcije) {
		super();
		this.id = id;
		this.pozivNaBroj = pozivNaBroj;
		this.stanje = stanje;
		this.student = student;
		this.transakcije = transakcije;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Transakcija> getTransakcije() {
		return transakcije;
	}

	public void setTransakcije(List<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}

	public FinansijskaKartica() {
		super();
	}

}
