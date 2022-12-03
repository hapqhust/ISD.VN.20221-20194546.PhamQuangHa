--
-- File generated with SQLiteStudio v3.4.0 on Sat Dec 3 19:32:17 2022
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Book
CREATE TABLE Book (
    id              INTEGER      PRIMARY KEY
                                 NOT NULL,
    author          VARCHAR (45) NOT NULL,
    hardCover       VARCHAR (45) NOT NULL,
    publisher       VARCHAR (45) NOT NULL,
    publicationDate DATE         NOT NULL,
    numOfPages      INTEGER      NOT NULL,
    language        VARCHAR (45) NOT NULL,
    bookCategory    VARCHAR (45) NOT NULL,
    CONSTRAINT fk_Book_Media1 FOREIGN KEY (
        id
    )
    REFERENCES Media (id) 
);


-- Table: Card
CREATE TABLE Card (
    id          INTEGER      PRIMARY KEY AUTOINCREMENT
                             NOT NULL,
    cardNumber  VARCHAR (15) NOT NULL,
    owner       VARCHAR (45) NOT NULL,
    cvvCode     VARCHAR (15) NOT NULL,
    dateExpired VARCHAR (15) NOT NULL,
    bank        VARCHAR (45) NOT NULL
);


-- Table: CD
CREATE TABLE CD (
    id              INTEGER       PRIMARY KEY
                                  NOT NULL,
    artist          VARCHAR (45)  NOT NULL,
    recordLabel     VARCHAR (45)  NOT NULL,
    musicType       VARCHAR (45)  NOT NULL,
    publicationDate DATE,
    trackList       VARCHAR (100) NOT NULL,
    CONSTRAINT fk_CD_Media1 FOREIGN KEY (
        id
    )
    REFERENCES Media (id) 
);


-- Table: DeliveryInfo
CREATE TABLE DeliveryInfo (
    id             INTEGER       PRIMARY KEY AUTOINCREMENT
                                 NOT NULL,
    name           VARCHAR (45)  NOT NULL,
    phoneNumber    VARCHAR (45)  NOT NULL,
    province       VARCHAR (45)  NOT NULL,
    instructions   VARCHAR (200),
    address        VARCHAR (100) NOT NULL,
    rushDeliveryId INTEGER       NOT NULL,
    CONSTRAINT fk_DeliveryInfo_RushDeliInfo FOREIGN KEY (
        rushDeliveryId
    )
    REFERENCES RushDeliveryInfo (id) 
);


-- Table: DVD
CREATE TABLE DVD (
    id           INTEGER      PRIMARY KEY
                              NOT NULL,
    discType     VARCHAR (45) NOT NULL,
    director     VARCHAR (45) NOT NULL,
    runtime      INTEGER      NOT NULL,
    studio       VARCHAR (45) NOT NULL,
    subtitle     VARCHAR (45) NOT NULL,
    releasedDate DATE,
    language     VARCHAR (45) NOT NULL,
    CONSTRAINT fk_DVD_Media1 FOREIGN KEY (
        id
    )
    REFERENCES Media (id) 
);


-- Table: Invoice
CREATE TABLE Invoice (
    id          INTEGER PRIMARY KEY
                        NOT NULL,
    totalAmount INTEGER NOT NULL,
    orderId     INTEGER NOT NULL,
    CONSTRAINT fk_Invoice_Order1 FOREIGN KEY (
        orderId
    )
    REFERENCES [Order] (id) 
);


-- Table: Media
CREATE TABLE Media (
    id                 INTEGER      PRIMARY KEY AUTOINCREMENT
                                    NOT NULL,
    category           VARCHAR (45) NOT NULL,
    price              INTEGER      NOT NULL,
    value              INTEGER      NOT NULL,
    title              VARCHAR (45) NOT NULL,
    description        TEXT         NOT NULL,
    barcode            VARCHAR (45) NOT NULL,
    quantity           INTEGER      NOT NULL,
    importDate         DATE         NOT NULL,
    rushOrderSupported BOOLEAN      NOT NULL,
    imageUrl           VARCHAR (45) NOT NULL
);


-- Table: Order
CREATE TABLE [Order] (
    id             INTEGER PRIMARY KEY
                           NOT NULL,
    shippingFees   INTEGER,
    subtotal       INTEGER,
    deliveryInfoId INTEGER NOT NULL,
    CONSTRAINT fk_Order_DeliveryInfo1 FOREIGN KEY (
        deliveryInfoId
    )
    REFERENCES DeliveryInfo (id) 
);


-- Table: OrderMedia
CREATE TABLE OrderMedia (
    orderID        INTEGER NOT NULL,
    price          INTEGER NOT NULL,
    quantity       INTEGER NOT NULL,
    mediaId        INTEGER NOT NULL,
    isRushDelivery BOOLEAN,
    PRIMARY KEY (
        orderID,
        mediaId
    ),
    CONSTRAINT fk_ordermedia_order FOREIGN KEY (
        orderID
    )
    REFERENCES [Order] (id),
    CONSTRAINT fk_OrderMedia_Media1 FOREIGN KEY (
        mediaId
    )
    REFERENCES Media (id) 
);


-- Table: PaymentTransaction
CREATE TABLE PaymentTransaction (
    id        INTEGER      PRIMARY KEY
                           NOT NULL,
    createAt  DATETIME     NOT NULL,
    content   VARCHAR (45) NOT NULL,
    method    VARCHAR (45),
    cardId    INTEGER      NOT NULL,
    invoiceId INTEGER      NOT NULL,
    CONSTRAINT fk_PaymentTransaction_Card1 FOREIGN KEY (
        cardId
    )
    REFERENCES Card (id),
    CONSTRAINT fk_PaymentTransaction_Invoice1 FOREIGN KEY (
        invoiceId
    )
    REFERENCES Invoice (id) 
);


-- Table: RushDeliveryInfo
CREATE TABLE RushDeliveryInfo (
    id                  INTEGER       PRIMARY KEY AUTOINCREMENT
                                      NOT NULL,
    receivedDate        DATE          NOT NULL,
    recievedTime        DATETIME      NOT NULL,
    rushDeliveryAddress VARCHAR (100) NOT NULL
);


-- Index: Invoice.fk_Invoice_Order1_idx
CREATE INDEX [Invoice.fk_Invoice_Order1_idx] ON Invoice (
    "orderId"
);


-- Index: Order.fk_Order_DileveryInfo1_idx
CREATE INDEX [Order.fk_Order_DileveryInfo1_idx] ON [Order] (
    "deliveryInfoId"
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
