package BackEnd;

import java.io.Serializable;



public class cls_pieza implements Serializable{
    
    boolean esBlanca;
    int posicionX;
    int posicionY;
    boolean entablero=false;
    //boolean saltapieza;
    //boolean[][] posibles_movimientos;
    //boolean[][] posibles_comer;
    public cls_logica.piezas Pieza;
    int posicionX_Inicio;
    int posicionY_Inicio;
    int Cantidad_Movimientos;
    public String Imagen="";
    
    
    public cls_pieza(boolean seleccion_color, cls_logica.piezas pieza, int posicionX_Inicial,int posicionY_Inicial) {
        
        esBlanca = seleccion_color;
        Pieza = pieza;
        entablero = true;
        Cantidad_Movimientos = 0;
        posicionX = posicionX_Inicial;
        posicionX_Inicio = posicionX_Inicial;
        posicionY = posicionY_Inicial;
        posicionY_Inicio = posicionY_Inicial;
        AsignarImagen();
        //saltapieza = salta_pieza_inicio;
        //super();
    }
    
    public cls_pieza(cls_pieza pieza)
    {
        this.esBlanca =  pieza.esBlanca;
    this.posicionX = pieza.posicionX;
    this.posicionY = pieza.posicionY;
    this.entablero = pieza.entablero;
    //boolean saltapieza;
    //boolean[][] posibles_movimientos;
    //boolean[][] posibles_comer;
    this.Pieza = pieza.Pieza;
    this.posicionX_Inicio = pieza.posicionX_Inicio;
    this.posicionY_Inicio = pieza.posicionY_Inicio;
    this.Cantidad_Movimientos = pieza.Cantidad_Movimientos;
    this.Imagen = pieza.Imagen;
    AsignarImagen();
    }
    
    public void moverpieza(int posicionX_Mover, int posicionY_Mover , int factor){
        posicionX = posicionX_Mover;
        posicionY = posicionY_Mover;
        Cantidad_Movimientos  = Cantidad_Movimientos + 1*factor;
    }
    
    public void capturado(){
        entablero = false;
    }
    
    public void promocion_peon(cls_logica.piezas pieza_promocion) {
        Pieza = pieza_promocion;
        AsignarImagen();
    }
    
    public void AsignarImagen()
    {
        switch (Pieza)
        {
            case Peon:
            {
                Imagen = "Pawn";
            }; 
                break;
            case Caballo:
            {
                Imagen = "Knight";
            };
                break;
            case Alfil:
            {
                Imagen = "Bishop";
            };
                break;
            case Dama:
            {
                Imagen= "Queen";
            };
                break;
            case Rey:
            {
                Imagen = "King";
            };
                break;
            case Torre:
            {
                Imagen = "Rook";
            };
                break;
            
            
        }
        
        if (!esBlanca)
        {
            Imagen = Imagen+" Filled";
        }
        
    }
    
    
    
    //abstract void mover_pieza(int PosicionX_Mover, int PosicionY_Mover);
    /*  abstract void rango_moviemiento();
    abstract void rango_comer();
    
    public boolean limpiar_matriz(boolean[][] matriz_limpiar)
    {
    cls_logica objLogica = new cls_logica();
    matriz_limpiar = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
    
    for (int i=0; i<objLogica.tamano_tablero;i++)
    {
    for (int j=0; j<objLogica.tamano_tablero;j++)
    {
    matriz_limpiar[i][j]= false;
    }
    }
    
    return true;
    }
    */
    
    
    
    /*    public void rango_comer()
    {
    }*/
}
