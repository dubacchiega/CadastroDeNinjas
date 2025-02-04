package br.com.bacchiega.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService  {

    @Autowired
    private NinjaRepository ninjaRepository;

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null); // orElse(null) se não existir, retorna null
    }

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        NinjaModel ninjaAntigo = ninjaRepository.findById(id).orElse(null);
        ninjaAntigo.setNome(ninjaAtualizado.getNome());
        ninjaAntigo.setEmail(ninjaAtualizado.getEmail());
    }


}
