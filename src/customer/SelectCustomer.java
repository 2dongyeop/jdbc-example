package customer;

import conf.Conf;

import java.sql.*;

public class SelectCustomer {
    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        PreparedStatement psmtQuery = null;
        ResultSet rs = null;

        try {
            // 드라이버를 로딩한다.
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 데이터베이스의 연결을 설정한다.
            conn = DriverManager.getConnection(Conf.DB_URL, Conf.DB_USER, Conf.DB_PASSWORD);

            // 고객 정보를 검색한다
            // 전체 고객 정보 검색
            // String query = "SELECT * FROM customer";

            // [TODO 특정 고객 정보 검색 - 꼭 기억해두기]
//            String query = "SELECT * FROM customer  WHERE customer_id = 'apple'";
            String query = "SELECT * FROM customer  WHERE customer_id = ?"; //apple을 나중에 삽입!



            // Statement를 가져온다.
            psmtQuery = conn.prepareStatement(query);
            psmtQuery.setString(1, "grape"); //이때 삽입.

            // SQL문을 실행한다.
            // rs : 검색 결과 집합
            rs = psmtQuery.executeQuery();

            // 결과 집합의 내용을 출력한다.
            while (rs.next()) { // 결과 집합으로부터 각 레코드(튜블을) 가져온다
                // TODO 고객 정보의 각 속성을 Get하는 문장들 완성
                String customerId = rs.getString("customer_id");
                String customerName = rs.getString("customer_name");
                int age = rs.getInt("age");
                String grade = rs.getString("grade");
                String jobTitle = rs.getString("job_title");
                int savedMoney = rs.getInt("saved_money");

                System.out.printf("%-12s : %3s : %3d : %-6s : %-3s : %5d %n",
                        customerId, customerName, age, grade, jobTitle, savedMoney);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // ResultSet를 닫는다.
                if (rs != null) rs.close();

                // Statement를 닫는다.
                if (psmtQuery != null) psmtQuery.close();

                // Connection를 닫는다.
                if (conn != null) conn.close();
            } catch (SQLException e) {
            }
        }
    }
}
