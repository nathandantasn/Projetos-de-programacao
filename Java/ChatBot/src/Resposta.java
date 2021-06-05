
public abstract class Resposta {
	
	private String palavraChave;
	
	public Resposta(String palavraChave) {
		this.palavraChave = palavraChave;
	}
	
	public abstract boolean verifica(String entrada);
	
	public abstract String produz();
	
	public String getPalavraChave() {
		return this.palavraChave;
	}
	
	public boolean encerrarConversa() {
		return true;
	}
}
