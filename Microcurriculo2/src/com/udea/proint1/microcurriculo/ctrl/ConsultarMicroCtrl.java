package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamentos;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.ngc.CorrequisitosNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadosNGC;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculosNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitosNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ConsultarMicroCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMicroCtrl.class);
	
	Combobox cmbIdUnidadAcademica;
	Combobox cmbIdDepartamento;
	Combobox cmbIdNucleo;
	Combobox cmbIdMateria;
	Combobox cmbIdEstado;
	Combobox cmbIdMicrocurriculo;
	
	Label lblNbreUnidadAcademica;
	Label lblNbreDepartamento;
	Label lblNbreNucleo;
	Label lblNbreMateria;
	Label lblNbreEstado;
	
	Label lblNombreDocente;
	Label lblSemestre;
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
	
	Checkbox ckbValidable;
	Checkbox ckbHabilitable;
	Checkbox ckbClasificable;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	NucleoNGC nucleoNGC;
	DependenciaNGC dependenciaNGC;
	MateriasNGC materiasNGC;
	MicrocurriculosNGC microcurriculosNGC;
	EstadosNGC estadosNGC;
	CorrequisitosNGC correquisitosNGC;
	PrerrequisitosNGC prerrequisitosNGC;

	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}

	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}

	public void setMateriasNGC(MateriasNGC materiasNGC) {
		this.materiasNGC = materiasNGC;
	}

	public void setMicrocurriculosNGC(MicrocurriculosNGC microcurriculosNGC) {
		this.microcurriculosNGC = microcurriculosNGC;
	}

	public void setEstadosNGC(EstadosNGC estadosNGC) {
		this.estadosNGC = estadosNGC;
	}

	public void setCorrequisitosNGC(CorrequisitosNGC correquisitosNGC) {
		this.correquisitosNGC = correquisitosNGC;
	}

	public void setPrerrequisitosNGC(PrerrequisitosNGC prerrequisitosNGC) {
		this.prerrequisitosNGC = prerrequisitosNGC;
	}

	public void cargarUnidadesAcademicas(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadesAca = unidadAcademicaNGC.listarUnidadAcademicas();
			cmbIdUnidadAcademica.getItems().clear();
			
			if(listaUnidadesAca != null){
				for(TbAdmUnidadAcademica unidad: listaUnidadesAca){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					cmbIdUnidadAcademica.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron unidades academicas");
			}
			//String nombre = cmbNbreUnidadAcademica.getValue().toString();
			//System.out.println("atributo: "+nombre);
			//lblCorrequisitos.setValue(nombre);
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarDepartamentos(){
		try {
			List<TbAdmDependencia> listaDepartamentos = dependenciaNGC.listarDependencias();
			cmbIdDepartamento.getItems().clear();
			
			if(listaDepartamentos != null){
				for(TbAdmDependencia departamento: listaDepartamentos){
					Comboitem item = new Comboitem(departamento.getVrIddependencia());
					cmbIdDepartamento.appendChild(item);
				}
			}else{
				
			}
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarNucleos(){
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			cmbIdNucleo.getItems().clear();
			
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo: listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					cmbIdNucleo.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarMaterias(){
		try {
			List<TbAdmMaterias> listaMaterias = materiasNGC.listarMaterias();
			cmbIdMateria.getItems().clear();
			
			if(listaMaterias != null){
				for(TbAdmMaterias materia: listaMaterias){
					Comboitem item = new Comboitem(materia.getVrIdmateria());
					cmbIdMateria.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron materias");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarMicrocurriculos(){
		try {
			List<TbMicMicrocurriculos> listaMicrocurriculos = microcurriculosNGC.listarMicrocurriculos();
			cmbIdMicrocurriculo.getItems().clear();
			
			if(listaMicrocurriculos != null){
				for(TbMicMicrocurriculos microcurriculo: listaMicrocurriculos){
					Comboitem item = new Comboitem(microcurriculo.getVrIdmicrocurriculo());
					cmbIdMicrocurriculo.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron microcurriculos");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarEstados(){
		try {
			List<TbMicEstados> listaEstados = estadosNGC.listarEstados();
			cmbIdEstado.getItems().clear();
			
			if(listaEstados != null){
				for(TbMicEstados estado: listaEstados){
					Comboitem item = new Comboitem(Integer.toString(estado.getNbIdestado()));
					cmbIdEstado.appendChild(item);
				}
			}else{
				//Messagebox.show("No se hallaron estados");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdUnidadAcademica(){
		String id = cmbIdUnidadAcademica.getValue().toString();
		try {
			TbAdmUnidadAcademica unidadAcademica = unidadAcademicaNGC.obtenerUnidadAcademica(id);
			lblNbreUnidadAcademica.setValue(unidadAcademica.getVrNombre());
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdEstado(){
		int id = Integer.parseInt(cmbIdEstado.getValue().toString());
		try {
			TbMicEstados estado = estadosNGC.obtenerEstados(id);
			lblNbreEstado.setValue(estado.getVrDescripcion());
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdDepartamento(){
		String id = cmbIdDepartamento.getValue().toString();
		try {
			TbAdmDependencia departamento = dependenciaNGC.obtenerDependencia(id);
			lblNbreDepartamento.setValue(departamento.getVrNombre());
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onSelect$cmbIdMateria(){
		String id = cmbIdMateria.getValue().toString();
		try {
			TbAdmMaterias materia = materiasNGC.obtenerMateria(id);
			lblNbreMateria.setValue(materia.getVrNombre());
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdNucleo(){
		String id = cmbIdNucleo.getValue().toString();
		try {
			TbAdmNucleo nucleo = nucleoNGC.obtenerNucleo(id);
			lblNbreNucleo.setValue(nucleo.getVrNombre());
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdMicrocurriculo(){
		String id = cmbIdMicrocurriculo.getValue().toString();
		obtenerMicro(id);
	}
	
	public void obtenerMicro(String id){
		try {
			TbMicMicrocurriculos microcurriculo = microcurriculosNGC.obtenerMicrocurriculos(id);
			lblNombreDocente.setValue("");
			lblSemestre.setValue("");
			lblCreditosMateria.setValue(Integer.toString(microcurriculo.getTbAdmMaterias().getNbCreditos()));
			int ht = microcurriculo.getTbAdmMaterias().getNbHt();
			int hp = microcurriculo.getTbAdmMaterias().getNbHp();
			int htp = microcurriculo.getTbAdmMaterias().getNbHtp();
			int horasSemestral = (ht+hp+htp)*16;
			lblHtMateria.setValue(Integer.toString(ht));
			lblHpMateria.setValue(Integer.toString(hp));
			lblHtpMateria.setValue(Integer.toString(htp));
			lblHoraClaseSemestral.setValue(Integer.toString(horasSemestral));
			
			if((microcurriculo.getTbAdmMaterias().getBlClasificable())==1){
				ckbClasificable.setChecked(true);
			}
			if((microcurriculo.getTbAdmMaterias().getBlHabilitable()) == 1){
				ckbHabilitable.setChecked(true);
			}
			if((microcurriculo.getTbAdmMaterias().getBlValidable()) == 1){
				ckbValidable.setChecked(true);
			}
			String listaCorrequisitos = "";
			String listaPrerrequisitos = "";
			
			String idMateria = microcurriculo.getTbAdmMaterias().getVrIdmateria(); 
			List<TbAdmCorrequisitos> correquisitos = correquisitosNGC.listarCorrequisitosxMateria(idMateria);
			
			for(TbAdmCorrequisitos correquisito: correquisitos){
				listaCorrequisitos = listaCorrequisitos + " "+(Integer.toString(correquisito.getNbId()));
			}
			lblCorrequisitos.setValue(listaCorrequisitos);
			
			List<TbAdmPrerrequisitos> prerrequisitos;
			try {
				prerrequisitos = prerrequisitosNGC.listarPrerrequisitosxMateria(idMateria);
			
				for(TbAdmPrerrequisitos prerrequisito: prerrequisitos){
					listaPrerrequisitos = listaPrerrequisitos + " "+(Integer.toString(prerrequisito.getNbId()));
				}
				lblPrerrequisitos.setValue(listaPrerrequisitos);
			} catch (ExcepcionesDAO e) {
				e.printStackTrace();
			}
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarUnidadesAcademicas();
		cargarDepartamentos();
		cargarNucleos();
		cargarMaterias();
		cargarMicrocurriculos();
		cargarEstados();
		System.out.println("Esta es la Ventana de Crear Microcurriculo");

	}
	
}
