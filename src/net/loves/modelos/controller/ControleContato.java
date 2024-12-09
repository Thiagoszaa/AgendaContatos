/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.loves.modelos.controller;
import java.util.List;
import net.loves.modelos.classes.Contato;
import  net.loves.modelos.interfaces.IcontatoCrud;
import net.loves.modelos.persistencia.ContatoDAO;
import net.loves.modelos.visao.telaPrincipal;
/**
 *
 * @author Thiago
 */
public class ControleContato implements IcontatoCrud {
    IcontatoCrud  persistenciaContato = null;

    public ControleContato() throws Exception {
        
        try{        
            persistenciaContato = new ContatoDAO();

        } catch(Exception erro){
        throw erro;
        }
           
    }
    
    

    @Override
    public void incluir(Contato pessoa) throws Exception {

             try{
                persistenciaContato.incluir(pessoa);
                  
            } catch (Exception erro) {
                throw erro;
        }
    }

    @Override
    public void alterar(Contato pessoa) throws Exception {
               try{
                persistenciaContato.alterar(pessoa);
                  
            } catch (Exception erro) {
                throw erro;
        }
  
    }

    @Override
    public void excluir(int identificador) throws Exception {
            try{
                persistenciaContato.excluir(identificador);

             } catch (Exception erro) {
                throw erro;
        }
    }

   

    @Override
    public Contato consultar(int identificador) throws Exception {
            try{
                    persistenciaContato.consultar(identificador);

             } catch (Exception erro) {
                throw erro;
        }
      return persistenciaContato.consultar(identificador);
    }  


    @Override
    public Contato consultar(String nome) throws Exception {
           try{
                    persistenciaContato.consultar(nome);

             } catch (Exception erro) {
                throw erro; 
         }
        return persistenciaContato.consultar(nome);
        
    }

    @Override
    public List<Contato> ListagemDeContatos() throws Exception {

           try {
            persistenciaContato.ListagemDeContatos();
        } catch (Exception erro) {
            throw erro;
        }
        return persistenciaContato.ListagemDeContatos();

   
    }
  }
    


