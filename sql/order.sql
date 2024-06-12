-- auto-generated definition
create table "order"
(
    transaction_id varchar(20)                            not null
        constraint order_pk
            primary key,
    order_name     varchar(50),
    order_tel      varchar(20),
    customer_memo  varchar(200),
    status         varchar(2),
    total          integer,
    deposit        integer,
    create_date    date,
    pickup_date    date,
    close_date     date,
    item_a_count   integer default 0,
    item_b_count   integer default 0,
    item_c_count   integer default 0,
    item_d_count   integer default 0,
    temperature    varchar default 'N'::character varying not null,
    apply_memo     varchar(200),
    item_e_count   integer default 0,
    item_f_count   integer default 0
);

comment on table "order" is '訂單';

comment on column "order".transaction_id is '交易序號';

comment on column "order".order_name is '訂購人';

comment on column "order".order_tel is '訂購電話';

comment on column "order".customer_memo is '備註';

comment on column "order".status is '狀態 A:審查中 C:已確認  E:結案';

comment on column "order".total is '總金額';

comment on column "order".deposit is '訂金';

comment on column "order".create_date is '訂購日期';

comment on column "order".pickup_date is '預期取貨日期';

comment on column "order".close_date is '結案日期';

comment on column "order".item_a_count is '南部蛋黃肉粽數量';

comment on column "order".item_b_count is '南部粽數量';

comment on column "order".item_c_count is '北部肉粽數量';

comment on column "order".item_d_count is '白米豆沙數量';

comment on column "order".temperature is '溫度:H:熱 C:冷凍 N:都行';

comment on column "order".apply_memo is '處理備註';

comment on column "order".item_e_count is '紅豆鹼粽';

comment on column "order".item_f_count is '原味鹼粽';

alter table "order"
    owner to postgres;

create index order__index
    on "order" (pickup_date, status, order_tel, order_name);

