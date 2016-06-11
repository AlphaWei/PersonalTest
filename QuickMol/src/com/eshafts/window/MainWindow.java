package com.eshafts.window;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.eshafts.module.language.LoadResource;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class MainWindow {

	protected Shell shell;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoadResource.initLang("EN");
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(850, 520);
		
		shell.setText("eShafts");
		shell.setMaximized(true);
		shell.setLayout(new FormLayout());
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText(LoadResource.RESOURCES.getString("menubar_file"));
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.setText(LoadResource.RESOURCES.getString("file_open"));
		
		MenuItem mntmCreate = new MenuItem(menu_1, SWT.NONE);
		mntmCreate.setText(LoadResource.RESOURCES.getString("file_create"));
		
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setText(LoadResource.RESOURCES.getString("file_save"));
		
		MenuItem mntmSavePic = new MenuItem(menu_1, SWT.NONE);
		mntmSavePic.setText(LoadResource.RESOURCES.getString("file_save_pic"));
		
		MenuItem mntmClose = new MenuItem(menu_1, SWT.NONE);
		mntmClose.setText(LoadResource.RESOURCES.getString("file_close_job"));
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText(LoadResource.RESOURCES.getString("system_exit"));
		
		MenuItem mntmTools = new MenuItem(menu, SWT.CASCADE);
		mntmTools.setText(LoadResource.RESOURCES.getString("menubar_tool"));
		
		Menu menu_2 = new Menu(mntmTools);
		mntmTools.setMenu(menu_2);
		
		MenuItem mntmMolConvert = new MenuItem(menu_2, SWT.NONE);
		mntmMolConvert.setText(LoadResource.RESOURCES.getString("tool_convert"));
		
		MenuItem mntmMaximum = new MenuItem(menu_2, SWT.NONE);
		mntmMaximum.setText(LoadResource.RESOURCES.getString("tool_mol_minimize"));
		
		MenuItem mntmRender = new MenuItem(menu, SWT.CASCADE);
		mntmRender.setText(LoadResource.RESOURCES.getString("menubar_render"));
		
		Menu menu_3 = new Menu(mntmRender);
		mntmRender.setMenu(menu_3);
		
		MenuItem mntmSurface = new MenuItem(menu_3, SWT.CASCADE);
		mntmSurface.setText(LoadResource.RESOURCES.getString("render_surface"));
		
		Menu menu_7 = new Menu(mntmSurface);
		mntmSurface.setMenu(menu_7);
		
		MenuItem mntmDot = new MenuItem(menu_7, SWT.CHECK);
		mntmDot.setText(LoadResource.RESOURCES.getString("surface_dot"));
		
		MenuItem mntmVander = new MenuItem(menu_7, SWT.CHECK);
		mntmVander.setText(LoadResource.RESOURCES.getString("surface_vander_waals"));
		
		MenuItem mntmMolSurface = new MenuItem(menu_7, SWT.CHECK);
		mntmMolSurface.setText(LoadResource.RESOURCES.getString("surface_mol_surface"));
		
		MenuItem mntmSolvent = new MenuItem(menu_7, SWT.CHECK);
		mntmSolvent.setText(LoadResource.RESOURCES.getString("surface_solvent"));
		
		MenuItem mntmSoklvent = new MenuItem(menu_7, SWT.CHECK);
		mntmSoklvent.setText(LoadResource.RESOURCES.getString("surface_soklvent"));
		
		MenuItem mntmElectrostatic = new MenuItem(menu_7, SWT.CHECK);
		mntmElectrostatic.setText(LoadResource.RESOURCES.getString("surface_electrostatic"));
		
		MenuItem mntmOpaque = new MenuItem(menu_7, SWT.CHECK);
		mntmOpaque.setText(LoadResource.RESOURCES.getString("surface_opaque"));
		
		MenuItem mntmTranslucent = new MenuItem(menu_7, SWT.CHECK);
		mntmTranslucent.setText(LoadResource.RESOURCES.getString("surface_translucent"));
		
		MenuItem mntmOff = new MenuItem(menu_7, SWT.CHECK);
		mntmOff.setText(LoadResource.RESOURCES.getString("surface_off"));
		
		MenuItem mntmLigand = new MenuItem(menu_3, SWT.CASCADE);
		mntmLigand.setText(LoadResource.RESOURCES.getString("render_ligand_style"));
		
		Menu menu_8 = new Menu(mntmLigand);
		mntmLigand.setMenu(menu_8);
		
		MenuItem mntmLine = new MenuItem(menu_8, SWT.RADIO);
		mntmLine.setText(LoadResource.RESOURCES.getString("ligand_line"));
		
		MenuItem mntmBall = new MenuItem(menu_8, SWT.RADIO);
		mntmBall.setText(LoadResource.RESOURCES.getString("ligand_ball"));
		
		MenuItem mntmStick = new MenuItem(menu_8, SWT.RADIO);
		mntmStick.setText(LoadResource.RESOURCES.getString("ligand_stick"));
		
		MenuItem mntmCpk = new MenuItem(menu_8, SWT.RADIO);
		mntmCpk.setText(LoadResource.RESOURCES.getString("ligand_cpk"));
		
		MenuItem mntmShowH = new MenuItem(menu_8, SWT.RADIO);
		mntmShowH.setText(LoadResource.RESOURCES.getString("ligand_showH"));
		
		MenuItem mntmHideH = new MenuItem(menu_8, SWT.RADIO);
		mntmHideH.setText(LoadResource.RESOURCES.getString("ligand_hideH"));
		
		MenuItem mntmProtein = new MenuItem(menu_3, SWT.CASCADE);
		mntmProtein.setText(LoadResource.RESOURCES.getString("render_protein_style"));
		
		Menu menu_9 = new Menu(mntmProtein);
		mntmProtein.setMenu(menu_9);
		
		MenuItem mntmWireframe = new MenuItem(menu_9, SWT.RADIO);
		mntmWireframe.setText(LoadResource.RESOURCES.getString("protein_line"));
		
		MenuItem mntmCartoon = new MenuItem(menu_9, SWT.RADIO);
		mntmCartoon.setText(LoadResource.RESOURCES.getString("protein_cartoon"));
		
		MenuItem mntmStrands = new MenuItem(menu_9, SWT.RADIO);
		mntmStrands.setText(LoadResource.RESOURCES.getString("protein_strands"));
		
		MenuItem mntmSpin = new MenuItem(menu_3, SWT.CASCADE);
		mntmSpin.setText(LoadResource.RESOURCES.getString("render_spin"));
		
		Menu menu_10 = new Menu(mntmSpin);
		mntmSpin.setMenu(menu_10);
		
		MenuItem mntmIsSpin = new MenuItem(menu_10, SWT.CHECK);
		mntmIsSpin.setText(LoadResource.RESOURCES.getString("spin_on"));
		
		MenuItem mntmReset = new MenuItem(menu_10, SWT.NONE);
		mntmReset.setText(LoadResource.RESOURCES.getString("spin_reset"));
		
		MenuItem mntmBackground = new MenuItem(menu_3, SWT.CASCADE);
		mntmBackground.setText(LoadResource.RESOURCES.getString("render_background"));
		
		Menu menu_11 = new Menu(mntmBackground);
		mntmBackground.setMenu(menu_11);
		
		MenuItem mntmWhite = new MenuItem(menu_11, SWT.RADIO);
		mntmWhite.setText(LoadResource.RESOURCES.getString("background_white"));
		
		MenuItem mntmBlack = new MenuItem(menu_11, SWT.RADIO);
		mntmBlack.setText(LoadResource.RESOURCES.getString("background_black"));
		
		MenuItem mntmRed = new MenuItem(menu_11, SWT.RADIO);
		mntmRed.setText(LoadResource.RESOURCES.getString("background_red"));
		
		MenuItem mntmOrange = new MenuItem(menu_11, SWT.RADIO);
		mntmOrange.setText(LoadResource.RESOURCES.getString("background_orange"));
		
		MenuItem mntmYellow = new MenuItem(menu_11, SWT.RADIO);
		mntmYellow.setText(LoadResource.RESOURCES.getString("background_yellow"));
		
		MenuItem mntmGreen = new MenuItem(menu_11, SWT.RADIO);
		mntmGreen.setText(LoadResource.RESOURCES.getString("background_green"));
		
		MenuItem mntmCyan = new MenuItem(menu_11, SWT.RADIO);
		mntmCyan.setText(LoadResource.RESOURCES.getString("background_cyan"));
		
		MenuItem mntmBlue = new MenuItem(menu_11, SWT.RADIO);
		mntmBlue.setText(LoadResource.RESOURCES.getString("background_blue"));
		
		MenuItem mntmIndigo = new MenuItem(menu_11, SWT.RADIO);
		mntmIndigo.setText(LoadResource.RESOURCES.getString("background_indigo"));
		
		MenuItem mntmViolet = new MenuItem(menu_11, SWT.RADIO);
		mntmViolet.setText(LoadResource.RESOURCES.getString("background_violet"));
		
		MenuItem mntmSet = new MenuItem(menu, SWT.CASCADE);
		mntmSet.setText(LoadResource.RESOURCES.getString("menubar_setting"));
		
		Menu menu_4 = new Menu(mntmSet);
		mntmSet.setMenu(menu_4);
		
		MenuItem mntmWorkpath = new MenuItem(menu_4, SWT.NONE);
		mntmWorkpath.setText(LoadResource.RESOURCES.getString("setting_workpath"));
		
		MenuItem mntmOther = new MenuItem(menu_4, SWT.NONE);
		mntmOther.setText(LoadResource.RESOURCES.getString("setting_other"));
		
		MenuItem mntmLang = new MenuItem(menu_4, SWT.NONE);
		mntmLang.setText(LoadResource.RESOURCES.getString("setting_lang"));
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText(LoadResource.RESOURCES.getString("menubar_help"));
		
		Menu menu_5 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_5);
		
		MenuItem mntmHelpDoc = new MenuItem(menu_5, SWT.NONE);
		mntmHelpDoc.setText(LoadResource.RESOURCES.getString("help_doc"));
		
		MenuItem mntmAbout = new MenuItem(menu, SWT.CASCADE);
		mntmAbout.setText(LoadResource.RESOURCES.getString("menubar_about"));
		
		Menu menu_6 = new Menu(mntmAbout);
		mntmAbout.setMenu(menu_6);
		
		MenuItem mntmAboutUs = new MenuItem(menu_6, SWT.NONE);
		mntmAboutUs.setText(LoadResource.RESOURCES.getString("about_us"));
		
		MenuItem mntmProtocol = new MenuItem(menu_6, SWT.CASCADE);
		mntmProtocol.setText(LoadResource.RESOURCES.getString("about_protocol"));
		
		Menu menu_12 = new Menu(mntmProtocol);
		mntmProtocol.setMenu(menu_12);
		
		MenuItem mntmOpenBabel = new MenuItem(menu_12, SWT.NONE);
		mntmOpenBabel.setText(LoadResource.RESOURCES.getString("protocol_openbabel"));
		
		MenuItem mntmJChem = new MenuItem(menu_12, SWT.NONE);
		mntmJChem.setText(LoadResource.RESOURCES.getString("protocol_jchempaint"));
		
		MenuItem mntmJmol = new MenuItem(menu_12, SWT.NONE);
		mntmJmol.setText(LoadResource.RESOURCES.getString("protocol_jmol"));
		
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
		toolBar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		FormData fd_toolBar = new FormData();
		fd_toolBar.right = new FormAttachment(0, shell.getStyle() - 100);
		fd_toolBar.top = new FormAttachment(0);
		fd_toolBar.left = new FormAttachment(0);
		toolBar.setLayoutData(fd_toolBar);
		
		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.setToolTipText(LoadResource.RESOURCES.getString("tooltip_open"));
		tltmNewItem.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/openf.png"));
		
		ToolItem tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_1.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/format.png"));
		tltmNewItem_1.setToolTipText(LoadResource.RESOURCES.getString("tooltip_convert"));
		
		ToolItem tltmNewItem_2 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_2.setToolTipText(LoadResource.RESOURCES.getString("tooltip_3dGen"));
		tltmNewItem_2.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/3D.png"));
		
		ToolItem tltmNewItem_3 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_3.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/showH.png"));
		tltmNewItem_3.setToolTipText(LoadResource.RESOURCES.getString("tooltip_showH"));
		
		ToolItem tltmNewItem_4 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_4.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/doSpin.png"));
		tltmNewItem_4.setToolTipText(LoadResource.RESOURCES.getString("tooltip_spin"));
		
		ToolItem tltmNewItem_5 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_5.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/Reset.png"));
		tltmNewItem_5.setToolTipText(LoadResource.RESOURCES.getString("tooltip_view"));
		
		ToolItem tltmNewItem_6 = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmNewItem_6.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/ball_stick.png"));
		tltmNewItem_6.setToolTipText(LoadResource.RESOURCES.getString("tooltip_ligand"));
		
		ToolItem tltmNewItem_7 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_7.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/Optimize.png"));
		tltmNewItem_7.setToolTipText(LoadResource.RESOURCES.getString("tooltip_minimize"));
		
		ToolItem tltmNewItem_8 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_8.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/modelKit.png"));
		tltmNewItem_8.setToolTipText(LoadResource.RESOURCES.getString("tooltip_builder"));
		
		ToolItem tltmNewItem_9 = new ToolItem(toolBar, SWT.DROP_DOWN);
		tltmNewItem_9.setImage(SWTResourceManager.getImage(MainWindow.class, "/com/eshafts/resources/pic/wireframe.png"));
		tltmNewItem_9.setToolTipText(LoadResource.RESOURCES.getString("tooltip_protein"));

	}
}
