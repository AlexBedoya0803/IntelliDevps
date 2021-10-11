package com.ApiRest.APIRest.controllers;

import com.ApiRest.APIRest.models.Proyecto;
import com.ApiRest.APIRest.models.Usuario;
import com.ApiRest.APIRest.repositories.ProyectoRepository;
import com.ApiRest.APIRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProyectoController {

    private final ProyectoRepository proyectoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ProyectoController(ProyectoRepository proyectoRepository, UsuarioRepository usuarioRepository) {
        this.proyectoRepository = proyectoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/participantes/{userId}/proyectos")
    public List<Proyecto> usuarioProyecto(@PathVariable String userId){

        //List<Proyecto> proyectoUsuario = proyectoRepository.findByusuarioId(userId);
        List<Proyecto> proyectoUsuario = new ArrayList<>();
        List<Proyecto> proyectos = proyectoRepository.findAll();
        for(Proyecto proyecto : proyectos){
            List<String> users = proyecto.getUsuarios();
            for(String id : users){
                if(id.equals(userId)){
                    proyectoUsuario.add(proyecto);
                }
            }
        }
        return proyectoUsuario;
    }

    @GetMapping("/proyectos")
    public List<Proyecto> getProyectos() {
        return proyectoRepository.findAll();
    }

    @GetMapping("/proyectos/{proyectoId}")
    public Optional<Proyecto> getProyecto(@PathVariable String proyectoId) {
        return proyectoRepository.findById(proyectoId);
    }

    @PostMapping("proyectos/agregarProyecto")
    public String agregarProyecto(@RequestBody Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        return "El proyecto " + proyecto.getId() + " fue agregado con éxito";
    }

    @DeleteMapping("proyectos/eliminarProyecto/{proyectoId}")
    public String eliminarProyecto(@PathVariable String proyectoId){
        proyectoRepository.deleteById(proyectoId);
        return "El proyecto " + proyectoId + " fue eliminado con éxito";
    }

    @PutMapping("proyectos/actualizarProyecto/{proyectoId}")
    public String actualizarProyecto(@RequestBody Proyecto proyecto){
        Optional<Proyecto> optionalProyecto = proyectoRepository.findById(proyecto.getId());
        Proyecto proyectoActualizar = optionalProyecto.get();
        proyectoActualizar.setNombre(proyecto.getNombre());
        proyectoActualizar.setDescripcion(proyecto.getDescripcion());
        proyectoActualizar.setFechaInicio(proyecto.getFechaInicio());
        proyectoActualizar.setFechaFinal(proyecto.getFechaFinal());
        proyectoActualizar.setObjetivos(proyecto.getObjetivos());
        proyectoActualizar.setObservaciones(proyecto.getObservaciones());
        proyectoActualizar.setPresupesto(proyecto.getPresupesto());
        proyectoActualizar.setEstado(proyecto.getEstado());
        proyectoActualizar.setFase(proyecto.getFase());
        proyectoActualizar.setTipo(proyecto.getTipo());
        proyectoActualizar.setUsuarios(proyecto.getUsuarios());
        proyectoRepository.save(proyectoActualizar);
        return "El proyecto " + proyecto.getId() + " fue actualizado con éxito";
    }
}
