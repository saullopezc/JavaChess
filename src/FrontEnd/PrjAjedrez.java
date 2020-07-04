/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package FrontEnd;
import BackEnd.cls_logica;
import BackEnd.cls_tablero;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author MGT03677
 */
public final class PrjAjedrez extends JFrame {
    
    /**
     * @param args the command line arguments
     */
    
    boton_pieza[][] botones;
    JPanel Panel;
    cls_tablero Tablero;
    JLabel Label;
    boolean TurnoesBlanca = true;
    Stack<cls_tablero> movimientos = new Stack<cls_tablero>();
    JButton btnDeshacer;
    JButton btnGuardar_Abrir;
    JTextField ctInfo;
    
    public PrjAjedrez()
    {
        Panel = new JPanel();
        Panel.setLayout(null);
        
        
        cls_logica ObjLogica = new cls_logica();
        botones = new boton_pieza[ObjLogica.tamano_tablero][ObjLogica.tamano_tablero];
        int tamano_botones=ObjLogica.tamano_botones;
        //50*X+30,50*Y+30, 50,50
        Panel.setBounds(tamano_botones*9,tamano_botones*9, 0, 0);
        
        
        
        
        for(int i=0; i < ObjLogica.tamano_tablero; i++ )
        {
            for(int j=0; j < ObjLogica.tamano_tablero; j++ )
            {
                botones[i][j] = new boton_pieza(i,j, tamano_botones);
                botones[i][j].addActionListener(this::Evento_Boton);
                Panel.add(botones[i][j]);
            }
        }
        Label = new JLabel("Prueba");
        Label.setBounds(0, 0, 300, 20);
        Label.setText("");
        Label.setVisible(true);
        Panel.add(Label);
        
        btnDeshacer = new JButton("DesHacer");
        btnDeshacer.setText("Deshacer");
        btnDeshacer.setBounds(tamano_botones/2, 0, tamano_botones*3, tamano_botones/2);
        btnDeshacer.addActionListener(this::Evento_Deshacer);
        
        Panel.add(btnDeshacer);
        
        btnGuardar_Abrir = new JButton("Guardabrir");
        btnGuardar_Abrir.setText("Guardabrir");
        btnGuardar_Abrir.setBounds(tamano_botones*3+tamano_botones/2, 0 , tamano_botones*2, tamano_botones/2);
        btnGuardar_Abrir.addActionListener(this::Evento_Guardar_Abrir);
        
        Panel.add(btnGuardar_Abrir);
        
        ctInfo = new JTextField("ctInfo");
        ctInfo.setBounds(tamano_botones*5+tamano_botones/2,0,tamano_botones*3,tamano_botones/2);
        ctInfo.setText("");
        
        Panel.add(ctInfo);
        
        
        add(Panel); 
        
        setSize(tamano_botones*9+tamano_botones/2,tamano_botones*9+tamano_botones/2);
        setBackground(Color.BLACK);
        setTitle("Ajedrez por SL");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        InicioTablero();
        pintar_rango();
        //add(botones[0][0]);
    }
    
    public void InicioTablero()
    {
        Tablero = new cls_tablero();
        cls_logica ObjLogica = new cls_logica();
        //     Tablero.posicion_piezas[4][3] = new  cls_pieza(false,piezas.Dama,4,3);
        TurnoesBlanca = true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        PrjAjedrez prjAjedrez = new PrjAjedrez();
        
        
    }
    
