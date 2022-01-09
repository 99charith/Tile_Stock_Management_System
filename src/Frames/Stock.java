/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import codes.Dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Charith
 */
public class Stock extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst=null;
    ResultSet rs=null;
            
            
    public Stock() {
        initComponents();
        conn = Dbconnect.connect();
        tableLoad();
        cartLoad();
        clearCart();
    }
    
    public Stock(int call) {
        initComponents();
        conn = Dbconnect.connect();
        tableLoad();
        cartLoad();
      
    }
    
    public void clearCart(){
        try {
               
               String sql="delete from cart";
               pst=conn.prepareStatement(sql);
               pst.execute();
               cartLoad();
               clear();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
    }
    
    public void tableLoad()
    {
        try {
        String sql="select * from stock";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        
        }
    }
    
    public void cartLoad()
    {
        try {
        String sql="select * from cart";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tablec.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        
        }
    }

    public void searchName(){
        
        String search=srch.getText();
        
        try {
            String sql="select * from stock where Tile_Name like'%"+search+"%'" ;
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            
        }
    }
    
       public void searchId(){
        
        String search=srch.getText();
        
        try {
            String sql="select * from stock where Tile_Id like'%"+search+"%'" ;
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            
        }
    }
       
       public void searchColour(){
        
        String search=srch.getText();
        
        try {
            String sql="select * from stock where Tile_Colour like'%"+search+"%'" ;
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            
        }
    }
       
      public void searchQuantity(){
        
        String search=srch.getText();
        
        try {
            String sql="select * from stock where Quantity>'"+search+"'" ;
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            
        }
    }
      
      public void searchSize(){
        
        String search=srch.getText();
        
        try {
            String sql="select * from stock where Size like'%"+search+"%'" ;
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            
        }
    }
      
    public void tableData(){
        int r=table.getSelectedRow();
        
        String id=table.getValueAt(r,0).toString();
        String name=table.getValueAt(r,1).toString();
        String colour=table.getValueAt(r,2).toString();
        String quantity=table.getValueAt(r,3).toString();
        String size=table.getValueAt(r,4).toString();
        String price=table.getValueAt(r,5).toString();
        String discount=table.getValueAt(r,6).toString();
        
        tid.setText(id);
        tn.setText(name);
        tc.setText(colour);
        q.setText(quantity);
        s.setText(size);
        p.setText(price);
        d.setText(discount);
    } 
    
      public void cartData(){
        int r=tablec.getSelectedRow();
        
        String id=tablec.getValueAt(r,0).toString();
        String name=tablec.getValueAt(r,1).toString();
        String quantity=tablec.getValueAt(r,2).toString();
        String price=tablec.getValueAt(r,3).toString();
        String discount=tablec.getValueAt(r,4).toString();
        
        tid.setText(id);
        tn.setText(name);
   
        q.setText(quantity);
       qq.setText(quantity);
        p.setText(price);
        d.setText(discount);
    } 
      
    public void clear(){
         tid.setText("");
        tn.setText("");
        tc.setText("");
        s.setText("");
        q.setText("");
        qq.setText("");
        p.setText("");
        d.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        srch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        srchby = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tid = new javax.swing.JLabel();
        s = new javax.swing.JLabel();
        tn = new javax.swing.JLabel();
        tc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        q = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        crt = new javax.swing.JButton();
        qq = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        crt1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lgo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        insert = new javax.swing.JButton();
        am = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        clrcrt = new javax.swing.JButton();
        pb = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rf = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablec = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ABC Lanka PVT. LTD.");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        srch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchActionPerformed(evt);
            }
        });
        srch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srchKeyReleased(evt);
            }
        });
        jPanel3.add(srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Search Tile Collection");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        srchby.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        srchby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "By Color", "By Size", "By Tile Id", "By Tile Name", "By Quantity", " " }));
        srchby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchbyActionPerformed(evt);
            }
        });
        jPanel3.add(srchby, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 135, 30));

        jPanel5.setBackground(new java.awt.Color(102, 255, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Details________________________");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tile Id");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tile Name");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tile Colour");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        tid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tid.setText("none");
        jPanel5.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 139, -1));

        s.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        s.setText("none");
        jPanel5.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 50, -1));

        tn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tn.setText("none");
        jPanel5.add(tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, -1));

        tc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tc.setText("none");
        jPanel5.add(tc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 139, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Quantity");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Size");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        q.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        q.setText("none");
        jPanel5.add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 50, -1));

        p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        p.setText("none");
        jPanel5.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 139, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Price");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Discount");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        d.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        d.setText("none");
        jPanel5.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 40, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("%");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        crt.setBackground(new java.awt.Color(153, 153, 153));
        crt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        crt.setText("Add to Cart");
        crt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtActionPerformed(evt);
            }
        });
        jPanel7.add(crt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 160, 40));

        qq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qqActionPerformed(evt);
            }
        });
        jPanel7.add(qq, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 80, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Quantity");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        crt1.setBackground(new java.awt.Color(153, 153, 153));
        crt1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        crt1.setText("Remove From Cart");
        crt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crt1ActionPerformed(evt);
            }
        });
        jPanel7.add(crt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, 40));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Clear Quantity");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, 40));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 210, 200));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 450, 410));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 440, 100));

        lgo.setBackground(new java.awt.Color(153, 153, 153));
        lgo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lgo.setText("Logout");
        lgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lgoActionPerformed(evt);
            }
        });
        jPanel3.add(lgo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 160, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 440, 620));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 490, 470));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insert.setBackground(new java.awt.Color(153, 153, 153));
        insert.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        insert.setText("Insert New Item");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        jPanel4.add(insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 170, 50));

        am.setBackground(new java.awt.Color(153, 153, 153));
        am.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        am.setText("Admin Management");
        am.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amActionPerformed(evt);
            }
        });
        jPanel4.add(am, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 180, 50));

        update.setBackground(new java.awt.Color(153, 153, 153));
        update.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        update.setText("Update this Item");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel4.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 170, 50));

        delete1.setBackground(new java.awt.Color(153, 153, 153));
        delete1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        delete1.setText("Delete this Item");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        jPanel4.add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 170, 50));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clrcrt.setBackground(new java.awt.Color(153, 153, 153));
        clrcrt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        clrcrt.setText("Clear Cart");
        clrcrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clrcrtActionPerformed(evt);
            }
        });
        jPanel8.add(clrcrt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 170, 50));

        pb.setBackground(new java.awt.Color(153, 153, 153));
        pb.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pb.setText("Pay The Bill");
        pb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbActionPerformed(evt);
            }
        });
        jPanel8.add(pb, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 180, 50));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 100));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 880, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ABC Lanka PVT Ltd.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 360, 34));

        rf.setText("Refresh DataBase");
        rf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfActionPerformed(evt);
            }
        });
        jPanel1.add(rf, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        tablec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecMouseClicked(evt);
            }
        });
        tablec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablecKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tablec);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 380, 340));

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Items In Cart");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 380, 70));

        jLabel10.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Charith@");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, -10, 1390, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srchActionPerformed

    private void srchbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchbyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srchbyActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
        
        String tilId=tid.getText();
        String tilName=tn.getText();
        String tilColour=tc.getText();
        float size=Float.parseFloat(s.getText());
        int qantity=Integer.parseInt(q.getText());
        float price=Float.parseFloat(p.getText());
        float discount=Float.parseFloat(d.getText()); 
        
        Update u=new Update(tilId,tilName,tilColour,size,qantity,price,discount);
        u.setVisible(true);
         dispose();    
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Please Select An Item !\n\n"+e);
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void amActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amActionPerformed
       Confirm cc=new Confirm();
       cc.setVisible(true);
       dispose();
       
    }//GEN-LAST:event_amActionPerformed

    private void srchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srchKeyReleased
        int sss=srchby.getSelectedIndex();
        switch(sss)
        {
            case 0:
            {
                searchColour();
                break;
            }
            case 1:
            {
                searchSize();
                break;
            }
            case 2:
            {
                searchId();
            break;
            }
            case 3:
            {
                searchName();
                break;
            }
            case 4:
            {
                searchQuantity();
                break;
            }
        }
        
    }//GEN-LAST:event_srchKeyReleased

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        Insert i=new Insert();
        i.setVisible(true);
        dispose();
      
    }//GEN-LAST:event_insertActionPerformed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        tableData();
        cartLoad();
    }//GEN-LAST:event_tableKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        tableData();
        cartLoad();
    }//GEN-LAST:event_tableMouseClicked

    private void rfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfActionPerformed
        tableLoad();
    }//GEN-LAST:event_rfActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        int check=JOptionPane.showConfirmDialog(null,"Do you want to delete this entry? ");
       
       if(check==0)
       {
           String tids=tid.getText();
           try {
               
               String sql="delete from stock where Tile_Id='"+tids+"'";
               pst=conn.prepareStatement(sql);
               pst.execute();
               JOptionPane.showMessageDialog(null,"Deleted");
               tableLoad();
               clear();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
       }
    }//GEN-LAST:event_delete1ActionPerformed

    private void crtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtActionPerformed
        String till=tid.getText();
        String tilName=tn.getText();
        float price=Float.parseFloat(p.getText());
        float discount=Float.parseFloat(d.getText());
        String quan=q.getText();
        
        try{
            int quint=Integer.parseInt(quan);
            int quantity=Integer.parseInt(qq.getText());
            if(quantity<=quint){
             String arg1="insert into cart(Item_Id,Item_Name,Quantity,Price,Discount) values('"+till+"','"+tilName+"','"+quantity+"','"+price+"','"+discount+"')";
             pst=conn.prepareStatement(arg1);
             pst.execute();
            JOptionPane.showMessageDialog(null,"Added to Cart");
            cartLoad();
            }
            else{
                JOptionPane.showMessageDialog(null,"No Enough Items in Stock");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ënter valid amount for quantity\n\n"+ e);
    }                       
    }//GEN-LAST:event_crtActionPerformed

    private void qqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qqActionPerformed

    private void crt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crt1ActionPerformed
         int check=JOptionPane.showConfirmDialog(null,"Do you want to delete this entry? ");
       
       if(check==0)
       {
           String tids=tid.getText();
           int quint=Integer.parseInt(q.getText());
           
           try {
               
               String sql="delete from cart where Item_Id='"+tids+"' and Quantity='"+quint+"'";
               pst=conn.prepareStatement(sql);
               pst.execute();
               JOptionPane.showMessageDialog(null,"Deleted from cart");
               cartLoad();
               clear();
               
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }}
    }//GEN-LAST:event_crt1ActionPerformed

    private void tablecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablecKeyReleased
        cartData();
        tableLoad();
    }//GEN-LAST:event_tablecKeyReleased

    private void tablecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablecMouseClicked
        cartData();
        tableLoad();
    }//GEN-LAST:event_tablecMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        qq.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbActionPerformed
        Pay p=new Pay();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_pbActionPerformed

    private void clrcrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clrcrtActionPerformed
        int check=JOptionPane.showConfirmDialog(null,"Do you want to clear the cart? ");
       
       if(check==0)
       {
           try {
               
               String sql="delete from cart";
               pst=conn.prepareStatement(sql);
               pst.execute();
               JOptionPane.showMessageDialog(null,"Cart Cleared");
               cartLoad();
               clear();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
       }
    }//GEN-LAST:event_clrcrtActionPerformed

    private void lgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lgoActionPerformed

        int check=JOptionPane.showConfirmDialog(null,"Do you want to logout? ");
       
       if(check==0)
       {
        Login l=new Login();
        l.setVisible(true);
        dispose();
       }
    }//GEN-LAST:event_lgoActionPerformed
    
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
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton am;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton clrcrt;
    private javax.swing.JButton crt;
    private javax.swing.JButton crt1;
    private javax.swing.JLabel d;
    private javax.swing.JButton delete1;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton lgo;
    private javax.swing.JLabel p;
    private javax.swing.JButton pb;
    private javax.swing.JLabel q;
    private javax.swing.JTextField qq;
    private javax.swing.JButton rf;
    private javax.swing.JLabel s;
    private javax.swing.JTextField srch;
    private javax.swing.JComboBox<String> srchby;
    private javax.swing.JTable table;
    private javax.swing.JTable tablec;
    private javax.swing.JLabel tc;
    private javax.swing.JLabel tid;
    private javax.swing.JLabel tn;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
