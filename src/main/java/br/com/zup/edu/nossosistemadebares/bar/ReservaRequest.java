package br.com.zup.edu.nossosistemadebares.bar;

import javax.validation.constraints.NotBlank;

public class ReservaRequest {
	
	@NotBlank
	private String reservadoPara;

	public ReservaRequest(@NotBlank String reservadoPara) {
		this.reservadoPara = reservadoPara;
	}
	
	public ReservaRequest() {
		
	}
	
	public String getReservadoPara() {
		return reservadoPara;
	}
	
}
