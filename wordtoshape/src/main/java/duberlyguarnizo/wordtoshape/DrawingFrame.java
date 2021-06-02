package duberlyguarnizo.wordtoshape;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class DrawingFrame extends JFrame {


	public DrawingFrame(ArrayList<String> text, int fontSize, int sizeX, int sizeY, int offset) throws HeadlessException {
		super();
		startUi(text, fontSize, sizeX, sizeY, offset);
	}

	private void startUi(ArrayList<String> text, int fontSize, int sizeX, int sizeY, int offset) {
		
		this.setTitle("Canvas for you, man!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		this.getContentPane().setPreferredSize(new Dimension(sizeX, sizeY));
		DrawingCanvas dc = new DrawingCanvas(text, fontSize, sizeX, sizeY, offset);
		this.add(dc);
		this.pack();
		//this.setVisible(true);

	}
}
