package com.mito.matricula.service.impl;

import com.mito.matricula.exceptions.DataNotFoundException;
import com.mito.matricula.repository.IGenericRepo;
import com.mito.matricula.service.ICrudService;

import java.util.List;

public abstract class CrudServiceImpl<T, ID> implements ICrudService<T, ID> {


    public abstract IGenericRepo<T, ID> returnRepo();


    @Override
    public List<T> listAllData() throws Exception {
        return returnRepo().findAll();
    }


    @Override
    public T listDataById(ID id) throws Exception{
        return returnRepo().findById(id).orElseThrow(()->new DataNotFoundException("El registro con ID " + id + ", NO fue encontrado!"));
    }


    @Override
    public T addNewData(T data) throws Exception{
        return returnRepo().save(data);
    }


    @Override
    public T updateData(T data) throws Exception{
        return returnRepo().save(data);
    }

    @Override
    public void deleteData(ID id) throws Exception{
        returnRepo().findById(id).orElseThrow(()->new DataNotFoundException("El registro con ID " + id + ", NO fue encontrado!"));
        returnRepo().deleteById(id);
    }

}
