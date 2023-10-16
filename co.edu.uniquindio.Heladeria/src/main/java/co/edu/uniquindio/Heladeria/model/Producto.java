package co.edu.uniquindio.Heladeria.model;

public class Producto {
    private String sabor;
    private String tipoCono;
    private String adicionalTopping;
    private String tipoProducto;
    private int stockAlmacen;
    private double precioTotal;
    private int idProducto;

    private Heladeria ownedByHeladeria;

    public Producto(){
    }

    public Producto(String sabor, String tipoCono, String adicionalTopping, String tipoProducto, int stockAlmacen, double precioTotal, int idProducto) {
        this.sabor = sabor;
        this.tipoCono = tipoCono;
        this.adicionalTopping = adicionalTopping;
        this.tipoProducto = tipoProducto;
        this.stockAlmacen = stockAlmacen;
        this.precioTotal = precioTotal;
        this.idProducto = idProducto;
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

    public String getTipoCono() {
        return tipoCono;
    }

    public void setTipoCono(String tipoCono) {
        this.tipoCono = tipoCono;
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
        return "Producto{" +
                "sabor='" + sabor + '\'' +
                ", tipoCono='" + tipoCono + '\'' +
                ", adicionalTopping='" + adicionalTopping + '\'' +
                ", tipoProducto='" + tipoProducto + '\'' +
                ", stockAlmacen=" + stockAlmacen +
                ", precioTotal=" + precioTotal +
                ", idProducto=" + idProducto +
                '}';
    }
}
