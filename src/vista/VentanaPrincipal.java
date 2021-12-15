
package vista;

import controlador.AlumnoDAO;
import javax.swing.JOptionPane;
import modelo.Alumno;

public class VentanaPrincipal extends javax.swing.JFrame {

    
    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        btnIngresar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnNota = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnqAlumno = new javax.swing.JMenu();
        mnuIngresar = new javax.swing.JMenuItem();
        mnuEliminar = new javax.swing.JMenuItem();
        mnuModificar = new javax.swing.JMenuItem();
        mnqMostrar = new javax.swing.JMenu();
        mnuTodos = new javax.swing.JMenuItem();
        mnuNota = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIngresar.setText("Ingresar Alumno");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Datos");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnNota.setText("Nota Final - Situación");
        btnNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Alumno");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        mnqAlumno.setText("Alumno");

        mnuIngresar.setText("Ingresar");
        mnuIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIngresarActionPerformed(evt);
            }
        });
        mnqAlumno.add(mnuIngresar);

        mnuEliminar.setText("Eliminar");
        mnuEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEliminarActionPerformed(evt);
            }
        });
        mnqAlumno.add(mnuEliminar);

        mnuModificar.setText("Modificar");
        mnuModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuModificarActionPerformed(evt);
            }
        });
        mnqAlumno.add(mnuModificar);

        jMenuBar1.add(mnqAlumno);

        mnqMostrar.setText("Mostrar");

        mnuTodos.setText("A Todos");
        mnuTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTodosActionPerformed(evt);
            }
        });
        mnqMostrar.add(mnuTodos);

        mnuNota.setText("Nota Final");
        mnuNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNotaActionPerformed(evt);
            }
        });
        mnqMostrar.add(mnuNota);

        jMenuBar1.add(mnqMostrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNota)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnIngresar)
                .addGap(33, 33, 33)
                .addComponent(btnMostrar)
                .addGap(26, 26, 26)
                .addComponent(btnNota)
                .addGap(29, 29, 29)
                .addComponent(btnEliminar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        VentanaIngreso ven=new VentanaIngreso();
        ven.setVisible(true);
        ven.setLocationRelativeTo(null);
        ven.setTitle("Ingreso Alumno");
        ven.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaActionPerformed
        String rut=JOptionPane.showInputDialog("Ingrese el Rut Del Alumno a Buscar:");
        AlumnoDAO aluDAO=new AlumnoDAO();
        Alumno alu=aluDAO.buscaralumno(rut);
        if(alu!=null)
        {
            double notaexamen=Double.parseDouble(JOptionPane.showInputDialog("Ingrese la Nota Del Examen"));
            JOptionPane.showMessageDialog(this, "La Nota Final es "+
                    alu.notafinal(notaexamen)+" Esta "+
                    alu.situacion(notaexamen));
        }
        else
        {
            JOptionPane.showMessageDialog(this, "El Alumno no Existe");
        }
        
    }//GEN-LAST:event_btnNotaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String rut=JOptionPane.showInputDialog("Ingrese el Rut Del Alumno a Buscar:");
        AlumnoDAO aluDAO=new AlumnoDAO();
        if(aluDAO.eliminarAlumno(rut))
        {
           JOptionPane.showMessageDialog(this, "Alumno Eliminado"); 
        }
        else
        {
           JOptionPane.showMessageDialog(this, "El Alumno no Existe"); 
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        VentanaMostrar ven=new VentanaMostrar();
        ven.setVisible(true);
        ven.setLocationRelativeTo(null);
        ven.setTitle("Mostrar Curso");
        ven.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void mnuIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIngresarActionPerformed
        btnIngresarActionPerformed(evt);
    }//GEN-LAST:event_mnuIngresarActionPerformed

    private void mnuEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEliminarActionPerformed
        btnEliminarActionPerformed(evt);
    }//GEN-LAST:event_mnuEliminarActionPerformed

    private void mnuTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTodosActionPerformed
        btnMostrarActionPerformed(evt);
    }//GEN-LAST:event_mnuTodosActionPerformed

    private void mnuNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNotaActionPerformed
        btnNotaActionPerformed(evt);
    }//GEN-LAST:event_mnuNotaActionPerformed

    private void mnuModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuModificarActionPerformed
        VentanaModificar ven=new VentanaModificar();
        ven.setVisible(true);
        ven.setLocationRelativeTo(null);
        ven.setTitle("Modificar Alumno");
        ven.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
    }//GEN-LAST:event_mnuModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNota;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mnqAlumno;
    private javax.swing.JMenu mnqMostrar;
    private javax.swing.JMenuItem mnuEliminar;
    private javax.swing.JMenuItem mnuIngresar;
    private javax.swing.JMenuItem mnuModificar;
    private javax.swing.JMenuItem mnuNota;
    private javax.swing.JMenuItem mnuTodos;
    // End of variables declaration//GEN-END:variables
}
