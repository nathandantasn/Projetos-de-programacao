import java.util.Scanner;

public class Gerenciamento {

	Scanner input = new Scanner(System.in);
	GerenciarConta gerenciar = new GerenciarConta();

	public void criarConta() {
		System.out.println("\nDigite: Conta Corrente, Conta Especial ou Conta Poupan�a para criar.\n");
		System.out.print("Tipo de conta: ");
		String texto = input.nextLine();
		texto.toLowerCase();
		if (texto.contains("corrente")) {
			System.out.print("\nDigite o n�mero da conta de sua prefer�ncia: ");
			String numeroDaConta = input.nextLine();
			if (!numeroDaConta.matches("[0-9]+")) {
				while (!numeroDaConta.matches("[0-9]+")) {
					System.out.print("\nPor favor, informe apenas n�meros: ");
					numeroDaConta = input.nextLine();
				}
			}
			if (gerenciar.testarNumeroDaConta(Integer.parseInt(numeroDaConta))) {
				int numero1 = 1;
				while (numero1 == 1) {
					System.out.print("Essa conta j� existe. Por favor, digite outro n�mero: ");
					numeroDaConta = input.nextLine();
					if (gerenciar.testarNumeroDaConta(Integer.parseInt(numeroDaConta)) == false) {
						numero1++;
					}
				}
			}
			System.out.print("Digite seu nome: ");
			String nome = input.nextLine();
			System.out.print("Digite seu cpf: ");
			String cpf = input.nextLine();
			if (!cpf.matches("[0-9]+")) {
				while (!cpf.matches("[0-9]+")) {
					System.out.print("\nPor favor, informe apenas n�meros: ");
					cpf = input.nextLine();
				}
			}
			System.out.print("Deseja acrescentar limite? Responda com 'sim': ");
			String resposta = input.nextLine();
			resposta.toLowerCase();
			if (resposta.contains("sim")) {
				System.out.print("Defina o valor do limite: ");
				String limite = input.nextLine();
				if (!limite.matches("[0-9]+")) {
					while (!limite.matches("[0-9]+")) {
						System.out.print("\nPor favor, informe apenas n�meros: ");
						limite = input.nextLine();
					}
				}
				Conta contaCorrente = new ContaCorrente(Integer.parseInt(numeroDaConta), nome, Integer.parseInt(cpf),
						Double.parseDouble(limite));
				System.out.print("\nConta criada com sucesso!\n");
				gerenciar.adicionarConta(contaCorrente);
			} else {
				Conta contaCorrente = new ContaCorrente(Integer.parseInt(numeroDaConta), nome, Integer.parseInt(cpf));
				System.out.print("\nConta criada com sucesso!\n");
				gerenciar.adicionarConta(contaCorrente);
			}

		} else if (texto.contains("especial")) {
			System.out.print("\nDigite o n�mero da conta de sua prefer�ncia: ");
			String numeroDaConta = input.nextLine();
			if (!numeroDaConta.matches("[0-9]+")) {
				while (!numeroDaConta.matches("[0-9]+")) {
					System.out.print("\nPor favor, informe apenas n�meros: ");
					numeroDaConta = input.nextLine();
				}
			}
			if (gerenciar.testarNumeroDaConta(Integer.parseInt(numeroDaConta))) {
				int numero1 = 1;
				while (numero1 == 1) {
					System.out.print("Essa conta j� existe. Por favor, digite outro n�mero: ");
					numeroDaConta = input.nextLine();
					if (gerenciar.testarNumeroDaConta(Integer.parseInt(numeroDaConta)) == false) {
						numero1++;
					}
				}
			}
			System.out.print("Digite seu nome: ");
			String nome = input.nextLine();
			System.out.print("Digite seu cpf: ");
			String cpf = input.nextLine();
			if (!cpf.matches("[0-9]+")) {
				while (!cpf.matches("[0-9]+")) {
					System.out.print("\nPor favor, informe apenas n�meros: ");
					cpf = input.nextLine();
				}
			}
			System.out.print("Digite o nome do seu gerente: ");
			String gerente = input.nextLine();
			System.out.print("Deseja acrescentar limite? Responda com 'sim': ");
			String resposta = input.nextLine();
			resposta.toLowerCase();
			if (resposta.contains("sim")) {
				System.out.print("Defina o valor do limite: ");
				String limite = input.nextLine();
				if (!limite.matches("[0-9]+")) {
					while (!limite.matches("[0-9]+")) {
						System.out.print("\nPor favor, informe apenas n�meros: ");
						limite = input.nextLine();
					}
				}
				Conta contaEspecial = new ContaEspecial(Integer.parseInt(numeroDaConta), nome, Integer.parseInt(cpf),
						Double.parseDouble(limite), gerente);
				System.out.println("\nConta criada com sucesso!\n");
				gerenciar.adicionarConta(contaEspecial);
			} else {
				Conta contaEspecial = new ContaEspecial(Integer.parseInt(numeroDaConta), nome, Integer.parseInt(cpf),
						gerente);
				System.out.println("\nConta criada com sucesso!\n");
				gerenciar.adicionarConta(contaEspecial);
			}

		} else if (texto.contains("poupan�a")) {
			System.out.print("\nDigite o n�mero da conta de sua prefer�ncia: ");
			String numeroDaConta = input.nextLine();
			if (!numeroDaConta.matches("[0-9]+")) {
				while (!numeroDaConta.matches("[0-9]+")) {
					System.out.print("\nPor favor, informe apenas n�meros: ");
					numeroDaConta = input.nextLine();
				}
			}
			if (gerenciar.testarNumeroDaConta(Integer.parseInt(numeroDaConta))) {
				int numero1 = 1;
				while (numero1 == 1) {
					System.out.print("Essa conta j� existe. Por favor, digite outro n�mero: ");
					numeroDaConta = input.nextLine();
					if (gerenciar.testarNumeroDaConta(Integer.parseInt(numeroDaConta)) == false) {
						numero1++;
					}
				}
			}
			System.out.print("Digite seu nome: ");
			String nome = input.nextLine();
			System.out.print("Digite seu cpf: ");
			String cpf = input.nextLine();
			if (!cpf.matches("[0-9]+")) {
				while (!cpf.matches("[0-9]+")) {
					System.out.print("\nPor favor, informe apenas n�meros: ");
					cpf = input.nextLine();
				}
			}
			Conta contaPoupanca = new ContaPoupanca(Integer.parseInt(numeroDaConta), nome, Integer.parseInt(cpf));
			System.out.println("\nConta criada com sucesso!\n");
			gerenciar.adicionarConta(contaPoupanca);
		} else {
			System.out.println("\nN�o entendemos o comando. Voltamos para o menu principal\n");
		}
	}

