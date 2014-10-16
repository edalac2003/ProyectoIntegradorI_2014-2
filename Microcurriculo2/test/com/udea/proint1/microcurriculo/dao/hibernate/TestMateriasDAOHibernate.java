package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
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

	static final Logger log = Logger.getLogger(TestMateriasDAOHibernate.class);

	@Autowired
	MateriasDAO materiasDAO;
	
	/*@Test
	public void testMateriasDAOHibernate() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testGuardarMateria()  {
		Materias materias = new Materias();
		materias.setIdMateria("20100102");
		materias.setNombre("Logica y Representación II");
		materias.setSemestre(2);
		materias.setCreditos(4);
		materias.setHabilitable('1');
		materias.setValidable('1');
		materias.setClasificable('1');
		materias.setHt(10);
		materias.setHp(15);
		materias.setHtp(12);
		materias.setNucleo("2010");
		materias.setModUsuario("USER");
		materias.setModFecha(null);
		try{
			materiasDAO.guardarMateria(materias);
		}catch(ExcepcionesDAO e){
			
		}
		
	}

	/*@Test
	public void testObtenerMateria() {
		try{
			Materias materia = materiasDAO.obtenerMateria("20100101");
			System.out.println(materia.getNombre());
			assertTrue(true);
		}catch(ExcepcionesDAO e){
			
		}
	}*/

	/*@Test
	public void testListarMaterias() {
		try{
			for(Materias materia: materiasDAO.listarMaterias()){
				System.out.print(materia.getIdMateria()+"  ");
				System.out.println(materia.getNombre());
				
			}
		}catch(ExcepcionesDAO e){
			
		}
	}*/

	/*@Test
	public void testListarMateriasPorNucleo() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarMateriasPorSemestre() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizarMateria() {
		
	}*/

}
