/**
 * Um exemplo de agente que anda aleatoriamente na arena. Esse agente pode ser usado como base
 * para a criação de um agente mais esperto. Para mais informações sobre métodos que podem
 * ser utilizados, veja a classe Agente.java.
 * 
 * Fernando Bevilacqua <fernando.bevilacqua@uffs.edu.br>
 */

package br.uffs.cc.jarena;

public class AgenteDaniel extends Agente

{
	int cont;

	public AgenteDaniel(Integer x, Integer y, Integer energia) {
		super(x, y, energia);
		setDirecao(geraDirecaoAleatoria());
		cont = 10;
	}
	
	public void pensa() {
		cont++;
		if (cont == 10) {
			setDirecao(BAIXO);
		if (cont%10 == 0){
			if (getId() == cont && getX() >= 10){
				
				setDirecao(CIMA);
			}
			cont++;
		}
		// Se não conseguimos nos mover para a direção atual, quer dizer
		// que chegamos no final do mapa ou existe algo bloqueando nosso
		// caminho.
		if(!podeMoverPara(getDirecao())) {
			setDirecao(DIREITA);
			System.out.println("VAMOS PARA CIMA");
			// Como não conseguimos nos mover, vamos escolher uma direção
			// nova.
			setDirecao(geraDirecaoAleatoria());
		}
		
		// Se o agente conseguie se dividir (tem energia) e se o total de energia
		// do agente é maior que 400, nos dividimos. O agente filho terá a metade
		// da nossa energia atual.
		if(podeDividir() && getEnergia() >= 800) {
			divide();
		}
	}
}
	public void recebeuEnergia() {
		System.out.println(getX() +"," +getY());
		String oy= Integer. toString(getX());
		String ox = Integer.toString(getY());
		enviaMensagem(ox + "," +oy);
		// Invocado sempre que o agente recebe energia.
	}
	
	public void tomouDano(int energiaRestanteInimigo) {
		if (getEnergia() >= energiaRestanteInimigo){
			System.out.println(getId());
		}else{
			setDirecao(ESQUERDA);
		}
		// Invocado quando o agente está na mesma posição que um agente inimigo
		// e eles estão batalhando (ambos tomam dano).
	}
	
	public void ganhouCombate() {
		System.out.println("Vence O Combate");
		// Invocado se estamos batalhando e nosso inimigo morreu.
	}
	
	public void recebeuMensagem(String msg) {
		String[] Coordenadas =msg.split(",");
		int myX = Integer .parseInt(Coordenadas[0]);
		int myY = Integer .parseInt(Coordenadas[1]);
		System.out.println("aqui tem energia");
		
		// Invocado sempre que um agente aliado próximo envia uma mensagem.
	}
	
	public String getEquipe() {
		// Definimos que o nome da equipe do agente é "Fernando".
		return "Daniel";
	}
}
