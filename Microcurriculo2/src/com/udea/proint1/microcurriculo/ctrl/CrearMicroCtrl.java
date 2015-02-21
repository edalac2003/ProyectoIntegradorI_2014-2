package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
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
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Textbox;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPais;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PaisNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;


public class CrearMicroCtrl extends GenericForwardComposer {

	private static Logger logger = Logger.getLogger(CrearMicroCtrl.class);
	
	Tabbox fichaContenidos;
	
	Button btnAddUnidad;
	Button btnAddTemas;
	Button btnAddObjetivo;
	Button btnAddSubTema;
	Button btnAddEvaluacion;
	Button btnAddBibliografia;
	Button btnAddCibergrafia;
	//Button btnGuardarMicro;
	
	Label lblNombreUnidadAcademica;
	Label lblNombreDependencia;
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
	Label lblIdSubtema;
	Label lblIdTema;
	Label lblNombreTema;
	
	
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
	Listbox listaTemaPorUnidad;
	
	Textbox txtNombreUnidad;
	Textbox txtNombreTema;
	Longbox txtNumeroSemanas;
	Textbox txtObjetivoEspecifico;
	Textbox txtSubTemas;
	Textbox txtActividadMicro;
	Longbox txtPorcentajeActividad;
	Textbox txtReferenciaBiblio;
	Textbox txtAutorBiblio;
	Textbox txtISBNBiblio;
	Textbox txtNombreSitioCiber;
	Textbox txtURLSitioCiber;
	Textbox txtJustificacionMicro;
	Textbox txtPropositoMicro;
	
	Datebox dtFechaEvaluacion;
	
	Combobox cmbIdUnidad;
	Combobox cmbListaUnidades;
	Combobox cmbListaTemas;
	Combobox cmbListaUnidadBiblio;
	Combobox cmbTipoBibliografia;
	Combobox cmbTipoCibergrafia;
	Combobox cmbMateria;
	Combobox cmbDocente;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	
	Date fechaEstimada = null;
	DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	MateriaNGC materiaNGC;
	PersonaNGC personaNGC;
	NucleoNGC nucleoNGC;
	SemestreNGC semestreNGC;
	PaisNGC paisNGC;
	TemaNGC temaNGC;
	SubtemaNGC subtemaNGC;
	DependenciaNGC dependenciaNGC;
	UnidadAcademicaNGC unidadAcademicaNGC;
	
	int porcentajeEvaluacion = 0;
	
	
	
	//Esto se debe incluir al momento de Guardar.  Son los DTO por medio de los cuales se comunicaran las capas
	/*NegocioMC  negocioMC ;
	
	public void setNegocioMC(NegocioMC  negocioMC){
		this.negocioMC = negocioMC;
	}*/
	
