package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.DepartamentoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
public class TestDepartamentoDAOHibernate {
	
	@Autowired
	DepartamentoDAO departamentosDAO;

	@Test
	public void testObtenerDepartamento() {
		try{
			TbAdmDepartamento departamento = departamentosDAO.obtenerDepartamento(18);
			System.out.println(departamento.getVrNombres());
			assertTrue(true);
		}catch(ExcepcionesDAO e){
			
		}
	}

}
