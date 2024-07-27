package br.com.projeto_4.ctr;
import java.sql.ResultSet;
import br.com.projeto_4.dto.FornecedorDTO;
import br.com.projeto_4.dao.FornecedorDAO;
import br.com.projeto_4.dao.ConexaoDAO;

public class FornecedorCTR {
    
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    public FornecedorCTR(){
    }
    
    public String inserirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.inserirFornecedor(fornecedorDTO)){
                return "Fornecedor Cadastrado com Sucesso!!!";
            } else{
                return "Fornecedor NÃO Cadastrado!!!";
            }
        }//fecha try
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO cadastrado";
        }
    }//fecha inserirFornecedor
    
    public String alterarFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.alterarFornecedor(fornecedorDTO)){
                return "Fornecedor Alterado com Sucesso!!!";
            } else{
                return "Fornecedor NÃO Alterado!!!";
            }
        }//fecha try
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO alterado";
        }
    }//fecha alterarFornecedor
    
    public String excluirFornecedor(FornecedorDTO fornecedorDTO){
        try{
            if(fornecedorDAO.excluirFornecedor(fornecedorDTO)){
                return "Fornecedor Excluido com Sucesso!!!";
            } else{
                return "Fornecedor NÃO Excluido!!!";
            }
        }//fecha try
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Fornecedor NÃO excluido";
        }
    }//fecha excluirFornecedor
    
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao){
        ResultSet rs = null;
        
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
    }//fecha consultarFornecedor
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//fecha CloseDB
    
}//Fecha FornecedorCTR
