package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class Ventana extends JFrame implements ActionListener {
	LienzoParaArrastrarFiguras c = new LienzoParaArrastrarFiguras();
	boolean cur = true;
	boolean fi = false;
	private JMenuBar menuBar;
    private JMenu archivo,entrada,ayuda;
    private JMenuItem ar_nuevo,ar_abrir,ar_guardar,ar_imagen,ar_imprimir,ar_salir;
    private JMenuItem en_paso,en_rapido,en_multiple;
    private JMenuItem ay_ayuda;
    private JButton cursor,estado,transicion,eliminar,des,re;
    
    public Ventana(){
    	super("JFLAP");
    	/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setLayout(null);
    	this.setSize(500, 500);
    	this.setResizable(false); */
    	this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.addComponents();
    	JToolBar toolBar = getToolBar();
    	this.getContentPane().add(toolBar, BorderLayout.NORTH);
    	c.addFigura(new Rectangulo(2, 3, 50, 33, Color.RED));
    	c.addFigura(new Rectangulo(7, 22, 150, 10, Color.GREEN));
    	c.addFigura(new Rectangulo(11, 44, 20, 100, Color.CYAN));
    	c.addFigura(new Circunferecia(6, 8, 34, Color.YELLOW));
    	c.addFigura(new Circunferecia(34, 8, 55, Color.WHITE));
    	c.addFigura(new Circunferecia(64, 8, 22, Color.BLUE));
    	this.getContentPane().add(c);
    	/*Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    	Dimension ventana = this.getSize();
    	this.setLocation(((pantalla.width - ventana.width) / 2), ((pantalla.height - ventana.height) / 2));*/
    	this.setVisible(true);
    }

	private void addComponents() {
		menuBar = new JMenuBar();
    	this.setJMenuBar(menuBar);
    	archivo = new JMenu("Archivo");
    	menuBar.add(archivo);
    	entrada = new JMenu("Entrada");
    	menuBar.add(entrada);
    	ayuda = new JMenu("Ayuda");
    	menuBar.add(ayuda);
    	ar_nuevo = new JMenuItem("Nuevo");
    	ar_abrir = new JMenuItem("Abrir");
    	ar_guardar = new JMenuItem("Guardar");
    	ar_imagen = new JMenuItem("Guardar como imagen");
    	ar_imprimir = new JMenuItem("Imprimir");
    	ar_salir = new JMenuItem("Salir");
    	archivo.add(ar_nuevo);
    	archivo.add(ar_abrir);
    	archivo.add(ar_guardar);
    	archivo.add(ar_imagen);
    	archivo.add(ar_imprimir);
    	archivo.add(ar_salir);
    	ar_nuevo.addActionListener(this);
    	ar_abrir.addActionListener(this);
    	ar_guardar.addActionListener(this);
    	ar_imagen.addActionListener(this);
    	ar_imprimir.addActionListener(this);
    	ar_salir.addActionListener(this);
    	en_paso = new JMenuItem("Paso a Paso");
    	en_rapido = new JMenuItem("Prueba rapida");
    	en_multiple = new JMenuItem("Pruebas multiples");
    	entrada.add(en_paso);
    	entrada.add(en_rapido);
    	entrada.add(en_multiple);
    	en_paso.addActionListener(this);
    	en_rapido.addActionListener(this);
    	en_multiple.addActionListener(this);
    	ay_ayuda = new JMenuItem("Ayuda");
    	ayuda.add(ay_ayuda);
    	ay_ayuda.addActionListener(this);
	}
	
	private JToolBar getToolBar() {
        JToolBar barraBotones = new JToolBar();
        cursor = new JButton("Cursor");
        estado = new JButton("Estado");
        transicion = new JButton("Transicion");
        eliminar = new JButton("Eliminar");
        des = new JButton("Des-Hacer");
        re = new JButton("Re-Hacer");
        cursor.addActionListener(this);
        estado.addActionListener(this);
        transicion.addActionListener(this);
        eliminar.addActionListener(this);
        des.addActionListener(this);
        re.addActionListener(this);
        barraBotones.add(cursor);
        barraBotones.add(estado);
        barraBotones.add(transicion);
        barraBotones.add(eliminar);
        barraBotones.add(des);
        barraBotones.add(re);
        return barraBotones;
    }
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cursor){
			cur = true;
			fi = false;
		}else if(e.getSource() == estado){
			cur = false;
			fi = true;
		}
	}
}
