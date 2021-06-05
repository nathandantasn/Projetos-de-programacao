import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RespostaAleatoria extends Resposta{
	
	private ArrayList <String> respostasAleatorias = new ArrayList<>();
	private int contador;

	public RespostaAleatoria(String palavraChave, ArrayList <String> respostas) {
		super(palavraChave);
		this.respostasAleatorias = respostas;
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
		this.contador = ThreadLocalRandom.current().nextInt(0, this.respostasAleatorias.size());
		return respostasAleatorias.get(contador);	
	}

}
