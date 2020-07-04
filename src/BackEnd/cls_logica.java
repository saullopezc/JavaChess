package BackEnd;

public class cls_logica {
    public enum piezas
    {
        Caballo ('C',30),
        Torre   ('T',55),
        Peon    (' ',10),
        Alfil   ('A',35),
        Dama    ('D',100),
        Rey     ('R',10000);
        
        char Abreviatura;
        int Valor = 0;
        String Imagen;
        
        piezas(char inicial, int valor)
        {
            this.Abreviatura = inicial;
            this.Valor = valor;
        }
        
        
        public void setAbreviatura(char Abreviatura) {
            this.Abreviatura = Abreviatura;
        }
        
        public char getAbreviatura() {
            return Abreviatura;
        }
        
        public void setValor(int Valor) {
            this.Valor = Valor;
        }
        
        public int getValor() {
            return Valor;
        }
    }
    
    
    public int tamano_tablero = 8;
    public int tamano_botones = 50;
    
    public void dentromatriz(boolean[][] matriz, int posicion_x, int posicion_y, boolean valor_enviado)
    {
        if (posicion_x < tamano_tablero && posicion_y < tamano_tablero)
        {
            matriz[posicion_x][posicion_y]= valor_enviado;
        }
    }
    
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
    
    public cls_logica() {
        super();
    }
}
