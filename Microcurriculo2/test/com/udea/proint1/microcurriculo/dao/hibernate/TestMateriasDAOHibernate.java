package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class TestMateriasDAOHibernate {

	static final Logger log = Logger.getLogger(TestMateriasDAOHibernate.class);

	@Autowired
	MateriaDAO materiasDAO;

	/*
	 * @Test public void testMateriasDAOHibernate() {
	 * fail("Not yet implemented"); }
	 */

	@Test
	public void testGuardarMateria() {
		TbAdmMateria materias = new TbAdmMateria();
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
		TbAdmNucleo nucleo = new TbAdmNucleo();
		nucleo.setVrNombre("2010");
		materias.setTbAdmNucleo(nucleo);
		materias.setVrModusuario("USER");
		materias.setDtModfecha(null);
		try {
			materiasDAO.guardarMateria(materias);
			assertTrue(true);
		} catch (ExcepcionesDAO e) {

		}

	}

	@Test
	public void testObtenerMateria() {
		try {
			TbAdmMateria materia = materiasDAO.obtenerMateria("0000000009");
			System.out.println(materia.getVrNombre());
			assertTrue(true);
		} catch (ExcepcionesDAO e) {

		}
	}

	@Test
	public void testListarMaterias() {
		try {
			for (TbAdmMateria materia : materiasDAO.listarMaterias()) {
				System.out.print(materia.getVrIdmateria() + "  ");
				System.out.println(materia.getVrNombre());
				assertTrue(true);
			}
		} catch (ExcepcionesDAO e) {

		}
	}

	@Test
	public void testListarMateriasPorNucleo() {
		List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
		 try{
			 materias = materiasDAO.listarMateriasPorNucleo("0000001");
			 Iterator<TbAdmMateria> iterador = materias.listIterator();
			 while( iterador.hasNext() ) {
				    TbAdmMateria m = (TbAdmMateria) iterador.next();
				    System.out.println(m.getVrNombre());
				    assertTrue(true);
			 }
		 }catch(ExcepcionesDAO e){
			 
		 }
	}

	@Test
	public void testListarMateriasPorSemestre() {

		List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
		try {
			materias = materiasDAO.listarMateriasPorSemestre(201402);
			Iterator<TbAdmMateria> iterador = materias.listIterator();
			while (iterador.hasNext()) {
				TbAdmMateria m = (TbAdmMateria) iterador.next();
				System.out.println(m.getVrNombre());
				// si es necesario lo borramos con:
				// iterador.remove();
			}
		} catch (ExcepcionesDAO e) {

		}
	}
	/*
	 * @Test public void testActualizarMateria() { TbAdmMaterias materia = new
	 * TbAdmMaterias(); materia.setVrIdmateria("0000000009");
	 * materia.setVrNombre("Logica y Representación III");
	 * materia.setNbSemestre(1); materia.setNbCreditos(4);
	 * materia.setBlHabilitable('0'); materia.setBlValidable('1');
	 * materia.setBlClasificable('0'); materia.setNbHt(10); materia.setNbHp(15);
	 * materia.setNbHtp(12); TbAdmNucleo nucleo = new TbAdmNucleo();
	 * nucleo.setVrNombre("2010"); materia.setTbAdmNucleo(nucleo);
	 * materia.setVrModusuario("USER"); materia.setDtModfecha(null); try {
	 * materiasDAO.actualizarMateria(materia); } catch (ExcepcionesDAO e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } }
	 */
}
