import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements Runnable{
		int a = 0;
		Thread thread;
		int [][]bg = new int[20][20];
		public GameScreen()
		{
			thread = new Thread(this);
			thread.start();
			bg[5][6] = 1;
			bg[4][7] = 2;
		}
		public void paint(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, 500, 500);
			g.setColor(Color.blue);
//			g.fillRect(a, 10, 100, 100);
//			g.drawString("xin chao cac ban", 10, a);
			paintBg(g);
			
		}	
		public void paintBg(Graphics g)
		{
			g.setColor(Color.gray);
			for (int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++)
				{
					if(bg[i][j] == 0) g.setColor(Color.gray);
					if(bg[i][j] == 1) g.setColor(Color.red);
					if(bg[i][j] == 2) g.setColor(Color.yellow);
					g.fillRect(i * 20 + 1, j * 20 + 1, 18, 18);
				}
				
			}
		}
		public void run()
		{
			while(true)
			{
				a++;
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
