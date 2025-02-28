package id.ac.ui.cs.advprog.eshop.repository;

import java.util.Iterator;

public interface RepositoryImplRead<T> {
    public T findById(String id);

    public Iterator<T> findAll();
}
