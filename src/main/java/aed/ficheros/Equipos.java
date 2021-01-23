package aed.ficheros;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Equipos {
	private StringProperty nomEquipo = new SimpleStringProperty();
	private StringProperty copasGanadas = new SimpleStringProperty();
	private StringProperty codLiga = new SimpleStringProperty();

	public final StringProperty nomEquipoProperty() {
		return this.nomEquipo;
	}

	public final String getNomEquipo() {
		return this.nomEquipoProperty().get();
	}

	public final void setNomEquipo(final String nomEquipo) {
		this.nomEquipoProperty().set(nomEquipo);
	}

	public final StringProperty copasGanadasProperty() {
		return this.copasGanadas;
	}

	public final String getCopasGanadas() {
		return this.copasGanadasProperty().get();
	}

	public final void setCopasGanadas(final String copasGanadas) {
		this.copasGanadasProperty().set(copasGanadas);
	}

	public final StringProperty codLigaProperty() {
		return this.codLiga;
	}

	public final String getCodLiga() {
		return this.codLigaProperty().get();
	}

	public final void setCodLiga(final String codLiga) {
		this.codLigaProperty().set(codLiga);
	}

}
