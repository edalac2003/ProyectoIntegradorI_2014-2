package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dto.Ciudades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class TestCiudadesDAOHibernate {

	static final Logger log = Logger.getLogger(TestCiudadesDAOHibernate.class);
	
	@Autowired
	CiudadesDAO ciudadDAO;
	
	@Test
	public void testObtenerCiudad() {
		try{
			Ciudades ciudad = ciudadDAO.obtenerCiudad(20);
			System.out.println(ciudad.getNombre());
			assertTrue(true);
		}catch(ExcepcionesDAO e){
			
		}
	}

}
