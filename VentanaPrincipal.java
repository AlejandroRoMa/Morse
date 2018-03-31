/*
    Nombre del Autor: Abraham Alejandro Rosales Martinez 
    Correo:   lelalez@hotmail.com
    tel: 715 159 63 23
    Instituto Tecnologico de Zitacuaro 
    Ing Informatica 8º sem

    Programa desarrollado en NetBeans IDE 8.0.2 con JDK 1.8
    
    Para hacer uso del programa solo hay que introducir las palabras  o los codigos a traducir en la caja de texto superior 
    y el resultado ira apareciendo en la caja inferior, en caso de no encontrar el codigo o la letra equivalente de un codigo 
    aparecera un mensaje en la caja inferior.
    

*/

package morse;


import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author AbrahamAlejandro
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {        
        initComponents();
        setJTexFieldChanged(jTextTexto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextTraduccion = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextTexto = new javax.swing.JTextPane();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Traducciones entre Morse y Alfanumericos");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Ingrese el texto a traducir:");

        jTextTraduccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(jTextTraduccion);

        jLabel3.setText("La traducción es la siguente:");

        jTextTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane4.setViewportView(jTextTexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                        .addComponent(jScrollPane3))
                    .addComponent(jLabel1))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextTexto;
    private javax.swing.JTextPane jTextTraduccion;
    // End of variables declaration//GEN-END:variables

    private final String[] letrasMorse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    private final char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private final String[] numerosMorse = {".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};
    private final char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private void setJTexFieldChanged(JTextPane jTextTexto) {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!jTextTexto.getText().isEmpty()) {
                    jTextTraduccion.setText(traducir(jTextTexto.getText()));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!jTextTexto.getText().isEmpty()) {
                    jTextTraduccion.setText(traducir(jTextTexto.getText()));
                } else {
                    jTextTraduccion.setText("");
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
        jTextTexto.getDocument().addDocumentListener(documentListener);
    }

    private String traducir(String texto) {
        String traduccion = "";
        if (!evaluarCadena(texto)) {
            String[] palabras = texto.split(" ");
            for (int e = 0; e < palabras.length; e++) {
                String palabra = palabras[e].toUpperCase();
                for (int i = 0; i < palabra.length(); i++) {
                    char c = palabra.charAt(i);
                    String equivalente = obtenerCodigo(c);
                    if (!equivalente.equals("NO")) {
                        traduccion += equivalente + " ";
                    } else {
                        i = palabra.length();
                        e = palabras.length;
                        traduccion = "No es posible realizar la traduccion ya que se capturo un caracter sin la equivalencia";
                    }
                }
                traduccion += "  ";
            }
        } else {
            String[] palabras = texto.split("   ");
            for (int e = 0; e < palabras.length; e++) {
                String[] letras = palabras[e].split(" ");
                for (int i = 0; i < letras.length; i++) {
                    char c = obtenerCaracter(letras[i]);
                    if (c!='.') {
                        traduccion += c ;
                    } else {
                        i = letras.length;
                        e = palabras.length;
                        traduccion = "No es posible realizar la traduccion ya que se capturo un codigo sin la equivalencia";
                    }
                }
                traduccion += " ";
            }
        }
        return traduccion;
    }

    private String obtenerCodigo(char caracter) {
        if (Character.isDigit(caracter)) {
            for (int i = 0; i < numeros.length; i++) {
                if (caracter == numeros[i]) {
                    return numerosMorse[i];
                }
            }
        } else {
            for (int i = 0; i < letras.length; i++) {
                if (caracter == letras[i]) {
                    return letrasMorse[i];
                }
            }
        }
        return "NO";
    }

    private char obtenerCaracter(String codigo) {
        for (int i = 0; i < numerosMorse.length; i++) {
            if (codigo.equals(numerosMorse[i])) {
                return numeros[i];
            }
        }
        for (int i = 0; i < letrasMorse.length; i++) {
            if (codigo.equals(letrasMorse[i])) {
                return letras[i];
            }
        }
        return '.';
    }

    private static boolean evaluarCadena(String cadena) {
        return cadena.charAt(0) == '.' || cadena.charAt(0) == '-';
    }
}
