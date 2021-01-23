package aed.ficheros;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class XMLController implements Initializable {

	// model
	private StringProperty equipoAñadir = new SimpleStringProperty();
	private StringProperty equipoEliminar = new SimpleStringProperty();
	private StringProperty equipoModificar = new SimpleStringProperty();

	// view
	@FXML
	private GridPane view;
	
	@FXML
	private ListView<File> vistDatos;

	@FXML
	private Button btnVisualizar;

	@FXML
	private TextField txtModEquipo;

	@FXML
	private Button btnModificar;

	@FXML
	private TextField txtDelEquipo;

	@FXML
	private Button btnEliminar;

	@FXML
	private Button btnCopiar;

	@FXML
	private TextField txtAddEquipo;

	@FXML
	private Button btnAñadir;

	public XMLController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewFXML.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		equipoAñadir.bind(txtAddEquipo.textProperty());
		equipoModificar.bind(txtModEquipo.textProperty());
		equipoEliminar.bind(txtDelEquipo.textProperty());
	}

	@FXML
	void onClickAñadir(ActionEvent event) {

	}

	@FXML
	void onClickCopiar(ActionEvent event) {

	}

	@FXML
	void onClickEliminar(ActionEvent event) {

	}

	@FXML
	void onClickModificar(ActionEvent event) {

	}

	@FXML
	void onClickVisualizar(ActionEvent event) {

	}

	public GridPane getView() {
		return view;
	}
}
