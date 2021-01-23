package aed.ficheros;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	//controllers
	private AccesoFicherosController accesoFicheros = new AccesoFicherosController();
	private XMLController xml = new XMLController();
	private FicheroAleatorioController aleatorio = new FicheroAleatorioController();
	
	// view
	@FXML
	private BorderPane view;

	@FXML
	private Tab tabAccesoFicheros;

	@FXML
	private Tab tabFicherosAleatorios;

	@FXML
	private Tab tabFicherosXML;
	
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tabAccesoFicheros.setContent(accesoFicheros.getView());
		tabFicherosXML.setContent(xml.getView());
		tabFicherosAleatorios.setContent(aleatorio.getView());
	}
	
	public BorderPane getView() {
		return view;
	}
}