	//Esta instruccion va en el controlador de la vista que se encargar� de mostrar los resultados de la consulta
	//arg.get("objeto")
	
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}

	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	public void setPaisNGC(PaisNGC paisNGC) {
		this.paisNGC = paisNGC;
	}
	
	public void setTemaNGC(TemaNGC temaNGC) {
		this.temaNGC = temaNGC;
	}

	public void setSubtemaNGC(SubtemaNGC subtemaNGC) {
		this.subtemaNGC = subtemaNGC;
	}

	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}

	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}

	public int getPorcentajeEvaluacion() {
		return porcentajeEvaluacion;
	}

	/**
	 * Este evento ocurre cuando se hace click en sobre el boton <AddCibergrafia>.
	 * 
	 * Captura y valora los valores y los adiciona al ListBox Listacibergrafia a traves del m�todo llenarListaCibergrafia
	 * 
	 * @param event
	 */
	public void onClick$btnAddCibergrafia(Event event){
		verificarCamposCibergrafia();
	}
	
	private void verificarCamposCibergrafia(){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (txtNombreSitioCiber.getValue() != null && (txtNombreSitioCiber.getValue().trim().length() > 0)){
				if (!"".equals(txtURLSitioCiber.getValue())){
					if (!"".equals(cmbTipoCibergrafia.getValue())){
						llenarListaCibergrafia();
					} else {
						Messagebox.show("Se Requiere informaci�n en el Campo <Tipo Cibergraf�a>");
					}
				} else {
					Messagebox.show("Se Requiere informaci�n en el Campo <URL Sitio>");
				}
			} else {
				Messagebox.show("Se Requiere informaci�n en el Campo <Nombre Sitio>");
			}				
		} else {
			Messagebox.show("Se Requiere informaci�n en el Campo <Nombre de la Unidad>");
		}
	}
	

	/**
	 * Este Metodo se encarga de llenar 
	 */
	private void llenarListaCibergrafia(){
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem, "");
			}
		});
		Listcell celdaUnidad = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celdaSitio = new Listcell(txtNombreSitioCiber.getValue());
		Listcell celdaURL = new Listcell(txtURLSitioCiber.getValue());
		Listcell celdaTipo = new Listcell(cmbTipoCibergrafia.getValue());
		listaItem.appendChild(celdaUnidad);
		listaItem.appendChild(celdaSitio);
		listaItem.appendChild(celdaURL);
		listaItem.appendChild(celdaTipo);
		listaCibergrafia.appendChild(listaItem);
		txtNombreSitioCiber.setValue("");
		txtURLSitioCiber.setValue("");
		txtNombreSitioCiber.focus();
	}
	
	
	public void onOK$cmbListaUnidadBiblio(){
		txtReferenciaBiblio.focus();
	}
	
	public void onOK$txtReferenciaBiblio(){
		txtAutorBiblio.focus();
	}
	
	public void onOK$txtAutorBiblio(){
		txtISBNBiblio.focus();
	}
	
	public void onOK$txtISBNBiblio(){
		cmbTipoBibliografia.focus();
	}
	
	public void onOK$cmbTipoBibliografia(){
		verificarCamposBibliografia();
	}
		
	public void onClick$btnAddBibliografia(Event event){
		verificarCamposBibliografia();
	}
	
	public void onOK$txtNombreSitioCiber(){
		txtURLSitioCiber.focus();
	}
	
	public void onOK$txtURLSitioCiber(){
		cmbTipoCibergrafia.focus();
	}
	
	public void onOK$cmbTipoCibergrafia(){
		verificarCamposCibergrafia();
	}
	
	public void onOK$cmbIdUnidad(){
		txtNombreTema.setFocus(true);
	}
	
	public void onOK$txtNombreTema(){
		txtNumeroSemanas.focus();
	}
	
	public void onOK$txtNumeroSemanas(){
		validarCamposTemas(cmbIdUnidad.getValue(), txtNombreTema.getValue(), Integer.parseInt(txtNumeroSemanas.getValue().toString()));
		cmbIdUnidad.setFocus(true);
	}
		
	public void onOK$txtSubTemas(){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
		cmbListaUnidades.setFocus(true);
	}
	
	public void onOK$txtActividadMicro(){
		txtPorcentajeActividad.focus();
	}
	
	public void onOK$txtPorcentajeActividad(){
		dtFechaEvaluacion.focus();
	}
	
	public void onOK$dtFechaEvaluacion(){
		verificarCamposEvaluacion();
	}
	
	public void onSelect$cmbListaTemas(){
		txtSubTemas.setFocus(true);
	}
	
	public void onOK$cmbListaTemas(){
		txtSubTemas.setFocus(true);
	}
	
	
	public void onSelect$cmbDocente(){
		lblNombreDocente.setValue(mostrarNombreDocente(cmbDocente.getValue()));
	}
	
	public void onOK$cmbDocente(){
		lblNombreDocente.setValue(mostrarNombreDocente(cmbDocente.getValue()));
		if (!(lblNombreDocente.getValue().equals("") && (lblNombreDocente.getValue().trim().length() > 0)))
			cmbSemestre.focus();				
	}
	
	public void onClick$btnAddUnidad(Event event){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}
	
	public void onOK$txtNombreUnidad(){
		llenarListaUnidades(txtNombreUnidad.getValue());
	}
	
	public void onOK$cmbListaUnidades(){		
		cargarTemasEnSubtemas(listaTemas, cmbListaUnidades.getValue());
		cmbListaTemas.focus();
	}
	
	public void onSelect$cmbListaUnidades(){
		cargarTemasEnSubtemas(listaTemas, cmbListaUnidades.getValue());
	}

	public void onOK$cmbUnidadAcademica(){
		cmbDependencia.focus();
	}
	
	public void onSelect$cmbUnidadAcademica(){
		lblNombreUnidadAcademica.setValue(mostrarUnidadAcademica(cmbUnidadAcademica.getValue()));
	}
	
	public void onOK$cmbDependencia(){
		cmbNucleo.focus();
	}
	
	public void onSelect$cmbDependencia(){
		lblNombreDependencia.setValue(mostrarDependencia(cmbDependencia.getValue()));
	}
	
	public void onSelect$cmbMateria(){
		mostrarInfoMateria(cmbMateria.getValue().toString());
	}
	
	public void onOK$cmbMateria(){
		mostrarInfoMateria(cmbMateria.getValue().toString());
	}
	
	public void onSelect$cmbNucleo(){
		mostrarNucleo(cmbNucleo.getValue().toString());
	}
	
	public void onSelect$fichaContenidos(){
		Tabpanel tabpanels = (Tabpanel)fichaContenidos.getSelectedPanel();
		int indice = tabpanels.getIndex();
		if (indice == 0){
			cmbDocente.focus();
		}else if (indice == 1){
			txtPropositoMicro.focus();
		}else if (indice == 2){
			txtNombreUnidad.focus();
		}else if (indice == 3){
			cmbListaUnidades.focus();
		}else if (indice == 4){
			txtActividadMicro.focus();
		}else if (indice == 5){
			cmbListaUnidadBiblio.focus();
		}
	}
	
	private void verificarCamposBibliografia(){
		if (!"".equals(cmbListaUnidadBiblio.getValue())){
			if (txtReferenciaBiblio.getValue() != null && (txtReferenciaBiblio.getValue().trim().length() > 0)){
				if (txtAutorBiblio.getValue() != null && (txtAutorBiblio.getValue().trim().length() > 0)){
					if (txtISBNBiblio.getValue() != null && (txtISBNBiblio.getValue().trim().length() > 0)){
						if (cmbTipoBibliografia.getValue() != null && (cmbTipoBibliografia.getValue().trim().length() > 0)){
							llenarListaBibliografia();
						} else
							Messagebox.show("Se Requiere informaci�n en el Campo <Tipo Bibliografia>");					
					} else
						Messagebox.show("Se Requiere informaci�n en el Campo <ISBN>");
				} else
					Messagebox.show("Se Requiere informaci�n en el Campo <Autor>");				
			} else
				Messagebox.show("Se Requiere informaci�n en el Campo <Referencia Bibliografica>");
		} else 
			Messagebox.show("Se Requiere informaci�n en el Campo <Nombre de la Unidad>");
	}
	
	private void llenarListaBibliografia(){
		final Listitem listaItem = new Listitem();
		
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem,"");
			}
		});
		
		Listcell celdaUnidad = new Listcell(cmbListaUnidadBiblio.getValue());
		Listcell celdaReferencia = new Listcell(txtReferenciaBiblio.getValue());
		Listcell celdaAutor = new Listcell(txtAutorBiblio.getValue().toUpperCase());
		Listcell celdaISBN = new Listcell(txtISBNBiblio.getValue().toUpperCase());
		Listcell celdaTipo = new Listcell(cmbTipoBibliografia.getValue().toUpperCase());
		listaItem.appendChild(celdaUnidad);
		listaItem.appendChild(celdaReferencia);
		listaItem.appendChild(celdaAutor);
		listaItem.appendChild(celdaISBN);
		listaItem.appendChild(celdaTipo);
		listaBibliografia.appendChild(listaItem);		
		
		limpiarCamposBibliografia();
		txtReferenciaBiblio.focus();
	}
	
	private void limpiarCamposBibliografia(){
		txtReferenciaBiblio.setValue("");
		txtAutorBiblio.setValue("");
		txtISBNBiblio.setValue("");
		cmbTipoBibliografia.setValue("");
	}
	
	public void onClick$btnAddEvaluacion(Event event){
		verificarCamposEvaluacion();
	}
	
	private void verificarCamposEvaluacion(){
		if (txtActividadMicro.getValue() != null && (txtActividadMicro.getValue().trim().length() > 0)){
			if (txtPorcentajeActividad.getValue() != null && (txtPorcentajeActividad.getValue() > 0)){
				if (dtFechaEvaluacion.getValue() != null) {
					llenarListaActividades();
				} else 
					Messagebox.show("La Informaci�n del Campo <fecha> no es v�lida");
			} else
				Messagebox.show("Se Requiere informaci�n en el Campo <Porcentaje>");
		} else
			Messagebox.show("Se Requiere informaci�n en el Campo <Actividad>");
	}
	
	public void llenarListaActividades() {
		final Listitem listaItem = new Listitem();				
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {		
				eliminaListItem(listaItem,"");
			}
		});
		
		Listcell celdaActividad = new Listcell(txtActividadMicro.getValue());
		Listcell celdaPorcentaje = new Listcell(txtPorcentajeActividad.getValue().toString());
		String tmpFecha = formatoFecha.format(dtFechaEvaluacion.getValue());
		Listcell celdaFecha = new Listcell(tmpFecha);
		
		porcentajeEvaluacion = porcentajeEvaluacion + Integer.parseInt(txtPorcentajeActividad.getValue().toString());
		if (porcentajeEvaluacion > 100){
			Messagebox.show("No es posible agregar el registro a la lista. El porcentaje de las Evaluaciones supera el 100%. " +
					"\n Por favor verifique los valores.");			
		} else {
			listaItem.appendChild(celdaActividad);
			listaItem.appendChild(celdaPorcentaje);
			listaItem.appendChild(celdaFecha);
			listaEvaluaciones.appendChild(listaItem);
			txtActividadMicro.setValue("");
			txtPorcentajeActividad.setValue(null);
			dtFechaEvaluacion.setValue(null);
			txtActividadMicro.focus();
		}
	}
	
	
	
	public void onClick$btnAddObjetivo(Event event){
		if(txtObjetivoEspecifico.getValue() != null && (txtObjetivoEspecifico.getValue().trim().length() >0)){	
			final Listitem listaItem = new Listitem();
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem,"");
				}
			});
			Listcell celda = new Listcell(txtObjetivoEspecifico.getValue());
			listaItem.appendChild(celda);			
			listaObjetivosEspecificos.appendChild(listaItem);
			txtObjetivoEspecifico.setText(null);
			txtObjetivoEspecifico.setValue(null);
		} else {
			Messagebox.show("Se Requiere informaci�n en el Campo <Objetivo Especifico>");
		}
	}
	
	
	/*public void onClick$btnAddObjetivo3(Event event){
		Map arg = new HashMap();
		arg.put("objeto", microcurriculo); //Microcurriculo es un DTO. Objeto es la clave, debe coincidir con el controlador 
		
		//Con esta orden se llama la nueva pagina y se envia un Map con los contenidos de los componentes
		Executions.createComponentsDirectly("/dsd/listarMicro.zul", "zul", null, arg);
	}*/
	
	private void eliminaListItem(Listitem item, String clave){		
		if(item.getParent().getId().toString().equals("listaUnidades")){
			eliminaCascadaUnidad(item, clave.toUpperCase());
			item.detach();
			recargarCombosUnidades(listaUnidades);
		} else if (item.getParent().getId().toString().equals("listaTemas")){
			eliminaCascadaTema(item, clave.toUpperCase());
			item.detach();
			recargarCombosTemas(listaTemas);
		} else if(item.getParent().getId().toString().equals("listaSubtemas")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaEvaluaciones")){
			Listcell celdaPorcentaje = (Listcell)item.getChildren().get(1);
			porcentajeEvaluacion = porcentajeEvaluacion - Integer.parseInt(celdaPorcentaje.getValue().toString());
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaBibliografia")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaCibergrafia")){
			item.detach();
		} else if(item.getParent().getId().toString().equals("listaObjetivosEspecificos")){
			item.detach();
		}
	}
		
	private void eliminaCascadaUnidad(Listitem item, String clave){
		if (listaBibliografia.getItems().size() > 0){
			for (int i=1; i<=listaBibliografia.getItems().size(); i++){
				Listitem itemBiblio = (Listitem)listaBibliografia.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemBiblio.getChildren().get(0);
				if (clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemBiblio.detach();
					i--;
				}				
			}
		}
		
		if (listaCibergrafia.getItems().size() > 0){
			for(int i=1; i<=listaCibergrafia.getItems().size(); i++){
				Listitem itemCiber = (Listitem)listaCibergrafia.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemCiber.getChildren().get(0);
				if(clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemCiber.detach();
					i--;
				}
			}
		}
		
		if (listaSubtemas.getItems().size() > 0){
			for(int i=1; i<=listaSubtemas.getItems().size(); i++){
				Listitem itemSubtema = (Listitem)listaSubtemas.getChildren().get(i);
				Listcell celdaUnidad = (Listcell)itemSubtema.getChildren().get(0);
				if(clave.equals(celdaUnidad.getLabel().trim().toUpperCase())){
					itemSubtema.detach();
					i--;
				}
			}
		}
		if (listaTemas.getItems().size() > 0){
			for(int i=1;i<=listaTemas.getItems().size(); i++){
				Listitem itemTema = (Listitem)listaTemas.getChildren().get(i);
				Listcell celdaTema = (Listcell)itemTema.getChildren().get(0);
				if (clave.equals(celdaTema.getLabel().trim().toUpperCase())){
					itemTema.detach();
					i--;
				}
			}
		}
	}
	
	private void eliminaCascadaTema(Listitem item, String clave){
		Listcell celda = (Listcell)item.getChildren().get(1);
		clave = celda.getLabel();
		if (listaSubtemas.getItems().size() > 0){
			for(int i=1; i<=listaSubtemas.getItems().size(); i++){
				Listitem itemSubtema = (Listitem)listaSubtemas.getChildren().get(i);
				Listcell celdaTema = (Listcell)itemSubtema.getChildren().get(1);
				if(clave.equals(celdaTema.getLabel().trim().toUpperCase())){
					itemSubtema.detach();
					i--;
				}
			}
		}
	}
	
	
	
	private void llenarListaUnidades(String nombreUnidad){
		if(!("".equals(nombreUnidad)) && (nombreUnidad.trim().length() > 0)){			
			final Listitem listaItem = new Listitem();
			final String tmpUnidad = nombreUnidad;
			
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem, tmpUnidad);					
				}
			});
			if (!existeUnidad(tmpUnidad)){
				Listcell celdaVacia = new Listcell("");
				listaItem.appendChild(celdaVacia);
				Listcell celdaUnidad = new Listcell(nombreUnidad.toUpperCase());
				listaItem.appendChild(celdaUnidad);
				llenarCombosUnidades(nombreUnidad.toUpperCase());
				listaUnidades.appendChild(listaItem);
				txtNombreUnidad.setValue("");
				txtNombreUnidad.setFocus(true);
			}else
				Messagebox.show("Existe un unidad con el mismo nombre.");
			
		} else
			if (listaUnidades.getItems().size() > 0)
				cmbIdUnidad.focus();
			else
				Messagebox.show("Se Requiere informaci�n en el Campo <Nombre de la Unidad>");
	}
	
	
	
	
	
	/**
	 * Boton btnAddTemas Evento onClick
	 * 
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validaci�n de contenido existente.
	 * 
	 * @param event
	 */
	public void onClick$btnAddTemas(Event event){		
		validarCamposTemas(cmbIdUnidad.getValue().toString(), txtNombreTema.getValue().toString(), 
				Integer.parseInt(txtNumeroSemanas.getValue().toString()));
					
	}
	
	
	/*
	 * Captura el contenido de los campos idUnidad, nombreTema y numeroSemanas, la cual se almacena en una 
	 * lista previa validaci�n de contenido existente.
	 * 
	 */
	private void validarCamposTemas(String idUnidad, String nombreTema, int numeroSemanas){
		if(cmbIdUnidad.getValue().trim().length() > 0)
			if (txtNombreTema.getValue().trim().length() > 0 && (!"".equals(txtNombreTema.getValue())))
				if(txtNumeroSemanas.longValue() > 0){
					llenarListaTemas(nombreTema);
					cmbListaUnidades.setSelectedIndex(-1);
					cmbListaUnidades.setValue("");
				}else{
					Messagebox.show("Se requiere informaci�n en el campo <Tiempo (Semanas)>");
					txtNumeroSemanas.focus();
				}
			else{
				Messagebox.show("Se requiere informaci�n en el campo <Nombre Tema>");
				txtNombreTema.focus();
			}
		else{
			Messagebox.show("Se requiere informaci�n en el campo <Nombre Unidad>");
			cmbIdUnidad.focus();
		}
			
		
	}
		
	public void llenarListaTemas(String tema){
		final Listitem listaItem = new Listitem();
		final String tmpTema = tema.toUpperCase().trim();
		
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				eliminaListItem(listaItem, tmpTema);
			}
		});
		
		if (!existeTema(tmpTema)){
			Listcell celdaUnidad = new Listcell(cmbIdUnidad.getValue());
			Listcell celdaTema = new Listcell(txtNombreTema.getValue().toUpperCase());		
			Listcell celdaTiempo = new Listcell(txtNumeroSemanas.getValue().toString());		
			listaItem.appendChild(celdaUnidad);
			listaItem.appendChild(celdaTema);
			listaItem.appendChild(celdaTiempo);
			
			listaTemas.appendChild(listaItem);
			cmbIdUnidad.setValue("");
			txtNombreTema.setValue("");
			txtNumeroSemanas.setValue(null);
		} else{
			Messagebox.show("El Tema a Ingresar ya Existe.");
		}
		
	}
	
	private boolean existeTema(String tema){
		boolean estado = false;
		for(int i=1; i<=listaTemas.getItems().size(); i++){
			Listitem item = (Listitem)listaTemas.getChildren().get(i);
			Listcell celdaTema = (Listcell)item.getChildren().get(1);
			if (tema.equals(celdaTema.getLabel().trim().toUpperCase())){
				estado = true;
				break;
			}
		}
		return estado;
	}
	
	private boolean existeUnidad(String unidad){
		boolean estado = false;
		for (int i=1;i<=listaUnidades.getItems().size(); i++){
			Listitem item = (Listitem)listaUnidades.getChildren().get(i);
			Listcell celdaUnidad = (Listcell)item.getChildren().get(1);
			if (unidad.toUpperCase().equals(celdaUnidad.getLabel())){
				estado = true;
				break;
			}
				
				
		}
		return estado;
	}
	
	public void onClick$btnAddSubTema(Event event){
		validarCamposSubtemas(cmbListaUnidades.getValue(), cmbListaTemas.getValue(), txtSubTemas.getValue());
	}
	
	private void validarCamposSubtemas(String listaUnidades, String listaTemas, String subTema){
		if (cmbListaUnidades.getValue() != null && (cmbListaUnidades.getValue().trim().length() > 0)){
			if (cmbListaTemas.getValue() != null && (cmbListaTemas.getValue().trim().length() > 0)){
				if (txtSubTemas.getValue() != null && (txtSubTemas.getValue().trim().length() > 0)){
					llenarListaSubTemas();
					cmbListaTemas.getItems().clear();
					cmbListaTemas.setValue("");;
					cmbListaUnidades.focus();
				} else
					Messagebox.show("Se Requiere informaci�n en el Campo <Subtema>");
			} else
				Messagebox.show("Se Requiere informaci�n en el Campo <Tema>");			
		} else
			Messagebox.show("Se Requiere informaci�n en el Campo <Unidad>");
	}
	
	private void llenarListaSubTemas(){
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {						
				eliminaListItem(listaItem,"");
			}
		});			
		
		Listcell celdaUnidad = new Listcell(cmbListaUnidades.getValue());
		Listcell celdaTema = new Listcell(cmbListaTemas.getValue());
		Listcell celdaSubtema = new Listcell(txtSubTemas.getValue());
		listaItem.appendChild(celdaUnidad);
		listaItem.appendChild(celdaTema);
		listaItem.appendChild(celdaSubtema);
		
		listaSubtemas.appendChild(listaItem);
		txtSubTemas.setValue("");
	}
	
	
	public void cargarMaterias(String nucleo){
		try {
			List<TbAdmMateria> listaMaterias = materiaNGC.listarMateriasxNucleo(nucleo);
			if (listaMaterias != null){
				for (TbAdmMateria materia : listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					item.setDescription(materia.getVrNombre());
					cmbMateria.appendChild(item);
				}
			} else {
				//System.out.println("El objeto est� Vacio");
			}
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
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

		if (lista.getItems().size() > 0){
			for (int i=1; i <= lista.getItems().size(); i++ ){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celda = (Listcell)listaItem.getChildren().get(1);

				Comboitem itemUnidadTema = new Comboitem(celda.getLabel());
				cmbIdUnidad.appendChild(itemUnidadTema);
				Comboitem item2 = new Comboitem(celda.getLabel());
				cmbListaUnidades.appendChild(item2); 
				Comboitem item3 = new Comboitem(celda.getLabel());
				cmbListaUnidadBiblio.appendChild(item3);
			}	
		}
			
	}
	
	private void recargarCombosTemas(Listbox lista){
		cmbListaTemas.getItems().clear();
		
		if(lista.getItems().size() > 0){
			for(int i=1; i<= lista.getItemCount(); i++){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celda = (Listcell)listaItem.getChildren().get(0);
				Comboitem item = new Comboitem(celda.getLabel());
				cmbListaTemas.appendChild(item);
			}
		}
	}

	
	
	/**
	 * Este metodo de encarga de Cargar, en el ComboBox de Temas de la pesta�a Subtemas, los datos hallados de acuerdo a la unidad Seleccionada.
	 * 
	 * @param lista.  Recibe el ListBox de donde se Extraeran los registros.
	 * @param unidad. Es el valor que se utilizar� para comparar.
	 */
	private void cargarTemasEnSubtemas(Listbox lista, String unidad){
		
		cmbListaTemas.getItems().clear();
		if (lista.getItemCount() > 0){
			for(int i=1;i<=lista.getItemCount(); i++){
				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
				Listcell celdaTema = (Listcell)listaItem.getChildren().get(1);
				Listcell celdaUnidad = (Listcell)listaItem.getChildren().get(0);
				Comboitem itemTema = new Comboitem(celdaTema.getLabel());
				
				if (unidad.equals(celdaUnidad.getLabel()))
					cmbListaTemas.appendChild(itemTema);
			}
		}		
	}
	
	private String mostrarNombreDocente(String idDocente){
		String nombre = "";
		TbAdmPersona persona = null;
	
		try {
			persona = personaNGC.obtenerPersona(idDocente);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		
		if (persona != null){
			nombre = persona.getVrApellidos()+" "+persona.getVrNombres();
		}	
		return nombre;
	}
	
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
	
		
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cmbDocente.focus();
	}

}
