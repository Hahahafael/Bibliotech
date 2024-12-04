package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //Usuário do banco de dados postgres
    private static final String USERNAME = "postgres";
    
    //Senha do banco de dados postgres
    private static final String PASSWORD = "rodrigo";
    
    //Caminho do BD
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Bibliotech";
    
    // Conexão com o BD postgres
    public static Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return conexao;
    }
}
