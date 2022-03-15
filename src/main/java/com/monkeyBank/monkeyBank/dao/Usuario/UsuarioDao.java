package com.monkeyBank.monkeyBank.dao.Usuario;

import com.monkeyBank.monkeyBank.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuario();

    List<Usuario> getUsuarioPorCorreo(Usuario usuario);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
