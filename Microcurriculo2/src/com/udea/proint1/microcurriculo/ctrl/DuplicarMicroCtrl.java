package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.SemestreNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DuplicarMicroCtrl extends GenericForwardComposer{
	
	private static Logger logger = Logger.getLogger(DuplicarMicroCtrl.class);
	
	Include panelDuplicarMicro;
	
	Borderlayout blyDuplicarMicro;
	
	Tabbox fichaContenidos;
	
	Panel panelSemestre;
	
	Combobox cmbSemestre2;
	Combobox cmbDocente;
	Combobox cmbSemestre;
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbMateria;
	
	Label lblIdMicrocurriculo;
	Label lblNombreUnidadAcademica;
	Label lblNombreDependencia;
	Label lblNombreNucleo;
	Label lblNombreMateria;
	Label lblCreditosMateria;
	Label lblHtMateria;
	Label lblHpMateria;
	Label lblHtpMateria;
	Label lblHoraClaseSemestral;
	Label lblCampoFormacion;
	Label lblCorrequisitos;
	Label lblPrerrequisitos;
	Label lblProgramasVinculados;
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
	Textbox txtPropositoMicro;
	Textbox txtJustificacionMicro;
	Textbox txtObjetivoGeneral;
	Textbox txtResumenMicro;
	
	Listbox listaObjetivosEspecificos;
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;
	Listbox listaCibergrafia;
	
	Toolbarbutton tool_save;
	Toolbarbutton tool_print;
	
	MicrocurriculoNGC microcurriculoNGC;
	SemestreNGC semestreNGC;
	PersonaNGC personaNGC;
	ObjetivoxMicroNGC objetivoxMicroNGC;
	CorrequisitoNGC correquisitoNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	
	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	public void setSemestreNGC(SemestreNGC semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}

	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
		this.objetivoxMicroNGC = objetivoxMicroNGC;
	}

	public void setCorrequisitoNGC(CorrequisitoNGC correquisitoNGC) {
		this.correquisitoNGC = correquisitoNGC;
	}

	public void setPrerrequisitoNGC(PrerrequisitoNGC prerrequisitoNGC) {
		this.prerrequisitoNGC = prerrequisitoNGC;
	}

	public void cargarSemestres(String idMicrocurriculo){
		TbMicMicrocurriculo microcurriculo = null;
		try {
			microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicrocurriculo);
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		String idMateria = microcurriculo.getTbAdmMateria().getVrIdmateria();
		
		List<TbMicMicrocurriculo> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		
		List<TbAdmSemestre> semestres = null;
		try {
			semestres = semestreNGC.listarSemestres();
		} catch (ExcepcionesLogica e) {
			logger.error(e);
		}
		
		cmbSemestre2.getItems().clear();
		cmbSemestre2.appendChild(new Comboitem("[Seleccione]"));
		
		if(semestres != null){
			for(TbAdmSemestre semestre: semestres){
				boolean semestreOcupado = false;
				if(listaMicrocurriculos != null){
					for(TbMicMicrocurriculo microRecorer: listaMicrocurriculos){
						if(idMateria.equals(microRecorer.getTbAdmMateria().getVrIdmateria())&&(semestre.getVrIdsemestre().equals(microRecorer.getTbAdmSemestre().getVrIdsemestre()))){
							semestreOcupado = true;
						}
					}
				}
				if(!semestreOcupado){
					Comboitem item = new Comboitem(semestre.getVrIdsemestre());
					cmbSemestre2.appendChild(item);
				}
			}
		}
		cmbSemestre2.setValue("[Seleccione]");
	}
	
	private void cargarDocentes(){
		try {
			List<TbAdmPersona> listaDocentes = personaNGC.obtenerDocentes();
			cmbDocente.getItems().clear();
			cmbDocente.appendChild(new Comboitem("[Seleccione]"));
			if (listaDocentes != null){
				for(TbAdmPersona docente : listaDocentes){
					Comboitem item = new Comboitem(docente.getVrIdpersona());
					item.setDescription(docente.getVrApellidos()+" "+docente.getVrNombres());
					cmbDocente.appendChild(item);
				}
			} else
				Messagebox.show("No Se Hallaron Registros de Docentes");
			cmbDocente.setValue("[Seleccione]");
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void llenarDatos(String idMicro, String idSemestre){
		
		TbMicMicrocurriculo microcurriculo = null;
		
		if(!idMicro.equals("") && (!idMicro.equals(null))){
			try {
				microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(idMicro);
			} catch (ExcepcionesLogica e) {
				logger.error(e);
			}
			
			if(microcurriculo!= null){
				llenarDatosDependencias(microcurriculo);
				llenarPrerrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarCorrequisitos(microcurriculo.getTbAdmMateria().getVrIdmateria());
				llenarDatosMateria(microcurriculo.getTbAdmMateria());
				cmbSemestre.setValue(idSemestre);
				cmbSemestre.setDisabled(true);
				lblIdMicrocurriculo.setValue(microcurriculo.getTbAdmMateria().getVrIdmateria()+"-"+idSemestre);
				//llenarComplementaria(microcurriculo);
			}
		}
	}
	
	public void llenarDatosDependencias(TbMicMicrocurriculo microcurriculo){
		
		cmbUnidadAcademica.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrIdunidad());
		cmbUnidadAcademica.setDisabled(true);
		lblNombreUnidadAcademica.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getTbAdmUnidadAcademica().getVrNombre());
		cmbDependencia.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrIddependencia());
		cmbDependencia.setDisabled(true);
		lblNombreDependencia.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getTbAdmDependencia().getVrNombre());
		cmbNucleo.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrIdnucleo());
		cmbNucleo.setDisabled(true);
		lblNombreNucleo.setValue(microcurriculo.getTbAdmMateria().getTbAdmNucleo().getVrNombre());
		cmbMateria.setValue(microcurriculo.getTbAdmMateria().getVrIdmateria());
		cmbMateria.setDisabled(true);
		lblNombreMateria.setValue(microcurriculo.getTbAdmMateria().getVrNombre());
		
	}
	
	public void llenarDatosMateria(TbAdmMateria materia){
		
		lblCreditosMateria.setValue(Integer.toString(materia.getNbCreditos()));
		lblHtMateria.setValue(Integer.toString(materia.getNbHt()));
		lblHpMateria.setValue(Integer.toString(materia.getNbHp()));
		lblHtpMateria.setValue(Integer.toString(materia.getNbHtp()));
		
		int ht = materia.getNbHt();
		int hp = materia.getNbHp();
		int htp = materia.getNbHtp();
		int horasSemestral = (ht+hp+htp)*16;
		
		lblHoraClaseSemestral.setValue(Integer.toString(horasSemestral));
		if((materia.getBlClasificable())==1){
			ckbClasificable.setChecked(true);
		}else if((materia.getBlClasificable())==0){
			ckbClasificable.setChecked(false);
		}
		if((materia.getBlHabilitable()) == 1){
			ckbHabilitable.setChecked(true);
		}else if((materia.getBlHabilitable()) == 0){
			ckbHabilitable.setChecked(false);
		}
		if((materia.getBlValidable()) == 1){
			ckbValidable.setChecked(true);
		}else if((materia.getBlValidable()) == 0){
			ckbValidable.setChecked(false);
		}
		
	}
	
	public void llenarCorrequisitos(String idMateria){
		String listaCorrequisitos = "";
		 
		List<TbAdmCorrequisito> correquisitos = null;
		try {
			correquisitos = correquisitoNGC.listarCorrequisitosxMateria(idMateria);
		} catch (ExcepcionesLogica e1) {
			logger.error(e1);
		}
		
		boolean bandera = true;
		for(TbAdmCorrequisito correquisito: correquisitos){
			if(bandera){
				listaCorrequisitos = correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre();
				bandera = false;
			}else{
				listaCorrequisitos = listaCorrequisitos + "\n"+(correquisito.getTbAdmMateriasByVrCorrequisito().getVrIdmateria()+" - "+correquisito.getTbAdmMateriasByVrCorrequisito().getVrNombre());
			}
		}
		lblCorrequisitos.setValue(listaCorrequisitos);
	}
	
	public void llenarPrerrequisitos(String idMateria){
		String listaPrerrequisitos = "";
		
		List<TbAdmPrerrequisito> prerrequisitos = null;
		try {
			prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(idMateria);
		} catch (ExcepcionesDAO e) {
			logger.error(e);
		}
		
		boolean bandera2 = true;
		for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
			if(bandera2){
				listaPrerrequisitos = prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre();
				bandera2 = false;
			}else{
				listaPrerrequisitos = listaPrerrequisitos + "\n"+(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
			}
		}
		lblPrerrequisitos.setValue(listaPrerrequisitos);
	}
	
