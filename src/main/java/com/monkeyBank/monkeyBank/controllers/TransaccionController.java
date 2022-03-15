package com.monkeyBank.monkeyBank.controllers;

import com.monkeyBank.monkeyBank.dao.Transaccion.TransaccionDao;
import com.monkeyBank.monkeyBank.models.Transaccion;
import com.monkeyBank.monkeyBank.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class TransaccionController {

    @Autowired
    TransaccionDao transaccionDao;

    @RequestMapping(value = "api/transaccion", method = RequestMethod.GET)
    public List<Transaccion> getTransaccion(){
        return transaccionDao.getTransaccion();
    }


    @RequestMapping(value = "api/registroTransaccion", method = RequestMethod.POST)
    public void registrarTransaccion(@RequestBody Transaccion transaccion){
        transaccionDao.registrarTransaccion(transaccion);
    }

    @RequestMapping(value = "api/retiro", method = RequestMethod.POST)
    public void registrarTransaccion(@RequestBody long cuenta, long valor){

    }
}
