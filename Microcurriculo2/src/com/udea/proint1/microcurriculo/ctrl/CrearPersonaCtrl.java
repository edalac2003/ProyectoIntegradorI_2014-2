package com.udea.proint1.microcurriculo.ctrl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;

import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.dto.TbAdmPais;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmTipoidentificacion;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.ngc.CiudadNGC;
import com.udea.proint1.microcurriculo.ngc.DepartamentoNGC;
import com.udea.proint1.microcurriculo.ngc.PaisNGC;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.ngc.TipoIdentificacionNGC;
import com.udea.proint1.microcurriculo.ngc.TipoPersonaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;


public class CrearPersonaCtrl extends GenericForwardComposer{

	private static Logger logger = Logger.getLogger(CrearMicroCtrl.class);
	private static String modUsuario = "SYSTEM";
	private static Date modFecha = new Date();
	
	Textbox txtBuscarNombre;
	Textbox txtApellidos;
	Textbox txtNombres;
	Textbox txtDireccion;
	Textbox txtEmail;
	Intbox txtNumeroID;
	Intbox txtTelefono;
	
	Listbox listaPersona;	
	
	Combobox cmbTipoID;
	Combobox cmbPais;
	Combobox cmbDepartamento;
	Combobox cmbCiudad;
	Combobox cmbEstado;
	Combobox cmbRol;
	
	Toolbarbutton tool_new;
	Toolbarbutton tool_save;
	Toolbarbutton tool_reload;
	
	private static List<TbAdmPersona> listadoPersona = null;
	private static List<TbAdmPais> listadoPaises = null;
	private static List<TbAdmDepartamento> listadoDepartamentos = null;
	private static List<TbAdmCiudad> listadoCiudades = null;
	private static List<TbAdmTipoidentificacion> listadoTipoID = null;
	private static List<TbAdmTipopersona> listadoTipoPersona = null;
	
	
	PaisNGC paisNGC;
	DepartamentoNGC departamentoNGC;
	CiudadNGC ciudadNGC;
	PersonaNGC personaNGC;
	TipoIdentificacionNGC tipoIdentificacionNGC;
	TipoPersonaNGC tipoPersonaNGC;
	
	public void setPersonaNGC(PersonaNGC personaNGC) {
		this.personaNGC = personaNGC;
	}
	
	public void setCiudadNGC(CiudadNGC ciudadNGC) {
		this.ciudadNGC = ciudadNGC;
	}

	public void setPaisNGC(PaisNGC paisNGC) {
		this.paisNGC = paisNGC;
	}

	public void setDepartamentoNGC(DepartamentoNGC departamentoNGC) {
		this.departamentoNGC = departamentoNGC;
	}

	public void setTipoIdentificacionNGC(TipoIdentificacionNGC tipoIdentificacionNGC) {
		this.tipoIdentificacionNGC = tipoIdentificacionNGC;
	}
	
	public void setTipoPersonaNGC(TipoPersonaNGC tipoPersonaNGC) {
		this.tipoPersonaNGC = tipoPersonaNGC;
	}
	

	public void onClick$tool_reload(){
		cargarListaPersona();
	}
	
	public void onClick$tool_save(){
		TbAdmPersona persona = empaquetarPersona();
		
		try {
			personaNGC.guardarPersona(persona);
			Messagebox.show("Registro Guardado Exitosamente.","Almacenado",Messagebox.OK,Messagebox.INFORMATION);
		} catch (ExcepcionesLogica e) {
			Messagebox.show("Se presentaron errores al Guardar el registro de Persona.","Error",Messagebox.OK,Messagebox.ERROR);
			logger.error("Se presentaron errores al Guardar el registro de Persona. "+e);
		}
		
			
	}
	
	public void onClick$tool_new(){
		limpiarCampos();
		cmbTipoID.focus();
	}
	
	
	private void limpiarCampos(){
		txtBuscarNombre.setValue("");
		txtNumeroID.setText("");;
		txtApellidos.setValue("");
		txtNombres.setValue("");
		txtDireccion.setValue("");
		txtTelefono.setText("");
		txtEmail.setValue("");
		cmbTipoID.setValue("");
		cmbCiudad.setValue("");
		cmbEstado.setValue("");
		cmbRol.setValue("");
	}
	
	
	private void cargarListaPersona(){
		try {
			listadoPersona = personaNGC.listarPersonas();
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron errores al intentar obtener el listado de Personas." + e.getMessage());
		}

		listaPersona.getItems().clear();
		if(listadoPersona != null){			
			for(TbAdmPersona persona : listadoPersona){
				if(!("".equals(persona.getVrIdpersona())) && !("USER".equals(persona.getVrNombres()))){
					if(persona.getBlEstado() == 1){
						Listitem item = new Listitem();
						Listcell celdaPersona = new Listcell(persona.getVrApellidos()+" "+persona.getVrNombres());
						item.appendChild(celdaPersona);
						listaPersona.appendChild(item);
					}
				}
			}
			
		} else
			System.out.println("La lista esta vacia.");
	}
	
