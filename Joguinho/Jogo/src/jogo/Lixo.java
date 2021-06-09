package jogo;

import jplay.URL;
import jplay.Window;

public class Lixo extends Ator {
	private double ataque;

	public Lixo(int x, int y) {
		super(URL.sprite("Trash.png"), 2);
		super.x = x;
		super.y = y;
		super.setTotalDuration(2000);
		
		this.setVelocidade(0.2);
		this.setMovendo(false);
		this.setAtaque(0.5);
	}
	
	public double getAtaque() {
		return ataque;
	}

	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}

	public void perseguirSubmarino(double x, double y) {
		if (super.x > x && super.y <= y + 50 && super.y >= y - 50 ) {
			moveTo(x, y, getVelocidade());
			if (super.getDirecao() != 1 ) {
				setSequence(0, 1);
				super.setDirecao(1);
			} 
			super.setMovendo(true);
		}
		else if (super.x < x && super.y <= y + 50 && super.y >= y - 50 ) {
			moveTo(x, y, getVelocidade());
			if (super.getDirecao() != 2 ) {
				setSequence(1,0);
				super.setDirecao(2);
			} 
			super.setMovendo(true);	
		}
		else if (super.y > y ) {
			moveTo(x, y, getVelocidade());
			if (super.getDirecao() != 4 ) {
				setSequence(0, 1);
				super.setDirecao(4);
			} 
			super.setMovendo(true);	
		}
		else if (super.y < y ) {
			moveTo(x, y, getVelocidade());
			if (super.getDirecao() != 5 ) {
				setSequence(1,0);
				super.setDirecao(5);
			} 
			super.setMovendo(true);	
		}
		if(super.isMovendo()) {
			update();
			super.setMovendo(false);
		}
	}

	public void morrer() {
		if (super.getEnergia() <= 0) {
			super.setVelocidade(0);
			super.setMovendo(false);
			super.setDirecao(0);
			this.setAtaque(0);
			
			super.x = 1_000_000;
		}
	}
	
	public void atacar(Submarino jogador, Window janela) {
		if (this.collided(jogador)) {
			Submarino.energia -= this.getAtaque();
		}
		if (Submarino.energia <= 0) {
			System.exit(0);
		}
	}
}
