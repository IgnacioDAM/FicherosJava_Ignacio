package aed.ficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

	@FXML
	private TableView<Equipos> tableEquipo;

	@FXML
	private TableColumn<Equipos, String> colNomEquipo;

	@FXML
	private TableColumn<Equipos, String> colCopas;

	@FXML
	private TableColumn<Equipos, String> colCodLiga;

	@FXML
	private TableView<Contrato> tableContrato;

	@FXML
	private TableColumn<Contrato, String> colFutbolista;

	@FXML
	private TableColumn<Contrato, String> colFechaInicio;

	@FXML
	private TableColumn<Contrato, String> colFechaFin;

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

		colNomEquipo.setCellValueFactory(v -> v.getValue().nomEquipoProperty());
		colCopas.setCellValueFactory(v -> v.getValue().copasGanadasProperty());
		colCodLiga.setCellValueFactory(v -> v.getValue().codLigaProperty());

		colFutbolista.setCellValueFactory(v -> v.getValue().futbolistaProperty());
		colFechaInicio.setCellValueFactory(v -> v.getValue().fechaInicioProperty());
		colFechaFin.setCellValueFactory(v -> v.getValue().fechaFinProperty());

	}

	@FXML
	void onClickAñadir(ActionEvent event) {
		SAXBuilder builder = new SAXBuilder();
		Document documentJDOM;
		try {
			documentJDOM = builder.build(new FileInputStream(new File("ficheros/Equipos.xml")));
			Element raiz = documentJDOM.getRootElement();
			List hijosRaiz = raiz.getChildren();
			Iterator iter = hijosRaiz.iterator();
			while (iter.hasNext()) {
				Element equipo = (Element) iter.next();
				if (equipo.getAttributeValue("nomEquipo").equals(equipoModificar.get())) {
					Element contratoNuevo = new Element("Nuevo contrato");
					contratoNuevo.setName("Pedro");
					contratoNuevo.setAttribute("12-05-13", "15-10-15");
					raiz.addContent(contratoNuevo);
					System.out.println("Contrato añadido");
				}
			}

		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void onClickCopiar(ActionEvent event) {
		SAXBuilder builder = new SAXBuilder();
		Document documentJDOM;
		try {
			documentJDOM = builder.build(new FileInputStream(new File("ficheros/Equipos.xml")));
			Element raiz = documentJDOM.getRootElement();
			raiz.clone();
			System.out.println("copiado");
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void onClickEliminar(ActionEvent event) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document documentJDOM = builder.build(new FileInputStream(new File("ficheros/Equipos.xml")));
			Element raiz = documentJDOM.getRootElement();
			List hijosRaiz = raiz.getChildren();
			Iterator iter = hijosRaiz.iterator();

			while (iter.hasNext()) {
				Element equipo = (Element) iter.next();
				if (equipo.getAttributeValue("nomEquipo").equals(equipoEliminar.get())) {
					iter.remove();
					System.out.println("Eliminado");
					// se elimina pero no se guarda que se elimina
				}
			}

		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void onClickModificar(ActionEvent event) {
		
	}

	@FXML
	void onClickVisualizar(ActionEvent event) {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document documentJDOM = builder.build(new FileInputStream(new File("ficheros/Equipos.xml")));
			Element raiz = documentJDOM.getRootElement();
			List<Element> hijosRaiz = raiz.getChildren();
			ArrayList<Equipos> equipos = new ArrayList<Equipos>();
			ArrayList<Contrato> contratos = new ArrayList<Contrato>();

			for (Element hijo : hijosRaiz) {
				Equipos equipo = new Equipos();
				equipo.setNomEquipo(hijo.getAttributeValue("nomEquipo"));
				equipo.setCopasGanadas(hijo.getAttributeValue("copasGanadas"));
				equipo.setCodLiga(hijo.getChildText("codLiga"));

				Element nieto = hijo.getChild("Contratos");
				List<Element> hijosContratos = nieto.getChildren();

				for (Element futbolista : hijosContratos) {
					Contrato contrato = new Contrato();
					contrato.setFutbolista(futbolista.getValue());
					contrato.setFechaInicio(futbolista.getAttributeValue("fechaInicio"));
					contrato.setFechaFin(futbolista.getAttributeValue("fechaFin"));

					contratos.add(contrato);
				}

				equipos.add(equipo);
			}
			tableEquipo.getItems().addAll(equipos);
			tableContrato.getItems().addAll(contratos);

		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
	}

	public GridPane getView() {
		return view;
	}
}
