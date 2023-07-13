

-- postgres ilay base ho ampesaina

create table users(
Id_User serial not null primary key,
Nom varchar(100),
Email varchar(100),
Password varchar(100),
Role int
);

create table avion(
Id_Avion serial primary key,
Nb_place_CA int,
Nb_place_CE int
);
INSERT INTO Avion VALUES (default,20, 100);
INSERT INTO Avion VALUES (default,10, 150);
INSERT INTO Avion VALUES (default,30, 80);

create table Vol (
    Id_Vol serial primary key,
    Numero_Vol int,
    Id_Avion int,
    Source VARCHAR(50),
    Destination VARCHAR(50),
    Date_Vol Timestamp,
    Prix int,
    foreign key(Id_Avion) references Avion(Id_Avion)
);
ALTER TABLE Vol ADD Validations BOOLEAN;
INSERT INTO Vol VALUES (default, 1000, 1, 'Paris', 'New York', '2023-07-05 14:30:00', 1500, true);
INSERT INTO Vol VALUES (default, 1001, 2, 'Barcelone', 'Rome', '2023-07-15 18:20:00', 1200, true);
INSERT INTO Vol VALUES (default, 1002, 3, 'Londres', 'Dubai', '2023-07-10 09:45:00', 2000, false);

create table Reservation(
    Id_Reservation serial primary key,
    Id_Vol int,
    Nom_passager varchar(100) not null,
    Date_Reservation Timestamp default current_timestamp,
    foreign key(Id_Vol) references Vol(Id_Vol)
);

create table Promotion(
    Id_Promotion serial primary key,
    Id_Avion int,
    Date_Debut Timestamp,
    Date_Fin Timestamp,
    foreign key(Id_Avion) references avion(Id_Avion)
);




