package stuService.ewq.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "transakcija")
public class Transakcija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double iznos;

	private LocalDateTime datumValute;

	@ManyToOne
	private FinansijskaKartica finansijskaKartica;

	public Transakcija(Long id, double iznos, LocalDateTime datumValute, FinansijskaKartica finansijskaKartica) {
		super();
		this.id = id;
		this.iznos = iznos;
		this.datumValute = datumValute;
		this.finansijskaKartica = finansijskaKartica;
	}

	public Transakcija() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public LocalDateTime getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(LocalDateTime datumValute) {
		this.datumValute = datumValute;
	}

	public FinansijskaKartica getFinansijskaKartica() {
		return finansijskaKartica;
	}

	public void setFinansijskaKartica(FinansijskaKartica finansijskaKartica) {
		this.finansijskaKartica = finansijskaKartica;
	}

}
