/*
-username : Andreea
-password : 1234
*/


CREATE TABLE utenti(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	nome VARCHAR(256),
	cognome VARCHAR(256),
	email VARCHAR(256) UNIQUE,
	password VARCHAR(256) NOT NULL,
	frasePresentazione VARCHAR(256),
	urlProfilo VARCHAR(256),
	dataNascita DATE
);

CREATE TABLE gruppi(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
	nome VARCHAR(256),
	urlImmagine VARCHAR(256),
	amministratore INTEGER, 
	FOREIGN KEY (amministratore) REFERENCES utenti(id)
);

CREATE TABLE postType (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(32)
);

CREATE TABLE post(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, 
	autore INTEGER,
	contenuto VARCHAR(2048),
	allegato VARCHAR(256),
	tipo INTEGER,
	idGroup INTEGER,
	idUser INTEGER,
	FOREIGN KEY (tipo) REFERENCES postType(id),
	FOREIGN KEY (idGroup) REFERENCES gruppi(id),
	FOREIGN KEY (idUser) REFERENCES utenti(id)
);

CREATE TABLE iscrizioni(
	idGruppi INTEGER,
	idUtenti INTEGER,
	FOREIGN KEY (idGruppi) REFERENCES gruppi(id),
	FOREIGN KEY (idUtenti) REFERENCES utenti(id)
	
);

CREATE TABLE amicizie(
	idUtente1 INTEGER,
	idUtente2 INTEGER,
	FOREIGN KEY(idUtente1) REFERENCES utenti(id),
	FOREIGN KEY(idUtente2) REFERENCES utenti(id)	
);

/*
Inserimento dei tre utenti
*/
INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Bugs',
		'Bunny',
		'bugsbunny@bugs.com',
		'123',
		'Ho le orecchie più belle del mondo',
		'img/bunny.jpg',
		'1940-07-27'
);
		
INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Deadpool',
		NULL,
		'dead@pool.com',
		'456',
		NULL,
		'img/images.jpg',
		'1991-02-07'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Jerry',
		NULL,
		'jerry@tom.com',
		'789',
		'Sono un topo obbediente',
		'img/images1.jpg',
		'1940-01-01'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Mickey',
		'Mouse',
		'mickey@mouse.com',
		'123',
		'Ho una coda di topo spettacolare',
		'img/mickey.png',
		'1928-01-01'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Albus',
		'Silente',
		'albus@silente.com',
		'123',
		'È l’ignoto che temiamo quando guardiamo la morte e il buio, nient’altro.',
		'img/albus.jpg',
		'1881-05-01'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Sirius',
		'Black',
		'sirius@black.com',
		'123',
		'..sta sempre a noi scegliere da che parte schierarci.',
		'img/sirius.jpg-c200',
		'1959-11-03'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Remus',
		'Lupin',
		'remus@lupin.com',
		'123',
		'Ho la Lunastorta.....',
		'img/remus.jpg',
		'1960-03-10'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Minerva',
		'McGranitt',
		'minerva@mcgranitt.com',
		'123',
		'Miao miao',
		'img/minerva.jpg',
		'1935-10-04'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Rubeus',
		'Hagrid',
		'rubeus@hagrid.com',
		'123',
		'Sono Custode,guardiacaccia e insegnante di Cura delle Creature Magiche',
		'img/hagrid.jpg',
		'1928-12-06'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Alastor',
		'Moody',
		'all@moody.com',
		'123',
		'" La bocca pareva un taglio diagonale, e mancava un grosso pezzo di naso."',
		'img/malocchio.jpg',
		'1928-12-06'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Seveus',
		'Piton',
		'severus@piton.com',
		'123',
		'Andate a pagina 394',
		'img/piton.jpg',
		'1960-01-09'
);

INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Harry',
		'Potter',
		'harry@potter.com',
		'123',
		'Expecto Patronum',
		'img/harry.jpg',
		'1980-07-31'
);
	
	
INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Hermione',
		'Granger',
		'hermione@granger.com',
		'123',
		'E'' Leviosa non Leviosà',
		'img/hermione.jpg',
		'1979-09-19'
);
	
	
INSERT INTO utenti (id, nome, cognome,email,password, frasePresentazione,urlProfilo, dataNascita) 
VALUES (default,
		'Ron',
		'Weasley',
		'ron@weasley.com',
		'123',
		'Miseriaccia!',
		'img/ron.jpg',
		'1980-03-01'
);
	
		
/*
Inserimento dei due gruppi
*/

