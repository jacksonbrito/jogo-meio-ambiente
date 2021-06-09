package jogo;

import java.awt.Point;
import java.util.Vector;
import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite {
	protected int direcao;
	private double velocidade;
	private boolean movendo;
	private double energia;
	
	Controle controle = new Controle();
	
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);

		this.setDirecao(3);
		this.setVelocidade(1.25);
		this.setMovendo(false);
		this.setEnergia(1000);
	}
	
	public double getEnergia() {
		return energia;
	}
	
	public void setEnergia(double energia) {
		this.energia = energia;
	}
	
	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public int getDirecao() {
		return direcao;
	}

	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}

	public boolean isMovendo() {
		return movendo;
	}
	
	public void setMovendo(boolean movendo) {
		this.movendo = movendo;
	}
	
	public void caminho(Scene cena) {
        Point min = new Point((int)super.x, (int)super.y);
        Point max = new Point((int)super.x + super.width, (int)super.y + super.height);

        Vector<?>tiles = cena.getTilesFromPosition(min, max);

        for (int i = 0; i < tiles.size(); i++) {
            TileInfo tile = (TileInfo) tiles.elementAt(i);

            if(controle.colisao(this, tile) == true) {

            	if(colisaoVertical(this, tile)) {
            		
            		if(tile.y + tile.height - 2 < super.y) {
            			super.y = tile.y + tile.height;
            		}
            		else if (tile.y > super.y + super.height - 2) {
            			super.y = tile.y - super.height;
            		}
            	}
                if (colisaoHorizontal(this,tile)) {
                    
					if(tile.x > super.x + super.width - 2) {
                        super.x = tile.x - super.width;
                    }
                    else{
                        super.x = tile.x + tile.width;
                    }
                }
            }
        }
    }
	
	private boolean colisaoVertical(GameObject obj, GameObject obj2) {
		if(obj2.x + obj2.width <= obj.x) {
			return false;
        }
        if (obj.x + obj.width <= obj2.x) {
        	return false;
        }
        return true;
    }
        
	private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
		if(obj2.y + obj2.height <= obj.y) {
			return false;
		}
		if (obj.y + obj.height <= obj2.y) {
			return false;
        }
        return true;
	}	
}
