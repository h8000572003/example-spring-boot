package org.h800570023.order.api.rest.user.notice;

import lombok.RequiredArgsConstructor;
import org.h800570023.order.mapper.LineUserDynamicSqlSupport;
import org.h800570023.order.mapper.LineUserMapper;
import org.h800570023.order.model.LineUser;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NotifyService {
    private final LineUserMapper lineUserMapper;

    @Transactional
    public   void update(NotifyRequestDTO query) {

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
