// Chapter 5 Question 27

// Luc Dowell

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
	private Color skyColor =Color.CYAN;

  public Rainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
	int xCenter;
	int yCenter;
	int largeRadius;
	int magentaRadius;
	int greenRadius;
	int skyRadius;
	
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();
    xCenter = width /2;
    yCenter = height * 3/4 ;
    
    largeRadius = width /4;
    magentaRadius = height /4 ;
    greenRadius = (int) Math.sqrt (magentaRadius * largeRadius);
    skyRadius = -(2*greenRadius-2*(int)magentaRadius-largeRadius)/2;
    
    g.setColor(Color.RED);
    g.fillArc(xCenter-largeRadius, height-largeRadius, largeRadius*2, largeRadius*2, 0, 180);
    g.setColor(Color.GREEN);
    g.fillArc(xCenter-greenRadius, height-greenRadius, greenRadius*2, greenRadius*2, 0, 180);
    g.setColor(Color.MAGENTA);
    g.fillArc(xCenter-magentaRadius, height-magentaRadius, magentaRadius*2, magentaRadius*2, 0, 180);
    g.setColor(skyColor);
    g.fillArc(xCenter-skyRadius, height-skyRadius, skyRadius*2, skyRadius*2, 0, 180);
    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    // ________________________________________________

    // Draw the sky-color semicircle:
    // ________________________________________________
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
