package jcrecorte;
import java.awt.*;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.FileChooserUI;

public class jcPanelRecorte extends JPanel implements MouseMotionListener,MouseListener   {

    Image img;
    BufferedImage Imagmemoria;
    BufferedImage imgrecortada;

    Graphics2D g2D;

    float x=0;
    float y=0;
    float ancho=0;
    float alto=0;
    private Object FileChooser;

    public jcPanelRecorte(BufferedImage f){
        this.img = f;
        this.setSize(f.getWidth(),f.getHeight());
        this.setVisible(true);
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      if(img!=null){
        Imagmemoria = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        g2D = Imagmemoria.createGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawImage(img,0, 0, img.getWidth(this), img.getHeight(this), this);
        g2D.setStroke(new BasicStroke(2f));
        g2D.setColor(Color.WHITE);
        Rectangle2D r2 = new Rectangle2D.Float( x, y, ancho, alto );
        g2D.draw(r2);
        g2.drawImage(Imagmemoria, 0, 0, this);
      }
    }

    public void guardar_imagen(String nombrearchivo){
        
   
imgrecortada = ((BufferedImage) img).getSubimage((int)x,(int) y,(int) ancho,(int) alto) ;
 try {          
 ImageIO.write(imgrecortada, "jpg", new File(nombrearchivo));
JOptionPane.showMessageDialog(null, "Se ha guardado Correctamente la imagen recortada");
} catch (IOException e) {
     JOptionPane.showMessageDialog(null, "Error, Trate nuevamente");

  }    
        
   }

    public void mouseDragged(MouseEvent e) {
        ancho = e.getX()-x;
        alto = e.getY()-y;

        if(ancho<0) ancho=0;
        if(alto<0) alto=0;
        if(x > this.getWidth()) x = this.getWidth() - ancho ;
        if(y > this.getHeight()) y = this.getHeight() - alto ;        

        this.repaint();
    }
    
    
    

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

}