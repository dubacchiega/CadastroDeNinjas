package br.com.bacchiega.CadastroDeNinjas.Ninjas;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService  {

    @Autowired
    private NinjaRepository ninjaRepository;

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

}
