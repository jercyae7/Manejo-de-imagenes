/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcrecorte;

/**
 *
 * @author Alumno
 */
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Translucida extends JPanel {

    @Override
    public void paint(Graphics g) {
// En este caso tendremos que trabajar con una BufferedImage
        URL imgURL = Expositororiginal.class.getResource("lily.jpg");
        BufferedImage img = null;
        try {
            img = ImageIO.read(imgURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int w = img.getWidth(null);
        int h = img.getHeight(null);
// Necesitaremos una imagen auxiliar a la que aplicar un filtro
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics gI = bi.getGraphics();
// Sobre esta imagen dibujaremos la imagen original
        gI.drawImage(img, 0, 0, null);
        Graphics2D g2d = (Graphics2D) g;
// Establecemos la componente alpha de nuestros graficos 50%
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        /* Draw the image, applying the filter */
        g2d.drawImage(bi, null, 0, 0);
// Pintamos el resto de componentes
        super.paint(g);
    }
}