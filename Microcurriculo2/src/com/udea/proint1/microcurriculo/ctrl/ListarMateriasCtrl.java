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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ListarMateriasCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ListarMateriasCtrl.class);
	
	Listbox listaMaterias;
	
	Combobox cmbCriterioBusqueda;
	Combobox cmbValorBusqueda;
	
	Button btnBuscarMaterias;
	
	MateriasNGC materiasNGC;
	
	//MicrocurriculosNGC microcurriculosNGC;

	
	
	public void setMateriasNGC(MateriasNGC materiasNGC) {
		this.materiasNGC = materiasNGC;
	}

	public void onClick$btnBuscarMaterias(Event event){
		//Messagebox.show("Entro al Evento Click de BUscar");
		
		if (!"".equals(cmbCriterioBusqueda.getValue()) && (cmbCriterioBusqueda.getValue() != null)){
			if ((!"".equals(cmbValorBusqueda.getValue())) && (cmbValorBusqueda.getValue() != null)){
				List<TbAdmMaterias> listaMaterias = null;
				try {
					listaMaterias = materiasNGC.listarMateriasxNucleo(cmbValorBusqueda.getValue().toString());
					if (listaMaterias != null){
						for(TbAdmMaterias materia : listaMaterias){
							llenarListaMaterias(materia);
						}						
					} else 
						Messagebox.show("No se encontraron registros coincidentes con el criterio de Busqueda");
				} catch (WrongValueException e) {
					e.printStackTrace();
				} catch (ExcepcionesLogica e) {
					e.printStackTrace();
				}				
			} else
				Messagebox.show("Se Requiere información en el Campo <Valor a Buscar>");
		}else
			Messagebox.show("Se Requiere información en el Campo <Criterio de Busqueda>");
	}
	
	public void llenarListaMaterias(TbAdmMaterias materia){
		Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {		
				consultarMaterias();
			}
		});
		System.out.println("Codigo : " + materia.getVrIdmateria());
		Listcell celda1 = new Listcell(materia.getVrIdmateria());
		Listcell celda2 = new Listcell(materia.getVrNombre());
		Listcell celda3 = new Listcell(materia.getTbAdmNucleo().getVrNombre());
		Listcell celda4 = new Listcell(Integer.toString(materia.getNbSemestre()));
		Listcell celda5 = new Listcell(Integer.toString(materia.getNbHt()));
		Listcell celda6 = new Listcell(Integer.toString(materia.getNbHp()));
		Listcell celda7 = new Listcell(Integer.toString(materia.getNbHtp()));
		Listcell celda8 = new Listcell(null);
		listaItem.appendChild(celda1);
		listaItem.appendChild(celda2);
		listaItem.appendChild(celda3);
		listaItem.appendChild(celda4);
		listaItem.appendChild(celda5);
		listaItem.appendChild(celda6);
		listaItem.appendChild(celda7);
		listaItem.appendChild(celda8);
		listaMaterias.appendChild(listaItem);
	}
	
	public void consultarMaterias(){
		
	}
	
	public void limpiarLista(Listbox lista){
		for (int i=lista.getItemCount();i==0;i++){
			lista.removeItemAt(i);
		}
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
}
