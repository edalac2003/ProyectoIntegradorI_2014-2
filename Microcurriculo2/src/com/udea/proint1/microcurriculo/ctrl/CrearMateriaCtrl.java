package com.udea.proint1.microcurriculo.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
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
import com.udea.proint1.microcurriculo.ngc.impl.MateriasNGCImpl;
import com.udea.proint1.microcurriculo.ngc.impl.NucleoNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CrearMateriaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMateriaCtrl.class);
	
	Listbox listBoxMaterias;
	Listbox ltbNucleo;
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

	private TbAdmMaterias materiaSeleccionada;
	private List<TbAdmMaterias> listaMaterias;
	private List<TbAdmNucleo> listaNucleos;
		
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void onCreate() throws ExcepcionesLogica{
		this.cargarMaterias();
		this.cargarNucleos();
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
}

