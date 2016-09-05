package com.samples.onetomany.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by edara on 9/5/16.
 */
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name="symbol")
    private String stock_symbol;
    @Column(name="company")
    private String company_name;
    @OneToMany(mappedBy = "stock",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<StockDailyRecord> dailyRecords = new HashSet<StockDailyRecord>();

    public String getStock_symbol() {
        return stock_symbol;
    }

    public void setStock_symbol(String stock_symbol) {
        this.stock_symbol = stock_symbol;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Set<StockDailyRecord> getDailyRecords() {
        return dailyRecords;
    }

    public void setDailyRecords(Set<StockDailyRecord> dailyRecords) {
        this.dailyRecords = dailyRecords;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Stock){
            if(((Stock) obj).getStock_symbol().equalsIgnoreCase(this.getStock_symbol())){
                return true;
            }
        }
        return false;
    }
    public void addRecord(StockDailyRecord rec){
        this.getDailyRecords().add(rec);
        rec.setStock(this);
    }
}
