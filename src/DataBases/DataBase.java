package DataBases;

import Models.Restaurant;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class DataBase<T> {
    public abstract void create(T restaurant);
    public abstract ArrayList<T> loadAll();
    public abstract T load(File file);
    public abstract void delete(int id);
    public abstract T get(int id);
}

