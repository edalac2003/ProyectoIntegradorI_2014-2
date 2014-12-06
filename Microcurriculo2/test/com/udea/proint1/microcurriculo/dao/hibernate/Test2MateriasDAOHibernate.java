package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MateriaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class Test2MateriasDAOHibernate {

	@Autowired
	MateriaDAO materiasDAO;
	
	@Test
	public void testBuscarMaterias() {
		try {
			for(TbAdmMateria materia: materiasDAO.buscarMaterias("201001%")){
				System.out.println("materia: "+ materia.getVrNombre());
			}
		} catch (ExcepcionesDAO e) {
			System.out.println(e);
		}
	}

}
