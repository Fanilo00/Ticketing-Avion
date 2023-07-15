

-- postgres ilay base ho ampesaina

create table users(
Id_User serial not null primary key,
Nom varchar(100),
Email varchar(100),
Password varchar(100),
Role int
);
INSERT INTO users VALUES ()

create table avion(
Id_Avion serial primary key,
Nb_place_CA int,
Nb_place_CE int
);
INSERT INTO Avion VALUES (default,20, 100);
INSERT INTO Avion VALUES (default,10, 150);
INSERT INTO Avion VALUES (default,30, 80);



CREATE TABLE Vol (
    Id_Vol serial PRIMARY KEY,
    Numero_Vol int,
    Id_Avion int,
    Source VARCHAR(50),
    Destination VARCHAR(50),
    Date_Vol Timestamp,
   	Duree_vol decimal(6,2),
    Prix int,
    date_soumission TIMESTAMP,
    est_valide BOOLEAN DEFAULT false,
    date_validation TIMESTAMP DEFAULT null,
    type_trajet int,
    FOREIGN KEY (Id_Avion) REFERENCES Avion(Id_Avion)
);

    INSERT INTO Vol (Numero_Vol, Id_Avion, Source, Destination, Date_Vol, Duree_vol, Prix, date_soumission, est_valide, type_trajet)
VALUES (1, 1, 'Paris', 'New York', '2023-07-15 10:00:00', 4.5, 1000, '2023-07-14 15:30:00', true, 0);

    INSERT INTO Vol (Numero_Vol, Id_Avion, Source, Destination, Date_Vol, Duree_vol, Prix, date_soumission, est_valide, type_trajet)
VALUES (2, 2, 'London', 'Paris', '2023-07-16 14:30:00', 2.75, 750, '2023-07-15 09:45:00', false, 1);

    INSERT INTO Vol (Numero_Vol, Id_Avion, Source, Destination, Date_Vol, Duree_vol, Prix, date_soumission, est_valide, type_trajet)
VALUES (3, 1, 'Madrid', 'Barcelona', '2023-07-17 09:00:00', 1.5, 500, '2023-07-16 16:20:00', true, 0);

   INSERT INTO Vol (Numero_Vol, Id_Avion, Source, Destination, Date_Vol, Duree_vol, Prix, date_soumission, est_valide, type_trajet)
VALUES (4, 3, 'Berlin', 'Rome', '2023-07-18 12:45:00', 3.25, 900, '2023-07-17 10:10:00', false, 1);

  INSERT INTO Vol (Numero_Vol, Id_Avion, Source, Destination, Date_Vol, Duree_vol, Prix, date_soumission, est_valide, type_trajet)
VALUES (5, 2, 'Tokyo', 'Sydney', '2023-07-19 18:30:00', 9.75, 2000, '2023-07-18 13:55:00', true, 0);

 select * from vol where est_valide='false' and 
 date_soumission<=current_timestamp and current_timestamp<=date_soumission + interval '2 weeks';

CREATE TABLE vol_attente_validation(
  id SERIAL PRIMARY KEY,
  employe_id INT,
  vol_details VARCHAR(200),
  date_soumission TIMESTAMP,
  est_valide BOOLEAN DEFAULT false,
  date_validation TIMESTAMP
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




