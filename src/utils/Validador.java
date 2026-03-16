package utils;

public class Validador {

    public void validarISBN(int cod){
        int ISBN = cod;
        if (ISBN == cod) {
            System.out.println("No se puede repetir el ISBN de un libro");
        }
    }


    public void validarAnio(int anio){
        if (anio > 2026) {
            System.out.println("No se pude terner un año mayor al actual");
        }else{
            System.out.println("Sucess");
        }
    }

    public void validarCampo(String campo){
        if (campo == "") {
            System.out.println("Ningún campo puede estar vacío.");
        }else{
            System.out.println("Sucess");
        }
    }

    
}