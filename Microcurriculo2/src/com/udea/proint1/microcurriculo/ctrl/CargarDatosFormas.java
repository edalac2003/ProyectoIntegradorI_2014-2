package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PaisNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CargarDatosFormas extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CargarDatosFormas.class);
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbDocente;
	Combobox cmbPaisBiblio;
	
	Window formaCrearMicro;
	Window formaListarMicro;
	
	Button btnBuscar;
	
	Grid grillaListado;
	
	Listbox listaMicrocurriculo;
	
	
	
	/**
	 * Aqui se definen los objetos de tipos NGC los cuales se les harán las solicitudes de datos
	 */
		
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	MateriaNGC materiaNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	MicrocurriculoNGC microcurriculoNGC;
	PaisNGC paisNGC;
	
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
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron problemas al Obtener los registros de la tabla <Tb_Adm_UnidadAcademica>.  "+e);
		}		
	}
	
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
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Dependencia>.  "+e);
		}		
	}
	
	private void cargarNucleos(){
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			cmbNucleo.getItems().clear();
			if (listaNucleos != null){
				cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
				for(TbAdmNucleo nucleo : listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
				}
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Nucleo>.  "+e);
		}		
	}
	
	private void cargarMaterias(String nucleo){
		List<TbAdmMateria> listaMaterias = null;
		
		if (!nucleo.equals("") && (nucleo.length() > 1)){
			try {
				listaMaterias = materiaNGC.buscarMaterias(nucleo);
			} catch (ExcepcionesLogica e) {
				logger.error(e.getMessage());
			}
		} else {
			try {
				listaMaterias = materiaNGC.listarMaterias();
			} catch (ExcepcionesLogica e) {
				logger.error(e.getMessage());
			}
		}
				
		cmbMateria.getItems().clear();
		if(listaMaterias != null){
			for(TbAdmMateria materia : listaMaterias){
				Comboitem item = new Comboitem(materia.getVrIdmateria());
				item.setDescription(materia.getVrNombre());
				cmbMateria.appendChild(item);
			}
		}
		
	}
	
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
			} else
				Messagebox.show("No se Encontraron Registros de Semestres");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarDocentes(){
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
	
//	private void cargarPais(){
//		List<TbAdmPais> listaPais = null;
//		
//		try {
//			listaPais = paisNGC.listarPaises();
//		} catch (ExcepcionesLogica e) {
//			logger.error("Error al intentar Obtener el listado de los registros de la tabla <TbAdmPais>.");
//		}
//		
//		if (listaPais != null){
//			for(TbAdmPais pais : listaPais){
//				Comboitem item = new Comboitem(pais.getVrNombre());
//				cmbPaisBiblio.appendChild(item);
//			}
//		}
//	}
	
	private void inicializarFormaListado(){
		String cadenaInicial = "[Seleccione]";
		cmbUnidadAcademica.setValue(cadenaInicial);
		cmbDependencia.setValue(cadenaInicial);
		cmbNucleo.setValue(cadenaInicial);
		cmbSemestre.setValue(cadenaInicial);
		cmbMateria.setValue(cadenaInicial);
		cmbDocente.setValue(cadenaInicial);		
	}
	
	private void cargarDependenciaPorUnidadAcademica(String unidad){
		
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
	
	private void cargarNucleosPorDependencia(String dependencia){
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
	
	private void cargarMateriasPorNucleo(String nucleo){
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
	
	private void inicializarFormaCrear(){
		String cadenaInicial = "[Seleccione]";
		cmbUnidadAcademica.setValue(cadenaInicial);
		cmbDependencia.setValue(cadenaInicial);
		cmbNucleo.setValue(cadenaInicial);
		cmbSemestre.setValue(cadenaInicial);
		cmbDocente.setValue(cadenaInicial);
		cmbMateria.setValue(cadenaInicial);
	}
	
	/**
	 * Definiendo los Eventos de los Objetos Combobox de la Forma
	 */
	
	public void onSelect$cmbUnidadAcademica(){
		cargarDependenciaPorUnidadAcademica(cmbUnidadAcademica.getValue());
	}
	
	public void onSelect$cmbDependencia(){
		cargarNucleosPorDependencia(cmbDependencia.getValue());
	}
	
	public void onSelect$cmbNucleo(){
		cargarMateriasPorNucleo(cmbNucleo.getValue());
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		if (comp.getParent().getId().equals("formaCrearMicro")){
			inicializarFormaCrear();
			
		} else if (comp.getParent().getId().equals("formaListarMicro")){
			inicializarFormaListado();
			cargarMaterias(cmbNucleo.getValue());
			
		}
		cargarUnidades();
		cargarDependencias();
		cargarSemestres();
		cargarNucleos();
		cargarDocentes();
	}

}
