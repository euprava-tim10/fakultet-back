INSERT INTO fakultet.admin_fakulteta (id,ime,prezime) VALUES
	 (1,'Boro','Boro');
INSERT INTO fakultet.fakultet (id,naziv) VALUES
	 (1,'FTN'),
	 (2,'Pravni');
INSERT INTO fakultet.hibernate_sequence (next_val) VALUES
	 (4);
INSERT INTO fakultet.smer (id,naziv,nivo_studija,fakultet_id) VALUES
	 (1,'SIT',0,1),
	 (2,'E2',0,1),
	 (3,'pravo',0,2);
INSERT INTO fakultet.student (id,ime,jmbg,prezime) VALUES
	 (2,'Gagi','222','Gagi');