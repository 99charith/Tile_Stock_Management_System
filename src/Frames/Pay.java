/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import codes.Dbconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Charith
 */
public class Pay extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public Pay() {
        initComponents();
        conn = Dbconnect.connect();
        cartLoad();
        bkm.setVisible(false);
        pr.setVisible(false);
        
    }
    
    public void cartLoad(){
    
      try {
        String sql="select * from cart";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            tableb.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
       }
    
    public void createT(){
        
    }
    
    public void recipt(){
        int c=tableb.getRowCount();
        String[] item=new String[c];
        String it="";
        
        tp.setText("*************************************\n");
        tp.setText(tp.getText()+"**         ABC Lanka Privet Limited               **\n");
        tp.setText(tp.getText()+"*************************************\n");
        //tp.seText(tp.getText()+"Recipt Id : ");
        tp.setText(tp.getText()+"Items_______________________________\n\n");
        tp.setText(tp.getText()+"   It_Id           It_name\n\n");
        for(int i=0;i<tableb.getRowCount();i++)
        {
           
            item[i]=(i+1)+". "+tableb.getValueAt(i,0).toString()+"      "+tableb.getValueAt(i,1).toString()+"\n   "+tableb.getValueAt(i,2).toString()+"(Quantity)---"+tableb.getValueAt(i,3).toString()+"(Price)---"+tableb.getValueAt(i,4).toString()+"(Discount)\n";
        }
        
        for(int j=0;j<c;j++){
            it=it+item[j];
        }
        tp.setText(tp.getText()+it);
        tp.setText(tp.getText()+"\nTotal Amount  : "+tt.getText()+"\n\n");
        tp.setText(tp.getText()+"Cash Recieved : "+cr.getText()+"\n\n");
        tp.setText(tp.getText()+"Balance        : "+b.getText()+"\n\n\n");
        tp.setText(tp.getText()+"******* Thank You Come Again ************\n\n\n");
    }
    
    
    public void clear(){
        ii.setText("");
        in.setText("");
        qu.setText("");
        pri.setText("");
        dis.setText("");
    }
    
    public void setTotal(){
        float total=0;
       for(int i=0;i<tableb.getRowCount();i++)
       {
           total=total+((Float.parseFloat(tableb.getValueAt(i,3).toString()))*(Integer.parseInt(tableb.getValueAt(i,2).toString()))-(Float.parseFloat(tableb.getValueAt(i,4).toString()))/100*(((Float.parseFloat(tableb.getValueAt(i,3).toString())))*(Integer.parseInt(tableb.getValueAt(i,2).toString()))));
       }
       tt.setText(Float.toString(total));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableb = new javax.swing.JTable();
        cnsl = new javax.swing.JButton();
        bck = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        qu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ii = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        in = new javax.swing.JTextField();
        pri = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dis = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        gt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tp = new javax.swing.JTextPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cp = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cr = new javax.swing.JTextField();
        tt = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        tt1 = new javax.swing.JLabel();
        tt2 = new javax.swing.JLabel();
        tt3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        st = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        pr = new javax.swing.JButton();
        bkm = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pay The BIll");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Pay The Bill");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableb.setBackground(new java.awt.Color(204, 204, 204));
        tableb.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableb);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 47, 520, 300));

        cnsl.setBackground(new java.awt.Color(204, 204, 204));
        cnsl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cnsl.setText("Cancel");
        cnsl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnslActionPerformed(evt);
            }
        });
        jPanel2.add(cnsl, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 140, 52));

        bck.setBackground(new java.awt.Color(204, 204, 204));
        bck.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        bck.setText("Back to Cart");
        bck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckActionPerformed(evt);
            }
        });
        jPanel2.add(bck, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 140, 52));

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add.setText("Add to Cart");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, 170, 52));

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Items To Be Billed");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel3)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Quantity");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, -1, 20));

        qu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(qu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 90, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Item_Id");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        ii.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(ii, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 130, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Item_Name");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, -1, 20));

        in.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inActionPerformed(evt);
            }
        });
        jPanel2.add(in, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 130, 40));

        pri.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(pri, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 510, 90, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Price");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, -1, 20));

        dis.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 510, 90, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Discount");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, -1, 20));

        jPanel7.setBackground(new java.awt.Color(153, 255, 153));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Add External Items");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jLabel12)
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, -1, 50));

        gt.setBackground(new java.awt.Color(204, 204, 204));
        gt.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        gt.setText("Get Total Amount");
        gt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtActionPerformed(evt);
            }
        });
        jPanel2.add(gt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 170, 52));

        tp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(tp);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 350, 360));

        jPanel9.setBackground(new java.awt.Color(153, 255, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Reciept");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 11, -1, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 350, 50));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        cp.setBackground(new java.awt.Color(204, 204, 204));
        cp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cp.setText("Confirm Payment");
        cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Enter Billing Details");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Cash Recieved");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Total Bill Amount");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Balance");

        cr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tt.setText("-");

        b.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b.setText("-");

        tt1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tt1.setText("Rs.");

        tt2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tt2.setText("Rs.");

        tt3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tt3.setText("Rs.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tt1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tt2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tt3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cr, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tt1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b))
                .addGap(22, 22, 22))
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));

        st.setBackground(new java.awt.Color(51, 51, 51));
        st.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(st, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(st, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));

        pr.setBackground(new java.awt.Color(204, 204, 204));
        pr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pr.setText("Print Recipt");
        pr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prActionPerformed(evt);
            }
        });

        bkm.setBackground(new java.awt.Color(204, 204, 204));
        bkm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bkm.setText("Back To Main");
        bkm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bkm, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bkm, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pr, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Harlow Solid Italic", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Charith@");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(547, 547, 547)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cnslActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnslActionPerformed
        int check=JOptionPane.showConfirmDialog(null,"Do you want to cansel Billing? ");
       
       if(check==0)
       {
        {
           try {
               
               String sql="delete from cart";
               pst=conn.prepareStatement(sql);
               pst.execute();
               cartLoad();
               Stock ss=new Stock();
                ss.setVisible(true);
                this.dispose();
               ss.clear();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
       }
       }
    }//GEN-LAST:event_cnslActionPerformed

    private void bckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckActionPerformed
        Stock s=new Stock(0);
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_bckActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String tilId=ii.getText();
        String tilName=in.getText();
        int qantity=Integer.parseInt(qu.getText());
        float price=Float.parseFloat(pri.getText());
        float discount=Float.parseFloat(dis.getText());

        try {
             String arg1="insert into cart(Item_Id,Item_Name,Quantity,Price,Discount) values('"+tilId+"','"+tilName+"','"+qantity+"','"+price+"','"+discount+"')";
             pst=conn.prepareStatement(arg1);
             pst.execute();
             JOptionPane.showMessageDialog(null,"Added to Cart");
             cartLoad();
             clear();
             

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
    }                                    
    }//GEN-LAST:event_addActionPerformed

    private void inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inActionPerformed

    private void gtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtActionPerformed
        try {
            if(tableb.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null,"No Any Items to be Billed");
            }
            else
            {
                setTotal();
            }
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_gtActionPerformed

    private void cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpActionPerformed
        try {
        float cash=Float.parseFloat(cr.getText());
        
        float ttl=Float.parseFloat(tt.getText());
        
        if(cash>=ttl){
        b.setText(Float.toString((cash-ttl)));
        st.setText("Payment Sucessful");
        st.setVisible(true);
        st.setBackground(Color.green);
        cp.setVisible(false);
        
        
        try {
            int count=tableb.getRowCount();
            String[] tids=new String[count];  
            float[] quin=new float[count];
            
            for(int i=0;i<count;i++)
            {
                tids[i]=tableb.getValueAt(i,0).toString();
                quin[i]=Float.parseFloat(tableb.getValueAt(i,2).toString());
            }
            
            for(int j=0;j<count;j++)
            {
               String sql="Update stock set Quantity=Quantity-'"+quin[j]+"' where Tile_Id='"+tids[j]+"'";
               pst=conn.prepareStatement(sql);
               pst.execute();
            }
            
            bkm.setVisible(true);
            pr.setVisible(true);
            cnsl.setVisible(false);
            bck.setVisible(false);
            
            recipt();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
        
        }
        else
        {
        JOptionPane.showMessageDialog(null,"Enter Enough Cash Amount");
        st.setText("Payment Unsucessful");
        st.setVisible(true);
        st.setBackground(Color.red);
        }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Click GetTotal & Enter Cash Amount");
        }
    }//GEN-LAST:event_cpActionPerformed

    private void bkmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkmActionPerformed
       try {
               
               String sql="delete from cart";
               pst=conn.prepareStatement(sql);
               pst.execute();
               cartLoad();
               Stock ss=new Stock();
                ss.setVisible(true);
                this.dispose();
               ss.clear();
               ss.clearCart();
               
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null,e);
           }
    }//GEN-LAST:event_bkmActionPerformed

    private void prActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prActionPerformed
       
        
        try {
            tp.print();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_prActionPerformed

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
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel b;
    private javax.swing.JButton bck;
    private javax.swing.JButton bkm;
    private javax.swing.JButton cnsl;
    private javax.swing.JButton cp;
    private javax.swing.JTextField cr;
    private javax.swing.JTextField dis;
    private javax.swing.JButton gt;
    private javax.swing.JTextField ii;
    private javax.swing.JTextField in;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JButton pr;
    private javax.swing.JTextField pri;
    private javax.swing.JTextField qu;
    private javax.swing.JButton st;
    private javax.swing.JTable tableb;
    private javax.swing.JTextPane tp;
    private javax.swing.JLabel tt;
    private javax.swing.JLabel tt1;
    private javax.swing.JLabel tt2;
    private javax.swing.JLabel tt3;
    // End of variables declaration//GEN-END:variables
}
