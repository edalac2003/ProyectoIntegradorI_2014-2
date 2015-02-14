package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.zkoss.util.resource.Labels;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Longbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.ngc.impl.MateriaNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.SemestreNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
import com.udea.proint1.microcurriculo.util.exception.Validaciones;

public class CrearMateriaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMateriaCtrl.class);
	
	Button btnGuardar;
	Button btnActualizar;
	
	Textbox txtFiltrarMateria;
	Longbox txtCodigo;
	Textbox txtNombreMateria;
	Longbox txtSemestre;
	Longbox txtCreditos;
	Longbox txtHt;
	Longbox txtHp;
	Longbox txtHtp;
	
	Checkbox ckbHabilitable;
	Checkbox ckbValidable;
	Checkbox ckbClasificable;
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDepartamento;
	Combobox cmbNucleo;
	Combobox cmbEstado;
	
	Label lblUnidadAcademica;
	Label lblNucleo;
	Label lblDepartamento;
	Label lblCodigo;
	
	MateriaNGCImpl materiaNGC;
	NucleoNGCImpl nucleoNGC;
	SemestreNGCImpl semestreNGC;
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;

	public void setMateriaNGC(MateriaNGCImpl materiaNGC) {
		this.materiaNGC = materiaNGC;
	}

	public void setNucleoNGC(NucleoNGCImpl nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}

	public void setSemestreNGC(SemestreNGCImpl semestreNGC) {
		this.semestreNGC = semestreNGC;
	}

	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}

	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}

	private TbAdmMateria materiaSeleccionada;
	private List<TbAdmMateria> listaMaterias;
	private List<TbAdmNucleo> listaNucleos;
	private List<TbAdmSemestre> listaSemestres;
	
	public void cargarUnidadesAcademicas(){
		try {
			List<TbAdmUnidadAcademica> listaUnidadesAca = unidadAcademicaNGC.listarUnidadAcademicas();
			cmbUnidadAcademica.getItems().clear();
			
			if(listaUnidadesAca != null){
				for(TbAdmUnidadAcademica unidad: listaUnidadesAca){
					Comboitem item = new Comboitem(unidad.getVrIdunidad());
					item.setDescription(unidad.getVrNombre());
					cmbUnidadAcademica.appendChild(item);
					cmbUnidadAcademica.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron unidades academicas");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarDepartamentos(){
		try {
			List<TbAdmDependencia> listaDepartamentos = dependenciaNGC.listarDependencias();
			cmbDepartamento.getItems().clear();
			
			if(listaDepartamentos != null){
				for(TbAdmDependencia departamento: listaDepartamentos){
					Comboitem item = new Comboitem(departamento.getVrIddependencia());
					item.setDescription(departamento.getVrNombre());
					cmbDepartamento.appendChild(item);
					cmbDepartamento.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron departamentos");
			}
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarNucleos(){
		try {
			List<TbAdmNucleo> listaNucleos = nucleoNGC.listarNucleos();
			cmbNucleo.getItems().clear();
			
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo: listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
					cmbNucleo.setValue("[Seleccione]");
				}
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void cargarEstado(){
		Comboitem item = new Comboitem("Activo");
		cmbEstado.appendChild(item);
		Comboitem item2 = new Comboitem("Inactivo");
		cmbEstado.appendChild(item2);
		cmbEstado.setValue("[Seleccione]");
	}
	
	public void onSelect$cmbUnidadAcademica(){
		String id = cmbUnidadAcademica.getValue().toString();
		try {
			TbAdmUnidadAcademica unidadAcademica = unidadAcademicaNGC.obtenerUnidadAcademica(id);
			lblUnidadAcademica.setValue(unidadAcademica.getVrNombre());
			recargarDepartamentos(id);
			recargarNucleos(id);
			recargarIdMateria(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbDepartamento(){
		String id = cmbDepartamento.getValue().toString();
		try {
			TbAdmDependencia departamento = dependenciaNGC.obtenerDependencia(id);
			lblDepartamento.setValue(departamento.getVrNombre());
			recargarNucleos(id);
			recargarIdMateria(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onSelect$cmbNucleo(){
		String id = cmbNucleo.getValue().toString();
		try {
			TbAdmNucleo nucleo = nucleoNGC.obtenerNucleo(id);
			lblNucleo.setValue(nucleo.getVrNombre());
			recargarIdMateria(id);
		} catch (ExcepcionesLogica e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void recargarIdMateria(String id){
		txtCodigo.setValue(new Long(Long.parseLong(id)));
		verificarCodigo();
	}
	
	public void recargarDepartamentos(String buscaDepartamentos){
		try {
			buscaDepartamentos = buscaDepartamentos + "%";
			List<TbAdmDependencia> listaDependencias = dependenciaNGC.buscarDepedencias(buscaDepartamentos);
			cmbDepartamento.getItems().clear();
			
			if(listaDependencias != null){
				for(TbAdmDependencia dependencia: listaDependencias){
					Comboitem item = new Comboitem(dependencia.getVrIddependencia());
					item.setDescription(dependencia.getVrNombre());
					cmbDepartamento.appendChild(item);
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
			cmbNucleo.getItems().clear();
			
			if(listaNucleos != null){
				for(TbAdmNucleo nucleo: listaNucleos){
					Comboitem item = new Comboitem(nucleo.getVrIdnucleo());
					item.setDescription(nucleo.getVrNombre());
					cmbNucleo.appendChild(item);
				}
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	public void onChange$txtCodigo(){
		verificarCodigo();
	}
	
	public void verificarCodigo(){
		String codigo = Long.toString(txtCodigo.getValue());
		if(codigo.length()<8){
			lblCodigo.setValue("¡Complete codigo!");
		}else if(codigo.length()>8){
			lblCodigo.setValue("¡Codigo excede el tamaño!");
		}else{
			lblCodigo.setValue("");
		}
	}
	
	/*public void onCreate() throws ExcepcionesLogica{
		this.cargarMaterias();
		this.cargarNucleos();
		this.cargarSemestres();
	}*/

	/*private void cargarSemestres() throws ExcepcionesLogica {
		try {
			this.listaSemestres = semestreNGC.listarSemestres();
			for (TbAdmSemestre semestre : listaSemestres) {
				ltbSemestre.appendChild(new Listitem(semestre.getVrIdsemestre(), semestre.getVrIdsemestre()));
			}
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de semestres");
		}
	}*/

	/*private void cargarNucleos()throws ExcepcionesLogica{
		try {
			this.listaNucleos = nucleoNGC.listarNucleos();
			for (TbAdmNucleo nucleo : listaNucleos) {
				ltbNucleo.appendChild(new Listitem(nucleo.getVrNombre(), nucleo.getVrIdnucleo()));
			}
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de núcleos");
		}
		
	}*/
	
	/*private void cargarMaterias() throws ExcepcionesLogica {
		try {
			this.listaMaterias = materiaNGC.listarMaterias();
			listBoxMaterias.setModel(new ListModelList<TbAdmMateria>(this.listaMaterias));
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de materias");
		}
		
	}*/
	
	/**
	 * Metodo que permite filtrar la lista rapida de materias
	 */
	/*public void onChange$txtFiltrarMateria() {
		List<TbAdmMateria> listaFiltrada = new ArrayList<TbAdmMateria>();
		String filtro = this.txtFiltrarMateria.getValue().toLowerCase();
		for (TbAdmMateria materia : this.listaMaterias) {
			if (materia.getVrNombre().toLowerCase().contains(filtro)){
				listaFiltrada.add(materia);
			}
		}
		this.listBoxMaterias.setModel(new ListModelList<TbAdmMateria>(listaFiltrada));
	}*/
	
	/*public void onSelect$listBoxMaterias(){
		Set<TbAdmMateria> selection = ((Selectable<TbAdmMateria>)listBoxMaterias.getModel()).getSelection();
		this.materiaSeleccionada = selection.iterator().next();
		this.llenarDatos();
	}*/
	
	/*public void onClick$imgAddNew()  {
		this.limpiarCampos();
	}*/
	
	/*private void limpiarCampos() {
		this.ltbNucleo.setVisible(true);
		this.txtNucleo.setVisible(false);
		this.ltbSemestre.setVisible(true);
		this.txtSemestre.setVisible(false);
		ltbNucleo.clearSelection();
		limpiarCampoConstraint(txtCodigo);
		limpiarCampoConstraint(txtMateria);
		limpiarCampoConstraint(txtNucleo);
		limpiarCampoConstraint(txtSemestre);
		limpiarCampoConstraint(txtCreditos);
		txtHabilitable.setText(null);
		txtValidable.setText(null);
		txtClasificable.setText(null);
		txtHt.setText(null);
		txtHp.setText(null);
		txtHtp.setText(null);
		txtEstado.setText(null);
		
		this.btnActualizar.setVisible(false);
		this.btnGuardar.setVisible(true);
		
	}*/
	
	/**
	 * Metodo para limpiar campo TextBox con Constraint
	 * @param textbox
	 */
	private void limpiarCampoConstraint(Textbox textbox){
		if (textbox.getConstraint() != null){
			Constraint c = textbox.getConstraint();
			textbox.setConstraint((String)null);
			textbox.setText("");
			textbox.setConstraint(c);
		}
	}

	/*private void llenarDatos() {
		TbAdmNucleo nucleo = materiaSeleccionada.getTbAdmNucleo();
		this.txtNucleo.setVisible(true);
		this.ltbNucleo.setVisible(false);
		this.txtSemestre.setVisible(true);
		this.ltbSemestre.setVisible(false);
		this.txtCodigo.setText(materiaSeleccionada.getVrIdmateria());
		this.txtNucleo.setText(materiaSeleccionada.getTbAdmNucleo().getVrNombre());
		this.txtMateria.setText(materiaSeleccionada.getVrNombre());;
		this.txtSemestre.setText(materiaSeleccionada.getNbSemestre()+"");
		this.txtCreditos.setText(materiaSeleccionada.getNbCreditos()+"");
		this.txtHabilitable.setText(materiaSeleccionada.getBlHabilitable()== 1?"Si":"No");
		this.txtValidable.setText(materiaSeleccionada.getBlValidable()== 1?"Si":"No");
		this.txtClasificable.setText(materiaSeleccionada.getBlClasificable()== 1?"Si":"No");
		this.txtHt.setText(materiaSeleccionada.getNbHt()+"");
		this.txtHp.setText(materiaSeleccionada.getNbHp()+"");
		this.txtHtp.setText(materiaSeleccionada.getNbHtp()+"");
		this.txtEstado.setText(materiaSeleccionada.getBlEstado()==1?"Activa":"Inactiva");
		
		this.btnActualizar.setVisible(true);
		this.btnGuardar.setVisible(false);
		
	}*/

	/*public void onClick$btnGuardar() throws ExcepcionesLogica{
		if (!Validaciones.isTextoVacio(txtCodigo.getText())) {
			if (!Validaciones.validarSoloNumeros(txtCodigo.getText())){
				throw new WrongValueException(txtCodigo, Labels.getLabel("Formato incorrecto para el campo Código"));
			}
		}
		
		if (ltbNucleo.getSelectedItem() == null){
			throw new WrongValueException(ltbNucleo, Labels.getLabel("Por favor seleccione un núcleo"));
		}
		
		if (ltbSemestre.getSelectedItem() == null){
			throw new WrongValueException(ltbSemestre, Labels.getLabel("Por favor seleccione un semestre"));
		}
		
		if (Validaciones.isTextoVacio(txtMateria.getText())) {
			throw new WrongValueException(txtMateria, Labels.getLabel("Por favor ingrese el nombre de la materia"));
		}
		
		TbAdmMateria materia = new TbAdmMateria();
		materia.setVrIdmateria(txtCodigo.getText());
		materia.setVrNombre(txtMateria.getText());
		TbAdmNucleo nucleo = new TbAdmNucleo(ltbNucleo.getSelectedItem().getValue().toString());
		materia.setTbAdmNucleo(nucleo);
		int nbSemestre = Integer.parseInt(ltbSemestre.getSelectedItem().getValue().toString());
		materia.setNbSemestre(nbSemestre);
		try{
			materiaNGC.guardarMateria(materia);	
			Messagebox.show("Materia grabada correctamente");
			this.cargarMaterias();
			this.limpiarCampos();
		}catch(ExcepcionesLogica e){
			Messagebox.show("No se pudo guardar la materia");
			this.limpiarCampos();
		}
	}*/
	
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cargarUnidadesAcademicas();
		cargarDepartamentos();
		cargarNucleos();
		cargarEstado();
	}
}

