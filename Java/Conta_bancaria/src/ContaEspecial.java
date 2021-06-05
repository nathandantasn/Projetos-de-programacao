
public class ContaEspecial extends ContaCorrente {
	
	private String nomeDoGerenteResponsavel;
	
	public ContaEspecial(int numeroDaConta, String nomeDoCliente, int CPF, String nomeDoGerenteResponsavel) {
		super(numeroDaConta, nomeDoCliente, CPF);
		this.nomeDoGerenteResponsavel = nomeDoGerenteResponsavel;
	}
	
	public ContaEspecial(int numeroDaConta, String nomeDoCliente, int CPF, double limite, String nomeDoGerenteResponsavel) {
		super(numeroDaConta, nomeDoCliente, CPF, limite);
		this.nomeDoGerenteResponsavel = nomeDoGerenteResponsavel;
	}
	
	public String getNomeDoGerenteResponsavel() {
		return this.nomeDoGerenteResponsavel;
	}
	
	public void setNomeDoGerenteResponsavel(String nomeDoGerenteResponsavel) {
		this.nomeDoGerenteResponsavel = nomeDoGerenteResponsavel;
	}
	
	@Override
	public String toString(){
		return "\nConta Especial:\nNúmero da conta: 000"+ getNumeroDaConta()
		+ "\nCliente: " + getNomeDoCliente() + "      CPF: " + getCpf()
		+ "\nGerente da Conta: " + getNomeDoGerenteResponsavel()
		+ "\nSaldo: R$ " + df.format(getSaldo()) + "      Limite: R$ " + df.format(getLimite());
	}
}
