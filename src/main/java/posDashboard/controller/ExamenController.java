package posDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posDashboard.model.entity.Categoria;
import posDashboard.model.entity.Examen;
import posDashboard.service.interfaces.IExamenService;

import java.util.List;

@RestController
@RequestMapping("/api/examenes")
public class ExamenController {

    @Autowired
    private IExamenService examenService;

    @PostMapping
    public ResponseEntity<Examen> saveExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }

    @GetMapping
    public ResponseEntity<?> findAllExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> findByIdExamen(@PathVariable Long id){
        return ResponseEntity.ok(examenService.obtenerExamenId(id));
    }

    @PutMapping
    public ResponseEntity<Examen> updateExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.actualizarExamen(examen));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExamen(@PathVariable Long id){
        examenService.eliminarExamenId(id);
        return ResponseEntity.noContent().build();
    }
    //

    @GetMapping("/categoria/{categoriaId}")
    public  ResponseEntity<List<Examen>> findAllExamenesByCategoriaId(@PathVariable Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return  ResponseEntity.ok(examenService.listarExamenDeCategoriaId(categoria));
    }

    @GetMapping("/state")
    public ResponseEntity<List<Examen>> findExamenState(){
        return ResponseEntity.ok(examenService.getAllExamenActivo());
    }

    @GetMapping("/categoria/state/{categoriaId}")
    public ResponseEntity<List<Examen>> findAllExamenActivoByCategoriaId(@PathVariable Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return ResponseEntity.ok(examenService.getAllExamenActivoByCategoryId(categoria));
    }


}
