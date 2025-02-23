import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EncDecController {


    public TextField inpute;
    public Button encrptybt;
    public Button clearbte;
    public TextArea outpute;
    public TextField inputd;
    public Button decryptbt;
    public Button clearbtd;
    public TextArea outputd;

    @FXML
    private void handleEncryption() {
        String inputText = inpute.getText();
        String encryptedText = PasswordUtil.encrypt(inputText);
        outpute.setText(encryptedText);
    }

    @FXML
    private void handleDecryption() {
        String encryptedText = inputd.getText();
        String decryptedText = PasswordUtil.decrypt(encryptedText);
        outputd.setText(decryptedText);
    }



    @FXML
    private void handleclear() {
        refreshScenes();
    }


    private void refreshScenes() {
        inpute.clear();
        outpute.clear();
        inputd.clear();
        outputd.clear();
    }




}
