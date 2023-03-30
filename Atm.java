import java.util.ArrayList;
import java.util.Scanner;
class Atm{
 public static void main(String args[]){
  Scanner z=new Scanner(System.in);
  System.out.println("------------------------");
  System.out.println("|   Choose an option   |");
  System.out.println("|----------------------|");
  System.out.println("|      1.Register      |");
  System.out.println("|        2.Exit        |");
  System.out.println("------------------------");
  int p1=Integer.valueOf(z.nextLine());
  if(p1==1){
   System.out.println("Enter User Id");
   int usid=Integer.valueOf(z.nextLine());
   System.out.println("Enter your Pin");
   int uspin=Integer.valueOf(z.nextLine());
   Functionality ob=new Functionality();
   while(true){
    System.out.println("-----------------------");
    System.out.println("|   Choose an option   |");
    System.out.println("|----------------------|");
    System.out.println("| 1.Transaction History|");
    System.out.println("|      2.Withdraw      |");
    System.out.println("|      3.Deposit       |");
    System.out.println("|      4.Transfer      |");
    System.out.println("|        5.Quit        |");
    System.out.println("------------------------");
    int optio=Integer.valueOf(z.nextLine());
    switch(optio){
     case 1: ob.history();break;
     case 2: System.out.print("Enter Amount:");
             int amou=Integer.valueOf(z.nextLine());
             ob.withdraw(amou);break;
     case 3: 
            System.out.print("Enter Amount to deposit:");
            int damou=Integer.valueOf(z.nextLine());
            ob.deposit(damou);break;
     case 4: 
            System.out.print("Enter Account Number:");
            int accnum=Integer.valueOf(z.nextLine());
            System.out.print("Enter Amount:");
            int tam=Integer.valueOf(z.nextLine());
            ob.transfer(accnum,tam);break;
     case 5: leave();
     default : System.out.println("Choose an option");
    }
   }
  }
  else{
   leave();
  }
 }
 public static void leave(){
   System.out.println("------------------------");
   System.out.println("|      Thank You       |");
   System.out.println("------------------------");
   System.exit(1);
  }
}
class Functionality{
 private int amount=1000;
 ArrayList<String> ar=new ArrayList<>();
 public void history(){
  print();
  for(int i=0;i<ar.size();i=i+3){
    if(ar.get(i).equals("Withdraw")){
      System.out.println("|       "+ar.get(i)+"          "+ar.get(i+1)+"          "+ar.get(i+2)+"  |");
    }else if(ar.get(i).equals("Deposit")){
      System.out.println("|       "+ar.get(i)+"           "+ar.get(i+1)+"           "+ar.get(i+2)+"  |");
    }else if(ar.get(i).equals("Transfer")){
      System.out.println("|       "+ar.get(i)+"          "+ar.get(i+1)+"           "+ar.get(i+2)+"  |");
    }
  }
  System.out.println("|----------------------------------------------|");
 }
 public void withdraw(int wamou){
  if(amount<wamou){
   System.out.println("Insufficient Balance");
  }else{
   amount-=wamou;
   System.out.println("Please take your money");
   ar.add("Withdraw");
   ar.add(String.valueOf(wamou));
   ar.add(String.valueOf(wamou));
  }
 }
 public void deposit(int edamou){
  amount+=edamou;
  ar.add("Deposit");
  ar.add(String.valueOf(edamou));
  ar.add(String.valueOf(amount));
  System.out.println("Deposit Successful");
 }
 public void transfer(int num,int tamou){
  if(tamou>amount){
    System.out.println("Low Balance");
  }else{
    amount-=tamou;
    ar.add("Transfer");
    ar.add(String.valueOf(tamou));
    ar.add(String.valueOf(amount));
    System.out.println("Transfer Successful");
  }
 }
 public void print(){
  System.out.println("------------------------------------------------");
  System.out.println("|             Transaction History              |");
  System.out.println("------------------------------------------------");
  System.out.println("|      Operation         Amount           Total|");
  System.out.println("------------------------------------------------");
  System.out.println("|       Deposit           1000           1000  |");
 }
}