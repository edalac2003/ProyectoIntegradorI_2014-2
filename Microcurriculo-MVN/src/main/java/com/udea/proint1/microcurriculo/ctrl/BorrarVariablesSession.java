package com.udea.proint1.microcurriculo.ctrl;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class BorrarVariablesSession extends GenericForwardComposer{
	
	private static Logger logger = Logger.getLogger(BorrarVariablesSession.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {				
		super.doAfterCompose(comp);
		session.removeAttribute("idMicro");
		session.removeAttribute("semestre");
	}
}
