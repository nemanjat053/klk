package stuService.ewq.dto;

import java.util.ArrayList;
import java.util.List;

import stuService.ewq.model.FinansijskaKartica;
import stuService.ewq.model.Transakcija;

public class FinansijskaKarticaDTO {

	private Long id;
	private double stanje;
	private StudentDTO studentDTO;
	private List<TransakcijaDTO> transakcijeDTO = new ArrayList<>();

	public FinansijskaKarticaDTO(FinansijskaKartica finansijskaKartica) {
		this.id = finansijskaKartica.getId();
		this.stanje = finansijskaKartica.getStanje();
		this.studentDTO = new StudentDTO(finansijskaKartica.getStudent());
		if (finansijskaKartica.getId() != null) {
			for (Transakcija tk : finansijskaKartica.getTransakcije()) {
				this.transakcijeDTO.add(new TransakcijaDTO(tk));
			}
		}
	}

	public FinansijskaKarticaDTO(Long id, double stanje, StudentDTO studentDTO, List<TransakcijaDTO> transakcijeDTO) {
		super();
		this.id = id;
		this.stanje = stanje;
		this.studentDTO = studentDTO;
		this.transakcijeDTO = transakcijeDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public List<TransakcijaDTO> getTransakcijeDTO() {
		return transakcijeDTO;
	}

	public void setTransakcijeDTO(List<TransakcijaDTO> transakcijeDTO) {
		this.transakcijeDTO = transakcijeDTO;
	}

}
