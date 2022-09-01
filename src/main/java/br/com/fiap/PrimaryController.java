package br.com.fiap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class PrimaryController {
    @FXML private TextArea txtAreaAnotacoes;

    public void newFile() {
        System.out.println("Criou!");
    }

    public void openFile() {
        FileChooser dialogoAbrir = new FileChooser();
        File fileAbrir = dialogoAbrir.showOpenDialog(null);

        try {
            Path path = fileAbrir.toPath();
            String texto = Files.readString(path);

            txtAreaAnotacoes.setText(texto);
        } catch (IOException e) {
            Alert alertErroSalvar = new Alert(AlertType.ERROR, "Erro ao salvar arquivo!");

            alertErroSalvar.show();
        }
    }

    public void saveFile() {
        String texto = txtAreaAnotacoes.getText();
        FileChooser dialogoSalvar = new FileChooser();
        File fileSalvar = dialogoSalvar.showSaveDialog(null);

        try {
            PrintWriter output = new PrintWriter(fileSalvar);

            output.write(texto);
            output.close();
        } catch (FileNotFoundException e) {
            Alert alertErroSalvar = new Alert(AlertType.ERROR, "Erro ao salvar arquivo!");

            alertErroSalvar.show();
        }
    }


    public void closeFile() {
        System.out.println("Fechou!");
    }
}
