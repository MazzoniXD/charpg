package com.api.charpg.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHAR_RPG")
public class Charpg implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String classe;

    @Column(nullable = false, length = 2)
    private String nivel;

    @Column(nullable = false, length = 2)
    private String forca;

    @Column(nullable = false, length = 2)
    private String destreza;

    @Column(nullable = false, length = 2)
    private String constituicao;

    @Column(nullable = false, length = 2)
    private String inteligencia;

    @Column(nullable = false, length = 2)
    private String sabedoria;

    @Column(nullable = false, length = 2)
    private String carisma;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

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