package org.h800570023.order.api.commons;

import lombok.RequiredArgsConstructor;
import org.h800570023.order.mapper.LineUserDynamicSqlSupport;
import org.h800570023.order.mapper.LineUserMapper;
import org.h800570023.order.model.LineUser;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LineNotify {
    private final LineUserMapper lineUserMapper;

    public void sendLineNotify(String message) {
        List<String> tokens = lineUserMapper.select(s -> s.where(LineUserDynamicSqlSupport.isNotify, SqlBuilder.isEqualTo("Y"))
        ).stream().map(LineUser::getId).toList();

        for (String token : tokens) {
            sendLineNotify(message, token);
        }
    }

    public boolean sendLineNotify(String message, String token) {
        try {
            URL url = new URL("https://notify-api.line.me/api/notify");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setDoOutput(true);

            String postData = "message=" + message;
            try (OutputStream os = conn.getOutputStream()) {
                os.write(postData.getBytes());
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            return responseCode != 200;
        } catch (Exception e) {
            return false;
        }


    }

}
