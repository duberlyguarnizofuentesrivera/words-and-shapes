package duberlyguarnizo.wordtoshape;

import java.awt.EventQueue;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable(){

			public void run() {
				ArrayList<String> wordList = new ArrayList<>();
				wordList.add("emotividad");
				wordList.add("franqueza");
				wordList.add("chuleza");
				wordList.add("sexyedad");
				DrawingFrame df= new DrawingFrame(wordList, 13, 500, 400, 16);
				df.setVisible(true);
			}
        	
        });
    }
}
