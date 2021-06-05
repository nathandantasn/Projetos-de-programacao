
public class ContaPoupanca extends Conta {
	
		private double porcentagem;
		
		public ContaPoupanca(int numeroDaConta, String nomeDoCliente, int CPF) {
			super(numeroDaConta, nomeDoCliente, CPF);
		}

		@Override
		public void calcularRendimento(double valorRendimento) {
			depositar((valorRendimento/100) * getSaldo());
		}
		
		@Override
		public String toString() {
			return "\nConta Poupan�a:\nN�mero da conta: 000"+ getNumeroDaConta()
			+ "\nCliente: " + getNomeDoCliente() + " CPF: " + getCpf()
			+ "\nSaldo: " + df.format(getSaldo());
		}

}