//	public void llenarComplementaria(TbMicMicrocurriculo microcurriculo){
//		
//		txtJustificacionMicro.setValue(microcurriculo.getVrJustificacion());
//		txtPropositoMicro.setValue(microcurriculo.getVrProposito());
//		txtResumenMicro.setValue(microcurriculo.getVrResumen());
//		
//		List<TbMicObjetivoxmicro> objetivosxMicro = null;
//		try {
//			objetivosxMicro = objetivoxMicroNGC.obtenerObjetivosxMicroxMicro(microcurriculo.getVrIdmicrocurriculo());
//		} catch (ExcepcionesLogica e) {
//			logger.error(e);
//		}
//		if(objetivosxMicro != null){
//			for(TbMicObjetivoxmicro objetivoxMicro: objetivosxMicro){
//				if(objetivoxMicro.getBlTipo()=='1'){
//					txtObjetivoGeneral.setValue(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
//				}else{
//					final Listitem listaItem = new Listitem();
//					listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
//						@Override
//						public void onEvent(Event arg0) throws Exception {
//							eliminaListItem(listaItem,"");
//						}
//					});
//					Listcell celda = new Listcell(objetivoxMicro.getTbMicObjetivo().getVrDescripcion());
//					listaItem.appendChild(celda);			
//					listaObjetivosEspecificos.appendChild(listaItem);
//				}
//			}
//		}
//	}
	
