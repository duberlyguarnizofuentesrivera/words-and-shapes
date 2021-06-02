package duberlyguarnizo.wordtoshape;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class DrawingCanvas extends JPanel {
	private static final int SPACE_HORIZONTAL = 5;
	private static final int SPACE_VERTICAL = 1;
	ArrayList<String> text;
	int textSize;
	int sizeX;
	int sizeY;
	int offset;
	Random rand = new Random();

	protected DrawingCanvas(ArrayList<String> text, int textSize, int sizeX, int sizeY, int offset) {
		super();
		this.text = text;
		this.textSize = textSize;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.offset = offset;
		this.setSize(sizeX, sizeY);
	}

	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		iterateColumns(g2d);
		drawShape(g2d);
	}

	private void drawShape(Graphics2D g2d) {
		Area background = new Area(new Rectangle(0,0,sizeX, sizeY));
		Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, sizeX, sizeY);
		background.subtract(new Area(shape));
		g2d.fill(background);
	}

	private void iterateColumns(Graphics2D g2d) {
		g2d.setFont(new Font("Calibri", Font.PLAIN, this.textSize));
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		FontMetrics fm = g2d.getFontMetrics();
		// todo: verificar que el numero correcto de correccion de tamaño es 0.7 en toda
		// pantalla
		int fontHeight = (int) (fm.getHeight() * 0.77);
		int numberOfRows = this.sizeY / (fontHeight + DrawingCanvas.SPACE_VERTICAL);
		int wordCountPosition = 0;
		int textArrayMaxIndex = text.size() - 1;
		int tamanoacumulado = 0;

		for (int j = 0; j < numberOfRows; j++) {
			System.out.println("j =" + j);
			while (tamanoacumulado < sizeX) {

				wordCountPosition = rand.nextInt(textArrayMaxIndex + 1);
				if (wordCountPosition == text.size() - 1) {
					wordCountPosition = 0;
				} else {
					wordCountPosition++;
				}
				String word = this.text.get(wordCountPosition);
				int xCoord = tamanoacumulado + DrawingCanvas.SPACE_HORIZONTAL;
				int yCoord = j * (fontHeight + DrawingCanvas.SPACE_VERTICAL);

				g2d.drawString(word, xCoord, yCoord);
				tamanoacumulado += fm.stringWidth(word) + SPACE_HORIZONTAL;
				System.out.println("y = " + yCoord);
				System.out.println("fontheigt = " + fontHeight);
			}
			tamanoacumulado = offset * (j % 2);

		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

}
