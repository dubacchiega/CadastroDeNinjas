package br.com.bacchiega.CadastroDeNinjas.Missoes;

import br.com.bacchiega.CadastroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String rank;

    // @OneToMany -> Uma missão pode ter vários ninjas
    // Uma missão para muitos ninjas
    @OneToMany(mappedBy = "missoes") // mapeando para a coluna missoes
    @JsonIgnore // ignora para nao dar o loop de serialização
    private List<NinjaModel> ninja;

}
