import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    private JButton[] buttonNumber = new JButton[10];
    private JButton[] buttonInstrumental = new JButton[5];
    private JButton buttonResult;
    private final Font FONT_NUMBER = new Font("New Romance",Font.BOLD,20);
    private final Font FONT_NUMBER_TopTextField = new Font("New Romance",Font.PLAIN,20);
    private final Font FONT_NUMBER_DownTextField = new Font("New Romance", Font.PLAIN,55);
    private JTextField topTextField;
    private JTextField downTextField;
    private String stringNumber1;
    private String stringInstrumental;

    private String ResultCalculator(String number1){
        try
        {
            int i1 = Integer.parseInt(number1.trim());
            return (i1 + "");
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            return "";
        }
    }
    private String ResultCalculatorPlus(String number1, String number2){
        try
        {
            int i1 = Integer.parseInt(number1.trim());
            int i2 = Integer.parseInt(number2.trim());
            return ((i1+i2)+"");
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            return "";
        }
    }
    private String ResultCalculatorMinus(String number1, String number2){
        try
        {
            int i1 = Integer.parseInt(number1.trim());
            int i2 = Integer.parseInt(number2.trim());
            return ((i1-i2)+"");
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            return "";
        }
    }
    private String ResultCalculatorMulti(String number1, String number2){
        try
        {
            int i1 = Integer.parseInt(number1.trim());
            int i2 = Integer.parseInt(number2.trim());
            return ((i1*i2)+"");
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            return "";
        }
    }
    private String ResultCalculatorMMM(String number1, String number2){
        try
        {
            int i1 = Integer.parseInt(number1.trim());
            int i2 = Integer.parseInt(number2.trim());

            return ((i1/i2)+"");
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
            return "";
        }
    }

    public Panel(){
        setLayout(null);

        topTextField = new JTextField();
        topTextField.setEditable(false);
        topTextField.setFont(FONT_NUMBER_TopTextField);
        topTextField.setBounds(5,55,372,35);
        topTextField.setForeground(Color.GRAY);
        add(topTextField);

        downTextField = new JTextField();
        downTextField.setEditable(false);
        downTextField.setFont(FONT_NUMBER_DownTextField);
        downTextField.setBounds(5,92,372,70);
        downTextField.setForeground(Color.BLACK);
        add(downTextField);

        buttonNumber[0] = new JButton("0");
        buttonNumber[0].setBounds((90+10)+10,(3*60+10)+250,90,60);
        buttonNumber[0].setFont(FONT_NUMBER);
        buttonNumber[0].setBackground(Color.WHITE);
        add(buttonNumber[0]);

        buttonResult = new JButton("=");
        buttonResult.setBounds((2*90+10)+10,(3*60+10)+250,90,60);
        buttonResult.setFont(FONT_NUMBER);
        buttonResult.setBackground(Color.WHITE);
        add(buttonResult);

        for(int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                buttonNumber[x + 1 + y * 3] = new JButton((x + 1 + y * 3)+"");
                buttonNumber[x + 1 + y * 3].setBounds((x*90+10)+10,(y*60+10)+250,90,60);
                buttonNumber[x + 1 + y * 3].setFont(FONT_NUMBER);
                buttonNumber[x + 1 + y * 3].setBackground(Color.WHITE);
                add(buttonNumber[x + 1 + y * 3]);
            }
        }
        ActionListener actionListenerButtonNumber = (ActionEvent e) ->{
            JButton buttonNumbers = (JButton) e.getSource();
            downTextField.setText(downTextField.getText() + buttonNumbers.getText());
        };

        for (JButton b : buttonNumber) {
            b.addActionListener(actionListenerButtonNumber);
        }

        ActionListener actionListenerInstrumental = (ActionEvent e) -> {
            JButton buttonInstrumental = (JButton) e.getSource();
            stringNumber1 = ResultCalculator(downTextField.getText());
            topTextField.setText(downTextField.getText() + " " + buttonInstrumental.getText());
            stringInstrumental = buttonInstrumental.getText();
            downTextField.setText(" ");
        };
        for (int y = 0; y < 4; y++) {
            if(y == 0 ) buttonInstrumental[y+1] = new JButton("+");
            if(y == 1 ) buttonInstrumental[y+1] = new JButton("-");
            if(y == 2 ) buttonInstrumental[y+1] = new JButton("x");
            if(y == 3 ) buttonInstrumental[y+1] = new JButton("/");
            buttonInstrumental[y+1].setBounds((3*90+10)+10,(y*60+10)+250,90,60);
            buttonInstrumental[y+1].setFont(FONT_NUMBER);
            buttonInstrumental[y+1].setBackground(Color.WHITE);
            buttonInstrumental[y+1].addActionListener(actionListenerInstrumental);
            add(buttonInstrumental[y+1]);
        }
        ActionListener actionListenerResult = (ActionEvent e) -> {
            JButton buttonResult = (JButton) e.getSource();
            topTextField.setText(topTextField.getText() + downTextField.getText() +" "+ buttonResult.getText());
            if (stringInstrumental.equals("+")) {
                downTextField.setText(ResultCalculatorPlus(stringNumber1,downTextField.getText()));
            }if(stringInstrumental.equals("-")) {
                downTextField.setText(ResultCalculatorMinus(stringNumber1,downTextField.getText()));
            }if(stringInstrumental.equals("x")) {
                downTextField.setText(ResultCalculatorMulti(stringNumber1,downTextField.getText()));
            }if(stringInstrumental.equals("/")) {
                downTextField.setText(ResultCalculatorMMM(stringNumber1,downTextField.getText()));
            }
        };
        buttonResult.addActionListener(actionListenerResult);
    }
}


