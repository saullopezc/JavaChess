package BackEnd;

import BackEnd.cls_logica.piezas;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class cls_tablero implements Serializable{
    
    public boolean[][] cuadros_tablero;
    public boolean[][] marca_seleccion;
    public boolean[][] marca_comer;
    public cls_pieza[][] posicion_piezas;
    public cls_pieza[][] posicion_piezas_capturas;
    public cls_pieza[][] posicion_piezas_simulacion;
    public cls_pieza[][] posicion_piezas_simulacion_capturas;
    public String[][] marca_imagen;
    cls_pieza pieza_seleccionada = null;
    cls_pieza pieza_seleccionada_simulacion = null;
    boolean jaque_blancas;
    boolean jaque_negras;

    public cls_tablero(cls_tablero tablerodestino){  
    
   
        cls_logica objLogica = new cls_logica();
        marca_seleccion = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        marca_comer = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        marca_imagen = new String[objLogica.tamano_tablero][objLogica.tamano_tablero];
        cuadros_tablero = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        limpiar_matriz(marca_seleccion);
        limpiar_matriz(marca_comer);
        
        posicion_piezas = new cls_pieza[objLogica.tamano_tablero][objLogica.tamano_tablero];
        posicion_piezas_capturas = new cls_pieza[objLogica.tamano_tablero][objLogica.tamano_tablero];
        
        posicion_piezas_simulacion = new cls_pieza[objLogica.tamano_tablero][objLogica.tamano_tablero];
        posicion_piezas_simulacion_capturas = new cls_pieza[objLogica.tamano_tablero][objLogica.tamano_tablero];
        
        pintartablero();
        
      //   this.cuadros_tablero = tablerodestino.cuadros_tablero.clone();
       //  this.marca_seleccion = tablerodestino.marca_seleccion.clone();
       // this.marca_comer = tablerodestino.marca_comer.clone();
        //this.posicion_piezas = tablerodestino.posicion_piezas.clone();
        // this.posicion_piezas_capturas = tablerodestino.posicion_piezas_capturas.clone();
        // this.posicion_piezas_simulacion = tablerodestino.posicion_piezas_simulacion.clone();
        
       /* if (tablerodestino.posicion_piezas_simulacion_capturas != null)
        {this.posicion_piezas_simulacion_capturas = tablerodestino.posicion_piezas_simulacion_capturas.clone();
        }else
        {this.posicion_piezas_simulacion_capturas = null;
        }
        //this.marca_imagen= tablerodestino.marca_imagen.clone();*/
        
       
        for (int i=0;i<objLogica.tamano_tablero;i++)
            for (int j=0;j<objLogica.tamano_tablero;j++)
            {
                this.cuadros_tablero[i][j] = tablerodestino.cuadros_tablero[i][j];
                //this.marca_seleccion[i][j] = tablerodestino.marca_seleccion[i][j];
                //this.marca_comer[i][j] = tablerodestino.marca_comer[i][j];
                
                if (tablerodestino.posicion_piezas != null)
                {
                if (tablerodestino.posicion_piezas[i][j] != null)
                {
                    //cls_pieza pieza2 = tablerodestino.posicion_piezas[i][j];
                    //cls_pieza pieza3 = new cls_pieza(pieza2.esBlanca,pieza2.Pieza,pieza2.posicionX,pieza2.posicionY);
                    cls_pieza pieza1 = new cls_pieza(tablerodestino.posicion_piezas[i][j]);
                    this.posicion_piezas[i][j] = null;
                    this.posicion_piezas[i][j] = pieza1;
                }else
                    this.posicion_piezas[i][j] = null;
                }else
                {
                    this.posicion_piezas = null;
                }
                
                if (tablerodestino.posicion_piezas_capturas != null) {
                if (tablerodestino.posicion_piezas_capturas[i][j] != null)
                {
                    cls_pieza pieza1 = new cls_pieza(tablerodestino.posicion_piezas_capturas[i][j]);
                    this.posicion_piezas_capturas[i][j] =  pieza1;
                }else
                    this.posicion_piezas_capturas[i][j] = null;
                }else
                {
                this.posicion_piezas_capturas = null;
                }
                
                
                if (tablerodestino.posicion_piezas_simulacion != null)
                {
                if (tablerodestino.posicion_piezas_simulacion[i][j] != null)
                {
                    cls_pieza pieza1 = new cls_pieza(tablerodestino.posicion_piezas_simulacion[i][j]);
                    this.posicion_piezas_simulacion[i][j] = pieza1;
                }else
                    this.posicion_piezas_simulacion[i][j] = null;
                }
                else
                {
                    this.posicion_piezas_simulacion = null;
                }
                
                if (this.marca_imagen != null) {
                this.marca_imagen[i][j]= tablerodestino.marca_imagen[i][j];
                }
                
                if (tablerodestino.posicion_piezas_simulacion_capturas != null)
                {
                if (tablerodestino.posicion_piezas_simulacion_capturas[i][j] != null)
                {
                    cls_pieza pieza1 = new cls_pieza(tablerodestino.posicion_piezas_simulacion_capturas[i][j]);
                    this.posicion_piezas_simulacion_capturas[i][j] = pieza1;
                }else
                    this.posicion_piezas_simulacion_capturas[i][j] = null;
                }
                else{
                    this.posicion_piezas_simulacion_capturas[i][j] = null;
                }
                
            }
        
        
        
        
        this.pieza_seleccionada= null;
        this.pieza_seleccionada_simulacion= null;
    this.jaque_blancas= tablerodestino.jaque_blancas;
    this.jaque_negras= tablerodestino.jaque_negras;
    
  }   
    
    public cls_tablero() {
        super();
        cls_logica objLogica = new cls_logica();
        marca_seleccion = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        marca_comer = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        marca_imagen = new String[objLogica.tamano_tablero][objLogica.tamano_tablero];
        cuadros_tablero = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        limpiar_matriz(marca_seleccion);
        limpiar_matriz(marca_comer);
        pintartablero();
        
        posicion_piezas = new cls_pieza[objLogica.tamano_tablero][objLogica.tamano_tablero];
        posicion_piezas_capturas = new cls_pieza[objLogica.tamano_tablero][objLogica.tamano_tablero];
        
                //Peon
        for(int i=0; i < objLogica.tamano_tablero; i++ )
        {
            //Blancas
            posicion_piezas[i][1] = new cls_pieza(true,piezas.Peon,i,1);
            
            //Negras
            posicion_piezas[i][6] = new cls_pieza(false,piezas.Peon,i,6);
            
            //  boolean seleccion_color, cls_logica.piezas pieza, int posicionX_Inicial,int posicionY_Inicial, boolean salta_pieza_inicio
        }
        
        //Damas
        posicion_piezas[3][0] = new  cls_pieza(true,piezas.Dama,3,0);
        posicion_piezas[3][7] = new  cls_pieza(false,piezas.Dama,3,7);
        
        //Torres
        posicion_piezas[0][0] = new  cls_pieza(true,piezas.Torre,0,0);
        posicion_piezas[7][0] = new  cls_pieza(true,piezas.Torre,7,0);
        
        posicion_piezas[0][7] = new  cls_pieza(false,piezas.Torre,0,7);
        posicion_piezas[7][7] = new  cls_pieza(false,piezas.Torre,7,7);
        
        //Caballos
        posicion_piezas[1][0] = new  cls_pieza(true,piezas.Caballo,1,0);
        posicion_piezas[6][0] = new  cls_pieza(true,piezas.Caballo,6,0);
        
        posicion_piezas[1][7] = new  cls_pieza(false,piezas.Caballo,1,7);
        posicion_piezas[6][7] = new  cls_pieza(false,piezas.Caballo,6,7);
        
        //Alfil
        posicion_piezas[2][0] = new  cls_pieza(true,piezas.Alfil,2,0);
        posicion_piezas[5][0] = new  cls_pieza(true,piezas.Alfil,5,0);
        
        posicion_piezas[2][7] = new  cls_pieza(false,piezas.Alfil,2,7);
        posicion_piezas[5][7] = new  cls_pieza(false,piezas.Alfil,5,7);
        
        //Reyes
        posicion_piezas[4][0] = new  cls_pieza(true,piezas.Rey,4,0);
        posicion_piezas[4][7] = new  cls_pieza(false,piezas.Rey,4,7);
        
        
        
    }
    
    public void pintartablero()
    {
        cls_logica objLogica = new cls_logica();
        //cuadros_tablero = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        double calculo = -1;
        for (int i=0;i<objLogica.tamano_tablero;i++)
            for (int j=0;j<objLogica.tamano_tablero;j++)
            {
                calculo = 0;
                // calculo = (-1) * ((-1) ^ (i+j));
                calculo = Math.pow(-1,i+j)*(-1);
                if (calculo < 1)
                {
                    cuadros_tablero[i][j] = false;
                }else
                {
                    cuadros_tablero[i][j] = true;
                }
            }
        
    }
    
    /* public int[] algebraico2matriz(String EntradaAlgebraico)
    {
    int[] posicion_salida = new int[2];
    
    switch (EntradaAlgebraico.toUpperCase().charAt(0)){
    
    case 'a':
    {
    posicion_salida[0] = 0;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    
    case 'b':
    {
    posicion_salida[0] = 1;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    case 'c':
    {
    posicion_salida[0] = 2;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    
    case 'd':
    {
    posicion_salida[0] = 3;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    
    case 'e':
    {
    posicion_salida[0] = 4;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    
    case 'f':
    {
    posicion_salida[0] = 5;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    
    case 'g':
    {
    posicion_salida[0] = 6;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    
    case 'h':
    {
    posicion_salida[0] = 7;
    posicion_salida[1] = Integer.parseInt(String.valueOf(EntradaAlgebraico.charAt(1)));
    }break;
    default: {
    posicion_salida= null;
    }
    }
    
    
    return posicion_salida;
    }
    
    
    public String matriz2algebraico(int[] EntradaMatriz)
    {
    String Salida_Matriz;
    int[] posicion_salida = new int[2];
    
    switch (posicion_salida[0]){
    
    case 0:
    {
    Salida_Matriz = "a"+posicion_salida[1];
    }break;
    case 1:
    {
    Salida_Matriz = "b"+posicion_salida[1];
    }break;
    case 2:
    {
    Salida_Matriz = "c"+posicion_salida[1];
    }break;
    case 3:
    {
    Salida_Matriz = "d"+posicion_salida[1];
    }break;
    case 4:
    {
    Salida_Matriz = "e"+posicion_salida[1];
    }break;
    case 5:
    {
    Salida_Matriz = "f"+posicion_salida[1];
    }break;
    case 6:
    {
    Salida_Matriz = "g"+posicion_salida[1];
    }break;
    case 7:
    {
    Salida_Matriz = "h"+posicion_salida[1];
    }break;
    
    default: {
    Salida_Matriz= null;
    }
    }
    
    
    return Salida_Matriz;
    }
    */
    
    public boolean limpiar_matriz(boolean[][] matriz_limpiar)
    {
        cls_logica objLogica = new cls_logica();
        // matriz_limpiar = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        
        for (int i=0; i<objLogica.tamano_tablero;i++)
        {
            for (int j=0; j<objLogica.tamano_tablero;j++)
            {
                matriz_limpiar[i][j]= false;
            }
        }
        
        return true;
    }
    
    public boolean limpiar_matriz(String[][] matriz_limpiar)
    {
        cls_logica objLogica = new cls_logica();
        // matriz_limpiar = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        
        for (int i=0; i<objLogica.tamano_tablero;i++)
        {
            for (int j=0; j<objLogica.tamano_tablero;j++)
            {
                matriz_limpiar[i][j]= "";
            }
        }
        
        return true;
    }
    
    public boolean marcar_casilla(int posicion_x, int posicion_y, cls_pieza pieza_enjuego)
    {
        cls_logica objLogica = new cls_logica();
        if (posicion_x > -1 &&  posicion_y > -1) {
            if (posicion_x < objLogica.tamano_tablero && posicion_y < objLogica.tamano_tablero)
            {
                if (posicion_piezas[posicion_x][posicion_y] == null){
                    marca_seleccion[posicion_x][posicion_y] = true;
                    return true;
                }else
                    if (posicion_piezas[posicion_x][posicion_y].esBlanca != pieza_enjuego.esBlanca)
                    {
                        if (pieza_enjuego.Pieza != piezas.Peon)
                        {
                            marca_comer[posicion_x][posicion_y] = true;
                            
                            if (posicion_piezas[posicion_x][posicion_y].Pieza == cls_logica.piezas.Rey)
                            {
                                if (pieza_enjuego.esBlanca)
                                {
                                    jaque_negras = true;
                                }
                                else{
                                    jaque_blancas = true;  }
                            }
                            
                            /*
                            
                            boolean jaque_blancas;
                            boolean jaque_negras;
                            */
                            marca_seleccion[posicion_x][posicion_y] = false;
                            return false;
                        }else
                        {
                            marca_seleccion[posicion_x][posicion_y] = false;
                            return false;
                        }
                        
                    }else
                    {
                        marca_seleccion[posicion_x][posicion_y] = false;
                        return false;
                    }
            }
        }
        return false;
    }
    
    public void rango_moviemiento(int posicionX_piezaseleccionada, int posicionY_piezaseleccionada, cls_pieza[][] piezasparam)
    {
        int posicionX = posicionX_piezaseleccionada;
        int posicionY = posicionY_piezaseleccionada;
        limpiar_matriz(marca_seleccion);
        limpiar_matriz(marca_comer);
        
        if  (piezasparam[posicionX][posicionY] != null)
        {
            switch (piezasparam[posicionX][posicionY].Pieza) {
                case Caballo:
                {
                    movimiento_caballo(piezasparam[posicionX][posicionY]);
                }
                break;
                case Torre:
                {
                    movimiento_hz_vt(piezasparam[posicionX][posicionY], false);
                }
                break;
                case Peon:
                {
                    movimiento_peon(piezasparam[posicionX][posicionY]);
                }
                break;
                case Alfil:
                {
                    movimiento_diagonal(piezasparam[posicionX][posicionY], false);
                }
                break;
                case Dama:
                {
                    movimiento_hz_vt(piezasparam[posicionX][posicionY], false);
                    movimiento_diagonal(piezasparam[posicionX][posicionY], false);
                }
                break;
                case Rey:
                {
                    movimiento_hz_vt(piezasparam[posicionX][posicionY], true);
                    movimiento_diagonal(piezasparam[posicionX][posicionY], true);
                }
                break;
                default:
                    break;
            }
            
            /*
            if (posicion_piezas[posicionX][posicionY].Pieza == piezas.Peon)
            {
            
            movimiento_peon(posicion_piezas[posicionX][posicionY]);
            }*/
        }
    }
    
    public void movimiento_diagonal(cls_pieza diagonal,boolean limite_movimientos)
    {
        int posicionX_pieza = diagonal.posicionX;
        int posicionY_pieza = diagonal.posicionY;
        boolean resultado = false;
        
        posicionX_pieza++;
        posicionY_pieza++;
        
        while (posicionX_pieza <= 7 && posicionY_pieza <= 7)
        {
            resultado = marcar_casilla(posicionX_pieza, posicionY_pieza, diagonal);
            if (limite_movimientos || !resultado )
            {
                break;
            }
            posicionX_pieza++;
            posicionY_pieza++;
        }
        
        
        posicionX_pieza = diagonal.posicionX;
        posicionY_pieza = diagonal.posicionY;
        resultado = false;
        posicionX_pieza++;
        posicionY_pieza--;
        
        while (posicionX_pieza <=7 && posicionY_pieza >= 0)
        {
            resultado = marcar_casilla(posicionX_pieza, posicionY_pieza, diagonal);
            if (limite_movimientos || !resultado)
            {
                break;
            }
            posicionX_pieza++;
            posicionY_pieza--;
        }
        
        posicionX_pieza = diagonal.posicionX;
        posicionY_pieza = diagonal.posicionY;
        resultado = false;
        
        posicionX_pieza--;
        posicionY_pieza--;
        
        while (posicionX_pieza >=0 && posicionY_pieza >= 0)
        {
            resultado = marcar_casilla(posicionX_pieza, posicionY_pieza, diagonal);
            if (limite_movimientos || !resultado)
            {
                break;
            }
            posicionX_pieza--;
            posicionY_pieza--;
        }
        
        posicionX_pieza = diagonal.posicionX;
        posicionY_pieza = diagonal.posicionY;
        resultado = false;
        
        posicionX_pieza--;
        posicionY_pieza++;
        
        while (posicionX_pieza >=0 && posicionY_pieza <= 7)
        {
            resultado = marcar_casilla(posicionX_pieza, posicionY_pieza, diagonal);
            if (limite_movimientos || !resultado)
            {
                break;
            }
            posicionX_pieza--;
            posicionY_pieza++;
        }
    }
    
    public void movimiento_hz_vt(cls_pieza hz_vt, boolean limite_movimientos)
    {
        boolean resultado = false;
        
        int posicionX_pieza = 0;
        int posicionY_pieza = 0;
        
        posicionX_pieza = hz_vt.posicionX;
        posicionY_pieza = hz_vt.posicionY;
        
        posicionX_pieza++;
        
        for(int i=posicionX_pieza; i<8 ; i++ )
        {
            resultado = marcar_casilla(i, posicionY_pieza, hz_vt);
            if (limite_movimientos || !resultado)
            {
                break;
            }
        }
        
        posicionX_pieza = hz_vt.posicionX;
        posicionY_pieza = hz_vt.posicionY;
        
        posicionY_pieza++;
        
        for(int i=posicionY_pieza; i<8 ; i++ )
        {
            resultado = marcar_casilla(posicionX_pieza, i, hz_vt);
            if (limite_movimientos || !resultado)
            {
                break;
            }
        }
        
        ////
        
        posicionX_pieza = hz_vt.posicionX;
        posicionY_pieza = hz_vt.posicionY;
        
        posicionX_pieza--;
        
        for(int i=posicionX_pieza; i>-1 ; i-- )
        {
            resultado = marcar_casilla(i, posicionY_pieza, hz_vt);
            if (limite_movimientos || !resultado)
            {
                break;
            }
        }
        
        posicionX_pieza = hz_vt.posicionX;
        posicionY_pieza = hz_vt.posicionY;
        
        posicionY_pieza--;
        
        for(int i=posicionY_pieza; i>-1 ; i-- )
        {
            resultado = marcar_casilla(posicionX_pieza, i, hz_vt);
            if (limite_movimientos || !resultado)
            {
                break;
            }
        }
        
        
        /*
        for(int i=0; i < hz_vt.posicionX; i++)
        {
        resultado = marcar_casilla(i, hz_vt.posicionY, hz_vt);
        if (limite_movimientos || !resultado)
        {
        break;
        }
        
        }
        
        resultado = false;
        for(int i=7; hz_vt.posicionX < i; i--)
        {
        resultado = marcar_casilla(i, hz_vt.posicionY, hz_vt);
        if (limite_movimientos || !resultado)
        {
        break;
        }
        }
        
        resultado = false;
        for(int i=0; i < hz_vt.posicionY; i++)
        {
        resultado = marcar_casilla(hz_vt.posicionX , i, hz_vt);
        if (limite_movimientos || !resultado)
        {
        break;
        }
        }
        
        resultado = false;
        for(int i=7; hz_vt.posicionY < i; i--)
        {
        resultado = marcar_casilla(hz_vt.posicionX, i, hz_vt);
        if (limite_movimientos || !resultado)
        {
        break;
        }
        }*/
    }
    
    
    public void movimiento_caballo(cls_pieza Caballo)
    {
        marcar_casilla(Caballo.posicionX+1, Caballo.posicionY+2, Caballo );
        marcar_casilla(Caballo.posicionX+1, Caballo.posicionY-2, Caballo );
        marcar_casilla(Caballo.posicionX-1, Caballo.posicionY+2, Caballo );
        marcar_casilla(Caballo.posicionX-1, Caballo.posicionY-2, Caballo );
        marcar_casilla(Caballo.posicionX+2, Caballo.posicionY+1, Caballo );
        marcar_casilla(Caballo.posicionX+2, Caballo.posicionY-1, Caballo );
        marcar_casilla(Caballo.posicionX-2, Caballo.posicionY+1, Caballo );
        marcar_casilla(Caballo.posicionX-2, Caballo.posicionY-1, Caballo );
        
    }
    
    
    
    public void movimiento_peon(cls_pieza Peon)
    {
        boolean resultado = false;
        if (Peon.Cantidad_Movimientos == 0)
        {
            if (!Peon.esBlanca) {
                resultado = marcar_casilla(Peon.posicionX, Peon.posicionY-1, Peon);
                if (resultado)
                {
                    marcar_casilla(Peon.posicionX, Peon.posicionY-2, Peon);
                }
            } else {
                resultado = marcar_casilla(Peon.posicionX, Peon.posicionY+1, Peon);
                if (resultado){
                    marcar_casilla(Peon.posicionX, Peon.posicionY+2, Peon);
                }
                //    Obj_Logica.dentromatriz(posibles_movimientos, posicionX, posicionY + 2, true);
                //    Obj_Logica.dentromatriz(posibles_movimientos, posicionX, posicionY + 1, true);
            }
        }else
        {
            if (!Peon.esBlanca)
            {
                marcar_casilla(Peon.posicionX, Peon.posicionY-1, Peon);
            } else
            {
                marcar_casilla(Peon.posicionX, Peon.posicionY+1, Peon);
            }
        }
        
        if (!Peon.esBlanca)
        {
            valida_comer_peon(Peon.posicionX-1,Peon.posicionY-1,Peon);
            valida_comer_peon(Peon.posicionX+1,Peon.posicionY-1,Peon);
        }else{
            valida_comer_peon(Peon.posicionX-1,Peon.posicionY+1,Peon);
            valida_comer_peon(Peon.posicionX+1,Peon.posicionY+1,Peon);
        }
        
        
    }
    
    public void valida_comer_peon(int posicionX_destino, int posicionY_destino, cls_pieza Peon)
    {
        cls_logica objLogica = new cls_logica();
        
        if (posicionX_destino > -1 &&  posicionY_destino > -1) {
            if (posicionX_destino < objLogica.tamano_tablero && posicionY_destino < objLogica.tamano_tablero)
            {
                if (posicion_piezas[posicionX_destino][posicionY_destino] != null)
                {
                    if (posicion_piezas[posicionX_destino][posicionY_destino].esBlanca != Peon.esBlanca)
                    {
                        marca_comer[posicionX_destino][posicionY_destino] = true;
                        
                        if (posicion_piezas[posicionX_destino][posicionY_destino].Pieza == cls_logica.piezas.Rey)
                            {
                                if (Peon.esBlanca)
                                {
                                    jaque_negras = true;
                                }
                                else{
                                    jaque_blancas = true;  }
                            }
                    }
                }
            }
            
        }}
    
    public boolean Movimientos(int X, int Y, boolean turnoesblanca)
    {
        
        if (posicion_piezas[X][Y] != null)
        {
            if (posicion_piezas[X][Y].esBlanca == turnoesblanca)
            {
                
                pieza_seleccionada = posicion_piezas[X][Y];
                rango_moviemiento(X, Y, posicion_piezas);
                return turnoesblanca;
                
            }else
            {
                if (pieza_seleccionada != null)
                {
                    rango_moviemiento(pieza_seleccionada.posicionX, pieza_seleccionada.posicionY, posicion_piezas);
                    if (marca_seleccion[X][Y] || marca_comer [X][Y] )
                    {
                        boolean MoverPieza = MoverPiezas(X,Y, pieza_seleccionada.posicionX, pieza_seleccionada.posicionY, posicion_piezas,pieza_seleccionada, false);
                        if (MoverPieza != turnoesblanca)
                        {
                            if (marca_comer [X][Y])
                            {
                                posicion_piezas_capturas[posicion_piezas[X][Y].posicionX_Inicio][posicion_piezas[X][Y].posicionY_Inicio] = posicion_piezas[X][Y];
                            }
                        }/*else
                        {
                            
                        }*/
                        
                        
                        /* int posicion_nuevaX = X;
                        int posicion_nuevaY = Y;
                        
                        int posicion_antesX = pieza_seleccionada.posicionX;
                        int posicion_antesY = pieza_seleccionada.posicionY;
                        
                        
                        posicion_piezas[posicion_antesX][posicion_antesY] = null;
                        posicion_piezas[posicion_nuevaX][posicion_nuevaY] = pieza_seleccionada;
                        posicion_piezas[posicion_nuevaX][posicion_nuevaY].moverpieza(posicion_nuevaX, posicion_nuevaY);
                        */
                        /*
                        posicion_piezas[X][Y]=null;
                        posicion_piezas[pieza_seleccionada.posicionX][pieza_seleccionada.posicionY] = null;
                        posicion_piezas[X][Y]=posicion_piezas[pieza_seleccionada.posicionX][pieza_seleccionada.posicionY];
                        //    posicion_piezas[X][Y]=posicion_piezas[pieza_seleccionada.posicionX][pieza_seleccionada.posicionY];
                        posicion_piezas[X][Y].moverpieza(X, Y);
                        */
                        /*pieza_seleccionada = null;
                        limpiar_matriz(marca_seleccion);
                        limpiar_matriz(marca_comer);
                        return !turnoesblanca;
                        */
                        
                        return MoverPieza;
                        
                    }else
                    {
                        LimpiarSeleccion();
                        return turnoesblanca;
                        
                    }
                    
                    
                }else
                {
                    
                    LimpiarSeleccion();
                    return turnoesblanca;
                }
            }
        }else
        {
            if (pieza_seleccionada != null)
            {
                rango_moviemiento(pieza_seleccionada.posicionX, pieza_seleccionada.posicionY, posicion_piezas);
                if (marca_seleccion[X][Y])
                {
                    /*int posicion_nuevaX = X;
                    int posicion_nuevaY = Y;
                    
                    int posicion_antesX = pieza_seleccionada.posicionX;
                    int posicion_antesY = pieza_seleccionada.posicionY;*/
                    
                    return MoverPiezas(X,Y, pieza_seleccionada.posicionX, pieza_seleccionada.posicionY, posicion_piezas,pieza_seleccionada, false);
                    
                    /*posicion_piezas[posicion_antesX][posicion_antesY] = null;
                    posicion_piezas[posicion_nuevaX][posicion_nuevaY] = pieza_seleccionada;
                    posicion_piezas[posicion_nuevaX][posicion_nuevaY].moverpieza(posicion_nuevaX, posicion_nuevaY);
                    pieza_seleccionada = null;
                    limpiar_matriz(marca_seleccion);
                    limpiar_matriz(marca_comer);
                    return !turnoesblanca;*/
                    
                }
                else
                {
                    LimpiarSeleccion();
                    return turnoesblanca;
                }
            }
            
            else
            {
                LimpiarSeleccion();
                return turnoesblanca;
            }
        }
        
    }
    
    public void LimpiarSeleccion()
    {
        pieza_seleccionada = null;
        limpiar_matriz(marca_seleccion);
        limpiar_matriz(marca_comer);
    }
    
    public int MovimientoValido(int posicion_nuevaX, int posicion_nuevaY, int posicion_antesX, int posicion_antesY, cls_pieza[][] piezasparam){

        cls_pieza[][] temp_piezasparam = null;
        temp_piezasparam = piezasparam.clone();                
        cls_pieza temp_pieza = temp_piezasparam[posicion_antesX][posicion_antesY];
        temp_piezasparam[posicion_antesX][posicion_antesY] = null;
        
        cls_pieza temp_pieza_d = temp_piezasparam[posicion_nuevaX][posicion_nuevaY];
        temp_piezasparam[posicion_nuevaX][posicion_nuevaY] = null;
        
        
        temp_pieza.moverpieza(posicion_nuevaX, posicion_nuevaY,0);
        temp_piezasparam[posicion_nuevaX][posicion_nuevaY] = temp_pieza;
        
        String Validacion = ValidaJaque(temp_pieza.esBlanca,temp_piezasparam);
        
        temp_pieza.moverpieza(posicion_antesX, posicion_antesY,0);
        temp_piezasparam[posicion_antesX][posicion_antesY] = temp_pieza;
        temp_piezasparam[posicion_nuevaX][posicion_nuevaY] = temp_pieza_d;
        
        if (Validacion == "Jaque Propio")
        {
            //JOptionPane.showMessageDialog(null,"Movimiento Invalido Rey propio en Jaque" , "Movimiento Invalido", 1);
            return 2;
        }
        
        if (Validacion == "Jaque")
        {
            return 1;
        }else
            {
            return 0;
            }
    }
    
    public boolean MoverPiezas(int posicion_nuevaX,int posicion_nuevaY, int posicion_antesX, int posicion_antesY, cls_pieza[][] piezasparam, cls_pieza piezaseleccionaparam, boolean EsSimulacion)
    {
        
        posicion_piezas_simulacion = piezasparam.clone();
        int Validacion = MovimientoValido(posicion_nuevaX,posicion_nuevaY,posicion_antesX,posicion_antesY,posicion_piezas_simulacion);
        if (Validacion != 2)
        
        {
            cls_pieza pieza_temporal = piezasparam[posicion_antesX][posicion_antesY];
            piezasparam[posicion_antesX][posicion_antesY] = null;
            pieza_temporal.moverpieza(posicion_nuevaX, posicion_nuevaY,1);
            piezasparam[posicion_nuevaX][posicion_nuevaY] = pieza_temporal;
           // piezasparam[posicion_nuevaX][posicion_nuevaY].moverpieza(posicion_nuevaX, posicion_nuevaY);

            if (!EsSimulacion)
            {
                if (posicion_nuevaY == 7)
                {
                    if (piezasparam[posicion_nuevaX][posicion_nuevaY].esBlanca)
                    {
                        if (piezasparam[posicion_nuevaX][posicion_nuevaY].Pieza == cls_logica.piezas.Peon)
                        {
                            piezasparam[posicion_nuevaX][posicion_nuevaY].promocion_peon(PromocionPeon());

                        }
                    }
                }else
                    if (posicion_nuevaY == 0)
                    {
                        if (!piezasparam[posicion_nuevaX][posicion_nuevaY].esBlanca)
                        {
                            if (piezasparam[posicion_nuevaX][posicion_nuevaY].Pieza == cls_logica.piezas.Peon)
                            {
                                piezasparam[posicion_nuevaX][posicion_nuevaY].promocion_peon(PromocionPeon());

                            }
                        }
                    }
            }
            if (Validacion  == 1)
            {
            if (Jaquemate(pieza_temporal.esBlanca))
            {
                JOptionPane.showMessageDialog(null,"Jaque Mate" , "Jaque Mate", 1);
            }else
            {
                JOptionPane.showMessageDialog(null,"Jaque" , "Jaque", 1);
            }
            }
            
            LimpiarSeleccion();
            //JOptionPane.showMessageDialog(null,"Movimiento Invalido Rey propio en Jaque" , "Movimiento Invalido", 1);
            return !piezasparam[posicion_nuevaX][posicion_nuevaY].esBlanca;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Movimiento Invalido, Jaque al rey propio" , "Jaque", 1);
            LimpiarSeleccion();
            return piezasparam[posicion_antesX][posicion_antesY].esBlanca;
        }
        
        /*if (!ValidaJaque(piezasparam[posicion_nuevaX][posicion_nuevaY].esBlanca, piezasparam))
        {
            piezasparam[posicion_antesX][posicion_antesY] = piezaseleccionaparam;
            piezasparam[posicion_antesX][posicion_antesY].moverpieza(posicion_antesX, posicion_antesY);
            piezasparam[posicion_nuevaX][posicion_nuevaY] = pieza_temporal;
            LimpiarSeleccion();
            //JOptionPane.showMessageDialog(null,"Movimiento Invalido Rey propio en Jaque" , "Movimiento Invalido", 1);
            return piezasparam[posicion_antesX][posicion_antesY].esBlanca;
            
        }/*
        
        /*
        if (piezasparam[posicion_antesX][posicion_antesY].Pieza == cls_logica.piezas.Peon)
        {
        else
        {
        
        }
        }
        */
        
        
        
        // return !piezasparam[posicion_nuevaX][posicion_nuevaY].esBlanca;
        
    }
    
    public void ordenaImagen()
    {
        cls_logica objLogica = new cls_logica();
        limpiar_matriz(marca_imagen);
        // matriz_limpiar = new boolean[objLogica.tamano_tablero][objLogica.tamano_tablero];
        for (int i=0; i<objLogica.tamano_tablero;i++)
        {
            for (int j=0; j<objLogica.tamano_tablero;j++)
            {
                
                marca_imagen[i][j]= "";
                if (posicion_piezas[i][j] != null )
                {
                    marca_imagen[i][j]= posicion_piezas[i][j].Imagen;
                }
            }
        }
        
    }
    
    public cls_logica.piezas PromocionPeon()
    {
        
        
        cls_logica objLogica = new cls_logica();
        // boolean dir = false;
        
        String option = "";
        
        String [] options = {
            cls_logica.piezas.Alfil.name(),
            cls_logica.piezas.Caballo.name(),
            cls_logica.piezas.Dama.name(),
            cls_logica.piezas.Torre.name()};
        
        int choice = -1;
        while (choice == -1){
            choice = JOptionPane.showOptionDialog(
                    null,
                    "Selecione una pieza ",
                    "Piezas",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    options,
                    options[3]);
            
        }
        
        return cls_logica.piezas.valueOf(options[choice]);
    }
    
    
public  String ValidaJaque(boolean esTurnoBlanca, cls_pieza[][] piezasparam){
        /*  boolean jaque_blancas;
        boolean jaque_negras;  */
        jaque_blancas = false;
        jaque_negras = false;
        cls_logica objLogica = new cls_logica();
        
        for (int i=0; i<objLogica.tamano_tablero;i++)
        {
            for (int j=0; j<objLogica.tamano_tablero;j++)
            {
                rango_moviemiento(i,j, piezasparam);
            }
        }
        
        if (jaque_blancas || jaque_negras)
        {
            if (esTurnoBlanca && jaque_blancas)
            {
                return "Jaque Propio";
            }else
            {
                if (!esTurnoBlanca && jaque_negras)
                {
                    return "Jaque Propio";
                }
                
               else
                {
                    //boolean Prueba = ValidaJaque(!esTurnoBlanca);
                   /* if (!Jaquemate(esTurnoBlanca))
                    {
                    JOptionPane.showMessageDialog(null,"Jaque" , "Jaque", 1);}
                    else
                    {
                    JOptionPane.showMessageDialog(null,"Jaque Mate" , "Jaque Mate", 1);
                    }*/
                    return "Jaque";
                }
            }
        }else
        {
            return "No hay Jaque";
        }
        
        //return true;
    }
   
    public boolean Jaquemate(boolean TurnoEsBlanca)
    {
      //  posicion_piezas;
        
      //  posicion_piezas_simulacion;
        posicion_piezas_simulacion = null;
        posicion_piezas_simulacion = posicion_piezas;
        int MoverPieza = 0;
        
        cls_logica objLogica = new cls_logica();
        
        for (int i=0; i<objLogica.tamano_tablero;i++)
        {
            for (int j=0; j<objLogica.tamano_tablero;j++)
            {
                if (posicion_piezas_simulacion[i][j] != null && posicion_piezas_simulacion[i][j].esBlanca != TurnoEsBlanca)
                {
                    rango_moviemiento(i,j, posicion_piezas_simulacion);
                    //pieza_seleccionada_simulacion = posicion_piezas_simulacion[i][j];
                    for (int k=0; k<objLogica.tamano_tablero;k++)
                    {
                        for (int l=0; l<objLogica.tamano_tablero;l++)
                        {
                            if (marca_seleccion[k][l] || marca_comer[k][l])
                            {
                               // System.out.println ("k: "+ k + " l: "+l+" i:"+i+" j:"+j+" Pieza:"+ posicion_piezas_simulacion[i][j].Pieza + " "+posicion_piezas_simulacion[i][j].esBlanca);
                                MoverPieza = MovimientoValido(k,l, i, j, posicion_piezas_simulacion);
                                rango_moviemiento(i,j, posicion_piezas_simulacion);
                              //  System.out.println (" "+MoverPieza);
                            if (MoverPieza != 2)
                            {
                                return false;
                            }else
                            {
                                posicion_piezas_simulacion = posicion_piezas;
                              //  pieza_seleccionada_simulacion = posicion_piezas_simulacion[i][j];
                            }
                            }
                            
                                }
        
        }
                }
            }
        }
        
        return true;
    }
    
    public boolean Turno()
    {
      cls_logica objLogica = new cls_logica();
      int cantidadMovBlanca = 0;
      int cantidadMovNegra = 0;
        
        for (int i=0; i<objLogica.tamano_tablero;i++)
        {
            for (int j=0; j<objLogica.tamano_tablero;j++)
            {
                if (posicion_piezas[i][j] != null ) {
                if (posicion_piezas[i][j].esBlanca)
                {
                    cantidadMovBlanca =cantidadMovBlanca + posicion_piezas[i][j].Cantidad_Movimientos;
                }else
                {
                    cantidadMovNegra = cantidadMovNegra + posicion_piezas[i][j].Cantidad_Movimientos;
                }
                
                }
                
                if (posicion_piezas_capturas[i][j] != null ) {
                if (posicion_piezas_capturas[i][j].esBlanca)
                {
                    cantidadMovBlanca =cantidadMovBlanca + posicion_piezas_capturas[i][j].Cantidad_Movimientos;
                }else
                {
                    cantidadMovNegra = cantidadMovNegra + posicion_piezas_capturas[i][j].Cantidad_Movimientos;
                }
                
                } 
        
            }
        }
    
        if (cantidadMovBlanca > cantidadMovNegra)
        {
            return false;
        }else
        {
            return true;
        }
        
    }
    
    
}









//public boolean esMovimientoValido()

//}
