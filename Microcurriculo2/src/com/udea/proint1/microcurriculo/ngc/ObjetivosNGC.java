package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivosNGC {

	
	public TbMicObjetivos obtenerSubtemas(int idObjetivo) throws ExcepcionesLogica;
	public void guardarObjetivos (int idObjetivo, String descripcion, Character tipo,  String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarObjetivos (String descripcion, Character tipo,  String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicObjetivos> listarObjetivos () throws ExcepcionesLogica;
}
