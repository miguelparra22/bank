package com.monkeyBank.monkeyBank.dao.Usuario;

import com.monkeyBank.monkeyBank.dao.Usuario.UsuarioDao;
import com.monkeyBank.monkeyBank.models.Cuenta;
import com.monkeyBank.monkeyBank.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsuario() {
        String query = "From Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Usuario> getUsuarioPorCorreo(Usuario usuario) {
        String query = "From Usuario Where email = :email";
        List<Usuario> usuarios = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        return usuarios;
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "From Usuario where email = :email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return  null;
        }
        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if( argon2.verify(passwordHashed, usuario.getPassword())){
            return lista.get(0);
        }


        return null;


    }


}
