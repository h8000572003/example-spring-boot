package org.h800570023.order.api.rest.config;

import lombok.RequiredArgsConstructor;
import org.h800570023.order.api.rest.config.query.QueryConfigReposeDTO;
import org.h800570023.order.api.rest.config.update.QuertConfigRequestDTO;
import org.h800570023.order.mapper.StoreConfigMapper;
import org.h800570023.order.model.StoreConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConfigService {
    private final StoreConfigMapper storeConfigMapper;

    public QueryConfigReposeDTO query() {
        StoreConfig storeConfig = storeConfigMapper.select(s -> s).stream().findAny().orElse(new StoreConfig());
        QueryConfigReposeDTO queryConfigReposeDTO = new QueryConfigReposeDTO();
        queryConfigReposeDTO.setTel(storeConfig.getTel());
        queryConfigReposeDTO.setUrl(storeConfig.getUrl());
        queryConfigReposeDTO.setAddress(storeConfig.getAddress());
        queryConfigReposeDTO.setExCode("O");
        queryConfigReposeDTO.setIsOpenOrder(storeConfig.getIsOpenOrder());
        return queryConfigReposeDTO;
    }

    @Transactional
    public void update(QuertConfigRequestDTO quertConfigRequestDTO) {
        storeConfigMapper.delete(d -> d);
        StoreConfig storeConfig = new StoreConfig();
        storeConfig.setAddress(quertConfigRequestDTO.getAddress());
        storeConfig.setTel(quertConfigRequestDTO.getTel());
        storeConfig.setIsOpenOrder(quertConfigRequestDTO.getIsOpenOrder());
        storeConfig.setUrl(quertConfigRequestDTO.getUrl());
        storeConfigMapper.insert(storeConfig);

    }
}
