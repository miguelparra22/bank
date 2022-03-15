package com.monkeyBank.monkeyBank;

import com.monkeyBank.monkeyBank.dao.Cuenta.CuentaDaoImpl;
import com.monkeyBank.monkeyBank.dao.Usuario.UsuarioDaoImp;
import com.monkeyBank.monkeyBank.models.Cuenta;
import com.monkeyBank.monkeyBank.models.Transaccion;
import com.monkeyBank.monkeyBank.models.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class MonkeyBankApplicationTests {

	@Test
	void contextLoads() {
	}



	EntityManager entityManager;


}
