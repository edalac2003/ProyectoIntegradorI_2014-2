package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.Materias;
import com.udea.proint1.microcurriculo.dto.Nucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring-configuration.xml")

public class TestMateriasDAOHibernate {

	@Autowired
	MateriasDAO materiasDAO;
	
	@Test
	public void testGuardarMateria() {
		Materias materia = new Materias();
		
		try{
			materia.setIdMateria("20100101");
			materia.setNombre("Logica I");
			materia.setSemestre(1);
			materia.setCreditos(4);
			materia.setHabilitable('1');
			materia.setValidable('1');
			materia.setClasificable('1');
			materia.setHt(6);
			materia.setHp(8);
			materia.setHtp(12);		
			materiasDAO.guardarMateria(materia);
		} catch (ExcepcionesDAO e) {

			e.printStackTrace();
		}
	}

	@Test
	public void testObtenerMateria() {
		Materias materia;
		
		try{
				
			materia= materiasDAO.obtenerMateria("20100101");
			System.out.println(materia.getNombre());
		} catch (ExcepcionesDAO e) {

			e.printStackTrace();
		}
	}

}
