package br.com.zup.edu.nossosistemadebares.bar;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/mesas")
public class ReservarMesaController {
	
	private final MesaRepository repository;

    public ReservarMesaController(MesaRepository repository) {
        this.repository = repository;
    }
	
    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(@PathVariable("id") Long idMesa, @RequestBody @Valid ReservaRequest request){
    	
    	Mesa mesa = repository.findById(idMesa).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"mesa não encontrada"));
    	
    	if(mesa.isReservada()) {
    		throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"mesa já reservada");
    	}
    	
//    	mesa.setReservadoPara(request.getReservadoPara());
    	
    	mesa.reservar(request.getReservadoPara());
    	
    	repository.save(mesa);
    	
    	return ResponseEntity.noContent().build();
    }
    
}
