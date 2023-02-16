/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configPaginado;

/**
 *
 * @author Usuario
 */
public class ConfiguracionPaginado {
    
    private int numeroPagina;
    private int elementosPorPagina;

    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 3;
    }

    public ConfiguracionPaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }
    
    public int getElementoASaltar(){
        return this.numeroPagina * this.elementosPorPagina;
    }
    
    public void avanzarPagina(){
        this.numeroPagina++;
    }
    
    public void retrocederPagina(){
        if(this.numeroPagina > 0){
            this.numeroPagina--;
        }
    }
       
}
