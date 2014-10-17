package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dto.Microcurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

public class TestMicrocurriculosDAOHibernate {

	static final Logger log = Logger.getLogger(TestMicrocurriculosDAOHibernate.class);
	@Autowired 
	MicrocurriculosDAO microcurriculosDAO;
	
	/*@Test
	public void testMicrocurriculosDAOHibernate() {
		fail("Not yet implemented");
	}*/

	@Test
	@Rollback(true)
	public void testGuardarMicrocurriculo() {
		Microcurriculos microcurriculo = new Microcurriculos();
		microcurriculo.setIdMicrocurriculo("2010010101");
		microcurriculo.setMateria("20100101");
		microcurriculo.setResumen("Este es un resumen");
		microcurriculo.setMetodologia("Esta es la Metodologia");
		microcurriculo.setSemestre("20142");
		microcurriculo.setResponsable("RESPONSABLE");
		microcurriculo.setModUsuario("QUIEN MODIFICA");
		microcurriculo.setModFecha(null);
		try{
			microcurriculosDAO.guardarMicrocurriculo(microcurriculo);
		}catch(ExcepcionesDAO e){
			
		}
	}

	/*@Test
	public void testObtenerMicrocurriculo() {
		try{
			Microcurriculos microcurriculo = microcurriculosDAO.obtenerMicrocurriculo("2010010101");
			if (microcurriculo == null){
				System.out.println("No se ha encontrado ninguna información");
			}else{
				System.out.println(microcurriculo.getMateria());
			}
		}catch(ExcepcionesDAO e){
			
		}
	}*/

	/*@Test
	public void testListarMicrocurriculos() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarMicrocurriculo() {
		fail("Not yet implemented");
	}*/

}
