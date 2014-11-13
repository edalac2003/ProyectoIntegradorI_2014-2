package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicrocurriculosNGC {
	
	public TbMicMicrocurriculos obtenerMicrocurriculos (String idMicrocurriculo) throws ExcepcionesLogica;
	
	public void guardarMicrocurriculos (TbMicMicrocurriculos microcurriculo) throws ExcepcionesLogica;
    
	public void actualizarMicrocurriculos (TbMicMicrocurriculos microcurriculo) throws ExcepcionesLogica;
    
    public List<TbMicMicrocurriculos> listarMicrocurriculos () throws ExcepcionesLogica;
    
    public List<TbMicMicrocurriculos> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesLogica;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorNucleo(String idNucleo) throws ExcepcionesLogica;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesLogica;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorResponsable(String idResponsable) throws ExcepcionesLogica;

}
