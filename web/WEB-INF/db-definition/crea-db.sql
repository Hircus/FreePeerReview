/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  tobias
 * Created: 22-mag-2019
 */

create table utenti(
    id serial primary key,
    nome varchar(100),
    cognome varchar(100),
    email varchar(100),
    password varchar(100),
    immagine varchar(100),
    ente varchar(100),
    tipoUtente boolean
);

create table articoli(
    id serial primary key,
    titolo varchar(100),
    testo varchar(300),
    immagine varchar(100),
    dataScrittura varchar(100)
);