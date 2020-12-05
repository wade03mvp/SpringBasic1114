create table book (
    bid integer not null generated always as identity,
    name varchar(20) not null, -- 書名
    price integer, -- 價格
    primary key(bid)
);
create table stock (
    sid integer not null generated always as identity,
    bid integer not null, -- book's id
    amount integer, -- 庫存量
    primary key(sid)
);
create table wallet (
    wid integer not null generated always as identity,
    money integer, -- 錢
    primary key(wid)
);


