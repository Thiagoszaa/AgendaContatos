/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.loves.modelos.classes;
import net.loves.modelos.enumeration.enumSexo;
/**
 *
 * @author Thiago
 */
public class Contato {
    
  //Atributos
  private int idContato = 0;
  private String nome = "";
  private Telefone fone = null;
  private enumSexo sexo = null;
  private String email = "";
  //Metodos
  public Contato() {
  }
  public Contato(int idContato, String nome, Telefone fone,
                 enumSexo sexo, String email) {
    this.idContato = idContato;
    this.nome = nome;
    this.fone = fone;
    this.sexo = sexo;
    this.email = email;
  }

  public int getIdContato() {
    return idContato;
  }

  public void setIdContato(int idContato) {
    this.idContato = idContato;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Telefone getFone() {
    return fone;
  }

  public void setFone(Telefone fone) {
    this.fone = fone;
  }

  public enumSexo getSexo() {
    return sexo;
  }

  public void setSexo(enumSexo sexo) {
    this.sexo = sexo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
}

