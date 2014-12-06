package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

public class TestMicrocurriculosDAOHibernate {

	static final Logger log = Logger.getLogger(TestMicrocurriculosDAOHibernate.class);
	@Autowired 
	MicrocurriculoDAO microcurriculosDAO;
	/*
	@Test
	public void testMicrocurriculosDAOHibernate() {
		fail("Not yet implemented");
	}*/

	@Test
	@Rollback(true)
	public void testGuardarMicrocurriculo() {
		TbMicMicrocurriculo microcurriculo = new TbMicMicrocurriculo();
		microcurriculo.setVrIdmicrocurriculo("2010010101");
		TbAdmMateria materias = new TbAdmMateria();
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
	
	@Test
	@Rollback(true)
	public void testlistarMicrocurriculosPorMateria() throws ExcepcionesDAO{
		TbAdmMateria materia = new TbAdmMateria();
		materia.setVrIdmateria("0000000009");
		materia.setVrNombre("Logica y Representacion I");
		List<TbMicMicrocurriculo> microcurriculos = microcurriculosDAO.listarMicrocurriculosPorMateria(materia);
	}
	/*public void testObtenerMicrocurriculo() {
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
