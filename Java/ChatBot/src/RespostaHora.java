import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RespostaHora extends Resposta{
	
	private String respostaHora;
	
	public RespostaHora(String palavraChave) {
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
	
	public String horaFormatada() {
		DateFormat formato = new SimpleDateFormat("HH:mm");
		Date horaAtual = new Date();
		String horaFormatada = formato.format(horaAtual);
		return horaFormatada;
	}
	
	@Override
	public  String produz() {
		this.respostaHora = "São 04h20... brincadeira, deixa o pai ver no Rolex!... Agora são " + horaFormatada() + "!";
		return this.respostaHora;	
	}

}
