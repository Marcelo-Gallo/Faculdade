package br.com.projeto_4.ctr;
import java.sql.ResultSet;
import br.com.projeto_4.dto.FornecedorDTO;
import br.com.projeto_4.dto.ProdutoDTO;
import br.com.projeto_4.dao.ConexaoDAO;
import br.com.projeto_4.dao.ProdutoDAO;

public class ProdutoCTR {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public ProdutoCTR(){
    }
    
    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            if(produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto Cadastrado com Sucesso!!!";
            }
            else{
                return "Produto NÃO Cadastrado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO Cadastrado";
        }
    }//fecha inserirProduto
    
    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try{
            if(produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)){
                return "Produto Alterado com Sucesso!!!";
            }
            else{
                return "Produto NÃO Alterado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO Alterado";
        }
    }//fecha alterarProduto
    
    public String excluirProduto(ProdutoDTO produtoDTO){
        try{
            if(produtoDAO.excluirProduto(produtoDTO)){
                return "Produto Excluido com Sucesso!!!";
            }
            else{
                return "Produto NÃO Excluido!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Produto NÃO Excluido";
        }
    }//fecha excluidoProduto
    
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao){
        ResultSet rs = null;
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        return rs;
    }//fecha consultarProduto
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }//fecha CloseDB
    
}//fecha Classe
