/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.example.repository;

import br.com.example.model.Municipio;
import br.com.example.model.MunicipioVO;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author caian
 */
public interface AeroportosRepository extends JpaRepository<Aeroportos, Integer>{
    
    @Query(value = "select new br.com.example.model.AeroportosVO(mb.nome,mb.municipio,mb.nome_regiao) from Aeroportos ma, Aeroportos mb where touches(ma.geometria, mb.geometria) = true and ma.nome = :nome")
    List<AeroportosVO> listarAeroportosVizinhos(String nome);
    
    @Query(value ="select distance(geography(ma.geometria), geography(mb.geometria)) from Aeroportos ma, Aeroportos mb where ma.nome = :aeroportosA  and   mb.nome = :aeroportosB")
    public Double distanciaEntreAeroportos(String aeroportosA, String aeroportosB);
}
