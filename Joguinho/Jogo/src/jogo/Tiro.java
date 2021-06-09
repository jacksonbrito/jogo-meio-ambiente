package jogo;

import jplay.Sprite;
import jplay.URL;

public class Tiro extends Sprite {

	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
	
	protected static final int VELOCIDADE_TIRO = 1;
	protected int caminho = STOP;
	protected boolean movendo;
	protected int direcao;

	public Tiro(double x, double y, int caminho) {
		super(URL.sprite("Missil.png"), 12);
		this.setCaminho(caminho);
		super.x = x;
		super.y = y;
		
		this.setMovendo(false);
		this.setDirecao(3);
	}
	
	public int getCaminho() {
		return caminho;
	}

	public void setCaminho(int caminho) {
		this.caminho = caminho;
	}

	public boolean isMovendo() {
		return movendo;
	}

	public void setMovendo(boolean movendo) {
		this.movendo = movendo;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}
	
	public void mover() {
		if (this.getCaminho() == LEFT) {
			super.x -= VELOCIDADE_TIRO;
			if (this.getDirecao() != 1) {
				setSequence(3, 5);
			}
			this.setMovendo(true);
		}
		if (this.getCaminho() == RIGHT || this.getCaminho() == STOP) {
			super.x += VELOCIDADE_TIRO;
			if (this.getDirecao() != 2) {
				setSequence(0, 2);
			}
			this.setMovendo(true);
		}
		if (this.getCaminho() == UP) {
			super.y -= VELOCIDADE_TIRO;
			if (this.getDirecao() != 4) {
				setSequence(9, 11);
			}
			this.setMovendo(true);
		}
		if (this.getCaminho() == DOWN) {
			super.y += VELOCIDADE_TIRO;
			if (this.getDirecao() != 5) {
				setSequence(6, 8);
			}
			this.setMovendo(true);
		}
		if (this.isMovendo()) {
			update();
			this.setMovendo(false);
		}
	}
}
