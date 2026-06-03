/*
Materia: Topicos Avanzados de programación
Reto 5: Programación concurrente e hilos
Nombre completo: Fernando Jeovany Frausto Cortes
Fecha de elaboración: 28/05/2026
Nombre del Asesor: Andrés Espinal Jiménez
 */

package proyecto_carrera_atletica;

import javax.swing.JFrame; //Importaciones
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AthleticRaceInterface extends JFrame {
    
    private Runner[] runners = new Runner[5];
    private int contadorCorredores = 0;
    private int lugarLlegada = 1; // Contador para saber en qué lugar llegan a la meta

    private JTextField txtNombre; // creacion de elementos de la ventana
    private JButton btnRegistrar;
    private JTextArea txtRegistrados;
    private JTextArea txtResultados;
    private JButton btnIniciar;
    private JButton btnReiniciar;
    private JButton btnTerminar;

    public AthleticRaceInterface() {
        setTitle("Carrera atlética"); // Título de la ventana
        setSize(480, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Panel principal 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(210, 230, 245)); 
        
        Font fuenteTitulos = new Font("SansSerif", Font.PLAIN, 15);
        Font fuenteListas = new Font("SansSerif", Font.PLAIN, 14);
        Color colorTexto = new Color(100, 100, 100); // Texto gris oscuro

        // Registrar corredor
        JPanel pnlSec1 = new JPanel(new BorderLayout(10, 5));
        pnlSec1.setOpaque(false); // Para que se vea el fondo azul
        
        JLabel lblReg = new JLabel("Registrar corredor");
        lblReg.setFont(fuenteTitulos);
        pnlSec1.add(lblReg, BorderLayout.NORTH);

        JPanel pnlInput = new JPanel(new BorderLayout(10, 0));
        pnlInput.setOpaque(false);
        
        // Simulación del texto
        txtNombre = new JTextField("Ingresa nombre...");
        txtNombre.setForeground(Color.GRAY);
        txtNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtNombre.getText().equals("Ingresa nombre...")) {
                    txtNombre.setText("");
                    txtNombre.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtNombre.getText().isEmpty()) {
                    txtNombre.setForeground(Color.GRAY);
                    txtNombre.setText("Ingresa nombre...");
                }
            }
        });
        
        btnRegistrar = new JButton("Registrar");
        pnlInput.add(txtNombre, BorderLayout.CENTER);
        pnlInput.add(btnRegistrar, BorderLayout.EAST);
        pnlSec1.add(pnlInput, BorderLayout.CENTER);

        //Corredores registrados
        JPanel pnlSec2 = new JPanel(new BorderLayout(0, 5));
        pnlSec2.setOpaque(false);
        
        JLabel lblRegList = new JLabel("Corredores registrados");
        lblRegList.setFont(fuenteTitulos);
        pnlSec2.add(lblRegList, BorderLayout.NORTH);

        txtRegistrados = new JTextArea(7, 30);
        txtRegistrados.setEditable(false);
        txtRegistrados.setFont(fuenteListas);
        txtRegistrados.setForeground(colorTexto);
        pnlSec2.add(new JScrollPane(txtRegistrados), BorderLayout.CENTER);

        //Resultados
        JPanel pnlSec3 = new JPanel(new BorderLayout(10, 5));
        pnlSec3.setOpaque(false);
        
        JLabel lblRes = new JLabel("Resultados");
        lblRes.setFont(fuenteTitulos);
        pnlSec3.add(lblRes, BorderLayout.NORTH);

        txtResultados = new JTextArea(7, 20);
        txtResultados.setEditable(false);
        txtResultados.setFont(fuenteListas);
        txtResultados.setForeground(colorTexto);
        pnlSec3.add(new JScrollPane(txtResultados), BorderLayout.CENTER);

        // Acomodo de los 3 botones
        JPanel pnlBotones = new JPanel(new GridLayout(3, 1, 0, 10));
        pnlBotones.setOpaque(false);
        btnIniciar = new JButton("Iniciar");
        btnReiniciar = new JButton("Reiniciar");
        btnTerminar = new JButton("Terminar");
        
        pnlBotones.add(btnIniciar);
        pnlBotones.add(btnReiniciar);
        pnlBotones.add(btnTerminar);
        pnlSec3.add(pnlBotones, BorderLayout.EAST);

        
        mainPanel.add(pnlSec1);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15))); 
        mainPanel.add(pnlSec2);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        mainPanel.add(pnlSec3);

        add(mainPanel);

        //Configuracíon de los botones

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                if (nombre.isEmpty() || nombre.equals("Ingresa nombre...")) {
                    JOptionPane.showMessageDialog(null, "El nombre del corredor no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Validación para limitar el tamaño del nombre
                if (nombre.length() > 15) {
                    JOptionPane.showMessageDialog(null, "El nombre es demasiado largo. Máximo 15 caracteres permitidos.", "Longitud excedida", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (contadorCorredores >= 5) {
                    JOptionPane.showMessageDialog(null, "Ya se ha alcanzado el límite máximo de 5 corredores.", "Límite", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                runners[contadorCorredores] = new Runner(nombre);
              
                txtRegistrados.append((contadorCorredores + 1) + " - " + nombre + "\n");
                contadorCorredores++;
                
                // Restablecer
                txtNombre.setForeground(Color.GRAY);
                txtNombre.setText("Ingresa nombre...");
                mainPanel.requestFocus(); // Quita el foco de la caja de texto
            }
        });

        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contadorCorredores < 5) {
                    JOptionPane.showMessageDialog(null, "Se requieren 5 corredores para iniciar la carrera.", "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                btnIniciar.setEnabled(false); 
                txtResultados.setText(""); 
                lugarLlegada = 1; // Reiniciamos el contador de la meta
                
                for (int i = 0; i < 5; i++) {
                    
                    ThreadRunner tarea = new ThreadRunner(runners[i], AthleticRaceInterface.this);
                    Thread hilo = new Thread(tarea);
                    hilo.start(); 
                }
            }
        });

        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorCorredores = 0;
                lugarLlegada = 1;
                runners = new Runner[5];
                txtNombre.setForeground(Color.GRAY);
                txtNombre.setText("Ingresa nombre...");
                txtRegistrados.setText("");
                txtResultados.setText("");
                btnIniciar.setEnabled(true); 
            }
        });

        btnTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
    }

    // registrar la llegada en orden
    public synchronized void registrarLlegada(String nombre, int tiempo) {
        txtResultados.append(lugarLlegada + " - " + nombre + " - Tiempo: " + tiempo + " segundos\n");
        lugarLlegada++;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AthleticRaceInterface().setVisible(true);
            }
        });
    }
}