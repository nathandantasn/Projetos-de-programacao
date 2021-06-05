
public class ContaCorrente extends Conta {

	private double limite;
	
		public ContaCorrente(int numeroDaConta, String nomeDoCliente, int CPF) {
			super(numeroDaConta, nomeDoCliente, CPF);
			this.limite = 0;
		}
		
		public ContaCorrente(int numeroDaConta, String nomeDoCliente, int CPF, double limite) {
			super(numeroDaConta, nomeDoCliente, CPF);
			this.limite = limite * -1;
		}

		public double getLimite() {
			return this.limite;
		}
		
		public void setNovoLimite(double valor) {
			this.limite = valor*-1;
		}
		
		public boolean usandoLimite() {
			if (getSaldo() < 0) {
				return true;
			}
			else {
				return false;
			}
		}

		@Override
		public String toString(){
			return "\nConta Corrente:\nNúmero da conta: 000"+ getNumeroDaConta()
			+ "\nCliente: " + getNomeDoCliente() + "      CPF: " + getCpf()
			+ "\nSaldo: R$ " + df.format(getSaldo()) + "      Limite: R$ " + df.format(getLimite());
		}	
		
	}

