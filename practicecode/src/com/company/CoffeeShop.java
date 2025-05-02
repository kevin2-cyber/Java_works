package com.company;

import java.util.Locale;
import java.util.Scanner;

public class CoffeeShop{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);

//allows user to input the name of one of te item needed
        System.out.println("Please enter the name of item you want");
        String itemName=scanner1.nextLine();

        //Items in the my shop
        String d="egg";
        String e="bread";
        String f="tea";
        String g="storm";
        String h="malt";

        //Allow the user to make some order if what the he or she needs is available
        if (itemName.toLowerCase(Locale.ROOT).equals(d)||itemName.equals(e)||
                itemName.equals(f)||itemName.equals(g)||itemName.equals(h)) {
            String Name = "Egg";
            String Type = "Food";
            String Price = "GHS200";

            String Name1 = "Bread";
            String Type1 = "Food";
            String Price1 = "GHS300";

            String Name2 = "Tea";
            String Type2 = "Food";
            String Price2 = "GHS300";

            String Name3 = "Storm";
            String Type3 = "Drink";
            String Price3 = "GHS70";

            String Name4 = "Beta malt";
            String Type4 = "Drink";
            String Price4 = "GHS100";

//Table form of the items and it prices
            System.out.println("The list of items in ONEDON's shop");
            System.out.println("Name        Type        Price");
            System.out.println(Name + "         " + Type + "        " + Price);
            System.out.println(Name1 + "       " + Type1 + "        " + Price1);
            System.out.println(Name2 + "         " + Type2 + "        " + Price2);
            System.out.println(Name3 + "       " + Type3 + "       " + Price3);
            System.out.println(Name4 + "   " + Type4 + "       " + Price4);

//allow the user to enter the number of items in each of the items int the orderly form(from top downwards)
            System.out.println("Please enter the number of items you want each from top downwards orderly: ");
            int egg = scanner.nextInt();
            int bread = scanner.nextInt();
            int tea = scanner.nextInt();
            int storm = scanner.nextInt();
            int malt = scanner.nextInt();

            //Calculation for the total price
            int  total=egg*200+bread*300+300*tea+70*storm+100*malt;

            // displays the type of item the user wants to order
            System.out.println("list of food items you want to order;");

            if (egg>0){ System.out.println("Egg(s)");}
            if(bread>0){ System.out.println("Bread"); }
            if(tea>0){ System.out.println("Cup of tea"); }
            System.out.println("list of Dink(s) you want to order;");
            if(storm>0){ System.out.println("Storm energy drink");}
            if(malt>0){ System.out.println("Malt");}

//display the total cost of the items ordered
            System.out.println("Please the total Amount your item cost is GHS"+total+".000");

//receiving the amount from the user.
            System.out.println("Kindly enter your amount: ");
            int amount=scanner.nextInt();
            if(amount==total){
                System.out.println("Please the items are ready, THANK YOU");
            }else if (amount>total){
                System.out.println("Please your items are ready,your balance is GHS"+(amount-total)+", THANK YOU.");
            }

//if the user amount cant buy the items selected
            else {
                System.out.println("Your amount could not reach the required amount,sorry your order failed");
            }

        }
        //if the user item is not available
        else {
            System.out.println("Please this item is currently unavailable");
        }

    }

}
