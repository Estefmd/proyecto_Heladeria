package co.edu.uniquindio.Heladeria.model;

public class Producto {
    private String sabor;
    private String adicionalTopping;
    private String tipoProducto;
    private String nombre;
    private int stockAlmacen;
    private double precioTotal;
    private int idProducto;

    private Heladeria ownedByHeladeria;

    public Producto(){
    }

    public Producto(String sabor, String adicionalTopping, String tipoProducto, String nombre, int stockAlmacen, double precioTotal, int idProducto, Heladeria ownedByHeladeria) {
        this.sabor = sabor;
        this.adicionalTopping = adicionalTopping;
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.stockAlmacen = stockAlmacen;
        this.precioTotal = precioTotal;
        this.idProducto = idProducto;
        this.ownedByHeladeria = ownedByHeladeria;
    }

    public Heladeria getOwnedByHeladeria() {
        return ownedByHeladeria;
    }

    public void setOwnedByHeladeria(Heladeria ownedByHeladeria) {
        this.ownedByHeladeria = ownedByHeladeria;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAdicionalTopping() {
        return adicionalTopping;
    }

    public void setAdicionalTopping(String adicionalTopping) {
        this.adicionalTopping = adicionalTopping;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getStockAlmacen() {
        return stockAlmacen;
    }

    public void setStockAlmacen(int stockAlmacen) {
        this.stockAlmacen = stockAlmacen;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Producto: " + "\n" +
                "nombre: " + nombre + "\n" +
                "sabor: " + sabor + "\n" +
                "adicionalTopping: " + adicionalTopping + "\n" +
                "tipoProducto: " + tipoProducto + "\n" +
                "stockAlmacen: " + stockAlmacen + "\n" +
                "precioTotal: " + precioTotal + "\n" +
                "idProducto: " + idProducto +"\n" +
                "________";
    }
}
