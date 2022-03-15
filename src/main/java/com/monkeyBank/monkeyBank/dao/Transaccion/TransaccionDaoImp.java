package com.monkeyBank.monkeyBank.dao.Transaccion;

import com.monkeyBank.monkeyBank.models.Transaccion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransaccionDaoImp implements TransaccionDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Transaccion> getTransaccion() {
        String query = "From Transaccion";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrarTransaccion(Transaccion transaccion) {
        entityManager.merge(transaccion);
    }

}
