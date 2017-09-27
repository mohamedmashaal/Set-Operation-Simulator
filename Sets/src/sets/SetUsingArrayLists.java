/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.ArrayList;

/**
 *
 * @author Mohamed Mashaal
 */
public class SetUsingArrayLists implements Set{
    private final int MAX = 10001 ;
    private ArrayList <ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    private int currentMax ;
    
    public SetUsingArrayLists(){
        currentMax = MAX ;
        initArrayList(currentMax);
    }
    
    public SetUsingArrayLists(int max){
        currentMax = max+1 ;
        initArrayList(currentMax);
    }
    
    private void initArrayList(int max){
        for(int i = 0 ; i < max ; i ++){
            data.add(i,new ArrayList<String>()); 
        }
    } 
    @Override
    public void addElement(int index, String element) {
        if(!data.get(index).contains(element)){
            data.get(index).add(element);
        }
    }

    @Override
    public void removeElement(int index, String element) {
            data.get(index).remove(element);
    }

    @Override
    public String printSet(int index) {
        StringBuilder res = new StringBuilder(data.get(index).toString());
        res.setCharAt(0, '{');
        res.setCharAt(res.length()-1,'}' );
        return res.toString() ;
    }
    
    public String printSet(ArrayList < String > set) {
        StringBuilder res = new StringBuilder(set.toString());
        res.setCharAt(0, '{');
        res.setCharAt(res.length()-1,'}' );
        return res.toString() ;
    }
    
    @Override
    public String printAll() {
        StringBuilder res = new StringBuilder();
        for(ArrayList<String> x : data){
            if(x.isEmpty())
                continue;
            res.append("Set ").append(data.indexOf(x)).append(" : ").append(printSet(x)).append("\n");
        }
        return res.toString();
    }

    @Override
    public String union(int index1, int index2) {
        ArrayList<String> uniRes = new ArrayList<String>(data.get(index1));
        for(String x : data.get(index2)){
            if(!uniRes.contains(x))
                uniRes.add(x);
        }
        return printSet(uniRes);
    }

    @Override
    public String intersect(int index1, int index2) {
        ArrayList<String> intRes = new ArrayList<String>();
        for(String x : data.get(index1)){
            if(data.get(index2).contains(x))
                intRes.add(x);
        }
        return printSet(intRes);
    }

    @Override
    public String complement(int index) {
        ArrayList<String> comRes = new ArrayList<String>(data.get(0));
        for(String x : data.get(index)){
            comRes.remove(x);
        }
        return printSet(comRes);
        
        
    }

    @Override
    public int getMax() {
        return currentMax;
    }

    @Override
    public void setMax(int max) {
        ArrayList< ArrayList <String > > old_data = data ;
        data = new ArrayList< ArrayList <String > >();
        int i = 0 ;
        for(i =0 ; (i <= max && i < old_data.size()) ; i ++){
            data.add(old_data.get(i));
        }
        if(i == (old_data.size())){
            for(int j = old_data.size() ; j <= max  ; j ++){
                data.add(new ArrayList<String>());
        }
        }
        currentMax = max ;
    }

    @Override
    public boolean uniContains(String element) {
        return data.get(0).contains(element) ;
    }
    
}
