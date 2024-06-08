package com.mycompany.views;

import com.mycompany.ilib.DAOBooksImpl;
import com.mycompany.ilib.DAOLendingsImpl;
import com.mycompany.ilib.DAOUsersImpl;
import com.mycompany.interfaces.DAOBooks;
import com.mycompany.interfaces.DAOLendings;
import com.mycompany.interfaces.DAOUsers;
import com.mycompany.utils.Utils;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.util.ByteArrayDataSource;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Lendings extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private String email;
    private String subject;
    private String message;

    public Lendings() {
        initComponents();
        InitStyles();
        setVisibleLabels(false);
    }

    private void setVisibleLabels(boolean visible) {

        lblTitle.setVisible(visible);
        lblTitleBook.setVisible(visible);
        lblDate.setVisible(visible);
        lblTitleBook1.setVisible(visible);
        lblDate1.setVisible(visible);
        lblTitleB1.setVisible(visible);
        lblDateB1.setVisible(visible);
        lblAuthor.setVisible(visible);
        lblCategory.setVisible(visible);
        lblEdit.setVisible(visible);
        lblLang.setVisible(visible);
        lblPags.setVisible(visible);
        lblTitleB.setVisible(visible);
        lblDateB.setVisible(visible);
        lblAuthorB.setVisible(visible);
        lblCategoryB.setVisible(visible);
        lblEditB.setVisible(visible);
        lblLangB.setVisible(visible);
        lblPagsB.setVisible(visible);
        lblDescription.setVisible(visible);
        lblDescription1.setVisible(visible);
        cbtRun.setVisible(visible);
        cbtRun.setSelected(!visible);
         cbtRun1.setVisible(visible);
        cbtRun1.setSelected(!visible);

    }

    private void InitStyles() {
        folioLbl.putClientProperty("FlatLaf.styleClass", "large");
        folioLbl.setForeground(Color.black);
        libroIdLbl.putClientProperty("FlatLaf.styleClass", "large");
        libroIdLbl.setForeground(Color.black);
        folioTxt.putClientProperty("JTextField.placeholderText", "Ingrese el folio del usuario.");
        libroIdTxt.putClientProperty("JTextField.placeholderText", "Ingrese el ID del Libro a prestar.");
        lblTitle.putClientProperty("FlatLaf.styleClass", "large");
        lblTitle.setForeground(Color.black);

        lblTitleBook.putClientProperty("FlatLaf.styleClass", "large");
        lblTitleBook.setForeground(Color.black);
        lblDate.putClientProperty("FlatLaf.styleClass", "large");
        lblDate.setForeground(Color.black);
        
        lblTitleBook1.putClientProperty("FlatLaf.styleClass", "large");
        lblTitleBook1.setForeground(Color.black);
        lblDate1.putClientProperty("FlatLaf.styleClass", "large");
        lblDate1.setForeground(Color.black);
        
        lblAuthor.putClientProperty("FlatLaf.styleClass", "large");
        lblAuthor.setForeground(Color.black);
        lblCategory.putClientProperty("FlatLaf.styleClass", "large");
        lblCategory.setForeground(Color.black);
        lblEdit.putClientProperty("FlatLaf.styleClass", "large");
        lblEdit.setForeground(Color.black);
        lblLang.putClientProperty("FlatLaf.styleClass", "large");
        lblLang.setForeground(Color.black);
        lblPags.putClientProperty("FlatLaf.styleClass", "large");
        lblPags.setForeground(Color.black);

        lblTitleB.putClientProperty("FlatLaf.styleClass", "large");
        lblTitleB.setForeground(Color.black);
        lblDateB.putClientProperty("FlatLaf.styleClass", "large");
        lblDateB.setForeground(Color.black);
        lblAuthorB.putClientProperty("FlatLaf.styleClass", "large");
        lblAuthorB.setForeground(Color.black);
        lblCategoryB.putClientProperty("FlatLaf.styleClass", "large");
        lblCategoryB.setForeground(Color.black);
        lblEditB.putClientProperty("FlatLaf.styleClass", "large");
        lblEditB.setForeground(Color.black);
        lblLangB.putClientProperty("FlatLaf.styleClass", "large");
        lblLangB.setForeground(Color.black);
        lblPagsB.putClientProperty("FlatLaf.styleClass", "large");
        lblPagsB.setForeground(Color.black);
        lblDescription.putClientProperty("FlatLaf.styleClass", "large");
        lblDescription.setForeground(Color.black);
        lblDescription1.putClientProperty("FlatLaf.styleClass", "large");
        lblDescription1.setForeground(Color.black);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        folioLbl = new javax.swing.JLabel();
        folioTxt = new javax.swing.JTextField();
        libroIdLbl = new javax.swing.JLabel();
        libroIdTxt = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTitleBook = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        lblEdit = new javax.swing.JLabel();
        lblLang = new javax.swing.JLabel();
        lblPags = new javax.swing.JLabel();
        lblTitleB = new javax.swing.JLabel();
        lblDateB = new javax.swing.JLabel();
        lblAuthorB = new javax.swing.JLabel();
        lblCategoryB = new javax.swing.JLabel();
        lblEditB = new javax.swing.JLabel();
        lblLangB = new javax.swing.JLabel();
        lblPagsB = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        cbtRun = new javax.swing.JRadioButton();
        lblTitleBook1 = new javax.swing.JLabel();
        lblTitleB1 = new javax.swing.JLabel();
        lblDate1 = new javax.swing.JLabel();
        lblDateB1 = new javax.swing.JLabel();
        lblDescription1 = new javax.swing.JLabel();
        cbtRun1 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        folioLbl.setText("Folio Usuario");

        folioTxt.setToolTipText("");
        folioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                folioTxtKeyTyped(evt);
            }
        });

        libroIdLbl.setText("Libro ID");

        libroIdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                libroIdTxtKeyTyped(evt);
            }
        });

        button.setBackground(new java.awt.Color(18, 90, 173));
        button.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setText("Prestar");
        button.setBorderPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitleBook.setText("Titulo");

        lblDate.setText("Fecha de Pub");

        lblTitle.setText("Datos del Libro");

        lblAuthor.setText("Autor");

        lblCategory.setText("Categoria");

        lblEdit.setText("Edicion");

        lblLang.setText("Idioma");

        lblPags.setText("Paginas");

        lblTitleB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblDateB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblAuthorB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblCategoryB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblEditB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblLangB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblPagsB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblDescription.setText("Selecciona si es el libro que buscas");

        cbtRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtRunActionPerformed(evt);
            }
        });

        lblTitleBook1.setText("Nombre");

        lblTitleB1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblDate1.setText("Correo Electronico");

        lblDateB1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));

        lblDescription1.setText("Selecciona si es tu usuario");

        cbtRun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtRun1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitleBook, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblTitleB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblDateB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblAuthorB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblCategoryB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblEditB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblLang, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblLangB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPags, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblPagsB, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDescription)
                                .addGap(96, 96, 96)
                                .addComponent(cbtRun))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitleBook1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(lblTitleB1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDateB1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDescription1)
                        .addGap(96, 96, 96)
                        .addComponent(cbtRun1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitle)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleBook)
                    .addComponent(lblTitleB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate)
                    .addComponent(lblDateB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAuthor)
                    .addComponent(lblAuthorB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategory)
                    .addComponent(lblCategoryB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEdit)
                    .addComponent(lblEditB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLang)
                    .addComponent(lblLangB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPags)
                    .addComponent(lblPagsB, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblDescription))
                    .addComponent(cbtRun))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitleBook1)
                    .addComponent(lblTitleB1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate1)
                    .addComponent(lblDateB1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblDescription1))
                    .addComponent(cbtRun1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(199, 199, 199))
                    .addComponent(folioTxt)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(223, 223, 223))
                    .addComponent(libroIdTxt)
                    .addComponent(button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addComponent(folioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addComponent(libroIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        String folio = folioTxt.getText();
        String bookId = libroIdTxt.getText();

        if (folio.isEmpty() || bookId.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe llenar todos los campos. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            folioTxt.requestFocus();
            return;
        } else if (!Utils.isNumeric(folio) || !Utils.isNumeric(bookId)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Los campos Folio y el ID del libro deben ser números enteros. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            folioTxt.requestFocus();
            return;
        } else if (Integer.parseInt(folio) <= 0 || Integer.parseInt(bookId) <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Los campos Folio y el ID del libro deben ser mayor que 0. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            folioTxt.requestFocus();
            return;
        }

        DAOUsers daoUsers = new DAOUsersImpl();

        // Validamos existencia del usuario
        com.mycompany.models.Users currentUser = null;
        try {
            currentUser = daoUsers.getUserById(Integer.parseInt(folio));
        } catch (Exception ex) {
            Logger.getLogger(Lendings.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (currentUser == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún usuario con ese folio. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            folioTxt.requestFocus();
            return;
        }

        DAOLendings daoLendings = new DAOLendingsImpl();

        try {
            List<com.mycompany.models.Lendings> lendings = daoLendings.listar(0,0);
            int prestamos = 0;

            for (int i = 0; i < lendings.size(); i++) {
                if (lendings.get(i).getUser_id() == currentUser.getId() && lendings.get(i).getDate_return() == null ) {
                    prestamos++;
                }
                if (prestamos == 4) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se pueden prestar mas de 4 libros al mismo usuario. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    this.setVisibleLabels(false);
                    return;
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Lendings.class.getName()).log(Level.SEVERE, null, ex);
        }

        DAOBooks daoBooks = new DAOBooksImpl();

        // Validamos existencia del libro
        com.mycompany.models.Books currentBook = null;
        try {
            currentBook = daoBooks.getBookById(Integer.parseInt(bookId));
        } catch (Exception ex) {
            Logger.getLogger(Lendings.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (currentBook == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró ningún libro con ese ID. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            libroIdTxt.requestFocus();
            return;
        } // Validamos disponibilidad del libro.
        else if (currentBook.getAvailable() < 1) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ya no hay más libros disponibles con esa ID para prestar. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            libroIdTxt.requestFocus();
            return;
        }

        if ( cbtRun.isSelected() && cbtRun.isVisible() && cbtRun1.isSelected() && cbtRun1.isVisible() ) {

            // Validaciones para los campos
            try {

                // Validamos que el usuario no tenga ya ese libro prestado.
                com.mycompany.models.Lendings currentLending = daoLendings.getLending(currentUser, currentBook);
                if (currentLending != null) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Esa persona ya cuenta con el préstamo de ese mismo Libro. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                    libroIdTxt.requestFocus();
                    setVisibleLabels(false);
                    return;
                }

                // Todo OK: Prestamos libro.
                com.mycompany.models.Lendings lending = new com.mycompany.models.Lendings();
                lending.setBook_id(currentBook.getId());
                lending.setUser_id(currentUser.getId());
                lending.setDate_out(Utils.getFechaActual());
                daoLendings.registrar(lending);

                // Modificamos el libro restandole 1 en disponibilidad.
                currentBook.setAvailable(currentBook.getAvailable() - 1);
                daoBooks.modificar(currentBook);

                javax.swing.JOptionPane.showMessageDialog(this, "Libro ID: " + currentBook.getId() + " prestado exitosamente a " + currentUser.getName() + ".\n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                try {
                    DAOBooks dao = new DAOBooksImpl();
                    DAOUsers daoUser = new DAOUsersImpl();

                    com.mycompany.models.Users user = daoUser.listarId(folioTxt.getText()).get(0);
                    com.mycompany.models.Books book = dao.listarId(libroIdTxt.getText()).get(0);

                    email = user.getTel();

                    crearPdf(book.getTitle(), book.getAuthor(), book.getCategory(), book.getDate(), book.getPages());

                    subject = "Reporte de prestamo de libro";
                    message = "encontraras los detalles en el siguiente archivo";

                    sendEmail();

                    folioTxt.setText("");
                    libroIdTxt.setText("");
                    setVisibleLabels(false);
                    lblTitleB.setText("");
                    lblDateB.setText("");
                    lblAuthorB.setText("");
                    lblCategoryB.setText("");
                    lblEditB.setText("");
                    lblLangB.setText("");
                    lblPagsB.setText("");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error al prestar el libro. \n", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
            }
        } else {
            setVisibleLabels(true);
            DAOBooks dao = new DAOBooksImpl();
            DAOUsers daoUser = new DAOUsersImpl();
            try {
                com.mycompany.models.Users user = daoUser.listarId(folioTxt.getText()).get(0);
                lblTitleB1.setText(user.getName()+" "+user.getLast_name_p()+" "+user.getLast_name_m());
                lblDateB1.setText(user.getTel());
            } catch (Exception ex) {
                Logger.getLogger(Lendings.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                com.mycompany.models.Books book = dao.listarId(libroIdTxt.getText()).get(0);
                lblTitleB.setText(book.getTitle());
                lblDateB.setText(book.getDate());
                lblAuthorB.setText(book.getAuthor());
                lblCategoryB.setText(book.getCategory());
                lblEditB.setText(book.getEdit());
                lblLangB.setText(book.getLang());
                lblPagsB.setText(book.getPages());

            } catch (Exception ex) {
                Logger.getLogger(Lendings.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_buttonActionPerformed

    private void folioTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_folioTxtKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignorar la entrada de caracteres no deseados
        }
    }//GEN-LAST:event_folioTxtKeyTyped

    private void libroIdTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_libroIdTxtKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();  // Ignorar la entrada de caracteres no deseados
        }
    }//GEN-LAST:event_libroIdTxtKeyTyped

    private void cbtRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtRunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtRunActionPerformed

    private void cbtRun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtRun1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtRun1ActionPerformed

    public void crearPdf(String title, String author, String category, String releaseDate, String pageCount) {
        // Crear un nuevo documento PDF
        PDDocument document = new PDDocument();

        try {
            // Añadir una página al documento
            PDPage page = new PDPage();
            document.addPage(page);

            String[] rules = {
                "• Respetar los plazos de devolución establecidos para evitar penalizaciones.",
                "• Utilizar correctamente las credenciales de acceso proporcionadas para el ",
                "  servicio en línea.",
                "• No compartir las credenciales de acceso con terceros para garantizar la seguridad",
                "  de la cuenta.",
                "• Descargar y leer los libros electrónicos de acuerdo con las políticas de uso ",
                "  establecidas.",
                "• No realizar copias ilegales o distribuir el contenido descargado de forma no ",
                "  autorizada.",
                "• Reportar cualquier problema técnico o dificultad de acceso al personal de la biblioteca.",
                "• Respetar los derechos de autor y las licencias de los materiales digitales.",
                "• Utilizar los recursos en línea de manera ética y responsable.",
                "• Evitar el acceso a sitios web o contenido que no esté relacionado con la investigación",
                "académica o la lectura recreativa.",
                "• Cerrar sesión correctamente después de usar los servicios en línea para proteger",
                "  la privacidad de la cuenta.",
                "© 2024 Biblioteca Trinity. Todos los derechos reservados."
            };

            // Iniciar una nueva secuencia de contenido
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Dibujar los márgenes
            contentStream.setLineWidth(2);
            contentStream.setStrokingColor(0, 0, 0); // Color negro
            contentStream.moveTo(40, 40);
            contentStream.lineTo(40, 750);
            contentStream.lineTo(550, 750);
            contentStream.lineTo(550, 40);
            contentStream.closeAndStroke();

            // Dibujar encabezado
            contentStream.setStrokingColor(100, 100, 100); // Color gris claro
            contentStream.moveTo(40, 740);
            contentStream.lineTo(550, 740);
            contentStream.closeAndStroke();

            // Dibujar pie de página
            contentStream.moveTo(40, 50);
            contentStream.lineTo(550, 50);
            contentStream.closeAndStroke();

            // Escribir fecha en el encabezado
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String date = sdf.format(new Date());

            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.beginText();
            contentStream.newLineAtOffset(450, 755);
            contentStream.showText("Fecha: " + date);
            contentStream.endText();

            // Cargar la imagen del logo desde el classpath
            InputStream in = getClass().getResourceAsStream("/images/logo.png");
            if (in == null) {
                System.err.println("No se pudo encontrar el archivo logo.png");
                return;
            }
            PDImageXObject logo = PDImageXObject.createFromByteArray(document, in.readAllBytes(), "logo.png");

            // Dibujar la imagen del logo en la página
            contentStream.drawImage(logo, 50, 690, 60, 60); // ajustar las coordenadas y tamaño según sea necesario

            // Escribir el título
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
            contentStream.beginText();
            contentStream.newLineAtOffset(120, 720); // ajustar la posición para dejar espacio para el logo
            contentStream.showText("Biblioteca Trinity");
            contentStream.endText();

            // Escribir subtítulo
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
            contentStream.beginText();
            contentStream.newLineAtOffset(120, 690);
            contentStream.showText("Reporte de Préstamo");
            contentStream.endText();

            // Dibujar línea separadora
            contentStream.setStrokingColor(200, 200, 200); // Color gris claro
            contentStream.moveTo(40, 680);
            contentStream.lineTo(550, 680);
            contentStream.closeAndStroke();

            // Escribir detalles del libro
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 640);
            contentStream.showText("Ha sido prestado el siguiente libro:");
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 620);
            contentStream.showText("Título: " + title);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 600);
            contentStream.showText("Autor: " + author);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 580);
            contentStream.showText("Categoría: " + category);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 560);
            contentStream.showText("Fecha de lanzamiento: " + releaseDate);
            contentStream.endText();

            contentStream.beginText();
            contentStream.newLineAtOffset(50, 540);
            contentStream.showText("Cantidad de páginas: " + pageCount);
            contentStream.endText();

            // Dibujar línea separadora
            contentStream.setStrokingColor(200, 200, 200); // Color gris claro
            contentStream.moveTo(40, 520);
            contentStream.lineTo(550, 520);
            contentStream.closeAndStroke();

            // Escribir título de las reglas
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 500);
            contentStream.showText("Reglas de la Biblioteca:");
            contentStream.endText();

            // Escribir las reglas
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            int yPosition = 480;
            for (String rule : rules) {
                contentStream.beginText();
                if (rule.charAt(0) == "©".charAt(0)) {
                    yPosition -= 80;
                }
                contentStream.newLineAtOffset(80, yPosition);
                contentStream.showText(rule);
                contentStream.endText();
                yPosition -= 20; // Ajusta el espaciado según sea necesario

                if (yPosition < 60) {
                    contentStream.close();
                    page = new PDPage();
                    document.addPage(page);
                    contentStream = new PDPageContentStream(document, page);
                    yPosition = 750;

                    // Redibujar los márgenes
                    contentStream.setLineWidth(2);
                    contentStream.setStrokingColor(0, 0, 0); // Color negro
                    contentStream.moveTo(40, 40);
                    contentStream.lineTo(40, 750);
                    contentStream.lineTo(550, 750);
                    contentStream.lineTo(550, 40);
                    contentStream.closeAndStroke();

                }
            }

            // Cerrar la secuencia de contenido
            contentStream.close();

            // Guardar el documento en un archivo
            document.save("ReporteBibliotecaTrinity.pdf");
            System.out.println("PDF creado exitosamente.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendEmail() throws IOException {
        // Configuración de las propiedades para la conexión con el servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Cambia "smtp.example.com" por tu servidor SMTP
        props.put("mail.smtp.port", "587"); // Puerto SMTP
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Credenciales de autenticación
        String username = "bibliotecatrinity0@gmail.com"; // Cambia por tu dirección de correo electrónico
        String password = "srus nnqo tjng hvkf"; // Cambia por tu contraseña

        // Creación de la sesión
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Creación del mensaje
            MimeMessage emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(username));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            emailMessage.setSubject(subject);

            // Crear el cuerpo del mensaje en formato HTML
            String htmlContent = "<h1 style='color: #0047AB;'>Reporte de la Biblioteca Trinity</h1>"
                    + "<p>Estimado/a usuario/a</p>"
                    + "<p>Adjunto encontrará el reporte de la Biblioteca Trinity.</p>"
                    + "<p>¡Gracias por su colaboración!</p>"
                    + "<p>Atentamente,<br/>"
                    + "Biblioteca Trinity</p>"
                    + "© 2024 Biblioteca Trinity. Todos los derechos reservados</p>"
                    + "<p><img src='cid:logo' alt='Logo Biblioteca'></p>"
                    + "<hr/>"
                    + "<p style='font-size: 10px; color: #666;'>© " + Calendar.getInstance().get(Calendar.YEAR) + " Biblioteca Trinity. Todos los derechos reservados.</p>";

            // Adjuntar el archivo PDF al mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlContent, "text/html; charset=utf-8");

            // Adjuntar la imagen del logo
            MimeBodyPart imagePart = new MimeBodyPart();
            // Cargar la imagen desde el classpath
            InputStream logoStream = getClass().getResourceAsStream("/images/logo.png");
            if (logoStream == null) {
                System.err.println("No se pudo encontrar el archivo logo.png");
                return;
            }
            DataSource fds = new ByteArrayDataSource(logoStream, "image/png");
            imagePart.setDataHandler(new DataHandler(fds));
            imagePart.setHeader("Content-ID", "<logo>");
            imagePart.setDisposition(MimeBodyPart.INLINE);

            // Crear el multipart para el cuerpo del mensaje
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(imagePart);

            // Adjuntar el PDF
            MimeBodyPart attachPart = new MimeBodyPart();
            DataSource source = new FileDataSource("ReporteBibliotecaTrinity.pdf");
            attachPart.setDataHandler(new DataHandler(source));
            attachPart.setFileName("ReporteBibliotecaTrinity.pdf");
            multipart.addBodyPart(attachPart);

            // Establecer el contenido del mensaje con los archivos adjuntos
            emailMessage.setContent(multipart);

            // Envío del mensaje
            Transport.send(emailMessage);

            JOptionPane.showMessageDialog(null, "Envío de correo exitoso.");
        } catch (MessagingException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al enviar el correo electrónico: " + ex.getMessage());
        }

        String filePath = "ReporteBibliotecaTrinity.pdf";

        // Crear un objeto File con la ruta del archivo
        File file = new File(filePath);

        // Verificar si el archivo existe antes de intentar eliminarlo
        if (file.exists()) {
            // Intentar eliminar el archivo
            if (file.delete()) {
                System.out.println("El archivo se eliminó correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton button;
    private javax.swing.JRadioButton cbtRun;
    private javax.swing.JRadioButton cbtRun1;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JTextField folioTxt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblAuthorB;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCategoryB;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDate1;
    private javax.swing.JLabel lblDateB;
    private javax.swing.JLabel lblDateB1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescription1;
    private javax.swing.JLabel lblEdit;
    private javax.swing.JLabel lblEditB;
    private javax.swing.JLabel lblLang;
    private javax.swing.JLabel lblLangB;
    private javax.swing.JLabel lblPags;
    private javax.swing.JLabel lblPagsB;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleB;
    private javax.swing.JLabel lblTitleB1;
    private javax.swing.JLabel lblTitleBook;
    private javax.swing.JLabel lblTitleBook1;
    private javax.swing.JLabel libroIdLbl;
    private javax.swing.JTextField libroIdTxt;
    // End of variables declaration//GEN-END:variables
}