	public void teste(String testar) {
		testar = testar.toLowerCase();
		if (testar.contains("criar")) {
			criarConta();
		} else if (testar.contains("sacar")) {
			if (gerenciar.vazia() == false) {
				System.out.print("Informe a conta: ");
				int conta = input.nextInt();
				System.out.print("Valor: R$ ");
				double valor = input.nextDouble();
				gerenciar.sacar(conta, valor);
			} else if (gerenciar.vazia()){
				System.out.print("\nN�o h� contas no sistema para sacar. Crie uma conta.\n");
			}
		} else if (testar.contains("depositar")) {
			if (gerenciar.vazia() == false) {
				System.out.print("Informe a conta: ");
				int conta = input.nextInt();
				System.out.print("Valor: R$ ");
				double valor = input.nextDouble();
				gerenciar.depositar(conta, valor);
			} else if (gerenciar.vazia()){
				System.out.print("\nN�o h� contas no sistema para depositar. Crie uma conta.\n");
			} else {
				System.out.print("\nDigite uma conta v�lida.\n");
			}
		} else if (testar.contains("transferir")) {
			if (gerenciar.vazia() == false || gerenciar.tamanhoListaContas() > 1) {
				System.out.print("Informe a conta origem: ");
				int contaOrigem = input.nextInt();
				System.out.print("Informe a conta destino: ");
				int contaDestino = input.nextInt();
				System.out.print("Valor: R$ ");
				double valor = input.nextDouble();
				gerenciar.transferirValor(contaOrigem, contaDestino, valor);
			} else if (gerenciar.tamanhoListaContas() == 1) {
				System.out.print("\nN�o h� contas suficientes no sistema para transferir.\n");
			} else if (gerenciar.vazia()) {
				System.out.print("\nN�o h� contas no sistema para transferir. Crie pelo menos 2 contas.\n");
			}
		} else if (testar.contains("buscar")) {
			if (gerenciar.vazia() == false) {
				System.out.print("Informe a conta: ");
				int conta = input.nextInt();
				System.out.println(gerenciar.buscarConta(conta));
			} else if (gerenciar.vazia()){
				System.out.print("\nN�o h� contas no sistema para buscar. Crie uma conta.\n");
			} else {
				System.out.print("\nDigite uma conta v�lida.\n");
			}
		} else if (testar.contains("remover")) {
			if (gerenciar.vazia() == false) {
				System.out.print("Informe a conta a ser removida: ");
				int conta = input.nextInt();
				gerenciar.removerConta(conta);
			} else {
				System.out.print("\nN�o h� contas no sistema para remover. Crie uma conta.\n");
			}
		} else if (testar.contains("usando")) {
			if (gerenciar.vazia() == false) {
				System.out.println(gerenciar.buscarClientesUsandoLimite());
			} else {
				System.out.print(
						"\nN�o h� contas no sistema para checar o limite. Crie uma conta corrente ou especial.\n");
			}
		} else if (testar.contains("especiais")) {
			if (gerenciar.vazia() == false) {
				System.out.println(gerenciar.buscarContasEspeciais());
			} else {
				System.out.print("\nN�o h� contas especiais no sistema. Crie uma conta especial.\n");
			}
		} else if (testar.contains("render")) {
			if (gerenciar.vazia() == false) {
				System.out.print("Informe a conta: ");
				int conta = input.nextInt();
				System.out.print("Informe o rendimento: ");
				double valor = input.nextDouble();
				if (gerenciar.buscarConta(conta) instanceof ContaPoupanca) {
					gerenciar.renderPoupanca(conta, valor);
				}else if (gerenciar.buscarConta(conta) instanceof ContaEspecial || gerenciar.buscarConta(conta) instanceof ContaCorrente){
					System.out.print("\nEssa conta n�o pode render, pois n�o � poupan�a.\n");
				}
			} else if (gerenciar.vazia()){
				System.out.print("\nN�o h� contas no sistema para render. Crie uma conta poupan�a.\n");
			} else {
				System.out.print("\nDigite uma conta v�lida.\n");
			}
		} else if (testar.contains("listar")) {
			if (gerenciar.vazia() == false) {
				System.out.println(gerenciar.listarContas());
			} else {
				System.out.print("\nN�o h� contas no sistema para listar. Crie uma conta.\n");
			}
		} else if (testar.contains("sair")) {
			System.out.print("\nObrigado por usar o S�Mandraking Banking. At� logo!\n");
			System.exit(0);
		} else if (testar.contains("palavra")) {
			System.out.print("\nPalavras-chaves: Criar conta, sacar, depositar, buscar conta, remover conta,"
					+ "\nclientes usando limite, contas especiais, render poupan�a, transferir valor, "
					+ "\nlistar contas, novo limite, nome do gerente, sair.\n");
		} else if (testar.contains("gerente")) {
			if (gerenciar.vazia() == false) {
				System.out.print("Informe a conta: ");
				String conta = input.nextLine();
				if (gerenciar.buscarConta(Integer.parseInt(conta)) instanceof ContaEspecial) {
					System.out.print("Digite o nome do novo gerente: ");
					String nome = input.nextLine();
					gerenciar.mudarNomeGerente(Integer.parseInt(conta), nome);
				}
				else if (gerenciar.buscarConta(Integer.parseInt(conta)) instanceof ContaPoupanca || gerenciar.buscarConta(Integer.parseInt(conta)) instanceof ContaCorrente){
					System.out.print("\nEssa conta n�o � especial. Informe o n�mero da conta especial ou crie uma.\n");
				}
			} else {
				System.out.print("\nN�o h� contas especiais no sistema. Crie uma conta especial.\n");
			}
		} else if (testar.contains("novo limite")) {
			if (gerenciar.vazia() == false) {
				System.out.print("Informe a conta: ");
				int conta = input.nextInt();
				if (gerenciar.buscarConta(conta) instanceof ContaCorrente || gerenciar.buscarConta(conta) instanceof ContaEspecial) {
					System.out.print("Digite o valor do novo limite: ");
					double limite = input.nextDouble();
					gerenciar.mudarLimite(conta, limite);
				}
				else if (gerenciar.buscarConta(conta) instanceof ContaPoupanca){
					System.out.print("\nEssa conta n�o � corrente ou especial. Crie uma para poder adicionar limite.\n");
				}
			} else if (gerenciar.vazia()){
				System.out.print("\nN�o h� contas correntes ou especiais no sistema para mudar o limite. Crie uma conta corrente ou especial.\n");
			} else {
				System.out.print("\nDigite uma conta v�lida.\n");
			}
		} else {
			System.out.print("\nPor favor, digite novamente a palavra-chave\n");
		}
	}
}
