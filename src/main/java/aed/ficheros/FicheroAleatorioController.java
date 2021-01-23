package aed.ficheros;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FicheroAleatorioController implements Initializable {
	
	static RandomAccessFile archivo;
	
	// view
	@FXML
	private GridPane view;

	@FXML
	private Button btnInsertar;

	@FXML
	private Button btnVisualizar;

	@FXML
	private TextField txtIDVisualizar;

	@FXML
	private Button btnVisualizarID;

	@FXML
	private TextField txtIDModificar;

	@FXML
	private TableView<EquiposAleatorios> datosTable;

	@FXML
	private TableColumn<EquiposAleatorios, String> colCodEquipo;

	@FXML
	private TableColumn<EquiposAleatorios, String> colNomEquipo;

	@FXML
	private TableColumn<EquiposAleatorios, String> colCodLiga;

	@FXML
	private TableColumn<EquiposAleatorios, String> colLocalidad;

	@FXML
	private TableColumn<EquiposAleatorios, String> colCopas;

	@FXML
	private TableColumn<EquiposAleatorios, Boolean> colInternacional;

	@FXML
	private Button btnModificar;
	
	public FicheroAleatorioController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewFicheroAleatorio.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void onClickInsertar(ActionEvent event) {
		try {
			archivo = new RandomAccessFile("Equipos", "rw");
			
			
		} catch(IOException e) {
			System.out.println("El archivo no se ha podido crear");
		}
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
