package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

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

public class CargarDatosFormas extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CargarDatosFormas.class);
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbMicrocurriculo;
	Combobox cmbDocente;
	Combobox cmbEstado;
	Combobox cmbPaisBiblio;
	
	Label lblNombreUnidadAcademica;
	Label lblNombreDependencia;
	Label lblNombreMateria;
	Label lblNombreDocente;
	Label lblNombreNucleo;
	Label lblNombreEstado;
	Label lblCreditosMateria;
	Label lblHtMateria;
	Label lblHpMateria;
	Label lblHtpMateria;
	Label lblHoraClaseSemestral;
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
//	Window formaCrearMicro;
//	Window formaListarMicro;
	
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
	
	private void cargarEstados(){
		List<TbMicEstado> listaEstados = null;
		cmbEstado.getItems().clear();
		
		try {
			 listaEstados = estadoNGC.listarEstados();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		if(listaEstados != null){
			for(TbMicEstado estado: listaEstados){
				Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
				item.setDescription(estado.getVrDescripcion());
				cmbEstado.appendChild(item);
			}
		}		
	}
	
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
	}
	
	private void cargarMicroxMateriaxSemestre(String codigoMicro){
		
		TbMicMicrocurriculo microcurriculo = null;
		cmbMicrocurriculo.getItems().clear();
		
		try {
			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(codigoMicro);
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		if (microcurriculo != null){
			Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
			cmbMicrocurriculo.appendChild(item);
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
	 * Definiendo los Eventos de los Objetos de la Forma
	 */
	
	public void onOK$cmbUnidadAcademica(){
		cmbDependencia.setDisabled(false);
		cmbDependencia.focus();
	}
	
	public void onOK$cmbDependencia(){
		cmbNucleo.setDisabled(false);
		cmbNucleo.focus();
	}
	
	public void onOK$cmbNucleo(){
		cmbMateria.setDisabled(false);
		cmbMateria.focus();
	}
		
	public void onOK$cmbMateria(){
		mostrarInfoMateria(cmbMateria.getValue().toString());
	}
	
	public void onOK$cmbSemestre(){
		cmbMicrocurriculo.setDisabled(false);
		String codigo = cmbMateria.getValue().toString()+"-"+cmbSemestre.getValue().toString();
		cargarMicroxMateriaxSemestre(codigo);
	}
	
	
	public void onSelect$cmbUnidadAcademica(){
		cmbDependencia.setDisabled(false);
		lblNombreUnidadAcademica.setValue(mostrarUnidadAcademica(cmbUnidadAcademica.getValue()));
		cargarDependenciaPorUnidadAcademica(cmbUnidadAcademica.getValue());
	}
	
	public void onSelect$cmbDependencia(){
		cmbNucleo.setDisabled(false);
		lblNombreDependencia.setValue(mostrarDependencia(cmbDependencia.getValue()));
		cargarNucleosPorDependencia(cmbDependencia.getValue());
	}
	
	public void onSelect$cmbNucleo(){
		cmbMateria.setDisabled(false);
		mostrarNucleo(cmbNucleo.getValue().toString());
		cargarMateriasPorNucleo(cmbNucleo.getValue());
	}
	
	public void onSelect$cmbMateria(){
		cmbSemestre.setDisabled(false);
		mostrarInfoMateria(cmbMateria.getValue().toString());
	}
	
	public void onSelect$cmbSemestre(){
		cmbMicrocurriculo.setDisabled(false);
		String codigo = cmbMateria.getValue().toString()+"-"+cmbSemestre.getValue().toString();
		cargarMicroxMateriaxSemestre(codigo);	}
	
	
//	public void onSelect$cmbEstado(){
//		lblNombreEstado.setValue(mostrarEstado(Integer.parseInt(cmbEstado.getValue().toString()))); 
//	}
	
	
	
	
	
	//***********************************************************************************************
	private String mostrarUnidadAcademica(String idUnidad){
		String nombre = "";
		TbAdmUnidadAcademica unidadAcademica = null;
		
		try{
			unidadAcademica = unidadAcademicaNGC.obtenerUnidadAcademica(idUnidad);
		}catch(ExcepcionesLogica e){
			logger.error(e);
		}
		
		if (unidadAcademica != null)
			nombre = unidadAcademica.getVrNombre();
		return nombre;
	}
	
	private String mostrarDependencia(String idDependencia){
		String nombre = "";
		TbAdmDependencia dependencia = null;
		
		try {
			dependencia = dependenciaNGC.obtenerDependencia(idDependencia);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		
		if (dependencia != null)
			nombre = dependencia.getVrNombre();
		
		return nombre;
	}
	
	private void mostrarNucleo(String idNucleo){
		TbAdmNucleo nucleo;
		try {
			nucleo = nucleoNGC.obtenerNucleo(idNucleo);
			lblNombreNucleo.setValue(nucleo.getVrNombre());
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		cmbMateria.getItems().clear();
		cargarMaterias(idNucleo);
	}
	
	private void mostrarInfoMateria(String idMateria){
		try {
			TbAdmMateria materia = materiaNGC.obtenerMateria(idMateria);
			if (materia != null ){
				lblNombreMateria.setValue(materia.getVrNombre());
				lblCreditosMateria.setValue(Integer.toString(materia.getNbCreditos()));
				lblHtMateria.setValue(Integer.toString(materia.getNbHt()));
				lblHpMateria.setValue(Integer.toString(materia.getNbHp()));
				lblHtpMateria.setValue(Integer.toString(materia.getNbHtp()));
				Integer horaClaseSemestral = (materia.getNbHt()+materia.getNbHp()+materia.getNbHtp())*16;
				lblHoraClaseSemestral.setValue(Integer.toString(horaClaseSemestral));
				if (materia.getBlValidable() == 1)
					ckbValidable.setChecked(true);
				else
					ckbValidable.setChecked(false);
				
				if (materia.getBlHabilitable() == 1)
					ckbHabilitable.setChecked(true);
				else
					ckbHabilitable.setChecked(false);
				
				if (materia.getBlClasificable() == 1)
					ckbClasificable.setChecked(true);
				else
					ckbClasificable.setChecked(false);	
			} else 
				Messagebox.show("El Registro esta vacio.");
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	private String mostrarEstado(int idEstado){
		String nombreEstado = "";
		try {
			TbMicEstado estado = estadoNGC.obtenerEstados(idEstado);
			nombreEstado = estado.getVrDescripcion();
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		return nombreEstado;
	}
	
	
	//*************************************************************************************************
	
	
	
	private void inhabilitarControles(){
//		cmbUnidadAcademica.setDisabled(true);;
		cmbDependencia.setDisabled(true);
		cmbNucleo.setDisabled(true);
		cmbMateria.setDisabled(true);
		cmbSemestre.setDisabled(true);
		cmbMicrocurriculo.setDisabled(true);
		cmbEstado.setDisabled(true);
		cmbDocente.setDisabled(true);
		ckbValidable.setDisabled(true);
		ckbHabilitable.setDisabled(true);
		ckbClasificable.setDisabled(true);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
//		System.out.println("Quien me llamó : "+comp.getParent().getId());
		if (comp.getParent().getId().equals("formaCrearMicro")){
			inicializarFormaCrear();
			
		} else if (comp.getParent().getId().equals("formaListarMicro")){
			inicializarFormaListado();
			cargarMaterias(cmbNucleo.getValue());
			
		} else if (comp.getParent().getId().equals("consultarMicro")){
			cargarEstados();
			cargarMicrocurriculos();
			inhabilitarControles();
		}
		cargarUnidades();
		cargarDependencias();
		cargarNucleos();
		cargarSemestres();
		cargarDocentes();	}
}
