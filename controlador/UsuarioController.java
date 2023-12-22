package com.redsoft.cursojava.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.redsoft.cursojava.servicio.UsuarioService;
import com.redsoft.cursojava.modelo.Usuario;

@Controller
public class UsuarioController {
    private final UsuarioService usuarioServices;

    public UsuarioController(UsuarioService usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuarioServices.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/agregarUsuario")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario nuevoUsuario) {
        // Guardar el nuevo usuario en el archivo JSON
        usuarioServices.agregarUsuario(nuevoUsuario);
        return ResponseEntity.ok("Usuario guardado exitosamente");
    }

    @PostMapping("/eliminarUsuario")
    public ResponseEntity<String> eliminarUsuario(@RequestBody Map<String, String> body) {
        String usuarioId = body.get("usuarioId");
        System.out.println("usuarioId" + usuarioId);
        usuarioServices.eliminarUsuario(Integer.parseInt(usuarioId));
        return ResponseEntity.ok("Usuario eliminado con éxito");
    }
}
