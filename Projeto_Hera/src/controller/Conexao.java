/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.ConexaoArduino;

/**
 *
 * @author yuril
 */
public class Conexao {

    static SerialPort portaEscolhida;
    //ConexaoArduino conexao = new ConexaoArduino();

    private ArrayList<ConexaoArduino> portas = new ArrayList<>();

    public Conexao() {
    }

    public void descobrirPortas() {
        SerialPort[] portNames = SerialPort.getCommPorts();
        for (int i = 0; i < portNames.length; i++) {
            ConexaoArduino conexao = new ConexaoArduino(portNames[i].getDescriptivePortName(), portNames[i].getSystemPortName());
            //portas.add(portNames[i].getDescriptivePortName(), portNames[i].getSystemPortName());
            portas.add(conexao);
        }
    }

    public boolean conectar(String porta) {
        portaEscolhida = SerialPort.getCommPort(porta);
        portaEscolhida.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
        return portaEscolhida.openPort();
    }

    public void desconectar() {
        portaEscolhida.closePort();
    }

    public void enviar(String funcao, String num) {
        PrintWriter out = new PrintWriter(portaEscolhida.getOutputStream());
        out.print(funcao);
        out.print(num);
        out.flush();
    }

    public InputStream receber() {
        return portaEscolhida.getInputStream();
    }

    public String nomesPortas(int i) {
        for (int j = 0; j < portas.size(); j++) {
            if (j == i) {
                return portas.get(j).getNomePorta();
            }
        }
        return null;
    }

    public String portas(int i) {
        for (int j = 0; j < portas.size(); j++) {
            if (j == i) {
                return portas.get(j).getPorta();
            }
        }
        return null;
    }

    public int sizePortas() {
        return portas.size();
    }
}


/*

    public ArrayList<String> getPortas() {
        return portas;
    }

    public void setPortas(ArrayList<String> portas) {
        this.portas = portas;
    }

    public ArrayList<String> getNomesPortas() {
        return nomesPortas;
    }

    public void setNomesPortas(ArrayList<String> nomesPortas) {
        this.nomesPortas = nomesPortas;
    }

    public void addNomesPortas(String nomePorta) {
        portas.add(nomePorta);
    }

    public void addPortas(String porta) {
        portas.add(porta);
    }*/
