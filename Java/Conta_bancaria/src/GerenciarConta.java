
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GerenciarConta {

	DecimalFormat df = new DecimalFormat("###,##0.00");
	ArrayList<Conta> contas = new ArrayList<>();

	public void adicionarConta(Conta c) {
		contas.add(c);
	}

	public boolean vazia() {
		if (contas.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int tamanhoListaContas() {
		return contas.size();
	}

	public boolean removerConta(int numeroDaConta) {
		if (vazia()) {
			System.out.println("Não há contas no sistema para remover");
			return false;
		} else {
			Conta c = contas.get(0);
			int pos = 0;
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getNumeroDaConta() == numeroDaConta) {
					c = contas.get(i);
					pos = i;
				}
			}
			if (c.getNumeroDaConta() == numeroDaConta) {
				System.out.println("=======================================\nConta removida: \n" + c.toString()
						+ "\n=======================================");
				contas.remove(pos);
				return true;
			} else {
				return false;
			}
		}
	}

	public String buscarContasEspeciais() {
		if (vazia()) {
			return "Lista de contas está vazia";
		} else {
			ArrayList<Conta> contasEspeciais = new ArrayList<>();
			int qtdeContasEspeciais = 0;
			String dados = "";
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i) instanceof ContaEspecial) {
					contasEspeciais.add(contas.get(i));
					qtdeContasEspeciais++;
				}
			}
			for (int i = 0; i < contasEspeciais.size(); i++) {
				Conta c = contasEspeciais.get(i);
				dados = dados.concat(c.toString() + "\n");
			}

			if (contasEspeciais.size() > 0) {
				return "=======================================\nContas Especiais: " + dados
						+ "\nQuantidade de contas especiais: " + qtdeContasEspeciais
						+ "\n=======================================";
			} else {
				return "\n==Não há nenhuma Conta Especial cadastrada no sistema\n";
			}
		}
	}

	public String buscarClientesUsandoLimite() {
		if (vazia()) {
			return "Lista de contas está vazia";
		} else {
			ArrayList<Conta> contasClientesUsandoLimite = new ArrayList<>();
			int qtdeClientes = 0;
			String dados = "";
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getSaldo() < 0) {
					contasClientesUsandoLimite.add(contas.get(i));
					qtdeClientes++;
				}
			}

			for (int i = 0; i < contasClientesUsandoLimite.size(); i++) {
				Conta c = contasClientesUsandoLimite.get(i);
				dados = dados.concat(c.toString() + "\n");
			}
			if (contasClientesUsandoLimite.size() > 0) {

				return "======================================\nContas usando limite:" + dados
						+ "Quantidade de clientes: " + qtdeClientes + "\n=======================================";
			} else {
				return "\n==Não há nenhum cliente usando limite\n";
			}
		}
	}

	public Conta buscarConta(int numeroDaConta) {
		if (vazia()) {
			System.out.println("Lista de contas está vazia");
			return null;
		} else {
			Conta c = contas.get(0);
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getNumeroDaConta() == numeroDaConta) {
					c = contas.get(i);
				}
			}
			if (c.getNumeroDaConta() == numeroDaConta) {
				return c;
			} else {
				return null;
			}
		}
	}

	public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor) {
		if (vazia()) {
			System.out.println("Lista de contas está vazia");
			return false;
		} else {
			Conta c = contas.get(0);
			Conta c2 = contas.get(0);
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getNumeroDaConta() == numeroContaFonte) {
					c = contas.get(i);
				}
				if (contas.get(i).getNumeroDaConta() == numeroContaDestino) {
					c2 = contas.get(i);
				}
			}
			if (c.getNumeroDaConta() == numeroContaFonte && c2.getNumeroDaConta() == numeroContaDestino
					&& c.getSaldo() >= valor) {
				c.sacar(valor);
				c2.depositar(valor);
				System.out.println("=======================================\nTransferência realizada com sucesso!\n"
						+ "Valor transferido: R$ " + valor + "\n=======================================");
				return true;
			} else {
				if (c.getNumeroDaConta() != numeroContaFonte) {
					System.out.println("\n== Número da conta de origem não existe.");
				}
				if (c2.getNumeroDaConta() != numeroContaDestino) {
					System.out.println("\n== Número da conta destino não existe.");
				}
				if (c.getSaldo() < valor) {
					System.out.println("\n== Saldo insuficiente para realizar a transação.");
				}
				return false;
			}
		}

	}

	public void renderPoupanca(int numeroDaConta, double valorRendimento) {
		if (vazia()) {
			System.out.println("Lista de contas está vazia");
		} else {
			Conta c = contas.get(0);
			double valorRendido = 0;
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getNumeroDaConta() == numeroDaConta && contas.get(i) instanceof ContaPoupanca) {
					c = contas.get(i);
					valorRendido = c.getSaldo() * (valorRendimento/ 100);
					c.calcularRendimento(valorRendimento);
				}
			}
			if (c.getNumeroDaConta() == numeroDaConta) {
				System.out.println("\nRendimento calculado com sucesso!\n\nValor rendimento: R$ "
						+ df.format(valorRendido) + "\nSaldo da conta: R$ " + df.format(c.getSaldo())
						+ "\n=======================================\n");
			} else {
				System.out.println(
						"\n=======================================\n\nNúmero da conta não existe \n=======================================\n");
			}
		}
	}

	public boolean sacar(int numeroDaConta, double valorSacado) {
		if (vazia()) {
			System.out.println("Lista de contas está vazia");
			return false;
		} else {
			Conta c = contas.get(0);
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getNumeroDaConta() == numeroDaConta) {
					c = contas.get(i);
				}
			}
			if (c instanceof ContaCorrente) {
				if (c.getSaldo() - valorSacado >= ((ContaCorrente) c).getLimite()
						&& c.getNumeroDaConta() == numeroDaConta
						|| c.getSaldo() > valorSacado && c.getNumeroDaConta() == numeroDaConta) {
					c.sacar(valorSacado);
					System.out.println("\n==Valor sacado: R$ " + df.format(valorSacado) + "\n" + c.toString());
					return true;
				} else {
					if (c.getNumeroDaConta() != numeroDaConta) {
						System.out.println("\n==Número da conta não existe.\n");
					} else if (c.getSaldo() - valorSacado < ((ContaCorrente) c).getLimite()
							|| c.getSaldo() < valorSacado) {
						System.out.println("\n==Saldo insuficiente para sacar o valor.\n");
					}
					return false;
				}
			} else if (c instanceof ContaEspecial) {
				if (c.getSaldo() - valorSacado > ((ContaEspecial) c).getLimite()
						&& c.getNumeroDaConta() == numeroDaConta
						|| c.getSaldo() > valorSacado && c.getNumeroDaConta() == numeroDaConta) {
					c.sacar(valorSacado);
					System.out.println("\n==Valor sacado: R$ " + df.format(valorSacado) + "\n" + c.toString() + "\n");
					return true;
				} else {
					if (c.getNumeroDaConta() != numeroDaConta) {
						System.out.println("\n==Número da conta não existe.\n");
					} else if (c.getSaldo() - valorSacado < ((ContaEspecial) c).getLimite()
							|| c.getSaldo() < valorSacado) {
						System.out.println("\n==Saldo insuficiente para sacar o valor.\n");
					}
					return false;
				}
			} else if (c instanceof ContaPoupanca) {
				if (c.getSaldo() > valorSacado && c.getNumeroDaConta() == numeroDaConta) {
					c.sacar(valorSacado);
					System.out.println("\n==Valor sacado: R$ " + valorSacado + "\n" + c.toString());
					return true;
				} else {
					if (c.getNumeroDaConta() != numeroDaConta) {
						System.out.println("\n==Número da conta não existe.\n");
					} else if (c.getSaldo() < valorSacado) {
						System.out.println("\n==Saldo insuficiente para sacar o valor.\n");
					}
					return false;
				}
			} else {
				System.out.println("\n==Número da conta não existe.\n");
				return false;
			}
		}
	}

	public boolean depositar(int numeroDaConta, double valorDepositado) {
		if (vazia()) {
			System.out.println("Lista de contas está vazia");
			return false;
		} else {
			Conta c = contas.get(0);
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getNumeroDaConta() == numeroDaConta) {
					c = contas.get(i);
				}
			}
			if (c.getNumeroDaConta() == numeroDaConta) {
				c.depositar(valorDepositado);
				System.out
						.println("\n==Valor depositado: R$ " + df.format(valorDepositado) + "\n" + c.toString() + "\n");
				return true;
			} else {
				System.out.println("\n==Número da conta não existe.\n");
				return false;
			}
		}

	}

	public String listarContas() {
		String dados = "";
		int qtdeContas = 0;
		for (int i = 0; i < contas.size(); i++) {
			Conta c = contas.get(i);
			dados = dados.concat(c.toString() + "\n");
		}
		return "=======================================\nContas no sistema: \n" + dados + "\nQuantidade de contas: "
				+ qtdeContas + "\n=======================================";
	}

	public boolean testarNumeroDaConta(int numeroDaConta) {
		int numero = 0;
		if (vazia() == false) {
			Conta c = contas.get(0);
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i).getNumeroDaConta() == numeroDaConta) {
					c = contas.get(i);
					numero = c.getNumeroDaConta();
				}
			}
		}
		if (numero == numeroDaConta) {
			return true;
		} else {
			return false;
		}
	}

	public void mudarLimite(int numeroDaConta, double valor) {
		if (vazia()) {
			System.out.println("Lista de contas está vazia");
		} else {
			Conta c = contas.get(0);
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i) instanceof ContaCorrente && contas.get(i).getNumeroDaConta() == numeroDaConta
						|| contas.get(i) instanceof ContaEspecial
								&& contas.get(i).getNumeroDaConta() == numeroDaConta) {
					if (contas.get(i) instanceof ContaCorrente) {
						c = contas.get(i);
						((ContaCorrente) c).setNovoLimite(valor);
					} else {
						c = contas.get(i);
						((ContaEspecial) c).setNovoLimite(valor);
					}
				}
			}
		}

	}

	public void mudarNomeGerente(int numeroDaConta, String novoGerente) {
		if (vazia()) {
			System.out.println("Lista de contas está vazia");
		} else {
			Conta c = contas.get(0);
			for (int i = 0; i < contas.size(); i++) {
				if (contas.get(i) instanceof ContaEspecial && contas.get(i).getNumeroDaConta() == numeroDaConta) {
					c = contas.get(i);
					((ContaEspecial) c).setNomeDoGerenteResponsavel(novoGerente);
				}
			}
		}
	}
}
