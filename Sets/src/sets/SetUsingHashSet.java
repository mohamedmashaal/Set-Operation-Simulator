/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Mohamed Mashaal
 */
public class SetUsingHashSet implements Set{
    private final int MAX = 10001 ;
    private ArrayList< HashSet <String > > data = new ArrayList< HashSet <String > >(); 
    private int currentMax ;
    public SetUsingHashSet(){
        currentMax = MAX ;
        initArrayList(currentMax);
    }
    
    public SetUsingHashSet(int max){
        currentMax = max+1 ;
        initArrayList(currentMax);
    }
    
    private void initArrayList(int max){
        for(int i = 0 ; i < max ; i ++){
            data.add(i,new HashSet<String>()); 
        }
    } 
    
    public void addElement(int index , String element){
        HashSet<String> target = data.get(index);
        target.add(element);
    }
    
    public void removeElement(int index , String element){
        HashSet<String> target = data.get(index);
        target.remove(element);
    }
    
    public String printSet(int index){
       HashSet<String> target = data.get(index);
       String rep = target.toString();
       StringBuilder out = new StringBuilder(rep);
       char st = '{'; char fn = '}' ;
       out.setCharAt(0, st);
       out.setCharAt(out.length()-1, fn);
       return out.toString();
    }
    public String printSet(HashSet<String> target){
       String rep = target.toString();
       StringBuilder out = new StringBuilder(rep);
       char st = '{'; char fn = '}' ;
       out.setCharAt(0, st);
       out.setCharAt(out.length()-1, fn);
       return out.toString();
    }
    
    public String printAll(){
        StringBuilder out = new StringBuilder();
        for(HashSet<String> x : data){
            if(x.isEmpty())
                continue;
            out.append("Set " + data.indexOf(x)+" : " +printSet(x)+"\n");
        }
        return out.toString();
    }
    
    public String union(int index1 , int index2){
        HashSet<String> set1 = data.get(index1);
        HashSet<String> set2 = data.get(index2);
        HashSet<String> unResult = new HashSet<String>();
        
        unResult.addAll(set1);
        unResult.addAll(set2);
        String res = printSet(unResult);
        return res ;
    }
    
    public String intersect(int index1 , int index2){
        HashSet<String> set1 = data.get(index1);
        HashSet<String> set2 = data.get(index2);
        
        HashSet<String> toBeDeleted = new HashSet<String>();
        HashSet<String> interResult = new HashSet<String>();
        
        toBeDeleted.addAll(set1);
        interResult.addAll(set1);
        
        toBeDeleted.removeAll(set2);
        interResult.removeAll(toBeDeleted);
        String res = printSet(interResult);
        return res ;
    }
    
    public String complement (int index){
        HashSet<String> compResult = new HashSet<String>();
        HashSet<String> toBeRemoved = data.get(index);
        
        compResult.addAll(data.get(0));
        compResult.removeAll(toBeRemoved);
        String res = printSet(compResult);
        return res ;
    }
    
    public int getMax(){
        return currentMax;
    }
    
    public void setMax(int max){
        ArrayList< HashSet <String > > old_data = data ;
        data = new ArrayList< HashSet <String > >();
        int i = 0 ;
        for(i =0 ; (i <= max && i < old_data.size()) ; i ++){
            data.add(old_data.get(i));
        }
        if(i == (old_data.size())){
            for(int j = old_data.size() ; j <= max  ; j ++){
                data.add(new HashSet<String>());
        }
        }
        currentMax = max ;
    }
    
        @Override
    public boolean uniContains(String element) {
        return data.get(0).contains(element) ;
    }
    
}