INSERT INTO gruppi(id, nome, urlImmagine ,amministratore)
VALUES (default,
        'CartoonNetwork',
        'img/cn.png',
        1

);
		
INSERT INTO gruppi(id, nome, urlImmagine ,amministratore)
VALUES (default,
        'Marvel',
        'img/marvel.jpg',
        2
);

INSERT INTO gruppi(id, nome, urlImmagine ,amministratore)
VALUES (default,
        'Disney ClubHouse',
        'img/disney.jpg',
        4
);

INSERT INTO gruppi(id, nome, urlImmagine ,amministratore)
VALUES (default,
        'Ordine della Fenice',
        'img/fenice.jpg',
        5

);

INSERT INTO gruppi(id, nome, urlImmagine ,amministratore)
VALUES (default,
        'Grifondoro',
        'img/grif.jpg',
        12

);



/*
Inserimento dei  tipi di post
*/

INSERT INTO postType(id, nome)
VALUES (default,
        'TEXT'
);

INSERT INTO postType(id, nome)
VALUES (default,
        'IMAGE'
);


INSERT INTO postType(id, nome)
VALUES (default,
        'LINK'
);
		
/*
Inserimento dei  post
*/
		
INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        1,
       'Un sondaggio inglese rivela: la frase più ricordata tra gli amanti dei cartoon è quella del celebre coniglio: «Che succede amico?»Bugs Bunny Per gli 
       americani dev''essere una sorta di riflesso condizionato: davanti alle orecchie di un coniglio viene automatico pensare «what''s up doc?». E si capisce.
       E'' la frase «tormentone» del coniglio più famoso d''America: Bugs Bunny. La faccia soddisfatta del dentone carota-dipendente la dice a ripetizione 
       anche da noi, al di qua delle Alpi: «Che succede amico?». E non è un caso che sia proprio quella la frase la più famosa legata a un personaggio dei 
       cartoon. Lo rivela un recente studio-sondaggio voluto dalla sede inglese del gruppo di distribuzione cinematografica Uci Cinemas per lanciare l''ultimo film della Warner Bros, Back in 
       Action. A 500 cinefili inglesi appassionati di cartoni animati è stato chiesto quale detto, frase o parola amano e ricordano di più in relazione a un cartoon. Bene: su tutti ha prevalso quel «what''s up doc?», seguito da «Doh!», espressione fra lo sgomento e lo stupito di un personaggio ben più giovane di Bugs, Homer Simpson il confuso ispettore nucleare della famiglia 
       più strampalata dei cartoon.',
       NULL,
        1,
        1,
       NULL
);


INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        2,
        '
            "-Che c''è, non hai mai sentito parlare di Google? Dovresti cercarlo su Google."
            "- A volte, non sempre ovviamente, ma a volte, io... vedo come delle cose. Ho delle visioni. Immagini distorte della realtà. [...] Oh, non è una cosa fissa. Ma il piccolo uomo pallido dietro la tenda, cioè il mio editor-- dice non più di due per episodio."
            "- Ehi, tamarro. Senti, io sono uno dei buoni--- be'', almeno in questo numero..."
            "-Fare l''eroe è la professione più breve del mondo. Fa tutto ridere, finchè capita a qualcun altro."
            "- Sono stato creato specificamente dagli umani... per uccidere gli umani. Il che la dice lunga sulla razza umana in generale, non credete?!"
            "- Una volta uno mi ha detto che alla fine di tutto rimpiangiamo non quello che abbiamo fatto, ma quello che non abbiamo fatto."
        ',
        'img/pool.jpg',
         2,
         2,
        NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        3,
        'La Ofcom ha spiegato che Tom & Jerry è un cartone animato vintage realizzato in un periodo in cui il rischio legato al fumo non era ancora stato attentamente studiato e che questa era un''ottima ragione per chiedere alla Turner di prendere provvedimenti. Tom & Jerry però sono stati censurati altre volte. Molte scene di altri episodi contenevano dei blackface, cioè quando esplodeva qualcosa o il viso di Tom, Jerry o altri personaggi si coprivano di fango, essi diventavano come delle persone africane e ciò poteva risultare offensivo per le persone di origine africana. Un altro episodio censurato è Il suo topo Venerdì (His Mouse Friday, 1951) a causa degli stereotipi razziali in esso contenuti.',
        'https://i.makeagif.com/media/6-06-2015/nc_GSl.gif',
        3,
        1,
        NULL
);
INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        4,
        '“Non te ne andare, ti prego. Nessuno finora è rimasto così a lungo con me. Ma se vuoi andartene, puoi farlo, Io mi ricorderò di te. Io ricordo tutti quelli che se ne vanno.”',
        'img/walt.jpg',
        2,
        3,
        NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        5,
       '"La voce di un bambino, per quanto onesta e sincera, è insignificante per chi ha dimenticato come ascoltare. Cosa misteriosa il tempo: potente e, quando ci s''intromette, pericolosa. Sirius Black è nella cella in cima alla torre oscura. Conosci la legge, signorina Granger, non dovete essere visti. E fareste bene, secondo me, a tornare prima dell''ultimo rintocco, altrimenti le conseguenze saranno troppo devastanti per parlarne. Se stanotte avrete successo, più di una vita innocente verrà salvata. Tre giri dovrebbero bastare! Oh, a proposito, quando si è in dubbio, trovo che tornare sui propri passi sia un modo saggio di cominciare!"',
       NULL,
        1,
        4,
       NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        11,
        '“Dopo tutto questo tempo..Sempre”',
        'img/patronus_snape.jpg',
        2,
        4,
        NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        10,
       '"Alastor Moody. Ex Auror, scontento del Ministero, e nuovo insegnante di Difesa contro le Arti Oscure. 
	   Sono qui perché me l''ha chiesto Silente. Fine della storia, addio, ciao. Ci sono domande?
	   Schiere di streghe e di maghi hanno affermato di aver eseguito gli ordini di Voi-Sapete-Chi perché? Sotto 
	   l''influenza della maledizione Imperius! Ma qui sta il punto: come li scoviamo i bugiardi?!
	   
	    L''anatema che uccide. Si sa che una sola persona è sopravvissuta ad esso... ed è in questa stanza."',
       NULL,
        1,
        4,
       NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        12,
        '“Expecto Patronum”',
        'img/p_h.jpg',
        2,
        4,
        NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        12,
        '“Expecto Patronum”',
        'img/p_h.jpg',
        2,
        5,
        NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        13,
       '‘Sei sicuro che sia un incantesimo, vero?’ chiese la ragazza. ‘Comunque, non funziona molto bene, o sbaglio? Io ho provato a fare alcuni 
	   incantesimi semplici semplici e mi sono riusciti tutti. Nella mia famiglia, nessuno ha poteri magici; è stata una vera sorpresa quando ho ricevuto la lettera, 
	    ma mi ha fatto un tale piacere, naturalmente, voglio dire, è la migliore scuola di magia che esista, ho sentito dire... 
	   Ho imparato a memoria tutti i libri di testo, naturalmente, spero proprio che basti... E... a proposito, io mi chiamo Hermione Granger, e voi?’',
       NULL,
        1,
        5,
       NULL
);

INSERT INTO post(id, autore,contenuto ,allegato, tipo, idGroup, idUser )
VALUES (default,
        8,
       'McGranitt: mi domando perché ogni volta che succede qualcosa ci siete di mezzo voi 3!
		Ron: ci creda professoressa, me lo chiedo anche io da 6 anni!’',
       NULL,
        1,
        5,
       NULL
); 

/*
Inserimento delle iscrizioni
*/

INSERT INTO iscrizioni(idGruppi, idUtenti)
VALUES  (1,1),
        (1,3),
        (2,2),
		(3,4),
		(3,1),
		(4,5),
		(4,6),
		(4,7),
		(4,8),
		(4,9),
		(4,10),
		(4,11),
		(4,12),	
		(5,12),
		(5,13),
		(5,14);
		


		 


/*
Inserimento delle amicizie
*/

INSERT INTO amicizie(idUtente1, idUtente2)
VALUES (2,1),
        (3,2),
        (3,1),
		(4,1),
		(4,2),
		(4,3),
		(5,6),
		(5,7),
		(5,8),
		(5,9),
		(5,10),
		(5,11),
		(5,12),
		(5,13),
		(5,14),
		(6,7),
		(6,8),
		(6,9),
		(6,10),
		(6,11),
		(6,12),
		(6,13),
		(6,14),
		(7,8),
		(7,9),
		(7,10),
		(7,11),
		(7,12),
		(7,13),
		(7,14),
		(8,9),
		(8,10),
		(8,11),
		(8,12),
		(8,13),
		(8,14),
		(9,10),
		(9,11),
		(9,12),
		(9,13),
		(9,14),
		(10,11),
		(10,12),
		(10,13),
		(10,14),
		(11,12),
		(12,13),
		(12,14),
		(13,14);
		
		
		
		
	   
	   
	   
	   