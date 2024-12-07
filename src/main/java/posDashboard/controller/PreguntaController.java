package posDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posDashboard.model.entity.Examen;
import posDashboard.model.entity.Pregunta;
import posDashboard.service.interfaces.IExamenService;
import posDashboard.service.interfaces.IPreguntaService;

import java.util.*;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntaController {

    @Autowired
    private IPreguntaService preguntaService;

    @Autowired
    private IExamenService examenService;

    @PostMapping
    public ResponseEntity<Pregunta> savePregunta(@RequestBody Pregunta pregunta){
        try {
            return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> findByIdPregunta(@PathVariable Long id){
        try {
            return ResponseEntity.ok(preguntaService.obtenerPreguntaId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Pregunta> updatePregunta(@RequestBody Pregunta pregunta){
        try {
            return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> findAllPreguntasExamenId(@PathVariable Long examenId){
        Examen examen = examenService.obtenerExamenId(examenId);
        Set<Pregunta> preguntas = examen.getPreguntas();

        List examenes = new ArrayList(preguntas);
        if (examenes.size() > Integer.parseInt(examen.getNumeroPreguntas())) {
            examenes = examenes.subList(0, Integer.parseInt(examen.getNumeroPreguntas() + 1));
        }

        Collections.shuffle(examenes);
        return ResponseEntity.ok(examenes);
    }

    @GetMapping("/examen/todos/{examenId}")
    public ResponseEntity<?> findAllsPreguntasByExamenId(@PathVariable Long examenId){
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        Set<Pregunta> preguntas = preguntaService.obtenerPreguntasExamen(examen);
        return ResponseEntity.ok(preguntas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePregunta(@PathVariable Long id){
        preguntaService.eliminarPregunta(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/evaluar-examen")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<Pregunta> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;

        for (Pregunta preg: preguntas){
            Pregunta pregunta = preguntaService.findOnePregunta(preg.getPreguntaId());
            if (pregunta.getRespuesta().equals(preg.getRespuestaDada())) {
                respuestasCorrectas ++;
                double puntos = Double.parseDouble(preguntas.get(0).getExamen().getPuntosMaximo()) / preguntas.size();
                puntosMaximos += puntos;
            }
            if (preg.getRespuestaDada() != null) {
                intentos ++;
            }
        }

        Map<String, Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos", puntosMaximos);
        respuestas.put("respuestasCorrectas", respuestasCorrectas);
        respuestas.put("intentos", intentos);
        return ResponseEntity.ok(respuestas);
    }
}
