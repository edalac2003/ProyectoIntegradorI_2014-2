package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import javax.mail.Message;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.ngc.impl.MateriasNGCImpl;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CrearMateriaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMateriaCtrl.class);
	
	Listbox listBoxMaterias;
	MateriasNGCImpl materiasNGC;
	private List<TbAdmMaterias> listaMaterias;
		
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}
	
	public void onCreate() throws ExcepcionesLogica{
		this.cargarMaterias();
	}

	private void cargarMaterias() throws ExcepcionesLogica {
		try {
			this.listaMaterias = materiasNGC.listarMaterias();
			for (TbAdmMaterias materia : listaMaterias) {
				Messagebox.show("Materia: " + materia.getVrNombre());
				listBoxMaterias.appendChild(new Listitem(materia.getVrNombre()));
			}
		} catch (Exception e) {
			throw new ExcepcionesLogica("No se pudo cargar la lista de materias");
		}
		
	}
	
	public MateriasNGC getMateriasNGC() {
		return materiasNGC;
	}

	public void setMateriasNGC(MateriasNGCImpl materiasNGC) {
		this.materiasNGC = materiasNGC;
	}
}
