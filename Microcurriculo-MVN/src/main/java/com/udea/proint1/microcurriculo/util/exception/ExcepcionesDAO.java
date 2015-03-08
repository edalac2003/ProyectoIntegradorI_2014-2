package com.udea.proint1.microcurriculo.util.exception;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.ngc.impl.PersonaNGCImpl;

public class ExcepcionesDAO extends Exception {
	
	private static Logger logger=Logger.getLogger(ExcepcionesDAO.class);
	
	public ExcepcionesDAO() {
		// TODO Auto-generated constructor stub
	}

	public ExcepcionesDAO(String arg0) {
		super(arg0);
		logger.info(arg0);
	}

	public ExcepcionesDAO(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ExcepcionesDAO(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ExcepcionesDAO(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
