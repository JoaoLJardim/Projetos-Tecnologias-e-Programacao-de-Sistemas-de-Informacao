import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SmartTermo extends JFrame {

    private JButton jButtonAddTemp;
    private JButton jButtonRemoveTemp;
    private JButton jButtonAddHumi;
    private JButton jButtonRemoveHumi;
    private JTextPane jTextPanelLog;
    private JLabel jLabelData;
    private JLabel jLabelStatus;
    private JLabel jLabelTempAtual;
    private JLabel jLabelTempDesejada;
    private JLabel jLabelHumiAtual;
    private JLabel jLabelHumiDesejada;
    private JLabel jLabelDataSet;
    private JLabel jLabelStatusSet;
    private JPanel jPanelMain;
    private JLabel jLabelTempAtualSet;
    private JLabel jLabelTempDesejadaSet;
    private JLabel jLabelHumiAtualSet;
    private JLabel jLabelHumiDesejadaSet;
    private JScrollPane jScrollPaneLog;
    private JButton convertButton;
    private JTextPane aa;
    private float tempAtual, tempDesejada, humidadeAtual, humidadeDesejada;
    private boolean converter;
    private boolean isOnline;
    private TimerTask timerTask, checkTask;
    private Timer timer;

    public SmartTermo() {
        super("SmartTermo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(jPanelMain);
        jLabelDataSet.setText(new Date().toString());

        tempAtual = 22;
        tempDesejada = 24;
        humidadeAtual = 80;
        humidadeDesejada = 10;
        timer = new Timer();
        jLabelStatusSet.setText("Off");
        jLabelTempAtualSet.setText(String.valueOf(tempAtual));
        jLabelTempDesejadaSet.setText(String.valueOf(tempDesejada));
        jLabelHumiAtualSet.setText(String.valueOf(humidadeAtual));
        jLabelHumiDesejadaSet.setText(String.valueOf(humidadeDesejada));

        checkTask = new TimerTask() {
            @Override
            public void run() {
                jLabelDataSet.setText(new Date().toString());
                if (tempAtual < tempDesejada || humidadeAtual < humidadeDesejada) {
                    jLabelStatusSet.setText("On");
                    isOnline = true;
                }

                if (tempAtual == tempDesejada || humidadeAtual == humidadeDesejada) {
                    jLabelStatusSet.setText("Off");
                    isOnline = false;
                }
            }
        };

        timerTask = new TimerTask() {
            @Override
            public void run() {
                Random random = new Random();

                if (!isOnline) {
                    if (random.nextInt(100) <= 30)
                        tempAtual -= 0.5;
                } else {
                    if (tempAtual < tempDesejada)
                        if (random.nextInt(100) <= 80)
                            tempAtual += 0.5;
                }

                if (!isOnline) {
                    if (random.nextInt(100) <= 30)
                        humidadeAtual -= 0.5;
                } else {
                    if (humidadeAtual < humidadeDesejada)
                        if (random.nextInt(100) <= 80)
                            humidadeAtual += 0.5;
                }
                jLabelTempAtualSet.setText(String.valueOf(tempAtual));
                jLabelHumiAtualSet.setText(String.valueOf(humidadeAtual));
            }
        };


        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { /* unused */ }

            @Override
            public void windowClosing(WindowEvent e) {
                timer.cancel();
            }

            @Override
            public void windowClosed(WindowEvent e) { /* unused */ }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) { /* unused */ }

            @Override
            public void windowActivated(WindowEvent e) { /* unused */ }

            @Override
            public void windowDeactivated(WindowEvent e) { /* unused */ }
        });
        timer.scheduleAtFixedRate(checkTask, 0, 1000);
        timer.scheduleAtFixedRate(timerTask, 0, 600000);


        super.setPreferredSize(new Dimension(500, 500));
        pack();
        jButtonAddTemp.addActionListener(e -> {
            tempDesejada += 0.5;
            jLabelTempDesejadaSet.setText(String.valueOf(tempDesejada));
            jTextPanelLog.setText(jTextPanelLog.getText() + "\nAumento Temperatura Desejada");
        });

        jButtonRemoveTemp.addActionListener(e -> {
            tempDesejada -= 0.5;
            jLabelTempDesejadaSet.setText(String.valueOf(tempDesejada));
            jTextPanelLog.setText(jTextPanelLog.getText() + "\nDiminuio Temperatura Desejada");
        });

        jButtonAddHumi.addActionListener(e -> {
            humidadeDesejada += 0.5;
            jLabelHumiDesejadaSet.setText(String.valueOf(humidadeDesejada));
            jTextPanelLog.setText(jTextPanelLog.getText() + "\nAumento Humidade Desejada");
        });

        jButtonRemoveHumi.addActionListener(e -> {
            humidadeDesejada -= 0.5;
            jLabelHumiDesejadaSet.setText(String.valueOf(humidadeDesejada));
            jTextPanelLog.setText(jTextPanelLog.getText() + "\nDiminuio Humidade Desejada");
        });

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: 17/12/2020


                if (converter) {
                    // to Celsius
                    tempAtual = ((tempAtual - 32) * 5 / 9);
                    tempDesejada = ((tempDesejada - 32) * 5 / 9);
                    converter = false;
                } else {
                    // to Fahrenheit
                    tempAtual = tempAtual * 9 / 5 + 32;
                    tempDesejada = tempDesejada * 9 / 5 + 32;
                    converter = true;
                }

                jLabelTempAtualSet.setText(String.valueOf(tempAtual));
                jLabelTempDesejadaSet.setText(String.valueOf(tempDesejada));
            }
        });

    }

    public static void main(String[] args) {
        SmartTermo termo = new SmartTermo();
        termo.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        jPanelMain = new JPanel();
        jPanelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 7, new Insets(0, 0, 0, 0), -1, -1));
        jLabelData = new JLabel();
        jLabelData.setText("Data:");
        jPanelMain.add(jLabelData, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelTempAtual = new JLabel();
        jLabelTempAtual.setText("Temperatura Atual:");
        jPanelMain.add(jLabelTempAtual, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelTempDesejada = new JLabel();
        jLabelTempDesejada.setText("Temperatura Desejada:");
        jPanelMain.add(jLabelTempDesejada, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelHumiAtual = new JLabel();
        jLabelHumiAtual.setText("Humidade Atual:");
        jPanelMain.add(jLabelHumiAtual, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelHumiDesejada = new JLabel();
        jLabelHumiDesejada.setText("Humidade Desejada:");
        jPanelMain.add(jLabelHumiDesejada, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelTempDesejadaSet = new JLabel();
        jLabelTempDesejadaSet.setText("Label");
        jPanelMain.add(jLabelTempDesejadaSet, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelTempAtualSet = new JLabel();
        jLabelTempAtualSet.setText("Label");
        jPanelMain.add(jLabelTempAtualSet, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jButtonAddHumi = new JButton();
        jButtonAddHumi.setText("+");
        jPanelMain.add(jButtonAddHumi, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelDataSet = new JLabel();
        jLabelDataSet.setText("Label");
        jPanelMain.add(jLabelDataSet, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jScrollPaneLog = new JScrollPane();
        jScrollPaneLog.setHorizontalScrollBarPolicy(30);
        jPanelMain.add(jScrollPaneLog, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        jTextPanelLog = new JTextPane();
        jTextPanelLog.setEditable(true);
        jTextPanelLog.setText("");
        jScrollPaneLog.setViewportView(jTextPanelLog);
        jButtonAddTemp = new JButton();
        jButtonAddTemp.setText("+");
        jPanelMain.add(jButtonAddTemp, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jButtonRemoveTemp = new JButton();
        jButtonRemoveTemp.setText("-");
        jPanelMain.add(jButtonRemoveTemp, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelHumiAtualSet = new JLabel();
        jLabelHumiAtualSet.setText("Label");
        jPanelMain.add(jLabelHumiAtualSet, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelHumiDesejadaSet = new JLabel();
        jLabelHumiDesejadaSet.setText("Label");
        jPanelMain.add(jLabelHumiDesejadaSet, new com.intellij.uiDesigner.core.GridConstraints(2, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jButtonRemoveHumi = new JButton();
        jButtonRemoveHumi.setText("-");
        jPanelMain.add(jButtonRemoveHumi, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelStatus = new JLabel();
        jLabelStatus.setText("Status:");
        jPanelMain.add(jLabelStatus, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jLabelStatusSet = new JLabel();
        jLabelStatusSet.setText("Off");
        jPanelMain.add(jLabelStatusSet, new com.intellij.uiDesigner.core.GridConstraints(0, 6, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        convertButton = new JButton();
        convertButton.setText("Convert");
        jPanelMain.add(convertButton, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aa = new JTextPane();
        jPanelMain.add(aa, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return jPanelMain;
    }
}
