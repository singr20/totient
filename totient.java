import java.util.*;

public class totient
{
    public totient()
    {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        
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
            }
        }
        
        System.out.println(rPrimes.size());
    }
}
