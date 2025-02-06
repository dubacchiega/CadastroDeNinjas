package br.com.bacchiega.CadastroDeNinjas.Ninjas;

import br.com.bacchiega.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    // @ManyToOne -> Um ninja tem uma única missão
    // -> muitos ninjas para uma missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Foreing Key ou chave estrangeira. Quem contem a FK é a dona do relacionamento
    private MissoesModel missoes;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;
}


