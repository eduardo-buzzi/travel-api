package br.com.travelapi.service;

import br.com.travelapi.model.Destino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final List<Destino> destinos = new ArrayList<>();

    private Long proximoId = 1L;

    public DestinoService() {

        destinos.add(new Destino(
                proximoId++,
                "Gramado",
                "Rio Grande do Sul",
                "Cidade turística conhecida pelo clima europeu.",
                true,
                "Natal Luz, Rua Coberta e Lago Negro"
        ));

        destinos.add(new Destino(
                proximoId++,
                "Florianópolis",
                "Santa Catarina",
                "Capital de Santa Catarina conhecida pelas praias.",
                true,
                "Praias, trilhas e passeios de barco"
        ));
    }

    public List<Destino> listarTodos() {
        return destinos;
    }

    public List<Destino> pesquisar(String nome, String localizacao) {

        if (nome == null && localizacao == null) {
            return destinos;
        }

        return destinos.stream()
                .filter(destino ->
                        (nome == null ||
                                destino.getNome()
                                        .toLowerCase()
                                        .contains(nome.toLowerCase()))
                        &&
                        (localizacao == null ||
                                destino.getLocalizacao()
                                        .toLowerCase()
                                        .contains(localizacao.toLowerCase()))
                )
                .collect(Collectors.toList());
    }

    public Destino buscarPorId(Long id) {

        return destinos.stream()
                .filter(destino -> destino.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Destino cadastrar(Destino destino) {

        destino.setId(proximoId++);

        destino.setMediaAvaliacoes(0.0);

        destino.setQuantidadeAvaliacoes(0);

        destinos.add(destino);

        return destino;
    }

    public Destino atualizar(Long id, Destino dados) {

        Destino destino = buscarPorId(id);

        if (destino == null) {
            return null;
        }

        destino.setNome(dados.getNome());

        destino.setLocalizacao(dados.getLocalizacao());

        destino.setDescricao(dados.getDescricao());

        destino.setHotelDisponivel(
                dados.isHotelDisponivel()
        );

        destino.setAtividades(
                dados.getAtividades()
        );

        return destino;
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

        destino.setQuantidadeAvaliacoes(
                novaQuantidade
        );

        destino.setMediaAvaliacoes(
                Math.round(novaMedia * 100.0) / 100.0
        );

        return destino;
    }

    public boolean excluir(Long id) {

        return destinos.removeIf(
                destino -> destino.getId().equals(id)
        );
    }
}