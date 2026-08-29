package br.com.travelapi.controller;

import br.com.travelapi.model.Destino;
import br.com.travelapi.model.NotaAvaliacao;
import br.com.travelapi.service.DestinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinoController {

    private final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Destino>> listarOuPesquisar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String localizacao) {

        return ResponseEntity.ok(
                destinoService.pesquisar(nome, localizacao)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> buscarPorId(
            @PathVariable Long id) {

        Destino destino = destinoService.buscarPorId(id);

        if (destino == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(destino);
    }

    @PostMapping
    public ResponseEntity<Destino> cadastrar(
            @RequestBody Destino destino) {

        Destino novoDestino = destinoService.cadastrar(destino);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novoDestino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> atualizar(
            @PathVariable Long id,
            @RequestBody Destino destino) {

        Destino destinoAtualizado =
                destinoService.atualizar(id, destino);

        if (destinoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(destinoAtualizado);
    }

    @PatchMapping("/{id}/avaliacao")
    public ResponseEntity<?> avaliar(
            @PathVariable Long id,
            @RequestBody NotaAvaliacao avaliacao) {

        try {

            Destino destino =
                    destinoService.avaliar(
                            id,
                            avaliacao.getNota()
                    );

            if (destino == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(destino);

        } catch (IllegalArgumentException e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long id) {

        boolean excluido =
                destinoService.excluir(id);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}