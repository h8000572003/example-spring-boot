package org.h800570023.order.api.commons;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class
CommonService {
    private final JdbcOperations jdbcOperations;

    public String getTransactionId() {
        LocalDate currentDate = LocalDate.now();

        // 定义日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 格式化日期
        String formattedDate = currentDate.format(formatter);

        String tx = "SELECT nextval('seq_no') as no;";
        List<String> no = jdbcOperations.query(tx, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return String.format("%06d", rs.getInt("no"));
            }
        });
        return formattedDate + no.get(0);
    }
}
