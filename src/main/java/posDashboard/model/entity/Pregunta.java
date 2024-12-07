package posDashboard.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preguntaId;

    @Column(name = "contenido", length = 5000)
    private String contenido;

    @Column(name = "imagen")
    private String imgane;

    @Column(name = "opcion_1")
    private String opcion1;

    @Column(name = "opcion_2")
    private String opcion2;

    @Column(name = "opcion_3")
    private String opcion3;

    @Column(name = "opcion_4")
    private String opcion4;

    @Transient
    @Column(name = "respuesta_dada")
    private String respuestaDada;


    @Column(name = "respuesta")
    private String respuesta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Examen examen;

    public Pregunta() {
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImgane() {
        return imgane;
    }

    public void setImgane(String imgane) {
        this.imgane = imgane;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getRespuestaDada() {
        return respuestaDada;
    }

    public void setRespuestaDada(String respuestaDada) {
        this.respuestaDada = respuestaDada;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}
