import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Departamento;
import entidade.HoraContrato;
import entidade.Trabalhador;
import entidade.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Qual departamento você pertence? ");
		String departamento = sc.nextLine();
		System.out.println("Dados do trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível: ");
		String nivel = sc.nextLine();
		System.out.print("Base salarial: ");
		double baseSalarial = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel),baseSalarial,new Departamento(departamento));
		
		System.out.print("Quantos contratos tem? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Dados do contrato #"+i+":");
			System.out.print("Data (DD/MM/AAAA): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int horas = sc.nextInt();
			HoraContrato contrato = new HoraContrato(data, valorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.print("Digite o mês e o ano a ser calculado a renda (MM/AAAA): ");
		sc.nextLine();
		String mesAno = sc.nextLine();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: "+trabalhador.getNome());
		System.out.println("Departamento: "+trabalhador.getDepartamento().getNome());
		System.out.println("Renda para ("+mesAno+"): "+String.format("%.2f", trabalhador.renda(mes, ano)));
		sc.close();

	}

}
