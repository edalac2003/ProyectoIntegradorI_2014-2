package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dao.TipoPersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

public class TestPersonaDAOHibernate {

	@Autowired
	PersonaDAO personaDao;
	
	@Autowired
	TipoPersonaDAO tipoPersonaDao;
	
	@Test
	public void testPersonaDAOHibernate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGuardarPersona() {
		
	}

	@Test
	public void testModificarPersona() {
		fail("Not yet implemented");
	}

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
			for(TbAdmPersona persona: personaDao.listarPersonas()){
				System.out.println(persona.getVrApellidos()+" "+persona.getVrNombres());
			}
		}catch(ExcepcionesDAO e){
			
		}
	}
	
	@Test
	public void testObtenerDocente() {
		TbAdmTipopersona tipoPersonaConsulta =null;
		
		try{
			tipoPersonaConsulta = tipoPersonaDao.obtenerTipoPersona(2);
			
			for(TbAdmPersona persona: personaDao.obtenerDocentes(tipoPersonaConsulta)){
                System.out.println("/*/*/*/*/*/*/*/*/*/*/**/");
                System.out.println("Cedula: " + persona.getVrIdpersona());
                System.out.println("Nombres: " + persona.getVrNombres());
                
        }

			
		}catch(ExcepcionesDAO e){
			
		}
	} 

	

	/*@Test
	public void testListarDocentePorNucleo() {
		fail("Not yet implemented");
	}*/

}
