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
    public void addRadioButton (String buttonName, final int formulaId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.formulaId=formulaId;
            }
        });
        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    public void addRadioButton2 (String buttonName, final int PeremId){
        JRadioButton button = new JRadioButton(buttonName);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                MainFrame.this.PeremId=PeremId;
                if (PeremId == 1) {
                    textFieldPerem.setText(Perem1.toString());
                }
                else {
                    if (PeremId ==2){
                        textFieldPerem.setText(Perem2.toString());
                    }
                    else {
                        if (PeremId ==3){
                            textFieldPerem.setText(Perem3.toString());
                        }
                    }
                }
            }
        });
        radioButtons2.add(button);
        peremType.add(button);
    }
    public MainFrame() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1", 1);
        addRadioButton("Формула 2", 2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        radioButtons.setSelected(
                radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.setBorder(
                BorderFactory.createLineBorder(Color.YELLOW));
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(labelForZ);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        JLabel labelForResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0", 50);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        JButton buttonCalc = new JButton("Вычислить");

        JButton buttonReset = new JButton("Очистить поля");

        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(
                BorderFactory.createLineBorder(Color.GREEN));
        JButton buttonM = new JButton("M+");


        JButton buttonMC = new JButton("MC");
        Box Mbox = Box.createHorizontalBox();
        Mbox.add(Box.createHorizontalGlue());
        Mbox.add(buttonM);
        Mbox.add(Box.createHorizontalStrut(50));
        Mbox.add(buttonMC);
        Mbox.add(Box.createHorizontalGlue());
        Mbox.setBorder(
                BorderFactory.createLineBorder(Color.PINK));

        JLabel labelPerem= new JLabel("Значение переменной:");
        textFieldPerem = new JTextField("0",25);
        textFieldPerem.setMaximumSize(textFieldPerem.getPreferredSize());
        Box Perem = Box.createHorizontalBox();
        Perem.add(Box.createHorizontalGlue());
        Perem.add(labelPerem);
        Perem.add(Box.createHorizontalStrut(10));
        Perem.add(textFieldPerem);
        Perem.add(Box.createHorizontalGlue());
        Perem.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        peremType.add(Box.createHorizontalGlue());
        addRadioButton2("Переменная 1:",1);
        addRadioButton2("Переменная 2:",2);
        addRadioButton2("Переменная 3:",3);
        radioButtons2.setSelected(radioButtons2.getElements().nextElement().getModel(), true);
        peremType.add(Box.createHorizontalGlue());
        peremType.setBorder(BorderFactory.createLineBorder(Color.GREEN));




        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);

        contentBox.add(Perem);
        contentBox.add(Mbox);
        contentBox.add(peremType);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
    // Главный метод класса
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(300,300);
    }
}

