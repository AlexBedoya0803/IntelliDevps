package com.ApiRest.APIRest.controllers;

import com.ApiRest.APIRest.models.Usuario;
import com.ApiRest.APIRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/participantes")
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/participantes/{usuarioId}")
    public Optional<Usuario> getUsuario(@PathVariable String usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }

    @PostMapping("participantes/agregarParticipante")
    public String agregarUsuario(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return "El usuario " + usuario.getId() + " fue agregado con éxito";
    }

    @DeleteMapping("participantes/eliminarParticipante/{usuarioId}")
    public String eliminarUsuario(@PathVariable String usuarioId){
        usuarioRepository.deleteById(usuarioId);
        return "El usuario " + usuarioId + " fue eliminado con éxito";
    }

    @PutMapping("participantes/actualizarParticipante/{usuarioId}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuario){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getId());
        Usuario usuarioActualizar = optionalUsuario.get();
        usuarioActualizar.setNombre(usuario.getNombre());
        usuarioActualizar.setCarrera(usuario.getCarrera());
        usuarioActualizar.setCelula(usuario.getCelula());
        usuarioActualizar.setEmail(usuario.getEmail());
        usuarioActualizar.setRol(usuario.getRol());
        usuarioActualizar.setProyectos(usuario.getProyectos());
        usuarioRepository.save(usuarioActualizar);
        return usuarioActualizar;
    }
}
