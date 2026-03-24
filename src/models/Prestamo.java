
package models;

public class Prestamo {

    private int fechaPrestamo;
    private String categoria;
    private int limitePrestamo;


    public Prestamo(int fechaPrestamo, String categoria, int limitePrestamo){
        this.fechaPrestamo = fechaPrestamo;
        this.categoria = categoria;
        this.limitePrestamo = limitePrestamo;

    }


    public int getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(int fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getLimitePrestamo() {
        return limitePrestamo;
    }
    public void setLimitePrestamo(int limitePrestamo) {
        this.limitePrestamo = limitePrestamo;
    }


}
