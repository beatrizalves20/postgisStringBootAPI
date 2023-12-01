package br.com.example.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.vividsolutions.jts.geom.Geometry;

@Data
@AllArgsConstructor
@Entity
@Table(name = "armazens_2014")
public class Armazens implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    @Column(name = "uf")
    private String uf;
    @Column(name = "municipio")
    private String municipio;
    @Column(name = "cap_ton")
    private String cap_ton;
    @Column(name = "geocodigo")
    private double geocodigo;    
    @Column(name = "geom")
    private Geometry geometria;

}
