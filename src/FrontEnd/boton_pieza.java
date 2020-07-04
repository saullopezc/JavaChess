/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package FrontEnd;
import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author MGT03677
 */
public class boton_pieza extends JButton {
    
    public int posicionX_boton = 0;
    public int posicionY_boton = 0;
    public int tamano_boton = 0;
    
    public boton_pieza(int X, int Y, int tamaño)
    {
        setBounds(tamaño*X+tamaño/2,tamaño*8-tamaño*Y-tamaño/2, tamaño,tamaño);
        posicionX_boton = X;
        posicionY_boton = Y;
        tamano_boton = tamaño;
        
    }
    
    /* public boton_pieza(int i, int j) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public void bordes(boolean fondoesblanco, boolean esMovimiento, boolean esComer,String pathImagen)
    {
        if (esMovimiento)
        {
            setBorder(BorderFactory.createLineBorder(Color.GREEN));
        }
        else{
            if (esComer)
            {
                setBorder(BorderFactory.createLineBorder(Color.RED));
            }
            else{
                setBorder(BorderFactory.createLineBorder(Color.decode("#9f9f8c")));
            }
        }
        
        if (fondoesblanco)
        {
            setBackground(Color.WHITE);
        }else
        {
            setBackground(Color.decode("#9f9f8c"));
        }
        if (pathImagen != ""){
            
           // ImageIcon Icono = new ImageIcon(getClass().getResource("C:\\Users\\MGT03677\\Documents\\NetBeansProjects\\prjAjedrez\\dist\\prjAjedrez\\src\\"+pathImagen+".png")); 
        //ImageIcon Icono = new ImageIcon(getClass().getResource("../src/"+pathImagen+".png"));
        ImageIcon Icono = new ImageIcon(getClass().getResource(pathImagen+".png"));
        Icon Icono2 = new ImageIcon(Icono.getImage().getScaledInstance(tamano_boton, tamano_boton, Image.SCALE_AREA_AVERAGING));
        this.setIcon(Icono2);}else
        {
        this.setIcon(null);
        }
    }
    
}
