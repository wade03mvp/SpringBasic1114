-- 建立 emp 資料表
create table emp (
    id integer not null generated always as identity, -- 主鍵,會自動產出流水序號
    name varchar(20) not null, -- 員工姓名
    age integer, -- 員工年齡
    sex varchar(1), -- 員工性別(M, F)
    ct timestamp default current_timestamp, -- 建檔時間, 與會插入資料庫主機目前的時間
    primary key(id) -- 設定 id 欄位為主鍵
)

