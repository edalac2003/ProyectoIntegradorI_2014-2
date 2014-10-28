package com.udea.proint1.microcurriculo.dao.hibernate;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
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
		TbAdmMaterias materias = new TbAdmMaterias();
		materias.setVrIdmateria("20100102");
		materias.setVrNombre("Logica y Representación II");
		materias.setNbSemestre(2);
		materias.setNbCreditos(4);
		materias.setBlHabilitable('1');
		materias.setBlValidable('1');
		materias.setBlClasificable('1');
		materias.setNbHt(10);
		materias.setNbHp(15);
		materias.setNbHtp(12);
		TbAdmNucleo nucleo  = new TbAdmNucleo();
		nucleo.setVrNombre("2010");
		materias.setTbAdmNucleo(nucleo);
		materias.setVrModusuario("USER");
		materias.setDtModfecha(null);
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
