package com.mohamedmashaal.setoperations;

/**
 * Created by Mohamed Mashaal on 9/27/2017.
 */

public interface Set {
    public void addElement(int index , String element);
    public void removeElement(int index , String element);
    public String printSet(int index);
    public String printAll();
    public String union(int index1 , int index2);
    public String intersect(int index1 , int index2);
    public String complement (int index);
    public int getMax();
    public void setMax(int max);
    public boolean uniContains(String element);
}