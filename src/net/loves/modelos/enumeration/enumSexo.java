/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package net.loves.modelos.enumeration;

/**
 *
 * @author Thiago
 */
public enum enumSexo {
 
   MASCULINO("MASCULINO") ,
  FEMININO ("FEMININO");
  
  private String descricao;

    private enumSexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
  
} // 
