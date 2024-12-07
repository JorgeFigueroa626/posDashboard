package posDashboard.service.interfaces;

import posDashboard.model.entity.Examen;
import posDashboard.model.entity.Pregunta;

import java.util.Set;

public interface IPreguntaService {

    public Pregunta agregarPregunta(Pregunta pregunta);

    public Pregunta actualizarPregunta(Pregunta pregunta);

    public Set<Pregunta> obtenerPreguntas();

    public Pregunta obtenerPreguntaId(Long id);

    public Set<Pregunta> obtenerPreguntasExamen(Examen examen);

    public void eliminarPregunta(Long id);

    public Pregunta findOnePregunta(Long preguntaId);
}
