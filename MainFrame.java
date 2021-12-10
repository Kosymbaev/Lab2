package bsu.rfe.java.group10.lab2.Kosymbaev.varB12;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
    private static final int WIDTH = 400;
    private static final int Height = 320;

    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    private JTextField textForPerem;

    private Double result;

    private Double Perem1=0.0;
    private Double Perem2=0.0;
    private Double Perem3=0.0;

    private JTextField textFieldResult;

    private ButtonGroup radioButtons = new ButtonGroup();

    private Box hboxFormulaType = Box.createHorizontalBox();

    private ButtonGroup radioButtons2 = new ButtonGroup();
    private Box peremType = Box.createHorizontalBox();
    private JTextField textFieldPerem;

    private int formulaId = 1;
    private int PeremId=1;

    public Double calculate1(Double x, Double y, Double z){
        return Math.pow(Math.cos(Math.pow(Math.E,x)+Math.pow(Math.exp(1+y),2)+Math.sqrt(Math.pow(Math.E,Math.cos(x))+Math.pow(Math.sin(z*Math.PI),2))+Math.sqrt(1/x)+Math.cos(Math.pow(y,2))),Math.sin(z));
    }
    public Double calculate2(Double x, Double y, Double z){

        return (1+Math.sqrt(z*x))/(Math.pow(1+Math.pow(x,3),1/y));
    }
    // Главный метод класса
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300,300);
    }
}

