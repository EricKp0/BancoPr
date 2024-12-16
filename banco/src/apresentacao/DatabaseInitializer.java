package apresentacao;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
	    public static void initializeDatabase() {
	        String sql = """
	            CREATE DATABASE IF NOT EXISTS banco;
	            USE banco;
	            CREATE TABLE IF NOT EXISTS conta (
	                numero VARCHAR(20) PRIMARY KEY,
	                saldo DOUBLE NOT NULL,
	                tipo_conta VARCHAR(20) NOT NULL
	            );
	            CREATE TABLE IF NOT EXISTS conta_normal (
	                numero VARCHAR(20) PRIMARY KEY,
	                FOREIGN KEY (numero) REFERENCES conta(numero)
	            );
	            CREATE TABLE IF NOT EXISTS conta_especial (
	                numero VARCHAR(20) PRIMARY KEY,
	                limite DOUBLE NOT NULL,
	                FOREIGN KEY (numero) REFERENCES conta(numero)
	            );
	            CREATE TABLE IF NOT EXISTS conta_deb_especial (
	                numero VARCHAR(20) PRIMARY KEY,
	                FOREIGN KEY (numero) REFERENCES conta_especial(numero)
	            );
	        """;

	        try (Connection conn = new AcessoADado().connect();
	             Statement stmt = conn.createStatement()) {
	            stmt.execute(sql);
	            System.out.println("Banco de dados e tabelas criados com sucesso.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
