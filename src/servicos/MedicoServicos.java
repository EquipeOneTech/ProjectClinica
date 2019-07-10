
package servicos;

import dao.DaoFactory;
import dao.MedicoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Medico;


public class MedicoServicos {
    public void cadastrarMedico(Medico pVO) throws SQLException {
        MedicoDao mDao = DaoFactory.getMedicoDao();
        mDao.cadastrarMedico(pVO);
    }

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<Medico> buscarMedico() throws SQLException {
        MedicoDao mDao = DaoFactory.getMedicoDao();
        return mDao.buscarMedico();
    }
}
