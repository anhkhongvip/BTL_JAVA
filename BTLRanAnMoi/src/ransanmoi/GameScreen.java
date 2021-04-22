package ransanmoi;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
		int a = 0;
		Thread thread;
		static int [][]bg = new int[20][20];
		static boolean isPlaying = true;
		static boolean isGameOver = false;
		static int padding = 10;
		static int WIDTH = 400;
		static int HEIGHT = 400;
		static int currentLevel = 1;
		static int pointSnake = 0;
		Snake snake;
		public GameScreen()
		{
			snake = new Snake();
			thread = new Thread(this);
			thread.start();
//			bg[5][6] = 1;
			bg[4][7] = 2;
		}
		private void drawFrame(Graphics g) {
			g.setColor(Color.ORANGE);
			g.drawRect(0, 0, WIDTH + padding * 2, HEIGHT + padding * 2);
			g.drawRect(1, 1, WIDTH + padding * 2 - 2, HEIGHT + padding * 2 - 2);
			g.drawRect(2, 2, WIDTH + padding * 2 - 4, HEIGHT + padding * 2 - 4);
		}
		public void paint(Graphics g)
		{
//			g.setColor(Color.white);
//			g.fillRect(0, 0, 500, 500);
//			g.setColor(Color.blue);
//			g.fillRect(a, 10, 100, 100);
//			g.drawString("xin chao cac ban", 10, a);
			
			paintBg(g);
			snake.drawSnake(g);
			drawFrame(g);
			if(!isPlaying)
			{
				g.setColor(Color.white);
				g.setFont(g.getFont().deriveFont(18.0f));
				g.drawString("PRESS SPACE TO GAME!", 90, 200);
			}
			if(isGameOver)
			{
				g.setColor(Color.ORANGE);
				g.setFont(g.getFont().deriveFont(25.0f));
				g.drawString("GAME OVER!", 90, 230);
			}
			g.setColor(Color.ORANGE);
			g.setFont(g.getFont().deriveFont(25.0f));
			g.drawString("LEVEL " +currentLevel, 470, 30);
			
			g.setColor(Color.ORANGE);
			g.setFont(g.getFont().deriveFont(25.0f));
			g.drawString("POINT : " +pointSnake, 450, 100);
		}	
		public void paintBg(Graphics g)
		{
			g.setColor(Color.black);
			g.fillRect(0, 0, WIDTH + padding * 2 + 300, HEIGHT + padding * 2);
			for (int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++)
				{
					g.fillRect(i * 20 + 1, j * 20 + 1, 18, 18);
					if(bg[i][j] == 2)
					{
						g.setColor(Color.yellow);
						g.fillRect(i * 20 + 1, j * 20 + 1, 18, 18);
						g.setColor(Color.black);
						
					}
				}
				
			}
		}
		
		public void run()
		{
			while(true)
			{
				if(isPlaying && !isGameOver)
				{
					snake.update();
					
				}
				repaint();
				try {
					thread.sleep(20);
				}
				catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		}
}
