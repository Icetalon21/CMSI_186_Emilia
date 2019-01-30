//import com.ian.CalendarStuff;

public class CountTheDays{
public static void main(String[] args) {
    long month1 = 0;
    long day1   = 0;
    long year1  = 0;
    long month2 = 0;
    long day2   = 0;
    long year2  = 0;
    try {
    month1 = Long.parseLong(args[0]);
    day1   = Long.parseLong(args[1]);
    year1  = Long.parseLong(args[2]);
    month2 = Long.parseLong(args[3]);
    day2   = Long.parseLong(args[4]);
    year2  = Long.parseLong(args[5]);
    }
    catch(NumberFormatException nfe){System.out.println("Bad input");}

if(!CalendarStuff.isValidDate(month1, day1, year1)){
    System.out.println("Bad date");
}

if(!CalendarStuff.isValidDate(month2, day2, year2)){
    System.out.println("Bad date");
}

/*public static boolean isValidArg ( long month1, long day1, long year1, long month2, long day2, long year2 ){
    if ((month1 >= 1 && month1 <= 12 && day1 >= 1 && day1 <= daysInMonth(month1, year1)) && (month2 >= 1 && month2 <= 12 && day2 >= 1 && day2 <= daysInMonth(month2, year2))){
        return true;
    }
    return false;
} */

long total = CalendarStuff.daysBetween(month1, day1, year1, month2, day2, year2);
System.out.println(total);

//int howManyDays= daysBetween.total();
//CountTheDays daysBetween = new daysBetween();
//CountTheDays countTheDays = new CountTheDays();
//System.out.println("There are" + howManyDays "days")
//CalendarStuff.daysBetween();
}
}
