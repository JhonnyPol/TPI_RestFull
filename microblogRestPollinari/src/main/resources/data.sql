insert into amministratori (id, cognome, nome, username, password) values(1,'Admin', 'Admin', 'admin', 'admin');
insert into utenti (id, cognome, nome, username, password) values(1, 'Rossi', 'Mario', 'MarioRossi', 'qwerty');
insert into utenti (id, cognome, nome, username, password) values(2, 'Verdi', 'Luigi', 'LuigiVerdi', 'qwerty');
insert into posts (id, titolo, testo, amministratore_id, data_Post) values(1, 'Ciao', 'ciaociaociaociaociao', 1, '2001-07-28');
insert into commenti (id, testo, post_id, utente_id) values(1, 'Gran bel post, complimenti!', 1, 1);
