/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towers;

import dao.EntidadeBase;
import dao.GenericoDao;
import dao.LogDao;
import java.util.Date;
import pojo.Log;

/**
 *
 * @author marce
 */
public class Towers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //LogDao logDao = new LogDao();
        Log log = new Log();
        
        log.setId(2);
        //log.setUser("OK");
        //log.setData(new Date());
        //log.setTabela("LOG");
        //log.setOperacao("insert");
        
        //logDao.salvar(log);
        
        //log = logDao.procurarId(Log.class, log.getId());
        System.out.println("Registro: \n"
                            + "id: " +log.getId()+ "\n"
                            + "User: " +log.getUser()+ "\n"
                            + "Data: " +log.getData()+ "\n"
                            + "Tabela: " +log.getTabela()+ "\n"
                            + "Operacao: " +log.getOperacao());
        //*/
        
        //logDao.excluir(log.getId());
        
        //logDao.excluir(EntidadeBase.class, log.get);
        
        
        //--------------------------------
        GenericoDao dao = new GenericoDao();
        //dao.excluir(Log.class, );
    }
    
}
