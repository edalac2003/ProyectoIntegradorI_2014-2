package com.udea.proint1.microcurriculo.dao.hibernate;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

public class TestMicrocurriculosDAOHibernate {

	static final Logger log = Logger.getLogger(TestMicrocurriculosDAOHibernate.class);
	@Autowired 
	MicrocurriculosDAO microcurriculosDAO;
	/*
	@Test
	public void testMicrocurriculosDAOHibernate() {
		fail("Not yet implemented");
	}*/

	@Test
	@Rollback(true)
	public void testGuardarMicrocurriculo() {
		TbMicMicrocurriculos microcurriculo = new TbMicMicrocurriculos();
		microcurriculo.setVrIdmicrocurriculo("2010010101");
		TbAdmMaterias materias = new TbAdmMaterias();
		materias.setVrNombre("Logica");
		microcurriculo.setTbAdmMaterias(materias);
		microcurriculo.setVrResumen("Este es un resumen");
		microcurriculo.setVrMetodologia("Esta es la Metodologia");
		microcurriculo.setNbSemestre(20142);
		microcurriculo.setVrResponsable("RESPONSABLE");
		microcurriculo.setVrModusuario("QUIEN MODIFICA");
		microcurriculo.setDtModfecha(null);
		try{
			microcurriculosDAO.guardarMicrocurriculo(microcurriculo);
		}catch(ExcepcionesDAO e){
			
		}
	}
	/*
	@Test
	public void testObtenerMicrocurriculo() {
		try{
			TbMicMicrocurriculos microcurriculo = microcurriculosDAO.obtenerMicrocurriculo("2010010101");
			if (microcurriculo == null){
				System.out.println("No se ha encontrado ninguna información");
			}else{
				System.out.println(microcurriculo.getTbAdmMaterias().getVrNombre());
			}
		}catch(ExcepcionesDAO e){
			
		}
	}*/

	/*@Test
	public void testListarMicrocurriculos() {
		
	}

	@Test
	public void testModificarMicrocurriculo() {
		fail("Not yet implemented");
	}*/

}
