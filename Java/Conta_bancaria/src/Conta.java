import java.text.DecimalFormat;

public abstract class Conta {
	DecimalFormat df = new DecimalFormat("###,##0.00");
	private int numeroDaConta;
	private String nomeDoCliente;
	private int cpf;
	private double saldo;
	
	
		public Conta(int numeroDaConta, String nomeDoCliente, int CPF) {
			this.numeroDaConta = numeroDaConta;
			this.nomeDoCliente = nomeDoCliente;
			this.cpf = CPF;
		}
		
		public int getNumeroDaConta() {
			return this.numeroDaConta;
		}
		
		public String getNomeDoCliente() {
			return this.nomeDoCliente;
		}
		
		public int getCpf() {
			return this.cpf;
		}
		
		public double getSaldo() {
			return this.saldo;
		}
		
		public void calcularRendimento(double valorRendimento) {
		}
		
		public void setNomeDoCliente(String nomeDoCliente) {
			this.nomeDoCliente = nomeDoCliente;
		}
		
		public boolean sacar(double valor) {
			this.saldo -= valor;
			return true;
		}
		
		public boolean depositar(double valor) {
			this.saldo += valor;
			return true;
		}
		
		public String toString(){
			return "\nNúmero da conta: 000"+ getNumeroDaConta()
					+ "\nCliente: " + getNomeDoCliente() + "      CPF: " + getCpf()
					+ "\nSaldo: " + df.format(getSaldo());
		}
	
}
