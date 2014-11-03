package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;

public class ListarMateriasCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ListarMateriasCtrl.class);
	
	Listbox listaMaterias;
	
	Combobox cmbCriterioBusqueda;
	
	Textbox txtValorBusqueda;
	
	Button btnBuscarMateria;
	
	MateriasNGC materiaNGC;

		
	public void setMateriaNGC(MateriasNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	
	public void onClick$btnBuscarMaterias(Event event){

	}


	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}


}
