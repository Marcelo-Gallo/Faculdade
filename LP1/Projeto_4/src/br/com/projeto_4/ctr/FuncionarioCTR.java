package br.com.projeto_4.ctr;

import java.sql.ResultSet;
import br.com.projeto_4.dto.FuncionarioDTO;
import br.com.projeto_4.dao.FuncionarioDAO;
import br.com.projeto_4.dao.ConexaoDAO;

public class FuncionarioCTR {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    //metodo construtor da classe
    public FuncionarioCTR() {
    }

    public String inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metodo que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionario Cadastrado com Sucesso!!!";
            } else {
                return "Funcionario NÃO Cadastrado!!!";
            }
        }//fecha try
        //caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo;
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO cadastrado";
        }//fecha catch
    }//fecha InserirFuncionario

    /*
    *metodo utilizado para controlar o acesso ao metodo consultarfuncionario da classe funcionarioDAO
    *
    *@param funcionarioDTO, que vem da classe da pagina (VIEW)
    *@param opcao, que vem da classe da pagina (VIEW)
    *@return um ResultSet com os dados do funcionario
     */
    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        //É criado um atributo do tipo ResultSet, pois este metodo recebe o resultado de uma consulta.
        ResultSet rs = null;

        //O atributo rs recebe a consulta realizada pelo metodo da classe DAO
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);

        return rs;
    }//fecha metodo consultarFuncionario

    /*
    *Metodo utilizado para fechar o banco de dados
     */
    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }//fecha o metodo CloseDB

    public String alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metoido que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionario Alterado com Sucesso!!!";
            } else {
                return "Funcionario NÃO Alterado!!!";
            }
        }//fecha try
        //caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo;
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO alterado";
        }//fecha catch
    }//fecha alterarFuncionario

    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            //Chama o metoido que esta na classe DAO aguardando uma resposta (true ou false)
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionario Excluido com Sucesso!!!";
            } else {
                return "Funcionario NÃO Excluido!!!";
            }
        }//fecha try
        //caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecendo;
        catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario NÃO Excluido";
        }//fecha catch
    }//fecha excluirFuncionario

    public String logarFuncionario(FuncionarioDTO funcionarioDTO) {
        return funcionarioDAO.logarFuncionario(funcionarioDTO);
    }//fecha logarFuncionario

}//fecha FuncionarioCTR
