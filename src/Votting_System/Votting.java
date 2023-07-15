/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Votting_System;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DrawInterface;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author ROHIT TIWARI
 */
public class Votting extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    Connection conn,con;
    ResultSet rs;
    PreparedStatement ps,pst;
    int a=0,b=0,c=0,d=0;
    public Votting() {
        initComponents();
        conn=DB.db();
        super.setBackground(new Color(0,0,0,0));
        super.setTitle("Votting System-Votting Consol");
        ImageIcon imgicon=new ImageIcon("icon.png");
        super.setIconImage(imgicon.getImage());
        jTextField1.setBackground(new Color(0,0,0,0));
        jTextField2.setBackground(new Color(0,0,0,0));
        jTextField3.setBackground(new Color(0,0,0,0));
        jTextField4.setBackground(new Color(0,0,0,0));
        jTextField5.setBackground(new Color(0,0,0,0));
        jTextField6.setBackground(new Color(0,0,0,0));
        jToggleButton3.setVisible(false);
        jToggleButton5.setVisible(false);
        jToggleButton6.setVisible(false);
        jToggleButton7.setVisible(false);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jButton15.setVisible(false);
        jButton12.setVisible(false);
        jLabel17.setVisible(false);
        jLabel15.setVisible(false);
        jLabel14.setVisible(false);
        jLabel16.setVisible(false);
        jTextField7.setEditable(false);
    }

    
    
    public void slide1()
    {
        new Thread()
        {
            public void run()
            {
                for(int i=0;i<=30;i++)
                {
                    try
                    {
                        Thread.sleep(6);
                    }catch(Exception e)
                    {}
                    jPanel3.setBounds(0, 196, 1370, i);
                }
            }
        }.start();
    }
    
    public void slide2()
    {
        new Thread()
        {
            public void run()
            {
                for(int i=30;i>=0;i--)
                {
                    try
                    {
                        Thread.sleep(6);
                    }catch(Exception e)
                    {}
                    jPanel3.setBounds(0, 196, 1370, i);
                }
            }
        }.start();
    }
    
    public void Log1()
    {
        new Thread()
        {
            public void run()
            {
                for(int i=0;i<=25;i++)
                {
                    try
                    {
                        Thread.sleep(3);
                    }catch(Exception e)
                    {}
                    jPanel7.setBounds(0, 225, 90, i);
                }
            }
        }.start();
    }
    
    public void Log2()
    {
        int i;
        new Thread()
        {
            public void run()
            {
                for(int i=25;i>=0;i--)
                {
                    try
                    {
                        Thread.sleep(2);
                    }catch(Exception e)
                    {}
                    jPanel7.setBounds(0, 225, 90, i);
                }
            }
        }.start();
    }
    
    
    
    public ImageIcon ResizeImage(String ImagePath,int w,int h)
    {
        ImageIcon Myimage =new ImageIcon(ImagePath);
        Image img=Myimage.getImage();
        Image newimg= img.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        ImageIcon image =new ImageIcon(newimg);
        return image;
    }
    
    public void createpdf()
    {
        try 
        {
            JFileChooser choos= new JFileChooser();
            choos.setCurrentDirectory(new java.io.File("."));
            choos.setApproveButtonText("Save");
            choos.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            FileNameExtensionFilter xmlfilter= new FileNameExtensionFilter("pdf file(*.pdf)","pdf");
            choos.addChoosableFileFilter(xmlfilter);
            choos.setFileFilter(xmlfilter);
            choos.setAcceptAllFileFilterUsed(false);
            if(choos.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
            {
                Document doc= new Document(PageSize.A4);
                doc.setMargins(25f, 25f, 20f, 20f);
                PdfWriter witter= PdfWriter.getInstance(doc, new FileOutputStream(new File(choos.getSelectedFile(),"Votting Result.pdf")));
                doc.open();
                Paragraph pg1 = new Paragraph();Paragraph pg2 = new Paragraph(),pg3 = new Paragraph();
                ImageIcon format = (ImageIcon) jLabel8.getIcon();
                Image img= format.getImage();
                Image imgnew = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                com.itextpdf.text.Image ico;
                ico= com.itextpdf.text.Image.getInstance(imgnew,null);
                //Chunk ch1= new Chunk(ico, TOP_ALIGNMENT, TOP_ALIGNMENT);
                pg1.add(new com.itextpdf.text.Image(ico) {
                });
                pg1.add(new Phrase(jLabel3.getText(),new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 26.0f, com.itextpdf.text.Font.BOLD,BaseColor.ORANGE)));
                pg1.add(new Phrase("\n"+jLabel2.getText(),new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18.0f, com.itextpdf.text.Font.BOLD,BaseColor.ORANGE)));
                pg1.add(new Phrase("\n"+jTextField1.getText(),new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18.0f, com.itextpdf.text.Font.BOLD,BaseColor.ORANGE)));
                pg1.add(new Phrase("\n"+jTextField2.getText(),new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 18.0f, com.itextpdf.text.Font.BOLD,BaseColor.ORANGE)));
                pg1.setAlignment((int) RIGHT_ALIGNMENT);
                //doc.add(ch1);
                doc.add(pg1);
                doc.close();
                //if(Integer.max(Integer.max(a, b),Integer.max(c, d))==a)
                //pg1=new Paragraph(string)
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jToggleButton9 = new javax.swing.JToggleButton();
        jPanel6 = new javax.swing.JPanel();
        jToggleButton8 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jToggleButton4 = new javax.swing.JToggleButton();
        jButton16 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel24 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jTextField5 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jButton14 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jTextField4 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(43, 51, 73));
        jTextField7.setFont(new java.awt.Font("Sitka Heading", 0, 36)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(56, 110, 152));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("Post:");
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        jTextField7.setOpaque(false);
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 150, 80, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimise_1.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverEnabled(false);
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Minimise_2.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 20, 20));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit_1.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverEnabled(false);
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit_2.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 10, 20, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BARR.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 190, 1190, 10));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BARR.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 1180, 10));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo3.jpg"))); // NOI18N
        jLabel8.setToolTipText("");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 150, 150));

        jPanel7.setBackground(new java.awt.Color(9, 35, 57));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inside-logout-icon.png"))); // NOI18N
        jLabel4.setText("LOGOUT");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        jPanel7.add(jLabel4);

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 90, 0));

        jPanel3.setBackground(new java.awt.Color(9, 35, 57));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(14, 14, 35));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 78, 101), 2, true));
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 2, 190, 24));

        jPanel8.setBackground(new java.awt.Color(14, 14, 35));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-trash-48.png"))); // NOI18N
        jToggleButton9.setBorder(null);
        jToggleButton9.setContentAreaFilled(false);
        jToggleButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton9MouseReleased(evt);
            }
        });
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });
        jPanel8.add(jToggleButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, -1));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 1, 28, 28));

        jPanel6.setBackground(new java.awt.Color(14, 14, 35));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/design.png"))); // NOI18N
        jToggleButton8.setBorder(null);
        jToggleButton8.setContentAreaFilled(false);
        jToggleButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton8MouseReleased(evt);
            }
        });
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jToggleButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 1, 28, 28));

        jPanel5.setBackground(new java.awt.Color(14, 14, 35));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avatar-380-456332.png"))); // NOI18N
        jToggleButton4.setBorder(null);
        jToggleButton4.setContentAreaFilled(false);
        jToggleButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton4MouseReleased(evt);
            }
        });
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 1, 28, 28));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 30));

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 153, 204));
        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/19_24x24.png"))); // NOI18N
        jButton16.setText("CLEAR VOTERS");
        jButton16.setContentAreaFilled(false);
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton16MouseReleased(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 2, 160, 24));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 153, 204));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1df88523.png"))); // NOI18N
        jButton7.setText("ABOUT");
        jButton7.setContentAreaFilled(false);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 2, 110, 24));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 153, 204));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reload-retry-again-update-restart-refresh-sync-2-2605.png"))); // NOI18N
        jButton6.setText("RESET");
        jButton6.setContentAreaFilled(false);
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 2, 120, 24));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Medal-2-512.png"))); // NOI18N
        jButton1.setText("RESULTS");
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 2, 120, 24));

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 153, 204));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1024px-Circle-icons-browser.svg.png"))); // NOI18N
        jToggleButton1.setText("ENABEL/DISABLE SYSTEM EDIT");
        jToggleButton1.setBorder(null);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseReleased(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 2, 240, 24));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 204));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/acrobat-flat.png"))); // NOI18N
        jLabel24.setText("EXPORT");
        jLabel24.setFocusable(false);
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel24MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel24MouseReleased(evt);
            }
        });
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 2, 90, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 196, 1370, 30));

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/menu-icon-5.png"))); // NOI18N
        jToggleButton2.setBorder(null);
        jToggleButton2.setContentAreaFilled(false);
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseReleased(evt);
            }
        });
        getContentPane().add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 160, 30, 30));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(43, 51, 73));
        jTextField1.setFont(new java.awt.Font("Sitka Heading", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(56, 110, 152));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Student Council Election");
        jTextField1.setBorder(null);
        jTextField1.setOpaque(false);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 620, 40));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(43, 51, 73));
        jTextField2.setFont(new java.awt.Font("Sitka Heading", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(100, 119, 123));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Please Click Here to Add Post Name");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        jTextField2.setOpaque(false);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 150, 545, 40));

        jPanel1.setBackground(new java.awt.Color(37, 78, 101));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 75, 720, 2));

        jPanel2.setBackground(new java.awt.Color(37, 78, 101));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 105, 620, 2));

        jLabel3.setFont(new java.awt.Font("High Tower Text", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(72, 140, 193));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 720, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 204, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setToolTipText("");
        jLabel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 78, 101), 2, true));
        jLabel17.setEnabled(false);
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 660, 130, 30));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(102, 153, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE.png"))); // NOI18N
        jButton11.setContentAreaFilled(false);
        jButton11.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE_1.png"))); // NOI18N
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton11MouseReleased(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 620, 70, 24));

        jToggleButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton7.setForeground(new java.awt.Color(102, 153, 255));
        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        jToggleButton7.setText("Enabel/Disable Field");
        jToggleButton7.setBorder(null);
        jToggleButton7.setBorderPainted(false);
        jToggleButton7.setContentAreaFilled(false);
        jToggleButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton7MouseReleased(evt);
            }
        });
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, -1, -1));

        jTextField5.setBackground(new java.awt.Color(43, 51, 73));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(72, 140, 193));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField5MousePressed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 550, 220, 30));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 1.png"))); // NOI18N
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 2.png"))); // NOI18N
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton15MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton15MouseReleased(evt);
            }
        });
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 520, 200, 24));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user@2x (2).png"))); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 282, 220, 270));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setToolTipText("");
        jLabel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 78, 101), 2, true));
        jLabel16.setEnabled(false);
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 660, 130, 30));

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(102, 153, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE.png"))); // NOI18N
        jButton10.setContentAreaFilled(false);
        jButton10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE_1.png"))); // NOI18N
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton10MouseReleased(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 620, 70, 24));

        jToggleButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton6.setForeground(new java.awt.Color(102, 153, 255));
        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        jToggleButton6.setText("Enabel/Disable Field");
        jToggleButton6.setBorder(null);
        jToggleButton6.setBorderPainted(false);
        jToggleButton6.setContentAreaFilled(false);
        jToggleButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton6MouseReleased(evt);
            }
        });
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, -1, -1));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 1.png"))); // NOI18N
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 2.png"))); // NOI18N
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton14MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton14MouseReleased(evt);
            }
        });
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 520, 200, 24));

        jLabel13.setFont(new java.awt.Font("Sitka Text", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user@2x (2).png"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 282, 220, 270));

        jTextField6.setBackground(new java.awt.Color(43, 51, 73));
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(72, 140, 193));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField6MousePressed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, 220, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 204));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setToolTipText("");
        jLabel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 78, 101), 2, true));
        jLabel15.setEnabled(false);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 660, 130, 30));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(102, 153, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE.png"))); // NOI18N
        jButton9.setContentAreaFilled(false);
        jButton9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE_1.png"))); // NOI18N
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, 70, 24));

        jToggleButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton5.setForeground(new java.awt.Color(102, 153, 255));
        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        jToggleButton5.setText("Enabel/Disable Field");
        jToggleButton5.setBorder(null);
        jToggleButton5.setBorderPainted(false);
        jToggleButton5.setContentAreaFilled(false);
        jToggleButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton5MouseReleased(evt);
            }
        });
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        jTextField4.setBackground(new java.awt.Color(43, 51, 73));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(72, 140, 193));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField4MousePressed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, 220, 30));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 1.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 2.png"))); // NOI18N
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton13MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton13MouseReleased(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, 200, 24));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user@2x (2).png"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 282, 220, 270));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setToolTipText("");
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 78, 101), 2, true));
        jLabel14.setEnabled(false);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 660, 130, 30));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(102, 153, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/VOTE_1.png"))); // NOI18N
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8MouseReleased(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 620, 70, 24));

        jToggleButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton3.setForeground(new java.awt.Color(102, 153, 255));
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/checked.png"))); // NOI18N
        jToggleButton3.setText("Enabel/Disable Field");
        jToggleButton3.setBorder(null);
        jToggleButton3.setBorderPainted(false);
        jToggleButton3.setContentAreaFilled(false);
        jToggleButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jToggleButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jToggleButton3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButton3MouseReleased(evt);
            }
        });
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 1.png"))); // NOI18N
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHOOSE_IMAGE 2.png"))); // NOI18N
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton12MouseReleased(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, 200, 24));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user@2x (2).png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 282, 220, 270));

        jTextField3.setBackground(new java.awt.Color(43, 51, 73));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(72, 140, 193));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 78, 101), 2));
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField3MousePressed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 220, 30));

        jLabel2.setFont(new java.awt.Font("High Tower Text", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(72, 140, 193));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setAlignmentX(0.5F);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 620, 25));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mainback_1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        jButton3.setLocation(1311, 11);
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        jButton3.setLocation(1310, 10);
    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        super.setState(ICONIFIED);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        jButton2.setLocation(1341, 11);
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        jButton2.setLocation(1340, 10);
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MousePressed
        jToggleButton2.setLocation(1331, 161);
    }//GEN-LAST:event_jToggleButton2MousePressed

    private void jToggleButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseReleased
        jToggleButton2.setLocation(1330, 160);
    }//GEN-LAST:event_jToggleButton2MouseReleased

    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
        
        if(jToggleButton2.isSelected())
        {
            if(jPanel3.getHeight()==30&&jPanel3.getWidth()==1370)
            slide2();
            else
            slide1();
        }
        else
        {
            if(jPanel3.getHeight()==30&&jPanel3.getWidth()==1370)
            slide2();
            else
            slide1();
        }
    }//GEN-LAST:event_jToggleButton2MouseClicked

    private void jToggleButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseEntered
        jToggleButton1.setForeground(new Color(86, 186, 220));
    }//GEN-LAST:event_jToggleButton1MouseEntered

    private void jToggleButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseExited
        jToggleButton1.setForeground(new Color(0,153,204));
    }//GEN-LAST:event_jToggleButton1MouseExited

    private void jToggleButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MousePressed
        jToggleButton1.setForeground(new Color(169, 220, 237));
        jToggleButton1.setLocation(jToggleButton1.getX()+1, jToggleButton1.getY());
    }//GEN-LAST:event_jToggleButton1MousePressed

    private void jToggleButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseReleased
        jToggleButton1.setForeground(new Color(86, 186, 220));
        jToggleButton1.setLocation(jToggleButton1.getX()-1, jToggleButton1.getY());
    }//GEN-LAST:event_jToggleButton1MouseReleased

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setForeground(new Color(86, 186, 220));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setForeground(new Color(0,153,204));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jButton1.setForeground(new Color(169, 220, 237));
        jButton1.setLocation(jButton1.getX()+1, jButton1.getY());
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        jButton1.setForeground(new Color(86, 186, 220));
        jButton1.setLocation(jButton1.getX()-1, jButton1.getY());
    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        jButton6.setForeground(new Color(86, 186, 220));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        jButton6.setForeground(new Color(0,153,204));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        jButton6.setForeground(new Color(169, 220, 237));
        jButton6.setLocation(jButton6.getX()+1, jButton6.getY());
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        jButton6.setForeground(new Color(86, 186, 220));
        jButton6.setLocation(jButton6.getX()-1, jButton6.getY());
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        jButton7.setForeground(new Color(86, 186, 220));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        jButton7.setForeground(new Color(0,153,204));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed
        jButton7.setForeground(new Color(169, 220, 237));
        jButton7.setLocation(jButton7.getX()+1, jButton7.getY());
    }//GEN-LAST:event_jButton7MousePressed

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        jButton7.setForeground(new Color(86, 186, 220));
        jButton7.setLocation(jButton7.getX()-1, jButton7.getY());
    }//GEN-LAST:event_jButton7MouseReleased

    private void jToggleButton4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton4MouseEntered
        jPanel5.setBackground(new Color(43, 51, 73));
    }//GEN-LAST:event_jToggleButton4MouseEntered

    private void jToggleButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton4MouseExited
        jPanel5.setBackground(new Color(14, 14, 35));
    }//GEN-LAST:event_jToggleButton4MouseExited

    private void jToggleButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton4MousePressed
        jPanel5.setLocation(9, 1);
        jPanel5.setBackground(new Color(90, 93, 127));
    }//GEN-LAST:event_jToggleButton4MousePressed

    private void jToggleButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton4MouseReleased
        jPanel5.setLocation(8, 1);
        jPanel5.setBackground(new Color(43, 51, 73));
    }//GEN-LAST:event_jToggleButton4MouseReleased

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        if(jToggleButton2.isSelected())
        {
            if(jPanel7.getHeight()==25&&jPanel7.getWidth()==90)
            Log2();
            else
            Log1();
        }
        else
        {
            if(jPanel7.getHeight()==25&&jPanel7.getWidth()==90)
            Log2();
            else
            Log1();
        }
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseEntered
        if(jPanel7.getHeight()==25&&jPanel7.getWidth()==90)
        Log2();
    }//GEN-LAST:event_jToggleButton2MouseEntered

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setForeground(new Color(86, 186, 220));    
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setForeground(new Color(0,153,204));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        jLabel4.setForeground(new Color(169, 220, 237));
        jLabel4.setLocation(jLabel4.getX()+1, jLabel4.getY());
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        jLabel4.setForeground(new Color(86, 186, 220));
        jLabel4.setLocation(jLabel4.getX()-1, jLabel4.getY());
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Login lb= new Login();
        lb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jToggleButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MouseEntered
        jToggleButton3.setForeground(new Color(86, 186, 220));  
    }//GEN-LAST:event_jToggleButton3MouseEntered

    private void jToggleButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MouseExited
        jToggleButton3.setForeground(new Color(102,153,255));
    }//GEN-LAST:event_jToggleButton3MouseExited

    private void jToggleButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MousePressed
        jToggleButton3.setForeground(new Color(169, 220, 237));
        jToggleButton3.setLocation(jToggleButton3.getX()+1, jToggleButton3.getY());
    }//GEN-LAST:event_jToggleButton3MousePressed

    private void jToggleButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MouseReleased
        jToggleButton3.setForeground(new Color(86, 186, 220));
        jToggleButton3.setLocation(jToggleButton3.getX()-1, jToggleButton3.getY());
    }//GEN-LAST:event_jToggleButton3MouseReleased

    private void jToggleButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton5MouseEntered
        jToggleButton5.setForeground(new Color(86, 186, 220));  
    }//GEN-LAST:event_jToggleButton5MouseEntered

    private void jToggleButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton5MouseExited
        jToggleButton5.setForeground(new Color(102,153,255));
    }//GEN-LAST:event_jToggleButton5MouseExited

    private void jToggleButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton5MousePressed
        jToggleButton5.setForeground(new Color(169, 220, 237));
        jToggleButton5.setLocation(jToggleButton5.getX()+1, jToggleButton5.getY());
    }//GEN-LAST:event_jToggleButton5MousePressed

    private void jToggleButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton5MouseReleased
        jToggleButton5.setForeground(new Color(86, 186, 220));
        jToggleButton5.setLocation(jToggleButton5.getX()-1, jToggleButton5.getY());
    }//GEN-LAST:event_jToggleButton5MouseReleased

    private void jToggleButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton6MouseEntered
        jToggleButton6.setForeground(new Color(86, 186, 220));  
    }//GEN-LAST:event_jToggleButton6MouseEntered

    private void jToggleButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton6MouseExited
        jToggleButton6.setForeground(new Color(102,153,255));
    }//GEN-LAST:event_jToggleButton6MouseExited

    private void jToggleButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton6MousePressed
        jToggleButton6.setForeground(new Color(169, 220, 237));
        jToggleButton6.setLocation(jToggleButton6.getX()+1, jToggleButton6.getY());
    }//GEN-LAST:event_jToggleButton6MousePressed

    private void jToggleButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton6MouseReleased
        jToggleButton6.setForeground(new Color(86, 186, 220));
        jToggleButton6.setLocation(jToggleButton6.getX()-1, jToggleButton6.getY());
    }//GEN-LAST:event_jToggleButton6MouseReleased

    private void jToggleButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton7MouseEntered
        jToggleButton7.setForeground(new Color(86, 186, 220));
    }//GEN-LAST:event_jToggleButton7MouseEntered

    private void jToggleButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton7MouseExited
        jToggleButton7.setForeground(new Color(102,153,255));                
    }//GEN-LAST:event_jToggleButton7MouseExited

    private void jToggleButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton7MousePressed
        jToggleButton7.setForeground(new Color(169, 220, 237));
        jToggleButton7.setLocation(jToggleButton7.getX()+1, jToggleButton7.getY());
    }//GEN-LAST:event_jToggleButton7MousePressed

    private void jToggleButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton7MouseReleased
        jToggleButton7.setForeground(new Color(86, 186, 220));
        jToggleButton7.setLocation(jToggleButton7.getX()-1, jToggleButton7.getY());
    }//GEN-LAST:event_jToggleButton7MouseReleased

    private void jButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MousePressed
        jButton12.setLocation(111, 521);
    }//GEN-LAST:event_jButton12MousePressed

    private void jButton12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseReleased
        jButton12.setLocation(110, 520);
    }//GEN-LAST:event_jButton12MouseReleased

    private void jButton13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MousePressed
        jButton13.setLocation(421, 521);
    }//GEN-LAST:event_jButton13MousePressed

    private void jButton13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseReleased
        jButton13.setLocation(420, 520);
    }//GEN-LAST:event_jButton13MouseReleased

    private void jButton15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MousePressed
        jButton15.setLocation(1051, 521);
    }//GEN-LAST:event_jButton15MousePressed

    private void jButton15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseReleased
        jButton15.setLocation(1051, 520);
    }//GEN-LAST:event_jButton15MouseReleased

    private void jButton14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MousePressed
        jButton14.setLocation(741, 521);
    }//GEN-LAST:event_jButton14MousePressed

    private void jButton14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseReleased
        jButton14.setLocation(740, 520);
    }//GEN-LAST:event_jButton14MouseReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Please Confirm", "Confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            String id=JOptionPane.showInputDialog("Eneter Your Admission No.");
            if(!"".equals(id))
            {
                try 
                {
                    String url="INSERT INTO Voters (Id) Values (?)";
                    ps=conn.prepareStatement(url);
                    ps.setString(1, id);
                    ps.execute();
                    a++;
                    String a1=Integer.toString(a);
                    jLabel14.setText(a1);
                    JOptionPane.showMessageDialog(null, "Thankyou");
                    ps.close();
                } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "You Already Voted" );
                }
            }else JOptionPane.showMessageDialog(null, "Vote is Not Added");
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vote is Not Added");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Please Confirm", "Confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            String id=JOptionPane.showInputDialog("Eneter Your Admission No.");
            if(!"".equals(id))
            {
                try 
                {

                    String url="INSERT INTO Voters (Id) Values (?)";
                    ps=conn.prepareStatement(url);
                    ps.setString(1, id);
                    ps.execute();
                    b++;
                    String a1=Integer.toString(b);
                    jLabel15.setText(a1);
                    JOptionPane.showMessageDialog(null, "Thankyou");
                    ps.close();
                } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "You Already Voted" );
                }
            }else JOptionPane.showMessageDialog(null, "Vote is Not Added");
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vote is Not Added");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Please Confirm", "Confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            String id=JOptionPane.showInputDialog("Eneter Your Admission No.");
            if(!"".equals(id))
            {
                try 
                {
                    String url="INSERT INTO Voters (Id) Values (?)";
                    ps=conn.prepareStatement(url);
                    ps.setString(1, id);
                    ps.execute();
                    c++;
                    String a1=Integer.toString(c);
                    jLabel16.setText(a1);
                    JOptionPane.showMessageDialog(null, "Thankyou");
                    ps.close();
                } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "You Already Voted" );
                }
            }else JOptionPane.showMessageDialog(null, "Vote is Not Added");
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vote is Not Added");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Please Confirm", "Confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            String id=JOptionPane.showInputDialog("Eneter Your Admission No.");
            if(!"".equals(id))
            {
                try 
                {
                    String url="INSERT INTO Voters (Id) Values (?)";
                    ps=conn.prepareStatement(url);
                    ps.setString(1, id);
                    ps.execute();
                    d++;
                    String a1=Integer.toString(d);
                    jLabel17.setText(a1);
                    JOptionPane.showMessageDialog(null, "Thankyou");
                    ps.close();
                } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "You Already Voted" );
                }
            }else JOptionPane.showMessageDialog(null, "Vote is Not Added");
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Vote is Not Added");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MousePressed
        jButton8.setLocation(171, 621);
    }//GEN-LAST:event_jButton8MousePressed

    private void jButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MousePressed
        jButton9.setLocation(481, 621);
    }//GEN-LAST:event_jButton9MousePressed

    private void jButton10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MousePressed
        jButton10.setLocation(801, 621);
    }//GEN-LAST:event_jButton10MousePressed

    private void jButton11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MousePressed
        jButton11.setLocation(1111, 621);
    }//GEN-LAST:event_jButton11MousePressed

    private void jButton8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseReleased
        jButton8.setLocation(170, 620);
    }//GEN-LAST:event_jButton8MouseReleased

    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
        jButton9.setLocation(480, 620);
    }//GEN-LAST:event_jButton9MouseReleased

    private void jButton10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseReleased
        jButton10.setLocation(801, 621);
    }//GEN-LAST:event_jButton10MouseReleased

    private void jButton11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseReleased
        jButton11.setLocation(1110, 620);
    }//GEN-LAST:event_jButton11MouseReleased

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        if(jToggleButton3.isSelected())
        {
            jLabel5.setVisible(false);
            jButton12.setVisible(false);
            jTextField3.setVisible(false);
            jButton8.setVisible(false);
            jLabel14.setVisible(false);
        }else
        {
            jLabel5.setVisible(true);
            jButton12.setVisible(true);
            jTextField3.setVisible(true);
            jButton8.setVisible(true);
            jLabel14.setVisible(true);
        }
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        if(jToggleButton5.isSelected())
        {
            jLabel9.setVisible(false);
            jButton13.setVisible(false);
            jTextField4.setVisible(false);
            jButton9.setVisible(false);
            jLabel15.setVisible(false);
        }else
        {
            jLabel9.setVisible(true);
            jButton13.setVisible(true);
            jTextField4.setVisible(true);
            jButton9.setVisible(true);
            jLabel15.setVisible(true);
        }
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        if(jToggleButton6.isSelected())
        {
            jLabel13.setVisible(false);
            jButton14.setVisible(false);
            jTextField6.setVisible(false);
            jButton10.setVisible(false);
            jLabel16.setVisible(false);
        }else
        {
            jLabel13.setVisible(true);
            jButton14.setVisible(true);
            jTextField6.setVisible(true);
            jButton10.setVisible(true);
            jLabel16.setVisible(true);
        }
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        if(jToggleButton7.isSelected())
        {
            jLabel10.setVisible(false);
            jButton15.setVisible(false);
            jTextField5.setVisible(false);
            jButton11.setVisible(false);
            jLabel17.setVisible(false);
        }else
        {
            jLabel10.setVisible(true);
            jButton15.setVisible(true);
            jTextField5.setVisible(true);
            jButton11.setVisible(true);
            jLabel17.setVisible(true);
        }
    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected())
        {
            jToggleButton3.setVisible(true);
            jToggleButton5.setVisible(true);
            jToggleButton6.setVisible(true);
            jToggleButton7.setVisible(true);
            if(jLabel5.isVisible())
            {
                jButton12.setVisible(true);
                jLabel14.setVisible(true);
            }else
            {
                jButton12.setVisible(false); 
                jLabel14.setVisible(false);
            }
            
            
            if(jLabel9.isVisible())
            {
                jButton13.setVisible(true);
                jLabel15.setVisible(true);
            }else
            {
                jButton13.setVisible(false); 
                jLabel15.setVisible(false);
            }
            
            
            if(jLabel13.isVisible())
            {
                jButton14.setVisible(true);
                jLabel16.setVisible(true);
            }else
            {
                jButton14.setVisible(false); 
                jLabel16.setVisible(false);
            }
            
            
            if(jLabel10.isVisible())
            {
                jButton15.setVisible(true);
                jLabel17.setVisible(true);
            }else
            {
                jButton15.setVisible(false); 
                jLabel17.setVisible(false);
            }
        }
        else
        {
            jToggleButton3.setVisible(false);
            jToggleButton5.setVisible(false);
            jToggleButton6.setVisible(false);
            jToggleButton7.setVisible(false);
            jButton13.setVisible(false);
            jButton14.setVisible(false);
            jButton15.setVisible(false);
            jButton12.setVisible(false);
            jLabel17.setVisible(false);
            jLabel15.setVisible(false);
            jLabel14.setVisible(false);
            jLabel16.setVisible(false);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextField3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MousePressed
        if(jToggleButton1.isSelected())
        {
            jTextField3.setEditable(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enable System Edit From Setting");
            jTextField3.setEditable(false);
        }
    }//GEN-LAST:event_jTextField3MousePressed

    private void jTextField4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MousePressed
        if(jToggleButton1.isSelected())
        {
            jTextField4.setEditable(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enable System Edit From Setting");
            jTextField4.setEditable(false);
        }
    }//GEN-LAST:event_jTextField4MousePressed

    private void jTextField6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MousePressed
        if(jToggleButton1.isSelected())
        {
            jTextField6.setEditable(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enable System Edit From Setting");
            jTextField6.setEditable(false);
        }
    }//GEN-LAST:event_jTextField6MousePressed

    private void jTextField5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MousePressed
        if(jToggleButton1.isSelected())
        {
            jTextField5.setEditable(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Enable System Edit From Setting");
            jTextField5.setEditable(false);
        }
    }//GEN-LAST:event_jTextField5MousePressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jLabel5.setIcon(null);
        jTextField3.setText(null);
        a=0;
        jLabel14.setText(Integer.toString(a));
        jLabel9.setIcon(null);
        jTextField4.setText(null);
        b=0;
        jLabel15.setText(Integer.toString(b));
        jLabel13.setIcon(null);
        jTextField5.setText(null);
        c=0;
        jLabel16.setText(Integer.toString(c));
        jLabel10.setIcon(null);
        jTextField6.setText(null);
        d=0;
        jLabel17.setText(Integer.toString(d));
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        JFileChooser file= new JFileChooser();
        file.setCurrentDirectory(new File("user.home"));
        FileNameExtensionFilter filter =new FileNameExtensionFilter("*.Images","jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result=file.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedfile =file.getSelectedFile();
            String path =selectedfile.getAbsolutePath();
            Icon in=ResizeImage(path,jLabel5.getWidth(),jLabel5.getHeight());
            jLabel5.setIcon(in);
            
            JOptionPane.showMessageDialog(null, "Image Added");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No Image Added");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        JFileChooser file= new JFileChooser();
        file.setCurrentDirectory(new File("user.home"));
        FileNameExtensionFilter filter =new FileNameExtensionFilter("*.Images","jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result=file.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedfile =file.getSelectedFile();
            String path =selectedfile.getAbsolutePath();
            Icon in=ResizeImage(path,jLabel9.getWidth(),jLabel9.getHeight());
            jLabel9.setIcon(in);
            
            JOptionPane.showMessageDialog(null, "Image Added");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No Image Added");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        JFileChooser file= new JFileChooser();
        file.setCurrentDirectory(new File("user.home"));
        FileNameExtensionFilter filter =new FileNameExtensionFilter("*.Images","jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result=file.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedfile =file.getSelectedFile();
            String path =selectedfile.getAbsolutePath();
            Icon in=ResizeImage(path,jLabel13.getWidth(),jLabel13.getHeight());
            jLabel13.setIcon(in);
            
            JOptionPane.showMessageDialog(null, "Image Added");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No Image Added");
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        JFileChooser file= new JFileChooser();
        file.setCurrentDirectory(new File("user.home"));
        FileNameExtensionFilter filter =new FileNameExtensionFilter("*.Images","jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result=file.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedfile =file.getSelectedFile();
            String path =selectedfile.getAbsolutePath();
            Icon in=ResizeImage(path,jLabel10.getWidth(),jLabel10.getHeight());
            jLabel10.setIcon(in);
            
            JOptionPane.showMessageDialog(null, "Image Added");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No Image Added");
        }
    }//GEN-LAST:event_jButton15ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Result rs = new Result();
        {
            if(jLabel5.getIcon() != null)
            {
                ImageIcon imn= (ImageIcon) jLabel5.getIcon();
                Image io=imn.getImage();
                Image oi=io.getScaledInstance(rs.jLabel16.getWidth(), rs.jLabel16.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newoi=new ImageIcon(oi);
                rs.jLabel16.setIcon(newoi);
                rs.jLabel4.setText("Name: "+jTextField3.getText());
                rs.jLabel5.setText("Post: "+jTextField2.getText());
                rs.jLabel6.setText("Vote: "+jLabel14.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==a)
                rs.jLabel20.setText("Winner");
                else
                rs.jLabel20.setText(null);
            }else
            {
                rs.jLabel4.setText("Name: "+jTextField3.getText());
                rs.jLabel5.setText("Post: "+jTextField2.getText());
                rs.jLabel6.setText("Vote: "+jLabel14.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==a)
                rs.jLabel20.setText("Winner");
                else
                rs.jLabel20.setText(null);
            }
        }
        
        {
            if(jLabel9.getIcon()!=null)
            {
                ImageIcon imn= (ImageIcon) jLabel9.getIcon();
                Image io=imn.getImage();
                Image oi=io.getScaledInstance(rs.jLabel17.getWidth(), rs.jLabel17.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newoi=new ImageIcon(oi);
                rs.jLabel17.setIcon(newoi);
                rs.jLabel9.setText("Name: "+jTextField4.getText());
                rs.jLabel8.setText("Post: "+jTextField2.getText());
                rs.jLabel7.setText("Vote: "+jLabel15.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==b)
                rs.jLabel21.setText("Winner");
                else
                rs.jLabel21.setText(null);
            }
            else
            {
                rs.jLabel9.setText("Name: "+jTextField4.getText());
                rs.jLabel8.setText("Post: "+jTextField2.getText());
                rs.jLabel7.setText("Vote: "+jLabel15.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==b)
                rs.jLabel21.setText("Winner");
                else
                rs.jLabel21.setText(null);
            }
        }
        
        {
            if(jLabel13.getIcon()!=null)
            {
                ImageIcon imn= (ImageIcon) jLabel13.getIcon();
                Image io=imn.getImage();
                Image oi=io.getScaledInstance(rs.jLabel18.getWidth(), rs.jLabel18.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newoi=new ImageIcon(oi);
                rs.jLabel18.setIcon(newoi);
                rs.jLabel11.setText("Name: "+jTextField6.getText());
                rs.jLabel10.setText("Post: "+jTextField2.getText());
                rs.jLabel12.setText("Vote: "+jLabel16.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==c)
                rs.jLabel22.setText("Winner");
                else
                rs.jLabel22.setText(null);
            }
            else
            {
                rs.jLabel11.setText("Name: "+jTextField6.getText());
                rs.jLabel10.setText("Post: "+jTextField2.getText());
                rs.jLabel12.setText("Vote: "+jLabel16.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==c)
                rs.jLabel22.setText("Winner");
                else
                rs.jLabel22.setText(null);
            }
        }
        
        {
            if(jLabel10.getIcon()!=null)
            {
                ImageIcon imn= (ImageIcon) jLabel10.getIcon();
                Image io=imn.getImage();
                Image oi=io.getScaledInstance(rs.jLabel19.getWidth(), rs.jLabel19.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newoi=new ImageIcon(oi);
                rs.jLabel19.setIcon(newoi);
                rs.jLabel14.setText("Name: "+jTextField5.getText());
                rs.jLabel15.setText("Post: "+jTextField2.getText());
                rs.jLabel13.setText("Vote: "+jLabel17.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==d)
                rs.jLabel23.setText("Winner");
                else
                rs.jLabel23.setText(null);
            }
            else
            {
                rs.jLabel14.setText("Name: "+jTextField5.getText());
                rs.jLabel15.setText("Post: "+jTextField2.getText());
                rs.jLabel13.setText("Vote: "+jLabel17.getText());
                if(Integer.max(Integer.max(a, b),Integer.max(c, d))==d)
                rs.jLabel23.setText("Winner");
                else
                rs.jLabel23.setText(null);
            }
        }
        
        rs.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseEntered
        jButton16.setForeground(new Color(86, 186, 220));
    }//GEN-LAST:event_jButton16MouseEntered

    private void jButton16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseExited
        jButton16.setForeground(new Color(0,153,204));
    }//GEN-LAST:event_jButton16MouseExited

    private void jButton16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MousePressed
        jButton16.setForeground(new Color(169, 220, 237));
        jButton16.setLocation(jButton16.getX()+1, jButton16.getY());
    }//GEN-LAST:event_jButton16MousePressed

    private void jButton16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseReleased
        jButton16.setForeground(new Color(86, 186, 220));
        jButton16.setLocation(jButton16.getX()-1, jButton16.getY());
    }//GEN-LAST:event_jButton16MouseReleased

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String url1="Delete From Voters";
        try {
            pst=conn.prepareStatement(url1);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Votting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        About ab= new About();
        ab.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jToggleButton8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton8MouseEntered
        jPanel6.setBackground(new Color(43, 51, 73)); 
    }//GEN-LAST:event_jToggleButton8MouseEntered

    private void jToggleButton8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton8MouseExited
       jPanel6.setBackground(new Color(14, 14, 35));
    }//GEN-LAST:event_jToggleButton8MouseExited

    private void jToggleButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton8MousePressed
         jPanel6.setLocation(239, 1);
        jPanel6.setBackground(new Color(90, 93, 127));
    }//GEN-LAST:event_jToggleButton8MousePressed

    private void jToggleButton8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton8MouseReleased
        jPanel6.setLocation(238, 1);
        jPanel6.setBackground(new Color(43, 51, 73));
    }//GEN-LAST:event_jToggleButton8MouseReleased

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        Update up = new Update();
        up.jTextField1.setText(jLabel11.getText());
        up.setVisible(true);
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton9MouseEntered
        jPanel8.setBackground(new Color(43, 51, 73)); 
    }//GEN-LAST:event_jToggleButton9MouseEntered

    private void jToggleButton9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton9MouseExited
        jPanel8.setBackground(new Color(14, 14, 35));
    }//GEN-LAST:event_jToggleButton9MouseExited

    private void jToggleButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton9MousePressed
        jPanel8.setLocation(271, 1);
        jPanel8.setBackground(new Color(90, 93, 127));
    }//GEN-LAST:event_jToggleButton9MousePressed

    private void jToggleButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton9MouseReleased
        jPanel8.setLocation(270, 1);
        jPanel8.setBackground(new Color(43, 51, 73));
    }//GEN-LAST:event_jToggleButton9MouseReleased

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        Delete dl= new Delete();
        dl.jTextField1.setText(jLabel11.getText());
        dl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        String result=JOptionPane.showInputDialog(null,"Please Enter Post Name","Input Box",JOptionPane.DEFAULT_OPTION);
        if(result==null||"".equals(result))
        {
            jTextField2.setForeground(new Color(100,119,123));
            jTextField2.setText("Please Click Here to Add Post Name");
            jTextField2.setFont(new Font("Sitka Heading",Font.PLAIN,24));
        }
        else
        {
            jTextField2.setForeground(new Color(56,110,152));
            jTextField2.setText(result);
            jTextField2.setFont(new Font("Sitka Heading",Font.PLAIN,36));
        }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        createpdf();
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        jLabel24.setForeground(new Color(86, 186, 220));
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        jLabel24.setForeground(new Color(0,153,204));
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MousePressed
        jLabel24.setForeground(new Color(169, 220, 237));
        jLabel24.setLocation(jLabel24.getX()+1, jLabel24.getY());
    }//GEN-LAST:event_jLabel24MousePressed

    private void jLabel24MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseReleased
        jLabel24.setForeground(new Color(86, 186, 220));
        jLabel24.setLocation(jLabel24.getX()-1, jLabel24.getY());
    }//GEN-LAST:event_jLabel24MouseReleased
  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Votting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Votting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Votting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Votting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Votting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    // End of variables declaration//GEN-END:variables

    
}
