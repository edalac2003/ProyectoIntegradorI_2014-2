package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriasDAOHibernateTest {

	@Autowired
	MateriasDAOHibernate materiasDAO;
	
	@Test
	public void testListarMateriasPorSemestre() {
		 
		 List<TbAdmMaterias> materias = new ArrayList<TbAdmMaterias>();
		 try{
			 materias = materiasDAO.listarMateriasPorSemestre(201402);
			 for ( Iterator iterador = materias.listIterator(); iterador.hasNext(); ) {
                 TbAdmMaterias mat = (TbAdmMaterias) iterador.next();
                 System.out.println("Nombre de materia: " + mat.getVrNombre());
           }
		 }catch(ExcepcionesDAO e){
			 
		 }
	}
	
	@Test
	public void testListarMaterias() {
		 MateriasDAOHibernate materia = new MateriasDAOHibernate();
		 
		 try{
			 List<TbAdmMaterias> materias = new ArrayList<TbAdmMaterias>();
			 materia.listarMaterias();
		 }catch(ExcepcionesDAO e){
			 
		 }
	}

}
