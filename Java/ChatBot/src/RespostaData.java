import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RespostaData extends Resposta{
	
	private String respostaData;
	private String diaSemana;
	
	public RespostaData(String palavraChave) {
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
	public String produz() {
		this.respostaData = "Hoje é " + data();
		return this.respostaData;	
	}
	
	public String diaSemana() {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		 GregorianCalendar calendario = new GregorianCalendar();
		    try {
				calendario.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(data));
		        switch (calendario.get(Calendar.DAY_OF_WEEK)) {
		            case Calendar.SUNDAY:
		                this.diaSemana = "Dominguera";
		                break;
		            case Calendar.MONDAY:
		                this.diaSemana = "Segunda-feira, infelizmente...";
		                break;
		            case Calendar.TUESDAY:
		            	this.diaSemana = "Terça-feira, seguimos...";
		            break;
		            case Calendar.WEDNESDAY:
		            	this.diaSemana = "Quarta-feira.";
		                break;
		            case Calendar.THURSDAY:
		            	this.diaSemana = "Quinta-feira, quase sexta!";
		                break;
		            case Calendar.FRIDAY:
		            	this.diaSemana = "Sexta-feira, dia de maldade!";
		                break;
		            case Calendar.SATURDAY:
		            	this.diaSemana = "Sábadoooww";
		        }
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    return this.diaSemana;
	}
	
	public String data() {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy, ").format(dataHoraAtual) + diaSemana();
		return data;
	}

}
