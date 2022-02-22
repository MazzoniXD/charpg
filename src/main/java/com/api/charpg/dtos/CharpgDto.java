package com.api.charpg.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CharpgDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String classe;

    @NotBlank
    @Size(max = 2)
    private String nivel;

    @NotBlank
    @Size(max = 2)
    private String forca;

    @NotBlank
    @Size(max = 2)
    private String destreza;

    @NotBlank
    @Size(max = 2)
    private String constituicao;

    @NotBlank
    @Size(max = 2)
    private String inteligencia;

    @NotBlank
    @Size(max = 2)
    private String sabedoria;

    @NotBlank
    @Size(max = 2)
    private String carisma;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getClasse(){
        return classe;
    }

    public void setClasse(String classe){
        this.classe = classe;
    }

    public String getNivel(){
        return nivel;
    }

    public void setNivel(String nivel){
        this.nivel = nivel;
    }

    public String getForca(){
        return forca;
    }

    public void setForca(String forca){
        this.forca = forca;
    }

    public String getDestreza(){
        return destreza;
    }

    public void setDestreza(String destreza){
        this.destreza = destreza;
    }

    public String getConstituicao(){
        return constituicao;
    }

    public void setConstituicao(String constituicao){
        this.constituicao = constituicao;
    }

    public String getInteligencia(){
        return inteligencia;
    }

    public void setInteligencia(String inteligencia){
        this.inteligencia = inteligencia;
    }

    public String getSabedoria(){
        return sabedoria;
    }

    public void setSabedoria(String sabedoria){
        this.sabedoria = sabedoria;
    }

    public String getCarisma(){
        return carisma;
    }

    public void setCarisma(String carisma){
        this.carisma = carisma;
    }
}
