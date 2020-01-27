/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author yuril
 */
public class ConexaoArduino {

    private String nomePorta;
    private String porta;

    public ConexaoArduino() {
    }

    public ConexaoArduino(String nomePorta, String porta) {
        this.nomePorta = nomePorta;
        this.porta = porta;
    }

    public String getNomePorta() {
        return nomePorta;
    }

    public void setNomePorta(String nomePorta) {
        this.nomePorta = nomePorta;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

}
