package com.udea.proint1.microcurriculo.ctrl;

import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.ngc.MateriaNGC;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.ngc.UnidadAcademicaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CargarDatos extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CargarDatos.class);
	
	public CargarDatos(){
		
	}
	
	Combobox cmbUnidadAcademica;
	Combobox cmbDependencia;
	Combobox cmbNucleo;
	Combobox cmbSemestre;
	Combobox cmbMateria;
	Combobox cmbDocente;
	Combobox cmbPaisBiblio;
	
	UnidadAcademicaNGC unidadAcademicaNGC;
	DependenciaNGC dependenciaNGC;
	NucleoNGC nucleoNGC;
	MateriaNGC materiaNGC;
	
	public void setUnidadAcademicaNGC(UnidadAcademicaNGC unidadAcademicaNGC) {
		this.unidadAcademicaNGC = unidadAcademicaNGC;
	}
	public void setNucleoNGC(NucleoNGC nucleoNGC) {
		this.nucleoNGC = nucleoNGC;
	}
	public void setMateriaNGC(MateriaNGC materiaNGC) {
		this.materiaNGC = materiaNGC;
	}
	
	public void setDependenciaNGC(DependenciaNGC dependenciaNGC) {
		this.dependenciaNGC = dependenciaNGC;
	}
	
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
	
	public void cargarDependencias(){
		try {
			List<TbAdmDependencia> listaDepartamentos = dependenciaNGC.listarDependencias();
			cmbDependencia.getItems().clear();
			
			if(listaDepartamentos != null){
				for(TbAdmDependencia departamento: listaDepartamentos){
					Comboitem item = new Comboitem(departamento.getVrIddependencia());
					item.setDescription(departamento.getVrNombre());
					cmbDependencia.appendChild(item);
					cmbDependencia.setValue("[Seleccione]");
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
				}
				cmbNucleo.setValue("[Seleccione]");
			}else{
				Messagebox.show("No se hallaron nucleos");
			}
			
		} catch (ExcepcionesLogica e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		
	}
	
}
