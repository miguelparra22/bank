package com.monkeyBank.monkeyBank.controllers;

import com.monkeyBank.monkeyBank.Utils.JWTUtil;
import com.monkeyBank.monkeyBank.dao.Usuario.UsuarioDao;
import com.monkeyBank.monkeyBank.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;




    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){


        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);

        if(usuarioLogueado != null){

            String token = jwtUtil.create(String.valueOf(usuarioLogueado.getId_usuario()), usuarioLogueado.getEmail());

            return token;
        }

        return "fail";
    }
}