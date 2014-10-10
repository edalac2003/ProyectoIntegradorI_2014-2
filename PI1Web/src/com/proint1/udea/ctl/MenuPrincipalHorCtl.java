package com.proint1.udea.ctl;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;

public class MenuPrincipalHorCtl  extends GenericForwardComposer{
	
	Div divCenter;
	 
	private static Logger logger=Logger.getLogger(MenuPrincipalHorCtl.class);
	
	public void onCreate(){
	}

	public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        logger.info("cargando MenuPrincipalHorCtl");
   }
	
	public void onClick$btnAdministracion() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/administracion/vista/consultarPersona.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("com.proint1.udea.administracion.vista.consultarPersona.zul");
	}
	
	public void onClick$btnIngresarCurriculo() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/crearMicroCurriculo.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnAprobarCurriculo() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/aprobarMicroCurriculo.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnDevolverCurriculo() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/devolverMicroCurriculo.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnDuplicarCurriculo() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/duplicarMicroCurriculo.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnActualizarCurriculo() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/actualizarMicroCurriculo.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnReporteCurriculo() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/crearReporteMicroCurriculo.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnReporteCurriculoNucleo() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/crearReporteXNucleo.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnReporteCurriculoEstado() throws IOException{
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		java.io.InputStream zulInput = this.getClass().getClassLoader().getResourceAsStream("com/proint1/udea/microcurriculo/vista/crearReporteXEstado.zul") ; 
		java.io.Reader zulReader = new java.io.InputStreamReader(zulInput);
		Window windowCenter= (Window)Executions.createComponentsDirectly(zulReader,"zul",divCenter,new HashMap()) ;	
		windowCenter.doEmbedded();
		//divCenter.setSrc("");
	}
	
	public void onClick$btnReporteActividades(){
		if(divCenter==null){
			divCenter = (Div)Sessions.getCurrent().getAttribute("divPrincipalCtl");
		}
		//iframaPrincipal.setSrc("");
	}
}
