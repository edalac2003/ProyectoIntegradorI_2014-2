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

import com.udea.proint1.microcurriculo.dao.DepartamentosDAO;
import com.udea.proint1.microcurriculo.dto.Departamentos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

public class TestDepartamentosDAOHibernate {
	
	static final Logger log=Logger.getLogger(DepartamentosDAOHibernate.class);

	@Autowired
	DepartamentosDAO departamentosDAO;
	
	@Test
	public void testObtenerDepartamento() throws ExcepcionesDAO {
		Departamentos departamento;
		
		try{
			departamento = departamentosDAO.obtenerDepartamento(20);
			System.out.println(departamento.getNombre());
		} catch (ExcepcionesDAO e) {
			
			log.info(e.getMessage());
			//e.printStackTrace();
		}
	}

}
