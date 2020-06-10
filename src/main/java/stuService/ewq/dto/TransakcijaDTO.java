package stuService.ewq.dto;

import java.time.LocalDateTime;

import stuService.ewq.model.Transakcija;

public class TransakcijaDTO {

	private Long id;
	private LocalDateTime datumValute;
	private Long finansijskaKarticaId;

	public TransakcijaDTO(Transakcija transakcija) {
		this.id = transakcija.getId();
		this.datumValute = transakcija.getDatumValute();
		this.finansijskaKarticaId = transakcija.getId();
	}

	public TransakcijaDTO(Long id, LocalDateTime datumValute, Long finansijskaKarticaId) {
		super();
		this.id = id;
		this.datumValute = datumValute;
		this.finansijskaKarticaId = finansijskaKarticaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(LocalDateTime datumValute) {
		this.datumValute = datumValute;
	}

	public Long getFinansijskaKarticaId() {
		return finansijskaKarticaId;
	}

	public void setFinansijskaKarticaId(Long finansijskaKarticaId) {
		this.finansijskaKarticaId = finansijskaKarticaId;
	}

}
