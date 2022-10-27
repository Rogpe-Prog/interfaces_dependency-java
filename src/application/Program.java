package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Número: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		double valor = sc.nextDouble();
		
		Contract contract = new Contract(number, date, valor);
		
		System.out.print("Entre com o número de parcelas: ");
		int parcelas = sc.nextInt();
		
		
		ContractService cs = new ContractService(new PaypalService());
		
		cs.processContract(contract, parcelas);
		
				
		System.out.println();
		System.out.println("Parcelas:");
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}

		
		sc.close();
	}

}
