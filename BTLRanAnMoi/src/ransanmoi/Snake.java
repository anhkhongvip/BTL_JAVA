package ransanmoi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Snake {
	int doDai = 3;
	int[] x;
	int[] y;
	long t1 = 0;
	public static int GO_UP = 1;
	public static int GO_DOWN = -1;
	public static int GO_LEFT = 2;
	public static int GO_RIGHT = -2;
	int vector = Snake.GO_DOWN;
	int maxLength = 8;
	int speed = 200;
	boolean updateAfterExchange = true;

	public Snake() {
		x = new int[20];
		y = new int[20];

		x[0] = 5;
		y[0] = 4;

		x[1] = 5;
		y[1] = 3;

		x[2] = 5;
		y[2] = 2;
		
	}

	public void reset() {
		doDai = 3;
		x = new int[20];
		y = new int[20];

		x[0] = 5;
		y[0] = 4;

		x[1] = 5;
		y[1] = 3;

		x[2] = 5;
		y[2] = 2;
		vector = Snake.GO_DOWN;
	}

	public void setVector(int v) {
		if (vector != -v && updateAfterExchange) {
			vector = v;
			updateAfterExchange = false;
		}
	}

	public boolean PointCoNamTrongRan(int x1, int y1) // xem diem co nam trung tren co ran khong
	{
		for (int i = 1; i < doDai; i++) {
			if (x[i] == x1 && y[i] == y1) {
				return true;
			}
		}
		return false;
	}

	public Point getCoordinatesPoint() {
		int x;
		int y;
		Random r = new Random();
		do {
			x = r.nextInt(19);
			y = r.nextInt(19);
		} while (PointCoNamTrongRan(x, y));
		return new Point(x, y);
	}
	public int getCurrentSpeed(){
		int speed = 200;
		for(int i = 0; i < GameScreen.currentLevel; i++)
		{
			speed *= 0.8;
		}
		return speed;
	}
	public void update() {
		if (doDai == maxLength) {
			GameScreen.isPlaying = false;
			reset();
			GameScreen.currentLevel++;
			speed = getCurrentSpeed();
		}
		for (int i = 1; i < doDai; i++) {
			if (x[0] == x[i] && y[0] == y[i]) {
				GameScreen.isPlaying = false;
				GameScreen.isGameOver = true;
			}
		}
		if (System.currentTimeMillis() - t1 > speed) {
			if (GameScreen.bg[x[0]][y[0]] == 2) {
				doDai++;
				GameScreen.bg[x[0]][y[0]] = 0;
				GameScreen.bg[getCoordinatesPoint().x][getCoordinatesPoint().y] = 2;
				GameScreen.pointSnake += 100;
			}
			for (int i = doDai - 1; i > 0; i--) {
				x[i] = x[i - 1];
				y[i] = y[i - 1];
			}
			
			if (vector == Snake.GO_UP)
				y[0]--;
			if (vector == Snake.GO_DOWN)
				y[0]++;
			if (vector == Snake.GO_LEFT)
				x[0]--;
			if (vector == Snake.GO_RIGHT)
				x[0]++;
			     updateAfterExchange = true;
			if (x[0] < 0)
				x[0] = 19;
			if (x[0] > 19)
				x[0] = 0;
			if (y[0] < 0)
				y[0] = 19;
			if (y[0] > 19)
				y[0] = 0;
			t1 = System.currentTimeMillis();
		}
	}

	public void drawSnake(Graphics g) {
		g.setColor(Color.red);
		for (int i = 0; i < doDai; i++) {
			g.fillRect(x[i] * 20 + 1, y[i] * 20 + 1, 18, 18);
		}
	}
}
