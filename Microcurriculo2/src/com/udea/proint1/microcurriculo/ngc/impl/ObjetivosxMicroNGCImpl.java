package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.ObjetivosxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.ngc.ObjetivosxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivosxMicroNGCImpl implements ObjetivosxMicroNGC {

	ObjetivosxMicroDAO objetivosxMicroDao;
	
		
	public void setObjetivosxMicroDao(ObjetivosxMicroDAO objetivosxMicroDao) {
		this.objetivosxMicroDao = objetivosxMicroDao;
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro)	throws ExcepcionesLogica {
		TbMicObjetivosxmicro objetivosxMicroTMP = null;
		
		if(objetivoxMicro != null){
			try {
				objetivosxMicroTMP = objetivosxMicroDao.obtenerObjetivoxMicro(objetivoxMicro.getNbId());
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar obtener el objeto <ObjetivoxMicro>");
			}
		}else{
			throw new ExcepcionesLogica("El Objeto <ObjetivoxMicro> está vacio.");
		}
		
		if(objetivosxMicroTMP == null){
			try {
				objetivosxMicroDao.guardarObjetivosxMicro(objetivoxMicro);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar guardar el objeto <ObjetivoxMicro>");
			}
		}else{
			throw new ExcepcionesLogica("El objeto <ObjetivoxMicro> ya Existe.");
		}
	}

	
	
	@Override
	public void guardarObjetivosxMicro(List<TbMicObjetivosxmicro> listaObjetivoxMicro) throws ExcepcionesLogica {
		if (listaObjetivoxMicro != null){
			for(TbMicObjetivosxmicro objetivoxMicro : listaObjetivoxMicro){
				guardarObjetivosxMicro(objetivoxMicro);				
			}
		}else{
			throw new ExcepcionesLogica("El objeto <Lista ObjetivoxMicrocurriculo no tiene información válida.");
		}
	}

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro)throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(String idMicrocurriculo,	int idObjetivo) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(int idObjetivo) throws ExcepcionesLogica {
		TbMicObjetivosxmicro objetivoxMicro = null;
		
		try {
			objetivoxMicro = objetivosxMicroDao.obtenerObjetivoxMicro(idObjetivo);
			if (objetivoxMicro != null)
				return objetivoxMicro;
			else
				return null;
			
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Error al intentar objetener el Objeto <ObjetivoxMicrocurriculo>");
		}
		
	}

	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = objetivosxMicroDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se presentaron error al Obtener el numero de Registros de la Tabla Objetivos x Microcurriculo.");
		}		
		
		return registro;
	}

}
