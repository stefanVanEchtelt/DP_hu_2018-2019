--opdracht 1
CREATE TABLE medewerkers_copy AS 
SELECT * FROM medewerkers 

ALTER TABLE medewerkers_copy  ADD geslacht varchar(1);

ALTER TABLE medewerkers_copy ADD CONSTRAINT geslacht_check 
	CHECK (geslacht in ('M', 'V'));


--opdracht 2
CREATE SEQUENCE afdelingsnummer_sequence START WITH 60 INCREMENT BY 10;

INSERT INTO AFDELINGEN (ANR, NAAM, LOCATIE, HOOFD)
VALUES (afdelingsnummer_sequence.NEXTVAL, 'KLEIN KANTOOR', 'MONTFOORT', 7839);

INSERT INTO AFDELINGEN (ANR, NAAM, LOCATIE, HOOFD)
VALUES (afdelingsnummer_sequence.NEXTVAL, 'GEMIDELD KANTOOR', 'MONTFOORT', 7839);

INSERT INTO AFDELINGEN (ANR, NAAM, LOCATIE, HOOFD)
VALUES (afdelingsnummer_sequence.NEXTVAL, 'GROOT KANTOOR', 'MONTFOORT', 7839);


--opdracht 3
CREATE TABLE historische_adressen (
    POSTCODE varchar(6) constraint valid_pc check(POSTCODE LIKE '[0-9]{4}[A-Z]{2}'),
    HUISNUMMER int,
    INGANGSDATUM date NOT NULL,
    EINDDATUM date,
    TELEFOON number(10) UNIQUE,
    MED_MNR int NOT NULL,
    PRIMARY KEY (POSTCODE, HUISNUMMER),
    FOREIGN KEY (MED_MNR) REFERENCES MEDEWERKERS(MNR),
    CONSTRAINT start_before_end check(EINDDATUM >= INGANGSDATUM)
);