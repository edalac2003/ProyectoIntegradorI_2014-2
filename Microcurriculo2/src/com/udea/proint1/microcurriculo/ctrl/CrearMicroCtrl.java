package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
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
	
	public void eliminaListItem(Listitem celda){
		celda.detach();
	}
	
	public void eliminaComboItem(Comboitem item){
		item.detach();
	}
	
	
	
	public void onClick$btnAddUnidad(Event event){
		if(txtNombreUnidad.getValue() != null && (txtNombreUnidad.getValue().trim().length() > 0)){
			
			final Listitem listaItem = new Listitem();
			listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					eliminaListItem(listaItem);					
				}
			});
			
			Listcell celda = new Listcell(txtNombreUnidad.getValue().toUpperCase());
			listaItem.appendChild(celda);
			llenarCombosUnidades(txtNombreUnidad.getValue().toUpperCase());
			listaUnidades.appendChild(listaItem);
			txtNombreUnidad.setValue("");
			txtNombreUnidad.setFocus(true);
		} else
			Messagebox.show("Se Requiere información en el Campo <Nombre de la Unidad>");
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
		
		if (cmbIdUnidad.getValue() != null && (cmbIdUnidad.getValue().trim().length() > 0)){
			if (txtNombreTema.getValue() != null && (txtNombreTema.getValue().trim().length() > 0)){
				if (txtNumeroSemanas.getValue() != null){
					llenarListaTemas();
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
		if (cmbListaUnidades.getValue() != null && (cmbListaUnidades.getValue().trim().length() > 0)){
			if (cmbListaTemas.getValue() != null && (cmbListaTemas.getValue().trim().length() > 0)){
				if (txtSubTemas.getValue() != null && (txtSubTemas.getValue().trim().length() > 0)){
					llenarListaSubTemas();
				} else
					Messagebox.show("Se Requiere información en el Campo <Subtema>");
			} else
				Messagebox.show("Se Requiere información en el Campo <Tema>");			
		} else
			Messagebox.show("Se Requiere información en el Campo <Unidad>");
	}
	
	public void llenarListaSubTemas(){
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
	}
	
	/*private void recargarCombosUnidades(Listbox lista){
		cmbIdUnidad.getItems().clear();
		cmbListaUnidades.getItems().clear();
		String unidad;
		Messagebox.show("Se cargaran "+ lista.getItemCount());
		
		for (int i=0; i < lista.getItemCount(); i++ ){
			unidad = lista.getItems().get(i).getValue();
			Comboitem item = new Comboitem(unidad);
			cmbIdUnidad.appendChild(item);
			item = new Comboitem(unidad);
			cmbListaUnidades.appendChild(item);
		}		
	}*/
	
	public void onSelect$cmbListaUnidades(){
		//Messagebox.show("Estoy en el Evento Select del Combobox");
		llenarTemasPorUnidad(listaTemas, cmbListaUnidades.getValue());
	}
	
	public void onClick$cmbListaUnidades(Event event){
		//Messagebox.show("Estoy en el Evento Select del Combobox");
		llenarTemasPorUnidad(listaTemas, cmbListaUnidades.getValue());
	}
	
	private void llenarTemasPorUnidad(Listbox lista, String Unidad){
		//cmbListaTemas.getItems().clear();
		//Messagebox.show("Estas en el modulo Llenar Temas por Unidad");
		
		for(int i=0; i < lista.getItemCount(); i++){
			//System.out.println(lista.getItems().get(i).getLabel());
			Listitem listaitem = new Listitem();
			listaitem = lista.getItemAtIndex(i);
			System.out.println(listaitem.getLabel());
			Comboitem item = new Comboitem(Integer.toString(i));
			cmbListaTemas.appendChild(item);
		}
		
		
	}
	
	/*public void onClick$cmbIdUnidad(){
		Messagebox.show("HIZO CLICK SOBRE " +cmbIdUnidad.getId());
		cmbIdUnidad.getItems().clear();
	}*/
	
	
	
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
	
	/*public void onClick$btnGuardarMicro(){
		Messagebox.show("HA INGRESADO A LA SECCION DE GUARDAR MICROCURRICULO");
		// HACER VALIDACIONES DE CAMPOS VACIOS.  CUALES SON LOS CAMPOS MINIMOS PARA GUARDAR UN MICROCURRICULO?
	}*/
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		//cargarMaterias();
		cargarNucleos();
		cargarDocentes();
		cargarSemestres();
		System.out.println("Esta es la Ventana de Crear Microcurriculo");

	}

}
