package ransanmoi;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FrameScreen extends JFrame{
		GameScreen gameScreen;
		public FrameScreen() {

			gameScreen = new GameScreen();
			add(gameScreen);
						
			this.addKeyListener(new handler());
		}
		public static void main(String[] args) {
			FrameScreen f = new FrameScreen();
			f.setVisible(true);
			f.setSize(750, 500);
		}
		private class handler implements KeyListener{

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					GameScreen.isPlaying = !GameScreen.isPlaying;
					if(GameScreen.isGameOver)
					{
						GameScreen.isGameOver = false;
						gameScreen.currentLevel = 1;
						gameScreen.pointSnake = 0;
						gameScreen.snake.reset();
						
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					gameScreen.snake.setVector(Snake.GO_UP);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					gameScreen.snake.setVector(Snake.GO_DOWN);
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					gameScreen.snake.setVector(Snake.GO_RIGHT);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					gameScreen.snake.setVector(Snake.GO_LEFT);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
}
