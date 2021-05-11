package bote;

/**
 * Almacen de información sobre la cantidad de pintura para pintar
 * @author Javier Linares Vizcaino
 * @version 29/04/2021
 */
public class Bote {
    private int contenido;//Centilitros de pintura disponibles en el bote
    private int centilitros_metro;//Centrilitros necesarios para pintar un metro cuadrado
    private String color;//Color de la pintura
    int precio;//Precio en céntimos del centilitro de pintura
    private int capacidad;//Número máximo de centilitros que caben en el bote
    
    /**
     * Constructor por defecto
     */
    public Bote(){}

    /**
     * Constructor por parámetros
     * 
     * @param contenido = La cantidad Centilitros de pintura disponible.
     * @param centilitros_metro = Centrilitros necesarios para pintar un metro 
     * cuadrado
     * @param color = Color de la pintura
     * @param precio = Precio en céntimos del centilitro de pintura
     * @param capacidad = Número máximo de centilitros que caben en el bote
     */
    public Bote(int contenido, int centilitros_metro, String color,int precio, int capacidad){
    this.contenido=contenido;
    this.centilitros_metro=centilitros_metro;
    this.color=color;
    this.precio=precio;
    this.capacidad=capacidad;
    }

    /**
     * Método que devuelve el contenido en centilitros del bote    
     * @return = Devuelve los centilitros disponible en el bote    
     */
    public int getContenido() {
        return contenido;
    }

    
    /**
     * Método que permite pintar una superficie, es necesario que haya 
     * suficiente pintura en el bote y que la superficie que se va a pintar 
     * sea positiva.
     * 
     * @param metros = La medidda de la superficie
     * @throws Exception = No se puede pintar una superficie con numeros 
     * negativos o con una superficie que sea negativa.
     */
    public void pintar(int metros) throws Exception{
        if(metros*this.centilitros_metro>this.contenido)
            throw new Exception("No hay pintura suficiente para pintar esa superficie");
        if(metros<=0)
            throw new Exception("No tiene sentido pintar una superficie que no sea positiva");
        this.contenido=this.contenido - (metros*this.centilitros_metro);
    }
    
    /**
     * Método que permite aumentar el contenido del bote de pintura, es necesario que la cantidad
     * que se quiere añadir y el dinero con que se va a pagar sean positvos, además el dinero debe 
     * ser suficiente para pagar la cantidad que se va a añadir.
     * 
     * @param centilitros La cantidad de litros de pintura con la que sequiere 
     * rellenar
     * @param centimos = Dinero que tenemos para pagar la pintura
     * @throws Exception = Cuando la cantidad de pintura en cetilitros es 
     * negativa no se podra rrellenar o si la cantidad de centimos es negativa
     * no se podra rellenar el bote.No se puede superar la cantidad de pintura del bote 
     * o no se tiene suficiente dinero para comprara la pintura.
     */
    public void rellenar(int centilitros, int centimos) throws Exception{
        if (centimos<=0){
            throw new Exception("Se necesita una cantidad positiva de dinero");
        }
        if (centilitros<=0){
            throw new Exception("Los centilitros deben ser positivos");
        }
    
         if (this.contenido + centilitros > capacidad) {
            throw new Exception("No se puede superar la capacidad del bote");
        }
        if (centimos < centilitros * precio){
            throw new Exception("No tiene dinero suficiente");
         }
        this.contenido=this.contenido+centilitros;
    }
       
}
