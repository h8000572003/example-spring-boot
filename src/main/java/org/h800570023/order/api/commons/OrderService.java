package org.h800570023.order.api.commons;

import lombok.RequiredArgsConstructor;
import org.h800570023.order.api.rest.craete.CreateOrderReposeDTO;
import org.h800570023.order.api.rest.craete.CreateOrderRequestDTO;
import org.h800570023.order.api.rest.ticket.apply.ApplyUserTickeReposeDTO;
import org.h800570023.order.api.rest.ticket.apply.ApplyUserTickeRequestDTO;
import org.h800570023.order.api.rest.ticket.query.QuertUserTickeReposeDTO;
import org.h800570023.order.api.rest.ticket.query.QuertUserTickeRequestDTO;
import org.h800570023.order.codes.*;
import org.h800570023.order.mapper.TicketDynamicSqlSupport;
import org.h800570023.order.mapper.TicketMapper;
import org.h800570023.order.model.Ticket;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.where.WhereDSL;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final TicketMapper ticketMapper;

    private final CommonService commonService;
    private final CodeService codeService;

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
        if (StringUtils.hasText(query.getTransactionId())) {
            where.and(TicketDynamicSqlSupport.transactionId, SqlBuilder.isLike("%" + query.getTransactionId()));
            hasWhere = true;
        }
        if (StringUtils.hasText(query.getName())) {
            where.and(TicketDynamicSqlSupport.orderName, SqlBuilder.isLike(query.getName() + "%"));
            hasWhere = true;
        }
        if (StringUtils.hasText(query.getStatus())) {
            where.and(TicketDynamicSqlSupport.status, SqlBuilder.isEqualTo(query.getStatus()));
            hasWhere = true;
        }
        if (StringUtils.hasText(query.getPhone())) {
            where.and(TicketDynamicSqlSupport.orderTel, SqlBuilder.isLike(query.getPhone() + "%"));
            hasWhere = true;
        }
        if (query.getPickupTime() != null) {
            where.and(TicketDynamicSqlSupport.pickupDate, SqlBuilder.isEqualTo(query.getPickupTime()));
            hasWhere = true;
        }
        if (StringUtils.hasText(query.getPickupCode())) {
            where.and(TicketDynamicSqlSupport.pickup, SqlBuilder.isLike(query.getPickupCode()));
            hasWhere = true;
        }
        if (StringUtils.hasText(query.getTemperature())) {
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

    public ApplyUserTickeReposeDTO apply(ApplyUserTickeRequestDTO query) {
        query.setStatus(TicketStatus.C.getCode());
        return updateTicket(query);
    }

    private ApplyUserTickeReposeDTO updateTicket(ApplyUserTickeRequestDTO query) {
        Integer total = query.getItems().stream().map(i -> {
            return i.getQuantity() * i.getPrice();
        }).reduce(0, Integer::sum);
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
                .set(TicketDynamicSqlSupport.itemACount).equalTo(getCount(query, ItemCodes.A))
                .set(TicketDynamicSqlSupport.itemBCount).equalTo(getCount(query, ItemCodes.B))
                .set(TicketDynamicSqlSupport.itemCCount).equalTo(getCount(query, ItemCodes.C))
                .set(TicketDynamicSqlSupport.itemDCount).equalTo(getCount(query, ItemCodes.D))
                .set(TicketDynamicSqlSupport.itemECount).equalTo(getCount(query, ItemCodes.E))
                .set(TicketDynamicSqlSupport.itemFCount).equalTo(getCount(query, ItemCodes.F))
                .where(TicketDynamicSqlSupport.transactionId, SqlBuilder.isEqualTo(query.getTransactionId())));
        ApplyUserTickeReposeDTO applyUserTickeReposeDTO = new ApplyUserTickeReposeDTO();
        return applyUserTickeReposeDTO;
    }

    public ApplyUserTickeReposeDTO reject(ApplyUserTickeRequestDTO query) {
        ticketMapper.update(u -> u
                .set(TicketDynamicSqlSupport.status).equalTo(TicketStatus.D.getCode())
                .set(TicketDynamicSqlSupport.closeDate).equalTo(new Date())
                .set(TicketDynamicSqlSupport.applyMemo).equalTo(query.getStoreMemo())
                .where(TicketDynamicSqlSupport.transactionId, SqlBuilder.isEqualTo(query.getTransactionId())));
        ApplyUserTickeReposeDTO applyUserTickeReposeDTO = new ApplyUserTickeReposeDTO();
        return applyUserTickeReposeDTO;
    }

    public ApplyUserTickeReposeDTO update(ApplyUserTickeRequestDTO query) {
        return updateTicket(query);
    }

    private static int getCount(ApplyUserTickeRequestDTO query, ItemCodes itemCodes) {
        return query.getItems().stream().filter(i -> i.getCode().equals(itemCodes.getCode()))
                .map(i -> i.getQuantity()).findAny().orElse(0);
    }

}
