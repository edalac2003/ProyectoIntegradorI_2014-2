package com.udea.proint1.microcurriculo.ctrl2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.ListableBeanFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Textbox;



public class CrearMicroCtrlxxx extends GenericForwardComposer {

	private static Logger logger = Logger.getLogger(CrearMicroCtrlxxx.class);
	
	Button btnAddUnidad;
	Button btnAddTemas;
	Button btnAddObjetivo;
	Button btnAddSubTema;
	Button btnAddEvaluacion;
	Button btnAddBibliografia;
	Button btnAddCibergrafia;
	
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
	
	
	public void onClick$btnAddCibergrafia(Event event){
		if ((!"".equals(cmbListaUnidadBiblio.getValue())) && (!"".equals(txtNombreSitioCiber.getValue())) && (!"".equals(txtURLSitioCiber.getValue())) && (!"".equals(cmbTipoCibergrafia.getValue()))){
			Listitem listaItem = new Listitem();
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
			
		}else {
			Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
		}
	}
	
	public void onClick$btnAddBibliografia(Event event){
		if((!"".equals(cmbListaUnidadBiblio.getValue())) && (!"".equals(cmbReferenciaBiblio.getValue())) && (!"".equals(cmbAutorBiblio.getValue()))) {
			if ((!"".equals(txtISBNBiblio.getValue())) && (!"".equals(cmbPaisBiblio.getValue())) && (!"".equals(cmbTipoBibliografia.getValue()))){
				Listitem listaItem = new Listitem();
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
			} else {
				Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
			}							
		} else {
			Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
		}		
	}
	
	public void onClick$btnAddEvaluacion(Event event){
		//if ("[0-9]".equals(txtPorcentajeActividad.getValue())){		
			if((!"".equals(txtActividadMicro.getValue())) && (!"".equals(txtPorcentajeActividad.getValue())) && (!"".equals(dtFechaEvaluacion.getValue()))){
				Listitem listaItem = new Listitem();
				Listcell celda1 = new Listcell(txtActividadMicro.getValue());
				Listcell celda2 = new Listcell(txtPorcentajeActividad.getValue().toString());
				Listcell celda3 = new Listcell(dtFechaEvaluacion.getValue().toString());
				listaItem.appendChild(celda1);
				listaItem.appendChild(celda2);
				listaItem.appendChild(celda3);
				listaEvaluaciones.appendChild(listaItem);
				txtActividadMicro.setValue("");
				txtPorcentajeActividad.setValue(null);	
			} else 
				Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
		/*} else {
			Messagebox.show("Se requiere valor Numérico para el Campo Porcentaje");
		}*/
	}
	
	public void onClick$btnAddObjetivo(Event event){
		if(!"".equals(txtObjetivoEspecifico.getValue())){
			Listitem listaItem = new Listitem();
			Listcell celda = new Listcell(txtObjetivoEspecifico.getValue());
			listaItem.appendChild(celda);			
			listaObjetivosEspecificos.appendChild(listaItem);
			txtObjetivoEspecifico.setValue("");
		} else {
			Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
		}
	}
	
	public void onClick$btnAddUnidad(Event event){
		if(!"".equals(txtNombreUnidad.getValue())){
			Listitem listaItem = new Listitem();
			Listcell celda = new Listcell(txtNombreUnidad.getValue().toUpperCase());
			listaItem.appendChild(celda);
			listaUnidades.appendChild(listaItem);
			txtNombreUnidad.setValue("");
		} else {
			Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
		}
		
		System.out.println("Se adiciono una celda a la lista");			
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
		if((!"".equals(cmbIdUnidad.getValue()) && (!"".equals(txtNombreTema.getValue())) && (!"".equals(txtNumeroSemanas.getValue())) )){
			Listitem listaItem = new Listitem();
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
		} else {
			Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
		}
		
	}
	
	public void onClick$btnAddSubTema(Event event){
		if((!"".equals(cmbListaUnidades.getValue())) && (!"".equals(cmbListaTemas.getValue())) && (!"".equals(txtSubTemas.getValue()))){
			Listitem listaItem = new Listitem();
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
		} else {
			Messagebox.show("No es Posible adicionar a la Lista.  Campos sin Información");
		}
		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		System.out.println("Esta es la Ventana de Crear Microcurriculo");

	}

}
