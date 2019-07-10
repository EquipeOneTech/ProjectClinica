
package dao;

import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;


public class DaoFactory {
      
    private static MedicoDao medicoDao = new MedicoDao();
    
    public static MedicoDao getMedicoDao(){
        return medicoDao;
      }
    
    
    private static PacienteDao pacienteDao = new PacienteDao();
    
    public static PacienteDao getPacienteDao(){
        return pacienteDao;
      }
    
    private static ConsultaDao consultaDao = new ConsultaDao();
    
    public static ConsultaDao getConsultaDao(){
        return consultaDao;
      }

       
}
