package posDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import posDashboard.model.entity.Categoria;
import posDashboard.service.interfaces.ICategoriaService;

import java.util.Set;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria categoria){
        try {
            Categoria add = categoriaService.agregarCategoria(categoria);
            return ResponseEntity.ok(add);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }

    }

    @GetMapping
    public ResponseEntity<Set<Categoria>> findAll(){
        try {
            Set<Categoria> lists = categoriaService.obtenerCategorias();
            return ResponseEntity.ok(lists);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        try {
            Categoria findId = categoriaService.obtenerCategoriaId(id);
            return ResponseEntity.ok(findId);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria){
        try {
            return ResponseEntity.ok(categoriaService.actualizarCategoria(categoria));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try {
            categoriaService.eliminarCategoria(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
