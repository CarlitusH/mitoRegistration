package com.mito.matricula.service;

import java.util.List;

public interface ICrudService <T, ID>{
    //crear las opraciones del crud básico
    List<T> listAllData() throws Exception;
    T listDataById(ID id) throws Exception;
    T addNewData(T data) throws Exception;
    T updateData(T data) throws Exception;
    void deleteData(ID id) throws Exception;

}
