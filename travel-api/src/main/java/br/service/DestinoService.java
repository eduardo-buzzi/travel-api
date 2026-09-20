package br.com.travelapi.service;

import br.com.travelapi.model.Destino;
import br.com.travelapi.repository.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;

    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public List<Destino> listarTodos() {
        return destinoRepository.findAll();
    }

    public List<Destino> pesquisar(String nome, String localizacao) {

        if (nome != null && localizacao != null) {
            return destinoRepository
                    .findByNomeContainingIgnoreCaseAndLocalizacaoContainingIgnoreCase(
                            nome,
                            localizacao
                    );
        }

        if (nome != null) {
            return destinoRepository
                    .findByNomeContainingIgnoreCase(nome);
        }

        if (localizacao != null) {
            return destinoRepository
                    .findByLocalizacaoContainingIgnoreCase(localizacao);
        }

        return destinoRepository.findAll();
    }

    public Destino buscarPorId(Long id) {

        return destinoRepository.findById(id)
                .orElse(null);
    }

    public Destino cadastrar(Destino destino) {

        destino.setId(null);
        destino.setMediaAvaliacoes(0.0);
        destino.setQuantidadeAvaliacoes(0);

        return destinoRepository.save(destino);
    }

    public Destino atualizar(Long id, Destino dados) {

        Destino destino = buscarPorId(id);

        if (destino == null) {
            return null;
        }

        destino.setNome(dados.getNome());
        destino.setLocalizacao(dados.getLocalizacao());
        destino.setDescricao(dados.getDescricao());
        destino.setHotelDisponivel(dados.isHotelDisponivel());
        destino.setAtividades(dados.getAtividades());

        return destinoRepository.save(destino);
    }

    public Destino avaliar(Long id, double nota) {

        Destino destino = buscarPorId(id);

        if (destino == null) {
            return null;
        }

        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException(
                    "A nota deve estar entre 1 e 5."
            );
        }

        double somaAtual =
                destino.getMediaAvaliacoes()
                        * destino.getQuantidadeAvaliacoes();

        int novaQuantidade =
                destino.getQuantidadeAvaliacoes() + 1;

        double novaMedia =
                (somaAtual + nota) / novaQuantidade;

        destino.setQuantidadeAvaliacoes(novaQuantidade);

        destino.setMediaAvaliacoes(
                Math.round(novaMedia * 100.0) / 100.0
        );

        return destinoRepository.save(destino);
    }

    public boolean excluir(Long id) {

        if (!destinoRepository.existsById(id)) {
            return false;
        }

        destinoRepository.deleteById(id);

        return true;
    }
}