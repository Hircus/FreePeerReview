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
    idUtente serial primary key,
    nome varchar(100),
    cognome varchar(100),
    email varchar(100),
    password varchar(100),
    immagine varchar(100),
    ente varchar(100),
    tipoUtente boolean
);

create table articoli(
    idArticolo serial primary key,
    titolo varchar(100),
    testo varchar(300),
    immagine varchar(100),
    dataScrittura varchar(100),
    stato enum ('Aperto', 'Accettato', 'Rifiutato', 'Valutazione'),
    categorie set ('HTML', 'CSS', 'Servlet', 'JSP', 'JavaScript', 'AJAX')
);

create table categorie(
    idCategoria serial primary key,
    nome varchar(100)
);

create table autori(
    idUtente bigint unsigned references utente(idUtente) on delete cascade on update cascade,
    idArticolo bigint unsigned REFERENCES articolo(idArticolo) on delete cascade on update cascade,
    primary key (idUtente, idArticolo)
);

create table valutazione(
    voto enum("1", "2", "3", "4", "5"),
    commAut varchar(100),
    commOrg varchar(100),
    idUtente bigint unsigned references utente(idUtente) on delete cascade on update cascade,
    idArticolo bigint unsigned REFERENCES articolo(idArticolo) on delete cascade on update cascade,
    primary key (idUtente, idArticolo)
);
