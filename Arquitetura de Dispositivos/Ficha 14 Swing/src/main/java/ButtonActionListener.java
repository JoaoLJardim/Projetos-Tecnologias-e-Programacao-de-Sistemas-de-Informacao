import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

    private GuiForm guiForm;

    public ButtonActionListener (GuiForm guiForm) {
        this.guiForm = guiForm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();

        switch (event) {
            case "Ok":
                guiForm.getJLabelDown().setText("Ok");
                break;
            case "Submit":
                guiForm.getJLabelDown().setText("Submit");
                break;
            case "Cancel":
                guiForm.getJLabelDown().setText("Cancel");
        }
    }
}