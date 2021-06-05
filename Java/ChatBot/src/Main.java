import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
	
		ChatBot bot = new ChatBot();
		
		System.out.println("---------------------------------------");
		System.out.println("= Iniciando o chatbot com Mandrakinho =");
		System.out.println("---------------------------------------");
		System.out.println(" # Para saber algumas palavras chaves já conhecidas, digite 'Interações'");
		System.out.println(" # Para saber como adicionar respostas ao chatbot, digite '/ajuda'\n");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\n # Para começar, digite seu nome de usuário: ");
		String usuario = input.nextLine();
		usuario = usuario.replace(" ", "");
		System.out.println("\nIniciando a conversa...\n");
		
		String  texto = "";
		while(true){
			Thread.sleep(1000);
			System.out.print("> @" + usuario + ": ");
			texto = input.nextLine();
			Thread.sleep(1500);
			bot.processa(texto);
		}
	}
}
