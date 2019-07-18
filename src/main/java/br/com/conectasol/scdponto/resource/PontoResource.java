package br.com.conectasol.scdponto.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.conectasol.scdponto.common.Response;
import br.com.conectasol.scdponto.model.Ponto;
import br.com.conectasol.scdponto.repository.PontoRepository;

@RestController
@RequestMapping("/ponto")
public class PontoResource {

	@Autowired
	private PontoRepository repository;

	@GetMapping
	public List<Ponto> listar() {
		return repository.findAll();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {

		repository.deleteById(id);
	}

	@PostMapping
	public ResponseEntity<Response> baterPonto(@RequestBody Ponto ponto) {

		System.out.println(ponto.getData());
		Ponto pontoSalvo = repository.save(ponto);
		if (pontoSalvo != null) {
			return ResponseEntity.ok(new Response(pontoSalvo.getId()));
		}

		return ResponseEntity.ok(new Response("Ponto inexistente!"));
	}

}
