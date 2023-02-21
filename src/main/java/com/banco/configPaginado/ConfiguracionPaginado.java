/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco.configPaginado;

/**
 *
 * @author lv1013
 */
public class ConfiguracionPaginado {

    private int numeroPagina;
    private int conteoPorPagina;

    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.conteoPorPagina = 5;
    }

    public ConfiguracionPaginado(int numeroPagina, int conteoPorPagina) {
        this.numeroPagina = numeroPagina;
        this.conteoPorPagina = conteoPorPagina;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public int getConteoPorPagina() {
        return conteoPorPagina;
    }

    public void setConteoPorPagina(int conteoPorPagina) {
        this.conteoPorPagina = conteoPorPagina;
    }

    public int getElementosASaltar() {
        return this.numeroPagina * this.conteoPorPagina;
    }

    public void avanzarPagina() {
        this.numeroPagina++;
    }

    public void retrocederPagina() {
        if (this.numeroPagina > 0) {
            this.numeroPagina--;
        }
    }

}
