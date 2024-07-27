package br.com.projeto_1.dao;

import java.sql.*;
import br.com.projeto_1.dto.ClienteDTO;

public class ClienteDAO {

    //Metodo Construtor da Classe
    public ClienteDAO() {
    }

    //atributo do tipo ResultSet utilizado para realizar consultas
    private ResultSet rs = null;
    //manipular o banco de dados
    private Statement stmt = null;

    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama um método que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //instancia um statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();

            //Comando SQL que sera executado no banco de dados
            String comando = "Insert into cliente (nome_cli, logradouro_cli, numero_cli, bairro_cli,"
                    + "cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) Values ("
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + "'" + clienteDTO.getLogradouro_cli() + "', "
                    + clienteDTO.getNumero_cli() + ", "
                    + "'" + clienteDTO.getBairro_cli() + "', "
                    + "'" + clienteDTO.getCidade_cli() + "', "
                    + "'" + clienteDTO.getEstado_cli() + "', "
                    + "'" + clienteDTO.getCep_cli() + "', "
                    + "'" + clienteDTO.getCpf_cli() + "', "
                    + "'" + clienteDTO.getRg_cli() + "') ";

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());

            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }//caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecento.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }//Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }//fecha finally
    }//fecha o metodo inserirCliente

    /*
    *metodo utilizado para consultar um objeto clienteDTO no banco de dados
    *
    *@param clienteDTO, que vem da classe ClienteCTR
    *@param opcao, que vem da classe ClienteCTR
    *@return um ResultSet com os dados do cliente
     */
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        try {
            //chama o metodo que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //cria o Statement que é responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();
            //comando SQL que sera executado no banco de dados
            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "Select c.* "
                            + "from cliente c "
                            + "where nome_cli like '" + clienteDTO.getNome_cli() + "%' "
                            + "order by c.nome_cli";
                    break;
                case 2:
                    comando = "Select c.* "
                            + "from cliente c "
                            + "where c.id_cli = " + clienteDTO.getId_cli();
                    break;
                case 3:
                    comando = "Select c.id_cli, c.nome_cli "
                            + "from cliente c";
                    break;

            }

            //executa o comando SQL no banco de dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        }//fecha try
        catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }//fecha metodo consultarCliente

    public boolean alterarCliente(ClienteDTO clienteDTO) {
        try {
            //Chama um método que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //instancia um statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();

            //Comando SQL que sera executado no banco de dados
            String comando = "Update cliente set "
                    + "nome_cli = '" + clienteDTO.getNome_cli() + "', "
                    + "logradouro_cli = '" + clienteDTO.getLogradouro_cli() + "', "
                    + "numero_cli = " + clienteDTO.getNumero_cli() + ", "
                    + "bairro_cli = '" + clienteDTO.getBairro_cli() + "', "
                    + "cidade_cli = '" + clienteDTO.getCidade_cli() + "', "
                    + "estado_cli = '" + clienteDTO.getEstado_cli() + "', "
                    + "cep_cli = '" + clienteDTO.getCep_cli() + "', "
                    + "cpf_cli = '" + clienteDTO.getCpf_cli() + "', "
                    + "rg_cli = '" + clienteDTO.getRg_cli() + "' "
                    + "where id_cli = " + clienteDTO.getId_cli();
            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());

            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }//caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecento.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }//Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }//fecha finally
    }//fecha alterarCliente

    public boolean excluirCliente(ClienteDTO clienteDTO) {
        try {
            //Chama um método que esta na classe ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            //instancia um statement que sera responsavel por executar alguma coisa no banco de dados
            stmt = ConexaoDAO.con.createStatement();

            //Comando SQL que sera executado no banco de dados
            String comando = "Delete from cliente where id_cli = "
                    + clienteDTO.getId_cli();

            //Executa o comando SQL no banco de Dados
            stmt.execute(comando.toUpperCase());

            //Da um commit no banco de dados
            ConexaoDAO.con.commit();
            //fecha o statement
            stmt.close();
            return true;
        }//caso tenha algum erro no codigo acima é enviado uma mensagem no console com o que esta acontecento.
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }//Independente de dar erro ou não ele vai fechar o banco de dados.
        finally {
            //Chama o metodo da classe ConexaoDAO para fechar o banco de dados
            ConexaoDAO.CloseDB();
        }//fecha finally
    }//fecha o metodo excluirCliente

}//Fecha classe ClienteDAO
