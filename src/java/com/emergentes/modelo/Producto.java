
package com.emergentes.modelo;


public class Producto {
    private int id;
    private String descripcion;
    private int stock;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String toString(){
     return "Producto{"+ "id="+id +", descripcion="+ descripcion + ",stock="+ stock + "}";
            
    }
}
