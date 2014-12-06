package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicroxSemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class TestMicroxsemestreDAOHibernate {
	
	@Autowired
	MicroxSemestreDAO microxsemestreDao;

	@Test
	public void testContarMicrosxsemestre() {
		try{
			int numero = microxsemestreDao.ContarMicrosxsemestre();
			System.out.println("cantidad de elementos "+numero);
			assertTrue(true);
		}catch(ExcepcionesDAO e){
			System.out.println(e);
		}
	}

}
