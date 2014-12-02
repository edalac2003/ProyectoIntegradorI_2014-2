package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmAuditoria {

	private int nbId;
	private TbAdmNucleo tbAdmNucleo;
	private TbAdmPersona tbAdmPersona;
	private String vrModusuario;
	private String vrOficina;
	private String vrHorarioatencion;
	private String vrHorarioclases;
	private Date vrModfecha;

	public TbAdmDocentesxnucleo() {
	}

	public TbAdmDocentesxnucleo(int nbId, TbAdmNucleo tbAdmNucleo,
			TbAdmPersona tbAdmPersona) {
		this.nbId = nbId;
		this.tbAdmNucleo = tbAdmNucleo;
		this.tbAdmPersona = tbAdmPersona;
	}

	public TbAdmDocentesxnucleo(int nbId, TbAdmNucleo tbAdmNucleo,
			TbAdmPersona tbAdmPersona, String vrModusuario, Date vrModfecha,
			String vrOficina, String vrHorarioatencion, String vrHorarioclases) {
		this.nbId = nbId;
		this.tbAdmNucleo = tbAdmNucleo;
		this.tbAdmPersona = tbAdmPersona;
		this.vrModusuario = vrModusuario;
		this.vrModfecha = vrModfecha;
		this.vrOficina = vrOficina;
		this.vrHorarioatencion = vrHorarioatencion;
		this.vrHorarioclases = vrHorarioclases;
	}
	
}
