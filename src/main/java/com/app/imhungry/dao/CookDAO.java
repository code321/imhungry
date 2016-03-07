package com.app.imhungry.dao;

import java.util.List;

import com.app.imhungry.model.Cook;

public interface CookDAO {
   
    public void add(Cook cook);
    public void update(Cook cook);
    public List<Cook> list();
    public Cook getById(long id);
    public void remove(long id);
     
}
