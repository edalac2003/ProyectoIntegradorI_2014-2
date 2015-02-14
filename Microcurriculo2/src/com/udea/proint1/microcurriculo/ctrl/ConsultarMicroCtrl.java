package com.udea.proint1.microcurriculo.ctrl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.CorrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.EstadoNGC;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculoNGC;
import com.udea.proint1.microcurriculo.ngc.MicroxEstadoNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivoxMicroNGC;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitoNGC;
import com.udea.proint1.microcurriculo.ngc.SubtemaxTemaNGC;
import com.udea.proint1.microcurriculo.ngc.TemaxUnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

/**
 * @author Elmer
 *
 */
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
	Label lblValidable;
	Label lblHabilitable;
	Label lblClasificable;
	Label lblPropositoMicro;
	Label lblJustificacionMicro;
	Label lblObjetivoGeneral;
	Label lblResumenMicro;
	
	Listbox listaObjetivosEspecificos;
	Listbox listaUnidades;
	Listbox listaTemas;
	Listbox listaSubtemas;
	Listbox listaEvaluaciones;
	Listbox listaBibliografia;
	Listbox listaCibergrafia;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	NucleoNGC nucleoNGC;
	DependenciaNGC dependenciaNGC;
	MateriaNGC materiaNGC;
	MicrocurriculoNGC microcurriculoNGC;
	EstadoNGC estadoNGC;
	CorrequisitoNGC correquisitoNGC;
	PrerrequisitoNGC prerrequisitoNGC;
	MicroxEstadoNGC microxestadoNGC;
	ObjetivoxMicroNGC objetivoxMicroNGC;
	UnidadxMicroNGC unidadxMicroNGC;
	TemaxUnidadNGC temaxUnidadNGC;
	SubtemaxTemaNGC subtemaxTemaNGC;
	EvaluacionxMicroNGC evaluacionxMicroNGC;
	UnidadNGC unidadNGC;
	BiblioxunidadNGC biblioxUnidadNGC;

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

	public void setObjetivoxMicroNGC(ObjetivoxMicroNGC objetivoxMicroNGC) {
		this.objetivoxMicroNGC = objetivoxMicroNGC;
	}

	public void setUnidadxMicroNGC(UnidadxMicroNGC unidadxMicroNGC) {
		this.unidadxMicroNGC = unidadxMicroNGC;
	}

	public void setTemaxUnidadNGC(TemaxUnidadNGC temaxUnidadNGC) {
		this.temaxUnidadNGC = temaxUnidadNGC;
	}

	public void setSubtemaxTemaNGC(SubtemaxTemaNGC subtemaxTemaNGC) {
		this.subtemaxTemaNGC = subtemaxTemaNGC;
	}

	public void setEvaluacionxMicroNGC(EvaluacionxMicroNGC evaluacionxMicroNGC) {
		this.evaluacionxMicroNGC = evaluacionxMicroNGC;
	}

	public void setUnidadNGC(UnidadNGC unidadNGC) {
		this.unidadNGC = unidadNGC;
	}

	public void setBiblioxUnidadNGC(BiblioxunidadNGC biblioxUnidadNGC) {
		this.biblioxUnidadNGC = biblioxUnidadNGC;
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
					item.setDescription(departamento.getVrNombre());
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
					item.setDescription(nucleo.getVrNombre());
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
					item.setDescription(materia.getVrNombre());
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
					item.setDescription(estado.getVrDescripcion());
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
			List<TbAdmDependencia> listaDependencias = dependenciaNGC.buscarDepedencias(buscaDepartamentos);
			cmbIdDepartamento.getItems().clear();
			
			if(listaDependencias != null){
				for(TbAdmDependencia dependencia: listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					item.setDescription(dependencia.getVrNombre());
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
					item.setDescription(nucleo.getVrNombre());
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
					item.setDescription(materia.getVrNombre());
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
			lblNombreDocente.setValue(microcurriculo.getTbAdmPersona().getVrIdpersona()+" - "+microcurriculo.getTbAdmPersona().getVrNombres()+" "+microcurriculo.getTbAdmPersona().getVrApellidos());
			lblSemestre.setValue(microcurriculo.getTbAdmSemestre().getVrNombre());
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
				lblClasificable.setValue("Si");
			}else if((microcurriculo.getTbAdmMateria().getBlClasificable())==0){
				lblClasificable.setValue("No");
			}
			if((microcurriculo.getTbAdmMateria().getBlHabilitable()) == 1){
				lblHabilitable.setValue("Si");
			}else if((microcurriculo.getTbAdmMateria().getBlHabilitable()) == 0){
				lblClasificable.setValue("No");
			}
			if((microcurriculo.getTbAdmMateria().getBlValidable()) == 1){
				lblValidable.setValue("Si");
			}else if((microcurriculo.getTbAdmMateria().getBlValidable()) == 0){
				lblValidable.setValue("No");
			}
			String listaCorrequisitos = "";
			String listaPrerrequisitos = "";
			
			String idMateria = microcurriculo.getTbAdmMateria().getVrIdmateria(); 
			List<TbAdmCorrequisito> correquisitos = correquisitoNGC.listarCorrequisitosxMateria(idMateria);
			
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
			
			List<TbAdmPrerrequisito> prerrequisitos;
			try {
				prerrequisitos = prerrequisitoNGC.listarPrerrequisitosxMateria(idMateria);
			
				boolean bandera2 = true;
				for(TbAdmPrerrequisito prerrequisito: prerrequisitos){
					if(bandera2){
						listaPrerrequisitos = prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre();
						bandera2 = false;
					}else{
						listaPrerrequisitos = listaCorrequisitos + "\n"+(prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrIdmateria()+" - "+prerrequisito.getTbAdmMateriasByVrPrerrequisito().getVrNombre());
					}
				}
				lblPrerrequisitos.setValue(listaPrerrequisitos);
			} catch (ExcepcionesDAO e) {
				e.printStackTrace();
			}
			lblPropositoMicro.setValue(microcurriculo.getVrProposito());
			lblJustificacionMicro.setValue(microcurriculo.getVrJustificacion());
			lblResumenMicro.setValue(microcurriculo.getVrResumen());
			
			List<TbMicObjetivoxmicro> objetivosxMicro = objetivoxMicroNGC.obtenerObjetivosxMicroxMicro(id);
			
			for(TbMicObjetivoxmicro objetivo:objetivosxMicro){
				if((objetivo.getTbMicObjetivo().getBlTipo()) == '1'){
					lblObjetivoGeneral.setValue(objetivo.getTbMicObjetivo().getVrDescripcion());
				}else{
					Listitem listaItem = new Listitem();
					Listcell celda = new Listcell(objetivo.getTbMicObjetivo().getVrDescripcion());
					listaItem.appendChild(celda);			
					listaObjetivosEspecificos.appendChild(listaItem);
				}
			}
			
			List<TbMicUnidadxmicro> unidadesxMicro = unidadxMicroNGC.listarUnidadesXMicroxMicro(id);
			
			List<Integer> unidades = new ArrayList<Integer>();
			
			for(TbMicUnidadxmicro unidadxMicro: unidadesxMicro){
				
				//guardo en un array list las unidades del microcurriculo
				unidades.add(unidadxMicro.getTbMicUnidad().getNbIdunidad());
				
				Listitem listaItem = new Listitem();
				Listcell celda = new Listcell(unidadxMicro.getTbMicUnidad().getVrNombre());
				listaItem.appendChild(celda);			
				listaUnidades.appendChild(listaItem);
			}
			
			List<String> temas = new ArrayList<String>();
			
			for(int unidad : unidades){
				List<TbMicTemaxunidad> temasxUnidad = temaxUnidadNGC.ListarTemasxUnidadxUnidad(unidad);
				
				for(TbMicTemaxunidad temaxUnidad : temasxUnidad){
					//guardo en un Arraylist todos los temas pertenecientes al microcurriculo y agrego las unidades
					//concatenadas como string separadas por "-"
					
					String idTema = Integer.toString(temaxUnidad.getTbMicTema().getNbIdtema());
					String idUnidad = Integer.toString(temaxUnidad.getTbMicUnidad().getNbIdunidad());
					temas.add(idTema+"-"+idUnidad);
					
					Listitem listaItem = new Listitem();
					Listcell celda = new Listcell(temaxUnidad.getTbMicUnidad().getVrNombre());
					listaItem.appendChild(celda);
					Listcell celda2 = new Listcell(temaxUnidad.getTbMicTema().getVrDescripcion());
					listaItem.appendChild(celda2);
					Listcell celda3 = new Listcell(Integer.toString(temaxUnidad.getNbSemanasRequeridas()));
					listaItem.appendChild(celda3);			
					listaTemas.appendChild(listaItem);
				}
			}
			
			for(String tema : temas){
				//estraigo el id de tema y de unidad y los vuelvo a poner como enteros
				String []campos = tema.split("-");
				int idTemaInt = Integer.parseInt(campos[0]);
				int idUnidadInt = Integer.parseInt(campos[1]);
				
				List<TbMicSubtemaxtema> subtemasxtema = subtemaxTemaNGC.listarSubtemaxTema_Tema(idTemaInt);
				TbMicUnidad unidad = unidadNGC.obtenerUnidades(idUnidadInt);
				
				for(TbMicSubtemaxtema subtemaxTema : subtemasxtema){
					Listitem listaItem = new Listitem();
					
					Listcell celda = new Listcell(unidad.getVrNombre());
					listaItem.appendChild(celda);
					Listcell celda2 = new Listcell(subtemaxTema.getTbMicTema().getVrDescripcion());
					listaItem.appendChild(celda2);
					Listcell celda3 = new Listcell(subtemaxTema.getTbMicSubtema().getVrDescripcion());
					listaItem.appendChild(celda3);			
					listaSubtemas.appendChild(listaItem);
				}
			}
			
			List<TbMicEvaluacionxmicro> evaluacionesxMicro = evaluacionxMicroNGC.ListarEvaluacionxMicroxMicro(id);
			
			for(TbMicEvaluacionxmicro evaluacionxMicro : evaluacionesxMicro){
				Listitem listaItem = new Listitem();
				Listcell celda = new Listcell(evaluacionxMicro.getTbMicEvaluacion().getVrDescripcion());
				listaItem.appendChild(celda);
				Listcell celda2 = new Listcell(Integer.toString(evaluacionxMicro.getNbPorcentaje())+"%");
				listaItem.appendChild(celda2);
				
				//formato para fecha
				DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
				
				Listcell celda3 = new Listcell(fecha.format(evaluacionxMicro.getDtFechaestimada()));
				listaItem.appendChild(celda3);			
				listaEvaluaciones.appendChild(listaItem);
			}
			
			for(int unidad : unidades){
				List<TbMicBiblioxunidad> bibliosxUnidad = biblioxUnidadNGC.listadoBiblioxUnidad(unidad);
				
				for(TbMicBiblioxunidad biblio : bibliosxUnidad){
					if((biblio.getTbMicBibliografia().getVrSitioweb() == null)||(biblio.getTbMicBibliografia().getVrSitioweb() == "")){
						Listitem listaItem = new Listitem();
						
						Listcell celda = new Listcell(biblio.getTbMicUnidad().getVrNombre());
						listaItem.appendChild(celda);
						Listcell celda2 = new Listcell(Integer.toString(biblio.getTbMicBibliografia().getNbIdbibliografia()));
						listaItem.appendChild(celda2);
						Listcell celda3 = new Listcell(biblio.getTbMicBibliografia().getVrAutor());
						listaItem.appendChild(celda3);
						Listcell celda4 = new Listcell(biblio.getTbMicBibliografia().getVrIsbn());
						listaItem.appendChild(celda4);
						Listcell celda5 = new Listcell("");
						listaItem.appendChild(celda5);
						
						String tipo;
						if(biblio.getTbMicBibliografia().getBlTipo()=='1'){
							tipo = "básica";
						}else{
							tipo = "complementaria";
						}
						Listcell celda6 = new Listcell(tipo);
						listaItem.appendChild(celda6);
						listaBibliografia.appendChild(listaItem);
					}
				}
			}
			
			for(int unidad : unidades){
				List<TbMicBiblioxunidad> bibliosxUnidad = biblioxUnidadNGC.listadoBiblioxUnidad(unidad);
				
				for(TbMicBiblioxunidad biblio : bibliosxUnidad){
					if((biblio.getTbMicBibliografia().getVrAutor() == null)||(biblio.getTbMicBibliografia().getVrAutor() == "")){
						Listitem listaItem = new Listitem();
						
						Listcell celda1 = new Listcell(biblio.getTbMicUnidad().getVrNombre());
						listaItem.appendChild(celda1);
						Listcell celda = new Listcell(biblio.getTbMicBibliografia().getVrNombre());
						listaItem.appendChild(celda);
						Listcell celda2 = new Listcell(biblio.getTbMicBibliografia().getVrSitioweb());
						listaItem.appendChild(celda2);
						String tipo;
						if(biblio.getTbMicBibliografia().getBlTipo()=='1'){
							tipo = "básica";
						}else{
							tipo = "complementaria";
						}
						Listcell celda3 = new Listcell(tipo);
						listaItem.appendChild(celda3);
						listaCibergrafia.appendChild(listaItem);
					}
				}
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
