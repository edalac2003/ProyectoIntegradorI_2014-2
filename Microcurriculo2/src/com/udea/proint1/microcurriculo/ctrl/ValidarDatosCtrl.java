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
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivosNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
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

	/**
	 * Evento onClick del Boton Guardar Microcurriculo
	 * 
	 * Aqui se inicia el proceso de la validacion de los Datos
	 * 
	 * @param event
	 */
	public void onClick$btnGuardarMicro(Event event){		
		List<TbMicUnidades> listaUnidades = empaquetarUnidades();
		//TbMicMicrocurriculos microcurriculo = empaquetarMicrocurriculo();
		List<TbMicObjetivos> listaObjetivos = empaquetarObjetivos();
		
		/*if (comprobarInformacionGeneral()){
			if (comprobarInformacionComplementaria()){
				if (comprobarUnidadesDetalladas()){
					if (comprobarEvaluaciones()){
						if (comprobarReferencias()){
							Messagebox.show("FELICIDADES!!!! \n TODOS LOS CAMPOS SE VERIFICARON CORRECTAMENTE.");
						} 
					} 
				} 
			} 
		} 	*/	
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
	TbMicMicroxestado microxEstado,
	TbMicMicroxsemestre microxSemestre (id, microcurriculo, semestre, modusuario, modfecha)
	*/
	
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
			System.out.println("Elemntos Adicionados : "+listaObjetivos.size());
		} else {
			Messagebox.show("Sin Información en el Campo Objetivo General.");
			txtObjetivoGeneral.setFocus(true);
		}		
		return listaObjetivos;
	}
	
	//QUEDA PENDIENTE PORQUE NO ENCONTRE EL DAO
	private TbMicMicroxsemestre empaquetarMicroPorSemestre(){
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
