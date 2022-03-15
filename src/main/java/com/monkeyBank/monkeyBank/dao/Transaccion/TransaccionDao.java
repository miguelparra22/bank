package com.monkeyBank.monkeyBank.dao.Transaccion;

import com.monkeyBank.monkeyBank.models.Cuenta;
import com.monkeyBank.monkeyBank.models.Transaccion;
import com.monkeyBank.monkeyBank.models.Usuario;

import java.util.List;

public interface TransaccionDao {
    List<Transaccion> getTransaccion();

    void registrarTransaccion(Transaccion transaccion);
}
