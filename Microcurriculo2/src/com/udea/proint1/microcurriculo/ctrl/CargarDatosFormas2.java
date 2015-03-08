package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PaisNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CargarDatosFormas2 extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CargarDatosFormas2.class);
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbMicrocurriculo;
	Combobox cmbDocente;
	Combobox cmbEstado;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	MateriaNGC materiaNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	MicrocurriculoNGC microcurriculoNGC;
	PaisNGC paisNGC;
	EstadoNGC estadoNGC;
	
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}
	
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}
	
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}
	
	public void setPaisNGC(PaisNGC paisNGC) {
		this.paisNGC = paisNGC;
	}
			
	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}
	
	/**
	 * Solicita de la capa del negocio todas las unidades existentes y las ubica en el combobox cmbUnidadAcademica
	 */
	private void cargarUnidades(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
			if (listaUnidadAcademica != null){			
				cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					item.setDescription(unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
				}
				cmbUnidadAcademica.setValue("[Seleccione]");
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron problemas al Obtener los registros de la tabla <Tb_Adm_UnidadAcademica>.  "+e);
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas las dependencias existentes y las ubica en el combobox cmbDependencia
	 */
	private void cargarDependencias(){
		try {
			List<TbAdmDependencia> listaDependencias = dependenciaNGC.listarDependencias();
			cmbDependencia.getItems().clear();
			if (listaDependencias != null){
				cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmDependencia dependencia : listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					item.setDescription(dependencia.getVrNombre());
					cmbDependencia.appendChild(item);
				}
				cmbDependencia.setValue("[Seleccione]");
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Dependencia>.  "+e);
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas los nucleos existentes y las ubica en el combobox cmbNucleo
	 */
	private void cargarNucleos(){
		cmbNucleo.getItems().clear();
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			listaNucleos = nucleoNGC.listarNucleos();
			if (listaNucleos != null){
				cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmNucleo nucleo : listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
				}
				cmbNucleo.setValue("[Seleccione]");
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Nucleo>.  "+e);
		}		
	}
	
	/**
	 * Solicita de la capa del negocio todas las materias existentes y las ubica en el combobox cmbMateria
	 */
	public void cargarMaterias(){
		try {
			List<TbAdmMateria> listaMaterias = materiaNGC.listarMaterias();
			cmbMateria.getItems().clear();
			
			if(listaMaterias != null){
				cmbMateria.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmMateria materia: listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					item.setDescription(materia.getVrNombre());
					cmbMateria.appendChild(item);
				}
				cmbMateria.setValue("[Seleccione]");
			}else{
				Messagebox.show("No se hallaron materias");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
			logger.error("error al invocar metodo listarMaterias de la clase MateriaNGC: "+e);
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los semestres existentes y los ubica en el combobox cmbSemestre
	 */
	private void cargarSemestres(){
		try {
			List<TbAdmSemestre> listaSemestre = semestreNGC.listarSemestres();
			cmbSemestre.getItems().clear();
			if (listaSemestre != null){
				cmbSemestre.appendChild(new Comboitem("[Seleccione]"));
				for (TbAdmSemestre semestre : listaSemestre){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbSemestre.appendChild(item);
				}
				cmbSemestre.setValue("[Seleccione]");
			} else
				Messagebox.show("No se Encontraron Registros de Semestres");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los estados existentes y los ubica en el combobox cmbEstado
	 */
	public void cargarEstados(){
		try {
			List<TbMicEstado> listaEstados = estadoNGC.listarEstados();
			cmbEstado.getItems().clear();
			
			if(listaEstados != null){
				cmbEstado.appendChild(new Comboitem("[Seleccione]"));
				for(TbMicEstado estado: listaEstados){
					Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
					item.setDescription(estado.getVrDescripcion());
					cmbEstado.appendChild(item);
				}
				cmbEstado.setValue("[Seleccione]");
			}else{
				//Messagebox.show("No se hallaron estados");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
			logger.error("error al invocar metodo listarEstados de la clase EstadoNGC: "+e);
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los docentes existentes y los ubica en el combobox cmbDocente
	 */
	private void cargarDocentes(){
		try {
			List<TbAdmPersona> listaDocentes = personaNGC.obtenerDocentes();
			cmbDocente.getItems().clear();
			if (listaDocentes != null){
				for(TbAdmPersona docente : listaDocentes){
					Comboitem item = new Comboitem(docente.getVrIdpersona());
					item.setDescription(docente.getVrApellidos()+" "+docente.getVrNombres());
					cmbDocente.appendChild(item);
				}
			} else
				Messagebox.show("No Se Hallaron Registros de Docentes");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Solicita de la capa del negocio todos los microcurriculos existentes y los ubica en el combobox cmbMicrocurriculo
	 */
	private void cargarMicrocurriculos(){
		cmbMicrocurriculo.getItems().clear();
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		if(listaMicrocurriculos != null){
			for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
				Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
				cmbMicrocurriculo.appendChild(item);
			}
		}
		cmbMicrocurriculo.setValue("[Seleccione]");
	}
	
	/**
	 * Hace la busqueda de las dependencias existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param unidad contiene indicio de id para busquedas de dependencias que coincidan
	 */
	private void recargarDependencias(String unidad){
		if(!cmbDependencia.getValue().toString().equals("[Seleccione]")){
			try {		
				List<TbAdmDependencia> listaDependencias = dependenciaNGC.listarDependenciasPorUnidad(unidad);
				cmbDependencia.getItems().clear();
				cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
				if (listaDependencias != null){
					for(TbAdmDependencia dependencia : listaDependencias){
						Comboitem item = new Comboitem(dependencia.getVrIddependencia());
						item.setDescription(dependencia.getVrNombre());
						cmbDependencia.appendChild(item);
					}
				}
				cmbDependencia.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Dependencia>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de los nucleos existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param dependencia contiene indicio de id para busquedas de nucleos que coincidan
	 */
	private void recargarNucleos(String dependencia){
		if(!cmbNucleo.getValue().toString().equals("[Seleccione]")){
			try {
				List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleosPorDependencia(dependencia);
				cmbNucleo.getItems().clear();
				if (listaNucleos != null){
					cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
					for(TbAdmNucleo nucleo : listaNucleos){
						Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
						item.setDescription(nucleo.getVrNombre());
						cmbNucleo.appendChild(item);
					}
				}
				cmbNucleo.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Nucleo>.  "+e);
			}
		}
	}
	
	/**
	 * Hace la busqueda de las materias existentes que contengan el parametro id que llega
	 * por argumento en el metodo
	 * @param nucleo contiene indicio de id para busquedas de materias que coincidan
	 */
	private void recargarMaterias(String nucleo){
		if(!cmbMateria.getValue().toString().equals("[Seleccione]")){
			try {
				List<TbAdmMateria> listaMateria = materiaNGC.listarMateriasxNucleo(nucleo);
				if (listaMateria != null){
					cmbMateria.getItems().clear();
					for(TbAdmMateria materia : listaMateria){
						Comboitem item = new Comboitem(materia.getVrIdmateria());
						item.setDescription(materia.getVrNombre());
						cmbMateria.appendChild(item);
					}
				}
				cmbMateria.setValue("[Seleccione]");
			} catch (ExcepcionesLogica e) {
				logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Materia>.  "+e);
			}
		}
	}
	
	public void recargarMicrocurriculos(String buscaMicrocurriculos){
		if(cmbMicrocurriculo != null){
			try {
				buscaMicrocurriculos = buscaMicrocurriculos + "%";
				List<TbMicMicrocurriculo> listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculosPorMateria(buscaMicrocurriculos);
				cmbMicrocurriculo.getItems().clear();
				
				if(listaMicrocurriculos != null){
					for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
						Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
						cmbMicrocurriculo.appendChild(item);
					}
				}else{
					Messagebox.show("No se hallaron microcurriculos");
				}
			} catch (ExcepcionesLogica e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbUnidadAcademica este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbUnidadAcademica(){
		recargarDependencias(cmbUnidadAcademica.getValue());
		recargarNucleos(cmbUnidadAcademica.getValue());
		recargarMaterias(cmbUnidadAcademica.getValue());
		recargarMicrocurriculos(cmbUnidadAcademica.getValue());
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbDependencia este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbDependencia(){
		recargarNucleos(cmbDependencia.getValue());
		recargarMaterias(cmbDependencia.getValue());
		recargarMicrocurriculos(cmbDependencia.getValue());
	}
	
	/**
	 * Ante el evento seleccion en el combobox cmbNucleo este procede a invocar metodos
	 * que hacen el filtrado de los demas combobox relacionados
	 */
	public void onSelect$cmbNucleo(){
		recargarMaterias(cmbNucleo.getValue());
		recargarMicrocurriculos(cmbNucleo.getValue());
	}
	
	public void onSelect$cmbMateria(){
		recargarMicrocurriculos(cmbMateria.getValue());
	}
	
	/**
	 * Se inicializan todos los combobox
	 */
	private void inicializarFormaListado(){
		String cadenaInicial = "[Seleccione]";
		cmbUnidadAcademica.setValue(cadenaInicial);
		cmbDependencia.setValue(cadenaInicial);
		cmbNucleo.setValue(cadenaInicial);
		cmbSemestre.setValue(cadenaInicial);
		cmbMateria.setValue(cadenaInicial);
		cmbDocente.setValue(cadenaInicial);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		if (comp.getParent().getId().equals("formaListarMicro")){
			inicializarFormaListado();
			cargarMaterias();
			cargarUnidades();
			cargarDependencias();
			cargarNucleos();
			cargarSemestres();
			cargarDocentes();
		} else if(comp.getParent().getId().equals("panelDuplicarMicro")){
			cargarMaterias();
			cargarUnidades();
			cargarDependencias();
			cargarNucleos();
			cargarMicrocurriculos();
			cargarSemestres();
		}
	}
	
}
