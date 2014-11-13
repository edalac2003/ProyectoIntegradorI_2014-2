package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.ls.LSInput;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Cell;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadesxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;


public class CrearMicroCtrl extends GenericForwardComposer {

	private static Logger logger = Logger.getLogger(CrearMicroCtrl.class);
	
	Button btnAddUnidad;
	Button btnAddTemas;
	Button btnAddObjetivo;
	Button btnAddSubTema;
	Button btnAddEvaluacion;
	Button btnAddBibliografia;
	Button btnAddCibergrafia;
	//Button btnGuardarMicro;
	
	
	Label lblNombreMateria;
	Label lblAreaMateria;
	Label lblCreditosMateria;
	Label lblHtMateria;
	Label lblHpMateria;
	Label lblHtpMateria;
	Label lblHoraClaseSemestral;
	Label lblCampoFormacion;
	Label lblPrerrequisitos;
	Label lblCorrequisitos;
	Label lblProgramasVinculados;
	Label lblNombreDocente;
	Label lblNombreNucleo;
	
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
	
	
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaObjetivosEspecificos;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;
	Listbox listaCibergrafia;
	
	Textbox txtNombreUnidad;
	Textbox txtNombreTema;
	Longbox txtNumeroSemanas;
	Textbox txtObjetivoEspecifico;
	Textbox txtSubTemas;
	Textbox txtActividadMicro;
	Longbox txtPorcentajeActividad;
	Textbox txtISBNBiblio;
	Textbox txtNombreSitioCiber;
	Textbox txtURLSitioCiber;
	
	Datebox dtFechaEvaluacion;
	
	Combobox cmbIdUnidad;
	Combobox cmbListaUnidades;
	Combobox cmbListaTemas;
	Combobox cmbListaUnidadBiblio;
	Combobox cmbReferenciaBiblio;
	Combobox cmbAutorBiblio;
	Combobox cmbPaisBiblio;
	Combobox cmbTipoBibliografia;
	Combobox cmbTipoCibergrafia;
	Combobox cmbIdMateria;
	Combobox cmbIdDocente;
	Combobox cmbIdNucleo;
	Combobox cmbIdSemestre;
	
	MateriasNGC materiasNGC;
	PersonaNGC personaNGC;
	NucleoNGC nucleoNGC;
	SemestreNGC semestreNGC;
	
	
	
	
	//Esto se debe incluir al momento de Guardar.  Son los DTO por medio de los cuales se comunicaran las capas
	/*NegocioMC  negocioMC ;
	
	public void setNegocioMC(NegocioMC  negocioMC){
		this.negocioMC = negocioMC;
	}*/
	
