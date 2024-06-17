package org.h800570023.order.codes;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CodeService {
    private Map<CodeSets, GetValue> map = new ConcurrentHashMap<>();

    public CodeService(JdbcOperations jdbcOperations) {
        for (CodeSets codeSet : CodeSets.values()) {
            Class<? extends TextCode> codeClass = codeSet.getCodeClass();
            GetValue codeHolder;
            if (codeClass != null) {
                codeHolder = new CodeHolder(codeClass);
            } else {
                codeHolder = new CodeSqlHolder(codeSet.getSql(), jdbcOperations);
            }
            map.put(codeSet, codeHolder);


        }
    }

    public String getText(CodeSets codeSet, String code) {
        return map.get(codeSet).getText(code);
    }

    public List<? extends TextCode> getAll(CodeSets codeSets) {
        return map.get(codeSets).getAll();
    }

    public <T extends TextCode>Optional<T> getValue(CodeSets codeSets, String code) {
        return (Optional<T>) map.get(codeSets).getAll().stream().filter(textCode -> textCode.getCode().equals(code)).findFirst();
    }

    static class CodeHolder implements GetValue{
        private final Map<String, String> codeMap = new ConcurrentHashMap<>();
        private final List<? extends TextCode> textCodes;

        public CodeHolder(Class<? extends TextCode> codeClass) {
            for (TextCode code : codeClass.getEnumConstants()) {
                codeMap.put(code.getCode(), code.getText());
            }
            textCodes = Arrays.stream(codeClass.getEnumConstants()).toList();
        }

        public String getText(String code) {
            return codeMap.get(code);
        }

        public List<? extends TextCode> getAll() {
            return textCodes;
        }
    }
    interface  GetValue{
        String getText(String code);
        List<? extends TextCode> getAll();
    }

    static class CodeSqlHolder implements GetValue{
        private final Map<String, String> codeMap = new ConcurrentHashMap<>();
        private final List<? extends TextCode> textCodes;
        private final JdbcOperations jdbcOperations;

        public CodeSqlHolder(String sql, JdbcOperations jdbcOperations) {
            this.jdbcOperations = jdbcOperations;


            List<BaseTextCode> query = this.jdbcOperations.query(sql, new RowMapper<BaseTextCode>() {
                @Override
                public BaseTextCode mapRow(ResultSet rs, int rowNum) throws SQLException {
                    String key = rs.getString("key");
                    String value = rs.getString("value");
                    return new BaseTextCode(key, value);
                }
            });
            for (BaseTextCode baseTextCode : query) {
                codeMap.put(baseTextCode.code, baseTextCode.text);
            }
            textCodes = query;
        }

        public String getText(String code) {
            return codeMap.get(code);
        }

        public List<? extends TextCode> getAll() {
            return textCodes;
        }
    }

    static class BaseTextCode implements TextCode {
        private String code;
        private String text;

        public BaseTextCode(String code, String text) {
            this.code = code;
            this.text = text;
        }

        @Override
        public String getCode() {
            return code;
        }

        @Override
        public String getText() {
            return text;
        }
    }
}
