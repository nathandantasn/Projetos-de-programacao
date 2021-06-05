import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Gerenciamento gerente = new Gerenciamento();

		System.out.println("Bem-vindo ao SóMankrake Banking\n");
		System.out.println("Palavras-chaves: Criar conta, sacar, depositar, buscar conta, remover conta,"
				+ "\nclientes usando limite, contas especiais, render poupança, transferir valor, \nlistar contas, novo limite, nome do gerente, sair\n"
				+ "\nObservações importantes: O valor do limite a ser indicado tem que ser positivo.");
		String texto = "";
		while (true) {
			System.out.print("\nDigite o que gostaria de fazer: ");
			texto = input.nextLine();
			gerente.teste(texto);
		}
	}
}
