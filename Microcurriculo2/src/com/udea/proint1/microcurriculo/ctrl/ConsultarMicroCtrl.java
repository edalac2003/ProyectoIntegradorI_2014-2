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

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
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
	MateriaNGC materiaNGC;
	MicrocurriculoNGC microcurriculoNGC;
	EstadoNGC estadoNGC;
	CorrequisitoNGC correquisitoNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	MicroxEstadoNGC microxestadoNGC;

	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}

	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}

	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	public void setMicrocurriculoNGC(MicrocurriculoNGC microcurriculoNGC) {
		this.microcurriculoNGC = microcurriculoNGC;
	}

	public void setEstadoNGC(EstadoNGC estadoNGC) {
		this.estadoNGC = estadoNGC;
	}

	public void setCorrequisitoNGC(CorrequisitoNGC correquisitoNGC) {
		this.correquisitoNGC = correquisitoNGC;
	}

	public void setPrerrequisitoNGC(PrerrequisitoNGC prerrequisitoNGC) {
		this.prerrequisitoNGC = prerrequisitoNGC;
	}

	public void setMicroxestadoNGC(MicroxEstadoNGC microxestadoNGC) {
		this.microxestadoNGC = microxestadoNGC;
	}

	/**
	 * Metodos inciales al cargar la pagina y que llenan los combobox
	 */
	
	public void cargarUnidadesAcademicas(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadesAca = unidadAcademicaNGC.listarUnidadAcademicas();
			cmbIdUnidadAcademica.getItems().clear();
			
			if(listaUnidadesAca != null){
				for(TbAdmUnidadAcademica unidad: listaUnidadesAca){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					item.setDescription(unidad.getVrNombre());
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
			List<TbAdmMateria> listaMaterias = materiaNGC.listarMaterias();
			cmbIdMateria.getItems().clear();
			
			if(listaMaterias != null){
				for(TbAdmMateria materia: listaMaterias){
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
			List<TbMicMicrocurriculo> listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculos();
			cmbIdMicrocurriculo.getItems().clear();
			
			if(listaMicrocurriculos != null){
				for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
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
			List<TbMicEstado> listaEstados = estadoNGC.listarEstados();
			cmbIdEstado.getItems().clear();
			
			if(listaEstados != null){
				for(TbMicEstado estado: listaEstados){
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
	
	/**
	 * Eventos que actualizan los combobox de acuerdo a la selección
	 */
	
	public void onSelect$cmbIdUnidadAcademica(){
		String id = cmbIdUnidadAcademica.getValue().toString();
		try {
			TbAdmUnidadAcademica unidadAcademica = unidadAcademicaNGC.obtenerUnidadAcademica(id);
			lblNbreUnidadAcademica.setValue(unidadAcademica.getVrNombre());
			recargarDepartamentos(id);
			recargarNucleos(id);
			recargarMaterias(id);
			recargarMicrocurriculos(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdEstado(){
		String id = cmbIdEstado.getValue().toString();
		int idNum = Integer.parseInt(id);
		String materia = cmbIdMateria.getValue().toString();
		try {
			TbMicEstado estado = estadoNGC.obtenerEstados(idNum);
			lblNbreEstado.setValue(estado.getVrDescripcion());
			
			if(materia.equals("")||(materia.equals(null))){
				recargarMicrosxEstado(idNum);
			}else{
				recargarMicrosxMateriasEstados(idNum, materia);
			}
			
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
			recargarNucleos(id);
			recargarMaterias(id);
			recargarMicrocurriculos(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onSelect$cmbIdMateria(){
		String id = cmbIdMateria.getValue().toString();
		try {
			TbAdmMateria materia = materiaNGC.obtenerMateria(id);
			lblNbreMateria.setValue(materia.getVrNombre());
			recargarMicrocurriculos(id);
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
			recargarMaterias(id);
			recargarMicrocurriculos(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbIdMicrocurriculo(){
		String id = cmbIdMicrocurriculo.getValue().toString();
		obtenerMicro(id);
	}
	
	/**
	 * Metodos a implementar por los eventos y que hacer el reload de los combobox
	 */
	
	public void recargarMicrosxEstado(int id){
		try {
			List<TbMicMicroxestado> listamicrosxEstado = microxestadoNGC.listarMicrosxestado(id);
			cmbIdMicrocurriculo.getItems().clear();
			
			if(listamicrosxEstado != null){
				for(TbMicMicroxestado microxEstado: listamicrosxEstado){
					Comboitem item = new Comboitem(microxEstado.getTbMicMicrocurriculo().getVrIdmicrocurriculo());
					cmbIdMicrocurriculo.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron microcurriculos");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void recargarMicrosxMateriasEstados(int id, String materia){
		try {
			List<TbMicMicroxestado> listamicrosxEstado = microxestadoNGC.listarMicrosxestado(id);
			cmbIdMicrocurriculo.getItems().clear();
			
			if(listamicrosxEstado != null){
				for(TbMicMicroxestado microxEstado: listamicrosxEstado){
					if((microxEstado.getTbMicMicrocurriculo().getTbAdmMateria().getVrIdmateria()).equals(materia)){
						Comboitem item = new Comboitem(microxEstado.getTbMicMicrocurriculo().getVrIdmicrocurriculo());
						cmbIdMicrocurriculo.appendChild(item);
					}
				}
			}else{
				Messagebox.show("No se hallaron microcurriculos");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void recargarDepartamentos(String buscaDepartamentos){
		try {
			buscaDepartamentos = buscaDepartamentos + "%";
			List<TbAdmDependencia> listaDependencias = dependenciaNGC.obtenerDependencia(buscaDepartamentos);
			cmbIdDepartamento.getItems().clear();
			
			if(listaDependencias != null){
				for(TbAdmDependencia dependencia: listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					cmbIdDepartamento.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron departamentos");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void recargarNucleos(String buscaNucleos){
		try {
			buscaNucleos = buscaNucleos+"%";
			List<TbAdmNucleo> listaNucleos = nucleoNGC.buscarNucleos(buscaNucleos);
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
	
	public void recargarMaterias(String buscaMaterias){
		try {
			buscaMaterias = buscaMaterias + "%";
			List<TbAdmMateria> listaMaterias = materiaNGC.buscarMaterias(buscaMaterias);
			cmbIdMateria.getItems().clear();
			
			if(listaMaterias != null){
				for(TbAdmMateria materia: listaMaterias){
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
	
	public void recargarMicrocurriculos(String buscaMicrocurriculos){
		try {
			buscaMicrocurriculos = buscaMicrocurriculos + "%";
			List<TbMicMicrocurriculo> listaMicrocurriculos = microcurriculoNGC.listarMicrocurriculosPorMateria(buscaMicrocurriculos);
			cmbIdMicrocurriculo.getItems().clear();
			
			if(listaMicrocurriculos != null){
				for(TbMicMicrocurriculo microcurriculo: listaMicrocurriculos){
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
	
	/**
	 * Metodo implementado para llenar los espacios en el microcurriculo a consultar
	 */
	
	public void obtenerMicro(String id){
		try {
			TbMicMicrocurriculo microcurriculo = microcurriculoNGC.obtenerMicrocurriculos(id);
			lblNombreDocente.setValue("");
			lblSemestre.setValue("");
			lblCreditosMateria.setValue(Integer.toString(microcurriculo.getTbAdmMateria().getNbCreditos()));
			int ht = microcurriculo.getTbAdmMateria().getNbHt();
			int hp = microcurriculo.getTbAdmMateria().getNbHp();
			int htp = microcurriculo.getTbAdmMateria().getNbHtp();
			int horasSemestral = (ht+hp+htp)*16;
			lblHtMateria.setValue(Integer.toString(ht));
			lblHpMateria.setValue(Integer.toString(hp));
			lblHtpMateria.setValue(Integer.toString(htp));
			lblHoraClaseSemestral.setValue(Integer.toString(horasSemestral));
			
			if((microcurriculo.getTbAdmMateria().getBlClasificable())==1){
				ckbClasificable.setChecked(true);
			}
			if((microcurriculo.getTbAdmMateria().getBlHabilitable()) == 1){
				ckbHabilitable.setChecked(true);
			}
			if((microcurriculo.getTbAdmMateria().getBlValidable()) == 1){
				ckbValidable.setChecked(true);
			}
			String listaCorrequisitos = "";
			String listaPrerrequisitos = "";
			
			String idMateria = microcurriculo.getTbAdmMateria().getVrIdmateria(); 
			List<TbAdmCorrequisito> correquisitos = correquisitoNGC.listarCorrequisitosxMateria(idMateria);
			
			for(TbAdmCorrequisito correquisito: correquisitos){
				listaCorrequisitos = listaCorrequisitos + " "+(Integer.toString(correquisito.getNbId()));
			}
			lblCorrequisitos.setValue(listaCorrequisitos);
			
			List<TbAdmPrerrequisito> prerrequisitos;
			try {
				prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(idMateria);
			
				for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
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
	
	/**
	 * Metodo principal del controlador
	 */
	
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
