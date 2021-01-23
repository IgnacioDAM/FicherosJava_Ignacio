package aed.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class AccesoFicherosController implements Initializable {

	// model
	private Ruta comprobarFichero = new Ruta();
	private Ruta nuevoFichero = new Ruta();
	private Ruta nuevaRuta = new Ruta();
	private StringProperty contenido = new SimpleStringProperty();

	// view
	@FXML
	private BorderPane view;

	@FXML
	private Button btnComprobar;

	@FXML
	private TextField txtActualRuta;

	@FXML
	private TextField txtNuevoDato;

	@FXML
	private CheckBox chkFichero;

	@FXML
	private Button btnCrearA;

	@FXML
	private Button btnEliminarA;

	@FXML
	private Button btnMoverA;

	@FXML
	private TextField txtNuevaRuta;

	@FXML
	private Button btnVisualizar;

	@FXML
	private Button btnModificar;

	@FXML
	private Button btnListarC;

	@FXML
	private Button btnNombreRuta;

	@FXML
	private TextArea txtDatosResultantes;

	public AccesoFicherosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ViewAccesoFicheros.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comprobarFichero.rutaProperty().bind(txtActualRuta.textProperty());
		nuevoFichero.rutaProperty().bind(txtNuevoDato.textProperty());
		nuevaRuta.rutaProperty().bind(txtNuevaRuta.textProperty());
		txtDatosResultantes.textProperty().bind(contenido);
	}

	@FXML
	void onClickComprobar(ActionEvent event) {
		File archivo = new File(comprobarFichero.getRuta());
		if (archivo.exists()) {
			if (archivo.isFile())
				contenido.set("Es un archivo");
			if (archivo.isDirectory())
				contenido.set("Es una carpeta");
		} else {
			contenido.set("El archivo no existe");
		}
	}

	@FXML
	void onClickCrear(ActionEvent event) {
		File archivo = new File(nuevoFichero.getRuta());
		try {
			if (chkFichero.isSelected()) {
				// A partir del objeto File creamos el fichero físicamente
				if (archivo.createNewFile())
					contenido.set("El fichero se ha creado correctamente");
				else
					contenido.set("No se ha podido crear el fichero");
			} else {
				if (!archivo.exists()) {
					if (archivo.mkdirs()) {
						contenido.set("Directorio creado");
					} else {
						contenido.set("El directorio no se ha podido crear");
					}
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@FXML
	void onClickEliminar(ActionEvent event) {
		File archivo = new File(nuevoFichero.getRuta());
		if (chkFichero.isSelected()) {
			if (archivo.delete())
				contenido.set("El fichero se ha borrado correctamente");
			else
				contenido.set("No se ha podido borrar el fichero");
		} else {
			if (archivo.delete()) {
				contenido.set("Directorio borrado");
			} else {
				contenido.set("El directorio no se ha podido crear");
			}

		}
	}

	@FXML
	void onClickMover(ActionEvent event) {
		// sigue mal
		File archivo = new File(nuevoFichero.getRuta());
		if (!archivo.exists()) {
			contenido.set("Error el primer fichero no existe");
		}
		File archivoNuevo = new File(nuevaRuta.getRuta());
		if (!archivoNuevo.exists()) {
			contenido.set("Error el primer fichero no existe");
		}

		boolean success = archivo.renameTo(archivoNuevo);
		if (!success) {
			contenido.set("Error intentando cambiar el nombre de fichero o al moverlo a nueva ruta");
		}
	}

	@FXML
	void onClickVisualizar(ActionEvent event) {
		File archivo = new File(nuevoFichero.getRuta());
		String datos = "";
		try {
			Scanner lector = new Scanner(archivo);
			while (lector.hasNextLine()) {
				String frase = lector.nextLine();
				datos += frase;
				datos += " | ";
			}
			contenido.set(datos);
			lector.close();

		} catch (FileNotFoundException e) {
			contenido.set("Un error ha ocurrido");
			e.printStackTrace();
		}
	}

	@FXML
	void onClickModificar(ActionEvent event) {
		// borra todo lo que haya en el fichero y pone lo que tengamos
		try {
			FileWriter archivo = new FileWriter(nuevoFichero.getRuta());
			archivo.write("Arhivo modificado correctamente");
			archivo.close();
			contenido.set("Archivo modificado correctamente");
		} catch (IOException e) {
			contenido.set("No se puede modificar el archivo");
			e.printStackTrace();
		}
	}

	@FXML
	void onClickListarCarpetas(ActionEvent event) {
		File archivo = new File(nuevoFichero.getRuta());
		String[] ficheros = archivo.list();
		String datos = "";
		if (ficheros == null)
			System.out.println("No hay ficheros en el directorio especificado");
		else {
			for (int x = 0; x < ficheros.length; x++) {
				datos += ficheros[x];
				datos += " | ";
			}
		}
		contenido.set(datos);
	}

	@FXML
	void onClickNombreRuta(ActionEvent event) {
		File archivo = new File(nuevoFichero.getRuta());
		contenido.set(archivo.getName() + " : " + archivo.getAbsolutePath());
	}

	public BorderPane getView() {
		return view;
	}

}
