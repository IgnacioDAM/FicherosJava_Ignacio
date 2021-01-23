package aed.ficheros;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ruta {

	private StringProperty ruta = new SimpleStringProperty();

	public final StringProperty rutaProperty() {
		return this.ruta;
	}

	public final String getRuta() {
		return this.rutaProperty().get();
	}

	public final void setRuta(final String ruta) {
		this.rutaProperty().set(ruta);
	}

}
