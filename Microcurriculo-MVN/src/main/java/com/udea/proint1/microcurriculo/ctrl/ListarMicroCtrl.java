package com.udea.proint1.microcurriculo.ctrl;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;



/**
 * 
 * @author Elmer Urrea y Edwin Acosta
 * Controlador para la vista listamic.zul, cuyo objetivo es facilitar la busqueda de microcurriculos en los
 * registros actuales, controlando el ingreso de datos y haciendo llenado de los combobox
 *
 */
@SuppressWarnings("rawtypes")
public class ListarMicroCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(ListarMicroCtrl.class);
	
	Window formaCrearMateria;
	
	Combobox cmbMateria;
	Combobox cmbNucleo;
	Combobox cmbDependencia;
	Combobox cmbUnidadAcademica;
	Combobox cmbSemestre;
	Combobox cmbDocente;
	Combobox cmbEstado;
	
	Listbox listaMicrocurriculo;
	
	Toolbarbutton tool_details;
	Toolbarbutton tool_duplica;
	
	MicrocurriculoNGC microcurriculoNGC;
	MicroxEstadoNGC microxEstadoNGC;
	MateriaNGC materiaNGC;
	EstadoNGC estadoNGC;
	
	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicMicrocurriculo
	 * @param microcurriculoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicMicroxEstado
	 * @param microxEstadoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setMicroxEstadoNGC(MicroxEstadoNGC microxEstadoNGC) {
		this.microxEstadoNGC = microxEstadoNGC;
	}

	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbAdmMateria
	 * @param materiaNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	/**
	 * Metodo set para la inyecci�n de dependencia y gestionar datos en la tabla TbMicEstado
	 * @param estadoNGC variable de acceso a los metodos de la capa del negocio
	 */
	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}
	
	/**
	 * Solicita de la capa del negocio todos los estados existentes y los ubica en el combobox cmbEstado
	 */
	public void cargarEstados(){
		try {
			List<TbMicEstado> listaEstados = estadoNGC.listarEstados();
			cmbEstado.getItems().clear();
			
			if(listaEstados != null){
				cmbEstado.appendChild(new Comboitem("[Seleccione]"));
				for(TbMicEstado estado: listaEstados){
					Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
					item.setDescription(estado.getVrDescripcion());
					cmbEstado.appendChild(item);
				}
				cmbEstado.setValue("[Seleccione]");
			}else{
				//Messagebox.show("No se hallaron estados");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
			logger.error("error al invocar metodo listarEstados de la clase EstadoNGC: "+e);
		}
	}
	
	/**
	 * ante el evento click en el boton buscar, el metodo procede a revisar los filtros diligenciados
	 * y se muestran todos los microcurriculos relacionados con la busqueda
	 */
	public void onClick$btnBuscar(){
		List<TbMicMicrocurriculo> microcurriculosEncontrados;
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoSemestre;
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoResponsable;
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoEstado = new ArrayList<TbMicMicrocurriculo>();
		
		if(!"[Seleccione]".equals(cmbMateria.getValue().toString())&&(!"".equals(cmbMateria.getValue().toString()))){
			String busca = cmbMateria.getValue().toString();
			busca = busca + "%";
			microcurriculosEncontrados = consultarMicrocurriculos(busca);
		}else{
			if(!"[Seleccione]".equals(cmbNucleo.getValue().toString())&&(!"".equals(cmbNucleo.getValue().toString()))){
				String busca = cmbNucleo.getValue().toString();
				busca = busca + "%";
				microcurriculosEncontrados = consultarMicrocurriculos(busca);
			}else{
				if(!"[Seleccione]".equals(cmbDependencia.getValue().toString())&&(!"".equals(cmbDependencia.getValue().toString()))){
					String busca = cmbDependencia.getValue().toString();
					busca = busca + "%";
					microcurriculosEncontrados = consultarMicrocurriculos(busca);
				}else{
					if(!"[Seleccione]".equals(cmbUnidadAcademica.getValue().toString())&&(!"".equals(cmbUnidadAcademica.getValue().toString()))){
						String busca = cmbUnidadAcademica.getValue().toString();
						busca = busca + "%";
						microcurriculosEncontrados = consultarMicrocurriculos(busca);
					}else{
						microcurriculosEncontrados = consultarMicrocurriculos("%");
					}
				}
			}
		}
		microcurriculosFiltradoSemestre = filtrarMicrocurriculosPorSemestre(microcurriculosEncontrados);
		microcurriculosFiltradoResponsable = filtrarMicrocurriculosPorResponsable(microcurriculosFiltradoSemestre);
		microcurriculosFiltradoEstado = filtrarMicrocurriculosPorEstado(microcurriculosFiltradoResponsable);
		listarMicrocurriculos(microcurriculosFiltradoEstado);
	}
	
	/**
	 * @param materiaBuscar cadena de caracteres concodigo de materia a buscar como like (coincidan primeros digitos)
	 * @return objeto array list con microcurriculos encontrados
	 */
	public List<TbMicMicrocurriculo> consultarMicrocurriculos(String materiaBuscar){
		List<TbMicMicrocurriculo> microcurriculosEncontrados = null;
		
		try{
			microcurriculosEncontrados = microcurriculoNGC.listarMicrocurriculosPorMateria(materiaBuscar);
			listaMicrocurriculo.getItems().clear();
			
		}catch(ExcepcionesLogica e){
			e.printStackTrace();
			logger.error("error al invocar metodo listarMicrocurriculosPorMateria de la clase MicrocurriculoNGC: "+e);
		}
		return microcurriculosEncontrados;
	}
	
	/**
	 * Hace la busqueda de los microcurriculos que coinciden con la busqueda de filtrado por semestre
	 * @param microcurriculosEncontrados objeto array list con microcurriculos a filtrar
	 * @return objeto array list con microcurriculos filtrados por semestre
	 */
	public List<TbMicMicrocurriculo> filtrarMicrocurriculosPorSemestre(List<TbMicMicrocurriculo> microcurriculosEncontrados){
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoSemestre = new ArrayList<TbMicMicrocurriculo>();
		
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
		return microcurriculosFiltradoSemestre;
	}
	
	/**
	 * Hace la busqueda de los microcurriculos que coinciden con la busqueda de filtrado por docente responsable
	 * @param microcurriculosFiltradoSemestre objeto array list con microcurriculos a filtrar
	 * @return objeto array list con microcurriculos filtrados por responsable del microcurriculo
	 */
	public List<TbMicMicrocurriculo> filtrarMicrocurriculosPorResponsable(List<TbMicMicrocurriculo> microcurriculosFiltradoSemestre){
		
		List<TbMicMicrocurriculo> microcurriculosFiltradoResponsable = new ArrayList<TbMicMicrocurriculo>();
		
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
		return microcurriculosFiltradoResponsable;
	}
	
	/**
	 * Hace la busqueda de los microcurriculos que coinciden con la busqueda de filtrado por estado
	 * @param microcurriculosFiltradoResponsable objeto array list con microcurriculos a filtrar
	 * @return objeto array list con microcurriculos filtrados por estado actual del microcurriculo
	 */
	public List<TbMicMicrocurriculo> filtrarMicrocurriculosPorEstado(List<TbMicMicrocurriculo> microcurriculosFiltradoResponsable){
		
		List<TbMicMicroxestado> consultaMicrosxEstado = null;
		List<TbMicMicrocurriculo> microcurriculosFiltradoEstado = new ArrayList<TbMicMicrocurriculo>();
		
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
					if(consultaMicrosxEstado != null){
						for(TbMicMicroxestado microxEstado: consultaMicrosxEstado){
							if(microcurriculo.getVrIdmicrocurriculo().equals(microxEstado.getTbMicMicrocurriculo().getVrIdmicrocurriculo())){
								microcurriculosFiltradoEstado.add(microcurriculo);
							}
						}
					}
				}
			}
		}
		return microcurriculosFiltradoEstado;
	}
	 /**
	  * Procede a mostrar el listado de los microcurriculos encontrados
	  * @param microsListar objeto array list con microcurriculos ya filtrados y los cuales se listaran
	  */
	public void listarMicrocurriculos(List<TbMicMicrocurriculo> microsListar){
		if(microsListar != null){
			List<TbMicMicroxestado> microsxEstado = null;
			
			try {
				microsxEstado = microxEstadoNGC.listarMicroxestado();
			} catch (ExcepcionesLogica e) {
				e.printStackTrace();
			}
			for(TbMicMicrocurriculo micro: microsListar){
				final Listitem listaItem = new Listitem();
				
				Listcell celdaCodigo = new Listcell(micro.getVrIdmicrocurriculo().toString());
				Listcell celdaUnidad = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
				Listcell celdaDependencia = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
				Listcell celdaNucleo = new Listcell(micro.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
				Listcell celdaMateria = new Listcell(micro.getTbAdmMateria().getVrNombre());
				Listcell celdaResponsable = new Listcell(micro.getTbAdmPersona().getVrNombres()+" "+micro.getTbAdmPersona().getVrApellidos());
				
				TbMicMicroxestado microxEstadoEncontrado = null;
				
				if(microsxEstado != null){
					for(TbMicMicroxestado microxEstado: microsxEstado){
						if(microxEstado.getTbMicMicrocurriculo().getVrIdmicrocurriculo().equals(micro.getVrIdmicrocurriculo())){
							microxEstadoEncontrado = microxEstado;
						}
					}
				}
				Listcell celdaEstado;
				if(microxEstadoEncontrado != null){
					celdaEstado = new Listcell(microxEstadoEncontrado.getTbMicEstado().getVrDescripcion());
				}else{
					celdaEstado = new Listcell("");
				}
				
				celdaCodigo.setStyle("font-size:10px");
				celdaUnidad.setStyle("font-size:10px");
				celdaDependencia.setStyle("font-size:10px");
				celdaNucleo.setStyle("font-size:10px");
				celdaMateria.setStyle("font-size:10px");
				celdaResponsable.setStyle("font-size:10px");
				celdaEstado.setStyle("font-size:10px");
				
				listaItem.appendChild(celdaCodigo);
				listaItem.appendChild(celdaUnidad);
				listaItem.appendChild(celdaDependencia);
				listaItem.appendChild(celdaNucleo);
				listaItem.appendChild(celdaMateria);
				listaItem.appendChild(celdaResponsable);
				listaItem.appendChild(celdaEstado);
				
				listaMicrocurriculo.appendChild(listaItem);
			}
		}
	}
	
//	public void onClick$tool_details(){
//		Listitem itemSelect = listaMicrocurriculo.getSelectedItem();
//		if(itemSelect != null){
//			Listcell celdaIdMicro = (Listcell) itemSelect.getChildren().get(0);
//			String idMicro = celdaIdMicro.getLabel();
//			tool_details.setHref("/microcurriculo/inicio_mic.zul");
//			
//		}else{
//			Messagebox.show("seleccione un microcurriculo de la lista");
//		}
//		
//	}
	
	/**
	 * Ante el evento click en el listbox listaMicrocurriculo, procede a generar enlaces en los botenes
	 * con funciones consultar, actualizar, duplicar e imprimir el microcurriculo seleccionado. 
	 */
	public void onClick$listaMicrocurriculo(){
		Listitem itemSelect = listaMicrocurriculo.getSelectedItem();
		if(itemSelect != null){
			Listcell celdaIdMicro = (Listcell) itemSelect.getChildren().get(0);
//			param.put(1, "dato Elmer");
//			System.out.println(param.get(1));
			String idMicro = celdaIdMicro.getLabel();
			session.setAttribute("idMicro", idMicro);
			tool_duplica.setHref("/microcurriculo/duplicarMic.zul");
		}
	}
	
	/**
	 * Metodo de inicio al cargar p�gina
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		
		super.doAfterCompose(comp);
		cargarEstados();
	}
}
