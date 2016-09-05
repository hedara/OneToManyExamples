package com.samples.onetomany.model;

import javax.persistence.*;

/**
 * Created by edara on 9/5/16.
 */
@Entity
@Table(name = "stockrecord")
public class StockDailyRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int record_id;
    @Column(name = "openprice")
    private double openprice;
    @Column(name = "closeprice")
    private double closeprice;

    @ManyToOne
    @JoinColumn(name = "stock_symbol")
    private Stock stock;

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public double getOpenprice() {
        return openprice;
    }

    public void setOpenprice(double openprice) {
        this.openprice = openprice;
    }

    public double getCloseprice() {
        return closeprice;
    }

    public void setCloseprice(double closeprice) {
        this.closeprice = closeprice;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof StockDailyRecord){
            if(((StockDailyRecord) obj).getRecord_id() == this.record_id){
                return true;
            }
        }
        return false;
    }
}
