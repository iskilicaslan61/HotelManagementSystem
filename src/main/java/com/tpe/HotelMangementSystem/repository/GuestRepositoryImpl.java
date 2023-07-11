package com.tpe.HotelMangementSystem.repository;

import com.tpe.HotelMangementSystem.config.HibernateUtils;
import com.tpe.HotelMangementSystem.model.Address;
import com.tpe.HotelMangementSystem.model.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GuestRepositoryImpl implements GuestRepository {
    @Override
    public void saveGuest(Guest guest) {

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            //create a new address object and set property
            Address address = new Address();
            address.setCity(guest.getAddress().getStreet());
            address.setCity(guest.getAddress().getCity());
            address.setCountry(guest.getAddress().getCountry());
            address.setZipCode(guest.getAddress().getZipCode());

            //set address to guest
            guest.setAddress(address);
            transaction.commit();
            HibernateUtils.closeSession(session);
           // session.close();

            session.save(guest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}