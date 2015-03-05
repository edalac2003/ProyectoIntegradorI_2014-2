package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Toolbar;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;




@SuppressWarnings("rawtypes")
public class ListarMicroCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ListarMicroCtrl.class);
	
	Combobox cmbMateria;
	Combobox cmbNucleo;
	Combobox cmbDependencia;
	Combobox cmbUnidadAcademica;
	Combobox cmbSemestre;
	Combobox cmbDocente;
	Combobox cmbEstado;
	
	Listbox listaMicrocurriculo;
	
	Toolbar tool_details;
	
	MicrocurriculoNGC microcurriculoNGC;
	MicroxEstadoNGC microxEstadoNGC;
	MateriaNGC materiaNGC;
	
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	public void setMicroxEstadoNGC(MicroxEstadoNGC microxEstadoNGC) {
		this.microxEstadoNGC = microxEstadoNGC;
	}

	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	List<TbMicMicrocurriculo> microcurriculosEncontrados = new ArrayList<TbMicMicrocurriculo>();
	
	List<TbMicMicrocurriculo> microcurriculosFiltradoSemestre = new ArrayList<TbMicMicrocurriculo>();
	
	List<TbMicMicrocurriculo> microcurriculosFiltradoResponsable = new ArrayList<TbMicMicrocurriculo>();
	
	List<TbMicMicrocurriculo> microcurriculosFiltradoEstado = new ArrayList<TbMicMicrocurriculo>();

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
	

	public void onClick$btnBuscar(){
		if(!"[Seleccione]".equals(cmbMateria.getValue().toString())&&(!"".equals(cmbMateria.getValue().toString()))){
			String busca = cmbMateria.getValue().toString();
			busca = busca + "%";
			consultarMicrocurriculos(busca);
		}else{
			if(!"[Seleccione]".equals(cmbNucleo.getValue().toString())&&(!"".equals(cmbNucleo.getValue().toString()))){
				String busca = cmbNucleo.getValue().toString();
				busca = busca + "%";
				consultarMicrocurriculos(busca);
			}else{
				if(!"[Seleccione]".equals(cmbDependencia.getValue().toString())&&(!"".equals(cmbDependencia.getValue().toString()))){
					String busca = cmbDependencia.getValue().toString();
					busca = busca + "%";
					consultarMicrocurriculos(busca);
				}else{
					if(!"[Seleccione]".equals(cmbUnidadAcademica.getValue().toString())&&(!"".equals(cmbUnidadAcademica.getValue().toString()))){
						String busca = cmbUnidadAcademica.getValue().toString();
						busca = busca + "%";
						consultarMicrocurriculos(busca);
					}else{
						consultarMicrocurriculos("%");
					}
				}
			}
		}
		filtrarMicrocurriculosPorSemestre();
		filtrarMicrocurriculosPorResponsable();
		filtrarMicrocurriculosPorEstado();
		listarMicrocurriculos();
		//cargarMicrocurriculos(cmbMateria.getValue());
	}
	
	public void consultarMicrocurriculos(String MateriaBuscar){
		try{
			
			microcurriculosEncontrados = microcurriculoNGC.listarMicrocurriculosPorMateria(MateriaBuscar);
			listaMicrocurriculo.getItems().clear();
			
		}catch(ExcepcionesLogica e){
			e.printStackTrace();
		}
	}
	
	public void filtrarMicrocurriculosPorSemestre(){
		microcurriculosFiltradoSemestre.clear();
		if("[Seleccione]".equals(cmbSemestre.getValue().toString()) || ("".equals(cmbSemestre.getValue().toString()))){
			microcurriculosFiltradoSemestre = microcurriculosEncontrados;
		}else{
			if(microcurriculosEncontrados != null){
				String semestre = cmbSemestre.getValue().toString();
				for(TbMicMicrocurriculo microcurriculo: microcurriculosEncontrados){
					if(microcurriculo.getTbAdmSemestre().getVrIdsemestre().equals(semestre)){
						microcurriculosFiltradoSemestre.add(microcurriculo);
					}
				}
			}
		}
	}
	
	public void filtrarMicrocurriculosPorResponsable(){
		microcurriculosFiltradoResponsable.clear();
		if("[Seleccione]".equals(cmbDocente.getValue().toString()) || ("".equals(cmbDocente.getValue().toString()))){
			microcurriculosFiltradoResponsable = microcurriculosFiltradoSemestre;
		}else{
			if(microcurriculosFiltradoSemestre != null){
				String docente = cmbDocente.getValue().toString();
				for(TbMicMicrocurriculo microcurriculo: microcurriculosFiltradoSemestre){
					if(microcurriculo.getTbAdmPersona().getVrIdpersona().equals(docente)){
						microcurriculosFiltradoResponsable.add(microcurriculo);
					}
				}
			}
		}
	}
	
	public void filtrarMicrocurriculosPorEstado(){
		List<TbMicMicroxestado> consultaMicrosxEstado = null;
		microcurriculosFiltradoEstado.clear();
		if("[Seleccione]".equals(cmbEstado.getValue().toString()) || ("".equals(cmbEstado.getValue().toString()))){
			microcurriculosFiltradoEstado = microcurriculosFiltradoResponsable;
		}else{
			int estado = Integer.parseInt(cmbEstado.getValue().toString());
			try {
				consultaMicrosxEstado = microxEstadoNGC.listarMicrosxestado(estado);
			} catch (ExcepcionesLogica e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(microcurriculosFiltradoResponsable != null){
				for(TbMicMicrocurriculo microcurriculo: microcurriculosFiltradoResponsable){
					for(TbMicMicroxestado microxEstado: consultaMicrosxEstado){
						if(microcurriculo.getVrIdmicrocurriculo().equals(microxEstado.getTbMicMicrocurriculo().getVrIdmicrocurriculo())){
							microcurriculosFiltradoEstado.add(microcurriculo);
						}
					}
				}
			}
		}
	}
	
	public void listarMicrocurriculos(){
		if(microcurriculosFiltradoEstado != null){
			for(TbMicMicrocurriculo micro: microcurriculosFiltradoEstado){
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
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		
		super.doAfterCompose(comp);
			
	}
}
