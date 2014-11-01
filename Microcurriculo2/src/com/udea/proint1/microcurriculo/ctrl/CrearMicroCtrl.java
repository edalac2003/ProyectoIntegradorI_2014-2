package com.udea.proint1.microcurriculo.ctrl;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;


public class CrearMicroCtrl extends GenericForwardComposer {

	private static Logger logger = Logger.getLogger(CrearMicroCtrl.class);
	
	Button btnAddUnidad;
	Button btnAddTemas;
	Button btnAddObjetivo;
	
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaObjetivosEspecificos;
	
	Textbox txtNombreUnidad;
	Textbox txtNombreTema;
	Textbox txtNumeroSemanas;
	Textbox txtObjetivoespecifico;
	
	Combobox cmbIdUnidad;
	
	
	public void onClick$btnAddObjetivo(Event event){
		Listitem listaItem = new Listitem();
		Listcell celda = new Listcell(txtObjetivoespecifico.getValue());
		listaItem.appendChild(celda);
		listaObjetivosEspecificos.appendChild(listaItem);
	}
	
	/*public void onClick$btnAddUnidad(Event event){
		Listitem listaItem = new Listitem();
		Listcell celda = new Listcell(txtNombreUnidad.getValue());
		listaItem.appendChild(celda);
		listaUnidades.appendChild(listaItem);
		System.out.println("Se adiciono una celda a la lista");			
	}
	
	public void onClick$btnAddTemas(Event event){
		Listitem listaItem = new Listitem();
		Listcell celda1 = new Listcell(cmbIdUnidad.getValue());
		Listcell celda2 = new Listcell(txtNombreTema.getValue());
		Listcell celda3 = new Listcell(txtNumeroSemanas.getValue());
		listaItem.appendChild(celda1);
		listaItem.appendChild(celda2);
		listaItem.appendChild(celda3);
		listaTemas.appendChild(listaItem);
	}
	*/
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		System.out.println("Esta es la Ventana de Crear Microcurriculo");

	}

}
