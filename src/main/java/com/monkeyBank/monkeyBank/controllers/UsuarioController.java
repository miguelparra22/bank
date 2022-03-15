package com.monkeyBank.monkeyBank.controllers;


import com.monkeyBank.monkeyBank.dao.Usuario.UsuarioDao;
import com.monkeyBank.monkeyBank.models.Cuenta;
import com.monkeyBank.monkeyBank.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuario();
    }

   /* @RequestMapping(value = "api/registroUsuario", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }*/


    @RequestMapping(value = "api/usuariosCorreo", method = RequestMethod.POST)
    public long getUsuarioCorreo(@RequestBody Usuario usuario){
        List<Usuario> usuarios = usuarioDao.getUsuarioPorCorreo(usuario);
        long user = usuarios.get(0).getId_usuario();
        return user ;
    }



    @RequestMapping(value = "api/registroUsuario", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon.hash(1,1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

}
