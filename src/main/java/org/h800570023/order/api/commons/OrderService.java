package org.h800570023.order.api.commons;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.h800570023.order.api.rest.custom.craete.CreateOrderReposeDTO;
import org.h800570023.order.api.rest.custom.craete.CreateOrderRequestDTO;
import org.h800570023.order.api.rest.custom.query.QuertCustomTickeRequestDTO;
import org.h800570023.order.api.rest.user.ticket.apply.ApplyStatusUserRequestDTO;
import org.h800570023.order.api.rest.user.ticket.apply.ApplyUserTickeReposeDTO;
import org.h800570023.order.api.rest.user.ticket.apply.ApplyUserTickeRequestDTO;
import org.h800570023.order.api.rest.user.ticket.query.QuertUserTickeReposeDTO;
import org.h800570023.order.api.rest.user.ticket.query.QuertUserTickeRequestDTO;
import org.h800570023.order.codes.*;
import org.h800570023.order.mapper.TicketDynamicSqlSupport;
import org.h800570023.order.mapper.TicketMapper;
import org.h800570023.order.model.Ticket;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.where.WhereDSL;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final TicketMapper ticketMapper;
    private final CommonService commonService;
    private final CodeService codeService;
    private final LineNotify lineNotify;

    public CreateOrderReposeDTO createOrder(CreateOrderRequestDTO createOrderRequestDTO) {
        String transactionId = commonService.getTransactionId();

        Ticket ticket = new Ticket();
        ticket.setDeposit(0);
        ticket.setPickupDate(createOrderRequestDTO.getPickupTime());
        ticket.setPickup(createOrderRequestDTO.getPickupCode());
        ticket.setCloseDate(null);
        ticket.setItemACount(0);
        ticket.setItemBCount(0);
        ticket.setItemCCount(0);
        ticket.setItemDCount(0);
        ticket.setItemECount(0);
        ticket.setItemFCount(0);
        ticket.setTemperature(TemperatureCodes.N.name());
        ticket.setApplyMemo("");
        ticket.setTransactionId(transactionId);
        ticket.setOrderName(createOrderRequestDTO.getName());
        ticket.setOrderTel(createOrderRequestDTO.getPhone());
        ticket.setCreateDate(new Date());
        ticket.setStatus(TicketStatus.A.name());
        ticket.setTemperature(TemperatureCodes.N.name());
        int total = getTotal(createOrderRequestDTO, ticket);
        if (total == 0) {
            throw new ApBusinessException("至少購買一項");
        }
        ticket.setTotal(total);
        ticket.setCustomerMemo(createOrderRequestDTO.getMemo());
        ticket.setEmail(createOrderRequestDTO.getEmail());
        ticketMapper.insert(ticket);

        CreateOrderReposeDTO createOrderReposeDTO = new CreateOrderReposeDTO();
        createOrderReposeDTO.setTransactionId(transactionId);


        String items = createOrderRequestDTO.getItems().stream().filter(i -> i.getQuantity() > 0).map(i -> {
            return ItemCodes.valueOf(i.getTitle()).getText()
                    + ":" + i.getQuantity() + "\n";
        }).collect(Collectors.joining());

        lineNotify.sendLineNotify("收到新的訂單:訂單號碼" + transactionId + "\n姓名:" + createOrderRequestDTO.getName()
                + "\n電話:" + createOrderRequestDTO.getPhone() + "\n品項：\n" + items);
        return createOrderReposeDTO;
    }

    private static int getTotal(CreateOrderRequestDTO createOrderRequestDTO, Ticket ticket) {
        int total = 0;
        List<CreateOrderRequestDTO.CreateOrderRequestItemDTO> items = createOrderRequestDTO.getItems();
        for (CreateOrderRequestDTO.CreateOrderRequestItemDTO item : items) {
            total += getFoodItemTotal(item, ticket);
//            item.getTitle();
        }
        return total;
    }

    private static int getFoodItemTotal(CreateOrderRequestDTO.CreateOrderRequestItemDTO item, Ticket ticket) {
        int total = 0;
        total += getFoodItemTotal(item, ticket::setItemACount, ItemCodes.A);
        total += getFoodItemTotal(item, ticket::setItemBCount, ItemCodes.B);
        total += getFoodItemTotal(item, ticket::setItemCCount, ItemCodes.C);
        total += getFoodItemTotal(item, ticket::setItemDCount, ItemCodes.D);
        total += getFoodItemTotal(item, ticket::setItemECount, ItemCodes.E);
        total += getFoodItemTotal(item, ticket::setItemFCount, ItemCodes.F);
        return total;
    }

    private static int getFoodItemTotal(CreateOrderRequestDTO.CreateOrderRequestItemDTO item,
                                        Consumer<Integer> consumer, ItemCodes foodCodes) {
        int total = 0;
        if (item.getTitle().equals(foodCodes.getCode())) {
            consumer.accept(item.getQuantity());
            total += item.getQuantity() * foodCodes.getPrice();
        }

        return total;
    }

    public QuertUserTickeReposeDTO query(QuertUserTickeRequestDTO query) {
        List<Ticket> select = getTickets(query);
        QuertUserTickeReposeDTO result = mapByTicket(select);
        return result;
    }

    private QuertUserTickeReposeDTO mapByTicket(List<Ticket> select) {
        QuertUserTickeReposeDTO result = new QuertUserTickeReposeDTO();


        List<QuertUserTickeReposeDTO.CreateOrderRequestTicketDTO> list = select.stream().map(i -> {
            QuertUserTickeReposeDTO.CreateOrderRequestTicketDTO createOrderRequestTicketDTO = new QuertUserTickeReposeDTO.CreateOrderRequestTicketDTO();
            createOrderRequestTicketDTO.setTransactionId(i.getTransactionId());
            createOrderRequestTicketDTO.setName(i.getOrderName());
            createOrderRequestTicketDTO.setPhone(i.getOrderTel());
            createOrderRequestTicketDTO.setPickupTime(i.getPickupDate());
            createOrderRequestTicketDTO.setStatus(i.getStatus());
            createOrderRequestTicketDTO.setTemperature(i.getTemperature());
            createOrderRequestTicketDTO.setTotal(i.getTotal());
            createOrderRequestTicketDTO.setPickupCode(i.getPickup());
            createOrderRequestTicketDTO.setEmail(i.getEmail());
            createOrderRequestTicketDTO.setMemo(i.getCustomerMemo());
            createOrderRequestTicketDTO.setStoreMemo(i.getApplyMemo());
            createOrderRequestTicketDTO.setDeposit(i.getDeposit());
            createOrderRequestTicketDTO.setChangeLog(i.getChangeLog());
            List<QuertUserTickeReposeDTO.CreateOrderRequestItemDTO> items = new ArrayList<>();
            add(items, i.getItemACount(), ItemCodes.A.getCode());
            add(items, i.getItemBCount(), ItemCodes.B.getCode());
            add(items, i.getItemCCount(), ItemCodes.C.getCode());
            add(items, i.getItemDCount(), ItemCodes.D.getCode());
            add(items, i.getItemECount(), ItemCodes.E.getCode());
            add(items, i.getItemFCount(), ItemCodes.F.getCode());

            createOrderRequestTicketDTO.setItems(items);

            return createOrderRequestTicketDTO;
        }).toList();
        result.setTickets(list);
        return result;
    }

    private List<Ticket> getTickets(QuertUserTickeRequestDTO query) {
        final WhereDSL.StandaloneWhereFinisher where = SqlBuilder.where();
        boolean hasWhere = false;
        if (StringUtils.isNotBlank(query.getTransactionId())) {
            where.and(TicketDynamicSqlSupport.transactionId, SqlBuilder.isLike("%" + query.getTransactionId()));
            hasWhere = true;
        }
        if (StringUtils.isNotBlank(query.getName())) {
            where.and(TicketDynamicSqlSupport.orderName, SqlBuilder.isLike(query.getName() + "%"));
            hasWhere = true;
        }
        if (StringUtils.isNotBlank(query.getStatus())) {
            where.and(TicketDynamicSqlSupport.status, SqlBuilder.isEqualTo(query.getStatus()));
            hasWhere = true;
        }
        if (StringUtils.isNotBlank(query.getPhone())) {
            where.and(TicketDynamicSqlSupport.orderTel, SqlBuilder.isLike(query.getPhone() + "%"));
            hasWhere = true;
        }
        if (StringUtils.isNotBlank(query.getPickupTime())) {
            where.and(TicketDynamicSqlSupport.pickupDate, SqlBuilder.isEqualTo(query.getPickupTime()));
            hasWhere = true;
        }
        if (StringUtils.isNotBlank(query.getPickupCode())) {
            where.and(TicketDynamicSqlSupport.pickup, SqlBuilder.isLike(query.getPickupCode()));
            hasWhere = true;
        }
        if (StringUtils.isNotBlank(query.getTemperature())) {
            where.and(TicketDynamicSqlSupport.temperature, SqlBuilder.isEqualTo(query.getTemperature()));
            hasWhere = true;
        }
        List<Ticket> select;

        if (hasWhere) {
            select = ticketMapper.select(s ->
                    s.applyWhere(where.toWhereApplier())
                            .orderBy(TicketDynamicSqlSupport.pickupDate, TicketDynamicSqlSupport.pickup, TicketDynamicSqlSupport.status));
        } else {
            select = ticketMapper.select(s ->
                    s
                            .orderBy(TicketDynamicSqlSupport.pickupDate, TicketDynamicSqlSupport.pickup, TicketDynamicSqlSupport.status));
        }
        return select;
    }

    private void add(List<QuertUserTickeReposeDTO.CreateOrderRequestItemDTO> items, Integer itemACount, String code) {
        Optional<ItemCodes> value = codeService.getValue(CodeSets.ITEM_CODES, code);
        QuertUserTickeReposeDTO.CreateOrderRequestItemDTO itemDTO = new QuertUserTickeReposeDTO.CreateOrderRequestItemDTO();
        itemDTO.setTitle(value.get().getText());
        itemDTO.setCode(code);
        itemDTO.setPrice(value.get().getPrice());
        itemDTO.setQuantity(itemACount);
        items.add(itemDTO);
    }


    @Transactional
    public void apply(ApplyStatusUserRequestDTO query) {
        UpdateDSL<UpdateModel> update = SqlBuilder.update(TicketDynamicSqlSupport.ticket);
        update.set(TicketDynamicSqlSupport.status).equalTo(TicketStatus.valueOf(query.getNewStatus()).getCode())
                .set(TicketDynamicSqlSupport.applyMemo).equalTo(query.getStoreMemo())
                .set(TicketDynamicSqlSupport.changeLog).equalTo(getNewLog("狀態變更:" + codeService.getText(CodeSets.TICKET_STATUS, query.getStatus()) + "更正為 " + codeService.getText(CodeSets.TICKET_STATUS, query.getNewStatus()), query.getTransactionId()))
                .set(TicketDynamicSqlSupport.updateTime).equalTo(new Date());
        if (EnumSet.of(TicketStatus.D, TicketStatus.E).contains(TicketStatus.valueOf(query.getNewStatus()))) {
            update.set(TicketDynamicSqlSupport.closeDate).equalTo(new Date());
        }


        update.where(TicketDynamicSqlSupport.transactionId, SqlBuilder.isEqualTo(query.getTransactionId()))
                .and(TicketDynamicSqlSupport.status, SqlBuilder.isEqualTo(query.getStatus()));
        UpdateStatementProvider updateStatement = update.build().render(RenderingStrategies.MYBATIS3);
        ticketMapper.update(updateStatement);


    }

    private String getNewLog(String newChange, String transactionId) {
        Optional<Ticket> ticket = ticketMapper.selectOne(s -> s.where(TicketDynamicSqlSupport.transactionId, SqlBuilder.isEqualTo(transactionId)));
        StringBuffer changeLog = new StringBuffer();
        if (ticket.isPresent()) {
            String changeLog1 = ticket.get().getChangeLog();
            if (StringUtils.isNotBlank(changeLog1)) {
                changeLog.append(changeLog1 + "\n");
            }

        }
        changeLog.append(getNow() + "." + newChange);
        return changeLog.toString();
    }

    private ApplyUserTickeReposeDTO updateTicket(ApplyUserTickeRequestDTO query, String newChagne) {
        Integer total = query.getItems().stream().map(i -> {
            return i.getQuantity() * i.getPrice();
        }).reduce(0, Integer::sum);
        final String newLog = getNewLog(newChagne, query.getTransactionId());
        ticketMapper.update(u -> u
                .set(TicketDynamicSqlSupport.status).equalTo(TicketStatus.C.getCode())
                .set(TicketDynamicSqlSupport.total).equalTo(total)
                .set(TicketDynamicSqlSupport.orderName).equalTo(query.getName())
                .set(TicketDynamicSqlSupport.orderTel).equalTo(query.getPhone())
                .set(TicketDynamicSqlSupport.email).equalTo(query.getEmail())
                .set(TicketDynamicSqlSupport.pickupDate).equalTo(query.getPickupTime())
                .set(TicketDynamicSqlSupport.pickup).equalTo(query.getPickupCode())
                .set(TicketDynamicSqlSupport.temperature).equalTo(query.getTemperature())
                .set(TicketDynamicSqlSupport.deposit).equalTo(query.getDeposit())
                .set(TicketDynamicSqlSupport.applyMemo).equalTo(query.getStoreMemo())
                .set(TicketDynamicSqlSupport.changeLog).equalTo(newLog)
                .set(TicketDynamicSqlSupport.itemACount).equalTo(getCount(query, ItemCodes.A))
                .set(TicketDynamicSqlSupport.itemBCount).equalTo(getCount(query, ItemCodes.B))
                .set(TicketDynamicSqlSupport.itemCCount).equalTo(getCount(query, ItemCodes.C))
                .set(TicketDynamicSqlSupport.itemDCount).equalTo(getCount(query, ItemCodes.D))
                .set(TicketDynamicSqlSupport.itemECount).equalTo(getCount(query, ItemCodes.E))
                .set(TicketDynamicSqlSupport.itemFCount).equalTo(getCount(query, ItemCodes.F))
                .set(TicketDynamicSqlSupport.updateTime).equalTo(new Date())
                .where(TicketDynamicSqlSupport.transactionId, SqlBuilder.isEqualTo(query.getTransactionId())));
        ApplyUserTickeReposeDTO applyUserTickeReposeDTO = new ApplyUserTickeReposeDTO();
        return applyUserTickeReposeDTO;
    }


    @Transactional
    public ApplyUserTickeReposeDTO update(ApplyUserTickeRequestDTO query) {

        List<Ticket> ticks = ticketMapper.select(s -> s.where(TicketDynamicSqlSupport.transactionId, SqlBuilder.isEqualTo(query.getTransactionId())));
        if (ticks.isEmpty()) {
            throw new ApBusinessException("找不到訂單");
        }
        StringBuffer stringBuffer = new StringBuffer();
        Ticket ticket = ticks.get(0);
        addNote(stringBuffer, "訂購人：", ticket.getOrderName(), query.getName());
        addNote(stringBuffer, "電話：", ticket.getOrderTel(), query.getPhone());
        addNote(stringBuffer, "取貨時間：", ticket.getPickupDate(), query.getPickupTime());
        addNote(stringBuffer, "取貨地點：", ticket.getPickup(), query.getPickupCode());
        addNoteIfCode(stringBuffer, "溫度：", ticket.getTemperature(), query.getTemperature(), CodeSets.TEMPERATURE_CODES);

        addNote(stringBuffer, "訂金：", ticket.getDeposit(), query.getDeposit());

        addNote(stringBuffer, "客戶備註：", ticket.getCustomerMemo(), query.getMemo());
        addNote(stringBuffer, "店家備註：", ticket.getApplyMemo(), query.getStoreMemo());
        List<QuertUserTickeReposeDTO.CreateOrderRequestItemDTO> items = query.getItems();
        for (QuertUserTickeReposeDTO.CreateOrderRequestItemDTO item : items) {
            check(item, ItemCodes.A, () -> ticket.getItemACount(), stringBuffer);
            check(item, ItemCodes.B, () -> ticket.getItemBCount(), stringBuffer);
            check(item, ItemCodes.C, () -> ticket.getItemCCount(), stringBuffer);
            check(item, ItemCodes.D, () -> ticket.getItemDCount(), stringBuffer);
            check(item, ItemCodes.E, () -> ticket.getItemECount(), stringBuffer);
            check(item, ItemCodes.F, () -> ticket.getItemFCount(), stringBuffer);
        }


        return updateTicket(query, stringBuffer.toString());
    }

    private void addNote(StringBuffer stringBuffer, String title, Object src, Object tar) {
        if (!Objects.equals(src, tar)) {
            stringBuffer.append(title + "從" + src + "變更為" + tar+" ");
        }
    }

    private void addNoteIfCode(StringBuffer stringBuffer, String title, String src, String tar, CodeSets codeSets) {
        if (!Objects.equals(src, tar)) {
            stringBuffer.append(title + "從" + codeService.getText(codeSets, src) + "變更為" + codeService.getText(codeSets, tar) );
        }
    }

    private void check(QuertUserTickeReposeDTO.CreateOrderRequestItemDTO item, ItemCodes a, IntSupplier tickCount, StringBuffer stringBuffer) {
        if (Objects.equals(a.getCode(), item.getCode())) {
            addNote(stringBuffer, a.getText() + ":", tickCount.getAsInt(), item.getQuantity());
        }

    }

    private static String getNow() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    private static int getCount(ApplyUserTickeRequestDTO query, ItemCodes itemCodes) {
        return query.getItems().stream().filter(i -> i.getCode().equals(itemCodes.getCode()))
                .map(i -> i.getQuantity()).findAny().orElse(0);
    }

    public QuertUserTickeReposeDTO queryCustom(QuertCustomTickeRequestDTO query) {
        if (!StringUtils.isNotBlank(query.getName())) {
            throw new ApBusinessException("請輸入購買人姓名");
        }
        if (!StringUtils.isNotBlank(query.getPhone())) {
            throw new ApBusinessException("請輸入電話");
        }
        return this.mapByTicket(ticketMapper.select(s -> s
                .where(TicketDynamicSqlSupport.orderName, SqlBuilder.isEqualTo(query.getName()))
                .and(TicketDynamicSqlSupport.orderTel, SqlBuilder.isEqualTo(query.getPhone())
                )).stream().toList());
    }
}
