/**
 * made by WenhaoWei. 
 * should not copy the code if no any privilege peimitted.
 * all rights reserved by WenhaoWei @2016	
 */
package com.eshafts.enums;

/**
 * 
 * @author AlphaWei
 *
 */
public enum GLOBAL_LANG {
	MENUBAR_FILE("menubar_file","File"),
	FILE_OPEN("file_open","Open File..."),
	FILE_CREATE("file_create","New"),
	FILE_SAVE("file_save","Save Molecular..."),
	FILE_SAVE_PIC("file_save_pic","Save Picture..."),
	FILE_CLOSE_JOB("file_close_job","Close Job"),
	SYSTEM_EXIT("system_exit","Exit"),

	MENUBAR_TOOL("menubar_tool","Tool"),
	TOOL_CONVERT("tool_convert","Convert"),
	TOOL_MOL_MINIMIZE("tool_mol_minimize","Energy Minimize"),

	MENUBAR_RENDER("menubar_render","Render"),
	RENDER_SURFACE("render_surface","Surface"),
	SURFACE_DOT("surface_dot","Dot Surface"),
	SURFACE_VANDER_WAALS("surface_vander_waals","van der Waals Surface"),
	SURFACE_MOL_SURFACE("surface_mol_surface","Molecular Surface"),
	SURFACE_SOLVENT("surface_solvent","Solvent Surface(1.4-Angstrom probe)"),
	SURFACE_SOKLVENT("surface_soklvent","Soklvent Accessible Surface(VDW+1.4 Angstrom)"),
	SURFACE_ELECTROSTATIC("surface_electrostatic","Molecular Electrostatic Potential"),
	SURFACE_OPAQUE("surface_opaque","Make Opaque"),
	SURFACE_TRANSLUCENT("surface_translucent","Make Translucent"),
	SURFACE_OFF("surface_off","Off"),

	RENDER_LIGAND_STYLE("render_ligand_style","Ligand Style"),
	LIGAND_LINE("ligand_line","Wireframe"),
	LIGAND_BALL("ligand_ball","Ball and Stick"),
	LIGAND_STICK("ligand_stick","Stick"),
	LIGAND_CPK("ligand_cpk","CPK"),
	LIGAND_SHOWH("ligand_showH","Show H"),
	LIGAND_HIDEH("ligand_hideH","Hide H"); 
	
	private String key;
	private String value;
	
	private GLOBAL_LANG(String key, String value){
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
