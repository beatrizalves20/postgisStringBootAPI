package br.com.example.controller;

import java.util.List;
import br.com.example.repository.MunicipioRepository;
import br.com.example.model.MunicipioVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Aeroportos API", version = "1.0", description = "Dados do Aeroporto"))
public class AeroportosController {
    
    @Autowired
    private AeroportosRepository repository;
    
    @GetMapping("/aeroportosVizinhos/{nome}")
    public List<AeroportosVO> aeroportosVizinhos(@PathVariable String nome){
        List<AeroportosVO> result;
        result = repository.listarAeroportosVizinhos(nome);
        return result;
    }
    
    @GetMapping("/distanciaEntreAeroportos/{aeroportosA}/{aeroportosB}")
     public Double distanciaEntreAeroportos(@PathVariable String aeroportosA, @PathVariable String aeroportosB){
        return repository.distanciaEntreAeroportos(aeroportosA, aeroportosB);
    }    
}
