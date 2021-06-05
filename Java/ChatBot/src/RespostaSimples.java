
public class RespostaSimples extends Resposta{
	
	private String respostaSimples;

	public RespostaSimples(String palavraChave, String respostaSimples) {
		super(palavraChave);
		this.respostaSimples = respostaSimples;
	}
	
	@Override
	public boolean verifica(String entrada) {
		entrada = entrada.toLowerCase();
		if (entrada.contains(getPalavraChave())) {
			return true;
		}
		else {
		return false;	
		}
	}
	
	@Override
	public boolean encerrarConversa() {
		if (getPalavraChave().equalsIgnoreCase("tchau") || getPalavraChave().equalsIgnoreCase("falow")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String produz() {
			return this.respostaSimples;	
	}

}
