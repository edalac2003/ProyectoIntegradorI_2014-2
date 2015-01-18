package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

@SuppressWarnings("rawtypes")
public class ListarMicroCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ListarMicroCtrl.class);
	
	/**
	 * Aqui se definen los objetos de tipos NGC los cuales se les harán las solicitudes de datos
	 */
		
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	
	
	
	/**
	 * Aqui se definen los objetos que componen la vista
	 */
	Grid grillaListado;
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbResponsable;
	
	
	Comboitem itemInicial = new Comboitem("[Seleccione]");
	/**
	 * Se Definen los Setters para cada componente
	 * @param unidadAcademicaNGC
	 */	
	
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	
	
	
	/**
	 * Se cargaran las Unidades en el Combobox de la vista
	 */
	private void cargarUnidades(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
			if (listaUnidadAcademica != null){			
				cmbUnidadAcademica.appendChild(itemInicial);
				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					cmbUnidadAcademica.appendChild(item);
				}
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron problemas al Obtener listado de la tabla <TbAdmUnidadAcademica>.  "+e);
		}		
	}
	
	public void onSelect$cmbUnidadAcademica(){
		cargarDependenciasPorUnidad(cmbUnidadAcademica.getValue().toString());
	}
		
	private void cargarDependenciasPorUnidad(String idUnidad){
		try {
			List<TbAdmDependencia> listaDependencia = dependenciaNGC.listarDependenciasPorUnidad(idUnidad);
			if (listaDependencia != null){
				for (TbAdmDependencia dependencia : listaDependencia){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					cmbDependencia.appendChild(item);
				}
			} else {
				Messagebox.show("No se Encontraron Registros de Dependencias.");
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar las Dependencias por Unidad.  "+e);
		}
	}
	
	public void onSelect$cmbDependencia(){
		cargarNucleosPorDependencia(cmbDependencia.getValue());
	}	
	
	private void cargarNucleosPorDependencia(String idDependencia){
		System.out.println("El valor a buscar es... "+idDependencia);
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleosPorDependencia(idDependencia);
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo : listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					cmbNucleo.appendChild(item);
				}
			} else
				System.out.println("La lista esta vacia");
			
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los Nucleos por Dependencias.  "+e);
		}
	}
	
	
	
	private void inicializarCombos(){
		cmbUnidadAcademica.setValue(itemInicial.getLabel());
		cmbDependencia.setValue(itemInicial.getLabel());
		cmbNucleo.setValue(itemInicial.getLabel());
		cmbSemestre.setValue(itemInicial.getLabel());
		cmbMateria.setValue(itemInicial.getLabel());
		cmbResponsable.setValue(itemInicial.getLabel());		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		
		super.doAfterCompose(comp);
		inicializarCombos();
		cargarUnidades();
	}
}
