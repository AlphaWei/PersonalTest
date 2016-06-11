/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.swt.widgets.ProgressBar;

/**
 *
 * @author Little-Kitty
 */
public class MyProgressBar extends ProgressBar implements ChangeListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
    private JLabel label;
    private JLabel label1;
    //private JFrame frame;
    private JDialog dialog;
    private boolean isClosed;

    private final String title;

    public MyProgressBar() {
        title = "Loading";
        initComp();
    }

    public MyProgressBar(String title) {
        this.title = title;
        initComp();
    }

    private void initComp() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        dialog = new JDialog();
        dialog.setTitle(title);
        dialog.setSize(350, 100);
        dialog.setResizable(false);
        dialog.setUndecorated(true);
        Container contentPane = dialog.getContentPane();
        setOrientation(JProgressBar.HORIZONTAL);// ���÷���
        setMaximum(100);
        setMinimum(0);
        setValue(0);
        addChangeListener(this);
        setStringPainted(true);
        setPreferredSize(new Dimension(350, 20));
        //JPanel panel = new JPanel();
        label1 = new JLabel(title, JLabel.CENTER);
        label = new JLabel("", JLabel.CENTER);
        panel.add(label1);
        panel.add(this);
        panel.add(label);
        contentPane.add(panel);
        //frame.pack();
        //dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
    }

    public void setParamNoClear() {
        addChangeListener(null);
        setStringPainted(false);
        setBackground(new java.awt.Color(0, 0, 255));
        setForeground(new java.awt.Color(0, 0, 255));
    }

    public void setShow(boolean isShow) {
        if (isShow) {            
            new SelfClose().start();
            new Thread(){
                @Override
                public void run(){
                    isClosed = false;
                    dialog.setVisible(true);
                }
            }.start();
        } else {
            isClosed = true;
            dialog.dispose();
        }
    }

    public void setLabel(int size) {
        label.setText("Loaded: " + size + " KB");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        int value = this.getValue();
        label.setText("Progress:" + Integer.toString(value) + "%");
    }

    class SelfClose extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(90000);
                if (!isClosed) {
                    setShow(false);
                    JOptionPane.showMessageDialog(null,
                            "Loading timeout! please retry it.", 
                                    "Error", JOptionPane.OK_OPTION);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MyProgressBar.class.getName())
                                .log(Level.SEVERE, null, ex);
            }
        }
    }
}
