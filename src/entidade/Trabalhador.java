package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidade.enums.NivelTrabalhador;

public class Trabalhador {
	private String nome;
	private NivelTrabalhador nivel;
	private Double baseSalarial;
	
	private Departamento departamento;
	private List <HoraContrato> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double baseSalarial, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.baseSalarial = baseSalarial;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getBaseSalarial() {
		return baseSalarial;
	}

	public void setBaseSalarial(Double baseSalarial) {
		this.baseSalarial = baseSalarial;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	public void adicionarContrato(HoraContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(HoraContrato contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int mes, int ano) {
		double soma = baseSalarial;
		Calendar cal = Calendar.getInstance();
		for (HoraContrato contrato : contratos) {
			cal.setTime(contrato.getData());
			int contrato_mes = 1+ cal.get(Calendar.MONTH);
			int contrato_ano = cal.get(Calendar.YEAR);
			if(mes==contrato_mes && ano==contrato_ano) {
				soma+= contrato.totalValor();
			}
		}
		return soma;
	}
}
