package br.com.travelapi.model;

public class Destino {

    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;
    private boolean hotelDisponivel;
    private String atividades;
    private double mediaAvaliacoes;
    private int quantidadeAvaliacoes;

    public Destino() {
    }

    public Destino(Long id, String nome, String localizacao, String descricao,
                    boolean hotelDisponivel, String atividades) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.hotelDisponivel = hotelDisponivel;
        this.atividades = atividades;
        this.mediaAvaliacoes = 0.0;
        this.quantidadeAvaliacoes = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isHotelDisponivel() {
        return hotelDisponivel;
    }

    public void setHotelDisponivel(boolean hotelDisponivel) {
        this.hotelDisponivel = hotelDisponivel;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public void setMediaAvaliacoes(double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }
}