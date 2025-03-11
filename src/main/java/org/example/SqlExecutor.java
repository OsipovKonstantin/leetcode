package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.stream.IntStream;

public class SqlExecutor {
    private static final String URL = "jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1";
    private static final String FOLDER_PATH = System.getProperty("user.dir") + "/src/main/java/org/example/";

    public static void execute(String fileName) {
        try (Connection connection = DriverManager.getConnection(URL);
             Statement statement = connection.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(FOLDER_PATH + fileName))) {
            initializeTable(reader, statement);
            String query = getQuery(reader);
            executeQuery(statement, query);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeQuery(Statement statement, String query) throws SQLException {
        try (ResultSet rs = statement.executeQuery(query)) {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                StringBuilder curRow = new StringBuilder();
                IntStream.range(1, columns + 1).forEach(i -> {
                    try {
                        curRow.append(rs.getString(i));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
                System.out.print(curRow + (rs.isLast() ? "\n" : "; "));
            }
        }
    }

    private static void initializeTable(BufferedReader reader, Statement statement) throws IOException, SQLException {
        String line;
        while ((line = reader.readLine()) != null && !line.startsWith("-- init")) {
            continue;
        }
        while (!(line = reader.readLine()).startsWith("-- solution")) {
            statement.execute(line);
        }
    }

    private static String getQuery(BufferedReader reader) throws IOException {
        StringBuilder query = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            query.append(line).append(" ");
        }
        return query.toString();
    }
}
