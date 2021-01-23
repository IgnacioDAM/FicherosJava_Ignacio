package aed.ficheros;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contrato {
	private StringProperty futbolista = new SimpleStringProperty();
	private StringProperty fechaInicio = new SimpleStringProperty();
	private StringProperty fechaFin = new SimpleStringProperty();

	public final StringProperty futbolistaProperty() {
		return this.futbolista;
	}

	public final String getFutbolista() {
		return this.futbolistaProperty().get();
	}

	public final void setFutbolista(final String futbolista) {
		this.futbolistaProperty().set(futbolista);
	}

	public final StringProperty fechaInicioProperty() {
		return this.fechaInicio;
	}

	public final String getFechaInicio() {
		return this.fechaInicioProperty().get();
	}

	public final void setFechaInicio(final String fechaInicio) {
		this.fechaInicioProperty().set(fechaInicio);
	}

	public final StringProperty fechaFinProperty() {
		return this.fechaFin;
	}

	public final String getFechaFin() {
		return this.fechaFinProperty().get();
	}

	public final void setFechaFin(final String fechaFin) {
		this.fechaFinProperty().set(fechaFin);
	}

}