	private void cargarTipoID(){
		try {
			listadoTipoID = tipoIdentificacionNGC.listarTipoIdentificacion();
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron errores al listar TipoIdentificacion. "+e);
		}
		
		cmbTipoID.getItems().clear();
		if(listadoTipoID !=  null){
			for(TbAdmTipoidentificacion tipoID : listadoTipoID){
				Comboitem item = new Comboitem(tipoID.getVrDescripcion());
				cmbTipoID.appendChild(item);
			}
		}
	}
	
	
	private void cargarTipoPersona(){
		try {
			listadoTipoPersona = tipoPersonaNGC.listarTipoPersona();
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron errores para listar los Tipos de Persona. "+e);
		}
		
		cmbRol.getItems().clear();
		if(listadoTipoPersona != null){
			for(TbAdmTipopersona tipoPersona : listadoTipoPersona){
				Comboitem item = new Comboitem(tipoPersona.getVrDescripcion());
				cmbRol.appendChild(item);
			}
		}
	}
	
	
	private void cargarPaises(){
		try {
			listadoPaises = paisNGC.listarPaises();
		} catch (ExcepcionesLogica e) {
			logger.error("Error al Intentar Obtener el Listado de Paises. "+e);
		}
		
		cmbPais.getItems().clear();
		if(listadoPaises != null){
			for(TbAdmPais pais : listadoPaises){
				Comboitem item = new Comboitem(pais.getVrNombre());
				cmbPais.appendChild(item);
			}
		}
	}
	
	private void cargarDepartamentos(TbAdmPais idPais){
		try {
			listadoDepartamentos = departamentoNGC.listarDepartamentosxPais(idPais);
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron errores al Listar los Departamentos. "+e);
		}
		cmbPais.getItems().clear();
		if(listadoDepartamentos != null){
			for(TbAdmDepartamento departamento : listadoDepartamentos){
				Comboitem item = new Comboitem(departamento.getVrNombres());
				cmbDepartamento.appendChild(item);
			}
		}
	}
	
	private void cargarCiudades(TbAdmDepartamento idDepartamento){
		
		try {
			listadoCiudades = ciudadNGC.listarCiudadesxDepartamento(idDepartamento);
		} catch (ExcepcionesLogica e) {
			logger.error("Se presentaron errores al intentar listar las Ciudades. "+e);
		}
		
		cmbCiudad.getItems().clear();
		if(listadoCiudades != null){
			for(TbAdmCiudad ciudad : listadoCiudades){
				Comboitem item = new Comboitem(ciudad.getVrNombre());				
				cmbCiudad.appendChild(item);
			}
		}
	}
	
	private TbAdmPersona empaquetarPersona(){
		TbAdmPersona persona = null;
		int estado = 0;
		if (comprobarCampos()){
			if("ACTIVADO".equals(cmbEstado.getValue()))
				estado = 1;
			else if ("DESACTIVADO".equals(cmbEstado.getValue()))
				estado = 0;
				
			persona = new TbAdmPersona();
			persona.setVrIdpersona(txtNumeroID.getText());
			persona.setVrNombres(txtNombres.getValue());
			persona.setVrApellidos(txtApellidos.getValue());
			persona.setVrEmail(txtEmail.getValue());
			persona.setVrTelefono(txtTelefono.getText());
			persona.setTbAdmCiudad(listadoCiudades.get(cmbCiudad.getSelectedIndex()));
			persona.setTbAdmTipoidentificacion(listadoTipoID.get(cmbTipoID.getSelectedIndex()));
			persona.setTbAdmTipopersona(listadoTipoPersona.get(cmbRol.getSelectedIndex()));
			persona.setVrModusuario(modUsuario);
			persona.setDtModfecha(modFecha);
		}else{
			
		}
		
		return persona;
	}
	
	private boolean comprobarCampos(){
		Boolean estado = false;
		if(txtNumeroID.getValue() > 0){
			if (txtApellidos.getValue().trim().length() > 0){
				if (txtNombres.getValue().trim().length() > 0){
					if (txtDireccion.getValue().trim().length() > 0){
						if (txtTelefono.getValue() > 0){
							if (cmbCiudad.getValue().trim().length() > 0){
								if (txtEmail.getValue().trim().length() > 0){
									if (cmbEstado.getValue().trim().length() > 0){
										if (cmbEstado.getValue().trim().length() > 0){
											estado = true;
										}
										
									}
									
								}
								
							}
							
						}
						
					}
					
				}
				
			}
		}
		
		return estado;
	}
	
	//*************************************************************************************************************
	//MANEJO DE EVENTOS
	//*************************************************************************************************************
	
	public void onSelect$cmbPais(){
		cargarDepartamentos(listadoPaises.get(cmbPais.getSelectedIndex()));
		cmbDepartamento.focus();
	}
	
	public void onOK$cmbPais(){
		cargarDepartamentos(listadoPaises.get(cmbPais.getSelectedIndex()));
		cmbDepartamento.focus();
	}
	
	public void onSelect$cmbDepartamento(){
		cargarCiudades(listadoDepartamentos.get(cmbDepartamento.getSelectedIndex()));
		cmbCiudad.focus();
	}
	
	public void onSelect$cmbCiudad(){
		txtEmail.focus();
	}
	
	public void onSelect$cmbTipoID(){
		txtNumeroID.focus();
	}
	
	public void onOK$txtNumeroID(){
		txtApellidos.focus();
	}
	
	public void onOK$txtApellidos(){
		txtApellidos.setValue(txtApellidos.toString().toUpperCase());
		txtNombres.focus();
	}
	
	public void onOK$txtNombres(){
		txtNombres.setValue(txtNombres.toString().toUpperCase());
		txtDireccion.focus();
	}
	
	public void onOK$txtDireccion(){
		txtTelefono.focus();
	}
	
	public void onOK$txtTelefono(){
		cmbPais.focus();
	}
	
	
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		if("crearPersona".equals(comp.getParent().getId())){
			cargarTipoID();
			cargarListaPersona();
			cargarPaises();
			cargarTipoPersona();
		}
		
		
	}

}
