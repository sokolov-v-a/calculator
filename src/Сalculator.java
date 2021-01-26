import javax.swing.*;
import java.awt.event.*;

public class Сalculator extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel result;

    public Сalculator() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        double doubleResult = calculate(textField1.getText(), textField2.getText());
        result.setText(Double.toString(doubleResult));
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Сalculator dialog = new Сalculator();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public double calculate(String equation, String stringVariables){
        String[] variables = stringVariables.split(" ");
        int count = 0;
        for (String variable:variables){
            count++;
            equation = equation.replaceAll("x"+count, variable);
        }
        System.out.println(equation);

        return Espresso.calculus(equation);
    }
}
