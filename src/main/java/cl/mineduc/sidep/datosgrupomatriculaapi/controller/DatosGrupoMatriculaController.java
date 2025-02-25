package cl.mineduc.sidep.datosgrupomatriculaapi.controller;

import cl.mineduc.sidep.datosgrupomatriculaapi.model.AsistenteCurso;
import cl.mineduc.sidep.datosgrupomatriculaapi.model.CursoMatriculaModel;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.AsistenteService;
import cl.mineduc.sidep.datosgrupomatriculaapi.services.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api-grupo-parv/v1/curso")
@RequiredArgsConstructor
public class DatosGrupoMatriculaController {

    private final CursoService cursoService;
    private final AsistenteService asistenteService;

    // Ingresar un nuevo curso
    @PostMapping
    public ResponseEntity<Void> crearCurso(@RequestBody CursoMatriculaModel curso) {
        cursoService.crearCurso(curso);
        return ResponseEntity.status(201).build(); // Devuelve un status 201 si el curso es creado
    }

    // Ingresar asistentes a un curso
    @PostMapping("/asistente")
    public ResponseEntity<Void> agregarAsistentes(@RequestBody AsistenteCurso asistenteCurso) {
        for (AsistenteCurso.Asistente asistente : asistenteCurso.getAsistentes()) {
            asistenteService.agregarAsistentes(asistente);
        }
        return ResponseEntity.status(201).build(); // Devuelve un status 201 si los asistentes son agregados
    }

    // Actualizar los datos de un curso
    @PutMapping
    public ResponseEntity<Void> actualizarCurso(@RequestBody CursoMatriculaModel curso) {
        cursoService.actualizarCurso(curso);
        return ResponseEntity.ok().build(); // Devuelve un status 200 si el curso es actualizado
    }

    // Obtener los datos de un curso
    @GetMapping("/{rbd}")
    public ResponseEntity<CursoMatriculaModel> obtenerCurso(@PathVariable int rbd) {
        CursoMatriculaModel curso = cursoService.obtenerCurso(rbd);
        if (curso == null) {
            return ResponseEntity.status(404).build(); // Devuelve un status 404 si no se encuentra el curso
        }
        return ResponseEntity.ok(curso); // Devuelve los datos del curso si se encuentra
    }

    // Eliminar un curso
    @DeleteMapping("/{rbd}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable int rbd) {
        boolean eliminado = cursoService.eliminarCurso(rbd);
        if (eliminado) {
            return ResponseEntity.ok().build(); // Devuelve un status 200 si el curso es eliminado
        }
        return ResponseEntity.status(404).build(); // Devuelve un status 404 si no se encuentra el curso
    }

    // Eliminar un asistente de un curso
    @DeleteMapping("/asistente")
    public ResponseEntity<Void> eliminarAsistente(@RequestBody AsistenteCurso.Asistente asistente) {
        Integer rutAsistente = asistente.getRut(); // Obtén el rut del asistente
        asistenteService.eliminarAsistente(rutAsistente);
        return ResponseEntity.status(200).build(); // Devuelve un status 200 si el asistente es eliminado
    }
}
