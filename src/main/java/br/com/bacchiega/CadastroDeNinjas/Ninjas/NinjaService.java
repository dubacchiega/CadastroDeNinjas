package br.com.bacchiega.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService  {

    @Autowired
    private NinjaRepository ninjaRepository;

    @Autowired
    private NinjaMapper ninjaMapper;

    // Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();

        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null); // orElse(null) se não existir, retorna null
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

//    O JPA (ou qualquer ORM utilizado) verifica o ID para decidir entre INSERT e UPDATE.
//
//Se o ID for null, ele insere um novo registro.
//Se o ID for um valor existente, ele atualiza o registro correspondente.
//Como ninjaMapper.map(ninjaDTO) provavelmente cria um novo objeto NinjaModel, ele vem sem ID (ou com id = null).
//
//Ao setar ninjaAtualizado.setId(id), garantimos que o JPA reconheça o objeto como uma atualização e faça um UPDATE no banco.

    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id); // vou setar o id para ele nao criar um novo dado e sim sobrescrever
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }


}
