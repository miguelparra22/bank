package com.monkeyBank.monkeyBank.dao.Cuenta;

import com.monkeyBank.monkeyBank.models.Cuenta;
import com.monkeyBank.monkeyBank.models.Transaccion;
import com.monkeyBank.monkeyBank.models.Usuario;

import java.util.List;

public interface CuentaDao {

    //Este metodo se usa para traer las cuentas creadas en bd.

    List<Cuenta> getCuenta();

    //Este metodo se creo para registrar una cuenta
    void registrarCuenta(Cuenta cuenta);

    //Este metodo consulta el saldo de una cuenta en especifico.
    List<Cuenta> getSaldo(Cuenta cuenta);

    void actualizarSaldo(Cuenta cuenta, long id_cuenta);

    Long Retirar(Cuenta cuenta, long valorRetirar);

    Long Consignar(Cuenta cuenta, long valorConsigar);

    List<Cuenta> getCuentaporId(Cuenta cuenta);
}
