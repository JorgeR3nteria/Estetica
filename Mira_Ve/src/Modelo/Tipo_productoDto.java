
package Modelo;

/**
 *
 * @author jorge
 */
public class Tipo_productoDto 
{
    private int id_tproducto;
    private String tipo_producto;
    private String marca;

    public Tipo_productoDto() {
    }

    public Tipo_productoDto(int id_tproducto, String tipo_producto, String marca) {
        this.id_tproducto = id_tproducto;
        this.tipo_producto = tipo_producto;
        this.marca = marca;
    }

    public int getId_tproducto() {
        return id_tproducto;
    }

    public void setId_tproducto(int id_tproducto) {
        this.id_tproducto = id_tproducto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
