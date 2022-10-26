## Java Database Connectivity example 

<br/>

### git-ignored file
- `config/conf`
    ```java
    public interface Conf {
        String DB_URL = "jdbc:oracle:thin:@server:port:sid";
        String DB_USER = "[username]"; // 자신의 데이터베이스 접속 아이디
        String DB_PASSWORD = "[password]"; // 자신의 데이터베이스 접속 암호
    }
    ```
