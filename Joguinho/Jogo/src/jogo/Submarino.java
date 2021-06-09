package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Submarino extends Ator {
	static double energia = 1000;
	
	Font f = new Font("arial", Font.BOLD, 30);
		
	public Submarino(int x, int y) {
		super(URL.sprite("submarino.png"), 2);
		super.x = x;
		super.y = y;
		super.setTotalDuration(2000);
	}
	
	ControleTiros tiros = new ControleTiros();
	
	public void atirar(Window janela, Scene cena, Keyboard teclado, Ator inimigo) {
		if(teclado.keyDown(KeyEvent.VK_SPACE)) {
			tiros.adicionaTiro(this.x + 80, this.y + 25, this.direcao, cena);
		}
		tiros.run(inimigo);
	}
	
	public void mover(Window janela, Keyboard teclado) {
		if (teclado.keyDown(Keyboard.LEFT_KEY) == true) {
			if (super.x > 0) {
				super.x  -= super.getVelocidade();
			}
			if (super.getDirecao() != 1) {
				setSequence(1, 0);
				super.setDirecao(1);
			}
			super.setMovendo(true);
			
		}else if (teclado.keyDown(Keyboard.RIGHT_KEY) == true) {
			if (super.x < janela.getWidth() - 150) {
				super.x  += super.getVelocidade();	
			}
			if (super.getDirecao() != 2) {
				setSequence(0, 1);
				super.setDirecao(2);
			}
			super.setMovendo(true);
			
		}else if (teclado.keyDown(Keyboard.UP_KEY) == true) {
            if (super.y > 0) {
                super.y  -= super.getVelocidade();
            }
            if (super.getDirecao() != 4) {
                setSequence(0, 1);
                super.setDirecao(4);
            }
            super.setMovendo(true);
            
        }else if (teclado.keyDown(Keyboard.DOWN_KEY) == true) {
            if (super.y < janela.getHeight() - 85) {
                super.y  += super.getVelocidade();
            }
            if (super.getDirecao() != 5) {
                setSequence(1, 0);
                super.setDirecao(5);
            }
            super.setMovendo(true);
        }
		
		if (super.isMovendo()) {
			update();
			super.setMovendo(false);
		}
	}
	
	public void energia(Window janela) {
		janela.drawText("Vida: " + Submarino.energia, 30, 30, Color.RED, f);
	}
}
