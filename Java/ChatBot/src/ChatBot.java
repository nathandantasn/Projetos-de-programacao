import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ChatBot {

	private ArrayList<Resposta> respostas;
	private ArrayList<String> respostaAlternativa = new ArrayList<>();
	private ArrayList<String> respostaAleatoriaPiadas;
	private ArrayList<String> respostaAleatoriaCuriosidades;

	public ChatBot() {
		this.respostas = new ArrayList<>();
		this.respostaAleatoriaPiadas = new ArrayList<>();
		this.respostaAleatoriaCuriosidades = new ArrayList<>();
		bancoDeRespostas();
	}

	public void adiciona(Resposta resposta) {
		respostas.add(resposta);
	}

	public void processa(String texto) {

		Resposta r = respostas.get(0);
		String resp = "";

		for (int i = 0; i < respostas.size(); i++) {
			if (respostas.get(i).verifica(texto) == true) {
				r = respostas.get(i);
				resp = r.produz();
			}
		}

		if (r.verifica(texto) == true) {
			if (r instanceof RespostaSimples) {
				if (r.encerrarConversa()) {
					System.out.println("> @mandrakinho157: "+resp);
					System.out.println("\nFim da conversa.");
					System.exit(0);
				} else {
					System.out.println("> @mandrakinho157: "+resp);
				}
			} else if (r instanceof RespostaHora) {
				System.out.println("> @mandrakinho157: "+resp);
			} else if (r instanceof RespostaAleatoria) {
				System.out.println("> @mandrakinho157: "+resp);
			} else if (r instanceof RespostaData) {
				System.out.println("> @mandrakinho157: "+resp);
			} else if (r instanceof RespostaContador) {
				System.out.println("> @mandrakinho157: "+resp);
			}
		} else {
			System.out.println("> @mandrakinho157: "+this.respostaAlternativa
					.get(ThreadLocalRandom.current().nextInt(0, this.respostaAlternativa.size())));
		}

	}

	public void adicionarPiada(String piada) {
		this.respostaAleatoriaPiadas.add(piada);
	}

	public void adicionarCuriosidade(String curiosidade) {
		this.respostaAleatoriaCuriosidades.add(curiosidade);
	}

	public void adicionarRespostaAlternativa(String resposta) {
		this.respostaAlternativa.add(resposta);
	}

	public void bancoDePiadas() {
		adicionarPiada("Qual a cidade brasileira que n�o tem t�xi? Uberl�ndia");
		adicionarPiada("Por que o mouse � muito mimado? Porque tudo que ele quer, o mouse pad.");
		adicionarPiada("Por que o pinheiro n�o se perde na floresta? Porque ele tem uma pinha");
		adicionarPiada(
				"Se voc� est� se sentindo sozinho, abandonado, achando que ningu�m liga para voc�... Atrase um pagamento.");
		adicionarPiada("O que s�o 4 pontinhos pretos na parede? Fourmigas");
		adicionarPiada(
				"O pato ama a pata, mas a pata n�o corresponde o amor do pato, o que eles t�m? Um amor pat�nico");
		adicionarPiada("Por que o sapo entra no computador? Para procurar a mem�ria RAM");
		adicionarPiada("O que o rato americano falou para o rato brasileiro? Come on Dongo! ");
		adicionarPiada("Voc� sabe qual � o rei dos queijos ? O Rei Queij�o");
		adicionarPiada(
				"O exterminador do futuro foi na assist�ncia t�cnica, e o t�cnico perguntou: instala XP? O exterminador respondeu: instala Vista, baby. ");
		respostas.add(new RespostaAleatoria("piada", this.respostaAleatoriaPiadas));
	}

	public void bancoDeCuriosidades() {
		adicionarCuriosidade("Voc� sabia que o Oceano Atl�ntico � mais salgado que o Pac�fico ?");
		adicionarCuriosidade("As uvas explodem quando colocadas no microondas.");
		adicionarCuriosidade("Em V�nus, 1 ano dura 243 dias.");
		adicionarCuriosidade("Comer uma ma�� � mais eficiente que tomar caf� para se manter acordado.");
		adicionarCuriosidade("A senha mais usada do mundo � 123456.");
		adicionarCuriosidade("Sanguessugas tem 34 c�rebros.");
		adicionarCuriosidade("O isqueiro foi inventado antes dos f�sforos.");
		adicionarCuriosidade("A barata consegue sobreviver por nove dias sem a cabe�a antes de morrer de fome.");
		adicionarCuriosidade("N�o � poss�vel roncar e sonhar ao mesmo tempo, de acordo com estudos.");
		respostas.add(new RespostaAleatoria("curiosidade", this.respostaAleatoriaCuriosidades));

	}

	public void bancoDeRespostasSimples() {

		adiciona(new RespostaSimples("nome", "Meu vulgo � Mandrakinho, o mais chavoso do peda�o. 8)"));
		adiciona(new RespostaSimples("mora", "Moro na cidade de S�o Paulo, conhece Campo Limpo ? Ent�o... por ali..."));
		adiciona(new RespostaSimples("salve", "Salve meu aliado, no que posso te ajudar?"));
		adiciona(new RespostaSimples("oi", "Qual a boa?"));
		adiciona(new RespostaSimples("ol�", "Opa eai brother"));
		adiciona(new RespostaSimples("eae", "Eae meu querido, manda bala"));
		adiciona(new RespostaSimples("bom dia", "Bom dia pra quem?"));
		adiciona(new RespostaSimples("noite", "Boa noite pra nois"));
		adiciona(new RespostaSimples("tarde", "Tardeeeeee"));
		adiciona(new RespostaSimples("bem", "Tudo em cima, e ai?"));
		adiciona(new RespostaSimples("vai", "Tranquil�o, na maior paz eai?"));
		adiciona(new RespostaSimples("lindo", "O pai � embassado mesmo, mo satisfa��o, s� agradece"));
		adiciona(new RespostaSimples("bonito", "Satisfa��o memo hein, obrigado bro"));
		adiciona(new RespostaSimples("tamb�m", "Maravilha meu bom, s� progresso"));
		adiciona(new RespostaSimples("idade", "Minha idade � confidencial meu caro, infelizmente ficarei devendo essa info hehe"));
		adiciona(new RespostaSimples("faz",
				"De segunda a sexta, tomo esporro na escola. S�bado e domingo, solto pipa e jogo bola"));
		adiciona(new RespostaSimples("tchau", "Valeu amigo, foi bom trocar aquela ideinha, at� a pr�xima"));
		adiciona(new RespostaSimples("falow", "� nois que voa brux�o, satisfa��o, tamo junto"));
		adiciona(new RespostaSimples("/ajuda", " # Para adicionar piadas no chat, usar o m�todo bot.adicionarPiada('escrever a piada')"
				+ "\n # Para adicionar curiosidades no chat, usar o m�todo bot.adicionarPiada('escrever a curiosidade')"
				+ "\n # Para adicionar palavras chaves e respostas simples, usar o m�todo bot.adicionar('palavra chave(tudo min�sculo)', 'resposta')\n"));
		adiciona(new RespostaSimples("certeza", "Confia que o pai ta monstro hoje. 8) $$"));
		adiciona(new RespostaSimples("intera��es", "* nome, lindo, mora, bom dia, hoje, horas, faz, salve, oi, ol�, conta, bem, boa tarde, boa noite *"));
	}

	public void bancoDeRespostasAlternativas() {
		adicionarRespostaAlternativa("Tendeu foi nada");
		adicionarRespostaAlternativa("De novo, tu com os papo que n�o to entendendo");
		adicionarRespostaAlternativa("Me explica isso direito");
		adicionarRespostaAlternativa("Respira e escreve de novo");
		adicionarRespostaAlternativa("Vai com calma, campe�o, o que tu quer dizer com isso?");
		adicionarRespostaAlternativa("Calmou le�o, entendi foi nada, digita de novo");
		adicionarRespostaAlternativa("Men, talvez n�o tenha resposta pra isso, que tal adicionar?");
	}

	public void bancoDeRespostas() {
		bancoDeRespostasSimples();
		respostas.add(new RespostaContador("conta"));
		bancoDePiadas();
		bancoDeRespostasAlternativas();
		bancoDeCuriosidades();
		respostas.add(new RespostaData("hoje"));
		respostas.add(new RespostaHora("hora"));
	}

}
