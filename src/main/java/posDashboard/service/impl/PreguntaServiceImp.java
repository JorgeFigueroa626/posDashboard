package posDashboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import posDashboard.model.entity.Examen;
import posDashboard.model.entity.Pregunta;
import posDashboard.respository.IExamenRepository;
import posDashboard.respository.IPreguntaRepository;
import posDashboard.service.interfaces.IPreguntaService;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class PreguntaServiceImp implements IPreguntaService {

    @Autowired
    private IPreguntaRepository preguntaRepository;

    @Override
    public Pregunta agregarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Pregunta actualizarPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public Set<Pregunta> obtenerPreguntas() {
        return (Set<Pregunta>) preguntaRepository.findAll();
    }

    @Override
    public Pregunta obtenerPreguntaId(Long id) {
        return preguntaRepository.findById(id).get();
    }

    @Override
    public Set<Pregunta> obtenerPreguntasExamen(Examen examen) {
        return preguntaRepository.findByExamen(examen);
    }

    @Override
    public void eliminarPregunta(Long id) {
        preguntaRepository.deleteById(id);
    }

    @Override
    public Pregunta findOnePregunta(Long preguntaId) {
        return preguntaRepository.getOne(preguntaId);
    }
}
