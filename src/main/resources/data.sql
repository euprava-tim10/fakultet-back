--postavi se svaki FOREIGN KEY na NULL
UPDATE konkurs
SET fakultet_id = NULL;

UPDATE kvota_smer
SET smer_id = NULL;

UPDATE obavestenje
SET student_id = NULL;

UPDATE prijava_konkurs
SET prva_zelja_id = NULL, student_id = NULL, konkurs_id = NULL;

UPDATE smer
SET fakultet_id = NULL;

UPDATE status_studija
SET student_id = NULL, smer_id = NULL;

UPDATE student_status_studija
SET student_id = NULL, status_studija_id = NULL;

--brisanje sadrzaja N-N tabela jer je FK NOT NULL
DELETE FROM konkurs_kvote;

--brisanje sadrzaja ostalih tabela
DELETE FROM fakultet.admin_fakulteta;
DELETE FROM fakultet.fakultet;
DELETE FROM fakultet.hibernate_sequence;
DELETE FROM fakultet.konkurs;
DELETE FROM fakultet.kvota_smer;
DELETE FROM fakultet.obavestenje;
DELETE FROM fakultet.prijava_konkurs;
DELETE FROM fakultet.procitano_obavestenje;
DELETE FROM fakultet.smer;
DELETE FROM fakultet.status_studija;
DELETE FROM fakultet.student;
DELETE FROM fakultet.student_status_studija;

--insert test vrednosti
INSERT INTO fakultet.admin_fakulteta (id,ime,prezime) VALUES
         (1,'Boro','Boro');
INSERT INTO fakultet.fakultet (id,naziv) VALUES
     (1,'FTN'),
     (2,'Pravni');
INSERT INTO fakultet.smer (id,naziv,nivo_studija,fakultet_id) VALUES
     (1,'SIT',0,1),
     (2,'E2',0,1),
     (3,'pravo',0,2);
INSERT INTO fakultet.student (id,ime,jmbg,prezime) VALUES
     (2,'Gagi','222','Gagi');