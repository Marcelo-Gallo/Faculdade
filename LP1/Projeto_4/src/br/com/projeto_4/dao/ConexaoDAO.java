package br.com.projeto_4.dao;

import java.sql.*;

/*Essa classe contem os metodos para abrir e fechar o banco de dados*/
public class ConexaoDAO {

    //Criando atrbuto do tipo Connection que servira para guardar a conexao com o banco de dados
    public static Connection con = null;

    //metodo construtor da classe
    public ConexaoDAO() {
    }

    public static void ConnectDB() {
        try {
            //Dados para conectar com o banco de dados Postgres
            String dsn = "projeto_4"; //nome do banco de dados
            String user = "postgres"; //nome do usuario utilizado para se conectar
            String senha = "postdba"; //senha do usuario acima informado

            DriverManager.registerDriver(new org.postgresql.Driver());

            String url = "jdbc:postgresql://localhost:5432/" + dsn;

            con = DriverManager.getConnection(url, user, senha);

            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("Erro ao abrir o banco");
            }
        }//fecha try
        //caso ocorra um erro ao abrir o banco de dados é emitida uma mensagem no console.
        catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados!" + e.getMessage());
        }//fecha catch
    }//fecha metodo ConnectDB()

    //Metodo que fecha a conexao com o banco de dados
    public static void CloseDB() {
        try {
            con.close();
        }//fecha try
        //Caso ocorra problemas para fechar o banco de dados é emitida uma mensagem no console
        catch (Exception e) {
            System.out.println("Problema ao fechar a base de dados! " + e.getMessage());
        }//fecha catch
    }//fecha o metodo CloseDB

}//fecha classe
