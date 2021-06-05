
public class RespostaContador extends Resposta {
	
	private int contador;
	
	public RespostaContador(String palavraChave) {
		super(palavraChave);
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
	public  String produz() {
		this.contador++;
		return "Ok! Atualmente a conta está em " + this.contador;	
	}

}
