CREATE TABLE ItemProduct ( -- 商品項目
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, -- 商品項目序號(主鍵)
    text VARCHAR(50) not null, -- 商品項目名稱
    price INTEGER NOT NULL, -- 商品單價
    inventory INTEGER NOT NULL, -- 商品庫存量
    PRIMARY KEY (id)
);

CREATE TABLE Invoice ( -- 發票
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, -- 發票序號(主鍵)
    invdate Date not null, -- 發票日期
    PRIMARY KEY (id)
);

CREATE TABLE Item ( -- 發票項目
    id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY, -- 項目序號(主鍵)
    amount INTEGER NOT NULL, -- 數量
    ipid INTEGER NOT NULL, -- 商品項目序號
    invid INTEGER NOT NULL, -- 發票序號
    PRIMARY KEY (id),
    FOREIGN KEY (ipid)  REFERENCES ItemProduct(id),
    FOREIGN KEY (invid) REFERENCES Invoice(id)
);