package com.monkeyBank.monkeyBank.dao.Cuenta;

import com.monkeyBank.monkeyBank.models.Cuenta;
import com.monkeyBank.monkeyBank.models.Transaccion;
import com.monkeyBank.monkeyBank.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class CuentaDaoImpl implements CuentaDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Cuenta> getCuenta() {

            String query = "From Cuenta";
           return   entityManager.createQuery(query).getResultList();


    }

    @Override
    public void registrarCuenta(Cuenta cuenta) {
        entityManager.merge(cuenta);
    }

    @Override
    public List<Cuenta> getSaldo(Cuenta cuenta) {

        String query = "From Cuenta WHERE id_usuario_cuenta = :id_usuario_cuenta";
        List<Cuenta> cuentas = entityManager.createQuery(query)
                .setParameter("id_usuario_cuenta", cuenta.getId_usuario_cuenta())
                .getResultList();


        return  cuentas;

    }

    @Override
    public void actualizarSaldo(Cuenta cuenta, long id_cuenta) {
        Cuenta cuentaSaldo = entityManager.find(Cuenta.class, id_cuenta);
        entityManager.merge(cuentaSaldo);
    }

    @Override
    public Long Retirar(Cuenta cuenta, long valorRetirar) {
        String query = "From Cuenta WHERE id_cuenta = :id_cuenta ";
        List<Cuenta> cuentas = entityManager.createQuery(query).setParameter("id_cuenta", cuenta.getId_cuenta())
                .getResultList();

        Timestamp fecha = cuentas.get(0).getFecha_creacion();
        Integer usuario = cuentas.get(0).getId_usuario_cuenta();
        Long SaldoActual = cuentas.get(0).getSaldo();
        Long SaldoNuevo = SaldoActual - valorRetirar;

        cuenta.setFecha_creacion(fecha);
        cuenta.setId_usuario_cuenta(usuario);
        cuenta.setSaldo(SaldoNuevo);


        entityManager.merge(cuenta);
        return SaldoNuevo;
    }


    @Override
    public Long Consignar(Cuenta cuenta, long valorConsigar) {
        String query = "From Cuenta WHERE id_cuenta = :id_cuenta ";
        List<Cuenta> cuentas = entityManager.createQuery(query).setParameter("id_cuenta", cuenta.getId_cuenta())
                .getResultList();

        Timestamp fecha = cuentas.get(0).getFecha_creacion();
        Integer usuario = cuentas.get(0).getId_usuario_cuenta();
        Long SaldoActual = cuentas.get(0).getSaldo();
        Long SaldoNuevo = SaldoActual + valorConsigar;

        cuenta.setFecha_creacion(fecha);
        cuenta.setId_usuario_cuenta(usuario);
        cuenta.setSaldo(SaldoNuevo);

        entityManager.merge(cuenta);


        return SaldoNuevo;
    }

    @Override
    public List<Cuenta> getCuentaporId(Cuenta cuenta) {
        String query = "From Cuenta WHERE id_usuario_cuenta = :id_usuario_cuenta";
        List<Cuenta> count = entityManager.createQuery(query)
                .setParameter("id_usuario_cuenta", cuenta.getId_usuario_cuenta())
                .getResultList();

        return  count;
    }


}
