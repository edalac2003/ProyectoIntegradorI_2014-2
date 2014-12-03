package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivosNGC {
	
	public TbMicObjetivos obtenerObjetivo(int id) throws ExcepcionesLogica;
	
	public void guardarObjetivo (TbMicObjetivos objetivo) throws ExcepcionesLogica;
	
    public void actualizarObjetivos (TbMicObjetivos objetivo) throws ExcepcionesLogica;
    
    public List<TbMicObjetivos> listarObjetivos () throws ExcepcionesLogica;
    
    public int numeroRegistros() throws ExcepcionesLogica;
    
    public List<TbMicObjetivos> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesLogica;
	
	public List<TbMicObjetivos> listarObjetivosPorTipo(char tipo) throws ExcepcionesLogica;
    
}
