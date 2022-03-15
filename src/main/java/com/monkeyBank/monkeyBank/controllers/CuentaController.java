package com.monkeyBank.monkeyBank.controllers;

import com.monkeyBank.monkeyBank.dao.Cuenta.CuentaDao;
import com.monkeyBank.monkeyBank.dao.Transaccion.TransaccionDao;
import com.monkeyBank.monkeyBank.models.Cuenta;
import com.monkeyBank.monkeyBank.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CuentaController {

    @Autowired
    CuentaDao cuentaDao;

    @Autowired
    TransaccionDao transaccionDao;

    @RequestMapping(value = "api/cuenta", method = RequestMethod.GET)
    public List<Cuenta> getCuentas(){
        return cuentaDao.getCuenta();
    }

    @RequestMapping(value = "api/CuentaSaludo", method = RequestMethod.GET)
    public String saludo(){
        return "hola";
    }

    @RequestMapping(value = "api/registroCuenta", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Cuenta cuenta){
        cuentaDao.registrarCuenta(cuenta);

    }

    @RequestMapping(value = "api/consultarSaldo", method = RequestMethod.POST)
    public long consultarSaldo(@RequestBody Cuenta cuenta){
      List<Cuenta> cuentas = cuentaDao.getSaldo(cuenta);
      long saldo = cuentas.get(0).getSaldo();
      return saldo ;
    }

    @RequestMapping(value = "api/retirarSaldo", method = RequestMethod.POST)
    public long retirarSaldo(@RequestBody Cuenta cuenta,  long valorRetirar){
        long saldo = cuentaDao.Retirar(cuenta,valorRetirar);
        return saldo;
    }

    @RequestMapping(value = "api/consignarSaldo", method = RequestMethod.POST)
    public long consignarSaldo(@RequestBody Cuenta cuenta,  long valorConsignar){
        long saldo = cuentaDao.Consignar(cuenta, valorConsignar);
        return saldo;
    }







}
