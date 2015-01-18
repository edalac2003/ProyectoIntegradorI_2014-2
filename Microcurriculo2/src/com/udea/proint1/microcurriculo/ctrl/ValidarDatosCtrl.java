package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicAutor;
import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.BibliografiaNGC;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxSemestreNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * Este Controlador se encarga de Realizar las validaciones de los datos antes de guardarlos
 * 
 * @author eacosta
 *
 */
public class ValidarDatosCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	private static String modUsuario = "SYSTEM";
	private static Date modFecha = new Date();
	
	//Declaracion de Variables globales requeridas.  Las listas se llenan de forma secundaria mediante un metodo primario.
	//Por Ejemplo: listadoUnidadesxMicro se llenar cuando se estan empaquetando las Unidades, a este metodo solo se le pasa un objeto de tipo
	//Microcurriculo.
	
	private static List<TbMicUnidadxmicro> listadoUnidadesxMicro;
	private static List<TbMicTemaxunidad> listadoTemasxUnidad;
	private static List<TbMicEvaluacionxmicro> listadoEvaluacionesxMicro;
	private static List<TbMicObjetivoxmicro> listadoObjetivosxMicro;
	private static List<TbMicBiblioxunidad> listadoBibliografiaxUnidad;
	private static List<TbMicSubtemaxtema> listadoSubtemaxTema;
	
		
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
	MateriaNGC materiaNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	ObjetivoNGC objetivoNGC;
	ObjetivoxMicroNGC objetivoxMicroNGC;
	UnidadNGC unidadNGC;
	
	EstadoNGC estadoNGC;
	TemaNGC temaNGC;
	TemaxUnidadNGC temaxUnidadNGC;
	EvaluacionNGC evaluacionNGC;
	EvaluacionxMicroNGC evaluacionxMicroNGC;
	UnidadxMicroNGC unidadxMicroNGC;
	SubtemaNGC subtemaNGC;
	SubtemaxTemaNGC subtemaxTemaNGC;
	BibliografiaNGC bibliografiaNGC;
	BiblioxunidadNGC biblioxUnidadNGC;
	MicrocurriculoNGC microcurriculoNGC;
	MicroxEstadoNGC microxEstadoNGC;
	MicroxSemestreNGC microxSemestreNGC;
	GuardarMicrocurriculoNGC guardarMicrocurriculoNGC;
	
	/*
	 * Definición de Metodos Setter de Objetos de Negocio.
	 */

	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}

	public void setObjetivoNGC(ObjetivoNGC objetivoNGC) {
		this.objetivoNGC = objetivoNGC;
	}

	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
		this.objetivoxMicroNGC = objetivoxMicroNGC;
	}

	public void setUnidadNGC(UnidadNGC unidadNGC) {
		this.unidadNGC = unidadNGC;
	}

	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}

	public void setTemaNGC(TemaNGC temaNGC) {
		this.temaNGC = temaNGC;
	}

	public void setTemaxUnidadNGC(TemaxUnidadNGC temaxUnidadNGC) {
		this.temaxUnidadNGC = temaxUnidadNGC;
	}

	public void setEvaluacionNGC(EvaluacionNGC evaluacionNGC) {
		this.evaluacionNGC = evaluacionNGC;
	}

	public void setEvaluacionxMicroNGC(EvaluacionxMicroNGC evaluacionxMicroNGC) {
		this.evaluacionxMicroNGC = evaluacionxMicroNGC;
	}

	public void setUnidadxMicroNGC(UnidadxMicroNGC unidadxMicroNGC) {
		this.unidadxMicroNGC = unidadxMicroNGC;
	}

	public void setSubtemaNGC(SubtemaNGC subtemaNGC) {
		this.subtemaNGC = subtemaNGC;
	}

	public void setSubtemaxTemaNGC(SubtemaxTemaNGC subtemaxTemaNGC) {
		this.subtemaxTemaNGC = subtemaxTemaNGC;
	}

	public void setBibliografiaNGC(BibliografiaNGC bibliografiaNGC) {
		this.bibliografiaNGC = bibliografiaNGC;
	}

	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
		this.biblioxUnidadNGC = biblioxUnidadNGC;
	}

	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	public void setMicroxEstadoNGC(MicroxEstadoNGC microxEstadoNGC) {
		this.microxEstadoNGC = microxEstadoNGC;
	}

	public void setMicroxSemestreNGC(MicroxSemestreNGC microxSemestreNGC) {
		this.microxSemestreNGC = microxSemestreNGC;
	}

	public void setGuardarMicrocurriculoNGC(
			GuardarMicrocurriculoNGC guardarMicrocurriculoNGC) {
		this.guardarMicrocurriculoNGC = guardarMicrocurriculoNGC;
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
		TbMicMicrocurriculo microcurriculo = empaquetarMicrocurriculo();
		TbMicMicroxestado microxEstado = empaquetarMicroxEstado(microcurriculo);
		TbMicMicroxsemestre microxSemestre = empaquetarMicroxSemestre(microcurriculo, cmbIdSemestre.getValue());
		List<TbMicUnidad> listaUnidades = empaquetarUnidades(microcurriculo);
		List<TbMicObjetivo> listaObjetivos = empaquetarObjetivos(microcurriculo);
		List<TbMicEvaluacion> listaEvaluaciones = empaquetarEvaluaciones(microcurriculo);
		List<TbMicTema> listaTemas = empaquetarTemas(listaUnidades);
		List<TbMicSubtema> listaSubtemas = empaquetarSubtemas(listaTemas);
		List<TbMicBibliografia> listaBibliografia = empaquetarBibliografias(listaUnidades);
		List<TbMicAutor> listaAutores = new ArrayList<TbMicAutor>();
		List<TbMicAutorxbiblio> listaAutorxBiblio = new ArrayList<TbMicAutorxbiblio>();
		
		
				
//		for(TbMicTema tema:listaTemas){
//			System.out.print(tema.getNbIdtema()+"   ");
//			System.out.println(tema.getVrDescripcion()+"    ");
//		}
//		
//		if(listaSubtemas.size() > 0){
//			for(TbMicSubtema subtema:listaSubtemas){
//				System.out.print(subtema.getNbIdsubtema()+"   ");
//				System.out.print(subtema.getVrDescripcion()+"   ");
//				System.out.print(subtema.getVrModusuario()+"   ");
//				System.out.println(subtema.getDtModfecha()+"    ");
//				
//			}
//		}else{
//			System.out.println("Lista Subtemas está vacia.");
//		}
//		
//		for(TbMicSubtemaxtema stxT : listadoSubtemaxTema){
//			System.out.print(stxT.getNbid()+"    ");
//			System.out.print(stxT.getTbMicTema().getVrDescripcion()+"   ");
//			System.out.print(stxT.getTbMicSubtema().getVrDescripcion()+"    ");
//			System.out.print(stxT.getVrModUsuario()+"   ");
//			System.out.println(stxT.getDtModFecha());
//		}
		
		
		if( !(existeMicrocurriculo(microcurriculo.getVrIdmicrocurriculo()))){
			try {
				guardarMicrocurriculoNGC.guardarMicroxlotes(microcurriculo, microxEstado, microxSemestre, listaTemas, listaSubtemas, listadoTemasxUnidad, 
								listaAutores, listaUnidades, listadoUnidadesxMicro, listaObjetivos, listadoObjetivosxMicro, listaBibliografia, 
								listadoBibliografiaxUnidad, listaAutorxBiblio, listaEvaluaciones, listadoEvaluacionesxMicro);
				Messagebox.show("El Microcurriculo se ha guardado correctamente en estado Borrador el cual puede cambiar de estado cuando lo desee.", "REGISTRO ALMACENADO", Messagebox.OK,Messagebox.INFORMATION);
			} catch (ExcepcionesLogica e) {
				logger.error("Error al intentar guardar el objeto <Microcurriculo>");
			}
//			if (verificarCampos() == 1){				
//				
//
//			} else if (verificarCampos() == 0){				
//				try {
//					guardarMicrocurriculoNGC.guardarMicroMiniLote(microcurriculo, microxEstado, microxSemestre, listaObjetivos, listadoObjetivosxMicro);
//					Messagebox.show("El registro de Microcurriculos se guardará con la información mínima necesaria. \n El estado de este será <BORRADOR> y no podrá ser cambiado hasta que complete toda la información.","Información",Messagebox.OK, Messagebox.EXCLAMATION);
//				} catch (ExcepcionesLogica e) {
//					logger.error("Error al intentar guardar el objeto <Microcurriculo>");
//				}				
//			} else
//				Messagebox.show("El formulario no cumple con la información minina necesaria para crear un Microcurriculo. \n Por favor verifique los campos e intentelo nuevamente.","ERROR",Messagebox.OK,Messagebox.ERROR);
		} else {
			Messagebox.show("El Microcurriculo que desea crear coincide con un Registro en la Base de Datos. \n Por favor verifique la información ingresada.","Advertencia",Messagebox.OK,Messagebox.INFORMATION);
		}
	}
	
	
	

	
	
	private boolean existeMicrocurriculo(String idMicrocurriculo){
		TbMicMicrocurriculo micro = null;
		boolean estado = false;
		
		try {
			micro = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error("Se ha producido un Error al intentar obtener un Registro desde la tabla Microcurriculos.");
		}
		
		if (micro != null)
			estado = true;
		
		return estado;
		
	}
	
	private TbMicMicroxestado empaquetarMicroxEstado(TbMicMicrocurriculo microcurriculo){
		TbMicMicroxestado microxEstado = null;
		int registro = 0;
		TbMicEstado estado = null;
		
		try {
			registro = microxEstadoNGC.contarRegistros();			
		} catch (ExcepcionesLogica e) {
			logger.error("Error al intentar recuperar el numero de Registros de la Tabla Microcurriculo x Estado.");
		}
		
		try {
			estado = estadoNGC.obtenerEstados(1);
		} catch (ExcepcionesLogica e) {
			logger.error("Error al obtener el objeto Estado.");
		}
		
		if(estado != null){
			microxEstado = new TbMicMicroxestado(registro+1, estado, microcurriculo, modUsuario, modFecha);
		}		
		return microxEstado;
	}
	
	
	private TbMicMicroxsemestre empaquetarMicroxSemestre(TbMicMicrocurriculo microcurriculo, String idSemestre){
		TbMicMicroxsemestre microxSemestre = null;
		int registro = 0;
		TbAdmSemestre semestre = null;
		
		try {
			registro = microxSemestreNGC.ContarMicrosxsemestre();
			semestre = semestreNGC.obtenerSemestre(idSemestre);
		} catch (ExcepcionesLogica e) {
			logger.error("");
		}
		
		if (semestre != null){
			microxSemestre = new TbMicMicroxsemestre(registro+1, microcurriculo, semestre, modUsuario, modFecha);
		}
		
		return microxSemestre;
	}
		
	private List<TbMicEvaluacion> empaquetarEvaluaciones(TbMicMicrocurriculo microcurriculo){
		List<TbMicEvaluacion> lista = null;
		TbMicEvaluacion evaluacion = null;
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		
		int registrosEvaluaciones = 0;
		int registrosEvaluacionesxMicro = 0;
		int contadorEvaluaciones = 0;
		int contadorEvaluacionesxMicro = 0;
		
		try {
			registrosEvaluaciones = evaluacionNGC.contarRegistros();
			lista = new ArrayList<TbMicEvaluacion>();			
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al intentar obtener el numero de registros de la tabla <Evaluaciones>.");
		}
		
		try{
			registrosEvaluacionesxMicro = evaluacionxMicroNGC.obtenerRegistros();
			listadoEvaluacionesxMicro = new ArrayList<TbMicEvaluacionxmicro>();
		} catch(ExcepcionesLogica e){
			logger.error("Se presentaron Errores al intentar obtener el numero de registros de la tabla <EvaluacionesxMicro>.");
		}
		
		//Character tipo;
		contadorEvaluaciones = registrosEvaluaciones;
		contadorEvaluacionesxMicro = registrosEvaluacionesxMicro;
		
		for(int i=0;i<listaEvaluaciones.getItemCount();i++){
			contadorEvaluaciones++; 
			contadorEvaluacionesxMicro++;
			Listitem listaitem = (Listitem)listaEvaluaciones.getChildren().get(i+1);
			Listcell celdaEvaluacion = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaPorcentaje = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaFecha = (Listcell)listaitem.getChildren().get(2);
			Date fechaEstimada = new Date(celdaFecha.getLabel());
			evaluacion = new TbMicEvaluacion(contadorEvaluaciones, celdaEvaluacion.getLabel(), modUsuario, modFecha);
			evaluacionxMicro = new TbMicEvaluacionxmicro(contadorEvaluacionesxMicro, evaluacion, microcurriculo, Integer.parseInt(celdaPorcentaje.getLabel()), fechaEstimada, modUsuario, modFecha);
			lista.add(evaluacion);
			listadoEvaluacionesxMicro.add(evaluacionxMicro);
		}
		return lista;
	}
	
	
	private List<TbMicTema> empaquetarTemas(List<TbMicUnidad> listadoUnidades){
		List<TbMicTema> lista = null;		
		TbMicTema tema = null;
		TbMicTemaxunidad temaxUnidad = null;
		TbMicUnidad unidad = null;
		int registroTemas = 0;
		int registroTemasxUnidad = 0;
		int contadorTemas = 0;
		int contadorTemasxUnidad = 0;
		
		try {
			registroTemas = temaNGC.contarRegistros();
			lista = new ArrayList<TbMicTema>();
		} catch (ExcepcionesLogica e) {
			logger.error("Error al intentar contar los Registros de la Tabla <Temas>.");
		}
		
		try {
			registroTemasxUnidad = temaxUnidadNGC.contarRegistros();
			listadoTemasxUnidad = new ArrayList<TbMicTemaxunidad>();
		} catch (ExcepcionesLogica e) {
			logger.error("Error al intentar contar los Registros de la Tabla <TemasxUnidad>.");
		}
		
		contadorTemas = registroTemas;
		contadorTemasxUnidad = registroTemasxUnidad;
		
		for (int i=0;i<listaTemas.getItemCount(); i++){
			contadorTemas++;
			contadorTemasxUnidad++;
			Listitem listaitem = (Listitem)listaTemas.getChildren().get(i+1);
			Listcell celdaUnidad = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaIdTema = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaNombreTema = (Listcell)listaitem.getChildren().get(2);
			Listcell celdaSemanas = (Listcell)listaitem.getChildren().get(3);
			
			unidad = obtenerUnidad(listadoUnidades, celdaUnidad.getLabel());
			String descripcion = celdaNombreTema.getLabel();
			tema = new TbMicTema(contadorTemas, descripcion, modUsuario, modFecha);
			temaxUnidad = new TbMicTemaxunidad(contadorTemasxUnidad, unidad, tema, Integer.parseInt(celdaSemanas.getLabel()), modUsuario, modFecha);
			lista.add(tema);
			listadoTemasxUnidad.add(temaxUnidad);
		}
		return lista;
	}
	
	
	
	private List<TbMicSubtema> empaquetarSubtemas(List<TbMicTema> listadoTemas){
		List<TbMicSubtema> lista = null;
		TbMicTema tema = null;
		TbMicSubtema subtema = null;
		TbMicSubtemaxtema subtemaxTema = null;		
		
		int registroSubtema = 0;
		int registroSubtemaxTema = 0;
		int contadorSubtema = 0;
		int contadorSubtemaxTema = 0;
		
		try {
			registroSubtema = subtemaNGC.contarRegistros();
			lista = new ArrayList<TbMicSubtema>();
		} catch (ExcepcionesLogica e){
			logger.error("NGC : Se presentaron problemas para obtener el numero de Registros de la tabla <Subtema>.   ");
		}			
		
		try{
			registroSubtemaxTema = subtemaxTemaNGC.contarRegistros();
			listadoSubtemaxTema = new ArrayList<TbMicSubtemaxtema>();
		}catch(ExcepcionesLogica e){
			logger.error("NGC : Se presentaron problemas para obtener el numero de Registros de la tabla <SubtemaxTema>.   ");
		}
			
		contadorSubtemaxTema = registroSubtemaxTema;
		contadorSubtema = registroSubtema;
		for(int i=0; i<listaSubtemas.getItemCount(); i++){
			Listitem listaitem = (Listitem)listaSubtemas.getChildren().get(i+1);
			Listcell celdaTemas = (Listcell)listaitem.getChildren().get(1);
			Listcell celdaSubtema = (Listcell)listaitem.getChildren().get(2);
			contadorSubtema++;
			String nombre = celdaTemas.getLabel().toString();
			
			tema = obtenerTema(listadoTemas, nombre);
						
			if (tema != null){
				subtema = new TbMicSubtema(contadorSubtema, celdaSubtema.getLabel().toString(), modUsuario, modFecha);
				lista.add(subtema);
				contadorSubtemaxTema++;
				subtemaxTema = new TbMicSubtemaxtema(contadorSubtemaxTema, tema, subtema, modUsuario, modFecha);
				listadoSubtemaxTema.add(subtemaxTema);
			} 
		}
		return lista;
	}
	
	
	
	private List<TbMicBibliografia> empaquetarBibliografias(List<TbMicUnidad> listaUnidades){
		List<TbMicBibliografia> lista = null;
		TbMicBibliografia bibliografia = null;
		TbMicBiblioxunidad biblioxUnidad = null;
		int registroBibliografia = 0;
		int registroBiblioxUnidad = 0;
		int contadorBiblio = 0;
		int contadorBilbioxUnidad = 0;
		char tipoBibliografia;
		
		try {
			registroBibliografia = bibliografiaNGC.contarRegistros();
			lista = new ArrayList<TbMicBibliografia>();
		} catch (ExcepcionesLogica e) {			
			logger.error("Error al intentar recuperar el numero de Registros de la Tabla Bibliobrafia.");
		}
		
		
		try {
			registroBiblioxUnidad = biblioxUnidadNGC.contarRegistros();
			listadoBibliografiaxUnidad = new ArrayList<TbMicBiblioxunidad>();			
		}catch(ExcepcionesLogica e){
			logger.error("Error al intentar recuperar el numero de Registros de la Tabla <BiblioxUnidad>.");
		}
		
		contadorBiblio = registroBibliografia;
		contadorBilbioxUnidad = registroBiblioxUnidad;
		for(int i=0; i<listaBibliografia.getItemCount(); i++){
			contadorBiblio++;
			contadorBilbioxUnidad++;
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
			bibliografia = new TbMicBibliografia(contadorBiblio, celdaReferencia.getLabel().toString(), "", 
					celdaISBN.getLabel().toString().toUpperCase(), tipoBibliografia, modUsuario, modFecha);
			TbMicUnidad unidad = obtenerUnidad(listaUnidades, celdaUnidad.getLabel().toString().toUpperCase());
			biblioxUnidad = new TbMicBiblioxunidad(contadorBilbioxUnidad, bibliografia, unidad, modUsuario, modFecha);
			
			lista.add(bibliografia);
			listadoBibliografiaxUnidad.add(biblioxUnidad);
		}
		
		for(int i=0; i<listaCibergrafia.getItemCount();i++){
			contadorBiblio++;
			contadorBilbioxUnidad++;
			Listitem listaItem = (Listitem)listaCibergrafia.getChildren().get(i+1);
			Listcell celdaUnidad = (Listcell)listaItem.getChildren().get(0);
			Listcell celdaReferencia = (Listcell)listaItem.getChildren().get(1);
			Listcell celdaSitio = (Listcell)listaItem.getChildren().get(2);
			Listcell celdaTipo = (Listcell)listaItem.getChildren().get(3);
			if (celdaTipo.getLabel().toUpperCase() == "BASICA"){
				tipoBibliografia = '1';
			}else 
				tipoBibliografia = '0';
			TbMicUnidad unidad = obtenerUnidad(listaUnidades, celdaUnidad.getLabel().toString().toUpperCase());
			bibliografia = new TbMicBibliografia(contadorBiblio, celdaReferencia.getLabel().toString(), 
					celdaSitio.getLabel().toString(), null, tipoBibliografia, modUsuario, modFecha);
			biblioxUnidad = new TbMicBiblioxunidad(contadorBilbioxUnidad, bibliografia, unidad, modUsuario, modFecha);
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
	private TbMicUnidad obtenerUnidad(List<TbMicUnidad> lista, String nombre){
		TbMicUnidad unidad = null;
		Iterator<TbMicUnidad> iterator = lista.iterator();
		while (iterator.hasNext() && (unidad == null)){			
			if(nombre.equals(iterator.next().getVrNombre()) )				
				unidad = iterator.next();
		}		
		return unidad;
	}
	
	
	private TbMicTema obtenerTema(List<TbMicTema> lista, String nombre){
		TbMicTema tema = null;
		Iterator<TbMicTema> iterator = lista.iterator();	
		while (iterator.hasNext() && (tema == null)){
			if(nombre.equalsIgnoreCase(iterator.next().getVrDescripcion().toString()))
				tema = iterator.next();		
		}		
		return tema;
	}
	
	
	private List<TbMicUnidad> empaquetarUnidades(TbMicMicrocurriculo microcurriculo){
		List<TbMicUnidad> lista = new ArrayList<TbMicUnidad>();
				
		TbMicUnidad unidad = null;
		TbMicUnidadxmicro unidadxMicro = null;
		
		listadoUnidadesxMicro = new ArrayList<TbMicUnidadxmicro>();
		int contador = 0;
		int registrosBD = 0;
		int registroObjetivoxMicro = 0;
		String nombreUnidad = "";
		try {
			registrosBD = unidadNGC.numeroRegistros();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		try {
			registroObjetivoxMicro = objetivoxMicroNGC.contarRegistros();
		} catch (ExcepcionesLogica e) {
			logger.error("Error al intentar contar los Registros de la Tabla <ObjetivosxMicro>");
		}
		
		for(int i=0; i < listaUnidades.getItemCount(); i++){
			contador = 	registrosBD + i + 1;	
			nombreUnidad = listaUnidades.getItems().get(i).getLabel();
			unidad = new TbMicUnidad(contador, nombreUnidad, modUsuario, modFecha);
			unidadxMicro = new TbMicUnidadxmicro(contador, unidad, microcurriculo, modUsuario, modFecha);
			lista.add(unidad);
			listadoUnidadesxMicro.add(unidadxMicro);
		}
		return lista;
	}
	
	/**
	 * Este metodo se encarga de tomar la información de la ListaObjetivosEspecificos y empaquetar ListaObjetivos y ListadoObjetivosxMicrocurriculo.
	 * @param microcurriculo
	 * @return Lista con objetos de Tipo Objetivos
	 */
	@SuppressWarnings("null")
	private List<TbMicObjetivo> empaquetarObjetivos(TbMicMicrocurriculo microcurriculo){
		List<TbMicObjetivo> listaObjetivos = null;
		TbMicObjetivo objetivo = null;
		TbMicObjetivoxmicro objetivosxMicro = null;
		
		
		int registrosObjetivosDB = 0;
		int registrosObjetivosxMicroDB = 0;
		int contadorObjetivos = 0;
		int contadorObjetivoxMicro = 0;
		String celdaObjetivo = "";
		
		try {
			registrosObjetivosDB = objetivoNGC.numeroRegistros()+1;
			listaObjetivos = new ArrayList<TbMicObjetivo>();
			listadoObjetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
				
		try{
			registrosObjetivosxMicroDB = objetivoxMicroNGC.contarRegistros() +1;
		}catch(ExcepcionesLogica e){
			
		}
		
		
		if((txtObjetivoGeneral.getValue().trim().length() > 0) && (txtObjetivoGeneral != null)){
			objetivo = new TbMicObjetivo(registrosObjetivosDB, txtObjetivoGeneral.getValue(), modUsuario, modFecha);
			
			listaObjetivos.add(objetivo);
			objetivosxMicro = new TbMicObjetivoxmicro(registrosObjetivosxMicroDB,objetivo,microcurriculo,'1',modUsuario,modFecha);
			listadoObjetivosxMicro.add(objetivosxMicro);
			for (int i=0; i<listaObjetivosEspecificos.getItemCount(); i++){
				contadorObjetivos = registrosObjetivosDB + i + 1;
				contadorObjetivoxMicro = registrosObjetivosxMicroDB + i + 1;
				celdaObjetivo = listaObjetivosEspecificos.getItems().get(i).getLabel();
				objetivo = new TbMicObjetivo(contadorObjetivos, celdaObjetivo, modUsuario, modFecha);
				objetivosxMicro = new TbMicObjetivoxmicro(contadorObjetivoxMicro,objetivo,microcurriculo,'0',modUsuario,modFecha);
				listaObjetivos.add(objetivo);
				listadoObjetivosxMicro.add(objetivosxMicro);
			}
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
	private TbMicMicrocurriculo empaquetarMicrocurriculo(){
		TbMicMicrocurriculo microcurriculo = null;;
		String codigoMicrocurriculo = "";
		TbAdmMateria materia = null;
		TbAdmSemestre semestre = null;
		TbAdmPersona responsable = null;		
		
		try {
			materia = materiaNGC.obtenerMateria(cmbIdMateria.getValue());
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		try {
			semestre = semestreNGC.obtenerSemestre(cmbIdSemestre.getValue());
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		try {
			responsable = personaNGC.obtenerPersona(cmbIdDocente.getValue());
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
		codigoMicrocurriculo = asignarIdMicrocurriculo(cmbIdSemestre.getValue().toString(), cmbIdMateria.getValue().toString());
		
		if ( codigoMicrocurriculo != null){
			if (materia != null){
				if (semestre != null){
					if (responsable != null){
						microcurriculo = new TbMicMicrocurriculo(codigoMicrocurriculo, materia, txtPropositoMicro.getText(), 
								txtJustificacionMicro.getText(), txtResumenMicro.getText(), responsable, modUsuario, modFecha);
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
			estado = estadoNGC.obtenerEstados(1).getVrDescripcion();
		} catch (ExcepcionesLogica e) {
			logger.info("El Registro Solicitado no fue Hallado en la Base de Datos.");
		}
		return estado;
	}
	
	
	
	private String asignarIdMicrocurriculo(String idsemestre, String idmateria){
		String codigo = null;
		TbAdmSemestre semestre = null;
		TbAdmMateria materia = null;
		
		try {
			semestre = semestreNGC.obtenerSemestre(idsemestre);
			materia = materiaNGC.obtenerMateria(idmateria);
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
	 * Este método se encarga de validar la información ingresada y clasifica el estado en el que se guardará el Microcurriculo.
	 * @return
	 */
	public int verificarCampos(){
		int estado = -1;
		if (comprobarInformacionGeneral()){
			if (comprobarInformacionComplementaria()){
				estado = 0;
				if (comprobarUnidadesDetalladas()){
					if (comprobarEvaluaciones()){
						if (comprobarReferencias()){
							estado = 1;							
						} 
					} 
				}
			} 
		}
		return estado;
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
				} 
//				else {
//					Messagebox.show("Falta Informacion en la lista <Subtemas por Temas>");
//					cmbListaUnidades.setFocus(true);
//				}
			} 
//			else {
//				Messagebox.show("Falta Informacion en la lista <Temas por Unidades>");
//				cmbIdUnidad.setFocus(true);
//			}
		} 
//		else {
//			Messagebox.show("Falta Informacion en la lista <Unidades>");
//			txtNombreUnidad.setFocus(true);
//		}
		
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
		} 
//		else {
//			Messagebox.show("Falta Informacion en la lista <Evaluaciones>");
//			txtActividadMicro.setFocus(true);
//		}
		
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
			} 
//			else {
//				Messagebox.show("Falta Informacion en la lista <Referencias Cibergráficas>");
//				txtNombreSitioCiber.setFocus(true);
//			}
		} 
//		else {
//			Messagebox.show("Falta Informacion en la lista <Referncias Bibliográficas>");
//			cmbReferenciaBiblio.setFocus(true);
//		}
		
		return estado;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		super.doAfterCompose(comp);		
	}

}
