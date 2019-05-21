-- opgave 1.6
select MNR, functie, GBDATUM from medewerkers
where GBDATUM < TO_DATE('01-01-1960')
and functie = 'TRAINER' or functie = 'VERKOPER';

-- opgave 1.9
select * from MEDEWERKERS
where naam like '% %';

-- opgave 2.5
select u.cursus, u.begindatum, count() as aantalinschrijvingen from uitvoeringen u
left join inschrijvingen i on (u.cursus = i.cursus and u.begindatum = i.begindatum)
where extract(year from i.BEGINDATUM) = 1999
group by u.cursus, u.begindatum
having count() >= 3;

-- opgave 2.7
select * from medewerkers m 
where 1 < (select count(i.CURSUS) 
                from INSCHRIJVINGEN i
                where m.MNR = i.CURSIST
                and i.CURSUS = 'S02'
                group by i.CURSUS
            );

-- opgave 3
select cursus, count(cursus) from uitvoeringen
group by cursus;

-- opgave 4.1
select floor(MONTHS_BETWEEN(MAX(GBDATUM), MIN(GBDATUM)) / 12) as jaaren from medewerkers;

-- opgave 4.2
select to_date(avg(to_number(to_char(GBDATUM, 'J'))), 'J') as gem from medewerkers;

-- opgave 5
select count(m.mnr) as aantaL_medewerkers,
    avg(coalesce(m.comm, 0)) as avg_comm,
    AVG(case when m.functie = 'VERKOPER' then coalesce(m.comm, 0) else null end) as avg_per_verkoper_comm
    from MEDEWERKERS m;
