package jogo;

import java.awt.Color;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 {
	private Window janela;
	private Scene cena;
	private Submarino jogador;
	private Keyboard teclado;
	private Lixo lixo[];
	
	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn"));
		
		jogador = new Submarino(310, 535);
		lixo = new Lixo[10];
		teclado = janela.getKeyboard();
		Som.play("song.wav");
		
		run();
	}

	private void run() {
		lixo[0] = new Lixo(50, 300);
		lixo[1] = new Lixo(50, 400);
		lixo[2] = new Lixo(50, 500);
		lixo[3] = new Lixo(300, 300);
		lixo[4] = new Lixo(500, 300);
		lixo[5] = new Lixo(700, 300);
		lixo[6] = new Lixo(900, 400);
		lixo[7] = new Lixo(900, 650);
		lixo[8] = new Lixo(900, 650);
		lixo[9] = new Lixo(300, 650);
		
		while(true) {
			
			jogador.mover(janela,teclado);	
			jogador.caminho(cena);
			cena.moveScene(jogador);
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			jogador.draw();
			
			for (int i = 0; i < lixo.length; i++) {
				lixo[i].caminho(cena);
				lixo[i].perseguirSubmarino(jogador.x, jogador.y);
				lixo[i].x += cena.getXOffset();
				lixo[i].y += cena.getYOffset();
				lixo[i].draw();
				jogador.atirar(janela, cena, teclado, lixo[i]);
				lixo[i].morrer();
				lixo[i].atacar(jogador, janela);
			}
			
			jogador.energia(janela);
			janela.update();
			
			for (int i = 0; i < lixo.length; i++) {
				if (lixo[i].y == 1_000_000) {
					janela.drawText("Fim", 400, 400, Color.GREEN);
				}
			}
			
		}	
	}
}
