create table city
(
    id         bigint not null auto_increment,
    name       varchar(255),
    country_id bigint,
    primary key (id)
) engine = InnoDB;
create table airport
(
    id      bigint not null auto_increment,
    name    varchar(255),
    city_id bigint,
    primary key (id)
) engine = InnoDB;
create table clients_data
(
    id               bigint not null auto_increment,
    email            varchar(255),
    first_name       varchar(255),
    last_name        varchar(255),
    trip_purchase_id bigint,
    primary key (id)
) engine = InnoDB;
create table continent
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
create table country
(
    id           bigint not null auto_increment,
    name         varchar(255),
    continent_id bigint,
    primary key (id)
) engine = InnoDB;
create table hotel
(
    id          bigint not null auto_increment,
    description varchar(255),
    name        varchar(255),
    standard    varchar(255),
    city_id     bigint,
    primary key (id)
) engine = InnoDB;
create table purchase_finance_details
(
    id               bigint not null auto_increment,
    adults_cost      double precision,
    children_cost    double precision,
    total_cost       double precision,
    trip_purchase_id bigint,
    primary key (id)
) engine = InnoDB;
create table trip
(
    id                   bigint           not null auto_increment,
    adult_price          double precision not null,
    adults_quantity      integer,
    child_price          double precision not null,
    children_quantity    integer,
    days_quantity        integer,
    end_date             date,
    is_promoted          integer          not null,
    start_date           date,
    type                 varchar(255),
    arrival_airport_id   bigint,
    arrival_city_id      bigint,
    departure_airport_id bigint,
    departure_city_id    bigint,
    hotel_id             bigint,
    primary key (id)
) engine = InnoDB;
create table trip_purchase
(
    id                 bigint not null auto_increment,
    adults_quantity    integer,
    children_quantity  integer,
    client_id          bigint,
    finance_details_id bigint,
    trip_id            bigint,
    primary key (id)
) engine = InnoDB;
create table user
(
    id       bigint not null auto_increment,
    email    varchar(255),
    password varchar(255),
    role     varchar(255),
    username varchar(255),
    primary key (id)
) engine = InnoDB;
alter table airport
    add constraint FKf583ieaw0ttnwklqy222tfru0 foreign key (city_id) references city (id);
alter table city
    add constraint FKrpd7j1p7yxr784adkx4pyepba foreign key (country_id) references country (id);
alter table clients_data
    add constraint FKmn4cngfyy6h9j3bw503rrsamr foreign key (trip_purchase_id) references trip_purchase (id);
alter table country
    add constraint FKpymfsgrl32dy3gtl9r7rykkjg foreign key (continent_id) references continent (id);
alter table hotel
    add constraint FKf1iabdv6bi2yohh9h48wce42x foreign key (city_id) references city (id);
alter table purchase_finance_details
    add constraint FKlg52exsxq5g56ujlx8j5slwyq foreign key (trip_purchase_id) references trip_purchase (id);
alter table trip
    add constraint FK8h24tx7r80j09v52gt974b2nl foreign key (arrival_airport_id) references airport (id);
alter table trip
    add constraint FKc5qdys8014lldoydnlkxqqkxg foreign key (arrival_city_id) references city (id);
alter table trip
    add constraint FK8yxenq4d5gfisdtcvcru6asjp foreign key (departure_airport_id) references airport (id);
alter table trip
    add constraint FKduax06jcigg53p7e5khjj1n3i foreign key (departure_city_id) references city (id);
alter table trip
    add constraint FKkhwcup185gsdomglyb3bbi15d foreign key (hotel_id) references hotel (id);
alter table trip_purchase
    add constraint FK66q40mju8hme7lnr5lwyfjv36 foreign key (client_id) references clients_data (id);
alter table trip_purchase
    add constraint FKjwbwv1q8dqcwt24e2s7ubeqi5 foreign key (finance_details_id) references purchase_finance_details (id);
alter table trip_purchase
    add constraint FKer1nkhfy3n86soydhprgb1ebd foreign key (trip_id) references trip (id);
