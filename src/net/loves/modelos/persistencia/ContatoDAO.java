/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.loves.modelos.persistencia;
import java.util.List;
import net.loves.modelos.interfaces.IcontatoCrud;
import net.loves.modelos.classes.*;
import net.loves.modelos.persistencia.ContatoDAO;


// Bibliotecas SQL
import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import net.loves.modelos.enumeration.enumSexo;
// Classe de conexao
import net.loves.modelos.ferramentas.ConexaoBD;


/**
 *
 * @author Thiago
 */
public class ContatoDAO implements IcontatoCrud {
    
    
    //Conexao com o banco
   private Connection conexao = null;
   public ContatoDAO() throws Exception{
     conexao = ConexaoBD.getConexao();
     if(conexao == null) throw new Exception("ERRO DE CONEXAO");
   }
    

    @Override
    public void incluir(Contato pessoa) throws Exception {
try {
     String sql =  "insert into contatos(nome, ddi, ddd, numero, sexo, email)"
             +     "values(?,?,?,?,?,?);";
     //Criando vinculo entre o comando SQL e o SGBD
     PreparedStatement preparedStatement = conexao.prepareStatement(sql);
     preparedStatement.setString(1, pessoa.getNome());
     preparedStatement.setInt(2, pessoa.getFone().getDdi());
     preparedStatement.setInt(3, pessoa.getFone().getDdd());
     preparedStatement.setInt(4,pessoa.getFone().getNumero());
     preparedStatement.setString(5,pessoa.getSexo().toString());
     preparedStatement.setString(6,pessoa.getEmail());
     // Mandando o comando SQL para SGBD executar
     preparedStatement.executeUpdate();
   } catch (SQLException erro) {

       throw new Exception("SQL Erro: "+ erro.getMessage());
   } catch(Exception erro){
         throw new Exception("Incluir Persistencia: " + erro);
   }

    }

    @Override
    public void alterar(Contato pessoa) throws Exception {

     String sql = "UPDATE Contatos SET nome = ?, ddi = ?, ddd = ?,"
                + " numero = ?, sexo = ?, email = ? WHERE idContato = ?";
        try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setInt(2, pessoa.getFone().getDdi());
            preparedStatement.setInt(3, pessoa.getFone().getDdd());
            preparedStatement.setInt(4, pessoa.getFone().getNumero());
            preparedStatement.setString(5, pessoa.getSexo().toString());
            preparedStatement.setString(6, pessoa.getEmail());
            preparedStatement.setInt(7, pessoa.getIdContato());

            int linhaAfetada = preparedStatement.executeUpdate();
            if (linhaAfetada == 0) {
                throw new Exception("Nenhum contato foi alterado. Verifique se o ID está correto.");
            }
        } catch (SQLException erro) {
            throw new Exception("Erro SQL ao tentar alterar o contato: " + erro.getMessage());
    }
    }

    @Override
    public void excluir(int identificador) throws Exception {
    try {
     PreparedStatement preparedStatement = null;
     preparedStatement = conexao.prepareStatement("delete from Contatos where idContato=?");
     // Parameters start with 1
     preparedStatement.setInt(1, identificador);
     preparedStatement.executeUpdate();
   } catch (SQLException e) {
       e.printStackTrace();
   }      

    }

  @Override
public Contato consultar(int identificador) throws Exception {
    Contato contato = null; // Objeto para armazenar os dados do contato
    String sql = "SELECT * FROM contatos WHERE idContato = ?"; // Consulta com filtro por identificador

    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
        preparedStatement.setInt(1, identificador); // Define o parâmetro na consulta

        try (ResultSet rs = preparedStatement.executeQuery()) { // Executa a consulta
            if (rs.next()) { // Verifica se encontrou um resultado
                contato = new Contato();
                contato.setIdContato(rs.getInt("idContato"));
                contato.setNome(rs.getString("nome"));

                // Configura os dados do telefone
                Telefone fone = new Telefone();
                fone.setDdi(rs.getInt("ddi"));
                fone.setDdd(rs.getInt("ddd"));
                fone.setNumero(rs.getInt("numero"));
                contato.setFone(fone);

                // Configura o sexo como enum
                contato.setSexo(enumSexo.valueOf(rs.getString("sexo")));

                // Configura o email
                contato.setEmail(rs.getString("email"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new Exception("Erro ao consultar o contato pelo identificador: " + e.getMessage());
    }

    return contato; // Retorna o contato encontrado ou null caso não encontre
}


   @Override
public Contato consultar(String nome) throws Exception {
    Contato contato = null; // Objeto para armazenar os dados do contato
    String sql = "SELECT * FROM contatos WHERE nome = ?"; // Consulta com filtro por nome

    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
        preparedStatement.setString(1, nome); // Define o parâmetro na consulta

        try (ResultSet rs = preparedStatement.executeQuery()) { // Executa a consulta
            if (rs.next()) { // Verifica se encontrou um resultado
                contato = new Contato();
                contato.setIdContato(rs.getInt("idContato"));
                contato.setNome(rs.getString("nome"));

                // Configura os dados do telefone
                Telefone fone = new Telefone();
                fone.setDdi(rs.getInt("ddi"));
                fone.setDdd(rs.getInt("ddd"));
                fone.setNumero(rs.getInt("numero"));
                contato.setFone(fone);

                // Configura o sexo como enum
                contato.setSexo(enumSexo.valueOf(rs.getString("sexo")));

                // Configura o email
                contato.setEmail(rs.getString("email"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new Exception("Erro ao consultar o contato pelo nome: " + e.getMessage());
    }

    return contato;
}


    @Override
    public List<Contato> ListagemDeContatos() throws Exception {
       
        List<Contato> listaDeContatos = new LinkedList<>();
   String sql = "select * from Contatos order by idContato";
   try {
     Statement statement = conexao.createStatement();
     ResultSet rs = statement.executeQuery(sql);
     while(rs.next()) {
         Contato objContato = new Contato();
         objContato.setIdContato(rs.getInt("idContato"));
         objContato.setNome(rs.getString("nome"));
         Telefone fone = new Telefone();
         fone.setDdi(rs.getInt("ddi"));
         fone.setDdd(rs.getInt("ddd"));
         fone.setNumero(rs.getInt("numero"));
         objContato.setFone(fone);
         objContato.setSexo(enumSexo.valueOf(rs.getString("sexo")));
         objContato.setEmail(rs.getString("email"));
         listaDeContatos.add(objContato);
     }
     return listaDeContatos;
   } catch (SQLException e) {
       e.printStackTrace();
   }
   return null;    
 }

 
    }
    
    
    

