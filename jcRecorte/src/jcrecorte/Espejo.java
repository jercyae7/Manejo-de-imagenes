/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcrecorte;

/**
 *
 * @author Alumno
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class Espejo extends JPanel {
// Cargamos la imagen original
    private ImageIcon photo = Expositororiginal.createImage("lily.jpg");

    @Override
    public void paint(Graphics g) {
// Imagen
        Image img = photo.getImage();
        int width = photo.getIconWidth();
        int height = photo.getIconHeight();
// Rotamos la imagen
        g.drawImage(img, 0, 0, width, height, 0, height, width, 0, null);
// Pintamos el resto de componentes
        super.paint(g);
    }
}