package com.eshafts.socket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import javax.swing.*;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.shafts.utils.MyProgressBar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SFTPConnection {

    private String host;
    private String username;
    private String password;
    private int port = 2222;
    private ChannelSftp sftp = null;
    private Session sshSession = null;

    public SFTPConnection() {
        this.host = "59.78.96.61";
        this.username = "whwei";
        this.password = "123456";
        //this.port = port;
    }

    public SFTPConnection(String host, String username, String password, int port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public SFTPConnection(String host, String username, String password) {
        this.host = host;
        this.username = username;
        this.password = password;
    }

    /**
     * connect the server
     * @return 
     */
    public boolean connect() {

        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.setTimeout(90000);//
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connect server exception!");
        }
        return false;
    }

    /**
     * close the connection
     */
    public void disconnect() {
        if (this.sftp != null) {
            if (this.sftp.isConnected()) {
                this.sftp.disconnect();
            }
        }
        if (this.sshSession != null) {
            if (this.sshSession.isConnected()) {
                this.sftp.disconnect();
            }
            System.out.println("sshSession is closed already");
        }
    }

    /**
     * check if the file exist
     *
     * @param directory
     * @return
     */
    public boolean isDirExist(String directory) {

        boolean isDirExistflag = false;
        try {
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistflag = sftpATTRS.isDir();
        } catch (Exception e) {
            if (e.getMessage().toLowerCase().equals("no such file")) {
                isDirExistflag = false;
            }
        }
        return isDirExistflag;
    }

    /**
     * create a new directory if not exist
     *
     * @param path
     */
    public void mkdirs(String path) {

        File file = new File(path);
        String fs = file.getParent();
        file = new File(fs);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * download single file
     *
     * @param remotePath 
     * @param remoteFileName 
     * @param localPath 
     * @param localFileName 
     */
    public void downloadfile(String remotePath, String remoteFileName, String localPath, String localFileName) {

        try {
            sftp.cd(remotePath);
            File file = new File(localPath + localFileName);
            mkdirs(localPath + localFileName);
            sftp.get(remoteFileName, new FileOutputStream(file));
        } catch (SftpException | FileNotFoundException ex) {
            Logger.getLogger(SFTPConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * batch download the files
     *
     * @param jobid
     * @param localPath save path
     * @param name
     * @return
     */
    public boolean batchDownLoadFile(String jobid, String localPath, String name) {

        String serverPath = "/home2/scbit/WebApps/FeatureAlign/jobs/" + jobid + "/";
        String serverFileName = "/home2/scbit/WebApps/FeatureAlign/jobs/" + jobid + "/result/";
        boolean resultcomplete = false;
        MyProgressBar myBar = new MyProgressBar("Download Job " + name);
        try {
            int i = 1;
            int V;
            if (connect()) {
                boolean ifExistDir = isDirExist(serverPath);
                boolean ifExistResult = isDirExist(serverFileName);
                if (ifExistDir && ifExistResult) {
                //ProgressBar Pb = new ProgressBar();
                    //thebar();                
                    myBar.setShow(true);
                    Vector v = listFiles(serverFileName);
                    if (v.size() > 0) {
                        Iterator it = v.iterator();
                        while (it.hasNext()) {
                            LsEntry entry = (LsEntry) it.next();
                            String filename = entry.getFilename();
                            SftpATTRS attrs = entry.getAttrs();
                            if (!attrs.isDir()) {
                                downloadfile(serverFileName, filename, localPath, filename);
                                i++;
                                V = i * 100 / v.size();
                                //progressbar.setValue(V);
                                myBar.setValue(V);
                            }
                        }
                    }
                    resultcomplete = true;
                } else {
                    JOptionPane.showMessageDialog(null, "The server is caculating...");
                }
            }
        } catch (SftpException e) {
            JOptionPane.showMessageDialog(null, "Connection error...");
            Logger.getLogger(SFTPConnection.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            myBar.setShow(false);
            this.disconnect();
        }
        return resultcomplete;
    }

    /**
     * @param path
     * @return
     * @throws SftpException
     */
    public Vector listFiles(String path) throws SftpException {
        return sftp.ls(path);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ChannelSftp getSftp() {
        return sftp;
    }

    public void setSftp(ChannelSftp sftp) {
        this.sftp = sftp;
    }

    public static void main(String args[]) {
        //SFTPConnection sftp = new SFTPConnection("59.78.96.61", "whwei", "123456");
        SFTPConnection sftp = new SFTPConnection();
        String jobid = "19895";
        String localPath = "F:\\" + jobid + "\\";
        //sftp.connect();
        sftp.batchDownLoadFile(jobid, localPath, "19895");
        //sftp.disconnect();
        System.exit(0);
    }

}
