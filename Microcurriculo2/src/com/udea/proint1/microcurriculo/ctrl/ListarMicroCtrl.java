package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;




@SuppressWarnings("rawtypes")
public class ListarMicroCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ListarMicroCtrl.class);
	
	Combobox cmbMateria;
	
	Listbox listaMicrocurriculo;
	
	MicrocurriculoNGC microcurriculoNGC;
	
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	private void cargarMicrocurriculos(String id){
		try {
			List<TbMicMicrocurriculo> listaMicro = microcurriculoNGC.listarMicrocurriculosPorMateria(id);	
			if (listaMicro != null){
				listaMicrocurriculo.getItems().clear();
				for(TbMicMicrocurriculo micro : listaMicro){
					final Listitem listaItem = new Listitem();
					
					
					Listcell celdaCodigo = new Listcell(micro.getVrIdmicrocurriculo().toString());
					Listcell celdaUnidad = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
					Listcell celdaDependencia = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
					Listcell celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
					Listcell celdaMateria = new Listcell(micro.getTbAdmMateria().getVrNombre());
					Listcell celdaSemestre = new Listcell();
					Listcell celdaResponsable = new Listcell(micro.getTbAdmPersona().getVrNombres()+" "+micro.getTbAdmPersona().getVrApellidos());
						
					celdaCodigo.setStyle("font-size:10px");
					celdaUnidad.setStyle("font-size:10px");
					celdaDependencia.setStyle("font-size:10px");
					celdaNucleo.setStyle("font-size:10px");
					celdaMateria.setStyle("font-size:10px");
					celdaSemestre.setStyle("font-size:10px");
					celdaResponsable.setStyle("font-size:10px");
					
					listaItem.appendChild(celdaCodigo);
					listaItem.appendChild(celdaUnidad);
					listaItem.appendChild(celdaDependencia);
					listaItem.appendChild(celdaNucleo);
					listaItem.appendChild(celdaMateria);
					listaItem.appendChild(celdaSemestre);
					listaItem.appendChild(celdaResponsable);
					
					listaMicrocurriculo.appendChild(listaItem);
				}
			}
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron Errores al listar los registros de la tabla <Tb_Adm_Microcurriculo>.  "+e);
		}
		
	}
	
	private void menuEmergente(Listitem item){
//		Menupopup editPopup = new Menupopup();
//		Menuitem itemConsulta = new Menuitem("Ver Detalles");
//		MenuItem itemDuplicar = new MenuItem("Duplicar");
//		Menuitem itemRefrescar = new Menuitem("Refrescar");
//		
//		editPopup.appendChild(itemConsulta);
//		editPopup.appendChild(itemRefrescar);
//		
//		listaMicrocurriculo.setContext(editPopup);

	}
	
	public void onClick$btnBuscar(){
		cargarMicrocurriculos(cmbMateria.getValue());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		
		super.doAfterCompose(comp);
			
	}
}
