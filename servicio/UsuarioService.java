package com.redsoft.cursojava.servicio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import com.redsoft.cursojava.modelo.Usuario;

@Service
public class UsuarioService {
    private static final String RUTAJSON = "C:\\Dev\\cursojava\\src\\main\\resources\\json\\usuario.json";

    public List<Usuario> getUsuarios() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(RUTAJSON), new TypeReference<List<Usuario>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            // Puedes agregar un log o mensaje de error más informativo aquí
            return Collections.emptyList();
        }
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
        ObjectMapper mapper = new ObjectMapper();
        File archivoJson = new File(RUTAJSON);
        try {
            List<Usuario> usuarios = archivoJson.exists()
                    ? mapper.readValue(archivoJson, new TypeReference<List<Usuario>>() {
                    })
                    : new ArrayList<>();
            usuarios.add(nuevoUsuario);
            mapper.writeValue(archivoJson, usuarios);
        } catch (IOException e) {
            e.printStackTrace();
            // Puedes agregar un log o mensaje de error más informativo aquí
        }
    }

    public void eliminarUsuario(int idUsuario) {
        ObjectMapper mapper = new ObjectMapper();
        File archivoJson = new File(RUTAJSON);

        try {
            List<Usuario> usuarios = archivoJson.exists()
                    ? mapper.readValue(archivoJson, new TypeReference<List<Usuario>>() {
                    })
                    : new ArrayList<>();

            List<Usuario> usuariosActualizados = usuarios.stream()
                    .filter(usuario -> usuario.getId() != idUsuario)
                    .collect(Collectors.toList());

            mapper.writeValue(archivoJson, usuariosActualizados);
        } catch (IOException e) {
            e.printStackTrace();
            // Puedes agregar un log o mensaje de error más informativo aquí
        }
    }
}
