package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import oracle.sql.DATE;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.sun.mail.handlers.message_rfc822;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.ngc.BibliografiaNGC;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.EstadosNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionesNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxmicroNGC;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculosNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivosNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivosxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemasNGC;
import com.udea.proint1.microcurriculo.ngc.TemasNGC;
import com.udea.proint1.microcurriculo.ngc.TemasxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadesNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadesxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * Este Controlador se encarga de Realizar las validaciones de los datos antes de guardarlos
 * 
 * @author eacosta
 *
 */
public class ValidarDatosCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	
	private static String modUsuario = "USER";
	
	private static Date modFecha = new Date();
	
	//Declaracion de Variables globales requeridas.  Las listas se llenan de forma secundaria mediante un metodo primario.
	//Por Ejemplo: listadoUnidadesxMicro se llenar cuando se estan empaquetando las Unidades, a este metodo solo se le pasa un objeto de tipo
	//Microcurriculo.
	
	private static List<TbMicUnidadesxmicro> listadoUnidadesxMicro;
	private static List<TbMicTemasxunidad> listadoTemasxUnidad;
	private static List<TbMicEvaluacionxmicro> listadoEvaluacionesxMicro;
	private static List<TbMicObjetivosxmicro> listadoObjetivosxMicro;
	private static List<TbMicBiblioxunidad> listadoBibliografiaxUnidad;
	
	
	Button btnGuardarMicro;
	
	Combobox cmbIdSemestre;
	Combobox cmbIdNucleo;
	Combobox cmbIdDocente;
	Combobox cmbIdMateria;
	Combobox cmbIdUnidad;
	Combobox cmbListaUnidades;
	Combobox cmbReferenciaBiblio;
	Combobox cmbEstadoActual;
	
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
	
	Label lblidMicrocurriculo;
	
	//Objetos de Tipo NGC que se requieren para las validaciones.
	MateriasNGC materiasNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	ObjetivosNGC objetivosNGC;
	ObjetivosxMicroNGC objetivosxMicroNGC;
	UnidadesNGC unidadesNGC;
	
	EstadosNGC estadosNGC;
	TemasNGC temasNGC;
	TemasxUnidadNGC temasxUnidadNGC;
	EvaluacionesNGC evaluacionesNGC;
	EvaluacionxmicroNGC evaluacionesxMicroNGC;
	UnidadesxMicroNGC unidadesxMicroNGC;
	SubtemasNGC subtemasNGC;
	BibliografiaNGC bibliografiaNGC;
	BiblioxunidadNGC biblioxUnidadNGC;
	MicrocurriculosNGC microcurriculoNGC;
	
	/*
	 * Definición de Metodos Setter de Objetos de Negocio.
	 */

	
	public void setMateriasNGC(MateriasNGC materiasNGC) {
		this.materiasNGC = materiasNGC;
	}

	public void setMicrocurriculoNGC(MicrocurriculosNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
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
	
	public void setObjetivosxMicroNGC(ObjetivosxMicroNGC objetivosxMicroNGC) {
		this.objetivosxMicroNGC = objetivosxMicroNGC;
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
	
	public void setEvaluacionesxMicroNGC(EvaluacionxmicroNGC evaluacionesxMicroNGC) {
		this.evaluacionesxMicroNGC = evaluacionesxMicroNGC;
	}	

	public void setUnidadesxMicroNGC(UnidadesxMicroNGC unidadesxMicroNGC) {
		this.unidadesxMicroNGC = unidadesxMicroNGC;
	}

	public void setSubtemasNGC(SubtemasNGC subtemasNGC) {
		this.subtemasNGC = subtemasNGC;
	}

	public void setBibliografiaNGC(BibliografiaNGC bibliografiaNGC) {
		this.bibliografiaNGC = bibliografiaNGC;
	}

	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
		this.biblioxUnidadNGC = biblioxUnidadNGC;
	}

	/**
	 * Evento onClick del Boton Guardar Microcurriculo
	 * 
	 * Aqui se inicia el proceso de la validacion de los Datos
	 * 
	 * @param event
	 */
	@SuppressWarnings("unused")
	public void onClick$btnGuardarMicro(Event event){		
		//Aqui se va a empaquetar todo.
		TbMicMicrocurriculos microcurriculo = empaquetarMicrocurriculo();
		TbMicMicroxestado microxEstado = null;
		List<TbMicUnidades> listaUnidades = empaquetarUnidades(microcurriculo);
		List<TbMicObjetivos> listaObjetivos = empaquetarObjetivos(microcurriculo);
		List<TbMicEvaluaciones> listaEvaluaciones = empaquetarEvaluaciones(microcurriculo);
		List<TbMicTemas> listaTemas = empaquetarTemas(listaUnidades);
		List<TbMicSubtemas> listaSubtemas = empaquetarSubtemas(listaTemas);
		List<TbMicBibliografia> listaBibliografia = empaquetarBibliografias(listaUnidades);
				
		if( !(existeMicrocurriculo(microcurriculo.getVrIdmicrocurriculo()))){
			if (verificarCampos() == 1){
				Messagebox.show("Registro guardado satisfactoriamente. \n Puede cambiar el Estado del Microcurriculo cuando lo desee.","Información",Messagebox.OK, Messagebox.EXCLAMATION);
			} else if (verificarCampos() == 0){
				Messagebox.show("El registro de Microcurriculos se guardará con la información mínima necesaria. \n El estado de este será <BORRADOR> y no podrá ser cambiado hasta que complete toda la información.","Información",Messagebox.OK, Messagebox.EXCLAMATION);
				
			} else
				Messagebox.show("El formulario no cumple con la información minina necesaria para crear un Microcurriculo. \n Por favor verifique los campos e intentelo nuevamente.","ERROR",Messagebox.OK,Messagebox.ERROR);
		} else {
			Messagebox.show("El Microcurriculo que desea crear coincide con un Registro en la Base de Datos. \n Por favor verifique la información ingresada.","Advertencia",Messagebox.OK,Messagebox.INFORMATION);
		}
		
		
		
		
		//
		/*
		List<TbMicTemas> listaTemas = empaquetarTemas(listaUnidades);
		*/
		
		//TbMicUnidades prueba = obtenerUnidad(lista, nombre)
		
		//TbMicMicroxsemestre microxSemestre = empaquetarMicroPorSemestre(microcurriculo, estado);
		//List<TbMicTemas> listaTemas = empaquetarListaTemas();
		//List<TbMicTemasxunidad> listaTemasxUnidad = empaquetarTemasxUnidad();
				
		//Se debe establecer el orden en el que se iran guardando los registros.

		//Primero.  Guardar el Microcurriculo.
		/*if (verificarCampos()== 1){
			Messagebox.show("Registro Guardado Satisfactoriamente.  Puede Cambiar su estado cuando lo desee.");
			cmbEstadoActual.setDisabled(false);
		} else {
			if (verificarCampos() == 0){
				Messagebox.show("Se guardará el registro de Microcurriculos con la información Mínima requerida. \n"+"El estado del Microcurriculo es <EN BORRADOR>");
				cmbEstadoActual.setDisabled(true);
			}else{
				Messagebox.show("No se puede Guardar el registro Microcurriculo porque no cumple con la información mínima requerida.");
				cmbEstadoActual.setDisabled(true);
			}
			
		}*/		
	}
	
	public int verificarCampos(){
		int estado = -1;
		if (comprobarInformacionGeneral()){
			System.out.println("Informacion general.  Validada");
			if (comprobarInformacionComplementaria()){
				System.out.println("Informacion complementaria.  Validada");
				if (comprobarUnidadesDetalladas()){
					System.out.println("Informacion de unidades.  Validada");
					if (comprobarEvaluaciones()){
						System.out.println("Informacion evaluaciones.  Validada");
						if (comprobarReferencias()){
							System.out.println("Informacion referencias.  Validada");
							estado = 1;							
						} 
					} 
				}
				estado = 0;
			} 
		}
		return estado;
	}
	
	private boolean existeMicrocurriculo(String idMicrocurriculo){
		TbMicMicrocurriculos micro = null;
		boolean estado = false;
		
		try {
			micro = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error("Se ha producido un Error al intenar obtener un Registro desde la tabla Microcurriculos.");
		}
		
		if (micro == null)
			estado = true;
		else
			estado = false;		
		return estado;
		
	}
	
		
	private List<TbMicEvaluaciones> empaquetarEvaluaciones(TbMicMicrocurriculos microcurriculo){
		List<TbMicEvaluaciones> lista = null;
		TbMicEvaluaciones evaluacion = null;
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		
		int registros = 0;
				
		try {
			registros = evaluacionesNGC.contarRegistros();
			lista = new ArrayList<TbMicEvaluaciones>();
			listadoEvaluacionesxMicro = new ArrayList<TbMicEvaluacionxmicro>();
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al intentar obtener el numero de registros de la tabla Evaluaciones.");
			System.out.println("Se presentaron Errores al intentar obtener el numero de registros de la tabla Evaluaciones.");
		}
		
		for(int i=0;i<listaEvaluaciones.getItemCount();i++){
			int contador = registros + i + 1; 
			Listitem listaitem = (Listitem)listaEvaluaciones.getChildren().get(i+1);
			Listcell celdaEvaluacion = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaPorcentaje = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaFecha = (Listcell)listaitem.getChildren().get(2);
			System.out.println(celdaEvaluacion.getLabel()+" "+celdaPorcentaje.getLabel()+" "+celdaFecha.getLabel());
			Date fechaEstimada = new Date(celdaFecha.getLabel());
			evaluacion = new TbMicEvaluaciones(contador, celdaEvaluacion.getLabel(), modUsuario, modFecha);
			evaluacionxMicro = new TbMicEvaluacionxmicro(contador, evaluacion, microcurriculo, Integer.parseInt(celdaPorcentaje.getLabel()), fechaEstimada, modUsuario, modFecha);
			lista.add(evaluacion);
			listadoEvaluacionesxMicro.add(evaluacionxMicro);
		}
		return lista;
	}
	
	
	private List<TbMicTemas> empaquetarTemas(List<TbMicUnidades> listadoUnidades){
		List<TbMicTemas> lista = null;		
		TbMicTemas tema = null;
		TbMicTemasxunidad temaxUnidad = null;
		TbMicUnidades unidad = null;
		int registro = 0;
		
		try {
			registro = temasNGC.contarRegistros();
			lista = new ArrayList<TbMicTemas>();
			listadoTemasxUnidad = new ArrayList<TbMicTemasxunidad>();			
		} catch (ExcepcionesLogica e) {
			logger.error("Error al intentar contar los Registros de la Tabla Temas.");
		}
				
		for (int i=0;i<listaTemas.getItemCount(); i++){
			Listitem listaitem = (Listitem)listaTemas.getChildren().get(i+1);
			Listcell celdaUnidad = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaTema = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaSemanas = (Listcell)listaitem.getChildren().get(2);
			unidad = obtenerUnidad(listadoUnidades, celdaUnidad.getLabel());
			String descripcion = celdaTema.getLabel();
			int contador = registro + i + 1;
			tema = new TbMicTemas(contador, descripcion, modUsuario, modFecha);
			temaxUnidad = new TbMicTemasxunidad(contador, unidad, tema, Integer.parseInt(celdaSemanas.getLabel()), modUsuario, modFecha);
						
			lista.add(tema);
			listadoTemasxUnidad.add(temaxUnidad);
		}
		return lista;
	}
	
	
	
	private List<TbMicSubtemas> empaquetarSubtemas(List<TbMicTemas> listadoTemas){
		List<TbMicSubtemas> lista = null;
		TbMicSubtemas subtema = null;
		TbMicTemas tema = null;
		
		int registro = 0;
		int contador = 0;
		
		try {
			registro = subtemasNGC.contarRegistros();
			lista = new ArrayList<TbMicSubtemas>();
		} catch (ExcepcionesLogica e) {
			logger.error("Error al momento de obtener el numero de Registros.");
		}
		
		for(int i=0; i<listaSubtemas.getItemCount(); i++){
			Listitem listaitem = (Listitem)listaSubtemas.getChildren().get(i+1);
			Listcell celdaTemas = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaSubtema = (Listcell)listaitem.getChildren().get(2);
			contador = registro + i + 1;
			String nombre = celdaTemas.getLabel().toString();
			tema = obtenerTema(listadoTemas, nombre);
			subtema = new TbMicSubtemas(contador, tema, celdaSubtema.getLabel().toString(), modUsuario, modFecha);
			lista.add(subtema);
		}
		return lista;
	}
	
	private List<TbMicBibliografia> empaquetarBibliografias(List<TbMicUnidades> listaUnidades){
		List<TbMicBibliografia> lista = null;
		TbMicBibliografia bibliografia = null;
		TbMicBiblioxunidad biblioxUnidad = null;
		int registro = 0;
		int registro2 = 0;
		int contador = 0;
		char tipoBibliografia;
		
		try {
			registro = bibliografiaNGC.contarRegistros();
			registro2 = biblioxUnidadNGC.contarRegistros();
			lista = new ArrayList<TbMicBibliografia>();
			listadoBibliografiaxUnidad = new ArrayList<TbMicBiblioxunidad>();
			
		} catch (ExcepcionesLogica e) {			
			logger.error("Error al intentar recuperar el numero de Registros de la Tabla Bibliobrafia x Unidad.");
		}
		
		
		for(int i=0; i<listaBibliografia.getItemCount(); i++){
			contador = registro + i + 1;
			Listitem listaitem = (Listitem)listaBibliografia.getChildren().get(i+1);
			Listcell celdaUnidad = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaReferencia = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaAutor = (Listcell)listaitem.getChildren().get(2);
			Listcell celdaISBN = (Listcell)listaitem.getChildren().get(3);
			Listcell celdaPais = (Listcell)listaitem.getChildren().get(4);
			Listcell celdaTipo = (Listcell)listaitem.getChildren().get(5);
			if (celdaTipo.getLabel().toUpperCase() == "BASICA"){
				tipoBibliografia = '1';
			}else 
				tipoBibliografia = '0';
			bibliografia = new TbMicBibliografia(contador, celdaReferencia.getLabel().toString(), "", 
					celdaISBN.getLabel().toString().toUpperCase(), tipoBibliografia, modUsuario, modFecha);
			TbMicUnidades unidad = obtenerUnidad(listaUnidades, celdaUnidad.getLabel().toString().toUpperCase());
			biblioxUnidad = new TbMicBiblioxunidad(contador, bibliografia, unidad, modUsuario, modFecha);
			
			lista.add(bibliografia);
			listadoBibliografiaxUnidad.add(biblioxUnidad);
		}
		registro = contador;
		
		for(int i=0; i<listaCibergrafia.getItemCount();i++){
			contador = registro + i + 1;
			Listitem listaItem = (Listitem)listaCibergrafia.getChildren().get(i+1);
			Listcell celdaUnidad = (Listcell)listaItem.getChildren().get(0);
			Listcell celdaReferencia = (Listcell)listaItem.getChildren().get(1);
			Listcell celdaSitio = (Listcell)listaItem.getChildren().get(2);
			Listcell celdaTipo = (Listcell)listaItem.getChildren().get(3);
			if (celdaTipo.getLabel().toUpperCase() == "BASICA"){
				tipoBibliografia = '1';
			}else 
				tipoBibliografia = '0';
			TbMicUnidades unidad = obtenerUnidad(listaUnidades, celdaUnidad.getLabel().toString().toUpperCase());
			bibliografia = new TbMicBibliografia(contador, celdaReferencia.getLabel().toString(), 
					celdaSitio.getLabel().toString(), null, tipoBibliografia, modUsuario, modFecha);
			biblioxUnidad = new TbMicBiblioxunidad(contador, bibliografia, unidad, modUsuario, modFecha);
			lista.add(bibliografia);
			listadoBibliografiaxUnidad.add(biblioxUnidad);			
		}	
		return lista;
	}
	
	/**
	 * 
	 * @param lista
	 * @param nombre
	 * @return
	 */
	private TbMicUnidades obtenerUnidad(List<TbMicUnidades> lista, String nombre){
		TbMicUnidades unidad = null;
		Iterator<TbMicUnidades> iterator = lista.iterator();
		while (iterator.hasNext() && (unidad == null)){			
			if(nombre.equals(iterator.next().getVrNombre()) ){				
				unidad = iterator.next();
			}
		}		
		return unidad;
	}
	
	
	private TbMicTemas obtenerTema(List<TbMicTemas> lista, String nombre){
		TbMicTemas tema = null;
		Iterator<TbMicTemas> iterator = lista.iterator();
		while (iterator.hasNext() && (tema == null)){
			if (iterator.next().toString().trim().toUpperCase() == nombre.trim().toUpperCase()){
				tema = iterator.next();
			}
			
		}
		
		return tema;
	}
	
	
	@SuppressWarnings("null")
	private List<TbMicUnidades> empaquetarUnidades(TbMicMicrocurriculos microcurriculo){
		List<TbMicUnidades> lista = new ArrayList<TbMicUnidades>();
				
		TbMicUnidades unidad = null;
		TbMicUnidadesxmicro unidadxMicro = null;
		
		listadoUnidadesxMicro = new ArrayList<TbMicUnidadesxmicro>();
		int contador = 0;
		int registro = 0;
		String nombreUnidad = "";
		
		logger.info("Empaquetando Lista Unidades");
		
		try {
			registro = unidadesNGC.numeroRegistros();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		for(int i=0; i < listaUnidades.getItemCount(); i++){
			contador = 	registro + i + 1;	
			nombreUnidad = listaUnidades.getItems().get(i).getLabel();
			unidad = new TbMicUnidades(contador, nombreUnidad, modUsuario, modFecha);
			unidadxMicro = new TbMicUnidadesxmicro(contador, unidad, microcurriculo, modUsuario, modFecha);
			
			lista.add(unidad);
			listadoUnidadesxMicro.add(unidadxMicro);
		}
		logger.info("Se adicionaron Elementos a la Lista." + lista.size());
		return lista;
	}
	
	/**
	 * Este metodo se encarga de tomar la información de la ListaObjetivosEspecificos y empaquetar ListaObjetivos y ListadoObjetivosxMicrocurriculo.
	 * @param microcurriculo
	 * @return Lista con objetos de Tipo Objetivos
	 */
	@SuppressWarnings("null")
	private List<TbMicObjetivos> empaquetarObjetivos(TbMicMicrocurriculos microcurriculo){
		List<TbMicObjetivos> listaObjetivos = null;
		TbMicObjetivos objetivo = null;
		TbMicObjetivosxmicro objetivosxMicro = null;
		
		
		int registro = 0;
		int contador = 0;
		String celdaObjetivo = "";
		
		try {
			registro = objetivosNGC.numeroRegistros()+1;
			listaObjetivos = new ArrayList<TbMicObjetivos>();
			listadoObjetivosxMicro = new ArrayList<TbMicObjetivosxmicro>();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		if((txtObjetivoGeneral.getValue().trim().length() > 0) && (txtObjetivoGeneral != null)){
			objetivo = new TbMicObjetivos(registro+1, txtObjetivoGeneral.getValue(), '1', modUsuario, modFecha);
			listaObjetivos.add(objetivo);
			objetivosxMicro = new TbMicObjetivosxmicro(contador+1,objetivo,microcurriculo,modUsuario,modFecha);
			listadoObjetivosxMicro.add(objetivosxMicro);
			for (int i=0; i<listaObjetivosEspecificos.getItemCount(); i++){
				contador = registro + i + 2;
				celdaObjetivo = listaObjetivosEspecificos.getItems().get(i).getLabel();
				objetivo = new TbMicObjetivos(contador, celdaObjetivo, '0', modUsuario, modFecha);
				objetivosxMicro = new TbMicObjetivosxmicro(contador,objetivo,microcurriculo,modUsuario,modFecha);
				listaObjetivos.add(objetivo);
				listadoObjetivosxMicro.add(objetivosxMicro);
			}
			logger.info("Elementos Adicionados en la Lista Objetivos : "+listaObjetivos.size());
		} else {
			Messagebox.show("Sin Información en el Campo Objetivo General.");
			txtObjetivoGeneral.setFocus(true);
		}		
		return listaObjetivos;
	}
	
	
	/*
	 * Este método se encarga de empaquetar la información y devolver un Objeto de tipo Microcurriculo
	 *  
	 * @return Objeto de Tipo Microcurriculo.
	 */
	private TbMicMicrocurriculos empaquetarMicrocurriculo(){
		TbMicMicrocurriculos microcurriculo = null;;
		String codigoMicrocurriculo = "";
		TbAdmMaterias materia = null;
		TbAdmSemestre semestre = null;
		TbAdmPersona responsable = null;		
		
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
						microcurriculo = new TbMicMicrocurriculos(codigoMicrocurriculo, materia, txtPropositoMicro.toString(), 
								txtJustificacionMicro.toString(), txtResumenMicro.toString(), responsable, modUsuario, modFecha);
						lblidMicrocurriculo.setValue(codigoMicrocurriculo.toString());
						cmbEstadoActual.setValue(obtenerEstado());
					}
				}
			}
		} else
			Messagebox.show("No se pudo crear el objeto Microcurriculo");
		return microcurriculo;
	}
	
	
	
	/*
	 * Obtiene la Descripcion de un estado que se asignará al Microcurriculo.
	 */
	private String obtenerEstado(){
		String estado = "";
		try {
			estado = estadosNGC.obtenerEstados(1).getVrDescripcion();
		} catch (ExcepcionesLogica e) {
			logger.info("El Registro Solicitado no fue Hallado en la Base de Datos.");
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
