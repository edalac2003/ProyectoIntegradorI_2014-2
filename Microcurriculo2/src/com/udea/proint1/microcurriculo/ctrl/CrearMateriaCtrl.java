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
import org.zkoss.zul.Constraint;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.ngc.impl.MateriasNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.SemestreNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
import com.udea.proint1.microcurriculo.util.exception.Validaciones;

public class CrearMateriaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMateriaCtrl.class);
	
	Listbox listBoxMaterias;
	Listbox ltbNucleo;
	Listbox ltbSemestre;
	Button btnGuardar;
	Button btnActualizar;
	Textbox txtFiltrarMateria;
	Textbox txtCodigo;
	Textbox txtMateria;
	Textbox txtSemestre;
	Textbox txtCreditos;
	Textbox txtHabilitable;
	Textbox txtValidable;
	Textbox txtClasificable;
	Textbox txtHt;
	Textbox txtHp;
	Textbox txtHtp;
	Textbox txtEstado;
	Textbox txtNucleo;
	MateriasNGCImpl materiasNGC;
	NucleoNGCImpl nucleosNGC;
	SemestreNGCImpl semestresNGC;

	

	private TbAdmMaterias materiaSeleccionada;
	private List<TbAdmMaterias> listaMaterias;
	private List<TbAdmNucleo> listaNucleos;
	private List<TbAdmSemestre> listaSemestres;
		
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		this.cargarMaterias();
	}
	
	public void onCreate() throws ExcepcionesLogica{
		this.cargarMaterias();
		this.cargarNucleos();
		this.cargarSemestres();
	}

	private void cargarSemestres() throws ExcepcionesLogica {
		try {
			this.listaSemestres = semestresNGC.listarSemestres();
			for (TbAdmSemestre semestre : listaSemestres) {
				ltbSemestre.appendChild(new Listitem(semestre.getVrIdsemestre(), semestre.getVrIdsemestre()));
			}
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de semestres");
		}
	}

	private void cargarNucleos()throws ExcepcionesLogica{
		try {
			this.listaNucleos = nucleosNGC.listarNucleos();
			for (TbAdmNucleo nucleo : listaNucleos) {
				ltbNucleo.appendChild(new Listitem(nucleo.getVrNombre(), nucleo.getVrIdnucleo()));
			}
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de núcleos");
		}
		
	}
	
	private void cargarMaterias() throws ExcepcionesLogica {
		try {
			this.listaMaterias = materiasNGC.listarMaterias();
			listBoxMaterias.setModel(new ListModelList<TbAdmMaterias>(this.listaMaterias));
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de materias");
		}
		
	}
	
	/**
	 * Metodo que permite filtrar la lista rapida de materias
	 */
	public void onChange$txtFiltrarMateria() {
		List<TbAdmMaterias> listaFiltrada = new ArrayList<TbAdmMaterias>();
		String filtro = this.txtFiltrarMateria.getValue().toLowerCase();
		for (TbAdmMaterias materia : this.listaMaterias) {
			if (materia.getVrNombre().toLowerCase().contains(filtro)){
				listaFiltrada.add(materia);
			}
		}
		this.listBoxMaterias.setModel(new ListModelList<TbAdmMaterias>(listaFiltrada));
	}
	
	public void onSelect$listBoxMaterias(){
		Set<TbAdmMaterias> selection = ((Selectable<TbAdmMaterias>)listBoxMaterias.getModel()).getSelection();
		this.materiaSeleccionada = selection.iterator().next();
		this.llenarDatos();
	}
	
	public void onClick$imgAddNew()  {
		this.limpiarCampos();
	}
	
	private void limpiarCampos() {
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
		
	}
	
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

	private void llenarDatos() {
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
		
	}

	public void onClick$btnGuardar() throws ExcepcionesLogica{
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
		
		TbAdmMaterias materia = new TbAdmMaterias();
		materia.setVrIdmateria(txtCodigo.getText());
		materia.setVrNombre(txtMateria.getText());
		TbAdmNucleo nucleo = new TbAdmNucleo(ltbNucleo.getSelectedItem().getValue().toString());
		materia.setTbAdmNucleo(nucleo);
		int nbSemestre = Integer.parseInt(ltbSemestre.getSelectedItem().getValue().toString());
		materia.setNbSemestre(nbSemestre);
		boolean guardarConfirmacion = materiasNGC.guardarMateria(materia);
		if(guardarConfirmacion){	
			Messagebox.show("Materia grabada correctamente");
			this.cargarMaterias();
			this.limpiarCampos();
		}else{
			Messagebox.show("No se pudo guardar la materia");
			this.limpiarCampos();
		}
	}
	public MateriasNGCImpl getMateriasNGC() {
		return materiasNGC;
	}

	public void setMateriasNGC(MateriasNGCImpl materiasNGC) {
		this.materiasNGC = materiasNGC;
	}
	
	public NucleoNGCImpl getNucleosNGC() {
		return nucleosNGC;
	}

	public void setNucleosNGC(NucleoNGCImpl nucleosNGC) {
		this.nucleosNGC = nucleosNGC;
	}
	
	public SemestreNGCImpl getSemestresNGC() {
		return semestresNGC;
	}

	public void setSemestresNGC(SemestreNGCImpl semestresNGC) {
		this.semestresNGC = semestresNGC;
	}
}

