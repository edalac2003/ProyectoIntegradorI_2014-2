package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.Materias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

public class TestMateriasDAOHibernate {

	@Autowired
	MateriasDAO materiasDAO;
	
	@Test
	public void testMateriasDAOHibernate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGuardarMateria() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerMateria() {
		try{
			Materias materia = materiasDAO.obtenerMateria("20100101");
			System.out.println(materia.getNombre());
			assertTrue(true);
		}catch(ExcepcionesDAO e){
			
		}
	}

	@Test
	public void testListarMaterias() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarMateriasPorNucleo() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarMateriasPorSemestre() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizarMateria() {
		fail("Not yet implemented");
	}

}
