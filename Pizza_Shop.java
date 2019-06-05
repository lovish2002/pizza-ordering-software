import java.util.*;
public class Pizza_Shop
{
    Scanner sc=new Scanner(System.in);
    Date dt=new Date();

    //Master File
    static int p_id[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    static String p_cat[] = {"VEG PIZZA","VEG PIZZA","VEG PIZZA","VEG PIZZA","VEG PIZZA","NON-VEG PIZZA","NON-VEG PIZZA","NON-VEG PIZZA","NON-VEG PIZZA","NON-VEG PIZZA","SIDES        ","SIDES        ","SIDES        ","BEVERAGES    ","BEVERAGES    ","","","","",""};//Spacing out has been done to ensure indentation of the menu during compilation
    static String p_names[]={"Veg Margherita","Veg Exotica","Veg Supreme","Veg Paneer","Veg Deluxe","Chicken Pizza","Chicken Fiesta","Chicken Sausage","Pepper Chicken","Chicken Tikka ","Garlic Bread ","Cheese Dip ","Pasta     ","Cold Drink","Mojito    ","","","","",""};
    static int p_qty[]={25,25,25,25,25,30,30,30,30,30,50,50,30,75,75,0,0,0,0,0};
    static int p_cost[]={350,425,480,550,615,400,460,575,610,650,80,20,150,50,180,0,0,0,0,0};
    static char p_remove[] = {'n','n','n','n','n','n','n','n','n','n','n','n','n','n','n',0,0,0,0,0};
    static int pid = 16;
    static int pindex = 15;
    static int n=15;//n=number of products

    // Transaction File

    static String c_p_cat[] = {"VEG PIZZA","VEG PIZZA","VEG PIZZA","","","","","","",""};
    static String c_names[]={"Ramesh","Shreyas","Aditya","","","","","","",""};
    static int c_p_id[] = {1,3,5,0,0,0,0,0,0,0};
    static String c_p_names[] = {"Veg Margherita","Veg Supreme","Veg Deluxe","","","","","","",""};
    static int c_qty[] = {2,3,4,0,0,0,0,0,0,0};
    static int c_amt[] = {700,1440,2460,0,0,0,0,0,0,0};
    static double c_gst[] = {70,144,246,0,0,0,0,0,0,0};
    static double c_bill[] ={770,1584,2706,0,0,0,0,0,0,0};

    String c_p_cart[]=new String[10];
    int c_p_qty[]=new int[10];
    int c_p_cost[]=new int[10];

    int k=0;//to store the number of products bought by the current customer 

    static int cid = 3;//customer id of last customer(ie.Aditya)
    static int cindex = 2;//customer index of last customer(ie.Aditya)

    static int out = 0;
    static int again = 0;

    static void main()
    {
        Pizza_Shop ob=new Pizza_Shop();
        

        cid++;//to increase the customer id by 1 for every new customer
        cindex++;//to increase the customer index by 1 for every new customer

        int ch;
        if(ob.c_names[ob.cindex]=="")
        {
            ob.custname();
        }
        do
        {

            ob.out=0;
            System.out.println("\f");
            ob.display_title();
            System.out.println();
            System.out.print("\t\t\tYour Customer ID--> "+ob.cid);
            System.out.println();
            System.out.println("\t\t\t1. Enquiry ");
            System.out.println("\t\t\t2. About Us");
            System.out.println("\t\t\t3. FAQs");
            System.out.println("\t\t\t4. Order");            
            System.out.println("\t\t\t5. Bill Printing");
            System.out.println("\t\t\t6. Administrator");
            System.out.println("\t\t\t7. Exit");
            System.out.println();
            System.out.print("\t\t\tEnter Your Choice --> ");
            ch=ob.sc.nextInt();

            switch(ch)
            {
                case 1 :
                ob.enquiry();
                break;

                case 2:
                ob.about_us();
                break;

                case 3 :
                ob.faq();
                break;

                case 4 :
                ob.order();
                break;

                case 5:
                ob.bill();
                break;

                case 6 :
                ob.admin();
                break;

                case 7 :
                ob.out = 1;
                ob.again = 0;
                break;

                default :
                System.out.println("Invalid choice entered");
            }

            if(ob.out == 0 )
            {
                System.out.println();
                System.out.println("Press 1 to go back to Main Menu");
                ob.again = ob.sc.nextInt();
            }

        }while(ob.again == 1 );
        System.out.println("\n\n\t\t\tThank You Visit Again");

    }

    void display_title()
    {
        System.out.println("\t\t########  #### ######## ######## ######## ##     ##");
        System.out.println("\t\t##     ##  ##       ##       ##  ##        ##   ##");
        System.out.println("\t\t##     ##  ##      ##       ##   ##         ## ##");
        System.out.println("\t\t########   ##     ##       ##    ######      ###");
        System.out.println("\t\t##         ##    ##       ##     ##         ## ##");
        System.out.println("\t\t##         ##   ##       ##      ##        ##   ##");
        System.out.println("\t\t##        #### ######## ######## ######## ##     ##");
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t-The Pizza Expert");
        System.out.println();
        System.out.println("\t\t\t\t Thank You For Choosing Pizzex");
        System.out.println();
        System.out.println("\t\t\t"+dt);
    }

    void custname()
    {
        System.out.println("Please enter your name");
        String cname=sc.nextLine();
        c_names[cindex]=cname;

        System.out.println("\f");
    }

    void enquiry()
    {
        System.out.println("\f");
        System.out.println("Sr. No.\t Category\t\tName\t\t\tCost\tQty.");
        int i;
        System.out.println();
        for(i=0;i<20;i++)
        {
            if(p_remove[i]=='n')
            {
                System.out.println(i+"\t" +p_cat[i]+"\t\t"+p_names[i]+"\t\t"+p_cost[i]+"\t"+p_qty[i]);
            }
        }

    } 

    void order()
    {
        System.out.println("\f");

        System.out.println();
        System.out.println("\t\t\t1. Veg Pizzas");
        System.out.println("\t\t\t2. Non Veg Pizzas");
        System.out.println("\t\t\t3. Sides");
        System.out.println("\t\t\t4. Beverages");
        System.out.println();
        System.out.println("\t\t\t5. Main Menu");
        System.out.println();
        System.out.println("\t\t\tPlease select your choice");
        int choice=sc.nextInt();
        int chc;int i;int qty;

        switch(choice)
        {
            case 1:
            System.out.println("\f");

            for(i=0;i<n;i++)
            {
                if(p_cat[i]=="VEG PIZZA" && p_remove[i]=='n')
                {
                    System.out.println((i+1)+". "+p_names[i]);
                }
            }
            chc=sc.nextInt();
            chc--;
            System.out.println("Enter the Quantity");
            qty=sc.nextInt();

            if(qty <= p_qty[chc])
            {
                c_p_qty[k]=qty;
                p_qty[chc]=p_qty[chc]-qty;
                c_p_cost[k]=p_cost[chc];
                c_p_cart[k]=p_names[chc];
                System.out.println("\n\t\t\tProduct successfully added to cart!");
                k++;
                qty=0;
            }
            else
            {
                System.out.println("Not sufficient quantity");
            }
            break;

            case 2:
            System.out.println("\f");

            for(i=0;i<n;i++)
            {
                if(p_cat[i].trim()=="NON-VEG PIZZA" && p_remove[i]=='n')
                {
                    System.out.println((i+1-5)+". "+p_names[i]);
                }
            }
            chc=sc.nextInt();
            chc=chc+4;
            System.out.println("Enter the Quantity");
            qty=sc.nextInt();

            if(qty <= p_qty[chc])
            {
                c_p_qty[k]=qty;
                p_qty[chc]=p_qty[chc]-qty;
                c_p_cost[k]=p_cost[chc];
                c_p_cart[k]=p_names[chc];
                System.out.println("\n\t\t\tProduct successfully added to cart!");
                k++;
                qty=0;
            }
            else
            {
                System.out.println("Not sufficient quantity");

            }

            break;

            case 3:

            System.out.println("\f");

            for(i=0;i<n;i++)
            {
                if(p_cat[i]=="SIDES        " && p_remove[i]=='n')
                {
                    System.out.println((i+1-10)+". "+p_names[i]);
                }
            }
            chc=sc.nextInt();
            chc=chc+9;
            System.out.println("Enter the Quantity");
            qty=sc.nextInt();

            if(qty <= p_qty[chc])
            {
                c_p_qty[k]=qty;
                p_qty[chc]=p_qty[chc]-qty;
                c_p_cost[k]=p_cost[chc];
                c_p_cart[k]=p_names[chc];
                System.out.println("\n\t\t\tProduct successfully added to cart!");
                k++;
                qty=0;
            }
            else
            {
                System.out.println("Not sufficient quantity");
            }
            break;

            case 4:

            System.out.println("\f");

            for(i=0;i<n;i++)
            {
                if(p_cat[i]=="BEVERAGES    " && p_remove[i]=='n')
                {
                    System.out.println((i+1-13)+". "+p_names[i]);
                }
            }
            chc=sc.nextInt();
            chc=chc+12;
            System.out.println("Enter the Quantity");
            qty=sc.nextInt();

            if(qty <= p_qty[chc])
            {
                c_p_qty[k]=qty;
                p_qty[chc]=p_qty[chc]-qty;
                c_p_cost[k]=p_cost[chc];
                c_p_cart[k]=p_names[chc];
                System.out.println("\n\t\t\tProduct successfully added to cart!");
                k++;
                qty=0;
            }
            else
            {
                System.out.println("Not sufficient quantity");
            }
            break;
            case 5:
            System.out.println("\f");
            out=1;
            again=1;

            break;

            default:
            System.out.println("\f");
            System.out.println("Invalid input");

        }
        if(choice > 0 && choice<5)
        {
            System.out.println("\t\t\tDo you want to continue ordering?(Y/N)");
            char ch=sc.next().charAt(0);
            if(ch=='y'||ch=='Y')
            {
                System.out.println("\f");
                order();
            }
            else if(ch=='n'||ch=='N')
            {
                bill();
            }
        }
    }

    void about_us()
    {
        System.out.println("\f");
        System.out.println("\t\t\t\t     Pizzex");
        System.out.println("\t\t\t\t     ~~~~~~");
        System.out.println();
        System.out.println("Pizzex is an American restaurant chain and international franchise founded in 1958 by\n Ron and Henry White. The company is known for its Italian-American cuisine menu including pizza and pasta,\n as well as side dishes and desserts. Pizzex has over 15,000 locations worldwide and is a subsidiary of Tasty! Brands, Inc., \none of the world's largest restaurant companies.Pizzex is split into several different \nrestaurant formats: the original family-style dine-in locations; \nstorefront delivery and carry-out locations; and hybrid locations that have carry-out, delivery, and dine-in\n options. Some full-size Pizzex locations have a lunch buffet, with \"all-you-can-eat\" pizza,\n salad, bread sticks, and a pasta bar. Pizzex has other business concepts independent of the store\n type; Pizzex \"Bistro\" locations are \"Red Roofs\" which have an expanded menu and\n slightly more upscale options.An upscale concept was unveiled in 2004, called \"Pizzex Italian Bistro\".\n At 50 U.S. locations, the Bistro is similar to a traditional Pizzex, except the menu features \nnew, Italian-themed dishes such as penne pasta, chicken pomodoro, and toasted sandwiches.\n Instead of black, white, and red, Bistro locations feature a burgundy and tan motif. Pizzex Bistros still \nserve the chain's traditional pizzas and sides. In some cases, Pizzex has replaced a \"Red Roof\" location with\n the new concept. \"Pizzex\" and \"The Hut\" locations are fast food restaurants. They offer a limited menu\n with many products not seen at a traditional Pizzex. These types of stores are often paired \nin a colocated location with a sibling brand such as WingStreet, KFC or Taco Bell,\n and found on college campuses, food courts, theme parks, bowling alleys, and within stores\n such as Target.Vintage \"Red Roof\" locations, designed by architect Richard D. Burke, can be found \nin the United States and Canada; several exist in the UK, Australia, and Mexico. \nIn his book Orange Roofs, Golden Arches, Phillip Langdon wrote that the Pizzex \"Red Roof\" architecture is something of\n a strange object – considered outs    ide the realm of significant architecture, yet swiftly reflecting shifts in\n popular taste and unquestionably making an impact on daily life. These buildings rarely show \nup in architectural journals, yet they have become some of the most numerous and conspicuous \nin the United States today.");
    }

    void faq()
    {
        System.out.println("\f");
        System.out.println("\t\t\t\t    FAQs");
        System.out.println("\t\t\t\t    ~~~~");
        System.out.println("1. What is the Operative Window for Pizzex?");
        System.out.println("->We at Pizzex operate from 11 AM to 11 PM");

        System.out.println();

        System.out.println("2. Can I place an Advance Order?");
        System.out.println("->You can certainly go ahead and chose your preferred time for delivery.");

        System.out.println();

        System.out.println("3. How is my food delivered?");
        System.out.println("->We deliver your food in our high quality thermal food bags to ensure your food arrives hot.");

        System.out.println();

        System.out.println("4. How long will my delivery take?");
        System.out.println("->We aim to complete deliveries in under 30 minutes from the time your order has been successfully placed.");

        System.out.println();

        System.out.println("5. What if something is wrong with my order?");
        System.out.println("->If there is an issue with your order, please contact your store directly.");

        System.out.println();

        System.out.println("6. What if I am not around when the delivery driver arrives?");
        System.out.println("->In that case, please let us know where to leave your order if you’re not home.");

        System.out.println();

        System.out.println("7. Do Pizza Hut charge a delivery fee?");
        System.out.println("->Unlike some other food delivery companies we do not charge a delivery fee!");

        System.out.println();

        System.out.println("8. Which toppings on Pizzex menu are organic?");
        System.out.println("->Mushrooms, green peppers, yellow onions and Roma tomatoes.");

        System.out.println();

        System.out.println("9. Where do your organic toppings come from?");
        System.out.println("->We are sourcing our organic toppings from Certified Organic farms.");

        System.out.println();

        System.out.println("10. Can I receive a discount for my large order?");
        System.out.println("->Yes, we do have discounts available for large orders.");

        System.out.println();

    }

    void bill()
    {
        System.out.println("\f");
        System.out.println("Enter the customer ID");
        int accept=sc.nextInt();

        if(accept < cid)
        {
            System.out.println("\f");
            display_title();

            System.out.println();
            System.out.println("\t\t\tCustomer Name: "+c_names[accept-1]);
            System.out.println("\t\t\tCustomer Id: "+accept);
            System.out.println();
            System.out.println("\tItem:\t\t\tQuantity:\tCost:\tTotal:");
            System.out.println("\t"+c_p_names[accept-1]+"\t\t\t"+c_qty[accept-1]+"\t"+p_cost[c_p_id[cindex]]+"\t"+c_amt[accept-1]);
            System.out.println();
            System.out.println("\t\t\tBill = Rupees "+(double)c_amt[accept-1]);
            System.out.println("\t\t\tGST = Rupees "+(double)c_gst[accept-1]);
            System.out.println();
            System.out.println("\t\t\tTotal = Rupees "+(double)c_bill[accept-1]);
        }
        else if(accept==cid)
        {
            int i;int cost=0;
            for(i=0;i<k;i++)
            {
                cost=cost + (c_p_qty[i]*c_p_cost[i]);
            }
            c_amt[cindex]=cost;
            c_gst[cindex]=(int)(c_amt[cindex]*0.1);
            c_bill[cindex]=c_amt[cindex]+c_gst[cindex];
            System.out.println("\f");
            display_title();

            System.out.println();
            System.out.println("\t\t\tCustomer Name: "+c_names[accept-1]);
            System.out.println("\t\t\tCustomer Id: "+accept);
            System.out.println();
            System.out.println("\tItem:\t\t\tQuantity:\tCost:\tTotal:");
            System.out.println();
            for(i=0;i<k;i++)
            {
                System.out.println("\t"+c_p_cart[i]+"\t\t\t"+c_p_qty[i]+"\t"+c_p_cost[i]+"\t"+(c_p_qty[i]*c_p_cost[i]));
            }
            System.out.println();
            System.out.println();
            System.out.println("\t\t\tBill= Rupees "+(double)c_amt[accept-1]);
            System.out.println("\t\t\tGST= Rupees "+c_gst[accept-1]);
            System.out.println();
            System.out.println("\t\t\tTotal= Rupees "+(c_amt[accept-1]+c_gst[accept-1]));;

            c_p_names[cindex]=c_p_cart[0];
            c_qty[cindex]=c_p_qty[0];

            System.out.println();
            System.out.println("\t\t\tEnter 1 for payment or 0 to go to the main menu");

            int ch=sc.nextInt();
            if(ch==1)
            {
                payment();
            }
            else
            {
                out=1;
                again=1;
            }
        }
    }

    void admin()
    {
        System.out.println("\f");
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Modify product cost");
        int adm=sc.nextInt();
        switch(adm)
        {
            case 1:
            String cat;
            String name;
            int qty;
            int cost;
            int confirm;
            String dustbin = "";

            System.out.println("\f");
            System.out.println();
            System.out.println("\t\t\t1. Add Product Menu");
            System.out.println();
            System.out.println("Your Product ID is --> " + pid);

            dustbin=sc.nextLine();

            System.out.println("Enter Product Cat  --> " );

            cat=sc.nextLine();

            System.out.println("Enter Product Name --> " );
            name = sc.nextLine();

            System.out.println("Enter Product Qty  --> " );
            qty = sc.nextInt();

            System.out.println("Enter Product Cost --> " );
            cost = sc.nextInt();

            System.out.println();
            System.out.print("\nPress 1 to confirm --> ");
            confirm = sc.nextInt();

            if(confirm == 1 )
            {
                p_id[pindex] = pid;
                p_cat[pindex] = cat;
                p_names[pindex] = name;
                p_qty[pindex] = qty;
                p_cost[pindex] = cost;
                p_remove[pindex] = 'n';

                pindex++;
                pid++;

                System.out.println("Product ADDED ........");
                n++;

            }
            else
            {
                System.out.println("Product NOT ADDED");
            }
            break;

            case 2:

            int id;
            boolean flagid = false;
            int i;

            enquiry();

            System.out.println("Enter ID to be removed");
            id = sc.nextInt();

            for(i=0;i<n;i++)
            {
                if(p_id[i] == id)
                {
                    flagid = true;
                    p_remove[i+1] = 'y';
                    System.out.println("Product removed!");
                    n--;
                    break;
                }
            }

            if(flagid == false)
            {
                System.out.println("Invalid id entered");
            }
            break;

            case 3:

            boolean flag_id =false;
            enquiry();

            System.out.println("Enter ID ");

            id = sc.nextInt();
            id++;

            for(i=0;i<n;i++)
            {
                if(p_id[i] == id)
                {
                    flag_id = true;

                    System.out.println("Current Cost   --> " + p_cost[i]);

                    System.out.print("\nEnter New Cost --> ");
                    p_cost[i] = sc.nextInt();

                    break;
                }
            }

            if(flag_id == false)
            {
                System.out.println("Invalid id entered");
            }
            break;
            default:
            System.out.println("Invalid input");

        }
    }

    void payment()
    {
        System.out.println("\f");
        System.out.println("\t\t\t1. Cash On Delivery");
        System.out.println("\t\t\t2. Credit Card");
        System.out.println("\t\t\t3. Debit Card");
        System.out.println("\t\t\t4. Net Banking");

        int chc_p=sc.nextInt();
        String card_number=""; 
        int cvv;
        int k2=0;
        int t=0;
        if(chc_p==1)
        {
            System.out.println("\f");
            System.out.println("Order Accepted! Please pay rupees "+c_bill[cindex]+" in cash");
        }
        else if(chc_p==2 || chc_p==3)
        {
            System.out.println("\f");
            System.out.println("\t\t\tPlease enter your 16 digit card number");

            System.out.println();

            String garbage=sc.nextLine();
            card_number=sc.nextLine();
            int l=card_number.length();
            if(l==19)
            {
                System.out.println("\t\t\tPlease enter the 3 digit CVV");
                cvv=sc.nextInt();
                t=cvv;
                while(t>0)
                {
                    t=t/10;
                    k2++;
                }
                if(k2==3)
                {

                    for(long i=0;i<100000000;i++)
                    {
                        if(i%1000000==0)
                        {
                            System.out.print("\f");
                            k++;
                            System.out.println("\t\t\tPlease enter your 16 digit card number");
                            System.out.println(card_number);
                            System.out.println();

                            System.out.println("\t\t\tPlease enter the 3 digit CVV");
                            System.out.println(cvv);

                            System.out.println();

                            System.out.print("\t\t\tLoading "+k+"%");

                        }

                    }
                    System.out.println("\f");
                    System.out.println("\t\tOrder Accepted! Your order will be delivered within 30 minutes");
                }
            }
            else
            {
                System.out.println("Wrong card number");
            }
        }

        else if(chc_p==4)
        {
            System.out.println("\f");

            System.out.println("\t\t\tPlease select your bank");
            System.out.println();
            System.out.println("\t\t\t1. State Bank of India");
            System.out.println("\t\t\t2. Axis Bank");
            System.out.println("\t\t\t3. HDFC Bank");
            System.out.println("\t\t\t4. ICICI Bank");
            System.out.println();
            int b_choice=sc.nextInt();
            System.out.println("\f");

            if(b_choice<=4)
            { 
                for(int z=0;z<5;z++)
                {
                    System.out.println("\f");
                    System.out.println("\t\t\tRedirecting.");
                    delay();
                    System.out.println("\f");
                    System.out.println("\t\t\tRedirecting..");
                    delay();
                    System.out.println("\f");
                    System.out.println("\t\t\tRedirecting...");
                    delay();

                }
            }
            else
            {
                System.out.println("Invalid input");
                System.out.println();
                payment();
            }
            System.out.println("\f");
            System.out.println("\t\t\tPlease enter your user id");
            String garbage=sc.nextLine();
            String uid=sc.nextLine();

            System.out.println();

            System.out.println("\t\t\tPlease enter your password");
            String pas=sc.nextLine();

            String spas="";            
            for(int i=0;i<pas.length()-2;i++)
            {
                spas=spas+"*";
            }
            System.out.println("\f");
            System.out.println("\t\t\tPlease enter your user id");
            System.out.println(uid);
            System.out.println("\t\t\tPlease enter your password");
            System.out.println(pas.charAt(0)+spas+pas.charAt(pas.length()-1));

            System.out.println();

            System.out.println("\t\tPlease enter 1 to confirm or 0 to cancel");
            int cfm=sc.nextInt();

            if(cfm==1)
            {
                System.out.println("\f");
                System.out.println("\t\t\tOrder accepted! Your order will be delivered in 30 mins,");
            }
            else
            {
                System.out.println("\f");
                System.out.println("\t\t\tOrder Cancelled");
            }
        }

        System.out.println();
        System.out.println("Enter 1 to start as a new customer");
        System.out.println("Enter 2 to exit");
        int chct=sc.nextInt();

        if(chct==1)
        {

            System.out.println("\f");
            main();

        }
        else if(chct==2)
        {
            exit();
        }
    }

    void delay()
    {
        long a;
        int wt=0;
        for(a=0;a<10000000;a++)
        {
            if(a%100000==0)
            {
                wt++;
            }
        }
    }

    void exit()
    {
        {
            System.out.println("\f");
            out=1;
            again=0;
        }
    }
}
