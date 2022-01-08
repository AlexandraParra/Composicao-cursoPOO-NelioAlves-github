package entidade;

import java.util.Date;

public class HoraContrato {
	private Date data;
	private Double valorHora;
	private Integer hora;
	
	public HoraContrato() {
	}

	public HoraContrato(Date data, Double valorHora, Integer hora) {
		this.data = data;
		this.valorHora = valorHora;
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}
	
	public double totalValor() {
		return hora * valorHora;
	}
}
