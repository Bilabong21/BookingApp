import java.util.Scanner;
import java.text.DecimalFormat;
public class BookingApp
{
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String sName = null;
        double Balance = 0 , prices = 0;

        //System.out.println("sName");
        boolean DestValid;
        do {

            System.out.println("Enter the EL, CPT and DBN : ");
            sName = kb.nextLine();
            sName = sName.toUpperCase();

            DestValid = validateDestination(sName);

        } while (!DestValid);

        System.out.println("Enter the flit type (R/r or S/s) ");
        char cType = kb.nextLine().charAt(0);
        cType = Character.toUpperCase(cType);

        double price = determinePrice(sName,cType);

        System.out.println("Enter the miles ");
        int miles = kb.nextInt();

        double points = convertPoint(miles);

        if(miles >= price)
          {
               Balance = miles - price;
              prices = 0;

          }else
               {
                   System.out.println("You can not use your voyage");
                   Balance = miles;
                   prices=price;
               }
        double rands = 0 ;
        displayBooking(sName,miles,price,Balance,rands);
    }
    public static boolean validateDestination(String p_sName)
     {
         boolean ans = false;

         if(p_sName.equals("EL")  || p_sName.equals("CPT")|| p_sName.equals("DBN") )
          {
              ans = true;
          }
         return ans;
     }
     public static double determinePrice(String p_sName , char p_cType)
      {
          double price = 0.00;


          if(p_sName.equals("EL"))
            {

                price = 1200;

            }else if(p_sName.equals("CPT"))
                   {

                       price = 2500;


                   } else if (p_sName.equals("DBN"))
                           {

                               price = 1800;

                           }

          if(p_cType == 'R')
             {
                 price *= 2;

             }

          return price;
      }
      public static double convertPoint(int p_miles)
      {
            double rands = (p_miles/2);

            return rands;
      }
      public static void displayBooking(String p_sName,double p_miles,double p_price,double p_Balance,double p_rands)
      {
         DecimalFormat df = new DecimalFormat("###.00");

          System.out.println("Dastination"+"\t\t"+"Voyage miles"+"\t\t"+"Price"+"\t\t"+"Balance"+"\t\t"+"Balance Points in Rands");

          System.out.println("p_sName"+"\t\tR"+"p_miles"+"\t\tR"+"p_price"+"\t\tR"+"p_Balance"+"\t\tR"+"p_rands");
      }

}
