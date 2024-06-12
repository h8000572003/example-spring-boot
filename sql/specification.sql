-- auto-generated definition
create table specification
(
    id    varchar(2)  not null
        constraint specification_pk
            primary key,
    name  varchar(14) not null,
    price integer     not null,
    memo  varchar(200)
);

comment on table specification is '品項規格';

comment on column specification.id is '品項代碼';

comment on column specification.name is '名稱';

comment on column specification.memo is '說明';

alter table specification
    owner to postgres;

create index specification_id_index
    on specification (id);

