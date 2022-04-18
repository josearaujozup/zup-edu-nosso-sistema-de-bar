package br.com.zup.edu.nossosistemadebares.bar;

import static br.com.zup.edu.nossosistemadebares.bar.StatusOcupacao.LIVRE;
import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOcupacao status = LIVRE;

    @Column
    private String reservadoPara;

    @Column(nullable = false)
    private LocalDateTime criadoEm = now();

    @Column(nullable = false)
    private LocalDateTime atualizadoEm = now();

    @Column(nullable = false)
    private Integer capacidade;

    public Mesa(Integer capacidade){
        this.capacidade=capacidade;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Mesa() {
    }

    public Long getId() {
        return id;
    }
    
    
	public void setReservadoPara(String reservadoPara) {
		this.reservadoPara = reservadoPara;
	}

	public boolean isReservada() {
		return this.status == StatusOcupacao.OCUPADO;
	}

	public void reservar(String reservadoPara) {
		
		this.reservadoPara = reservadoPara;
		this.status = StatusOcupacao.OCUPADO;
	}
}