	//Esta instruccion va en el controlador de la vista que se encargará de mostrar los resultados de la consulta
	//arg.get("objeto")
	
	
	public void setMateriasNGC(MateriasNGC materiasNGC) {
		this.materiasNGC = materiasNGC;
	}

	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	
	/**
	 * Este evento ocurre cuando se hace click en sobre el boton <AddCibergrafia>.
	 * 
	 * Captura y valora los valores y los adiciona al ListBox Listacibergrafia a traves del método llenarListaCibergrafia
	 * 
	 * @param event
	 */
	public void onClick$btnAddCibergrafia(Event event){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (txtNombreSitioCiber.getValue() != null && (txtNombreSitioCiber.getValue().trim().length() > 0)){
				if (!"".equals(txtURLSitioCiber.getValue())){
					if (!"".equals(cmbTipoCibergrafia.getValue())){
						llenarListaCibergrafia();
					} else {
						Messagebox.show("Se Requiere información en el Campo <Tipo Cibergrafía>");
					}
				} else {
					Messagebox.show("Se Requiere información en el Campo <URL Sitio>");
				}
			} else {
				Messagebox.show("Se Requiere información en el Campo <Nombre Sitio>");
			}				
		} else {
			Messagebox.show("Se Requiere información en el Campo <Nombre de la Unidad>");
		}
	}
	
	/**
	 * Este Metodo se encarga de llenar 
	 */
	public void llenarListaCibergrafia(){
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem);
			}
		});
		Listcell celda1 = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celda2 = new Listcell(txtNombreSitioCiber.getValue());
		Listcell celda3 = new Listcell(txtURLSitioCiber.getValue());
		Listcell celda4 = new Listcell(cmbTipoCibergrafia.getValue());
		listaItem.appendChild(celda1);
		listaItem.appendChild(celda2);
		listaItem.appendChild(celda3);
		listaItem.appendChild(celda4);
		listaCibergrafia.appendChild(listaItem);
		txtNombreSitioCiber.setValue("");
		txtURLSitioCiber.setValue("");
	}
	
	public void onClick$btnAddBibliografia(Event event){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (cmbReferenciaBiblio.getValue() != null && (cmbReferenciaBiblio.getValue().trim().length() > 0)){
				if (cmbAutorBiblio.getValue() != null && (cmbAutorBiblio.getValue().trim().length() > 0)){
					if (txtISBNBiblio.getValue() != null && (txtISBNBiblio.getValue().trim().length() > 0)){
						if (cmbPaisBiblio.getValue() != null && (cmbPaisBiblio.getValue().trim().length() > 0)){
							if (cmbTipoBibliografia.getValue() != null && (cmbTipoBibliografia.getValue().trim().length() > 0)){
								llenarListaBibliografia();
							} else
								Messagebox.show("Se Requiere información en el Campo <Tipo Bibliografia>");
						} else 
							Messagebox.show("Se Requiere información en el Campo <Pais>");						
					} else
						Messagebox.show("Se Requiere información en el Campo <ISBN>");
				} else
					Messagebox.show("Se Requiere información en el Campo <Autor>");				
			} else
				Messagebox.show("Se Requiere información en el Campo <Referencia Bibliografica>");
		} else 
			Messagebox.show("Se Requiere información en el Campo <Nombre de la Unidad>");
	}
	
	public void llenarListaBibliografia(){
		final Listitem listaItem = new Listitem();
		
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {		
				
				eliminaListItem(listaItem);
			}
		});
		
		Listcell celda1 = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celda2 = new Listcell(cmbReferenciaBiblio.getValue());
		Listcell celda3 = new Listcell(cmbAutorBiblio.getValue());
		Listcell celda4 = new Listcell(txtISBNBiblio.getValue());
		Listcell celda5 = new Listcell(cmbPaisBiblio.getValue());
		Listcell celda6 = new Listcell(cmbTipoBibliografia.getValue());
		listaItem.appendChild(celda1);
		listaItem.appendChild(celda2);
		listaItem.appendChild(celda3);
		listaItem.appendChild(celda4);
		listaItem.appendChild(celda5);
		listaItem.appendChild(celda6);
		listaBibliografia.appendChild(listaItem);
	}
	
	public void onClick$btnAddEvaluacion(Event event){
		if (txtActividadMicro.getValue() != null && (txtActividadMicro.getValue().trim().length() > 0)){
			if (txtPorcentajeActividad.getValue() != null && (txtPorcentajeActividad.getValue() > 0)){
				if (dtFechaEvaluacion.getValue() != null) {
					llenarListaActividades();
				} else 
					Messagebox.show("La Información del Campo <fecha> no es válida");
			} else
				Messagebox.show("Se Requiere información en el Campo <Porcentaje>");
		} else
			Messagebox.show("Se Requiere información en el Campo <Actividad>");
	}
	
	public void llenarListaActividades() {
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {		
				
				eliminaListItem(listaItem);
			}
		});
		
		Listcell celda1 = new Listcell(txtActividadMicro.getValue());
		Listcell celda2 = new Listcell(txtPorcentajeActividad.getValue().toString());
		Listcell celda3 = new Listcell(dtFechaEvaluacion.getValue().toString());
		listaItem.appendChild(celda1);
		listaItem.appendChild(celda2);
		listaItem.appendChild(celda3);
		listaEvaluaciones.appendChild(listaItem);
		txtActividadMicro.setValue("");
		txtPorcentajeActividad.setValue(null);	
	}
	
	
	
	public void onClick$btnAddObjetivo(Event event){
		if(txtObjetivoEspecifico.getValue() != null && (txtObjetivoEspecifico.getValue().trim().length() >0)){	
			final Listitem listaItem = new Listitem();
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {

				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem);
				}
			});
			Listcell celda = new Listcell(txtObjetivoEspecifico.getValue());
			listaItem.appendChild(celda);			
			listaObjetivosEspecificos.appendChild(listaItem);
			txtObjetivoEspecifico.setText(null);
			txtObjetivoEspecifico.setValue(null);
		} else {
			Messagebox.show("Se Requiere información en el Campo <Objetivo Especifico>");
		}
	}
	
	
	/*public void onClick$btnAddObjetivo3(Event event){
		Map arg = new HashMap();
		arg.put("objeto", microcurriculo); //Microcurriculo es un DTO. Objeto es la clave, debe coincidir con el controlador 
		
		//Con esta orden se llama la nueva pagina y se envia un Map con los contenidos de los componentes
		Executions.createComponentsDirectly("/dsd/listarMicro.zul", "zul", null, arg);
	}*/
	
	public void eliminaListItem(Listitem item){		
		if(item.getParent() == listaUnidades){
			item.detach();
			recargarCombosUnidades(listaUnidades);
		}
		item.detach();
	}
	
	public void onClick$btnAddUnidad(Event event){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}
	
	public void onOK$txtNombreUnidad(){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}

	private void llenarListaUnidades(String nombreUnidad){
		if(nombreUnidad != null && (nombreUnidad.trim().length() > 0)){			
			final Listitem listaItem = new Listitem();
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem);					
				}
			});
			
			Listcell celda = new Listcell(nombreUnidad.toUpperCase());
			listaItem.appendChild(celda);
			llenarCombosUnidades(nombreUnidad.toUpperCase());
			listaUnidades.appendChild(listaItem);
			txtNombreUnidad.setValue("");
			txtNombreUnidad.setFocus(true);
		} else
			Messagebox.show("Se Requiere información en el Campo <Nombre de la Unidad>");
	}
	
	
	
	public void onOK$cmbIdUnidad(){
		txtNombreTema.setFocus(true);
	}
	
	public void onOK$txtNombreTema(){
		txtNumeroSemanas.setFocus(true);
	}
	
	public void onOK$txtNumeroSemanas(){
		validarCamposTemas(cmbIdUnidad.getValue(), txtNombreUnidad.getValue(), Integer.parseInt(txtNumeroSemanas.getValue().toString()));
		cmbIdUnidad.setFocus(true);
	}
	
	public void onOK$cmbListaUnidades(){
		llenarTemasPorUnidad(listaTemas, cmbListaUnidades.getValue());
		cmbListaTemas.setFocus(true);
	}
	
	public void onOK$cmbListaTemas(){
		txtSubTemas.setFocus(true);
	}
	
	public void onOK$txtSubTemas(){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
		cmbListaUnidades.setFocus(true);
	}
	
	
	/**
	 * Boton btnAddTemas Evento onClick
	 * 
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validación de contenido existente.
	 * 
	 * @param event
	 */
	public void onClick$btnAddTemas(Event event){		
		validarCamposTemas(cmbIdUnidad.getValue(), txtNombreUnidad.getValue(), Integer.parseInt(txtNumeroSemanas.getValue().toString()));		
	}
	
	
	/*
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validación de contenido existente.
	 * 
	 */
	private void validarCamposTemas(String idUnidad, String nombreTema, int numeroSemanas){
		if (cmbIdUnidad.getValue() != null && (cmbIdUnidad.getValue().trim().length() > 0)){
			if (txtNombreTema.getValue() != null && (txtNombreTema.getValue().trim().length() > 0)){
				if (txtNumeroSemanas.getValue() != null){
					llenarListaTemas();
					cmbListaUnidades.setSelectedIndex(-1);
					cmbListaUnidades.setValue("");					
				} else {
					Messagebox.show("Se Requiere información en el Campo <Tiempo (Semanas)>");
					txtNumeroSemanas.setFocus(true);
				}					
			} else {
				Messagebox.show("Se Requiere información en el Campo <Tema>");
				txtNombreTema.setFocus(true);
			}				
		} else{
			Messagebox.show("Se Requiere información en el Campo <Unidad>");			
		}		
	}
		
	public void llenarListaTemas(){
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {		
				
				eliminaListItem(listaItem);
			}
		});
		
		Listcell celda1 = new Listcell(cmbIdUnidad.getValue());
		Listcell celda2 = new Listcell(txtNombreTema.getValue().toUpperCase());
		Listcell celda3 = new Listcell(txtNumeroSemanas.getValue().toString());
		
		listaItem.appendChild(celda1);
		listaItem.appendChild(celda2);
		listaItem.appendChild(celda3);
		listaTemas.appendChild(listaItem);
		cmbIdUnidad.setValue("");
		txtNombreTema.setValue("");
		txtNumeroSemanas.setValue(null);
	}
	
	public void onClick$btnAddSubTema(Event event){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
	}
	
	private void validarCamposSubtemas(String listaUnidades, String listaTemas, String subTema){
		if (cmbListaUnidades.getValue() != null && (cmbListaUnidades.getValue().trim().length() > 0)){
			if (cmbListaTemas.getValue() != null && (cmbListaTemas.getValue().trim().length() > 0)){
				if (txtSubTemas.getValue() != null && (txtSubTemas.getValue().trim().length() > 0)){
					llenarListaSubTemas();
					cmbListaUnidades.setSelectedIndex(-1);
					cmbListaTemas.setSelectedIndex(-1);
				} else
					Messagebox.show("Se Requiere información en el Campo <Subtema>");
			} else
				Messagebox.show("Se Requiere información en el Campo <Tema>");			
		} else
			Messagebox.show("Se Requiere información en el Campo <Unidad>");
	}
	
	public void llenarListaSubTemas(){
		//listaSubtemas.getItems().clear();
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {		
				
				eliminaListItem(listaItem);
			}
		});			
		
		Listcell celda1 = new Listcell(cmbListaUnidades.getValue());
		Listcell celda2 = new Listcell(cmbListaTemas.getValue());
		Listcell celda3 = new Listcell(txtSubTemas.getValue());
		listaItem.appendChild(celda1);
		listaItem.appendChild(celda2);
		listaItem.appendChild(celda3);
		listaSubtemas.appendChild(listaItem);
		cmbListaUnidades.setValue("");
		cmbListaTemas.setValue("");
		txtSubTemas.setValue("");
	}
	
	
	
	public void cargarDocentes(){
		try {
			List<TbAdmPersona> listaDocentes = personaNGC.listarPersonas();
			cmbIdDocente.getItems().clear();
			if (listaDocentes != null){
				//Messagebox.show("Se Hallaron Registros "+listaDocentes.size());
				for(TbAdmPersona docente : listaDocentes){
					Comboitem item = new Comboitem(docente.getVrIdpersona());
					cmbIdDocente.appendChild(item);
				}
			} else
				Messagebox.show("No Se Hallaron Registros de Docentes");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarMaterias(String nucleo){
		try {
			List<TbAdmMaterias> listaMaterias = materiasNGC.listarMateriasxNucleo(nucleo);
			if (listaMaterias != null){
				for (TbAdmMaterias materia : listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					cmbIdMateria.appendChild(item);
				}
			} else {
				System.out.println("El objeto está Vacio");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	
	public void cargarNucleos(){
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			cmbIdNucleo.getItems().clear();
			if (listaNucleos != null){
				for(TbAdmNucleo nucleo : listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					cmbIdNucleo.appendChild(item);
				}
			} else
				Messagebox.show("No se Encontraron Registros en la Tabla Nucleos Académicos");
		} catch (ExcepcionesLogica e) {
			logger.error(e);			
		}
	}
	
	private void cargarSemestres(){
		try {
			List<TbAdmSemestre> listaSemestre = semestreNGC.listarSemestres();
			if (listaSemestre != null){
				for (TbAdmSemestre semestre : listaSemestre){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbIdSemestre.appendChild(item);
				}
			} else
				Messagebox.show("No se Encontraron Registros de Semestres");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		
	}
	
	public void onSelect$cmbIdNucleo(){
		TbAdmNucleo nucleo;
		try {
			nucleo = nucleoNGC.obtenerNucleo(cmbIdNucleo.getValue().toString());
			lblNombreNucleo.setValue(nucleo.getVrNombre());
		} catch (WrongValueException e) {
			e.printStackTrace();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
		cmbIdMateria.getItems().clear();
		cargarMaterias(cmbIdNucleo.getValue().toString());
	}
		
	private void llenarCombosUnidades(String unidad){
		Comboitem item = new Comboitem(unidad);		
		cmbIdUnidad.appendChild(item);
		Comboitem item2 = new Comboitem(unidad);
		cmbListaUnidades.appendChild(item2);
		Comboitem item3 = new Comboitem(unidad);
		cmbListaUnidadBiblio.appendChild(item3);
	}
	
	private void recargarCombosUnidades(Listbox lista){
		cmbIdUnidad.getItems().clear();
		cmbListaUnidades.getItems().clear();
		cmbListaUnidadBiblio.getItems().clear();
		cmbListaTemas.getItems().clear();
		String celda;
		
		for (int i=0; i < lista.getItemCount(); i++ ){
			Listitem listaItem = (Listitem)lista.getChildren().get(0); 
			celda = listaItem.getLabel();
			Comboitem item = new Comboitem(celda);
			cmbIdUnidad.appendChild(item);
			Comboitem item2 = new Comboitem(celda);
			cmbListaUnidades.appendChild(item2); 
			Comboitem item3 = new Comboitem(celda);
			cmbListaUnidadBiblio.appendChild(item3);
		}		
	}
	
	public void onSelect$cmbListaUnidades(){
		//Messagebox.show("Estoy en el Evento Select del Combobox");
		llenarTemasPorUnidad(listaTemas, cmbListaUnidades.getValue());
	}
		
	private void llenarTemasPorUnidad(Listbox lista, String unidad){
		cmbListaTemas.getItems().clear();
		
		for(int i=1; i <= listaTemas.getItemCount(); i++){
			Listitem listaitem = (Listitem)lista.getChildren().get(i);
			Listcell celdaUnidades = (Listcell)listaitem.getChildren().get(0);
			Listcell celdaTemas = (Listcell)listaitem.getChildren().get(1);
			Comboitem item = new Comboitem(celdaTemas.getLabel());
			
			cmbListaTemas.appendChild(item);
			
			/*if (celdaUnidades.getLabel().trim() == unidad){
				System.out.println("prueba : " +celdaUnidades.getLabel() +"  "+ celdaTemas.getLabel());
			} else{
				System.out.println("NO ES IGUAL "+ celdaUnidades.getLabel().length()+" que "+ unidad.length());
			}	*/		
		}	
	}
	
	
	
	public void onSelect$cmbIdDocente(){
		try {
			TbAdmPersona persona = personaNGC.obtenerPersona(cmbIdDocente.getValue().toString());
			if (persona != null){
				lblNombreDocente.setValue(persona.getVrNombres() + " "+ persona.getVrApellidos());
			} else 
				Messagebox.show("No se Encontró el Regitro para el docente.");
		} catch (WrongValueException e) {
			e.printStackTrace();
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdMateria(){
		//Messagebox.show("Ingresó al Evento."+ cmbIdMateria.getValue().toString());
		try {
			TbAdmMaterias materia = materiasNGC.obtenerMateria(cmbIdMateria.getValue().toString());
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
	
		
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarNucleos();
		cargarDocentes();
		cargarSemestres();
		logger.info("Esta es la Ventana de Crear Microcurriculo");

	}

}
