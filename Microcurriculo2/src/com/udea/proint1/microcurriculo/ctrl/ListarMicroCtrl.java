//package com.udea.proint1.microcurriculo.ctrl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.zkoss.zk.ui.Component;
//import org.zkoss.zk.ui.util.GenericForwardComposer;
//import org.zkoss.zul.Button;
//import org.zkoss.zul.Combobox;
//import org.zkoss.zul.Comboitem;
//import org.zkoss.zul.Grid;
//import org.zkoss.zul.Messagebox;
//
//import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
//import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
//import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
//import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
//import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
//import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
//import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
//import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
//import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
//import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
//import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
//import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
//
//@SuppressWarnings("rawtypes")
//public class ListarMicroCtrl extends GenericForwardComposer{
//
//	private static Logger logger = Logger.getLogger(ListarMicroCtrl.class);
//	
//	
//	
//	
//	/**
//	 * Aqui se definen los objetos que componen la vista
//	 */
//	Grid grillaListado;
//	
//	Combobox cmbUnidadAcademica;
//	Combobox cmbDependencia;
//	Combobox cmbNucleo;
//	Combobox cmbSemestre;
//	Combobox cmbMateria;
//	Combobox cmbResponsable;
//
//	Button btnBuscar;
//	
//	
//	
//	/**
//	 * Se cargaran las Unidades en el Combobox de la vista
//	 */
////	private void cargarUnidades(){
////		try {
////			List<TbAdmUnidadAcademica> listaUnidadAcademica = unidadAcademicaNGC.listarUnidadAcademicas();			
////			if (listaUnidadAcademica != null){			
////				cmbUnidadAcademica.appendChild(new Comboitem("[Seleccione]"));
////				for(TbAdmUnidadAcademica unidad : listaUnidadAcademica){
////					Comboitem item = new Comboitem(unidad.getVrIdunidad());
////					cmbUnidadAcademica.appendChild(item);
////				}
////			}
////		} catch (ExcepcionesLogica e) {
////			logger.error("Se presentaron problemas al Obtener listado de la tabla <TbAdmUnidadAcademica>.  "+e);
////		}		
////	}
//	
//	public void onSelect$cmbUnidadAcademica(){
//		if (cmbUnidadAcademica.getValue().equals("[Seleccione]")){
//			cmbDependencia.getItems().clear();
//			cmbNucleo.getItems().clear();
//			cmbMateria.getItems().clear();
//			cmbSemestre.getItems().clear();
//			cmbResponsable.getItems().clear();
//			inicializarCombos();
//		}else
//			cargarDependenciasPorUnidad(cmbUnidadAcademica.getValue().toString());
//	}
//		
//	private void cargarDependenciasPorUnidad(String idUnidad){
//		try {
//			List<TbAdmDependencia> listaDependencia = dependenciaNGC.listarDependenciasPorUnidad(idUnidad);
//			if (listaDependencia != null){
//				cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
//				for (TbAdmDependencia dependencia : listaDependencia){
//					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
//					cmbDependencia.appendChild(item);
//				}
//			} else {
//				Messagebox.show("No se Encontraron Registros de Dependencias.");
//			}
//		} catch (ExcepcionesLogica e) {
//			logger.error("Se presentaron Errores al listar las Dependencias por Unidad.  "+e);
//		}
//	}
//	
////	private void cargarDependencias(){
////		try {
////			List<TbAdmDependencia> listaDependencias = dependenciaNGC.listarDependencias();
////			if (listaDependencias != null){
////				cmbDependencia.appendChild(new Comboitem("[Seleccione]"));
////				for(TbAdmDependencia dependencia : listaDependencias){
////					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
////					cmbDependencia.appendChild(item);
////				}
////			}
////		} catch (ExcepcionesLogica e) {
////			logger.error("Se presentaron Errores al listar las Dependencias por Unidad.  "+e);
////		}
////		
////	}
//	
//	public void onSelect$cmbDependencia(){
//		cargarNucleosPorDependencia(cmbDependencia.getValue());
//		
//	}
//	
//	public void onClick$cmbDependencia(){
//		if(cmbDependencia.getValue().equals("[Seleccione]") && (cmbDependencia.getItemCount() > 1)){
//			cargarDependencias();
//		}else
//			cargarNucleosPorDependencia(cmbDependencia.getValue());
//	}
//	
//	private void cargarNucleosPorDependencia(String idDependencia){
//		try {
//			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleosPorDependencia(idDependencia);
//			if(listaNucleos != null){
//				cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
//				for(TbAdmNucleo nucleo : listaNucleos){
//					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
//					cmbNucleo.appendChild(item);
//				}
//			} else
//				System.out.println("La lista esta vacia");
//			
//		} catch (ExcepcionesLogica e) {
//			logger.error("Se presentaron Errores al listar los Nucleos por Dependencias.  "+e);
//		}
//	}
//	
////	private void cargarNucleos(){
////		try {
////			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
////			if (listaNucleos != null){
////				cmbNucleo.appendChild(new Comboitem("[Seleccione]"));
////				for(TbAdmNucleo nucleo : listaNucleos){
////					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
////					cmbNucleo.appendChild(item);
////				}
////			}
////		} catch (ExcepcionesLogica e) {
////			logger.error("Se presentaron Errores al listar los registros de la tabla Nucleos.  "+e);
////		}
////		
////	}
//	
//	public void onSelect$cmbNucleo(){
//		cargarMateriasPorNucleo(cmbNucleo.getValue());
//	}
//	
//	private void cargarMateriasPorNucleo(String nucleo){
//		try {
//			List<TbAdmMateria> listaMaterias = materiaNGC.listarMateriasxNucleo(nucleo);
//			cmbMateria.appendChild(new Comboitem("[Seleccione]"));
//			if (listaMaterias != null){
//				for(TbAdmMateria materia : listaMaterias){
//					Comboitem item = new Comboitem(materia.getVrIdmateria());
//					cmbMateria.appendChild(item);
//				}
//			}
//		} catch (ExcepcionesLogica e) {
//			logger.error("Se presentaron Errores al listar las Materias por Nucleos.  "+e);
//		}
//	}
//	
//	
//	private void cargarSemestres(){
//		try {
//			List<TbAdmSemestre> listaSemestre = semestreNGC.listarSemestres();
//			if (listaSemestre != null){
//				cmbSemestre.appendChild(new Comboitem("[Seleccione]"));
//				for (TbAdmSemestre semestre : listaSemestre){
//					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
//					cmbSemestre.appendChild(item);
//				}
//			} else
//				Messagebox.show("No se Encontraron Registros de Semestres");
//		} catch (ExcepcionesLogica e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void onSelect$btnBuscar(){
//		
//	}
//	
////	private String crearCadenaBusqueda(){
////		String cadena = null;
////		if(){
////			
////		}
////		
////		return cadena;
////	}
//	
//	private void inicializarCombos(){
//		String cadenaInicial = "[Seleccione]";
//		cmbUnidadAcademica.setValue(cadenaInicial);
//		cmbDependencia.setValue(cadenaInicial);
//		cmbNucleo.setValue(cadenaInicial);
//		cmbSemestre.setValue(cadenaInicial);
//		cmbMateria.setValue(cadenaInicial);
//		cmbResponsable.setValue(cadenaInicial);		
//	}
//	
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	public void doAfterCompose(Component comp) throws Exception {		
//		
//		super.doAfterCompose(comp);
//		inicializarCombos();
//		cargarUnidades();
//		cargarSemestres();
//		
//	}
//}
