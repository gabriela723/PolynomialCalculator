package polynomial;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polynom {
    private TreeMap<Integer, Integer> polynom=new TreeMap<Integer, Integer>(Collections.reverseOrder()) ;

    public Polynom(String pol) {
        addMap(pol);
    }
    public Polynom(){

    };

    public TreeMap<Integer, Integer> getPolynom() {
        return polynom;
    }

    public void addMap(String pol){
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(pol);
        Integer e,c ;
        String coeficient=null;
        String exponent=null;
        Integer indexOfE;
        while (matcher.find()) {
            String copy=matcher.group(1);
            Integer indexOfX=copy.indexOf("x");
            if(indexOfX==-1){
                e=0;
                c=Integer.parseInt(copy);
            }
            else{
                indexOfE=copy.indexOf("^");
                if(indexOfE==-1){
                    e=1;
                    if(indexOfX==0)
                        c=1;
                    else {
                        coeficient = copy.substring(0, indexOfX);
                        if (coeficient.equals("+")){
                            c=1;
                        }
                        else {
                            if (coeficient.equals("-"))
                                c = -1;
                            else
                                c = Integer.parseInt(coeficient);
                        }
                    }
                }
                else{
                    coeficient=copy.substring(0, indexOfX);

                    if (coeficient.equals("+")){
                        c=1;
                    }
                    else {
                        if (coeficient.equals("-"))
                            c = -1;
                        else {
                            if(coeficient.length()==0)
                                c=1;
                           else c = Integer.parseInt(coeficient);
                        }
                    }
                    exponent=copy.substring(indexOfE+1,copy.length());
                    e=Integer.parseInt(exponent);
                }
            }
                this.polynom.put(e,c);
        }
    }

    public String convertPolynom(Polynom p){
        String convP=new String();
        int k=0;
        for(Map.Entry<Integer, Integer> i: p.polynom.entrySet()){
            int coef=i.getValue();
            int exponent=i.getKey();
            if(coef==1)
                if(exponent!=0){
                    if(exponent>=0)
                        convP=convP.concat("+");
                    else
                        convP=convP.concat("-");
                    convP=convP.concat("x");
                }
                else
                    convP=convP.concat("+1");
            else if(coef==-1)
                    if(exponent!=0)
                        convP=convP.concat("-x");
                    else
                        convP=convP.concat("-1");
            else{
                if(coef>0)
                    convP=convP.concat("+");
                convP=convP.concat(String.valueOf(coef)) ;
                if(exponent!=0)
                     convP=convP.concat("x");
            }
            if(exponent!=0){
                if(exponent!=1 && exponent!=-1 && exponent!=0){
                    convP=convP.concat("^");

                    convP=convP.concat(String.valueOf(exponent));
                }
            }
        }
        if(convP.indexOf("+")==0)
            convP=convP.substring(1,convP.length());
        return convP;
    }
}
