package org.h800570023.order.api.rest.user.notice;

import lombok.RequiredArgsConstructor;
import org.h800570023.order.mapper.LineUserDynamicSqlSupport;
import org.h800570023.order.mapper.LineUserMapper;
import org.h800570023.order.model.LineUser;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
@RequiredArgsConstructor
public class NotifyService {
    private final LineUserMapper lineUserMapper;

    @Transactional
    public void update(NotifyRequestDTO query) {
        if (StringUtils.hasText(query.getToke())) {
            int count = lineUserMapper.update(s -> s.set(LineUserDynamicSqlSupport.isNotify).equalTo("Y")
                    .where(LineUserDynamicSqlSupport.id, SqlBuilder.isEqualTo(query.getToke())));
            if (count == 0) {
                LineUser lineUser = new LineUser();
                lineUser.setIsNotify("Y");
                lineUser.setId(query.getToke());
                lineUserMapper.insert(lineUser);
            }
        }


    }

    public static void main(String[] args) {
        getToken("zf5cP69ELCQXOURMLdUrD4");
    }

    private static String getToken(String accessCode) {

        StringBuffer response = null;
        try {
            String url = "https://notify-bot.line.me/oauth/token";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // 設定請求方法為 POST
            con.setRequestMethod("POST");

            // 設定 HTTP 標頭
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // 填入必要的資料
            String grantType = "authorization_code";
            String code = accessCode;
            String redirectUri = "https://convincing-brandy-andytsia-d4b231f3.koyeb.app";
            String clientId = "88kDIn539twSiZ4XrukC2W";
            String clientSecret = "nCGH27NX66Z4WkabMRePA8SzrrFkQMKELSSsVjnC4qu";

            // 組成要傳送的資料字串
            String urlParameters = "grant_type=" + URLEncoder.encode(grantType, "UTF-8")
                    + "&code=" + URLEncoder.encode(code, "UTF-8")
                    + "&redirect_uri=" + URLEncoder.encode(redirectUri, "UTF-8")
                    + "&client_id=" + URLEncoder.encode(clientId, "UTF-8")
                    + "&client_secret=" + URLEncoder.encode(clientSecret, "UTF-8");

            // 啟用輸出並寫入要求資料
            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(urlParameters);
                wr.flush();
            }

            // 取得回應
            int responseCode = con.getResponseCode();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 輸出回應結果
        return response.toString();
    }
}
