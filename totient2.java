import java.util.*;

public class totient2
{
    double high = 0;
    Scanner scan = new Scanner(System.in);
    int number = scan.nextInt();
    int associated;
    public totient2(){
        findtotient(number);
        for(int i = 1; i <= number; i++){
            findnum(i);
        }
        System.out.println("Highest n/φ(n) = " + high + " associated with the number " + associated);
    }
    public double findnum(int num)
    {
        ArrayList<Integer> possible = new ArrayList<Integer>();
        
        if(num % 2 == 0){
            
            for(int i = 1; i < num; i += 2){
                possible.add(i);
            }
            
        } else if(num % 2 != 0){
            for(int i = 1; i < num; i ++){
                possible.add(i);
            }
        }

        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(int i = 1; i < num; i++){
            if(num % i == 0)
                factors.add(i);
        }

        ArrayList<Integer> rPrimes = new ArrayList<Integer>();
        rPrimes.add(1);
        for(int i = 1; i < possible.size(); i++){
            int check = possible.get(i);
            boolean isRelative = true;
            for(int b = 1; b < factors.size(); b++){
                if(check % factors.get(b) == 0){
                   isRelative = false;
                }
            }
            if(isRelative){
                rPrimes.add(check);
                //System.out.print(check + " ");
            }
        }
        //System.out.println("");
        double ratio = (double)num/rPrimes.size();
        if(ratio > high){
            high = ratio;
            associated = num;
        }
        //System.out.println(num + ":" + rPrimes + "; φ(" + num + ") = " + rPrimes.size() + "; " + num + "/φ(" + num + ") = " + ratio);
        return ratio;
    }
    public void findtotient(int b){
        ArrayList<Integer> possible = new ArrayList<Integer>();
        
        if(b % 2 == 0){
            
            for(int i = 1; i < b; i += 2){
                possible.add(i);
            }
            
        } else if(b % 2 != 0){
            for(int i = 1; i < b; i ++){
                possible.add(i);
            }
        }

        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(int i = 1; i < b; i++){
            if(b % i == 0)
                factors.add(i);
        }

        ArrayList<Integer> rPrimes = new ArrayList<Integer>();
        rPrimes.add(1);
        for(int i = 1; i < possible.size(); i++){
            int check = possible.get(i);
            boolean isRelative = true;
            for(int x = 1; x < factors.size(); x++){
                if(check % factors.get(x) == 0){
                   isRelative = false;
                }
            }
            if(isRelative){
                rPrimes.add(check);
                //System.out.print(check + " ");
            }
        }
        //System.out.println("");
        System.out.println("φ(" + b + ") = " + rPrimes.size());
    }
}
