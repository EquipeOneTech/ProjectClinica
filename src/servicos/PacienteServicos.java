
package servicos;

import dao.DaoFactory;
import dao.PacienteDao;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Paciente;


public class PacienteServicos {
    public void cadastrarPaciente(Paciente pVO) throws SQLException {
      PacienteDao pDAO = DaoFactory.getPacienteDao();
        pDAO.cadastrarPaciente(pVO);
    }//fecha método

    /**
     * @return Retornando um Array contendo todos os produtos do banco de dados.
     * @throws SQLException Lançando exceção de SQL
     */
    public ArrayList<Paciente> buscarPaciente() throws SQLException {
        PacienteDao pDao = DaoFactory.getPacienteDao();
        return pDao.buscarPaciente();
    }
}
