/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.ConsultaDao;
import dao.DaoFactory;
import dao.MedicoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Consulta;
import modelo.Medico;

/**
 *
 * @author Alunos
 */
public class ConsultaServicos {
    
    public void cadastrarConsulta(Consulta pVO) throws SQLException {
        ConsultaDao cDao = DaoFactory.getConsultaDao();
        cDao.cadastrarConsulta(pVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<Consulta> buscarConsultas() throws SQLException {
        ConsultaDao cDao = DaoFactory.getConsultaDao();
        return cDao.buscarConsultas();
    }//fecha método
    
}
