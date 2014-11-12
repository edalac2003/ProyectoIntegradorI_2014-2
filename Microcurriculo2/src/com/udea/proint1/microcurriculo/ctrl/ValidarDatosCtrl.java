package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.sql.DATE;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.sun.mail.handlers.message_rfc822;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.EstadosNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionesNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxmicroNGC;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivosNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.TemasNGC;
import com.udea.proint1.microcurriculo.ngc.TemasxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * Este Controlador se encarga de Realizar las validaciones de los datos antes de guardarlos
 * 
 * @author eacosta
 *
 */
public class ValidarDatosCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	
	Button btnGuardarMicro;
	
	Combobox cmbIdSemestre;
	Combobox cmbIdNucleo;
	Combobox cmbIdDocente;
	Combobox cmbIdMateria;
	Combobox cmbIdUnidad;
	Combobox cmbListaUnidades;
	Combobox cmbReferenciaBiblio;
	
	Textbox txtPropositoMicro;
	Textbox txtJustificacionMicro;
	Textbox txtObjetivoGeneral;
	Textbox txtObjetivoEspecifico;
	Textbox txtResumenMicro;
	Textbox txtNombreUnidad;
	Textbox txtActividadMicro;
	Textbox txtNombreSitioCiber;
	
	Listbox listaObjetivosEspecificos;
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;	
	Listbox listaCibergrafia;
	
	//Objetos de Tipo NGC que se requieren para las validaciones.
	MateriasNGC materiasNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	ObjetivosNGC objetivosNGC;
	UnidadesNGC unidadesNGC;
	
	EstadosNGC estadosNGC;
	TemasNGC temasNGC;
	TemasxUnidadNGC temasxUnidadNGC;
	EvaluacionesNGC evaluacionesNGC;
	EvaluacionxmicroNGC evaluacionxMicro;
	
	
	/*
	 * Definición de Metodos Setter de Objetos de Negocio.
	 */

	public void setMateriasNGC(MateriasNGC materiasNGC) {
		this.materiasNGC = materiasNGC;
	}

	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	public void setObjetivosNGC(ObjetivosNGC objetivosNGC) {
		this.objetivosNGC = objetivosNGC;
	}
	
	public void setUnidadesNGC(UnidadesNGC unidadesNGC) {
		this.unidadesNGC = unidadesNGC;
	}
	
	public void setEstadosNGC(EstadosNGC estadosNGC) {
		this.estadosNGC = estadosNGC;
	}
	
	public void setTemasNGC(TemasNGC temasNGC) {
		this.temasNGC = temasNGC;
	}

	public void setTemasxUnidadNGC(TemasxUnidadNGC temasxUnidadNGC) {
		this.temasxUnidadNGC = temasxUnidadNGC;
	}
	
	public void setEvaluacionesNGC(EvaluacionesNGC evaluacionesNGC) {
		this.evaluacionesNGC = evaluacionesNGC;
	}
	
	public void setEvaluacionxMicro(EvaluacionxmicroNGC evaluacionxMicro) {
		this.evaluacionxMicro = evaluacionxMicro;
	}

	/**
	 * Evento onClick del Boton Guardar Microcurriculo
	 * 
	 * Aqui se inicia el proceso de la validacion de los Datos
	 * 
	 * @param event
	 */
	public void onClick$btnGuardarMicro(Event event){		
		//Aqui se va a empaquetar todo.
		TbMicMicrocurriculos microcurriculo = empaquetarMicrocurriculo();
		//List<TbMicUnidades> listaUnidades = empaquetarUnidades();
		
		List<TbMicEvaluaciones> listaEvaluaciones = empaquetarEvaluaciones(microcurriculo);
		
		
		//List<TbMicObjetivos> listaObjetivos = empaquetarObjetivos();
		
		//TbMicMicroxsemestre microxSemestre = empaquetarMicroPorSemestre(microcurriculo, estado);
		//List<TbMicTemas> listaTemas = empaquetarListaTemas();
		//List<TbMicTemasxunidad> listaTemasxUnidad = empaquetarTemasxUnidad();
		
		
		//Se debe establecer el orden en el que se iran guardando los registros.
		//Primero.  Guardar el Microcurriculo.
		/*if (verificarCampos()== 1){
			Messagebox.show("Registro Guardado Satisfactoriamente.  Puede Cambiar su estado cuando lo desee.");
		} else {
			if (verificarCampos() == 0){
				Messagebox.show("Se guardará el registro de Microcurriculos con la información Mínima requerida. \n"+"El estado del Microcurriculo es <EN BORRADOR>");
			}else
				Messagebox.show("No se puede Guardar el registro Microcurriculo porque no cumple con la información mínima requerida.");
		}*/
		
		
	}
	
	public int verificarCampos(){
		int estado = -1;
		if (comprobarInformacionGeneral()){
			if (comprobarInformacionComplementaria()){
				if (comprobarUnidadesDetalladas()){
					if (comprobarEvaluaciones()){
						if (comprobarReferencias()){
							estado = 1;
						} 
					} 
				}
				estado = 0;
			} 
		}
		return estado;
	}
	
	/*List<TbMicTemas> temas
	List<TbMicTemasxunidad> temasxunidad,
	List<TbMicAutores> autores,
	List<TbMicSubtemas> subtemas,
	List<TbMicUnidades> unidades (id, nombre, modusuario, modfecha)
	List<TbMicUnidadesxmicro> unidadesxmicro,
	List<TbMicBiblioxunidad> biblioxunidad,
	List<TbMicAutorxbiblio> autorxbiblio,
	List<TbMicObjetivos> objetivos (Id, descripcion, tipo, modusuario, modfecha)
	List<TbMicObjetivosxmicro> objetivosxmicro,
	List<TbMicBibliografia> bibliografia,
	TbMicMicrocurriculos microcurriculo(ID, materia, resumen, metodologia, semestre, responsable, modusuario, modfecha)
	TbMicMicroxestado microxEstado (Id, microcurriculo, estado, modusuario, modfecha)
	TbMicMicroxsemestre microxSemestre (id, microcurriculo, semestre, modusuario, modfecha)
	*/
	
	/*private List<TbMicTemasxunidad> empaquetarTemasxUnidad(){
		List<TbMicTemasxunidad> lista = new ArrayList<TbMicTemasxunidad>();
		TbMicTemasxunidad temaxUnidad = null;
		TbMicTemas tema = null;
		TbMicUnidades unidad = null;
		int registro = 0;
		
		try {
			registro = temasxUnidadNGC.contarRegistros();
		} catch (ExcepcionesLogica e) {
			System.out.println("No es posible obtener el numero de Registros de la Tabla TemasxUnidad.");
		}
		
		for (int i = 0; i<listaSubtemas.getItemCount();i++){
			int contador = registro + i + 1;
			Listitem listaitem = (Listitem)listaSubtemas.getChildren().get(i);
			Listcell celdaUnidades = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaTemas = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaSemanas = (Listcell)listaitem.getChildren().get(2);
			tema = temasNGC.
			temaxUnidad = new TbMicTemasxunidad();
			
		}
		
		return lista;
	}*/
	
	private List<TbMicEvaluaciones> empaquetarEvaluaciones(TbMicMicrocurriculos microcurriculo){
		List<TbMicEvaluaciones> lista = new ArrayList<TbMicEvaluaciones>();
		List<TbMicEvaluacionxmicro> lista2 = new ArrayList<TbMicEvaluacionxmicro>();
		TbMicEvaluaciones evaluacion = null;
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		int registros = 0;
		Date fecha = new Date();
		
		try {
			registros = evaluacionesNGC.contarRegistros();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<listaEvaluaciones.getItemCount();i++){
			int contador = registros + i + 1; 
			Listitem listaitem = (Listitem)listaEvaluaciones.getChildren().get(i+1);
			Listcell celdaEvaluacion = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaPorcentaje = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaFecha = (Listcell)listaitem.getChildren().get(2);
			Date fechaEstimada = new Date(celdaFecha.getLabel());
			evaluacion = new TbMicEvaluaciones(contador, celdaEvaluacion.getLabel(), "USER", fecha);
			evaluacionxMicro = new TbMicEvaluacionxmicro(contador, evaluacion, microcurriculo, Integer.parseInt(celdaPorcentaje.getLabel()), fechaEstimada, "USER", fecha);
			lista.add(evaluacion);
			lista2.add(evaluacionxMicro);
		}
		return lista;
	}
	
	private List<TbMicTemas> empaquetarTemas(){
		List<TbMicTemas> lista = new ArrayList<TbMicTemas>();
		Date fecha = new Date();
		
		int registro = 0;
		
		try {
			registro = temasNGC.contarRegistros();
		} catch (ExcepcionesLogica e) {
			System.out.println("Ctrl : Problemas para obtener el numero de registros de Temas.");
			//logger.error("Error al intentar contar los Registros de la Tabla Temas.");
		}
				
		for (int i=0;i<listaTemas.getItemCount(); i++){
			Listitem listaitem = (Listitem)listaTemas.getChildren().get(i+1);
			Listcell celdas = (Listcell)listaitem.getChildren().get(1);
			int contador = registro + i + 1;
			TbMicTemas tema = new TbMicTemas(contador, celdas.getLabel(), "USER", fecha);
			lista.add(tema);			
		}
		Messagebox.show("Registros almacenados en la lista : " + lista.size());
		
		return lista;
	}
	
	@SuppressWarnings("null")
	private List<TbMicUnidades> empaquetarUnidades(){
		List<TbMicUnidades> lista = new ArrayList<TbMicUnidades>();
		TbMicUnidades unidad = null;
		int registro = 0;
		int numRegistro = 0;
		Date fecha = new Date();
		String nombreUnidad = "";
		String modUsuario = "USER";
		logger.info("Empaquetando Lista Unidades");
		try {
			numRegistro = unidadesNGC.numeroRegistros();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		for(int i=0; i < listaUnidades.getItemCount(); i++){
			registro = 	numRegistro + i + 1;	
			nombreUnidad = listaUnidades.getItems().get(i).getLabel();
			unidad = new TbMicUnidades(registro, nombreUnidad, modUsuario, fecha);
			lista.add(unidad);			
		}
		logger.info("Se adicionaron Elementos a la Lista." + lista.size());
		return lista;
	}
	
	
	@SuppressWarnings("null")
	private List<TbMicObjetivos> empaquetarObjetivos(){
		List<TbMicObjetivos> listaObjetivos = new ArrayList<TbMicObjetivos>();
		TbMicObjetivos objetivo = null;
		Date fecha = new Date();
		int registrosObjetivo = 0;
		int registro = 0;
		String celdaObjetivo = "";
		
		try {
			registrosObjetivo = objetivosNGC.numeroRegistros()+1;
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		if((txtObjetivoGeneral.getValue().trim().length() > 0) && (txtObjetivoGeneral != null)){
			objetivo = new TbMicObjetivos(registrosObjetivo, txtObjetivoGeneral.getValue(), '1', "USER", fecha);
			listaObjetivos.add(objetivo);
			for (int i=0; i<listaObjetivosEspecificos.getItemCount(); i++){
				registro = registrosObjetivo + i + 1;
				celdaObjetivo = listaObjetivosEspecificos.getItems().get(i).getLabel();
				objetivo = new TbMicObjetivos(registro, celdaObjetivo, '0', "USER", fecha);
				System.out.println(i+"  "+fecha);
				listaObjetivos.add(objetivo);
			}
			logger.info("Elementos Adicionados en la Lista Objetivos : "+listaObjetivos.size());
		} else {
			Messagebox.show("Sin Información en el Campo Objetivo General.");
			txtObjetivoGeneral.setFocus(true);
		}		
		return listaObjetivos;
	}
	
	
	
	//QUEDA PENDIENTE PORQUE NO ENCONTRE EL DAO
	//TbMicMicroxsemestre microxSemestre (id, microcurriculo, semestre, modusuario, modfecha)
	private TbMicMicroxsemestre empaquetarMicroPorSemestre(TbMicMicrocurriculos microcurriculo, TbMicEstados estado){
		TbMicMicroxsemestre registro = null;
		
			
		return registro;
	}
	
	private TbMicMicrocurriculos empaquetarMicrocurriculo(){
		TbMicMicrocurriculos microcurriculo = new TbMicMicrocurriculos();
		String codigoMicrocurriculo = "";
		TbAdmMaterias materia = null;
		TbAdmSemestre semestre = null;
		TbAdmPersona responsable = null;
		Date fecha = new Date();
		
		try {
			materia = materiasNGC.obtenerMateria(cmbIdMateria.getValue());
			semestre = semestreNGC.obtenerSemestre(cmbIdSemestre.getValue());
			responsable = personaNGC.obtenerPersona(cmbIdDocente.getValue());
			
		} catch (WrongValueException e) {
			e.printStackTrace();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		codigoMicrocurriculo = asignarIdMicrocurriculo(cmbIdSemestre.getValue().toString(), cmbIdMateria.getValue().toString());
		if ( codigoMicrocurriculo != null){
			if (materia != null){
				if (semestre != null){
					if (responsable != null){
						microcurriculo = new TbMicMicrocurriculos(codigoMicrocurriculo, materia, txtPropositoMicro.getValue(), 
								txtJustificacionMicro.getValue(), txtResumenMicro.getValue(), 0, 
								responsable.getVrIdpersona(), "USER", fecha);
						Messagebox.show("El Objeto Microcurriculo se Creó Correctamente");
					}
				}
			}
		} else
			Messagebox.show("No se pudo crear el objeto Microcurriculo");
		return microcurriculo;
	}
	
	private TbMicEstados obtenerEstado(){
		TbMicEstados estado = null;
		try {
			estado = estadosNGC.obtenerEstados(1);
		} catch (ExcepcionesLogica e) {
			logger.info("El Registro Solicitado no fue Hallado en la Base de Datos.");
		}
		if (estado != null){			
			Messagebox.show("Se Encontró Registro de Estado : "+estado.getNbIdestado()+" "+estado.getVrDescripcion());
			
		}
		return estado;
	}
	
	private String asignarIdMicrocurriculo(String idsemestre, String idmateria){
		String codigo = null;
		TbAdmSemestre semestre = null;
		TbAdmMaterias materia = null;
		
		try {
			semestre = semestreNGC.obtenerSemestre(idsemestre);
			materia = materiasNGC.obtenerMateria(idmateria);
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		if (semestre != null){
			if (materia != null){
				codigo = materia.getVrIdmateria().toUpperCase() + "-" + semestre.getVrIdsemestre().toUpperCase();	
			}else
				Messagebox.show("No es posible generar el codigo del Microcurriculo porque el valor de la Materia es Incorrecto.");					
		}else
			Messagebox.show("No es posible generar el codigo del Microcurriculo porque el valor del semestre es Incorrecto.");
		
		return codigo;
	}
	
	
	/**
	 * Este metodo verifica que los campos de la Pestaña Información General no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarInformacionGeneral(){
		Boolean estado = false;
		if (cmbIdSemestre.getValue() != null && (cmbIdSemestre.getValue().trim().length() > 0)){
			if (cmbIdNucleo.getValue() != null && (cmbIdNucleo.getValue().trim().length() > 0)){
				if ((cmbIdDocente.getValue() != null) && (cmbIdDocente.getValue().trim().length() > 0)){
					if((cmbIdMateria.getValue() != null) && (cmbIdMateria.getValue().trim().length() > 0)){
						estado = true;
					} else {
						Messagebox.show("Falta Informacion en el Campo <Id Materia>");
						cmbIdMateria.setFocus(true);
					}					
				} else {
					Messagebox.show("Falta Informacion en el Campo <Id Responsable>");
					cmbIdDocente.setFocus(true);
				}
			} else {
				Messagebox.show("Falta Informacion en el Campo <Id Nucleo>");
				cmbIdNucleo.setFocus(true);
			}
		} else {
			Messagebox.show("Falta Informacion en el Campo <Id Semestre>");
			cmbIdSemestre.setFocus(true);
		}
		
		return estado;
	}
	
	
	/**
	 * Este metodo verifica que los Componentes de la Pestaña Información Complementaria no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarInformacionComplementaria(){
		boolean estado = false;
		if ((txtPropositoMicro.getValue() != null) && (txtPropositoMicro.getValue().trim().length() > 0)){
			if ((txtJustificacionMicro.getValue() != null) && (txtJustificacionMicro.getValue().trim().length() > 0)){
				if ((txtObjetivoGeneral.getValue() != null) && (txtObjetivoGeneral.getValue().trim().length() > 0)){
					if (listaObjetivosEspecificos.getItemCount() > 0){
						if ((txtResumenMicro.getValue() != null) && (txtResumenMicro.getValue().trim().length() > 0)){
							estado = true;
						} else {
							Messagebox.show("Falta Informacion en el Campo <Contenido Resumido>");
						}
					} else {
						Messagebox.show("Falta Informacion en la lista <Objetivos Especificos>");
						txtObjetivoEspecifico.setFocus(true);
					}
				} else {
					Messagebox.show("Falta Informacion en el Campo <Objetivo General Microcurriculo>");
					txtObjetivoGeneral.setFocus(true);
				}
			} else {
				Messagebox.show("Falta Informacion en el Campo <Justificación Microcurriculo>");
				txtJustificacionMicro.setFocus(true);
			}
		} else {
			Messagebox.show("Falta Informacion en el Campo <Proposito Microcurriculo>");
			txtPropositoMicro.setFocus(true);
		}
				
		return estado;
	}
	
	/**
	 * Este metodo verifica que los Componentes de la Pestaña Unidades Detalladas no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarUnidadesDetalladas(){
		Boolean estado = false;
		if ((listaUnidades.getItemCount() > 0) && (listaUnidades != null)){
			if ((listaTemas.getItemCount() > 0) && (listaTemas != null)){
				if ((listaSubtemas.getItemCount() > 0) && (listaSubtemas != null)){
					estado = true;
				} else {
					Messagebox.show("Falta Informacion en la lista <Subtemas por Temas>");
					cmbListaUnidades.setFocus(true);
				}
			} else {
				Messagebox.show("Falta Informacion en la lista <Temas por Unidades>");
				cmbIdUnidad.setFocus(true);
			}
		} else {
			Messagebox.show("Falta Informacion en la lista <Unidades>");
			txtNombreUnidad.setFocus(true);
		}
		
		return estado;
	}
	
	/**
	 * Este metodo verifica que los componentes de la Pestaña Evaluaciones no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarEvaluaciones(){
		Boolean estado = false;
		if ((listaEvaluaciones.getItemCount() > 0) && (listaEvaluaciones != null)){
			estado = true;
		} else {
			Messagebox.show("Falta Informacion en la lista <Evaluaciones>");
			txtActividadMicro.setFocus(true);
		}
		
		return estado;
	}
	
	/**
	 * Este metodo verifica que los componentes de la Pestaña Bibliográficas no esten vacios.
	 * 
	 * @return estado.  Si es verdadero, todos los campos fueron verificados correctamente; en caso contrario es falso.
	 */
	private boolean comprobarReferencias(){
		Boolean estado = false;
		if ((listaBibliografia.getItemCount() > 0) && (listaBibliografia != null)){
			if ((listaCibergrafia.getItemCount() > 0) && (listaCibergrafia != null)){
				estado = true;
			} else {
				Messagebox.show("Falta Informacion en la lista <Referencias Cibergráficas>");
				txtNombreSitioCiber.setFocus(true);
			}
		} else {
			Messagebox.show("Falta Informacion en la lista <Referncias Bibliográficas>");
			cmbReferenciaBiblio.setFocus(true);
		}
		
		return estado;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		super.doAfterCompose(comp);		
	}

}
