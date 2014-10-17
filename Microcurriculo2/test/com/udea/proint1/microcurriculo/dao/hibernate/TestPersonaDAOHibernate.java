package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.Persona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

public class TestPersonaDAOHibernate {

	@Autowired
	PersonaDAO personaDAO;
	
	@Test
	public void testPersonaDAOHibernate() {
		fail("Not yet implemented");
	}

	/*@Test
	public void testGuardarPersona() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarPersona() {
		fail("Not yet implemented");
	}*/

	/*@Test
	public void testObtenerPersona() {
		try{
			Persona persona = personaDAO.obtenerPersona("92532121");
			
			System.out.println(persona.getApellidos() +"  "+persona.getNombres());
			
			assertTrue(true);
		}catch(ExcepcionesDAO e){
			
		}
	}*/

	@Test
	public void testListarPersonas() {
		try{
			for(Persona persona: personaDAO.listarPersonas()){
				System.out.println(persona.getApellidos()+" "+persona.getNombres());
			}
		}catch(ExcepcionesDAO e){
			
		}
	}
	
	/*@Test
	public void testObtenerPersonaPorTipo() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testListarDocentePorNucleo() {
		fail("Not yet implemented");
	}*/

}
