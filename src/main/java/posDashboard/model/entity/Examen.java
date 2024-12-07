package posDashboard.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "examenes")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examenId;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descrpcion")
    private String descripcion;

    @Column(name = "puntos_maximo")
    private String puntosMaximo;

    @Column(name = "numero_pregunta")
    private String numeroPreguntas;

    @Column(name = "state")
    private boolean state = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @OneToMany(mappedBy = "examen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Pregunta> preguntas = new HashSet<>();

    public Examen() {
    }

    public Long getExamenId() {
        return examenId;
    }

    public void setExamenId(Long examenId) {
        this.examenId = examenId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuntosMaximo() {
        return puntosMaximo;
    }

    public void setPuntosMaximo(String puntosMaximo) {
        this.puntosMaximo = puntosMaximo;
    }

    public String getNumeroPreguntas() {
        return numeroPreguntas;
    }

    public void setNumeroPreguntas(String numeroPreguntas) {
        this.numeroPreguntas = numeroPreguntas;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
