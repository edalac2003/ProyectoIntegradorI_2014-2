package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import javax.mail.Message;

import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dao.SubtemaxTemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SubtemaxTemaNGCImpl implements SubtemaxTemaNGC {


	SubtemaxTemaDAO subtemaxTemaDao;
	
	
	public void setSubtemaxTemaDao(SubtemaxTemaDAO subtemaxTemaDao) {
		this.subtemaxTemaDao = subtemaxTemaDao;
	}


	@Override
	public void guardar(TbMicSubtemaxtema subtemaxTema)	throws ExcepcionesLogica {
		
		if (subtemaxTema != null){
			try {
				subtemaxTemaDao.guardar(subtemaxTema);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("NGC : No se puede guardar el registro <SubtemaxTema>.   "+e.getMessage());
			}
		} else{
			Messagebox.show("El Objeto SubTemaxTema no contiene informaci�n v�lida. \n Por favor corrijala."+"Error Guardar"+Messagebox.ERROR);
		}

	}

	
	@Override
	public void modificar(TbMicSubtemaxtema subtemaxTema)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema(int idSubtema)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema_Tema(int idTema)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema_Tema(int idTema)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = subtemaxTemaDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("NGC : Se presentaron errores al Obtener el numero de registros de la tabla <SubtemaxTema>" + e.getMessage());
		}
		
		return registro;
	}

}
