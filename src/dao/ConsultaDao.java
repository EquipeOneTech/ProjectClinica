
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Consulta;
import modelo.Medico;
import persistencia.ConexaoBanco;

public class ConsultaDao {
     public void cadastrarConsulta(Consulta pVO) throws SQLException {

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
            sql = "insert into consulta(codigo,dataConsulta,hora,crm_medico,matricula_paciente)"
                    + "values( null,'" + pVO.getData() + "','" + pVO.getHora() + "', '" + pVO.getCrm() + "','"+ pVO.getMatricula() +"')";

            //Executando o sql
            stat.execute(sql);

        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Consulta!");
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha método

 
    public ArrayList<Consulta> buscarConsultas() throws SQLException {

        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;

            //Montando o sql            
            sql = "select * from consulta";

            /* Executando o SQL  e armazenando
             o ResultSet em um objeto do tipo
             ResultSet chamado rs */
            ResultSet rs = stat.executeQuery(sql);

            /* Criando ArrayList para armazenar 
             objetos do tipo produto */
            ArrayList<Consulta> prod = new ArrayList<>();

            /* Enquanto houver uma próxima linha no 
             banco de dados o while roda */
            while (rs.next()) {
                //Criando um novo obj. ProdutoVO
                Consulta c = new Consulta();

                /* Mapeando a tabela do banco para objeto
                 chamado pVO */
                c.setCodigo(rs.getInt("codigo"));
                c.setData(rs.getString("dataConsulta"));
                c.setHora(rs.getString("Hora"));
                c.setCrm(rs.getString("crm_medico"));
                c.setMatricula(rs.getInt("matricula_paciente"));

                /* Inserindo o objeto pVO no ArrayList */
                prod.add(c);
            }//fecha while

            //Retornando o ArrayList com todos objetos
            return prod;

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Consulta! " + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }//fecha finally
    }//fecha mé
    
}
