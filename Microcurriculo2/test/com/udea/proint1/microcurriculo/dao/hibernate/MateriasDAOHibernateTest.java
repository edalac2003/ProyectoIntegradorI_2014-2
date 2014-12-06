package com.udea.proint1.microcurriculo.dao.hibernate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriasDAOHibernateTest {

	@Autowired
	MateriaDAOHibernate materiasDAO;
	
	@Test
	public void testListarMateriasPorSemestre() {
		 
		 List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
		 try{
			 materias = materiasDAO.listarMateriasPorSemestre(201402);
			 for ( Iterator iterador = materias.listIterator(); iterador.hasNext(); ) {
                 TbAdmMateria mat = (TbAdmMateria) iterador.next();
                 System.out.println("Nombre de materia: " + mat.getVrNombre());
           }
		 }catch(ExcepcionesDAO e){
			 
		 }
	}
	
	@Test
	public void testListarMaterias() {
		 MateriaDAOHibernate materia = new MateriaDAOHibernate();
		 
		 try{
			 List<TbAdmMateria> materias = new ArrayList<TbAdmMateria>();
			 materia.listarMaterias();
		 }catch(ExcepcionesDAO e){
			 
		 }
	}

}
