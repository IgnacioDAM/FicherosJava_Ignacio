package aed.ficheros;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EquiposAleatorios {
	private StringProperty codEquipo = new SimpleStringProperty();
	private StringProperty nomEquipo = new SimpleStringProperty();
	private StringProperty codLiga = new SimpleStringProperty();
	private StringProperty localidad = new SimpleStringProperty();
	private StringProperty copasGanadas = new SimpleStringProperty();
	private BooleanProperty internacional = new SimpleBooleanProperty();

	public final StringProperty codEquipoProperty() {
		return this.codEquipo;
	}

	public final String getCodEquipo() {
		return this.codEquipoProperty().get();
	}

	public final void setCodEquipo(final String codEquipo) {
		this.codEquipoProperty().set(codEquipo);
	}

	public final StringProperty nomEquipoProperty() {
		return this.nomEquipo;
	}

	public final String getNomEquipo() {
		return this.nomEquipoProperty().get();
	}

	public final void setNomEquipo(final String nomEquipo) {
		this.nomEquipoProperty().set(nomEquipo);
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

	public final StringProperty localidadProperty() {
		return this.localidad;
	}

	public final String getLocalidad() {
		return this.localidadProperty().get();
	}

	public final void setLocalidad(final String localidad) {
		this.localidadProperty().set(localidad);
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

	public final BooleanProperty internacionalProperty() {
		return this.internacional;
	}

	public final boolean isInternacional() {
		return this.internacionalProperty().get();
	}

	public final void setInternacional(final boolean internacional) {
		this.internacionalProperty().set(internacional);
	}

}
