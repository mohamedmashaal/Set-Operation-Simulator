/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

/**
 *
 * @author Mohamed Mashaal
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
}
