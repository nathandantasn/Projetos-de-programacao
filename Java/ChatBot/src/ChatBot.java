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
		adicionarPiada("Qual a cidade brasileira que não tem táxi? Uberlândia");
		adicionarPiada("Por que o mouse é muito mimado? Porque tudo que ele quer, o mouse pad.");
		adicionarPiada("Por que o pinheiro não se perde na floresta? Porque ele tem uma pinha");
		adicionarPiada(
				"Se você está se sentindo sozinho, abandonado, achando que ninguém liga para você... Atrase um pagamento.");
		adicionarPiada("O que são 4 pontinhos pretos na parede? Fourmigas");
		adicionarPiada(
				"O pato ama a pata, mas a pata não corresponde o amor do pato, o que eles têm? Um amor patônico");
		adicionarPiada("Por que o sapo entra no computador? Para procurar a memória RAM");
		adicionarPiada("O que o rato americano falou para o rato brasileiro? Come on Dongo! ");
		adicionarPiada("Você sabe qual é o rei dos queijos ? O Rei Queijão");
		adicionarPiada(
				"O exterminador do futuro foi na assistência técnica, e o técnico perguntou: instala XP? O exterminador respondeu: instala Vista, baby. ");
		respostas.add(new RespostaAleatoria("piada", this.respostaAleatoriaPiadas));
	}

	public void bancoDeCuriosidades() {
		adicionarCuriosidade("Você sabia que o Oceano Atlântico é mais salgado que o Pacífico ?");
		adicionarCuriosidade("As uvas explodem quando colocadas no microondas.");
		adicionarCuriosidade("Em Vênus, 1 ano dura 243 dias.");
		adicionarCuriosidade("Comer uma maçã é mais eficiente que tomar café para se manter acordado.");
		adicionarCuriosidade("A senha mais usada do mundo é 123456.");
		adicionarCuriosidade("Sanguessugas tem 34 cérebros.");
		adicionarCuriosidade("O isqueiro foi inventado antes dos fósforos.");
		adicionarCuriosidade("A barata consegue sobreviver por nove dias sem a cabeça antes de morrer de fome.");
		adicionarCuriosidade("Não é possível roncar e sonhar ao mesmo tempo, de acordo com estudos.");
		respostas.add(new RespostaAleatoria("curiosidade", this.respostaAleatoriaCuriosidades));

	}

	public void bancoDeRespostasSimples() {

		adiciona(new RespostaSimples("nome", "Meu vulgo é Mandrakinho, o mais chavoso do pedaço. 8)"));
		adiciona(new RespostaSimples("mora", "Moro na cidade de São Paulo, conhece Campo Limpo ? Então... por ali..."));
		adiciona(new RespostaSimples("salve", "Salve meu aliado, no que posso te ajudar?"));
		adiciona(new RespostaSimples("oi", "Qual a boa?"));
		adiciona(new RespostaSimples("olá", "Opa eai brother"));
		adiciona(new RespostaSimples("eae", "Eae meu querido, manda bala"));
		adiciona(new RespostaSimples("bom dia", "Bom dia pra quem?"));
		adiciona(new RespostaSimples("noite", "Boa noite pra nois"));
		adiciona(new RespostaSimples("tarde", "Tardeeeeee"));
		adiciona(new RespostaSimples("bem", "Tudo em cima, e ai?"));
		adiciona(new RespostaSimples("vai", "Tranquilão, na maior paz eai?"));
		adiciona(new RespostaSimples("lindo", "O pai é embassado mesmo, mo satisfação, só agradece"));
		adiciona(new RespostaSimples("bonito", "Satisfação memo hein, obrigado bro"));
		adiciona(new RespostaSimples("também", "Maravilha meu bom, só progresso"));
		adiciona(new RespostaSimples("idade", "Minha idade é confidencial meu caro, infelizmente ficarei devendo essa info hehe"));
		adiciona(new RespostaSimples("faz",
				"De segunda a sexta, tomo esporro na escola. Sábado e domingo, solto pipa e jogo bola"));
		adiciona(new RespostaSimples("tchau", "Valeu amigo, foi bom trocar aquela ideinha, até a próxima"));
		adiciona(new RespostaSimples("falow", "É nois que voa bruxão, satisfação, tamo junto"));
		adiciona(new RespostaSimples("/ajuda", " # Para adicionar piadas no chat, usar o método bot.adicionarPiada('escrever a piada')"
				+ "\n # Para adicionar curiosidades no chat, usar o método bot.adicionarPiada('escrever a curiosidade')"
				+ "\n # Para adicionar palavras chaves e respostas simples, usar o método bot.adicionar('palavra chave(tudo minúsculo)', 'resposta')\n"));
		adiciona(new RespostaSimples("certeza", "Confia que o pai ta monstro hoje. 8) $$"));
		adiciona(new RespostaSimples("interações", "* nome, lindo, mora, bom dia, hoje, horas, faz, salve, oi, olá, conta, bem, boa tarde, boa noite *"));
	}

	public void bancoDeRespostasAlternativas() {
		adicionarRespostaAlternativa("Tendeu foi nada");
		adicionarRespostaAlternativa("De novo, tu com os papo que não to entendendo");
		adicionarRespostaAlternativa("Me explica isso direito");
		adicionarRespostaAlternativa("Respira e escreve de novo");
		adicionarRespostaAlternativa("Vai com calma, campeão, o que tu quer dizer com isso?");
		adicionarRespostaAlternativa("Calmou leão, entendi foi nada, digita de novo");
		adicionarRespostaAlternativa("Men, talvez não tenha resposta pra isso, que tal adicionar?");
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
