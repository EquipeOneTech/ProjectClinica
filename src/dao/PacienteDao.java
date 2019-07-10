/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Medico;
import modelo.Paciente;
import persistencia.ConexaoBanco;

/**
 *
 * @author Alunos
 */
public class PacienteDao {
     public void cadastrarPaciente(Paciente pVO) throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConexaoBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //String que receberá instrução SQL
            String sql;

            /* Montando a instrução INSERT para inserir
             um objeto pVO no Banco MySQL */
            sql = "insert into paciente(matricula,nome_paciente,telefone)"
                    + "values( null,'" + pVO.getNome() + "','" + pVO.getTelefone() + "')";

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Paciente!");
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

 
    public ArrayList<Paciente> buscarPaciente() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from paciente";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<Paciente> prod = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                Paciente p = new Paciente();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                p.setMatricula(rs.getInt("matricula"));
                p.setNome(rs.getString("nome_paciente"));
                p.setTelefone(rs.getString("telefone"));

                /* Inserindo o objeto pVO no ArrayList */
                prod.add(p);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Paciente! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha mé
}
