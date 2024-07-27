package br.com.projeto_3.ctr;

import java.sql.ResultSet;
import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dao.ClienteDAO;
import br.com.projeto_3.dao.ConexaoDAO;

public class ClienteCTR {

    ClienteDAO clienteDAO = new ClienteDAO();

    //metodo construtor da classe
    public ClienteCTR() {
    }

    public String inserirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metoido que esta na classe DAO aguardando uma resposta (true ou false)
            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente Cadastrado com Sucesso!!!";
            } else {
                return "Cliente NÃO Cadastrado!!!";
            }
        }//fecha try
        //caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo;
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO cadastrado";
        }//fecha catch
    }//fecha InserirCliente

    /*
    *metodo utilizado para controlar o acesso ao metodo consultarCliente da classe ClienteDAO
    *
    *@param clienteDTO, que vem da classe da pagina (VIEW)
    *@param opcao, que vem da classe da pagina (VIEW)
    *@return um ResultSet com os dados do cliente
     */
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este metodo recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo metodo da classe DAO
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);

        return rs;
    }//fecha metodo consultarCliente

    /*
    *Metodo utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//fecha o metodo CloseDB

    public String alterarCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metoido que esta na classe DAO aguardando uma resposta (true ou false)
            if (clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente Alterado com Sucesso!!!";
            } else {
                return "Cliente NÃO Alterado!!!";
            }
        }//fecha try
        //caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo;
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO alterado";
        }//fecha catch
    }//fecha alterarCliente

    public String excluirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama o metoido que esta na classe DAO aguardando uma resposta (true ou false)
            if (clienteDAO.excluirCliente(clienteDTO)) {
                return "Cliente Excluido com Sucesso!!!";
            } else {
                return "Cliente NÃO Excluido!!!";
            }
        }//fecha try
        //caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo;
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente NÃO Excluido";
        }//fecha catch
    }//fecha excluirCliente

}//fecha ClienteCTR
