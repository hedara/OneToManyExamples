package com.samples.onetomany;

import com.samples.onetomany.model.Stock;
import com.samples.onetomany.model.StockDailyRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by edara on 9/5/16.
 */
@Component
public class ServiceEx1 {
    @Autowired
    SessionFactory sessionFactory;

    public void run() {
        System.out.println("************************************ Method-1");
        addStockAndRecord();
        System.out.println("************************************ Method-2");
        //removeStockRecords();
        System.out.println("************************************ Method-3");
        addStockRecord();
        System.out.println("************************************ Method-4");
        deleteStock();
    }

    public void addStockAndRecord() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Stock stock = getSampleStock();
            StockDailyRecord dailyRecord = getSampleStockRecord(11,12);
            stock.getDailyRecords().add(dailyRecord);
            dailyRecord.setStock(stock);
            session.save(stock);

            transaction.commit();
        }catch(Exception ex) {
            System.out.println(ex);
        }finally {
            session.close();
            if(transaction.isActive())
                transaction.commit();
        }
    }

    public void removeStockRecords() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Stock stock = session.get(Stock.class,"abc");
            stock.getDailyRecords().clear();
            session.save(stock);
            transaction.commit();
        }catch(Exception ex) {
            System.out.println(ex);
        }finally {
            session.close();
            if(transaction.isActive())
                transaction.commit();
        }
    }
    public void addStockRecord() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Stock stock = session.get(Stock.class,"abc");
            stock.addRecord(getSampleStockRecord(21,22));
            session.saveOrUpdate(stock);
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            session.close();
            if (transaction.isActive())
                transaction.commit();
        }
    }

    public void deleteStock() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Stock stock = session.get(Stock.class,"abc");
            session.remove(stock);
            transaction.commit();
        }catch(Exception ex) {
            System.out.println(ex);
        }finally {
            session.close();
            if (transaction.isActive())
                transaction.commit();
        }
    }

    public Stock getSampleStock() {
        Stock stock = new Stock();
        stock.setStock_symbol("abc");
        stock.setCompany_name("ABC corp");
        return stock;
    }
    public StockDailyRecord getSampleStockRecord(int min, int max) {
        StockDailyRecord record = new StockDailyRecord();
        record.setOpenprice(min);
        record.setCloseprice(max);
        return record;
    }

}
