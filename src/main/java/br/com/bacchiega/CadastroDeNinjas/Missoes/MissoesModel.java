package br.com.bacchiega.CadastroDeNinjas.Missoes;

import br.com.bacchiega.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String rank;

    // @OneToMany -> Uma missão pode ter vários ninjas
    // Uma missão para muitos ninjas
    @OneToMany(mappedBy = "missoes") // mapeando para a coluna missoes
    private List<NinjaModel> ninja;

    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, String rank) {
        this.id = id;
        this.nome = nome;
        this.rank = rank;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
