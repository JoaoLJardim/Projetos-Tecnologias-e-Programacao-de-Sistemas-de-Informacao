import javax.swing.*;

public class GuiForm extends JFrame {

    private JPanel jPanelMain;
    private JButton jButtonOk;
    private JButton jButtonSubmit;
    private JButton jButtonCancel;
    private JLabel jLabelUp;
    private JLabel jLabelDown;


    public GuiForm(String str) {
        super(str);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setContentPane(jPanelMain);

        jButtonSubmit.addActionListener(new ButtonActionListener(this));
        jButtonOk.addActionListener(new ButtonActionListener(this));
        jButtonCancel.addActionListener(new ButtonActionListener(this));


        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new GuiForm("Gui Form");
        frame.setVisible(true);
    }

    public JLabel getJLabelDown() {
        return jLabelDown;
    }

}
