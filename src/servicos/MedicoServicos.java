/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dao.DaoFactory;
import dao.MedicoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Medico;

/**
 *
 * @author Alunos
 */
public class MedicoServicos {
    public void cadastrarMedico(Medico pVO) throws SQLException {
        MedicoDao mDao = DaoFactory.getMedicoDao();
        mDao.cadastrarMedico(pVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<Medico> buscarMedico() throws SQLException {
        MedicoDao mDao = DaoFactory.getMedicoDao();
        return mDao.buscarMedico();
    }//fecha método
}
