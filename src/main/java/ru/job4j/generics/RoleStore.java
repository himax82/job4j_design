package ru.job4j.generics;

public class RoleStore<T extends Base> implements Store<T> {

    private final Store<T> store = new UserStore<>();

    @Override
    public void add(T model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return store.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public T findById(String id) {
        return store.findById(id);
    }
}
