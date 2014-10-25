package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class TestCiudadesDAOHibernate {

	static final Logger log = Logger.getLogger(TestCiudadesDAOHibernate.class);
	
	@Autowired
	CiudadesDAO ciudadDao;
	
	@Test
	public void testObtenerCiudad() {
		try{
			TbAdmCiudades ciudad = ciudadDao.obtenerCiudad(20);
			System.out.println(ciudad.getVrNombre());
			assertTrue(true);
		}catch(ExcepcionesDAO e){
			
		}
	}

}
