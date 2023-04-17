package operations;

import polynomial.Polynom;

import java.util.Map;

public class Function {

    public static Polynom add (Polynom p1, Polynom p2)
    {
        for(Map.Entry<Integer, Integer> i: p2.getPolynom().entrySet())
        {
            if(p1.getPolynom().containsKey(i.getKey())){
                p1.getPolynom().put(i.getKey(), p1.getPolynom().get(i.getKey())+i.getValue());
                if(p1.getPolynom().get(i.getKey())==0)
                    p1.getPolynom().remove(i.getKey());
            }
            else
                p1.getPolynom().put(i.getKey(), i.getValue());
        }
        return p1;
    }

    public static Polynom subtract(Polynom p1, Polynom p2){
        Integer aux=0;
        for(Map.Entry<Integer,Integer> i:p2.getPolynom().entrySet()){
            if(p1.getPolynom().containsKey(i.getKey())){
                p1.getPolynom().put(i.getKey(), p1.getPolynom().get(i.getKey())-i.getValue());
                if(p1.getPolynom().get(i.getKey())==0)
                    p1.getPolynom().remove(i.getKey());
            }
            else
                p1.getPolynom().put(i.getKey(), (-1)*i.getValue());

        }
    return p1;
    }

    public static Polynom multiplication(Polynom p1, Polynom p2){
        Polynom p=new Polynom("");
        Integer finalKey;
        Integer finalValue;
        Integer key1, key2, value1, value2;

        for(Map.Entry<Integer, Integer> i: p1.getPolynom().entrySet()){
            key1=i.getKey();
            value1=i.getValue();
            for (Map.Entry<Integer, Integer> j: p2.getPolynom().entrySet()){
                key2=j.getKey();
                value2=j.getValue();

                finalKey=key1+key2;
                finalValue=value1*value2;

                if(p.getPolynom().containsKey(finalKey)){
                    p.getPolynom().put(finalKey, p.getPolynom().get(finalKey)+finalValue);
                }
                else
                    p.getPolynom().put(finalKey, finalValue);
            }
        }
        return p;
    }

    public static Polynom derivation(Polynom p1){
        Polynom p=new Polynom("");
        Integer key;
        Integer value;
        for(Map.Entry<Integer, Integer> i: p1.getPolynom().entrySet()){
            key=i.getKey();
            value=i.getValue();
            value=value*key;
            key--;

            if (key>=0)
                p.getPolynom().put(key,value);
        }

        return p;
    }
}
