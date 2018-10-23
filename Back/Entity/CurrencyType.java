package sut.sa.g15.entity;

import lombok.NonNull;

import javax.persistence.*;

@Entity
public class CurrencyType {
    @Id
    @SequenceGenerator(name = "currency_type_seq",sequenceName = "currency_type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="currency_type_seq")
    @Column(name = "TYPE_ID",unique = true,nullable = false)
    private @NonNull Long typeID;
    private @NonNull String type;

    public CurrencyType() {
    }

    public CurrencyType(String type) {
        this.type = type;
    }

    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
