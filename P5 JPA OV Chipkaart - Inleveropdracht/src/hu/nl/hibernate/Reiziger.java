package hu.nl.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "REIZIGER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "REIZIGERID")
})
public class Reiziger {

    @Id
    @Column(name = "REIZIGERID", unique = true, nullable = false)
    private int id;

    @Column(name = "VOORLETTERS", length = 10)
    private String voornaam;

    @Column(name = "TUSSENVOEGSEL", length = 10)
    private String tussenvoegsel;

    @Column(name = "ACHTERNAAM")
    private String achternaam;

    @Column(name = "GEBOORTEDATUM")
    private Date gbdatum;

    @OneToMany(targetEntity = OVChipkaart.class, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="reiziger")
    private List<OVChipkaart> ovChipkaarten;

    public Reiziger() {
    }

    public Reiziger(int id, String voornaam, String tussenvoegsel, String achternaam, Date gbdatum) {
        this(id, voornaam, tussenvoegsel, achternaam, gbdatum, null);
    }

    public Reiziger(int id, String voornaam, String tussenvoegsel, String achternaam, Date gbdatum, List<OVChipkaart> ovChipkaarten) {
        this.id = id;
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.gbdatum = gbdatum;
        this.ovChipkaarten = ovChipkaarten;
    }

    public void addOVChipkaart(OVChipkaart ovChipkaart) {
        if (!ovChipkaarten.contains(ovChipkaart))
            ovChipkaarten.add(ovChipkaart);
    }

    public void removeOVChipkaart(OVChipkaart ovChipkaart) {
        ovChipkaarten.remove(ovChipkaart);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getVolledigeNaam() {
        return voornaam + " " + (tussenvoegsel != null ? tussenvoegsel : "") + achternaam;
    }

    public Date getGbdatum() {
        return gbdatum;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public List<OVChipkaart> getOVChipkaarten() {
        return ovChipkaarten;
    }

    public void setOVChipkaarten(List<OVChipkaart> ovChipkaarten) {
        this.ovChipkaarten = ovChipkaarten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reiziger reiziger = (Reiziger) o;

        // Because id is a primairy key this value is always unique, so we only have to check this in equals()
        return id == reiziger.id;

    }

    @Override
    public String toString() {
        return "Reiziger{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                ", tussenvoegsel='" + tussenvoegsel + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", gbdatum=" + gbdatum +
                '}';
    }
}