//	private void eliminaListItem(Listitem item, String clave){		
//		if(item.getParent().getId().toString().equals("listaUnidades")){
//			eliminaCascadaUnidad(item, clave.toUpperCase());
//			item.detach();
//			recargarCombosUnidades(listaUnidades);
//		} else if (item.getParent().getId().toString().equals("listaTemas")){
//			eliminaCascadaTema(item, clave.toUpperCase());
//			item.detach();
//			recargarCombosTemas(listaTemas);
//		} else if(item.getParent().getId().toString().equals("listaSubtemas")){
//			item.detach();
//		} else if(item.getParent().getId().toString().equals("listaEvaluaciones")){
//			Listcell celdaPorcentaje = (Listcell)item.getChildren().get(1);
//			porcentajeEvaluacion = porcentajeEvaluacion - Integer.parseInt(celdaPorcentaje.getValue().toString());
//			item.detach();
//		} else if(item.getParent().getId().toString().equals("listaBibliografia")){
//			item.detach();
//		} else if(item.getParent().getId().toString().equals("listaCibergrafia")){
//			item.detach();
//		} else if(item.getParent().getId().toString().equals("listaObjetivosEspecificos")){
//			item.detach();
//		}
//	}
	
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
	
//	private void recargarCombosTemas(Listbox lista){
//		cmbListaTemas.getItems().clear();
//		
//		if(lista.getItems().size() > 0){
//			for(int i=1; i<= lista.getItemCount(); i++){
//				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
//				Listcell celda = (Listcell)listaItem.getChildren().get(0);
//				Comboitem item = new Comboitem(celda.getLabel());
//				cmbListaTemas.appendChild(item);
//			}
//		}
//	}
	
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
	
//	private void recargarCombosUnidades(Listbox lista){
//		cmbIdUnidad.getItems().clear();
//		cmbListaUnidades.getItems().clear();
//		cmbListaUnidadBiblio.getItems().clear();
//		cmbListaTemas.getItems().clear();
//
//		if (lista.getItems().size() > 0){
//			for (int i=1; i <= lista.getItems().size(); i++ ){
//				Listitem listaItem = (Listitem)lista.getChildren().get(i); 
//				Listcell celda = (Listcell)listaItem.getChildren().get(1);
//
//				Comboitem itemUnidadTema = new Comboitem(celda.getLabel());
//				cmbIdUnidad.appendChild(itemUnidadTema);
//				Comboitem item2 = new Comboitem(celda.getLabel());
//				cmbListaUnidades.appendChild(item2); 
//				Comboitem item3 = new Comboitem(celda.getLabel());
//				cmbListaUnidadBiblio.appendChild(item3);
//			}	
//		}
//			
//	}
	
	public void onSelect$cmbSemestre2(){
		String semestreDuplicar = cmbSemestre2.getValue().toString();
		if(!semestreDuplicar.equals("[Seleccione]")&&(!semestreDuplicar.equals(""))){
			session.setAttribute("semestre", semestreDuplicar);
		}else{
			if(session.hasAttribute("semestre")){
				session.removeAttribute("semestre");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		if(session.hasAttribute("idMicro")&&(session.hasAttribute("semestre"))){
			panelDuplicarMicro.setVisible(false);
			blyDuplicarMicro.setVisible(true);
			panelSemestre.setVisible(false);
			fichaContenidos.setVisible(true);
			cargarDocentes();
			
			String idMicrocurriculo = session.getAttribute("idMicro").toString();
			String idSemestre = session.getAttribute("semestre").toString();
			llenarDatos(idMicrocurriculo, idSemestre);
			
		}else if(session.hasAttribute("idMicro")){
			panelDuplicarMicro.setVisible(false);
			blyDuplicarMicro.setVisible(true);
			panelSemestre.setVisible(true);
			fichaContenidos.setVisible(false);
			String idMicrocurriculo = session.getAttribute("idMicro").toString();
			cargarSemestres(idMicrocurriculo);
			tool_print.setVisible(false);
			tool_save.setVisible(false);
		}else{
			panelDuplicarMicro.setVisible(true);
			blyDuplicarMicro.setVisible(false);
			tool_print.setVisible(false);
			tool_save.setVisible(false);
		}
		
	}
}
