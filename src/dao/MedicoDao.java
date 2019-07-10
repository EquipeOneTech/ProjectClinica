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
import persistencia.ConexaoBanco;

/**
 *
 * @author Alunos
 */
public class MedicoDao {
 public void cadastrarMedico(Medico med) throws SQLException {

        //Buscando uma conexão com o Banco de Dados
        Connection con = ConexaoBanco.getConexao();
        /*Criando obj. capaz de executar instruções
         SQL no banco de dados*/
        Statement stat = con.createStatement();

        try {
            //String que receberá instrução SQL
            String sql;

            /* Montando a instrução INSERT para inserir
             um objeto medico no Banco MySQL */
            sql = "insert into medico(crm,nome,especialidade)"
                    + "values( '" + med.getCrm() + "','" + med.getNome() + "', '" + med.getEspecialidade() + "')";

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir medico!");
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

 
    public ArrayList<Medico> buscarMedico() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from medico";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<Medico> prod = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                Medico m = new Medico();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                m.setCrm(rs.getString("crm"));
                m.setNome(rs.getString("nome"));
                m.setEspecialidade(rs.getString("especialidade"));

                /* Inserindo o objeto med no ArrayList */
                prod.add(m);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Medico! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha mé
}