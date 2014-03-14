/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jcrecorte;

/**
 *
 * @author Alumno
 */
import jcrecorte.Expositororiginal;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Original extends javax.swing.JPanel {
// Cargamos la imagen original 
    public ImageIcon photo;
       
    String URLIMA;
     public Original(GetSetImagen obj){
    
    try{
        URLIMA=obj.getImagen();
    System.out.print("Original..."+URLIMA);
                if(URLIMA==null){
                    JOptionPane.showMessageDialog(null, "Falta Cargar Imagen");
                }
                else{
                photo = Expositororiginal.createImage(""+URLIMA); 
                }
                JOptionPane.showMessageDialog(null, photo);
     }
    catch(Exception e)
    {
     
     }
    }
    
    public Original(){
    photo = Expositororiginal.createImage("lily.jpg"); 
    
    }
    
      

    @Override
    public void paint(Graphics g) {
        
         try{
                g.drawImage(photo.getImage(), 0, 0, null);
// Pintamos el resto de componentes
        super.paint(g);
     }catch(Exception e){
     
     }
    }
}