-- opgave 1.4
select * from medewerkers m
where exists (
    select * from inschrijvingen i
    where m.mnr = i.cursist 
    and i.cursus = 'XML'
)
and exists (
    select * from inschrijvingen i
    where m.mnr = i.cursist 
    and i.cursus = 'JAV'
);

-- opgave 1.7
select mnr from medewerkers m
where m.afd != 20;

-- opgave 1.8
select mnr from medewerkers m
where NOT EXISTS (
    select * from inschrijvingen i
    where m.mnr = i.cursist 
    and i.cursus = 'JAV'
);

-- opgave 1.10
-- wel
select * from medewerkers m
where exists (
    select * from medewerkers m2
    where m2.chef = m.mnr
);

-- niet
select * from medewerkers m
where not exists (
    select * from medewerkers m2
    where m2.chef = m.mnr
);

-- opgave 1.11
select * from uitvoeringen u
where exists (
    select * from cursussen c
    where c.code = u.cursus
    and c.type = 'ALG'
)
and u.begindatum LIKE '%-99';

-- opgave 2.4
select u.cursus, u.begindatum, count(*) as aantal_inschrijvingen from uitvoeringen u
join inschrijvingen i on (u.cursus = i.cursus and i.begindatum = u.begindatum)
group by u.cursus, u.begindatum
order by u.begindatum;

-- opgave 2.9
select m.naam, m.VOORL from medewerkers m
where exists (
    select * from inschrijvingen i
    join uitvoeringen u on (u.begindatum = i.begindatum and i.cursus = u.cursus)
    join cursussen c on (c.code = u.cursus)
    where c.type = 'ALG'
    and i.cursist = m.mnr
    and u.docent = m.chef
);
-- opgave 3.3
select * from medewerkers m
where not exists (
    select * from UITVOERINGEN u
    where u.docent = m.mnr
);