    private void Evento_Boton(java.awt.event.ActionEvent evt) {
        
        boton_pieza botonazo  = (boton_pieza) evt.getSource();
        //botonazo.posicionX_boton
        //Tablero.posicion_piezas[botonazo.posicionX_boton][botonazo.posicionY_boton].Pieza;
        //       if (Tablero.posicion_piezas[botonazo.posicionX_boton][botonazo.posicionY_boton]!=null)
        //       {
        cls_tablero tablero = new cls_tablero(Tablero);
        //Tablero.rango_moviemiento(botonazo.posicionX_boton, botonazo.posicionY_boton);
        boolean RespuestaMovimiento = Tablero.Movimientos(botonazo.posicionX_boton, botonazo.posicionY_boton, TurnoesBlanca);
//        System.out.println(TurnoesBlanca);
//        System.out.println(Tablero.Turno());
        
        //cls_tablero tablero = new cls_tablero(Tablero);

        if (TurnoesBlanca != RespuestaMovimiento)
        {
            TurnoesBlanca = RespuestaMovimiento;
           // tablero = new cls_tablero(Tablero);
            movimientos.push(tablero);
        }

        if (Tablero.posicion_piezas[botonazo.posicionX_boton][botonazo.posicionY_boton]!=null)
        {
            Label.setText(" X= "+botonazo.posicionX_boton+" Y="+botonazo.posicionY_boton+" Pieza "+Tablero.posicion_piezas[botonazo.posicionX_boton][botonazo.posicionY_boton].Pieza.toString() );
        }else
        {
            Label.setText(" X= "+botonazo.posicionX_boton+" Y="+botonazo.posicionY_boton);
            
        }
        
        pintar_rango();
        
    }
    
    public void pintar_rango()
    {
        
        cls_logica ObjLogica = new cls_logica();
        Tablero.ordenaImagen();
        for(int i=0; i < ObjLogica.tamano_tablero; i++ )
        {
            for(int j=0; j < ObjLogica.tamano_tablero; j++ )
            {
                //botones[i][j].setSelected(Tablero.marca_seleccion[i][j]);
                
                botones[i][j].bordes(
                        Tablero.cuadros_tablero[i][j], 
                        Tablero.marca_seleccion[i][j], 
                        Tablero.marca_comer[i][j],
                       // "../src/Queen.png"
                        Tablero.marca_imagen[i][j]
                        );
                
                /*if (Tablero.marca_seleccion[i][j])
                {
                //botones[i][j].setText("M");
                }else
                {
                if (Tablero.marca_comer[i][j])
                {
                botones[i][j].setText("C");
                }else
                {
                botones[i][j].setText("");
                }
                }*/
            }
        }
    }
    
    private void Evento_Deshacer(java.awt.event.ActionEvent evt) {
        
        if (movimientos.empty())
        {
                JOptionPane.showMessageDialog(null,"Tablero Inicial" , "Tablero Inicial", 1);
        }else
        {
        Tablero = new cls_tablero(movimientos.pop()); 
        TurnoesBlanca = Tablero.Turno();
        pintar_rango();
        }
    }
    
    public void Evento_Guardar_Abrir(java.awt.event.ActionEvent evt) {
    
        String Texto= ctInfo.getText();
        if (!"".equals(Texto))
        {
            File fichero = new File(Texto);
            
            if (fichero.exists())
            {      
                ObjectInputStream ois = null;
                try {
                    System.out.println("El fichero " + Texto + " existe");
                    ois = new ObjectInputStream(new FileInputStream(fichero));
                    try {
                        movimientos = (Stack<cls_tablero>)ois.readObject();
                        
                        Tablero = new cls_tablero(movimientos.pop()); 
                        TurnoesBlanca = Tablero.Turno();
                        pintar_rango();
                        
                JOptionPane.showMessageDialog(null,"Se ha cargado con exito" , "Se ha cargado con exito", 1);
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PrjAjedrez.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(PrjAjedrez.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        Logger.getLogger(PrjAjedrez.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            else{
                
      System.out.println("Pues va a ser que no");
                ObjectOutputStream  oos = null;
                try { 
                    oos = new ObjectOutputStream(new FileOutputStream(fichero));
                    cls_tablero tablero = new cls_tablero(Tablero);
                    movimientos.push(tablero);
                    
                    oos.writeObject(movimientos);
                    oos.close();
                    
                JOptionPane.showMessageDialog(null,"Se ha guardado con exito" , "Se ha guardado con exito", 1);
                    
                } catch (IOException ex) {
                    Logger.getLogger(PrjAjedrez.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        oos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(PrjAjedrez.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
            }
        }else
        {
            JOptionPane.showMessageDialog(null,"Campo Vacio No se guardo" , "Sin informacion", 1);
        }
        
    }
    
}
